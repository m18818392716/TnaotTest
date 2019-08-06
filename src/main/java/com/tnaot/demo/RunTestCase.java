package com.tnaot.demo;

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
import io.appium.java_client.android.AndroidDriver;
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
import java.util.List;

public class RunTestCase implements ITest {

    public static final String PAGE_PACKAGE_PATH = "com.tnaot.page";
    public static final int SLEEP_WAIT_TIME = 2 * 1000;

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
        System.out.println("Run Test Case ---->>>>> ["+ testCase+"]");
        try {
            this.runCase(testCase.getId());
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail("Case Fail 【"+testCase.getId()+"】");
        } finally {
            SelectDriver.getAppiumDriver().resetApp();
        }
    }

    public void runCase(String caseId) {
        TestCase testCase = ExcelUtil.getTestCases().get(caseId);
        // 如果有依赖的用例，则先执行依赖的用例
        if (StringUtils.isNotBlank(testCase.getDependId())) {
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
            AppiumUtil.sleep(SLEEP_WAIT_TIME);
            MobileElement mobileElement = null;
            if(StringUtils.isNotBlank(caseStep.getElementPath())){
                mobileElement = this.getMobileElement(caseStep.getElementPath());
            }
            this.executeAction(mobileElement, caseStep.getAction(), caseStep.getData());
        }
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
    public static final String ASSERT_TOAST = "assertToast";//断言toast弹框消息

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
                Assert.assertEquals(mobileElement.getText(),data);
                break;
            case IS_SELECTED:
                mobileElement.isSelected();
                break;
            case SLIDE_UP:
                SlideScreen.slideUp(SelectDriver.getAppiumDriver());
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
            case ASSERT_TOAST:
                WebElement showClose = new AndroidDriverWait((AndroidDriver)SelectDriver.getAppiumDriver(), 60).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'" + data + "')]")));
                Assert.assertNotNull(showClose);
                break;
            default:
                Assert.fail("预期以外的操作：Element[" + mobileElement + "] Action: [" + action + "]");
                break;
        }
    }

    public TestCase getTestCase() {
        return testCase;
    }
}
