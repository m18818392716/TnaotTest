package com.tnaot.demo;

import com.tnaot.core.AndroidDriverWait;
import com.tnaot.core.ExpectedCondition;
import com.tnaot.utils.AppiumUtil;
import com.tnaot.utils.AppiumUtils.SendEmail;
import com.tnaot.utils.SelectDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class demoTest {

    @Test
    public void run(ITestContext context) {

        System.out.println("test starting....");


        AppiumUtil appiumUtil = new AppiumUtil();
        SelectDriver selectDriver = new SelectDriver();
        AppiumDriver appiumDriver = selectDriver.selectDriver(context, appiumUtil);
//        appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Switch[1]")).click();
//        appiumDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[10]")).click();

//        appiumUtil.findElement("Xpath","/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Switch[1]").click();
//        appiumUtil.findElement("Xpath","/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[10]").click();




        //wait for 60s if WebElemnt show up less than 60s , then return , until 60s
//        WebElement goButton = new AndroidDriverWait(appiumDriver, 60)
//                .until(new ExpectedCondition<WebElement>() {
//                    public WebElement apply(AndroidDriver d) {
//                        return d.findElement(By
//                                .id("com.hsbc.personalbanking.MobileGPBUKUAT:id/go"));
//                    }
//
//                });
    }

    @Test
    public void run1() {

        System.out.println("test starting....");
        Assert.assertTrue(1==2);
    }

    @Test
    public void run2() {

        System.out.println("test starting....");
        Assert.assertEquals(1,2);
    }

    @Test
    public void run3() {

        System.out.println("test starting....");
    }


//    @AfterSuite
//    public void senEmail() {
//
//        try {
//            TimeUnit.SECONDS.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        SendEmail.send("D:/software/idea-workspace/test-output/allure-report");
//    }

}
