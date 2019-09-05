package com.tnaot.demo;

import com.tnaot.core.AndroidDriverWait;
import com.tnaot.utils.*;
import com.tnaot.utils.entity.*;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

@SuppressWarnings("unchecked")
public class RunTestCase implements ITest {

    public static ThreadLocal<TestCase> lastTestCase = new ThreadLocal<>();
    public static Map<String,String> elementContent = new HashMap<>();
    private final static LogUtils logger = new LogUtils(RunTestCase.class);

    private TestCase testCase;

    public RunTestCase(String caseId) {
        this.testCase = ExcelUtil.getTestCases().get(caseId);
    }

    @Override
    public String getTestName() {
        return String.format("%s(%s)", testCase.getId(), testCase.getDescription());
    }

    @Test
    public void run() {
        System.out.println("Run Test Case ---->>>>> [" + testCase + "]");
        // 判断是否resetApp
        if (getLastTestCase() != null){
            String lastCaseResult = ExcelUtil.getResults().get(getLastTestCase().getId()).getResult();
            // 【上一个用例失败】 或 【上一个用例不是依赖的用例并且没有constantID】 的情况就resetApp
            if(!ExcelUtil.RESULT_PASS.equals(lastCaseResult) || !getLastTestCase().getId().equals(testCase.getDependId()) && getLastTestCase().getConstantId() == null){
                logger.info("Reset App!");
                SelectDriver.getAppiumDriver().resetApp();
                resetGlobalExecuteNum();
                runInitAppAction();
            }
        } else {
            runInitAppAction();
        }

        try {
            this.runCase(testCase.getId());
        } catch (NoSuchElementException e){
            Assert.fail("元素找不到：" + e.getMessage().substring(e.getMessage().indexOf(": ") + 1));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Case Fail 【" + testCase.getId() + "】", e);
        } finally {
            setLastTestCase(testCase);
        }
    }

    public void runInitAppAction(){
        this.executeAction("MainPage.mainCloseButton", CLICK_IF_EXIST, null);
    }

    public void runCase(String caseId) {
        TestCase testCase = ExcelUtil.getTestCases().get(caseId);
        // 获取用户进行登录操作
        if(StringUtils.isNotBlank(testCase.getUserId())){
            runLoginByUserId(testCase.getUserId());
        }
        // 如果依赖的用例不为上一个且执行成功的用例，则执行依赖的用例
        if (StringUtils.isNotBlank(testCase.getDependId()) && !lastPassIsDependOrHasConst()) {
            runCase(testCase.getDependId());
        }
        // 获取用例步骤
        List<CaseStep> caseSteps = ExcelUtil.getCaseSteps().get(caseId);
        if (caseSteps == null) {
            Assert.fail("未定义用例步骤！用例ID：" + caseId);
        }
        // 遍历执行步骤
        for (CaseStep caseStep : caseSteps) {
            System.out.println("Run case step: " + caseStep);
            executeAction(caseStep.getElementPath(), caseStep.getAction(), caseStep.getData());
            // 如果Global Step表有对应的操作，则继续执行该操作
            executeGlobalStep(caseStep.getElementPath());
        }

        // 获取用例断言
        List<AssertStep> assertSteps = ExcelUtil.getAssertSteps().get(caseId);
        if (assertSteps != null) {
            // 遍历执行断言步骤
            for(AssertStep assertStep : assertSteps){
                System.out.println("Run assert step: " + assertStep);
                executeAction(assertStep.getElementPath(), assertStep.getAction(), assertStep.getData());
                // 如果Global Step表有对应的操作，则继续执行该操作
                executeGlobalStep(assertStep.getElementPath());
            }
        } else {
//            Assert.fail("未定义用例断言！用例ID：" + caseId);
        }

        // 若有constantID，则运行constant步骤
        if (testCase.getConstantId() != null){
            List<ConstantStep> constantSteps = ExcelUtil.getConstantSteps().get(testCase.getConstantId());
            for (ConstantStep constantStep : constantSteps){
                System.out.println("Run constant step: " + constantStep);
                executeAction(constantStep.getElementPath(), constantStep.getAction(), constantStep.getData());
                // 如果Global Step表有对应的操作，则继续执行该操作
                executeGlobalStep(constantStep.getElementPath());
            }
        }
    }

