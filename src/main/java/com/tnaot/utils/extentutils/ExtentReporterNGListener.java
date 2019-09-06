package com.tnaot.utils.extentutils;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.relevantcodes.extentreports.model.ExceptionInfo;
import com.relevantcodes.extentreports.model.Test;
import com.tnaot.utils.ExcelUtil;
import com.tnaot.utils.SqlLiteUtil;
import org.testng.*;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;


public class ExtentReporterNGListener implements IReporter {

    private ExtentReports extent;

    public static String EXTENT_CONFIG = System.getProperty("user.dir")+"\\src\\main\\resources\\extent-config.xml";

//    @Override
//    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory){
//        // true为覆盖已经生成的报告
//        extent = new ExtentReports(outputDirectory + File.separator + "AutomationReport.html", false  // true为覆盖已经生成的报告，false 在已有的报告上面生成，不会覆盖旧的结果
//                , NetworkMode.OFFLINE // 最新运行的用例结果在第一个
//        );
////        extent.x("127.0.0.1", 27017); // 将结果写进MongoDB
////        extent.startReporter(ReporterType.DB, outputDirectory + File.separator + "AutomationReport.html"); //生成本地的DB数据文件(SQLite文件)
//        extent.addSystemInfo("Machine Type","Android");
//        extent.loadConfig(new File(EXTENT_CONFIG));
//        extent.addSystemInfo("tester","ChenQian");
//
//        for (ISuite suite : suites) {
//            Map<String, ISuiteResult> result = suite.getResults();
//
//            for (ISuiteResult r : result.values()) {
//                ITestContext context = r.getTestContext();
//
//                buildTestNodes(context.getPassedTests(), LogStatus.PASS);
//                buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
//                buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
//            }
//        }
//
//        extent.flush();
//        extent.close();
//    }
//
//    private void buildTestNodes(IResultMap tests, LogStatus status) {
//
//
//        ExtentTest test;
//
//        if (tests.size() > 0) {
//            for (ITestResult result : tests.getAllResults()) {
////                test = extent.startTest(result.getMethod().getMethodName());
//                test = extent.startTest(result.getTestName());
//
//                test.setStartedTime(getTime(result.getStartMillis()));
//                test.setEndedTime(getTime(result.getEndMillis()));
//                String[] name = result.getName().split("_");
//                test.assignCategory(name[0]);
//
//                for (String group : result.getMethod().getGroups())
//                    test.assignCategory(group);
//
//                List<String> outputList = Reporter.getOutput(result);
//                System.out.println("outputList: "+outputList);
//
//                if (result.getThrowable() != null) {
//
////                    String fileName=System.getProperty("user.dir")+"\\test-output\\"+result.getTestName()+".png";
////                    test.addScreenCapture(fileName);
//                  //test.log(status, test.addScreenCapture("./img/"+result.getMethod().getMethodName()+".png"));
//
//                  //test.log(status, test.addScreenCapture("../img/"+result.getTestName()+".png"));//直接运行绿色运行按钮生成test-output
//                  //test.log(status, test.addScreenCapture("img/"+result.getTestName()+".png"));//通过maven命令进行运行
//                  test.log(status, test.addScreenCapture("./surefire-reports/img/"+result.getTestName()+".png"));//通过绿色按钮进行运行
//                  test.log(status, result.getThrowable());
//
//                }
//                else {
//                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
//                }
//
//                extent.endTest(test);
//            }
//        }
//    }

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory){
        // true为覆盖已经生成的报告
        extent = new ExtentReports(outputDirectory + File.separator + "AutomationReport.html", true  // true为覆盖已经生成的报告，false 在已有的报告上面生成，不会覆盖旧的结果
                , NetworkMode.OFFLINE // 最新运行的用例结果在第一个
        );
//        extent.x("127.0.0.1", 27017); // 将结果写进MongoDB
//        extent.startReporter(ReporterType.DB, outputDirectory + File.separator + "AutomationReport.html"); //生成本地的DB数据文件(SQLite文件)
        extent.addSystemInfo("Machine Type","Android");
        extent.loadConfig(new File(EXTENT_CONFIG));
        extent.addSystemInfo("tester","ChenQian");

//        for (ISuite suite : suites) {
//            Map<String, ISuiteResult> result = suite.getResults();
//
//            for (ISuiteResult r : result.values()) {
//                ITestContext context = r.getTestContext();
//
//                buildTestNodes(context.getPassedTests(), LogStatus.PASS);
//                buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
//                buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
//            }
//        }
        buildTestNodes(SqlLiteUtil.getAllLastCaseByStatus(ExcelUtil.RESULT_PASS), LogStatus.PASS);
        buildTestNodes(SqlLiteUtil.getAllLastCaseByStatus(ExcelUtil.RESULT_FAIL), LogStatus.FAIL);
        buildTestNodes(SqlLiteUtil.getAllLastCaseByStatus(ExcelUtil.RESULT_SKIP), LogStatus.SKIP);

        extent.flush();
        extent.close();
        SqlLiteUtil.closeConnection();
    }

    private void buildTestNodes(List<Map<String, Object>> testCaseList, LogStatus status) {
        ExtentTest test;
        if (testCaseList.size() > 0) {
            for (Map<String, Object> testCase : testCaseList){
                test = extent.startTest(testCase.get("testName").toString());
                Date startTime = getTime((Long)testCase.get("startTime"));
                Date endTime = getTime((Long)testCase.get("endTime"));
                test.setStartedTime(startTime);
                test.setEndedTime(endTime);
                String[] name = testCase.get("testName").toString().split("_");
                test.assignCategory(name[0]);
                // 打印错误信息
                if(testCase.get("throwableMessage") != null){
                    test.log(status, test.addScreenCapture("./surefire-reports/img/"+testCase.get("testName")+".png"));//通过绿色按钮进行运行
                    // 设置异常信息
                    String throwableMessage = testCase.get("throwableMessage").toString();
                    ExceptionInfo exceptionInfo = new ExceptionInfo();
                    exceptionInfo.setTest((Test) test.getTest());
                    exceptionInfo.setExceptionName(throwableMessage.substring(0, throwableMessage.indexOf(":")));
                    exceptionInfo.setStackTrace(throwableMessage);
                    test.getTest().setException(exceptionInfo);
                    String tag = "pre";
                    String s = exceptionInfo.getStackTrace();
                    if (s.contains("<") || s.contains(">")) {
                        tag = "textarea";
                    }
                    test.log(status, null,"<" + tag + ">" + exceptionInfo.getStackTrace() + "</" + tag + ">");
                } else {
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                }
                extent.endTest(test);
            }
        }
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
}
