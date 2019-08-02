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

    /** 版本更新 */
    @AndroidFindBy(id="com.tnaot.news:id/tvMain")
    MobileElement versionUpdate;

}
