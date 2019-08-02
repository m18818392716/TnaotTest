package com.tnaot.demo;

import com.tnaot.utils.ExcelUtil;
import com.tnaot.utils.SelectDriver;
import com.tnaot.utils.entity.CaseStep;
import com.tnaot.utils.entity.TestCase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.commons.lang3.StringUtils;
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
            ExcelUtil.getResults().get(testCase.getId()).setResult(true);
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
            MobileElement mobileElement = this.getMobileElement(caseStep.getElementPath());
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
    public Method getGetMethod(Class targetClass, String fieldName) {
        String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        try {
            return targetClass.getMethod(methodName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static final String ACTION_CLICK = "click";
    public static final String ACTION_SEND_KEY = "sendKey";
    public static final String COMPARE_TEXT = "compare";
    public static final String IS_SELECTED = "isSelected";
    public static final String SLIDE_UP = "isSelected";//滑动

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
            default:
                Assert.fail("预期以外的操作：Element[" + mobileElement + "] Action: [" + action + "]");
                break;
        }
    }

    public TestCase getTestCase() {
        return testCase;
    }
}
