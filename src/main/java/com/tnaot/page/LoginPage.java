package com.tnaot.page;

import com.tnaot.anotation.FindElementBy;
import com.tnaot.core.AppiumBaseExecutor;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@Data
public class LoginPage extends AppiumBaseExecutor {

    public LoginPage(AppiumDriver<?> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);//初始化driver，否则@AndroidFindBy会提示空指针异常
    }

    @FindElementBy(type="id", value="com.tnaot.news:id/tvLanguage")
    @AndroidFindBy(id="com.tnaot.news:id/tvLanguage")
    WebElement tvLanguage;
    @FindElementBy(type="id", value="com.tnaot.news:id/tvHistory")
    @AndroidFindBy(id="com.tnaot.news:id/tvHistory")
    WebElement tvHistory;


    /** 初次安装页面弹框-是否允许获取当前位置 */
    @AndroidFindBy(id="com.android.packageinstaller:id/dialog_container")
    WebElement dialogContainer;

    /** 初次安装页面弹框-点击“允许” */
    @AndroidFindBy(id="com.android.packageinstaller:id/permission_allow_button")
    WebElement allowButton;

    /** 我的 */
    @AndroidFindBy(id="com.tnaot.newspro:id/iv_mine")
    WebElement rlMine;

    /** 登录 */
    @AndroidFindBy(id="com.tnaot.newspro:id/tv_login_btn")
    WebElement enterButton;

    /** 我的-右上角-设置按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_mine")
    WebElement settingButon;

    /** 我的-弹窗-关闭按钮 */
    @AndroidFindBy(id="com.tnaot.newspro:id/ivClose")
    WebElement bannerCloseButton;

    /** 手机号登录入口 */
    @AndroidFindBy(id="com.tnaot.newspro:id/tv_login_btn")
    WebElement phoneLoginButton;

    /** 手机号登录方式 */
    @AndroidFindBy(id="com.tnaot.newspro:id/tv_main_password_login")
    WebElement phoneLoginType;

    /** 注册方式 */
    @AndroidFindBy(id="com.tnaot.newspro:id/tv_main_phone_login")
    WebElement registerLoginType;

    /** 注册方式-区域 */
    @AndroidFindBy(id="com.tnaot.newspro:id/iv_arrow_area_code")
    WebElement registerArea;

    /** 注册方式-手机号 */
    @AndroidFindBy(id="com.tnaot.newspro:id/et_phone_num")
    WebElement registerPhone;
    /** 注册方式-手机号-下一步 */
    @AndroidFindBy(id="com.tnaot.newspro:id/ibtn_login")
    WebElement registerNextPhone;
    /** 注册方式-手机号-下一步-输入验证码 */
    @AndroidFindBy(id="com.tnaot.newspro:id/et_verify_code")
    WebElement registerCode;


    /** 区域 */
    @AndroidFindBy(id="com.tnaot.newspro:id/iv_password_arrow_area_code")
    WebElement areaText;

    /** 区域-选择 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView[2]")
    WebElement areaSelectZH;

    /** 区域-选择 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.TextView")
    WebElement areaSelectKM;



    /** 手机号 */
    @AndroidFindBy(id="com.tnaot.newspro:id/et_password_phone_num")
    WebElement phoneText;

    /** 密码 */
    @AndroidFindBy(id="com.tnaot.newspro:id/et_phone_password")
    WebElement pwdText;

    /** 登录按钮 */
    @AndroidFindBy(id="com.tnaot.newspro:id/ibtn_password_login")
    WebElement loginButton;

    /** 快速注册 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_quick_registration")
    WebElement quickRegistration;

    /** 忘记密码 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_forget_pwd")
    WebElement forgetPwd;

    /** 第一条资讯 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.TextView")
    WebElement newsOne;

    /** 收藏按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/ivFavorite")
    WebElement isCollect;



    /**  For Test */
//    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Switch[1]")
    @AndroidFindBy(id = "com.hsbc.personalbanking.MobileGPBUKUAT:id/accountSwitch")
    WebElement switch1;
    //    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Switch[2]")
    @AndroidFindBy(id = "com.hsbc.personalbanking.MobileGPBUKUAT:id/currencySwitchLess")
    WebElement switch2;
    //    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[10]")
    @AndroidFindBy(id = "com.hsbc.personalbanking.MobileGPBUKUAT:id/go")
    WebElement goBtn;

    @AndroidFindBy(id = "com.hsbc.personalbanking.MobileGPBUKUAT:id/ivAllocationOff")
    WebElement allocationBtn;

    @AndroidFindBy(id = "com.hsbc.personalbanking.MobileGPBUKUAT:id/ivAllocationOn")
    WebElement allocationBtn1;

    @AndroidFindBy(id = "com.hsbc.personalbanking.MobileGPBUKUAT:id/tvLeft")
    WebElement accountLable;


    /**  */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Switch[1]")
    WebElement openButton1;

    /**  */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[10]")
    WebElement openButton2;





    /** 认领模块 **/
    /**【关注】按钮 **/
    @AndroidFindBy(id = "com.tnaot.newspro:id/ll_follow")
    WebElement followButton;

    /**【关注列表】第一个人 **/
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
    WebElement followListFirst;


    /**立即认领按钮 **/
    @AndroidFindBy(id = "com.tnaot.newspro:id/tv_to_claim")
    WebElement claimButton;
    /** 实名认证 **/
    @AndroidFindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div[2]/div[1]")
    WebElement resource1;
    /**联系方式 **/
    @AndroidFindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]")
    WebElement resource2;
    /**来源资料截图 **/
    @AndroidFindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div[3]/div")
    WebElement resource3;
    /**营业执照**/
    @AndroidFindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div[4]/div[1]")
    WebElement resource4;

    /**实名认证-姓名 **/
    @AndroidFindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div[1]/div/input")
    WebElement nameClaim;
    /** 实名认证-证件号码**/
    @AndroidFindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div[2]/div/input")
    WebElement idCardClaim;
    /**实名认证-上传身份证-正面 **/
    @AndroidFindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div[3]/div[1]/img")
    WebElement card1Claim;
    /**实名认证-上传身份证-反面 **/
    @AndroidFindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div[3]/div[2]/img")
    WebElement card2Claim;

    /**实名认证-选择图片方式-从相册中获取 **/
    @AndroidFindBy(xpath = "//*[@id=\"app\"]/div/div[4]/div[2]")
    WebElement selectPhontoType;

    /**实名认证-选择相册图片 **/
    @AndroidFindBy(id = "com.tnaot.newspro:id/iv_photo")
    WebElement selectPhoto;
    /**实名认证-选择相册图片-完成 **/
    @AndroidFindBy(id = "com.tnaot.newspro:id/done")
    WebElement finishSelectPhoto;





    /** **/
    /** **/
    /** **/
    /** **/
    /** **/
    /** **/
    /** **/
    /** **/
    /** **/
    /** **/
    /** **/
    /** **/
    /** **/
    /** **/


}
