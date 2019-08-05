package com.tnaot.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;

/**
 * 滑动公共方法是需要使用AppiumDriver，所以必须继承包含AppiumDriver的AppiumDriverInit 类
 */
public class SlideScreen {
//public class SlideScreen extends AppiumDriverInit {

    /**
     * 向上滑动屏幕
     * @param driver
     */
    public static void slideUp(AppiumDriver<WebElement> driver) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        new TouchAction(driver).press(PointOption.point(width / 2, height * 3 / 4)).moveTo(PointOption.point(width / 2, height / 10)).release().perform();
    }


    /**
     * 向下滑动屏幕
     * @param driver
     */
    public static void slideDown(AppiumDriver<WebElement> driver) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        new TouchAction(driver).press(PointOption.point(width / 2, height / 10)).moveTo(PointOption.point(width / 2, height * 3 / 4)).release().perform();

    }

    /**
     * 向左滑动屏幕
     * @param driver
     */
    public static void slideLeft(AppiumDriver<WebElement> driver) {
        //获取手机屏幕的宽度
        int width = driver.manage().window().getSize().width;
        // 获取手机屏幕的高度
        int height = driver.manage().window().getSize().height;
        // /*new一个TouchAction对象，调用其按压press()方法，输入坐标点,moveTo移动到下一个坐标点，之后调用release()和perform()方法执行，注意，宽乘以或者除以的数字自己来定义计算的，主要是呈现一个公共的方式，兼容所有的手机*/
        new TouchAction(driver).press(PointOption.point(width * 3 / 4, height / 2)).moveTo(PointOption.point(width / 10, height / 2)).release().perform();
    }

    /**
     * 向右滑动屏幕
     * @param driver
     */
    public static void slideRight(AppiumDriver<WebElement> driver) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        new TouchAction(driver).press(PointOption.point(width / 10, height / 2)).moveTo(PointOption.point(width * 3 / 4 , height / 2)).release().perform();
    }

}
