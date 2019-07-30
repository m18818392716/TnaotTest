package com.tnaot.demo;

import com.tnaot.utils.AppiumUtil;
import com.tnaot.utils.ExcelUtil;
import com.tnaot.utils.SelectDriver;
import com.tnaot.utils.entity.TestCase;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestCaseFactory {

    public void initProject(ITestContext context){
        System.out.println("初始化项目开始！");
        AppiumUtil appiumUtil = new AppiumUtil();
        SelectDriver selectDriver = new SelectDriver();
        selectDriver.selectDriver(context, appiumUtil);
        ExcelUtil.readCaseExcel();
        ExcelUtil.readStepExcel();
        System.out.println("step信息：");
        for(String key : ExcelUtil.getCaseSteps().keySet()){
            System.out.println(key+" : "+ ExcelUtil.getCaseSteps().get(key));
        }
        System.out.println("初始化项目结束！");
    }

    @Factory
    public Object[] createInstances(ITestContext context) {
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
    public void quitProject(){
        System.out.println("项目完结！！！！");
        ExcelUtil.writeResult();
        SelectDriver.getAppiumDriver().quit();
    }
}


