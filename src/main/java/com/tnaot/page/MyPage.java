package com.tnaot.page;

import com.tnaot.core.AppiumBaseExecutor;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Data;

@Data
public class MyPage extends AppiumBaseExecutor {

    public MyPage(AppiumDriver<?> driver) {
        super(driver);
    }

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




    /** 邀请好友 */
    @AndroidFindBy(id="com.tnaot.news:id/tvMain")
    MobileElement inviteFriends;

    /** 任务中心 */
    @AndroidFindBy(id="com.tnaot.news:id/tvMain")
    MobileElement taskCenter;

    /** 手机充值 */
    @AndroidFindBy(id="com.tnaot.news:id/tvMain")
    MobileElement phonePaid;

    /** 我的资料 */
    @AndroidFindBy(id="com.tnaot.news:id/tvMain")
    MobileElement myInfo;

    /** 账号设置 */
    @AndroidFindBy(id="com.tnaot.news:id/tvMain")
    MobileElement accountSetting;

    /** 热门活动 */
    @AndroidFindBy(id="com.tnaot.news:id/tvMain")
    MobileElement hotActivity;

    /** 消息通知 */
    @AndroidFindBy(id="com.tnaot.news:id/tvMain")
    MobileElement infoNotice;

    /** 用户动态 */
    @AndroidFindBy(id="com.tnaot.news:id/tvMain")
    MobileElement userDynamic;

    /** 在线客服 */
    @AndroidFindBy(id="com.tnaot.news:id/tvMain")
    MobileElement lineService;

    /** 自媒体申请 */
    @AndroidFindBy(id="com.tnaot.news:id/tvMain")
    MobileElement mediaApplication;

    /** 系统设置 */
    @AndroidFindBy(id="com.tnaot.news:id/tvMain")
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
    @AndroidFindBy(id="\tcom.tnaot.news:id/tv_tips_one_time")
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
    @AndroidFindBy(id="com.tnaot.news:id/tvMain")
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
