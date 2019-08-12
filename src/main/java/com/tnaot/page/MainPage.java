package com.tnaot.page;

import com.tnaot.core.AppiumBaseExecutor;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.support.PageFactory;

@Data
public class MainPage extends AppiumBaseExecutor {

    public MainPage(AppiumDriver<?> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    /** 生活Tab键 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_life")
    MobileElement rlLife;

    /** 定位弹窗-allow */
    @AndroidFindBy(id="com.android.packageinstaller:id/permission_allow_button")
    MobileElement allowButton;

    /** 定位弹窗-deny */
    @AndroidFindBy(id="com.android.packageinstaller:id/permission_deny_button")
    MobileElement denyButton;


    /** 首页-房地产 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_top_text'][@text='房地产']")
    MobileElement estateSubType;
    /** 首页-房地产-二手房 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='二手房']")
    MobileElement estateSubType1;
    /** 首页-房地产-新房 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='新房']")
    MobileElement estateSubType2;
    /** 首页-房地产-租房 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='租房']")
    MobileElement estateSubType3;
    /** 首页-房地产-写字楼 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='写字楼']")
    MobileElement estateSubType4;
    /** 首页-房地产-厂房 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='厂房']")
    MobileElement estateSubType5;
    /** 首页-房地产-仓库 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='仓库']")
    MobileElement estateSubType6;
    /** 首页-房地产-商铺 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='商铺']")
    MobileElement estateSubType7;
    /** 首页-房地产-土地 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='土地']")
    MobileElement estateSubType8;

    /** 首页-周边商家 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_top_text'][@text='周边商家']")
    MobileElement businessSubType;
    /** 首页-周边商家-美食 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='美食']")
    MobileElement businessSubType1;
    /** 首页-周边商家-娱乐 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='娱乐']")
    MobileElement businessSubType2;
    /** 首页-周边商家-旅行 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='旅行']")
    MobileElement businessSubType3;
    /** 首页-周边商家-购物 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='购物']")
    MobileElement businessSubType4;
    /** 首页-周边商家-健身 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='健身']")
    MobileElement businessSubType5;
    /** 首页-周边商家-医疗 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='医疗']")
    MobileElement businessSubType6;
    /** 首页-周边商家-教育 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='教育']")
    MobileElement businessSubType7;
    /** 首页-周边商家-服务 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='服务']")
    MobileElement businessSubType8;


    /** 首页-交易买卖 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_top_text'][@text='交易买卖']")
    MobileElement tradeSubType;
    /** 首页-交易买卖-手机/平板 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='手机/平板']")
    MobileElement tradeSubType1;
    /** 首页-交易买卖-电子数码 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='电子数码']")
    MobileElement tradeSubType2;
    /** 首页-交易买卖-家电 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='家电']")
    MobileElement tradeSubType3;
    /** 首页-交易买卖-汽车 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='汽车']")
    MobileElement tradeSubType4;
    /** 首页-交易买卖-摩托车 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='摩托车']")
    MobileElement tradeSubType5;
    /** 首页-交易买卖-服装 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='服装']")
    MobileElement tradeSubType6;
    /** 首页-交易买卖-家居 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='家居']")
    MobileElement tradeSubType7;
    /** 首页-交易买卖-更多分类 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='更多分类']")
    MobileElement tradeSubType8;


    /** 首页-折扣优惠 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_top_text'][@text='折扣优惠']")
    MobileElement discountSubType;
    /** 首页-折扣优惠-美食餐饮 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='美食餐饮']")
    MobileElement discountSubType1;
    /** 首页-折扣优惠-休闲娱乐 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='休闲娱乐']")
    MobileElement discountSubType2;
    /** 首页-折扣优惠-购物卖场 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='购物卖场']")
    MobileElement discountSubType3;
    /** 首页-折扣优惠-时尚女性 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='时尚女性']")
    MobileElement discountSubType4;
    /** 首页-折扣优惠-汽车服务 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='汽车服务']")
    MobileElement discountSubType5;
    /** 首页-折扣优惠-家居装饰 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='家居装饰']")
    MobileElement discountSubType6;
    /** 首页-折扣优惠-培训机构 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='培训机构']")
    MobileElement discountSubType7;
    /** 首页-折扣优惠-更多优惠 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='更多优惠']")
    MobileElement discountSubType8;

    /** 首页-便民服务 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_top_text'][@text='便民服务']")
    MobileElement serviceSubType;
    /** 首页-便民服务-手机充值 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='手机充值']")
    MobileElement serviceSubType1;
    /** 首页-便民服务-本地黄页 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='本地黄页']")
    MobileElement serviceSubType2;
    /** 首页-便民服务-柬文翻译 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='柬文翻译']")
    MobileElement serviceSubType3;
    /** 首页-便民服务-本地汇率 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='本地汇率']")
    MobileElement serviceSubType4;
    /** 首页-便民服务-出入境指南 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='出入境指南']")
    MobileElement serviceSubType5;
    /** 首页-便民服务-柬文学习 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='柬文学习']")
    MobileElement serviceSubType6;
    /** 首页-便民服务-一键报警 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='一键报警']")
    MobileElement serviceSubType7;
    /** 首页-便民服务-寻人求助 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='寻人求助']")
    MobileElement serviceSubType8;


    /** 首页-求职招聘 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_top_text'][@text='求职招聘']")
    MobileElement job;

    /** 首页-寻人求职 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_top_text'][@text='寻人求职']")
    MobileElement peopleForHelp;

    /** 首页-手机充值 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_top_text'][@text='手机充值']")
    MobileElement prePaidPhone;


    /** 首页-二手房 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_mid_text'][@text='二手房']")
    MobileElement secondTitle1;
    /** 首页-租房 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_mid_text'][@text='租房']")
    MobileElement secondTitle2;
    /** 首页-美食 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_mid_text'][@text='美食']")
    MobileElement secondTitle3;
    /** 首页-娱乐 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_mid_text'][@text='娱乐']")
    MobileElement secondTitle4;
    /** 首页-购物 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_mid_text'][@text='购物']")
    MobileElement secondTitle5;
    /** 首页-翻译 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_mid_text'][@text='翻译']")
    MobileElement secondTitle6;
    /** 首页-学柬语 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_mid_text'][@text='学柬语']")
    MobileElement secondTitle7;
    /** 首页-服务 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_mid_text'][@text='服务']")
    MobileElement secondTitle8;
    /** 首页-活动 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_mid_text'][@text='活动']")
    MobileElement secondTitle9;
    /** 首页-客服 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_mid_text'][@text='客服']")
    MobileElement secondTitle10;


    /** 发布按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_top_release")
    MobileElement topRelease;

    /** 发布动态 */
    @AndroidFindBy(xpath="//android.widget.TextView[@text='发布动态']")
    MobileElement sendDynamic;

    /** 发布交易 */
    @AndroidFindBy(xpath="//*[@text='发布交易']")
    MobileElement sendTransaction;
    /** 发布交易-返回 */
    @AndroidFindBy(id="com.tnaot.news:id/ivBack")
    MobileElement backButton;
    /** 发布交易-发布 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_send")
    MobileElement sendButton;
    /** 发布交易-标题 */
    @AndroidFindBy(id="com.tnaot.news:id/edit_title")
    MobileElement titleText;
    /** 发布交易-内容 */
    @AndroidFindBy(id="com.tnaot.news:id/edit_content")
    MobileElement contentText;

    /** 发布交易-上传图片 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_add_photo")
    MobileElement uploadPhoto;
    /** 发布交易-上传图片-拍照 */
    @AndroidFindBy(id="com.tnaot.news:id/ll_camera")
    MobileElement takePhoto;
    /** 发布交易-上传图片-从手机相册中选取 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_type_pick_photo")
    MobileElement photoAlbum;
    /** 发布交易-上传图片-取消 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_cancel")
    MobileElement dismissPhoto;
    /** 发布交易-上传图片-选择即将要上传的图片 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]")
    MobileElement uploadAlbumPhoto1;
    /** 发布交易-上传图片-选择即将要上传的图片 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[2]")
    MobileElement uploadAlbumPhoto2;
    /** 发布交易-上传图片-选择即将要上传的图片 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[3]")
    MobileElement uploadAlbumPhoto3;
    /** 发布交易-上传图片-选择即将要上传的图片 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[4]")
    MobileElement uploadAlbumPhoto4;
    /** 发布交易-上传图片-选取图片-完成 */
    @AndroidFindBy(id="com.tnaot.news:id/done")
    MobileElement donePhoto;



    /** 发布交易-交易买卖地址 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_location")
    MobileElement locationText;

    /** 发布交易-交易买卖地址-请选择省份 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_province")
    MobileElement proviceText;
    /** 发布交易-交易买卖地址-请选择省份-省份选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvName'][@text='金边']")
    MobileElement proviceText1;
    /** 发布交易-交易买卖地址-请选择省份-省份选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvName'][@text='西港']")
    MobileElement proviceText2;
    /** 发布交易-交易买卖地址-请选择省份-省份选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvName'][@text='柴桢']")
    MobileElement proviceText3;
    /** 发布交易-交易买卖地址-请选择省份-省份选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvName'][@text='贡布']")
    MobileElement proviceText4;
    /** 发布交易-交易买卖地址-请选择省份-省份选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvName'][@text='白马']")
    MobileElement proviceText5;
    /** 发布交易-交易买卖地址-请选择省份-省份选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvName'][@text='马德望']")
    MobileElement proviceText6;
    /** 发布交易-交易买卖地址-请选择省份-省份选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvName'][@text='干丹']")
    MobileElement proviceText7;
    /** 发布交易-交易买卖地址-请选择省份-省份选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvName'][@text='磅针']")
    MobileElement proviceText8;

    /** 发布交易-交易买卖地址-请选择省份-省份选择-保存 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_save")
    MobileElement saveButton;

    /** 发布交易-类型 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_release_second_hand_content")
    MobileElement transactionType;
    /** 发布交易-类型-手机/平板 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='手机/平板']")
    MobileElement transactionType1;
    /** 发布交易-类型-电脑 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='电脑']")
    MobileElement transactionType2;
    /** 发布交易-类型-电子数码 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='电子数码']")
    MobileElement transactionType3;
    /** 发布交易-类型-服装 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='服装']")
    MobileElement transactionType4;
    /** 发布交易-类型-书籍 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='书籍']")
    MobileElement transactionType5;
    /** 发布交易-类型-家具 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='家具']")
    MobileElement transactionType6;
    /** 发布交易-类型-宠物 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='宠物']")
    MobileElement transactionType7;
    /** 发布交易-类型-食品 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='食品']")
    MobileElement transactionType8;
    /** 发布交易-类型-办公设备 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='办公设备']")
    MobileElement transactionType9;
    /** 发布交易-类型-文体户外 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='文体户外']")
    MobileElement transactionType10;
    /** 发布交易-类型-家电 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='家电']")
    MobileElement transactionType11;
    /** 发布交易-类型-美容保障 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='美容保障']")
    MobileElement transactionType12;

    /** 发布交易-价格 */
    @AndroidFindBy(id="com.tnaot.news:id/edit_release_price_content")
    MobileElement priceText;
    /** 发布交易-输入价格 */
    @AndroidFindBy(id="com.tnaot.news:id/edit_price_custom")
    MobileElement inputPrice;
    /** 发布交易-保存价格 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_save")
    MobileElement savePrice;
    /** 联系方式-电话 */
    @AndroidFindBy(id="com.tnaot.news:id/etPhone")
    MobileElement telephoneText;
    /** 联系方式-微信 */
    @AndroidFindBy(id="com.tnaot.news:id/etWeChat")
    MobileElement wechatText;
    /** 联系方式-邮箱 */
    @AndroidFindBy(id="com.tnaot.news:id/etEmail")
    MobileElement emailText;
    /** 联系方式-Facebook */
    @AndroidFindBy(id="com.tnaot.news:id/etFaceBook")
    MobileElement facebookText;


    /** 发布求职招聘 */
    @AndroidFindBy(xpath="//android.widget.TextView[@text='发布求职招聘']")
    MobileElement sendJob;
    /** 发布求职招聘-求职者位置 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_location_content")
    MobileElement locationContent;
    /** 发布求职招聘-求职者位置-请选择省份 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_province")
    MobileElement chooseProvince;
//    /** 发布求职招聘-求职者位置-请选择省份-选择省份 */
//    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvName'][@text='金边']")
//    MobileElement sendJob;
    /** 发布求职招聘-求职者位置-详细地址 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_detail_location")
    MobileElement detailLocation;
    /** 发布求职招聘-求职者位置-详细地址-输入小区/写字楼/商品房 */
    @AndroidFindBy(id="com.tnaot.news:id/etSearch")
    MobileElement inputSearch;
    /** 发布求职招聘-求职者位置-详细地址-输入小区/写字楼/商品房-查找 */
    @AndroidFindBy(id="com.tnaot.news:id/tvSearch")
    MobileElement searchButton;
    /** 发布求职招聘-求职者位置-详细地址-拖动地图定位 */
    @AndroidFindBy(id="com.tnaot.news:id/btnGoMap")
    MobileElement btnGoMap;



    /** 发布求职招聘-我要-求职 */
    @AndroidFindBy(id="com.tnaot.news:id/rb_job_wanted")
    MobileElement jobWanted;
    /** 发布求职招聘-我要-招聘 */
    @AndroidFindBy(id="com.tnaot.news:id/rb_recruit")
    MobileElement jobRecruit;
    /** 发布求职招聘-职位 */
    @AndroidFindBy(id="com.tnaot.news:id/et_position_content")
    MobileElement positionText;
    /** 发布求职招聘-类型 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_release_job_content")
    MobileElement jobType;
    /** 发布求职招聘-类型-求职招聘类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='技工/保养']")
    MobileElement jobType1;
    /** 发布求职招聘-类型-求职招聘类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='交货/仓储']")
    MobileElement jobType2;
    /** 发布求职招聘-类型-求职招聘类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='市场营销']")
    MobileElement jobType3;
    /** 发布求职招聘-类型-求职招聘类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='媒体广告']")
    MobileElement jobType4;
    /** 发布求职招聘-类型-求职招聘类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='医疗健康护理']")
    MobileElement jobType5;
    /** 发布求职招聘-类型-求职招聘类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='跟单/采购']")
    MobileElement jobType6;
    /** 发布求职招聘-类型-求职招聘类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='操作/生产']")
    MobileElement jobType7;
    /** 发布求职招聘-类型-求职招聘类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='度假村/赌场']")
    MobileElement jobType8;
    /** 发布求职招聘-类型-求职招聘类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='销售']")
    MobileElement jobType9;
    /** 发布求职招聘-类型-求职招聘类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='律师/法务']")
    MobileElement jobType10;
    /** 发布求职招聘-类型-求职招聘类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='翻译']")
    MobileElement jobType11;
    /** 发布求职招聘-类型-求职招聘类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='旅行社']")
    MobileElement jobType12;

    /** 发布求职招聘-月薪-请选择薪资区间 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_release_salary_content")
    MobileElement salaryText;
    /** 发布求职招聘-月薪-请选择薪资区间-月薪选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='面议']")
    MobileElement salaryType1;
    /** 发布求职招聘-月薪-请选择薪资区间-月薪选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='$ 100-180']")
    MobileElement salaryType2;
    /** 发布求职招聘-月薪-请选择薪资区间-月薪选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='$ 180-250']")
    MobileElement salaryType3;
    /** 发布求职招聘-月薪-请选择薪资区间-月薪选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='$ 250-500']")
    MobileElement salaryType4;
    /** 发布求职招聘-月薪-请选择薪资区间-月薪选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='$ 500-800']")
    MobileElement salaryType5;
    /** 发布求职招聘-月薪-请选择薪资区间-月薪选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='$ 800-1200']")
    MobileElement salaryType6;
    /** 发布求职招聘-月薪-请选择薪资区间-月薪选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='$ 1200-2000']")
    MobileElement salaryType7;
    /** 发布求职招聘-月薪-请选择薪资区间-月薪选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='$ 2000-3000']")
    MobileElement salaryType8;
    /** 发布求职招聘-月薪-请选择薪资区间-月薪选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='$ 3000-5000']")
    MobileElement salaryType9;
    /** 发布求职招聘-月薪-请选择薪资区间-月薪选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='$ 5000+']")
    MobileElement salaryType10;


    /** 发布求职招聘-月薪-面议 */
    @AndroidFindBy(id="com.tnaot.news:id/cb_face_to_face")
    MobileElement salaryFace;



    /** 发布优惠 */
    @AndroidFindBy(xpath="//android.widget.TextView[@text='发布优惠']")
    MobileElement sendDiscount;
    /** 发布优惠-类型 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_release_discount_content")
    MobileElement discountType;
    /** 发布优惠-类型-折扣优惠类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='美食餐饮']")
    MobileElement discountType1;
    /** 发布优惠-类型-折扣优惠类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='休闲娱乐']")
    MobileElement discountType2;
    /** 发布优惠-类型-折扣优惠类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='婚庆服务']")
    MobileElement discountType3;
    /** 发布优惠-类型-折扣优惠类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='家居装饰']")
    MobileElement discountType4;
    /** 发布优惠-类型-折扣优惠类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='购物卖场']")
    MobileElement discountType5;
    /** 发布优惠-类型-折扣优惠类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='时尚女性']")
    MobileElement discountType6;
    /** 发布优惠-类型-折扣优惠类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='汽车服务']")
    MobileElement discountType7;
    /** 发布优惠-类型-折扣优惠类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='培训机构']")
    MobileElement discountType8;
    /** 发布优惠-类型-折扣优惠类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='旅游酒店']")
    MobileElement discountType9;
    /** 发布优惠-类型-折扣优惠类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='亲子母婴']")
    MobileElement discountType10;
    /** 发布优惠-类型-折扣优惠类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='健身美体']")
    MobileElement discountType11;
    /** 发布优惠-类型-折扣优惠类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='服装']")
    MobileElement discountType12;



    /** 发布房地产 */
    @AndroidFindBy(xpath="//android.widget.TextView[@text='发布房地产']")
    MobileElement sendEstate;
    /** 发布房地产-出售 */
    @AndroidFindBy(id="com.tnaot.news:id/ivEstateSaleMethod1")
    MobileElement estateSell;
    /** 发布房地产-出租 */
    @AndroidFindBy(id="com.tnaot.news:id/ivEstateSaleMethod2")
    MobileElement estateRent;
    /** 发布房地产-出售-上传照片 */
    @AndroidFindBy(id="com.tnaot.news:id/llUploadImage")
    MobileElement uploadImage;

    /** 发布房地产-出售-上传照片-完成 */
    @AndroidFindBy(id="com.tnaot.news:id/tvComplete")
    MobileElement tvComplete;


    /** 发布房地产-出售-标题 */
    @AndroidFindBy(id="com.tnaot.news:id/edit_title")
    MobileElement sellTitle;

    /** 发布房地产-出售-类别 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_release_estate_content")
    MobileElement estateCategoryType;
    /** 发布房地产-出售-类别-选择发布类别 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='二手房']")
    MobileElement estateCategoryType1;
    /** 发布房地产-出售-类别-选择发布类别 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='新房']")
    MobileElement estateCategoryType2;
    /** 发布房地产-出售-类别-选择发布类别 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='写字楼']")
    MobileElement estateCategoryType3;
    /** 发布房地产-出售-类别-选择发布类别 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='厂房']")
    MobileElement estateCategoryType4;
    /** 发布房地产-出售-类别-选择发布类别 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='仓库']")
    MobileElement estateCategoryType5;
    /** 发布房地产-出售-类别-选择发布类别 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='商铺']")
    MobileElement estateCategoryType6;
    /** 发布房地产-出售-类别-选择发布类别 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='土地']")
    MobileElement estateCategoryType7;


    /** 发布房地产-出售-类型 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_release_estate_content2")
    MobileElement estateSellType;
    /** 发布房地产-出售-类型-选择产品类型 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='普通住宅']")
    MobileElement estateSellType1;
    /** 发布房地产-出售-类型-选择产品类型 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='别墅']")
    MobileElement estateSellType2;
    /** 发布房地产-出售-类型-选择产品类型 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='双子别墅']")
    MobileElement estateSellType3;
    /** 发布房地产-出售-类型-选择产品类型 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='排屋']")
    MobileElement estateSellType4;
    /** 发布房地产-出售-类型-选择产品类型 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='联排别墅']")
    MobileElement estateSellType5;
    /** 发布房地产-出售-类型-选择产品类型 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='公寓']")
    MobileElement estateSellType6;
    /** 发布房地产-出售-类型-选择产品类型 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='可出租式公寓']")
    MobileElement estateSellType7;
    /** 发布房地产-出售-类型-选择产品类型 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='酒店式公寓']")
    MobileElement estateSellType8;
    /** 发布房地产-出售-类型-选择产品类型 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='单间']")
    MobileElement estateSellType9;


    /** 发布房地产-出售-价格 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_release_price_content")
    MobileElement sellPrice;
    /** 发布房地产-出售-面积 */
    @AndroidFindBy(id="com.tnaot.news:id/edit_release_estate_area_content")
    MobileElement sellArea;
    /** 发布房地产-出售-房产地址 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_release_detail_address_content")
    MobileElement sellAddress;
    /** 发布房地产-出售-联系人 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_contact_content")
    MobileElement sellContact;
    /** 发布房地产-出售-房屋描述 */
    @AndroidFindBy(id="com.tnaot.news:id/edit_contact_des")
    MobileElement sellDescription;




    /** 商家入驻 */
    @AndroidFindBy(xpath="//android.widget.TextView[@text='商家入驻']")
    MobileElement sendBusiness;
    /** 商家入驻-类型 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_release_discount_content")
    MobileElement businessType;
    /** 商家入驻-类型-美食 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='美食']")
    MobileElement businessType1;
    /** 商家入驻-类型-娱乐 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='娱乐']")
    MobileElement businessType2;
    /** 商家入驻-类型-旅行 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='旅行']")
    MobileElement businessType3;
    /** 商家入驻-类型-购物 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='购物']")
    MobileElement businessType4;
    /** 商家入驻-类型-健身 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='健身']")
    MobileElement businessType5;
    /** 商家入驻-类型-医疗 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='医疗']")
    MobileElement businessType6;
    /** 商家入驻-类型-教育 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='教育']")
    MobileElement businessType7;
    /** 商家入驻-类型-服务 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='服务']")
    MobileElement businessType8;

    /** 商家入驻-参考价格 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_province_content")
    MobileElement referencePrice;





    /** 寻人求助 */
    @AndroidFindBy(xpath="//android.widget.TextView[@text='寻人求助']")
    MobileElement sendHelp;
    /** 寻人求助-类型 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_type")
    MobileElement helpType;
    /** 寻人求助-类型-寻人 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='寻人']")
    MobileElement helpType1;
    /** 寻人求助-类型-寻物 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='寻物']")
    MobileElement helpType2;
    /** 寻人求助-类型-求助 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='求助']")
    MobileElement helpType3;

    /** 我要爆料 */
    @AndroidFindBy(xpath="//android.widget.TextView[@text='我要爆料']")
    MobileElement sendFact;

    /** 商业互助 */
    @AndroidFindBy(xpath="//android.widget.TextView[@text='商业互助']")
    MobileElement sendBusinessHelp;

    /** 发布类型-取消按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/pop_rl_click")
    MobileElement dismissButton;




}
