package com.tnaot.step;

import com.tnaot.page.NewsPage;
import com.tnaot.utils.AppiumUtil;
import com.tnaot.utils.SelectDriver;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class NewsStep {

    @Test
    public void getNewsDetail(ITestContext context) {
        AppiumUtil appiumUtil = new AppiumUtil();
        SelectDriver selectDriver = new SelectDriver();
        AppiumDriver appiumDriver = selectDriver.selectDriver(context, appiumUtil);
        NewsPage newsPage = new NewsPage(appiumDriver);

        //举报文章
//        // 用于生成xpath定位 相当于 "//*[@text='没有找到用户名或密码']"
//        String toast_message = "没有找到用户名或密码";
//        String message ='//*[@text=\'{}\']'.format(toast_message);
//        // 获取toast提示框内容
//        toast_element = WebDriverWait(driver,5).until(lambda x:x.find_element_by_xpath(message))
//        print(toast_element.text)
//        assert toast_element.text == "没有找到用户名或密码"





        //收藏文章



        //复制链接



        //QQ分享



        //发布评论



        //查看评论列表




    }
}
