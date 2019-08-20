package com.tnaot.utils.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestNGRetry implements IRetryAnalyzer {

    private int retryCount = 1;//设置当前的重跑次数
    private static final int maxRetryCount = 3;//设置最大重跑次数，定义为常量。

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (retryCount<=maxRetryCount){
            System.out.println("it's the ["+retryCount+"] times retry.And the current case is ["+iTestResult.getTestName()+"]");//输出当前的重跑次数以及当前的正在重跑的用例名称。

            retryCount++;//重跑之后，次数+1
            return true;//当return true之后，代表继续重跑
        }
        return false;//return false之后，代表停止重跑
    }

    public void reSetCount(){
        retryCount=1;
    }
}
