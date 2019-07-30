package com.tnaot.demo;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SwipeTest {

    private AndroidDriver driver;

    @Before
    public void setUp() throws Exception
    {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android Devices");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("udid", "0123456789ABCDEF");
        capabilities.setCapability("appPackage", "com.android.settings");
        capabilities.setCapability("appActivity", ".Settings");
        capabilities.setCapability("NoReset", true);
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        System.out.println("启动应用！");
    }


    @After
    public void tearDown()
            throws Exception
    {
        driver.quit();
        System.out.println("退出driver！");
    }

    @Test
    public void test()
    {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement webElement = driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Display\"))");
        //使用scrollIntoView方法实现滚动到指定控件元素
        System.out.println("scroll!");
        webElement.click();
        System.out.println("click!");
    }
}
