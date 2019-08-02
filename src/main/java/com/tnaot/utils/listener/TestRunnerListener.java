package com.tnaot.utils.listener;

import com.tnaot.utils.AppiumUtil;
import com.tnaot.utils.AppiumUtils.ScreenScr;
import com.tnaot.utils.SelectDriver;
import org.testng.*;

import org.apache.log4j.Logger;

import java.util.Iterator;

public class TestRunnerListener extends TestListenerAdapter {

    private Logger logger = Logger.getLogger(TestRunnerListener.class);

    private int m_count = 0;
    private String filePath=System.getProperty("user.dir");

//    protected ExtentReports extent;
//    protected ExtentTest test;

    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
        logger.info("【" + tr.getName() + " Success】");

//        TestNGRetry retryAnalyzer = (TestNGRetry) tr.getMethod().getRetryAnalyzer();
//        retryAnalyzer.reSetCount();
//        finish(tr);由于版本问题，报错
    }


    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        //String picName =tr.getStartMillis()+""+tr.getTestName();
        String picName = tr.getTestName();
        ScreenScr.getScreen(SelectDriver.getAppiumDriver(),picName);
        logger.info("【" + tr.getName() + " Failure】");
        Reporter.log("["+tr.getName()+"失败]");
//        takeScreenShot(tr);


//        TestNGRetry retryAnalyzer = (TestNGRetry) tr.getMethod().getRetryAnalyzer();
//        retryAnalyzer.reSetCount();
//        finish(tr);由于版本问题，报错
    }

    @Override
    public void onTestStart(ITestResult tr) {
        super.onTestStart(tr);
        logger.info("【" + tr.getName() + " Start】");
        //    extent=InitDriverCase.getextent();
        //    test= extent.startTest(tr.getName());
    }


    public void takeScreenShot(ITestResult tr){
        AppiumUtil baseTestcase=(AppiumUtil)tr.getInstance();
        baseTestcase.takescreen(tr.getName());

    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        super.onTestSkipped(tr);
        //String picName =tr.getStartMillis()+""+tr.getTestName();
        String picName = tr.getTestName();
        ScreenScr.getScreen(SelectDriver.getAppiumDriver(),picName);
        logger.info("【" + tr.getName() + " Skipped】");
        Reporter.log("["+tr.getName()+"跳过]");
        //takeScreenShot(tr);
        //logger.info("【" + tr.getName() + " Skipped】");




        //    test.log(LogStatus.SKIP, "SKIP");
        //    extent.endTest(test);
    }

    @Override
    public void onFinish(ITestContext testContext) {
        super.onFinish(testContext);
        Iterator<ITestResult> listOfFailedTests=testContext.getFailedTests().getAllResults().iterator();
        while(listOfFailedTests.hasNext()){
            ITestResult failedTest = listOfFailedTests.next();
            ITestNGMethod method = failedTest.getMethod();
            if(testContext.getFailedTests().getResults(method).size()>1){
                listOfFailedTests.remove();
            }else{
                if(testContext.getPassedTests().getResults(method).size()>0){
                    listOfFailedTests.remove();
                }
            }
        }
    }
}