    // 判断上一个用例是否  为pass、并且[上一个用例为当前用例依赖的用例] 或 [上一个用例有constantId]
    private boolean lastPassIsDependOrHasConst() {
        if(getLastTestCase() != null){
            // 获取上一个用例的结果
            String lastCaseResult = ExcelUtil.getResults().get(getLastTestCase().getId()).getResult();
            if (ExcelUtil.RESULT_PASS.equals(lastCaseResult) && (getLastTestCase().getId().equals(testCase.getDependId()) || getLastTestCase().getConstantId() != null )) {
                return true;
            }
        }
        return false;
    }


    public static final String LOGIN_CASE_ID = "login_001"; // 登录用例ID
    public static final String LOGIN_PHONE_NUMBER_ELEMENT = "LoginPage.phoneText";
    public static final String LOGIN_PASSWORD_ELEMENT = "LoginPage.pwdText";
    public static final String LOGIN_USER_NAME_ELEMENT = "MyPage.userName";
    public static final String LOGIN_AREA_OPTION_ELEMENT = "LoginPage.areaSelect"; // 区域选择步骤的elementPath
    public static final Map<String, String> AREA_ELEMENT_MAP = new HashMap(){{ // 国家与对应元素的路径
        put("中国", "LoginPage.areaSelect");
        put("柬埔寨", "LoginPage.areaSelectJP");
    }};

    private void runLoginByUserId(String userId) {
        List<CaseStep> caseSteps = ExcelUtil.getCaseSteps().get(LOGIN_CASE_ID);
        // 保存原登录step
        List<CaseStep> userCaseSteps = CommonUtil.deepCopy(caseSteps);
        User user = ExcelUtil.getUsers().get(userId);
        System.out.println("Run Login User: " + user);
        for(CaseStep caseStep : caseSteps){
            if(LOGIN_PHONE_NUMBER_ELEMENT.equals(caseStep.getElementPath())){
                caseStep.setData(user.getPhoneNumber());
            }
            if(LOGIN_PASSWORD_ELEMENT.equals(caseStep.getElementPath())){
                caseStep.setData(user.getPassword());
            }
            if(LOGIN_USER_NAME_ELEMENT.equals(caseStep.getElementPath())){
                caseStep.setData(user.getUserName());
            }
            if(LOGIN_AREA_OPTION_ELEMENT.equals(caseStep.getElementPath())){
                caseStep.setElementPath(AREA_ELEMENT_MAP.get(user.getCountry()));
            }
        }
        runCase(LOGIN_CASE_ID);
        // 复原登录用例数据
        ExcelUtil.getCaseSteps().put(LOGIN_CASE_ID, userCaseSteps);
    }

    private void executeGlobalStep(String elementPath){
        List<GlobalStep> globalStepList = ExcelUtil.getGlobalSteps().get(elementPath);
        if(globalStepList != null && globalStepList.size() > 0){
            for (GlobalStep globalStep : globalStepList){
                // 该步骤尚未执行过或者type不为1，则执行
                if(globalStep.getExecuteNum() == 0 || !"1".equals(globalStep.getType())){
                    System.out.println("Run global step: " + globalStep);
                    executeAction(globalStep.getElementPath(), globalStep.getAction(), globalStep.getData());
                    globalStep.setExecuteNum(globalStep.getExecuteNum() + 1);
                }
            }
        }
    }

    // 每次resetApp重置执行次数
    private void resetGlobalExecuteNum() {
        Map<String, List<GlobalStep>> globalStepMap = ExcelUtil.getGlobalSteps();
        for (String key : globalStepMap.keySet()){
            for (GlobalStep globalStep : globalStepMap.get(key)){
                globalStep.setExecuteNum(0);
            }
        }
    }

    public static final String ACTION_CLICK = "click";
    public static final String ACTION_SEND_KEY = "sendkeys";
    public static final String ACTION_CLEAR = "clear";
    public static final String COMPARE_TEXT = "compare";
    public static final String COMPARE_CONTENT_DESC_TEXT = "compareContentDesc";
    public static final String IS_SELECTED = "isSelected";

