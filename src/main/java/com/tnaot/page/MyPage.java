package com.tnaot.page;

import com.tnaot.core.AppiumBaseExecutor;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class MyPage extends AppiumBaseExecutor {

    public MyPage(AppiumDriver<?> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    /** 我的 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_mine")
    MobileElement rlMine;

    /** 我的-用户名 */
    @AndroidFindBy(id="com.tnaot.news:id/tvUsername")
    MobileElement userName;

    /** 我的头像 */
    @AndroidFindBy(id="com.tnaot.news:id/ivUser")
    MobileElement myPhone;

    /** 我的头像-编辑资料 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_editinfo")
    MobileElement editInfo;



    /** 手机号登录 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_phone")
    MobileElement phoneLoginType;

    /** 区域 */
    @AndroidFindBy(id="com.tnaot.news:id/et_country")
    MobileElement areaText;

    /** 区域-选择 */
    @AndroidFindBy(id="com.tnaot.news:id/tvName")
    MobileElement areaSelect;

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


    /** 谷歌账号登录 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_google")
    MobileElement googleLoginType;

    /** Facebook登录 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_facebook")
    MobileElement facebookLoginType;

    /** Twitter登录 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_twitter")
    MobileElement twitterLoginType;

    /** Line登录 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_line")
    MobileElement lineLoginType;

    /** 向右按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_login_right_arrow")
    MobileElement loginRightArrow;

    /** QQ登录 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_qq")
    MobileElement qqLoginType;

    /** 微信登录 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_wechat")
    MobileElement wechatLoginType;

    /** 向左按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_login_left_arrow")
    MobileElement loginLeftArrow;






    /** 提现 */
    @AndroidFindBy(id="com.tnaot.news:id/tvCashWithdrawal")
    MobileElement tvCashWithdrawal;

    /** 账单 */
    @AndroidFindBy(id="com.tnaot.news:id/tvBill")
    MobileElement tvBill;

    /** 钱包 */
    @AndroidFindBy(id="com.tnaot.news:id/tvWallet")
    MobileElement tvWallet;

    /** 收藏 */
    @AndroidFindBy(id="com.tnaot.news:id/tvFavorite")
    MobileElement tvFavorite;

    /** 历史 */
    @AndroidFindBy(id="com.tnaot.news:id/tvHistory")
    MobileElement tvHistory;

    /** Language */
    @AndroidFindBy(id="com.tnaot.news:id/tvLanguage")
    MobileElement tvLanguage;

    /** Language-弹窗关闭 */
    @AndroidFindBy(id="com.tnaot.news:id/ivClose")
    MobileElement closeButton;

    /** Language-中文 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_zh")
    MobileElement tvLanguageZH;

    /** Language-英文 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_en")
    MobileElement tvLanguageEN;

    /** Language-柬文 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_km")
    MobileElement tvLanguageKM;


    /** 任务中心赚取更多金币 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_task_center")
    MobileElement taskCenterForCoin;



    /** 邀请好友 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvMain'][@text='邀请好友']")
    MobileElement inviteFriends;

    /** 任务中心 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvMain'][@text='任务中心']")
    MobileElement taskCenter;

    /** 手机充值 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvMain'][@text='手机充值']")
    MobileElement phonePaid;

    /** 我的资料 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvMain'][@text='我的资料']")
    MobileElement myInfo;
    /** 我的资料-用户名 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_userName")
    MobileElement myInfoUserName;
    /** 我的资料-用户名-请输入用户名 */
    @AndroidFindBy(id="com.tnaot.news:id/et_content")
    MobileElement updateUserName;
    /** 我的资料-用户名-请输入用户名-确定 */
    @AndroidFindBy(id="com.tnaot.news:id/bt_confirm")
    MobileElement btConfirm;
    /** 我的资料-用户名-请输入用户名-取消 */
    @AndroidFindBy(id="com.tnaot.news:id/bt_cancel")
    MobileElement btCancel;




    /** 我的资料-简介 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_prefect")
    MobileElement myInfoIntroduction;

    /** 我的资料-简介 */
    @AndroidFindBy(id="com.tnaot.news:id/et_content")
    MobileElement myInfoIntroductionText;
    /** 我的资料-简介-取消 */
    @AndroidFindBy(id="com.tnaot.news:id/bt_cancel")
    MobileElement myInfoIntroductionAccept;
    /** 我的资料-简介-确定*/
    @AndroidFindBy(id="com.tnaot.news:id/bt_confirm")
    MobileElement myInfoIntroductionDismiss;

    /** 我的资料-性别 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_gender")
    MobileElement myInfoSex;
    /** 我的资料-性别-男 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]")
    MobileElement myInfoSexMan;
    /** 我的资料-性别-女 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")
    MobileElement myInfoSexWoman;
    /** 我的资料-性别-保密 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[3]")
    MobileElement myInfoSexSecret;
    /** 我的资料-性别-取消 */
    @AndroidFindBy(id="android:id/button2")
    MobileElement myInfoSexDismissButton;



    /** 我的资料-生日 750-1300 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_birthday")
    MobileElement myInfoBirthday;

    /** 我的资料-地区   [0,1276][1440,1456]   700,1276~700,1456  */
    @AndroidFindBy(id="com.tnaot.news:id/rl_area")
    MobileElement myInfoArea;
    /** 我的资料-地区-选择地区-取消 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_cancel")
    MobileElement myInfoAreaAccept;
    /** 我的资料-地区-选择地区-确认 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_confirm")
    MobileElement myInfoAreaDismiss;


    /** 我的资料-兴趣标签 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_user_tag")
    MobileElement myInfoHobby;
    /** 我的资料-兴趣标签-返回按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/ib_back")
    MobileElement myInfoHobbyBackButton;
    /** 我的资料-兴趣标签-确定按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/ib_user_tag_select")
    MobileElement myInfoHobbyAcceptButton;



    /** 账号设置 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvMain'][@text='账号设置']")
    MobileElement accountSetting;
    /** 账号设置-手机号 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_phoneNumber")
    MobileElement accountSettingPhone;
    /** 账号设置-修改密码 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_changePassword")
    MobileElement accountSettingUpdatePwd;
    /** 账号设置-修改密码-发送验证码 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_getVerifyCode")
    MobileElement getVerifyCode;
    /** 账号设置-修改密码-输入验证码 */
    @AndroidFindBy(id="com.tnaot.news:id/et_verification")
    MobileElement inputVerifyCode;
    /** 账号设置-修改密码-输入密码 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_changePassword")
    MobileElement inputPwd;
    /** 账号设置-修改密码-提交按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/btn_submit")
    MobileElement submitButton;



    /** 热门活动 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvMain'][@text='热门活动']")
    MobileElement hotActivity;

    /** 消息通知 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvMain'][@text='消息通知']")
    MobileElement infoNotice;

    /** 用户动态 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvMain'][@text='用户动态']")
    MobileElement userDynamic;

    /** 在线客服 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvMain'][@text='在线客服']")
    MobileElement lineService;

    /** 自媒体申请 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvMain'][@text='自媒体申请']")
    MobileElement mediaApplication;

//    /** 系统设置 */
//    @FindBy(linkText="系统设置")
//    MobileElement sysSetting;

    /** 系统设置 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvMain'][@text='系统设置']")
    MobileElement sysSetting;

    /** 系统设置-清除缓存 */
    @AndroidFindBy(id="com.tnaot.news:id/number")
    MobileElement clearCache;

    /** 系统设置-字体大小 */
    @AndroidFindBy(id="com.tnaot.news:id/typeface")
    MobileElement fontSize;
    /** 系统设置-字体大小-小 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]")
    MobileElement fontSizeSmall;
    /** 系统设置-字体大小-中 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")
    MobileElement fontSizeMiddler;
    /** 系统设置-字体大小-大 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[3]")
    MobileElement fontSizeLarge;
    /** 系统设置-字体大小-特大 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[4]")
    MobileElement fontSizeXLarge;


    /** 系统设置-非WiFi流量设置 */
    @AndroidFindBy(id="com.tnaot.news:id/tvImageMode")
    MobileElement imageMode;
    /** 系统设置-非WiFi流量设置-无图 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_no_image")
    MobileElement imageModeNoImage;
    /** 系统设置-非WiFi流量设置-缩略图 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_thumb")
    MobileElement imageModeThumbImage;
    /** 系统设置-非WiFi流量设置-高清大图 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_big_image")
    MobileElement imageModeBigImage;


    /** 系统设置-非WiFi播放提醒 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_no_wifi_play_mode")
    MobileElement playMode;
    /** 系统设置-非WiFi播放提醒-提醒一次 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_tips_one_time")
    MobileElement playModeOneTime;
    /** 系统设置-非WiFi播放提醒-总是提醒 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_tips_always")
    MobileElement playModeAlways;

    /** 系统设置-自动播放 */
    @AndroidFindBy(id="com.tnaot.news:id/tgbtn_video_auto_play")
    MobileElement autoPlay;

    /** 系统设置-列表是否显示摘要 */
    @AndroidFindBy(id="com.tnaot.news:id/tb_display_summary")
    MobileElement displaySummary;

    /** 系统设置-退出登录 */
    @AndroidFindBy(id="com.tnaot.news:id/rlExit")
    MobileElement logoutButton;
    /** 系统设置-退出登录-确定 */
    @AndroidFindBy(id="android:id/button1")
    MobileElement acceptButton;
    /** 系统设置-退出登录-取消 */
    @AndroidFindBy(id="android:id/button2")
    MobileElement dismissButton;


    /** 版本更新 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvMain'][@text='版本更新']")
    MobileElement versionUpdate;
    /** 版本更新-检查版本 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_version")
    MobileElement versionUpdateVersion;
    /** 版本更新-自动更新 */
    @AndroidFindBy(id="com.tnaot.news:id/btn_toggle")
    MobileElement versionUpdateAutoUpdate;
    /** 版本更新-去评价 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_evaluate")
    MobileElement versionUpdateEvaluate;
    /** 版本更新-用户协议 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_userAgreement")
    MobileElement versionUpdateUserAgreement;
    /** 版本更新-隐私条款 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_privacy_clause")
    MobileElement versionUpdatePrivacyClause;
    /** 版本更新-关于我们 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_about")
    MobileElement versionUpdateAboutUS;

}
