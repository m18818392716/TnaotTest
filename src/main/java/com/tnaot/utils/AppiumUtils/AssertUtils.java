package com.tnaot.utils.AppiumUtils;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class AssertUtils {

    public static boolean flag = true;                      //是否有错误
    public static List<Error> errors = new ArrayList<>();    //错误集合

    public static void assertEquals(String actual, String expected) {
        Assert.assertEquals(actual,expected,"Expected ["+ expected +"],Actual ["+ actual+"]!");
    }

    public static void assertNotEquals(String actual, String expected) {
        Assert.assertNotEquals(actual,expected,"Expected Not Equals ["+ expected +"],But Actual ["+ actual+"] Is Equals!");
    }

    public static void assertContains(String actual, String expected) {
        Assert.assertTrue(actual.contains(expected), "Element[" + actual + "] not contains"  + expected + "!");
    }

    public static void assertNotNull(Object actual) {
        Assert.assertNotNull(actual,"Element[" + actual + "] not contains not exsist!");
    }

    /**
     * 验证值是否相等
     * @param actual 第一个值
     * @param expected 要对比的值
     */
    public static void verifyEquals(Object actual, Object expected){
        try{
            Assert.assertEquals(actual, expected);
        }catch(Error e){
            errors.add(e);
            flag = false;
        }
    }

    /**
     * 验证值是否相等
     * @param actual 第一个值
     * @param expected 要对比的值
     * @param message 出错时候的提示消息
     */
    public static void verifyEquals(Object actual, Object expected, String message){
        try{
            Assert.assertEquals(actual, expected, message);
        }catch(Error e){
            errors.add(e);
            flag = false;
        }
    }

    public static void isEquals(String actual,String expected,String message) {
        try {
            Assert.assertEquals(actual,expected,message);
            System.out.println("");
        } catch(NoAlertPresentException exception) {

            Assert.fail(message);

        }

    }


}