    public static final String SLIDE_UP = "swipeUp";//向上滑动
    public static final String SLIDE_DOWN = "swipeDown";//向下滑动
    public static final String SLIDE_LEFT = "swipeLeft";//向左滑动
    public static final String SLIDE_RIGHT = "swipeRight";//向右滑动
    public static final String SLIDE_DOWN_TIMES = "swipeDownTimes";//向下滑动若干次数
    public static final String SLIDE_LEFT_TIMES = "swipeLeftTimes";//向左滑动若干次数
    public static final String SLIDE_RIGHT_TIMES = "swipeRightTimes";//向右滑动若干次数

    public static final String SLIDE_TO_TARGET = "swipeToTarget";//滑动到目标元素

    public static final String SLIDE_TO_End = "swipeToEnd";//向上滑动到目标元素
    public static final String SLIDE_DOWN_TO_End = "swipeDownToEnd";//向下滑动到目标元素
    public static final String SLIDE_LEFT_TO_End = "swipeLeftToEnd";//向左滑动到目标元素
    public static final String SLIDE_RIGHT_TO_End = "swipeRightToEnd";//向右滑动到目标元素

    public static final String SLIDE_LEFT_ELEMENT = "swipeLeftElement";//向左滑动控件
    public static final String SLIDE_RIGHT_ELEMENT = "swipeRightElement";//向右滑动控件

    public static final String SLIDE_ELEMENT = "slideElement";//滑动控件-控件内部滑动
    public static final String SLIDE_ELEMENT_TO_TARGET = "slideElementToTarget";//滑动控件到目标元素-控件内部滑动

    public static final String TAP_POINT = "tapPoint";//点击某一个坐标
    public static final String TAP_POINT_MOVE_TO_POINT = "tapPointMoveToPoint";//两个坐标点之间的滑动
    public static final String LONG_PRESS_ELEMENT = "longPressElement";//长按某一个控件
    public static final String LONG_PRESS_POINT = "longPressPoint";//长按某一个坐标点


    public static final String ASSERT_TOAST = "assertToast";//断言toast弹框消息
    public static final String IS_EXIST = "isExist";//元素是否存在
    public static final String ASSET_CONTEXT = "asset";//断言元素内容是否与预期一致

    public static final String CLICK_IF_EXIST = "clickIfExist";// 如果存在则点击
    public static final String SAVE_VALUE = "saveValue";// 保存控件值

    public static final String ASSERT_EQUALS = "assertEquals";// 保存控件值
    public static final String ASSERT_NOT_EQUALS = "assertNotEquals";// 保存控件值


    public static final String WAIT_SECONDS = "waitSeconds";// 等待多少秒
    public static final String BACK_LAST_PAGE = "backLastPage";// 返回上一层页面

    public static final String GET_IMAGE_COUNT = "getImageCount";// 返回上一层页面

    public static int imageCount = 0;





//    关于webview页面的滑动方法
    public static final String WEBVIEW_SCROLL_TO_PRESENCE = "scrolltoPresence";// 滑动到目标元素
    public static final String WEBVIEW_SCROLL_TO_BOTTOM_PAGE = "scrollToBottomfPage";// 滑动到页面底部
    public static final String WEBVIEW_TO_BOTTOM = "toBottom";// 滚动条向下拉到顶
    public static final String WEBVIEW_TO_TOP = "toTop";// 滚动条向上拉到顶
    public static final String WEBVIEW_SCROLL_TO_BOTTOM = "scrolltoBottom";// 控制滚动条向下拉到顶
    public static final String WEBVIEW_SCROLL_TO_TOP = "scrolltoTop";// 控制滚动条向上拉到顶
    public static final String WEBVIEW_SCROLL_TO_VERTICAL_MIDDLE = "verticaltoMiddle";// 控制垂直滚动条拉到中间
    public static final String WEBVIEW_SCROLL_TO_HORIZONTAL_MIDDLE = "horizontaltoMiddle";// 控制水平滚动条左右拉到中间






