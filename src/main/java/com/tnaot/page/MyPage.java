package com.tnaot.page;

import com.tnaot.anotation.FindElementBy;
import com.tnaot.core.AppiumBaseExecutor;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
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
    /** 红包-右下角的红包提示 */
    @AndroidFindBy(id="com.tnaot.news:id/viewMessageTarget")
    MobileElement bonus;
    /** 红点击红包-红包弹窗 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_red_packet")
    MobileElement redPacketOverlay;
    /** 红点击红包-红包弹窗-领取的金额 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_red_packet")
    MobileElement redPacketValue;


    /** 我的-金币 */
    @AndroidFindBy(id="com.tnaot.news:id/tvCoin")
    MobileElement tvCoin;
    /** 我的-零钱 */
    @AndroidFindBy(id="com.tnaot.news:id/tvMoney")
    MobileElement tvMoney;


    /** 我的-用户名 */
    @AndroidFindBy(id="com.tnaot.news:id/tvUsername")
    MobileElement userName;

    /** 我的头像 */
    @AndroidFindBy(id="com.tnaot.news:id/ivUser")
    MobileElement myPhoto;

    /** 我的头像-编辑资料 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_editinfo")
    MobileElement editInfo;
    /** 我的头像-发布动态 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_release_dynamic")
    MobileElement releaseDynamic;
    /** 我的头像-动态 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_dynamic_option")
    MobileElement dynamicOption;
    /** 我的头像-生活 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_life_option")
    MobileElement lifeOption;




    /** 我的头像-动态列表-第一个转发的资讯-标题 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_news_content")
    MobileElement dynamicListNewsTitle;
    /** 我的头像-动态列表-第一个发布的动态-内容 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_content_comment")
    MobileElement dynamicListDynamicTitle;

    /** 我的头像-生活列表-第一个生活的动态（转发并评论）-内容 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_content_comment")
    MobileElement lifeListContent;
    /** 我的头像-生活列表-第一个生活的动态（转发并评论）-标题 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_news_content")
    MobileElement lifeListNewsTitle;
    /** 我的头像-生活列表-第一个生活的动态（转发并评论）-更多 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/iv_delete")
    MobileElement lifeListMore;
    /** 我的头像-生活列表-第一个生活的动态（转发并评论）-更多-删除 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_delete")
    MobileElement lifeListDelete;














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
    /** 提现-详情页-title */
    @FindElementBy(type = "accessibilityId", value = "提现")
    MobileElement tvCashWithdrawalDetail;

    /** 提现-金额-$1 */
    @FindElementBy(type = "accessibilityId", value = "$1")
    MobileElement tvCashWithdrawalAmount1;
    /** 提现-金额-$2 */
    @FindElementBy(type = "accessibilityId", value = "$2")
    MobileElement tvCashWithdrawalAmount2;
    /** 提现-金额-$5 */
    @FindElementBy(type = "accessibilityId", value = "$5")
    MobileElement tvCashWithdrawalAmount3;
    /** 提现-金额-$10 */
    @FindElementBy(type = "accessibilityId", value = "$10")
    MobileElement tvCashWithdrawalAmount4;
    /** 提现-金额-$20 */
    @FindElementBy(type = "accessibilityId", value = "$20")
    MobileElement tvCashWithdrawalAmount5;
    /** 提现-金额-$30 */
    @FindElementBy(type = "accessibilityId", value = "$30")
    MobileElement tvCashWithdrawalAmount6;
    /** 提现-立即提现 */
    @FindElementBy(type = "accessibilityId", value = "立即提现")
    MobileElement toCashWithdrawal;



    /** 账单 */
    @AndroidFindBy(id="com.tnaot.news:id/tvBill")
    MobileElement tvBill;
    /** 账单-详情页-title */
    @FindElementBy(type = "accessibilityId", value = "账单")
    MobileElement tvBillDetail;


    /** 钱包 */
    @AndroidFindBy(id="com.tnaot.news:id/tvWallet")
    MobileElement tvWallet;
    /** 钱包-详情页-title */
    @FindElementBy(type = "accessibilityId", value = "我的钱包")
    MobileElement tvWalletDetail;



    /** 收藏 */
    @AndroidFindBy(id="com.tnaot.news:id/tvFavorite")
    MobileElement tvFavorite;
    /** 收藏-资讯 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_tab_hisotyr_favoirte'][contains(@text, '资讯')]")
    MobileElement collectNewsList;
    /** 收藏-生活 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_tab_hisotyr_favoirte'][contains(@text, '生活')]")
    MobileElement collectLifeList;
    /** 收藏-编辑 */
    @AndroidFindBy(id="com.tnaot.news:id/tvEdit")
    MobileElement editButton;
