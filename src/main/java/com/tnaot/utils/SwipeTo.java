package com.tnaot.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

public class SwipeTo {

//    public static void swipeToUp(AppiumDriver<AndroidElement> driver, int during){
//        int width = driver.manage().window().getSize().width;
//        int height = driver.manage().window().getSize().height;
//        driver.swipe(width / 2, height * 3/ 4, width /2 , height /4, during);
//    }
//
//    public static void swipeToUp(AppiumDriver<AndroidElement> driver, int during,int num){
//        int width = driver.manage().window().getSize().width;
//        int height = driver.manage().window().getSize().height;
//        for(int i = 0;i < num;i++){
//            driver.swipe(width / 2, height * 3/ 4, width /2 , height /4, during);
//        }
//    }
//
//    public static void swipeToDown(AppiumDriver<AndroidElement> driver, int during){
//        int width = driver.manage().window().getSize().width;
//        int height = driver.manage().window().getSize().height;
//        System.out.println(width );
//        System.out.println(height);
//        driver.swipe(width / 2, height / 4, width /2 , height * 3 /4, during);
//    }
//
//    public static void swipeToDown(AppiumDriver<AndroidElement> driver, int during,int num){
//        int width = driver.manage().window().getSize().width;
//        int height = driver.manage().window().getSize().height;
//        System.out.println(width );
//        System.out.println(height);
//        for(int i = 0;i < num;i++){
//            driver.swipe(width / 2, height / 4, width /2 , height * 3 /4, during);
//        }
//    }
//
//    public static void swipeToLeft(AppiumDriver<AndroidElement> driver, int during){
//        int width = driver.manage().window().getSize().width;
//        int height = driver.manage().window().getSize().height;
//        driver.swipe(width * 3 / 4 , height / 2, width / 4, height / 2, during);
//    }
//
//    public static void swipeToLeft(AppiumDriver<AndroidElement> driver, int during,int num){
//        int width = driver.manage().window().getSize().width;
//        int height = driver.manage().window().getSize().height;
//        for(int i = 0;i < num;i++){
//            driver.swipe(width * 3 / 4 , height / 2, width / 4, height / 2, during);
//        }
//    }
//
//    public static void swipeToRight(AppiumDriver<AndroidElement> driver, int during){
//        int width = driver.manage().window().getSize().width;
//        int height = driver.manage().window().getSize().height;
//        driver.swipe(width / 4, height / 2, width * 3 / 4, height / 2, during);
//    }
//
//    public static void swipeToRight(AppiumDriver<AndroidElement> driver, int during,int num){
//        int width = driver.manage().window().getSize().width;
//        int height = driver.manage().window().getSize().height;
//        for(int i = 0;i < num;i++){
//            driver.swipe(width / 4, height / 2, width * 3 / 4, height / 2, during);
//        }
//    }
//
//    public enum Heading {
//        UP, DOWN
//    }
//
//    /**
//     * 控件内上下滑动
//     *
//     * @param step    测试步骤
//     * @param by      控件定位方式
//     * @param heading 滑动方向 UP  DOWN
//     */
//    public static void swipeControl(AppiumDriver<AndroidElement> driver,String id,Heading heading,int num) {
//        // 获取控件开始位置的坐标轴
//        Point start = driver.findElement(By.id(id)).getLocation();
//        int startX = start.x;
//        int startY = start.y;
//
//        // 获取控件坐标轴差
//        Dimension q = driver.findElement(By.id(id)).getSize();
//        int x = q.getWidth();
//        int y = q.getHeight();
//        // 计算出控件结束坐标
//        int endX = x + startX;
//        int endY = y + startY;
//
//        // 计算中间点坐标
//        int centreX = (endX + startX) / 2;
//        int centreY = (endY + startY) / 2;
//
//        switch (heading) {
//            // 向上滑动
//            case UP:
//                driver.swipe(centreX, centreY + 30, centreX, centreY - 30, num);
//                break;
//            // 向下滑动
//            case DOWN:
//                driver.swipe(centreX, centreY - 30, centreX, centreY + 30, num);
//                break;
//        }
//        //log.info(step);
//    }
//
//
//    /**
//     * 单个手指，点击屏幕某个控件位置(左上，左下，右上，右下，中间)
//     */
//    public enum Location {
//        UPLEFT, LOWLEFT, UPRIGHT, LOWRIGHT, CENTRE
//    }
//
//    /**
//     * 点击控件某个地方
//     *
//     * @param step
//     * @param by
//     * @param location
//     */
//    public static void clickControl(AppiumDriver<AndroidElement> driver,String id,Location location) throws InterruptedException {
//        //log.info(step);
//        // 获取控件开始位置的坐标轴
//        Point start = driver.findElement(By.id(id)).getLocation();
//        int startX = start.x;
//        int startY = start.y;
//        // 获取控件坐标轴差
//        Dimension q = driver.findElement(By.id(id)).getSize();
//        int x = q.getWidth();
//        int y = q.getHeight();
//        // 计算出控件结束坐标
//        int endX = x + startX;
//        int endY = y + startY;
//
//        switch (location) {
//            // 左上 点击
//            case UPLEFT:
//                driver.tap(1, startX + 10, startY + 10, 100);
//                Thread.sleep(2000);
//                break;
//            // 右上 点击
//            case UPRIGHT:
//                driver.tap(1, endX - 10, startY + 10, 100);
//                Thread.sleep(2000);
//                break;
//            // 左下 点击
//            case LOWLEFT:
//                driver.tap(1, startX + 10, endY - 10, 100);
//                Thread.sleep(2000);
//                break;
//            // 右下 点击
//            case LOWRIGHT:
//                driver.tap(1, endX - 10, endY - 10, 100);
//                Thread.sleep(2000);
//                break;
//            // 中间 点击
//            case CENTRE:
//                driver.tap(1, (endX + startX) / 2, (endY + startY) / 2, 100);
//                Thread.sleep(2000);
//                break;
//        }
//    }
}