    // 传入控件路径对控件执行操作
    private void executeAction(String elementPath, String action, String data) {
        WebElement webElement = null;
        if (StringUtils.isNotBlank(elementPath)) {
            webElement = AppiumUtil.getWebElement(elementPath);
        }
        switch (action) {
            case ACTION_CLICK:
                webElement.click();
                break;
            case ACTION_SEND_KEY:
                webElement.clear();
                webElement.sendKeys(data);
                break;
            case ACTION_CLEAR:
                webElement.clear();
                break;
            case COMPARE_TEXT:
                Assert.assertTrue(webElement.getText().contains(data), "Element[" + webElement + "] not exsist!");
                break;
            case COMPARE_CONTENT_DESC_TEXT:
                Assert.assertEquals(webElement.getAttribute("content-desc"), data, "Expected ["+ data +"],Actual ["+ webElement.getAttribute("content-desc")+"]!");
                break;
            case IS_SELECTED:
                Assert.assertTrue(webElement.isSelected());
                break;
            case SLIDE_UP:
                SlideScreen.slideUp(SelectDriver.getAppiumDriver(), Integer.parseInt(data));
                break;
            case SLIDE_DOWN:
                SlideScreen.slideDown(SelectDriver.getAppiumDriver());
                break;
            case SLIDE_LEFT:
                SlideScreen.slideLeft(SelectDriver.getAppiumDriver());
                break;
            case SLIDE_RIGHT:
                SlideScreen.slideRight(SelectDriver.getAppiumDriver());
                break;
            case SLIDE_DOWN_TIMES:
                SlideScreen.slideDown(SelectDriver.getAppiumDriver(), Integer.parseInt(data));
                break;
            case SLIDE_LEFT_TIMES:
                SlideScreen.slideLeft(SelectDriver.getAppiumDriver(), imageCount);
                break;
            case SLIDE_RIGHT_TIMES:
                SlideScreen.slideRight(SelectDriver.getAppiumDriver(), Integer.parseInt(data));
                break;
            case SLIDE_TO_TARGET:
                SlideScreen.slideToTarget(SelectDriver.getAppiumDriver(), webElement);
                break;
            case SLIDE_TO_End:
                String endString = data.split("，")[0];
                String direction = data.split("，")[1];
                SlideScreen.swipeToEnd(SelectDriver.getAppiumDriver(), endString, SlideScreen.Heading.valueOf(direction));
                break;
//            case SLIDE_DOWN_TO_End:
//                SlideScreen.swipeDownToEnd(SelectDriver.getAppiumDriver(), data);
//                break;
//            case SLIDE_LEFT_TO_End:
//                SlideScreen.swipeLeftToEnd(SelectDriver.getAppiumDriver(), data);
//                break;
//            case SLIDE_RIGHT_TO_End:
//                SlideScreen.swipeRightToEnd(SelectDriver.getAppiumDriver(), data);
//                break;
            case SLIDE_LEFT_ELEMENT:
                int h = webElement.getSize().getHeight();
                int w = webElement.getSize().getWidth();
                new TouchAction(SelectDriver.getAppiumDriver()).press(PointOption.point(w, h / 2)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(Math.round(5))) ).moveTo(PointOption.point(0, h / 2)).release().perform();
                break;
            case SLIDE_RIGHT_ELEMENT:
                int h1 = webElement.getSize().getHeight();
                int w1 = webElement.getSize().getWidth();
                new TouchAction(SelectDriver.getAppiumDriver()).press(PointOption.point(0, h1 / 2)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(Math.round(5))) ).moveTo(PointOption.point(w1, h1 / 2)).release().perform();
                break;
            case SLIDE_ELEMENT:
                SlideScreen.slideElement(webElement, SlideScreen.Heading.valueOf(data));
                break;
            case SLIDE_ELEMENT_TO_TARGET:
                String targetText = data.split("，")[0];
                String dir = data.split("，")[1];
                SlideScreen.slideElementToTarget(SelectDriver.getAppiumDriver(), targetText, webElement, SlideScreen.Heading.valueOf(dir));
                break;
            case TAP_POINT:
                SlideScreen.tapPoint(SelectDriver.getAppiumDriver(), data);
                break;
            case ASSERT_TOAST:
                WebElement showClose = new AndroidDriverWait((AndroidDriver) SelectDriver.getAppiumDriver(), 60).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'" + data + "')]")));
                Assert.assertNotNull(showClose);
                break;
            case TAP_POINT_MOVE_TO_POINT:
                SlideScreen.tapPointMoveToPoint(SelectDriver.getAppiumDriver(), data);
                break;
            case LONG_PRESS_ELEMENT:
                SlideScreen.longPressElement(webElement);
                break;
            case LONG_PRESS_POINT:
                SlideScreen.longPressPoint(SelectDriver.getAppiumDriver(), data);
                break;
            case IS_EXIST:
                //判断元素是否存在后续需要自己封装方法
                //webElement.isDisplayed();
                Assert.assertTrue(webElement.isDisplayed(),"Element[" + webElement + "] not exsist!");

