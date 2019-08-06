package com.tnaot.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * 滑动公共方法是需要使用AppiumDriver，所以必须继承包含AppiumDriver的AppiumDriverInit 类
 */
public class SlideScreen {
//public class SlideScreen extends AppiumDriverInit {

    /**
     * 向上滑动屏幕
     * @param driver
     */
    public static void slideUp(AppiumDriver<WebElement> driver,int times) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        for (int i = 0; i <= times; i++) {
            new TouchAction(driver).press(PointOption.point(width / 2, height * 3 / 4)).moveTo(PointOption.point(width / 2, height / 10)).release().perform();
        }
    }

    public static void slideUp(AppiumDriver<WebElement> driver) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        //new TouchAction(driver).press(PointOption.point(width / 2, height * 3 / 4)).moveTo(PointOption.point(width / 2, height / 10)).release().perform();

        new TouchAction(driver).longPress(PointOption.point(width / 2, 100))
                .moveTo(PointOption.point(width / 2, height - 100)).release()
                .perform();
    }


    /**
     * 向下滑动屏幕
     * @param driver
     */
    public static void slideDown(AppiumDriver<WebElement> driver) {
        int width = driver.manage().window().getSize().width;//获取屏幕宽度
        int height = driver.manage().window().getSize().height;//获取屏幕高度
        //new TouchAction(driver).press(PointOption.point(width / 2, height / 10)).moveTo(PointOption.point(width / 2, height * 3 / 4)).release().perform();

        new TouchAction(driver)
                .longPress(PointOption.point(width / 2, height - 100))
                .moveTo(PointOption.point(width / 2, 100)).release().perform();
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
        //new TouchAction(driver).press(PointOption.point(width * 3 / 4, height / 2)).moveTo(PointOption.point(width / 10, height / 2)).release().perform();

        new TouchAction(driver)
                .longPress(PointOption.point(width - 100, height / 2))
                .moveTo(PointOption.point(100, height / 2)).release().perform();
    }

    /**
     * 向右滑动屏幕
     * @param driver
     */
    public static void slideRight(AppiumDriver<WebElement> driver) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        //new TouchAction(driver).press(PointOption.point(width / 10, height / 2)).moveTo(PointOption.point(width * 3 / 4 , height / 2)).release().perform();

        new TouchAction(driver).longPress(PointOption.point(100, height / 2))
                .moveTo(PointOption.point(width - 100, height / 2)).release()
                .perform();
    }


    public static void slideToTarget(WebElement webElement) {
        JavascriptExecutor dj=(JavascriptExecutor)SelectDriver.getAppiumDriver();//将Driver实例化为js对象
        dj.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", webElement);//滑动到上面定位到的元素的位置
    }

    //页面不断上滑，滑动到出现 THE END为止
    public static void swipeToEnd(AppiumDriver<WebElement> driver, String endString){
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        boolean isSwipe = true;
//        String endString = "THE END";
        while (isSwipe) {
            slideUp(driver);//向上滑动屏幕
            String temp =driver.getPageSource();
            if(temp.contains(endString))
                isSwipe = false;
        }
    }

//    protected static void swipe(AppiumDriver<WebElement> driver, String id){
//        List<WebElement> jokes = new ArrayList<WebElement>();
//        jokes = driver.findElementsByXPath(id);
//
//        WebElement firstJoke = jokes.get(0);
//        WebElement lastJoke = jokes.get(jokes.size()-2);
//        new TouchAction(driver).press(lastJoke).waitAction(Duration.ofSeconds(1)).moveTo(firstJoke).release().perform();
//        System.out.println("滑动页面");
//    }

    /** 点击具体的坐标点 */
    public static void tapPoint(AppiumDriver<WebElement> driver, String data) {
        String point[] = data.split(",");
        int x = Integer.parseInt(point[0]);
        int y = Integer.parseInt(point[1]);
        new TouchAction(driver).press(PointOption.point(x, y)).release().perform();
    }



}
