package com.tnaot.page;

import com.tnaot.core.AppiumBaseExecutor;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Susanna
 * @date 2021/3/22 18:26
 */

@Data
public class WemediaPage extends AppiumBaseExecutor {

    public WemediaPage(AppiumDriver<?> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    /** 申请自媒体按钮 */
    @AndroidFindBy(xpath="//*[@id=\"app\"]/div/div[2]/div[2]/span")
    WebElement applyButton;

    /** 资料：自媒体资料 */
    @AndroidFindBy(xpath="//*[@id=\"app\"]/div/div[2]/div[1]")
    WebElement informationOne;

    /** 资料：真实姓名 */
    @AndroidFindBy(xpath="//*[@id=\"app\"]/div/div[2]/div[2]")
    WebElement informationTwo;

    /** 资料：联系方式 */
    @AndroidFindBy(xpath="//*[@id=\"app\"]/div/div[2]/div[3]")
    WebElement informationThree;

    /** 资料：材料证明 */
    @AndroidFindBy(xpath="//*[@id=\"app\"]/div/div[2]/div[4]")
    WebElement informationFour;

    /** 资料：营业执照 */
    @AndroidFindBy(xpath="//*[@id=\"app\"]/div/div[2]/div[5]")
    WebElement informationFive;

//    /**头像 **///*[@id="app"]/div/div[2]/div[1]
//
//    /** 姓名 **///*[@id="app"]/div/div[2]/div[2]/div/input
//
//    /** 简介**///*[@id="app"]/div/div[2]/div[3]/div/textarea
//
//    /** 提交按钮 **///*[@id="app"]/div/div[2]/div[4]/div/p
//
//    /** 姓名 **/ //*[@id="app"]/div/div[2]/div[1]/div/input
//
//    /** 身份证**/ //*[@id="app"]/div/div[2]/div[2]
//
//    /**身份证号码 **///*[@id="app"]/div/div[2]/div[3]/div/input
//
//    /**身份证正面 **///*[@id="app"]/div/div[2]/div[4]/div/div[2]/div[1]/img
//
//    /**身份证反面 **///*[@id="app"]/div/div[2]/div[4]/div/div[2]/div[2]/img
//
//
//
//    /** 区域**///*[@id="app"]/div/div[2]/div[1]
//    /** 手机号区域选择**///*[@id="app"]/div/div[2]/div[2]/div/img
//    /** 中国**///*[@id="app"]/div/div[4]/button[1]
//    /** 柬埔寨**///*[@id="app"]/div/div[4]/button[2]
//    /** 取消**///*[@id="app"]/div/div[4]/button[3]
//
//    /** 输入手机号码 **///*[@id="app"]/div/div[2]/div[2]/div/input
//    /** 验证码 **///*[@id="app"]/div/div[2]/div[3]/div/input
//    /** **///*[@id="app"]/div/div[2]/div[4]/div/p
//    /** **/
//    /** **/
//    /** **/
//    /** **/
//    /** **/
//    /** **/




}
