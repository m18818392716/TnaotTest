package com.tnaot.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
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
     *
     * @param driver
     * @param times 滑动次数
     */
    public static void slideUp(AppiumDriver<WebElement> driver, int times) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        for (int i = 0; i < times; i++) {

            //new TouchAction(driver).press(PointOption.point(width / 2, height * 3 / 4)).moveTo(PointOption.point(width / 2, height * 1 / 4)).release().perform();

            new TouchAction(driver)
                    .press(PointOption.point(width / 2, height - 500))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(Math.round(3))))//采用java-client6.0并且加上这一句才可以滑动
                    .moveTo(PointOption.point(width / 2, 100)).release().perform();
        }
    }

    /**
     * 向下滑动屏幕
     *
     * @param driver
     * @param times 滑动次数
     */
    public static void slideDown(AppiumDriver<WebElement> driver, int times) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        for (int i = 0; i < times; i++) {

            //new TouchAction(driver).press(PointOption.point(width / 2, height * 3 / 4)).moveTo(PointOption.point(width / 2, height / 10)).release().perform();

            new TouchAction(driver).press(PointOption.point(width / 2, 500))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(Math.round(3))))
                    .moveTo(PointOption.point(width / 2, height - 500)).release().perform();
        }
    }

    /**
     * 向左滑动屏幕
     *
     * @param driver
     * @param times 滑动次数
     */
    public static void slideLeft(AppiumDriver<WebElement> driver, int times) {
        //获取手机屏幕的宽度
        int width = driver.manage().window().getSize().width;
        // 获取手机屏幕的高度
        int height = driver.manage().window().getSize().height;
        for (int i = 0; i < times; i++) {
            new TouchAction(driver)
                    .press(PointOption.point(width - 100, height / 2))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(Math.round(3))))
                    .moveTo(PointOption.point(100, height / 2)).release().perform();
        }
    }

    /**
     * 向右滑动屏幕
     *
     * @param driver
     * @param times 滑动次数
     */
    public static void slideRight(AppiumDriver<WebElement> driver, int times) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        for (int i = 0; i < times; i++) {
            new TouchAction(driver).longPress(PointOption.point(100, height / 2))
                    .moveTo(PointOption.point(width - 100, height / 2)).release()
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(Math.round(3))))
                    .perform();
        }
    }

    public static void slideUp(AppiumDriver<WebElement> driver) {
        slideUp(driver, 1);
    }

    public static void slideDown(AppiumDriver<WebElement> driver) {
        slideDown(driver, 1);
    }

    public static void slideLeft(AppiumDriver<WebElement> driver) {
        slideLeft(driver, 1);
    }

    public static void slideRight(AppiumDriver<WebElement> driver) {
        slideRight(driver, 1);
    }


    public static void slideToTarget(AppiumDriver<WebElement> driver, WebElement webElement) {
//        JavascriptExecutor dj = (JavascriptExecutor) SelectDriver.getAppiumDriver();//将Driver实例化为js对象
//        dj.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", webElement);//滑动到上面定位到的元素的位置

        boolean isSwipe = true;
        while (isSwipe) {
            if (AppiumUtil.isVisible(webElement)) {//判断元素是否可见
                isSwipe = false;
            } else {
                slideUp(driver);//向上滑动屏幕
            }
        }

    }

    public enum Heading {
        UP, DOWN, LEFT, RIGHT
    }

    /**
     * 控件内上下滑动、左右滑动
     *
     * @param heading 滑动方向 UP  DOWN
     */
    public static void slideElement(WebElement webElement, Heading heading) {
        // 获取控件开始位置的坐标轴
        Point start = webElement.getLocation();
        int startX = start.x;
        int startY = start.y;

        // 获取控件坐标轴差
        Dimension q = webElement.getSize();
        int x = q.getWidth();
        int y = q.getHeight();
        // 计算出控件结束坐标
        int endX = x + startX;
        int endY = y + startY;

        // 计算中间点坐标
        int centreX = (endX + startX) / 2;
        int centreY = (endY + startY) / 2;

        switch (heading) {
            // 向上滑动
            case UP:
                new TouchAction(SelectDriver.getAppiumDriver()).press(PointOption.point(centreX, centreY + 30))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(Math.round(3))))
                        .moveTo(PointOption.point(centreX, centreY - 30)).release().perform();
                break;
            // 向下滑动
            case DOWN:
                new TouchAction(SelectDriver.getAppiumDriver()).press(PointOption.point(endX, centreY - 30))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(Math.round(3))))
                        .moveTo(PointOption.point(centreX, centreY + 30)).release().perform();
                break;
            //向左滑动
            case LEFT:
                new TouchAction(SelectDriver.getAppiumDriver()).press(PointOption.point(endX-50, centreY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(Math.round(3))))
                        .moveTo(PointOption.point(startX, centreY)).release().perform();
                break;
            // 向右滑动
            case RIGHT:
                new TouchAction(SelectDriver.getAppiumDriver()).press(PointOption.point(startX, centreY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(Math.round(3))))
                        .moveTo(PointOption.point(endX, centreY)).release().perform();
                break;

        }

    }

    //控件内部滑动到目标元素
    public static void slideElementToTarget(AppiumDriver<WebElement> driver, String endString, WebElement webElement, Heading heading) {

        boolean isSwipe = true;
        //String endString = "THE END";
        while (isSwipe) {
            String temp = driver.getPageSource();
            if (temp.contains(endString)) {
                isSwipe = false;
            } else {
                slideElement(webElement, heading);//向上滑动屏幕
            }
        }
    }



    //页面不断上滑，滑动到出现 THE END为止
    public static void swipeToEnd(AppiumDriver<WebElement> driver, String endString, Heading heading) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        boolean isSwipe = true;
        //String endString = "THE END";
        while (isSwipe) {
            String temp = driver.getPageSource();
            if (temp.contains(endString)) {
                isSwipe = false;
            } else {
                switch (heading) {
                    case UP:
                        slideUp(driver);//向上滑动屏幕
                        break;
                    case DOWN:
                        slideDown(driver);
                        break;
                    case LEFT:
                        slideLeft(driver);
                        break;
                    case RIGHT:
                        slideRight(driver);
                        break;
                }
            }
        }
    }

    //页面不断下滑，滑动到出现 THE END为止
    public static void swipeDownToEnd(AppiumDriver<WebElement> driver, String endString) {
//        int width = driver.manage().window().getSize().width;
//        int height = driver.manage().window().getSize().height;
//        boolean isSwipe = true;
//        //String endString = "THE END";
//        while (isSwipe) {
//            slideDown(driver);//向上滑动屏幕
//            String temp =driver.getPageSource();
//            if(temp.contains(endString))
//                isSwipe = false;
//        }
    }

    //页面不断左滑，滑动到出现 THE END为止
    public static void swipeLeftToEnd(AppiumDriver<WebElement> driver, String endString) {
//        int width = driver.manage().window().getSize().width;
//        int height = driver.manage().window().getSize().height;
//        boolean isSwipe = true;
//        //String endString = "THE END";
//        while (isSwipe) {
//            slideDown(driver);//向上滑动屏幕
//            String temp =driver.getPageSource();
//            if(temp.contains(endString))
//                isSwipe = false;
//        }
    }

    //页面不断右滑，滑动到出现 THE END为止
    public static void swipeRightToEnd(AppiumDriver<WebElement> driver, String endString) {
//        int width = driver.manage().window().getSize().width;
//        int height = driver.manage().window().getSize().height;
//        boolean isSwipe = true;
//        //String endString = "THE END";
//        while (isSwipe) {
//            slideDown(driver);//向上滑动屏幕
//            String temp =driver.getPageSource();
//            if(temp.contains(endString))
//                isSwipe = false;
//        }
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


    /**
     * 点击具体的坐标点
     */
    public static void tapPoint(AppiumDriver<WebElement> driver, String data) {
        String point[] = data.split(",");
        int x = Integer.parseInt(point[0]);
        int y = Integer.parseInt(point[1]);
        new TouchAction(driver).press(PointOption.point(x, y)).release().perform();
    }


    /**
     * 点击具体的坐标点  [590,1209][910,1401]    [750,1401][750,1209]
     */
    public static void tapPointMoveToPoint(AppiumDriver<WebElement> driver, String data) {
        String point[] = data.split(",");
        int x = Integer.parseInt(point[0]);
        int y = Integer.parseInt(point[1]);
        int x1 = Integer.parseInt(point[2]);
        int y1 = Integer.parseInt(point[3]);
        new TouchAction(driver).press(PointOption.point(x, y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(Math.round(5)))).moveTo(PointOption.point(x1, y1)).release().perform();
    }

    public static void longPressElement(WebElement webElement) {
        // 获取控件开始位置的坐标轴
        Point start = webElement.getLocation();
        int startX = start.x;
        int startY = start.y;

        // 获取控件坐标轴差
        Dimension q = webElement.getSize();
        int x = q.getWidth();
        int y = q.getHeight();
        // 计算出控件结束坐标
        int endX = x + startX;
        int endY = y + startY;

        // 计算中间点坐标
        int centreX = (endX + startX) / 2;
        int centreY = (endY + startY) / 2;

        new TouchAction(SelectDriver.getAppiumDriver()).longPress(PointOption.point(centreX, centreY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(Math.round(2))))
                .release().perform();

    }

    public static void longPressPoint(AppiumDriver<WebElement> driver, String data) {
        String point[] = data.split(",");
        int x = Integer.parseInt(point[0]);
        int y = Integer.parseInt(point[1]);
        new TouchAction(driver).longPress(PointOption.point(x, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(Math.round(2))))
                .release().perform();
    }

    /**
     * 滑动到目标元素-向左
     */
    public static void swipeToTarget(AppiumDriver<WebElement> driver, String endString) {
        String old = "";
        String temp = driver.getPageSource();//获取当前页面页数
        while (true) {
            if (old == temp) {
                break;
            } else {
                if (driver.getPageSource().contains(endString)) {
                    System.out.println("找到了元素/滑动到了指定元素的当前页面");
                    break;
                } else {
                    new TouchAction(driver).press(PointOption.point(1300, 300)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(Math.round(5)))).moveTo(PointOption.point(0, 300)).release().perform();
                    old = temp;
                    temp = driver.getPageSource();
                }
            }
        }


    }


}