//                driver.findElement(By.Xpath("//android.view.View[@content-desc='业务说明']");
//                SelectDriver.getAppiumDriver().findElementByAccessibilityId("content-desc的值");
                break;
            case ASSET_CONTEXT:
                Assert.assertEquals(webElement.getText(), data);
                break;
            case CLICK_IF_EXIST:
                AppiumUtil.clickElementIfExist(webElement);
                break;
            case SAVE_VALUE:
                System.out.println("Element text: "+webElement.getText());
                // 以elementPath为key，控件内容为value进行保存
                elementContent.put(elementPath, webElement.getText());
                break;
            case ASSERT_EQUALS:
                System.out.println("Element text: "+webElement.getText()+" Map data: "+elementContent.get(data));
                Assert.assertEquals(webElement.getText(), elementContent.get(data));
                break;
            case ASSERT_NOT_EQUALS:
                System.out.println("Element text: "+webElement.getText()+" Map data: "+elementContent.get(data));
                Assert.assertNotEquals(webElement.getText(), elementContent.get(data), "Expected Not Equals ["+ elementContent.get(data) +"],But Actual ["+ webElement.getText()+"] Is Equals!");
                break;
            case WAIT_SECONDS:
                AppiumUtil.sleep(Long.valueOf(data)*1000);
                break;
            case BACK_LAST_PAGE:
                SelectDriver.getAppiumDriver().navigate().back();
                break;
            case GET_IMAGE_COUNT:
                imageCount = Integer.valueOf(webElement.getText().substring(0, webElement.getText().indexOf("图")));
                break;
            // 关于webview页面元素的相关滑动方法
            case WEBVIEW_SCROLL_TO_PRESENCE:
                ScrollBarUtil.scrolltoPresence(SelectDriver.getAppiumDriver(), webElement);
                break;
            case WEBVIEW_SCROLL_TO_BOTTOM_PAGE:
                ScrollBarUtil.scrollingToBottomofPage(SelectDriver.getAppiumDriver());
                break;
            case WEBVIEW_TO_BOTTOM:
                ScrollBarUtil.toBottom(SelectDriver.getAppiumDriver());
                break;
            case WEBVIEW_TO_TOP:
                ScrollBarUtil.toTop(SelectDriver.getAppiumDriver());
                break;
            case WEBVIEW_SCROLL_TO_BOTTOM:
                ScrollBarUtil.scrolltoBottom(SelectDriver.getAppiumDriver());
                break;
            case WEBVIEW_SCROLL_TO_TOP:
                ScrollBarUtil.scrolltoTop(SelectDriver.getAppiumDriver());
                break;
            case WEBVIEW_SCROLL_TO_VERTICAL_MIDDLE:
                ScrollBarUtil.verticaltoMiddle(SelectDriver.getAppiumDriver());
                break;
            case WEBVIEW_SCROLL_TO_HORIZONTAL_MIDDLE:
                ScrollBarUtil.horizontaltoMiddle(SelectDriver.getAppiumDriver());
                break;

            default:
                Assert.fail("预期以外的操作：Element[" + webElement + "] Action: [" + action + "]");
                break;
        }
    }

    public TestCase getTestCase() {
        return testCase;
    }

    public TestCase getLastTestCase() {
        return lastTestCase.get();
    }

    public void setLastTestCase(TestCase testCase) {
        lastTestCase.set(testCase);
    }
}
