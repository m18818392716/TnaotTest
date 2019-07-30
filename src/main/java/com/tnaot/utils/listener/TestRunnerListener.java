package com.tnaot.utils.listener;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestRunnerListener extends TestListenerAdapter {

    @Override
    public void onTestSuccess(ITestResult tr) {
        TestNGRetry retryAnalyzer = (TestNGRetry) tr.getMethod().getRetryAnalyzer();
        retryAnalyzer.reSetCount();
//        finish(tr);由于版本问题，报错
    }


    @Override
    public void onTestFailure(ITestResult tr) {
        TestNGRetry retryAnalyzer = (TestNGRetry) tr.getMethod().getRetryAnalyzer();
        retryAnalyzer.reSetCount();
//        finish(tr);由于版本问题，报错
    }
}
