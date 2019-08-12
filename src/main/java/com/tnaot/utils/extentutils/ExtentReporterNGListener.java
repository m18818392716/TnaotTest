package com.tnaot.utils.extentutils;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.*;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;
import com.relevantcodes.extentreports.ReporterType;

import javax.imageio.ImageIO;

public class ExtentReporterNGListener implements IReporter {

    private ExtentReports extent;

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory){
        // true为覆盖已经生成的报告
        extent = new ExtentReports(outputDirectory + File.separator + "Extent.html", true  // true为覆盖已经生成的报告，false 在已有的报告上面生成，不会覆盖旧的结果
                , NetworkMode.OFFLINE // 最新运行的用例结果在第一个
        );
        extent.startReporter(ReporterType.DB, outputDirectory + File.separator + "Extent.html"); //生成本地的DB数据文件

        extent.addSystemInfo("Machine Type","Android");
        extent.addSystemInfo("tester","ChenQian");

        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();

            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();

                buildTestNodes(context.getPassedTests(), LogStatus.PASS);
                buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
                buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
            }
        }

        extent.flush();
        extent.close();
    }

    private void buildTestNodes(IResultMap tests, LogStatus status) {


        ExtentTest test;

        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
//                test = extent.startTest(result.getMethod().getMethodName());
                test = extent.startTest(result.getTestName());

                test.setStartedTime(getTime(result.getStartMillis()));
                test.setEndedTime(getTime(result.getEndMillis()));

                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);

                if (result.getThrowable() != null) {

//                    String fileName=System.getProperty("user.dir")+"\\test-output\\"+result.getTestName()+".png";
//                    test.addScreenCapture(fileName);
                  //test.log(status, test.addScreenCapture("./img/"+result.getMethod().getMethodName()+".png"));
                  test.log(status, test.addScreenCapture("../img/"+result.getTestName()+".png"));
                  test.log(status, result.getThrowable());

                }
                else {
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
