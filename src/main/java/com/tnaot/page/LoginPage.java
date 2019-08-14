package com.tnaot.page;

import com.tnaot.core.AppiumBaseExecutor;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.support.PageFactory;

@Data
public class LoginPage extends AppiumBaseExecutor {

    public LoginPage(AppiumDriver<?> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    /** 初次安装页面弹框-是否允许获取当前位置 */
    @AndroidFindBy(id="com.android.packageinstaller:id/dialog_container")
    MobileElement dialogContainer;

    /** 初次安装页面弹框-点击“允许” */
    @AndroidFindBy(id="com.android.packageinstaller:id/permission_allow_button")
    MobileElement allowButton;

    /** 我的 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_mine")
    MobileElement rlMine;

    /** 手机号登录 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_phone")
    MobileElement phoneLoginType;

    /** 区域 */
    @AndroidFindBy(id="com.tnaot.news:id/et_country")
    MobileElement areaText;

    /** 区域-选择 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/cn.bingoogolapple.swipebacklayout.BGASwipeBackLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView[2]")
    MobileElement areaSelect;

    /** 区域-选择 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/cn.bingoogolapple.swipebacklayout.BGASwipeBackLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.TextView")
    MobileElement areaSelectJP;



    /** 手机号 */
    @AndroidFindBy(id="com.tnaot.news:id/user_name")
    MobileElement phoneText;

    /** 密码 */
    @AndroidFindBy(id="com.tnaot.news:id/user_pwd")
    MobileElement pwdText;

    /** 登录按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/tvLogin")
    MobileElement loginButton;

    /** 快速注册 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_quick_registration")
    MobileElement quickRegistration;

    /** 忘记密码 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_forget_pwd")
    MobileElement forgetPwd;

    /** 第一条资讯 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.TextView")
    MobileElement newsOne;

    /** 收藏按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/ivFavorite")
    MobileElement isCollect;



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

    @AndroidFindBy(id = "com.hsbc.personalbanking.MobileGPBUKUAT:id/ivAllocationOn")
    MobileElement allocationBtn1;

    @AndroidFindBy(id = "com.hsbc.personalbanking.MobileGPBUKUAT:id/tvLeft")
    MobileElement accountLable;


    /**  */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Switch[1]")
    MobileElement openButton1;

    /**  */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[10]")
    MobileElement openButton2;


}
