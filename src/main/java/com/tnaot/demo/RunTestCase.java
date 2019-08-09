package com.tnaot.demo;

import com.sun.deploy.security.WIExplorerSigningCertStore;
import com.tnaot.core.AndroidDriverWait;
import com.tnaot.utils.AppiumUtil;
import com.tnaot.utils.AppiumUtils.SwipeUtils;
import com.tnaot.utils.ExcelUtil;
import com.tnaot.utils.SelectDriver;
import com.tnaot.utils.SlideScreen;
import com.tnaot.utils.entity.CaseStep;
import com.tnaot.utils.entity.TestCase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.List;

public class RunTestCase implements ITest {

    public static final String PAGE_PACKAGE_PATH = "com.tnaot.page";
    public static ThreadLocal<String> lastCaseId = new ThreadLocal<>();

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
        // 当上一个用例是成功的且为当前依赖的用例时，不resetApp
        if (!isLastPassForDepend()) {
            SelectDriver.getAppiumDriver().resetApp();
        }
        try {
            this.runCase(testCase.getId());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Case Fail 【" + testCase.getId() + "】");
        } finally {
            setLastCaseId(testCase.getId());
        }
    }

    public void runCase(String caseId) {
        TestCase testCase = ExcelUtil.getTestCases().get(caseId);
        // 如果依赖的用例不为上一个且执行成功的用例，则执行依赖的用例
        if (StringUtils.isNotBlank(testCase.getDependId()) && !isLastPassForDepend()) {
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
            MobileElement mobileElement = null;
            if (StringUtils.isNotBlank(caseStep.getElementPath())) {
                mobileElement = this.getMobileElement(caseStep.getElementPath());
            }
            this.executeAction(mobileElement, caseStep.getAction(), caseStep.getData());
        }
    }

    // 判断上一个用例是否为pass、并且为当前用例依赖的用例
    private boolean isLastPassForDepend() {
        if(StringUtils.isNotBlank(getLastCaseId())){
            String lastCaseResult = ExcelUtil.getResults().get(getLastCaseId()).getResult();
            // 当上一个执行的用例为当前依赖的用例，并且上一个执行的用例成功时，返回true
            if (getLastCaseId().equals(testCase.getDependId()) && ExcelUtil.RESULT_PASS.equals(lastCaseResult)) {
                return true;
            }
        }
        return false;
    }

    // 根据elementPath获取MobileElement
    public MobileElement getMobileElement(String elementPath) {
        String[] pathArray = elementPath.split("\\.");
        String pageClassName = pathArray[0];
        String pageElement = pathArray[1];
        try {
            Class targetPage = Class.forName(PAGE_PACKAGE_PATH + "." + pageClassName);
            Method getMethod = getGetMethod(targetPage, pageElement);
            Constructor constructor = targetPage.getConstructor(AppiumDriver.class);
            Object pageObject = constructor.newInstance(SelectDriver.appiumDriver.get());
            return (MobileElement) getMethod.invoke(pageObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 获取属性的get方法
    public static Method getGetMethod(Class targetClass, String fieldName) {
        String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        try {
            return targetClass.getMethod(methodName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            Assert.fail();
        }
        return null;
    }

    public static final String ACTION_CLICK = "click";
    public static final String ACTION_SEND_KEY = "sendkeys";
    public static final String COMPARE_TEXT = "compare";
    public static final String IS_SELECTED = "isSelected";

    public static final String SLIDE_UP = "swipeUp";//向上滑动
    public static final String SLIDE_DOWN = "swipeDown";//向下滑动
    public static final String SLIDE_LEFT = "swipeLeft";//向左滑动
    public static final String SLIDE_RIGHT = "swipeRight";//向右滑动
    public static final String SLIDE_TO_TARGET = "swipeToTarget";//滑动到目标元素

    public static final String SLIDE_UP_TO_End = "swipeUpToEnd";//向上滑动到目标元素
    public static final String SLIDE_DOWN_TO_End = "swipeDownToEnd";//向下滑动到目标元素
    public static final String SLIDE_LEFT_TO_End = "swipeLeftToEnd";//向左滑动到目标元素
    public static final String SLIDE_RIGHT_TO_End = "swipeRightToEnd";//向右滑动到目标元素

    public static final String SLIDE_LEFT_ELEMENT = "swipeLeftElement";//向左滑动控件
    public static final String SLIDE_RIGHT_ELEMENT = "swipeRightElement";//向右滑动控件

    public static final String TAP_POINT = "tapPoint";//点击某一个坐标
    public static final String TAP_POINT_MOVE_TO_POINT = "tapPointMoveToPoint";//两个坐标点之间的滑动
    public static final String ASSERT_TOAST = "assertToast";//断言toast弹框消息
    public static final String IS_EXIST = "isExist";//元素是否存在
    public static final String ASSET_CONTEXT = "asset";//断言元素内容是否与预期一致

    // 对控件执行操作
    private void executeAction(MobileElement mobileElement, String action, String data) {
        switch (action) {
            case ACTION_CLICK:
                mobileElement.click();
                break;
            case ACTION_SEND_KEY:
                mobileElement.sendKeys(data);
                break;
            case COMPARE_TEXT:
                Assert.assertEquals(mobileElement.getText(), data);
                break;
            case IS_SELECTED:
                mobileElement.isSelected();
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
            case SLIDE_TO_TARGET:
                SlideScreen.slideToTarget(mobileElement);
                break;
            case SLIDE_UP_TO_End:
                SlideScreen.swipeUpToEnd(SelectDriver.getAppiumDriver(), data);
                break;
            case SLIDE_DOWN_TO_End:
                SlideScreen.swipeDownToEnd(SelectDriver.getAppiumDriver(), data);
                break;
            case SLIDE_LEFT_TO_End:
                SlideScreen.swipeLeftToEnd(SelectDriver.getAppiumDriver(), data);
                break;
            case SLIDE_RIGHT_TO_End:
                SlideScreen.swipeRightToEnd(SelectDriver.getAppiumDriver(), data);
                break;
            case SLIDE_LEFT_ELEMENT:
                int h = mobileElement.getSize().getHeight();
                int w = mobileElement.getSize().getWidth();
                new TouchAction(SelectDriver.getAppiumDriver()).press(PointOption.point(w, h / 2)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(Math.round(5))) ).moveTo(PointOption.point(0, h / 2)).release().perform();
                break;
            case SLIDE_RIGHT_ELEMENT:
                int h1 = mobileElement.getSize().getHeight();
                int w1 = mobileElement.getSize().getWidth();
                new TouchAction(SelectDriver.getAppiumDriver()).press(PointOption.point(0, h1 / 2)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(Math.round(5))) ).moveTo(PointOption.point(w1, h1 / 2)).release().perform();
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
            case IS_EXIST:
                //判断元素是否存在后续需要自己封装方法
                //mobileElement.isDisplayed();
                Assert.assertTrue(mobileElement.isDisplayed(),"Element[" + mobileElement + "] not exsist!");

//                driver.findElement(By.Xpath("//android.view.View[@content-desc='业务说明']");
//                SelectDriver.getAppiumDriver().findElementByAccessibilityId("content-desc的值");
                break;
            case ASSET_CONTEXT:
                Assert.assertEquals(mobileElement.getText(), data);
                break;
            default:
                Assert.fail("预期以外的操作：Element[" + mobileElement + "] Action: [" + action + "]");
                break;
        }
    }

    public TestCase getTestCase() {
        return testCase;
    }

    public String getLastCaseId() {
        return lastCaseId.get();
    }

    public void setLastCaseId(String caseId) {
        lastCaseId.set(caseId);
    }
}
