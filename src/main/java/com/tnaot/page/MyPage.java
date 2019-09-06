package com.tnaot.page;

import com.tnaot.anotation.FindElementBy;
import com.tnaot.core.AppiumBaseExecutor;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@Data
public class MyPage extends AppiumBaseExecutor {

    public MyPage(AppiumDriver<?> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    /** 我的 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_mine")
    WebElement rlMine;
    /** 我的-版本更新弹窗关闭按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_update_close")
    WebElement updateCloseButton;

    /** 红包-右下角的红包提示 */
    @AndroidFindBy(id="com.tnaot.news:id/viewMessageTarget")
    WebElement bonus;
    /** 红点击红包-红包弹窗 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_red_packet")
    WebElement redPacketOverlay;
    /** 红点击红包-红包弹窗-领取的金额 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_red_packet")
    WebElement redPacketValue;


    /** 我的-金币 */
    @AndroidFindBy(id="com.tnaot.news:id/tvCoin")
    WebElement tvCoin;
    /** 我的-零钱 */
    @AndroidFindBy(id="com.tnaot.news:id/tvMoney")
    WebElement tvMoney;


    /** 我的-用户名 */
    @AndroidFindBy(id="com.tnaot.news:id/tvUsername")
    WebElement userName;

    /** 我的头像 */
    @AndroidFindBy(id="com.tnaot.news:id/ivUser")
    WebElement myPhoto;

    /** 我的头像-编辑资料 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_editinfo")
    WebElement editInfo;
    /** 我的头像-发布动态 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_release_dynamic")
    WebElement releaseDynamic;
    /** 我的头像-动态 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_dynamic_option")
    WebElement dynamicOption;
    /** 我的头像-生活 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_life_option")
    WebElement lifeOption;




    /** 我的头像-动态列表-第一个转发的资讯-标题 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_news_content")
    WebElement dynamicListNewsTitle;
    /** 我的头像-动态列表-第一个发布的动态-内容 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_content_comment")
    WebElement dynamicListDynamicTitle;

    /** 我的头像-生活列表-第一个生活的动态（转发并评论）-内容 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_content_comment")
    WebElement lifeListContent;
    /** 我的头像-生活列表-第一个生活的动态（转发并评论）-标题 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_news_content")
    WebElement lifeListNewsTitle;
    /** 我的头像-生活列表-第一个生活的动态（转发并评论）-更多 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/iv_delete")
    WebElement lifeListMore;
    /** 我的头像-生活列表-第一个生活的动态（转发并评论）-更多-删除 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_delete")
    WebElement lifeListDelete;














    /** 手机号登录 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_phone")
    WebElement phoneLoginType;

    /** 区域 */
    @AndroidFindBy(id="com.tnaot.news:id/et_country")
    WebElement areaText;

    /** 区域-选择 */
    @AndroidFindBy(id="com.tnaot.news:id/tvName")
    WebElement areaSelect;

    /** 手机号 */
    @AndroidFindBy(id="com.tnaot.news:id/user_name")
    WebElement phoneText;

    /** 密码 */
    @AndroidFindBy(id="com.tnaot.news:id/user_pwd")
    WebElement pwdText;

    /** 登录按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/tvLogin")
    WebElement loginButton;

    /** 快速注册 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_quick_registration")
    WebElement quickRegistration;

    /** 忘记密码 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_forget_pwd")
    WebElement forgetPwd;


    /** 谷歌账号登录 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_google")
    WebElement googleLoginType;

    /** Facebook登录 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_facebook")
    WebElement facebookLoginType;

    /** Twitter登录 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_twitter")
    WebElement twitterLoginType;

    /** Line登录 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_line")
    WebElement lineLoginType;

    /** 向右按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_login_right_arrow")
    WebElement loginRightArrow;

    /** QQ登录 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_qq")
    WebElement qqLoginType;

    /** 微信登录 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_wechat")
    WebElement wechatLoginType;

    /** 向左按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_login_left_arrow")
    WebElement loginLeftArrow;






    /** 提现 */
    @AndroidFindBy(id="com.tnaot.news:id/tvCashWithdrawal")
    WebElement tvCashWithdrawal;
    /** 提现-详情页-title */
    @FindElementBy(type = "accessibilityId", value = "提现")
    WebElement tvCashWithdrawalDetail;
    /** 提现-详情页-你尚未设置账号 */
    @FindElementBy(type = "className", value = "none-accounts", isWeb = true)
    MobileElement noSetAccount;

    /** 提现-金额-$1 */
    @FindElementBy(type = "accessibilityId", value = "$1")
    WebElement tvCashWithdrawalAmount1;
    /** 提现-金额-$2 */
    @FindElementBy(type = "accessibilityId", value = "$2")
    WebElement tvCashWithdrawalAmount2;
    /** 提现-金额-$5 */
    @FindElementBy(type = "accessibilityId", value = "$5")
    WebElement tvCashWithdrawalAmount3;
    /** 提现-金额-$10 */
    @FindElementBy(type = "accessibilityId", value = "$10")
    WebElement tvCashWithdrawalAmount4;
    /** 提现-金额-$20 */
    @FindElementBy(type = "accessibilityId", value = "$20")
    WebElement tvCashWithdrawalAmount5;
    /** 提现-金额-$30 */
    @FindElementBy(type = "accessibilityId", value = "$30")
    WebElement tvCashWithdrawalAmount6;
    /** 提现-立即提现 */
    @FindElementBy(type = "accessibilityId", value = "立即提现")
    WebElement toCashWithdrawal;



    /** 账单 */
    @AndroidFindBy(id="com.tnaot.news:id/tvBill")
    WebElement tvBill;
    /** 账单-详情页-title */
    @FindElementBy(type = "accessibilityId", value = "账单")
    WebElement tvBillDetail;


    /** 钱包 */
    @AndroidFindBy(id="com.tnaot.news:id/tvWallet")
    WebElement tvWallet;
    /** 钱包-详情页-title */
    @FindElementBy(type = "accessibilityId", value = "我的钱包")
    WebElement tvWalletDetail;



    /** 收藏 */
    @AndroidFindBy(id="com.tnaot.news:id/tvFavorite")
    WebElement tvFavorite;
    /** 收藏-资讯 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_tab_hisotyr_favoirte'][contains(@text, '资讯')]")
    WebElement collectNewsList;
    /** 收藏-生活 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_tab_hisotyr_favoirte'][contains(@text, '生活')]")
    WebElement collectLifeList;
    /** 收藏-编辑 */
    @AndroidFindBy(id="com.tnaot.news:id/tvEdit")
    WebElement editButton;
//    /** 收藏-返回按钮 */
//    @AndroidFindBy(id="com.tnaot.news:id/ib_back")
//    WebElement backButton;
    /** 收藏-编辑-checkbox */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/cn.bingoogolapple.swipebacklayout.BGASwipeBackLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.view.View")
    WebElement selectedBox;


    /** 收藏资讯列表-发布时间 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_time")
    WebElement releaseTime;
    /** 收藏资讯列表-作者 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tvAuthor")
    WebElement releaseAuthor;
    /** 收藏资讯列表-标题 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_title")
    WebElement releaseTitle;


    /** 收藏生活列表-标题 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/cn.bingoogolapple.swipebacklayout.BGASwipeBackLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView[1]")
    WebElement collectLifeListTitle;









    /** 历史 */
    @AndroidFindBy(id="com.tnaot.news:id/tvHistory")
    WebElement tvHistory;

    /** 历史-资讯tab键 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_tab_hisotyr_favoirte'][contains(@text, '资讯')]")
    WebElement historyNewsList;
    /** 历史-生活tab键 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_tab_hisotyr_favoirte'][contains(@text, '生活')]")
    WebElement historyLifeList;

    /** 历史-资讯列表-标题 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_title")
    WebElement historyTitle;
    /** 历史-资讯列表-作者 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tvAuthor")
    WebElement historyAuthor;
    /** 历史-资讯列表-发布时间 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_time")
    WebElement historyReleaseTime;


    /** 历史-资讯列表-动态--作者 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_name")
    WebElement historyDynamicAuthor;
    /** 历史-资讯列表-动态-发布时间 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_content")
    WebElement historyDynamicContent;


    /** 历史-生活列表-标题 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_life_content")
    WebElement historyLifeListTitle;



    /** Language */
    @AndroidFindBy(id="com.tnaot.news:id/tvLanguage")
    WebElement tvLanguage;

    /** Language-弹窗关闭 */
    @AndroidFindBy(id="com.tnaot.news:id/ivClose")
    WebElement closeButton;

    /** Language-中文 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_zh")
    WebElement tvLanguageZH;

    /** Language-英文 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_en")
    WebElement tvLanguageEN;

    /** Language-柬文 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_km")
    WebElement tvLanguageKM;


    /** 任务中心赚取更多金币 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_task_center")
    WebElement taskCenterForCoin;



    /** 邀请好友 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvMain'][@text='邀请好友']")
    WebElement inviteFriends;

    /** 任务中心 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvMain'][@text='任务中心']")
    WebElement taskCenter;

    /** 手机充值 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvMain'][@text='手机充值']")
    WebElement phonePaid;

    /** 我的资料 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvMain'][@text='我的资料']")
    WebElement myInfo;
    /** 我的资料-用户名 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_userName")
    WebElement myInfoUserName;
    /** 我的资料-用户名-请输入用户名 */
    @AndroidFindBy(id="com.tnaot.news:id/et_content")
    WebElement updateUserName;
    /** 我的资料-用户名-请输入用户名-确定 */
    @AndroidFindBy(id="com.tnaot.news:id/bt_confirm")
    WebElement btConfirm;
    /** 我的资料-用户名-请输入用户名-取消 */
    @AndroidFindBy(id="com.tnaot.news:id/bt_cancel")
    WebElement btCancel;



    /** 我的资料-简介 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_prefect")
    WebElement myInfoIntroduction;

    /** 我的资料-简介 */
    @AndroidFindBy(id="com.tnaot.news:id/et_content")
    WebElement myInfoIntroductionText;
    /** 我的资料-简介-取消 */
    @AndroidFindBy(id="com.tnaot.news:id/bt_cancel")
    WebElement myInfoIntroductionDismiss;
    /** 我的资料-简介-确定*/
    @AndroidFindBy(id="com.tnaot.news:id/bt_confirm")
    WebElement myInfoIntroductionAccept;

    /** 我的资料-性别 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_gender")
    WebElement myInfoSex;
    /** 我的资料-性别-男 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]")
    WebElement myInfoSexMan;
    /** 我的资料-性别-女 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")
    WebElement myInfoSexWoman;
    /** 我的资料-性别-保密 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[3]")
    WebElement myInfoSexSecret;
    /** 我的资料-性别-取消 */
    @AndroidFindBy(id="android:id/button2")
    WebElement myInfoSexDismissButton;



    /** 我的资料-生日 750-1300 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_birthday")
    WebElement myInfoBirthday;
    /** 我的资料-生日-输入年份 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[1]/android.widget.EditText")
    WebElement myInfoBirthdayYear;
    /** 我的资料-生日-输入月份 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[2]/android.widget.EditText")
    WebElement myInfoBirthdayMonth;
    /** 我的资料-生日-输入日 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[3]/android.widget.EditText")
    WebElement myInfoBirthdayDay;




    /** 我的资料-地区   [0,1276][1440,1456]   700,1276~700,1456  */
    @AndroidFindBy(id="com.tnaot.news:id/rl_area")
    WebElement myInfoArea;
    /** 我的资料-地区-选择地区-取消 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_cancel")
    WebElement myInfoAreaDismiss;
    /** 我的资料-地区-选择地区-确认 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_confirm")
    WebElement myInfoAreaAccept;


    /** 我的资料-兴趣标签 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_user_tag")
    WebElement myInfoHobby;
    /** 我的资料-兴趣标签-科技-手机 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='英超']")
    WebElement hobbyScienceType1;
    /** 我的资料-兴趣标签-科技-互联网 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='互联网']")
    WebElement hobbyScienceType2;
    /** 我的资料-兴趣标签-科技-相机 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='相机']")
    WebElement hobbyScienceType3;
    /** 我的资料-兴趣标签-科技-软件 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='软件']")
    WebElement hobbyScienceType4;
    /** 我的资料-兴趣标签-科技-平板电脑 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='平板电脑']")
    WebElement hobbyScienceType5;

    /** 我的资料-兴趣标签-体育-英超 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='二手车']")
    WebElement hobbySportsType1;
    /** 我的资料-兴趣标签-体育-拳击 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='拳击']")
    WebElement hobbySportsType2;
    /** 我的资料-兴趣标签-体育-足球 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='足球']")
    WebElement hobbySportsType3;
    /** 我的资料-兴趣标签-体育-户外 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='户外']")
    WebElement hobbySportsType4;
    /** 我的资料-兴趣标签-体育-世界杯 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='世界杯']")
    WebElement hobbySportsType5;

    /** 我的资料-兴趣标签-汽车-二手车 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='养生']")
    WebElement hobbyCarType1;
    /** 我的资料-兴趣标签-汽车-保养 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='保养']")
    WebElement hobbyCarType2;
    /** 我的资料-兴趣标签-汽车-新车 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='新车']")
    WebElement hobbyCarType3;
    /** 我的资料-兴趣标签-汽车-摩托 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='摩托']")
    WebElement hobbyCarType4;
    /** 我的资料-兴趣标签-汽车-兰博基尼 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='兰博基尼']")
    WebElement hobbyCarType5;


    /** 我的资料-兴趣标签-健康-养生 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='家居']")
    WebElement hobbyHealthType1;
    /** 我的资料-兴趣标签-健康-减肥 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='减肥']")
    WebElement hobbyHealthType2;
    /** 我的资料-兴趣标签-健康-健身 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='健身']")
    WebElement hobbyHealthType3;
    /** 我的资料-兴趣标签-健康-药品 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='药品']")
    WebElement hobbyHealthType4;
    /** 我的资料-兴趣标签-健康-疾病 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='疾病']")
    WebElement hobbyHealthType5;


    /** 我的资料-兴趣标签-返回按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/ib_back")
    WebElement myInfoHobbyBackButton;
    /** 我的资料-兴趣标签-确定按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/ib_user_tag_select")
    WebElement myInfoHobbyAcceptButton;



    /** 账号设置 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvMain'][@text='账号设置']")
    WebElement accountSetting;
    /** 账号设置-手机号 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_phoneNumber")
    WebElement accountSettingPhone;
    /** 账号设置-修改密码 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_changePassword")
    WebElement accountSettingUpdatePwd;
    /** 账号设置-修改密码-发送验证码 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_getVerifyCode")
    WebElement getVerifyCode;
    /** 账号设置-修改密码-输入验证码 */
    @AndroidFindBy(id="com.tnaot.news:id/et_verification")
    WebElement inputVerifyCode;
    /** 账号设置-修改密码-输入密码 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_changePassword")
    WebElement inputPwd;
    /** 账号设置-修改密码-提交按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/btn_submit")
    WebElement submitButton;



    /** 热门活动 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvMain'][@text='热门活动']")
    WebElement hotActivity;

    /** 消息通知 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvMain'][@text='消息通知']")
    WebElement infoNotice;

    /** 用户动态 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvMain'][@text='用户动态']")
    WebElement userDynamic;

    /** 在线客服 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvMain'][@text='在线客服']")
    WebElement lineService;

    /** 自媒体申请 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvMain'][@text='自媒体申请']")
    WebElement mediaApplication;

//    /** 系统设置 */
//    @FindBy(linkText="系统设置")
//    WebElement sysSetting;

    /** 系统设置 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvMain'][@text='系统设置']")
    WebElement sysSetting;

    /** 系统设置-清除缓存 */
    @AndroidFindBy(id="com.tnaot.news:id/number")
    WebElement clearCache;

    /** 系统设置-字体大小 */
    @AndroidFindBy(id="com.tnaot.news:id/typeface")
    WebElement fontSize;
    /** 系统设置-字体大小-小 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]")
    WebElement fontSizeSmall;
    /** 系统设置-字体大小-中 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")
    WebElement fontSizeMiddler;
    /** 系统设置-字体大小-大 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[3]")
    WebElement fontSizeLarge;
    /** 系统设置-字体大小-特大 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[4]")
    WebElement fontSizeXLarge;


    /** 系统设置-非WiFi流量设置 */
    @AndroidFindBy(id="com.tnaot.news:id/tvImageMode")
    WebElement imageMode;
    /** 系统设置-非WiFi流量设置-无图 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_no_image")
    WebElement imageModeNoImage;
    /** 系统设置-非WiFi流量设置-缩略图 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_thumb")
    WebElement imageModeThumbImage;
    /** 系统设置-非WiFi流量设置-高清大图 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_big_image")
    WebElement imageModeBigImage;


    /** 系统设置-非WiFi播放提醒 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_no_wifi_play_mode")
    WebElement playMode;
    /** 系统设置-非WiFi播放提醒-提醒一次 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_tips_one_time")
    WebElement playModeOneTime;
    /** 系统设置-非WiFi播放提醒-总是提醒 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_tips_always")
    WebElement playModeAlways;

    /** 系统设置-自动播放 */
    @AndroidFindBy(id="com.tnaot.news:id/tgbtn_video_auto_play")
    WebElement autoPlay;

    /** 系统设置-列表是否显示摘要 */
    @AndroidFindBy(id="com.tnaot.news:id/tb_display_summary")
    WebElement displaySummary;

    /** 系统设置-退出登录 */
    @AndroidFindBy(id="com.tnaot.news:id/rlExit")
    WebElement logoutButton;
    /** 系统设置-退出登录-确定 */
    @AndroidFindBy(id="android:id/button1")
    WebElement acceptButton;
    /** 系统设置-退出登录-取消 */
    @AndroidFindBy(id="android:id/button2")
    WebElement dismissButton;


    /** 版本更新 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvMain'][@text='版本更新']")
    WebElement versionUpdate;
    /** 版本更新-检查版本 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_version")
    WebElement versionUpdateVersion;
    /** 版本更新-自动更新 */
    @AndroidFindBy(id="com.tnaot.news:id/btn_toggle")
    WebElement versionUpdateAutoUpdate;
    /** 版本更新-去评价 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_evaluate")
    WebElement versionUpdateEvaluate;

    /** 版本更新-用户协议 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_userAgreement")
    WebElement versionUpdateUserAgreement;
    /** 版本更新-用户协议-文本 */
    //@AndroidFindBy(xpath="//android.view.View[@content-desc='Tnaot用户协议']")
    @AndroidFindBy(xpath="//android.view.View[@content-desc='Tnaot用户协议']")
    WebElement userAgreementText;
    /** 版本更新-用户协议-文本-返回按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/ib_back")
    WebElement backButton;



    /** 版本更新-隐私条款 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_privacy_clause")
    WebElement versionUpdatePrivacyClause;
    /** 版本更新-隐私条款-文本 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='隐私政策']")
    WebElement privacyClauseText;

    /** 版本更新-关于我们 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_about")
    WebElement versionUpdateAboutUS;
    /** 版本更新-关于我们-文本 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='邮箱：support@tnaot.com']")
    WebElement aboutUSText;


}
