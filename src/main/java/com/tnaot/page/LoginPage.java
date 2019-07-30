package com.tnaot.page;

import com.tnaot.core.AppiumBaseExecutor;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.support.PageFactory;

@Data
public class LoginPage extends AppiumBaseExecutor {

    public LoginPage(AppiumDriver<?> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    /** 我的 */
    @AndroidFindBy(id="cn.dbyl.young.tianqi:id/tab_home")
    MobileElement tabMine;

    /** 手机号登录 */
    @AndroidFindBy(id="cn.dbyl.young.tianqi:id/tab_personal")
    MobileElement phoneLoginType;

    /** 区域 */
    @AndroidFindBy(id="cn.dbyl.young.tianqi:id/tab_personal")
    MobileElement areaText;

    /** 手机号 */
    @AndroidFindBy(id="cn.dbyl.young.tianqi:id/tab_personal")
    MobileElement phoneText;

    /** 密码 */
    @AndroidFindBy(id="cn.dbyl.young.tianqi:id/tab_personal")
    MobileElement pwdText;

    /** 登录按钮 */
    @AndroidFindBy(id="cn.dbyl.young.tianqi:id/tab_personal")
    MobileElement loginButton;

    /**  */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Switch[1]")
    MobileElement openButton1;

    /**  */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[10]")
    MobileElement openButton2;


    /**  For Test */
//    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Switch[1]")
    @AndroidFindBy(id = "com.hsbc.personalbanking.MobileGPBUKUAT:id/accountSwitch")
    MobileElement switch1;
    //    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Switch[2]")
    @AndroidFindBy(id = "com.hsbc.personalbanking.MobileGPBUKUAT:id/currencySwitchLess")
    MobileElement switch2;
    //    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[10]")
    @AndroidFindBy(id = "com.hsbc.personalbanking.MobileGPBUKUAT:id/go")
    MobileElement goBtn;

    @AndroidFindBy(id = "com.hsbc.personalbanking.MobileGPBUKUAT:id/ivAllocationOff")
    MobileElement allocationBtn;

}