//    /** 收藏-返回按钮 */
//    @AndroidFindBy(id="com.tnaot.news:id/ib_back")
//    MobileElement backButton;
    /** 收藏-编辑-checkbox */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/cn.bingoogolapple.swipebacklayout.BGASwipeBackLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.view.View")
    MobileElement selectedBox;


    /** 收藏资讯列表-发布时间 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_time")
    MobileElement releaseTime;
    /** 收藏资讯列表-作者 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tvAuthor")
    MobileElement releaseAuthor;
    /** 收藏资讯列表-标题 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_title")
    MobileElement releaseTitle;


    /** 收藏生活列表-标题 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/cn.bingoogolapple.swipebacklayout.BGASwipeBackLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView[1]")
    MobileElement collectLifeListTitle;









    /** 历史 */
    @AndroidFindBy(id="com.tnaot.news:id/tvHistory")
    MobileElement tvHistory;

    /** 历史-资讯tab键 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_tab_hisotyr_favoirte'][contains(@text, '资讯')]")
    MobileElement historyNewsList;
    /** 历史-生活tab键 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_tab_hisotyr_favoirte'][contains(@text, '生活')]")
    MobileElement historyLifeList;

    /** 历史-资讯列表-标题 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_title")
    MobileElement historyTitle;
    /** 历史-资讯列表-作者 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tvAuthor")
    MobileElement historyAuthor;
    /** 历史-资讯列表-发布时间 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_time")
    MobileElement historyReleaseTime;


    /** 历史-资讯列表-动态--作者 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_name")
    MobileElement historyDynamicAuthor;
    /** 历史-资讯列表-动态-发布时间 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_content")
    MobileElement historyDynamicContent;


    /** 历史-生活列表-标题 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_life_content")
    MobileElement historyLifeListTitle;



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
    MobileElement myInfoIntroductionDismiss;
    /** 我的资料-简介-确定*/
    @AndroidFindBy(id="com.tnaot.news:id/bt_confirm")
    MobileElement myInfoIntroductionAccept;

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
    /** 我的资料-生日-输入年份 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[1]/android.widget.EditText")
    MobileElement myInfoBirthdayYear;
    /** 我的资料-生日-输入月份 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[2]/android.widget.EditText")
    MobileElement myInfoBirthdayMonth;
    /** 我的资料-生日-输入日 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[3]/android.widget.EditText")
    MobileElement myInfoBirthdayDay;




    /** 我的资料-地区   [0,1276][1440,1456]   700,1276~700,1456  */
    @AndroidFindBy(id="com.tnaot.news:id/rl_area")
    MobileElement myInfoArea;
    /** 我的资料-地区-选择地区-取消 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_cancel")
    MobileElement myInfoAreaDismiss;
    /** 我的资料-地区-选择地区-确认 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_confirm")
    MobileElement myInfoAreaAccept;


    /** 我的资料-兴趣标签 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_user_tag")
    MobileElement myInfoHobby;
    /** 我的资料-兴趣标签-科技-手机 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='英超']")
    MobileElement hobbyScienceType1;
    /** 我的资料-兴趣标签-科技-互联网 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='互联网']")
    MobileElement hobbyScienceType2;
    /** 我的资料-兴趣标签-科技-相机 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='相机']")
    MobileElement hobbyScienceType3;
    /** 我的资料-兴趣标签-科技-软件 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='软件']")
    MobileElement hobbyScienceType4;
    /** 我的资料-兴趣标签-科技-平板电脑 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='平板电脑']")
    MobileElement hobbyScienceType5;

    /** 我的资料-兴趣标签-体育-英超 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='二手车']")
    MobileElement hobbySportsType1;
    /** 我的资料-兴趣标签-体育-拳击 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='拳击']")
    MobileElement hobbySportsType2;
    /** 我的资料-兴趣标签-体育-足球 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='足球']")
    MobileElement hobbySportsType3;
    /** 我的资料-兴趣标签-体育-户外 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='户外']")
    MobileElement hobbySportsType4;
    /** 我的资料-兴趣标签-体育-世界杯 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='世界杯']")
    MobileElement hobbySportsType5;

    /** 我的资料-兴趣标签-汽车-二手车 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='养生']")
    MobileElement hobbyCarType1;
    /** 我的资料-兴趣标签-汽车-保养 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='保养']")
    MobileElement hobbyCarType2;
    /** 我的资料-兴趣标签-汽车-新车 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='新车']")
    MobileElement hobbyCarType3;
    /** 我的资料-兴趣标签-汽车-摩托 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='摩托']")
    MobileElement hobbyCarType4;
    /** 我的资料-兴趣标签-汽车-兰博基尼 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='兰博基尼']")
    MobileElement hobbyCarType5;


    /** 我的资料-兴趣标签-健康-养生 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='家居']")
    MobileElement hobbyHealthType1;
    /** 我的资料-兴趣标签-健康-减肥 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='减肥']")
    MobileElement hobbyHealthType2;
    /** 我的资料-兴趣标签-健康-健身 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='健身']")
    MobileElement hobbyHealthType3;
    /** 我的资料-兴趣标签-健康-药品 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='药品']")
    MobileElement hobbyHealthType4;
    /** 我的资料-兴趣标签-健康-疾病 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_user_tag'][@text='疾病']")
    MobileElement hobbyHealthType5;


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
    /** 版本更新-用户协议-文本 */
    //@AndroidFindBy(xpath="//android.view.View[@content-desc='Tnaot用户协议']")
    @AndroidFindBy(xpath="//android.view.View[@content-desc='Tnaot用户协议']")
    MobileElement userAgreementText;
    /** 版本更新-用户协议-文本-返回按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/ib_back")
    MobileElement backButton;



    /** 版本更新-隐私条款 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_privacy_clause")
    MobileElement versionUpdatePrivacyClause;
    /** 版本更新-隐私条款-文本 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='隐私政策']")
    MobileElement privacyClauseText;

    /** 版本更新-关于我们 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_about")
    MobileElement versionUpdateAboutUS;
    /** 版本更新-关于我们-文本 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='邮箱：support@tnaot.com']")
    MobileElement aboutUSText;


}
