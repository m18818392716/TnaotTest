package com.tnaot.demo;

import com.tnaot.utils.AppiumUtil;
import com.tnaot.utils.ExcelUtil;
import com.tnaot.utils.SelectDriver;
import com.tnaot.utils.entity.TestCase;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestCaseFactory{

    public void initProject(ITestContext context){
        System.out.println("初始化项目开始！");
        AppiumUtil appiumUtil = new AppiumUtil();
        SelectDriver selectDriver = new SelectDriver();
        AppiumDriver appiumDriver = selectDriver.selectDriver(context, appiumUtil);

        ExcelUtil.readCaseExcel();
        ExcelUtil.readStepExcel();
//        System.out.println("step信息：");
//        for(String key : ExcelUtil.getCaseSteps().keySet()){
//            System.out.println(key+" : "+ ExcelUtil.getCaseSteps().get(key));
//        }
        System.out.println("初始化项目结束！");

        AppiumUtil.sleep(5000L);
        try{
            WebElement allowButton = appiumDriver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"));
            if(allowButton.isDisplayed()){
                allowButton.click();
            }
        } catch (NoSuchElementException e){
            System.out.println("不存在该控件");
        }


    }

    // 使用Factory实现动态添加用例
    @Factory
    @Parameters({"excelPath"})
    public Object[] createInstances(ITestContext context, @Optional String excelPath) {
        ExcelUtil.excelPath = excelPath;
        initProject(context);
        Map<String, TestCase> testCases = ExcelUtil.getTestCases();
        // 遍历执行Case
        List<Object> caseList = new ArrayList<>();
        for(String caseId : testCases.keySet()){
            if("YES".equalsIgnoreCase(testCases.get(caseId).getIsRun())){
                caseList.add(new RunTestCase(caseId));
                ExcelUtil.getResults().get(caseId).setIsRun(true);
            } else {
                ExcelUtil.getResults().get(caseId).setIsRun(false);
            }
        }
        Object[] result = new Object[caseList.size()];
        caseList.toArray(result);
        return result;
    }

    @AfterSuite
    public void quitProject(ITestContext context){
        System.out.println("项目完结！！！！");
        System.out.println("PASS用例："+context.getPassedTests());
        System.out.println("FAIL用例："+context.getFailedTests());
        ExcelUtil.writeResult();
        SelectDriver.getAppiumDriver().quit();
    }
}