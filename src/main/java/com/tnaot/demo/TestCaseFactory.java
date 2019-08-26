package com.tnaot.demo;

import com.tnaot.page.LoginPage;
import com.tnaot.utils.AppiumUtil;
import com.tnaot.utils.ExcelUtil;
import com.tnaot.utils.SelectDriver;
import com.tnaot.utils.entity.TestCase;
import org.testng.ITestContext;
import org.testng.annotations.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestCaseFactory{

    public void initProject(ITestContext context, String env){
        System.out.println("初始化项目开始！");
        AppiumUtil appiumUtil = new AppiumUtil();
        SelectDriver selectDriver = new SelectDriver();
        selectDriver.environment = env;
        selectDriver.selectDriver(context, appiumUtil);
        ExcelUtil.readAllExcel();
        System.out.println("初始化项目结束！");
    }

    // 使用Factory实现动态添加用例
    @Factory
    @Parameters({"excelPath","env"})
    public Object[] createInstances(ITestContext context, @Optional String excelPath, @Optional String env) {
        ExcelUtil.excelPath = excelPath;
        initProject(context, env);
        Map<String, TestCase> testCases = ExcelUtil.getTestCases();
        // 遍历添加Excel用例数据，转化为即将要执行的测试用例
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