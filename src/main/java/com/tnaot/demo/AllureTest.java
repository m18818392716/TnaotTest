package com.tnaot.demo;


import com.tnaot.utils.AppiumUtils.SendEmail;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Feature("前线突击测试")
public class AllureTest {

    @Test(description = "侯征测试")
    @Story("测试发券")
    @Description("主要测试四种券发送")
    @Step("测试步骤....")
    public void failedTest(){

        Assert.assertEquals(2,2);
    }

    @Test
    public void testApp()
    {
        System.out.println(System.getProperty("name"));
        System.out.println(System.getProperty("buildDirectory"));
        Assert.assertTrue(true);
    }

    @AfterSuite
    public void senEmail() {

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SendEmail.send("D:/software/idea-workspace/test-output/allure-report");
    }


}
