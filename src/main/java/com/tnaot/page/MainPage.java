package com.tnaot.page;

import com.tnaot.anotation.FindElementBy;
import com.tnaot.core.AppiumBaseExecutor;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class MainPage extends AppiumBaseExecutor {

    public MainPage(AppiumDriver<?> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    /** 生活Tab键 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_life")
    WebElement rlLife;

    /** 定位弹窗-allow */
    @AndroidFindBy(id="com.android.packageinstaller:id/permission_allow_button")
    WebElement allowButton;

    /** 定位弹窗-deny */
    @AndroidFindBy(id="com.android.packageinstaller:id/permission_deny_button")
    WebElement denyButton;


    /** 首页-房地产 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_top_text'][@text='房地产']")
    WebElement estateSubType;
    /** 首页-房地产-二手房 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[2]/div/div[2]/div[2]/ul/li[1]", isWeb = true)
    WebElement estateSubType1;
    /** 首页-房地产-新房 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[2]/div/div[2]/div[2]/ul/li[2]", isWeb = true)
    WebElement estateSubType2;
    /** 首页-房地产-租房 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[2]/div/div[2]/div[2]/ul/li[3]", isWeb = true)
    WebElement estateSubType3;
    /** 首页-房地产-写字楼 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[2]/div/div[2]/div[2]/ul/li[4]", isWeb = true)
    WebElement estateSubType4;
    /** 首页-房地产-厂房 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[2]/div/div[2]/div[2]/ul/li[5]", isWeb = true)
    WebElement estateSubType5;
    /** 首页-房地产-仓库 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[2]/div/div[2]/div[2]/ul/li[6]", isWeb = true)
    WebElement estateSubType6;
    /** 首页-房地产-商铺 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[2]/div/div[2]/div[2]/ul/li[7]", isWeb = true)
    WebElement estateSubType7;
    /** 首页-房地产-土地 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[2]/div/div[2]/div[2]/ul/li[8]", isWeb = true)
    WebElement estateSubType8;

    /** 首页-房地产-列表-标题 */
    @FindElementBy(type = "className", value="item-title", isWeb = true)
    WebElement estateListTitle;
    /** 首页-房地产-列表-面议方式 */
    @FindElementBy(type = "className", value="money", isWeb = true)
    WebElement estateListDiscussType;
    /** 首页-房地产-列表-更多 */
    @FindElementBy(type = "className", value="more", isWeb = true)
    WebElement estateListMore;
    /** 首页-房地产-列表-更多-收藏 */
    @FindElementBy(type = "xpath", value="//span[contains(text(),'收藏')]", isWeb = true)
    WebElement estateListMoreCollect;
    /** 首页-房地产-列表-更多-举报 */
    @FindElementBy(type = "xpath", value="//span[contains(text(),'举报')]", isWeb = true)
    WebElement estateListMoreReport;
    /** 首页-房地产-列表-更多-举报-虚假广告 */
    @FindElementBy(type = "xpath", value="//span[contains(text(),'虚假广告')]", isWeb = true)
    WebElement estateListMoreReportReason1;
    /** 首页-房地产-列表-更多-举报-低俗色情 */
    @FindElementBy(type = "xpath", value="//span[contains(text(),'低俗色情')]", isWeb = true)
    WebElement estateListMoreReportReason2;
    /** 首页-房地产-列表-更多-举报-垃圾内容 */
    @FindElementBy(type = "xpath", value="//span[contains(text(),'垃圾内容')]", isWeb = true)
    WebElement estateListMoreReportReason3;
    /** 首页-房地产-列表-更多-举报-确定 */
    @FindElementBy(type = "xpath", value="//span[contains(text(),'确定')]", isWeb = true)
    WebElement estateListMoreReportAccept;
    /** 首页-房地产-列表-更多-转发 */
    @FindElementBy(type = "xpath", value="//span[contains(text(),'转发')]", isWeb = true)
    WebElement estateListMorePublish;

    /** 首页-房地产-列表详情-返回 */
    @FindElementBy(type = "className", value="back", isWeb = true)
    WebElement estateListDetailBack;
    /** 首页-房地产-列表详情-收藏 */
    @FindElementBy(type = "className", value="headerIcon", isWeb = true)
    WebElement estateListDetailCollect;
    /** 首页-房地产-列表详情-更多 */
    @FindElementBy(type = "className", value="headerMoreIcon", isWeb = true)
    WebElement estateListDetailMore;

//    /** 首页-房地产-列表详情-标题 */
//    @FindElementBy(type = "className", value="font-house-contactTitle", isWeb = true)
//    WebElement estateListMore;
//    /** 首页-房地产-列表详情-出售方式 */
//    @FindElementBy(type = "className", value="more", isWeb = true)
//    WebElement estateListMore;
//    /** 首页-房地产-列表详情-面议方式 */
//    @FindElementBy(type = "className", value="more", isWeb = true)
//    WebElement estateListMore;







    /** 首页-周边商家 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_top_text'][@text='周边商家']")
    WebElement businessSubType;
    /** 首页-周边商家-美食 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[2]/div/div[2]/div[2]/ul/li[1]", isWeb = true)
    WebElement businessSubType1;
    /** 首页-周边商家-娱乐 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[2]/div/div[2]/div[2]/ul/li[2]", isWeb = true)
    WebElement businessSubType2;
    /** 首页-周边商家-旅行 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[2]/div/div[2]/div[2]/ul/li[3]", isWeb = true)
    WebElement businessSubType3;
    /** 首页-周边商家-购物 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[2]/div/div[2]/div[2]/ul/li[4]", isWeb = true)
    WebElement businessSubType4;
    /** 首页-周边商家-健身 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[2]/div/div[2]/div[2]/ul/li[5]", isWeb = true)
    WebElement businessSubType5;
    /** 首页-周边商家-医疗 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[2]/div/div[2]/div[2]/ul/li[6]", isWeb = true)
    WebElement businessSubType6;
    /** 首页-周边商家-教育 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[2]/div/div[2]/div[2]/ul/li[7]", isWeb = true)
    WebElement businessSubType7;
    /** 首页-周边商家-服务 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[2]/div/div[2]/div[2]/ul/li[8]", isWeb = true)
    WebElement businessSubType8;


    /** 首页-交易买卖 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_top_text'][@text='交易买卖']")
    WebElement tradeSubType;
    /** 首页-交易买卖-手机/平板 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[1]/div/div[2]/ul/li[1]", isWeb = true)
    WebElement tradeSubType1;
    /** 首页-交易买卖-电子数码 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[1]/div/div[2]/ul/li[2]", isWeb = true)
    WebElement tradeSubType2;
    /** 首页-交易买卖-家电 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[1]/div/div[2]/ul/li[3]", isWeb = true)
    WebElement tradeSubType3;
    /** 首页-交易买卖-汽车 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[1]/div/div[2]/ul/li[4]", isWeb = true)
    WebElement tradeSubType4;
    /** 首页-交易买卖-摩托车 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[1]/div/div[2]/ul/li[5]", isWeb = true)
    WebElement tradeSubType5;
    /** 首页-交易买卖-服装 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[1]/div/div[2]/ul/li[6]", isWeb = true)
    WebElement tradeSubType6;
    /** 首页-交易买卖-家居 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[1]/div/div[2]/ul/li[7]", isWeb = true)
    WebElement tradeSubType7;
    /** 首页-交易买卖-更多分类 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[1]/div/div[2]/ul/li[8]", isWeb = true)
    WebElement tradeSubType8;
    /** 首页-交易买卖-生活资讯列表第一条-标题 */
    @FindElementBy(type = "className", value="money", isWeb = true)
    WebElement tradeLifeListTitle;
    /** 首页-交易买卖-生活资讯列表第二条-标题 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[3]/div/ul/li[2]/div/div[1]/h2", isWeb = true)
    WebElement tradeLifeListTitle2;






    /** 首页-折扣优惠 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_top_text'][@text='折扣优惠']")
    WebElement discountSubType;
    /** 首页-折扣优惠-美食餐饮 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[1]/div/div[2]/ul/li[1]", isWeb = true)
    WebElement discountSubType1;
    /** 首页-折扣优惠-休闲娱乐 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[1]/div/div[2]/ul/li[2]", isWeb = true)
    WebElement discountSubType2;
    /** 首页-折扣优惠-购物卖场 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[1]/div/div[2]/ul/li[3]", isWeb = true)
    WebElement discountSubType3;
    /** 首页-折扣优惠-时尚女性 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[1]/div/div[2]/ul/li[4]", isWeb = true)
    WebElement discountSubType4;
    /** 首页-折扣优惠-汽车服务 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[1]/div/div[2]/ul/li[5]", isWeb = true)
    WebElement discountSubType5;
    /** 首页-折扣优惠-家居装饰 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[1]/div/div[2]/ul/li[6]", isWeb = true)
    WebElement discountSubType6;
    /** 首页-折扣优惠-培训机构 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[1]/div/div[2]/ul/li[7]", isWeb = true)
    WebElement discountSubType7;
    /** 首页-折扣优惠-更多优惠 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[1]/div/div[2]/ul/li[8]", isWeb = true)
    WebElement discountSubType8;
    /** 首页-折扣优惠-生活资讯列表第一条-标题 */
    @FindElementBy(type = "className", value="list-tail", isWeb = true)
    WebElement discountLifeListTitle;
    /** 首页-折扣优惠-生活资讯列表第二条-标题 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[2]/div[2]/div[1]/div/ul/li[2]/div[1]/p[2]", isWeb = true)
    WebElement discountLifeListTitle2;


    /** 首页-便民服务 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_top_text'][@text='便民服务']")
    WebElement serviceSubType;
    /** 首页-便民服务-手机充值 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[1]/div[2]/ul/li[1]", isWeb = true)
    WebElement serviceSubType1;
    /** 首页-便民服务-手机充值-输入要充值的手机号码 */
    @FindElementBy(type = "xpath", value="//android.widget.EditText[@content-desc='输入要充值的手机号码']")
    WebElement serviceSubType1InputTelephone;
    /** 首页-便民服务-手机充值-充值金额 */
    @FindElementBy(type = "xpath", value="//android.view.View[@content-desc='充值金额']")
    WebElement serviceSubType1PayMoney;
    /** 首页-便民服务-手机充值-更多服务 */
    @FindElementBy(type = "xpath", value="//android.view.View[@content-desc='更多服务']")
    WebElement serviceSubType1MoreService;
    /** 首页-便民服务-手机充值-充值说明 */
    @FindElementBy(type = "xpath", value="//android.view.View[@content-desc='充值说明']")
    WebElement serviceSubType1PayIntroduce;

    /** 首页-便民服务-本地黄页 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[1]/div[2]/ul/li[2]", isWeb = true)
    WebElement serviceSubType2;
    /** 首页-便民服务-本地黄页-应急电话 */
    @FindElementBy(type = "xpath", value = "//android.view.View[@content-desc='应急电话']")
    WebElement serviceSubType2Tab1;
    /** 首页-便民服务-本地黄页-应急电话-标题 */
    @FindElementBy(type = "className", value = "name", isWeb = true )
    WebElement serviceSubType2ListTitle;
    /** 首页-便民服务-本地黄页-应急电话-电话图标 */
    @FindElementBy(type = "xpath", value = "//android.widget.Image[@content-desc='phone@2x']")
    WebElement serviceSubType2PhoneIcon;
    /** 首页-便民服务-本地黄页-政府 */
    @FindElementBy(type = "xpath", value = "//android.view.View[@content-desc='政府']" )
    WebElement serviceSubType2Tab2;
    /** 首页-便民服务-本地黄页-商会 */
    @FindElementBy(type = "xpath", value = "//android.view.View[@content-desc='商会']")
    WebElement serviceSubType2Tab3;
    /** 首页-便民服务-本地黄页-学校 */
    @FindElementBy(type = "xpath", value = "//android.view.View[@content-desc='学校']")
    WebElement serviceSubType2Tab4;
    /** 首页-便民服务-本地黄页-航空公司 */
    @FindElementBy(type = "xpath", value = "//android.view.View[@content-desc='航空公司']")
    WebElement serviceSubType2Tab5;
    /** 首页-便民服务-本地黄页-医院 */
    @FindElementBy(type = "xpath", value = "//android.view.View[@content-desc='医院']")
    WebElement serviceSubType2Tab6;

    /** 首页-便民服务-柬文翻译 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[1]/div[2]/ul/li[3]", isWeb = true)
    WebElement serviceSubType3;
    /** 首页-便民服务-本地汇率 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[1]/div[2]/ul/li[4]", isWeb = true)
    WebElement serviceSubType4;
    /** 首页-便民服务-本地汇率-美元 */
    @FindElementBy(type = "xpath", value="//android.view.View[@content-desc='美元']")
    WebElement serviceSubType4Tab1;
    /** 首页-便民服务-本地汇率-人民币 */
    @FindElementBy(type = "xpath", value="//android.view.View[@content-desc='人民币']")
    WebElement serviceSubType4Tab2;
    /** 首页-便民服务-本地汇率-瑞尔 */
    @FindElementBy(type = "xpath", value="//android.view.View[@content-desc='瑞尔']")
    WebElement serviceSubType4Tab3;


    /** 首页-便民服务-出入境指南 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[1]/div[2]/ul/li[5]", isWeb = true)
    WebElement serviceSubType5;
    /** 首页-便民服务-出入境指南-落地签表单 */
    @FindElementBy(type = "xpath", value="//android.view.View[@content-desc='落地签表单']")
    WebElement serviceSubType5Tab1;
    /** 首页-便民服务-出入境指南-出入境单 */
    @FindElementBy(type = "xpath", value="//android.view.View[@content-desc='出入境单']")
    WebElement serviceSubType5Tab2;
    /** 首页-便民服务-出入境指南-申报单 */
    @FindElementBy(type = "xpath", value="//android.view.View[@content-desc='申报单']")
    WebElement serviceSubType5Tab3;


    /** 首页-便民服务-柬文学习 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[1]/div[2]/ul/li[6]", isWeb = true)
    WebElement serviceSubType6;
    /** 首页-便民服务-一键报警 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[1]/div[2]/ul/li[7]", isWeb = true)
    WebElement serviceSubType7;
    /** 首页-便民服务-一键报警-联系电话弹窗 */
    @FindElementBy(type = "className", value="alarm", isWeb = true)
    WebElement serviceSubType7Overlay;
    /** 首页-便民服务-一键报警-联系电话弹窗关闭按钮 */
    @FindElementBy(type = "className", value="cancel", isWeb = true)
    WebElement serviceSubType7OverlayCloseButton;


    /** 首页-便民服务-寻人求助 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[1]/div[2]/ul/li[8]", isWeb = true)
    WebElement serviceSubType8;


    /** 首页-求职招聘 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_top_text'][@text='求职招聘']")
    WebElement job;
    /** 首页-求职招聘-销售 */
    @FindElementBy(type = "xpath", value = "//span[contains(text(),'销售')]", isWeb = true )
    WebElement jobSubType1;
    /** 首页-求职招聘-建筑/工程 */
    @FindElementBy(type = "xpath", value = "//span[contains(text(),'建筑/工程')]", isWeb = true )
    WebElement jobSubType2;
    /** 首页-求职招聘-行政 */
    @FindElementBy(type = "xpath", value = "//span[contains(text(),'行政')]", isWeb = true )
    WebElement jobSubType3;
    /** 首页-求职招聘-司机/保安 */
    @FindElementBy(type = "xpath", value = "//span[contains(text(),'司机/保安')]", isWeb = true )
    WebElement jobSubType4;
    /** 首页-求职招聘-技工/保养 */
    @FindElementBy(type = "xpath", value = "//span[contains(text(),'技工/保养')]", isWeb = true )
    WebElement jobSubType5;
    /** 首页-求职招聘-操作/生产 */
    @FindElementBy(type = "xpath", value = "//span[contains(text(),'操作/生产')]", isWeb = true )
    WebElement jobSubType6;
    /** 首页-求职招聘-教育培训 */
    @FindElementBy(type = "xpath", value = "//span[contains(text(),'教育培训')]", isWeb = true )
    WebElement jobSubType7;
    /** 首页-求职招聘-更多分类 */
    @FindElementBy(type = "xpath", value = "//span[contains(text(),'更多分类')]", isWeb = true )
    WebElement jobSubType8;
    /** 首页-求职招聘-生活资讯列表第一条-标题 */
    @FindElementBy(type = "className", value="price", isWeb = true)
    WebElement jobLifeListTitle;
    /** 首页-求职招聘-生活资讯列表第二条-标题 */
    @FindElementBy(type = "xpath", value="//*[@id='app']/div[2]/div[3]/div/ul/li[2]/div/div[1]/h2", isWeb = true)
    WebElement jobLifeListTitle2;
    /** 首页-求职招聘-二级页面-返回按钮 */
    @FindElementBy(type = "className", value="sea-return", isWeb = true)
    WebElement backFromTwoToOne;


    /** 首页-寻人求职 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_top_text'][@text='寻人求职']")
    WebElement peopleForHelp;

    /** 首页-手机充值 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_top_text'][@text='手机充值']")
    WebElement prePaidPhone;


    /** 首页-二手房 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_mid_text'][@text='二手房']")
    WebElement secondTitle1;
    /** 首页-美食、娱乐、购物、服务 */
    @FindElementBy(type = "className", value = "headerText", isWeb = true )
    //@FindElementBy(type = "xpath", value = "//span[contains(text(),'美食')]", isWeb = true )
    WebElement secondTitle1ListHeader;
    /** 首页-美食、娱乐、购物、服务 */
    @FindElementBy(type = "className", value = "mer-name", isWeb = true )
    WebElement secondTitle1ListTitle;

    /** 首页-租房 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_mid_text'][@text='租房']")
    WebElement secondTitle2;
    /** 首页-美食 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_mid_text'][@text='美食']")
    WebElement secondTitle3;
    /** 首页-娱乐 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_mid_text'][@text='娱乐']")
    WebElement secondTitle4;
    /** 首页-购物 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_mid_text'][@text='购物']")
    WebElement secondTitle5;
    /** 首页-翻译 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_mid_text'][@text='翻译']")
    WebElement secondTitle6;
    /** 首页-学柬语 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_mid_text'][@text='学柬语']")
    WebElement secondTitle7;
    /** 首页-学柬语-酒店宾馆*/
    @FindElementBy(type = "xpath", value = "//span[contains(text(),'酒店宾馆')]", isWeb = true )
    WebElement secondTitle7List1;
    /** 首页-学柬语-通讯邮寄*/
    @FindElementBy(type = "xpath", value = "//span[contains(text(),'通讯邮寄')]", isWeb = true )
    WebElement secondTitle7List2;
    /** 首页-学柬语-娱乐体育*/
    @FindElementBy(type = "xpath", value = "//span[contains(text(),'娱乐体育')]", isWeb = true )
    WebElement secondTitle7List3;
    /** 首页-学柬语-美食购物*/
    @FindElementBy(type = "xpath", value = "//span[contains(text(),'美食购物')]", isWeb = true )
    WebElement secondTitle7List4;
    /** 首页-学柬语-健康看病*/
    @FindElementBy(type = "xpath", value = "//span[contains(text(),'健康看病')]", isWeb = true )
    WebElement secondTitle7List5;
    /** 首页-学柬语-地理方位*/
    @FindElementBy(type = "xpath", value = "//span[contains(text(),'地理方位')]", isWeb = true )
    WebElement secondTitle7List6;
    /** 首页-学柬语-会客拜访*/
    @FindElementBy(type = "xpath", value = "//span[contains(text(),'会客拜访')]", isWeb = true )
    WebElement secondTitle7List7;
    /** 首页-学柬语-数字表达*/
    @FindElementBy(type = "xpath", value = "//span[contains(text(),'数字表达')]", isWeb = true )
    WebElement secondTitle7List8;
    /** 首页-学柬语-宗教节日*/
    @FindElementBy(type = "xpath", value = "//span[contains(text(),'宗教节日')]", isWeb = true )
    WebElement secondTitle7List9;
    /** 首页-学柬语-咨询问询*/
    @FindElementBy(type = "xpath", value = "//span[contains(text(),'咨询问询')]", isWeb = true )
    WebElement secondTitle7List10;
    /** 首页-学柬语-时间日期*/
    @FindElementBy(type = "xpath", value = "//span[contains(text(),'时间日期')]", isWeb = true )
    WebElement secondTitle7List11;
    /** 首页-学柬语-问候祝福*/
    @FindElementBy(type = "xpath", value = "//span[contains(text(),'问候祝福')]", isWeb = true )
    WebElement secondTitle7List12;
    /** 首页-学柬语-地名地点*/
    @FindElementBy(type = "xpath", value = "//span[contains(text(),'地名地点')]", isWeb = true )
    WebElement secondTitle7List13;
    /** 首页-学柬语-安全报警*/
    @FindElementBy(type = "xpath", value = "//span[contains(text(),'安全报警')]", isWeb = true )
    WebElement secondTitle7List14;
    /** 首页-学柬语-交通运输*/
    @FindElementBy(type = "xpath", value = "//span[contains(text(),'交通运输')]", isWeb = true )
    WebElement secondTitle7List15;
    /** 首页-学柬语-天气气象*/
    @FindElementBy(type = "xpath", value = "//span[contains(text(),'天气气象')]", isWeb = true )
    WebElement secondTitle7List16;

    /** 首页-服务 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_mid_text'][@text='服务']")
    WebElement secondTitle8;
    /** 首页-活动 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_mid_text'][@text='活动']")
    WebElement secondTitle9;
    /** 首页-客服 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_mid_text'][@text='客服']")
    WebElement secondTitle10;


    /** 首页-手机充值 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_bottom_icon_title'][@text='手机充值']")
    WebElement additional1;
    /** 首页-租车打车 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_bottom_icon_title'][@text='租车打车']")
    WebElement additional2;
    /** 首页-商家入驻 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_bottom_icon_title'][@text='商家入驻']")
    WebElement additional3;
    /** 首页-新闻爆料 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_bottom_icon_title'][@text='新闻爆料']")
    WebElement additional4;





    /** 发布按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_top_release")
    WebElement topRelease;

    /** 发布动态 */
    @AndroidFindBy(xpath="//android.widget.TextView[@text='发布动态']")
    WebElement sendDynamic;

    /** 发布交易 */
    @AndroidFindBy(xpath="//*[@text='发布交易']")
    WebElement sendTransaction;
    /** 发布交易-返回 */
    @AndroidFindBy(id="com.tnaot.news:id/ivBack")
    WebElement backButton;
    /** 发布交易-发布 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_send")
    WebElement sendButton;
    /** 发布交易-标题 */
    @AndroidFindBy(id="com.tnaot.news:id/edit_title")
    WebElement titleText;
    /** 发布交易-内容 */
    @AndroidFindBy(id="com.tnaot.news:id/edit_content")
    WebElement contentText;

    /** 发布交易-上传图片 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_add_photo")
    WebElement uploadPhoto;
    /** 发布交易-上传图片-拍照 */
    @AndroidFindBy(id="com.tnaot.news:id/ll_camera")
    WebElement takePhoto;
    /** 发布交易-上传图片-从手机相册中选取 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_type_pick_photo")
    WebElement photoAlbum;
    /** 发布交易-上传图片-取消 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_cancel")
    WebElement dismissPhoto;
    /** 发布交易-上传图片-选择即将要上传的图片 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]")
    WebElement uploadAlbumPhoto1;
    /** 发布交易-上传图片-选择即将要上传的图片 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[2]")
    WebElement uploadAlbumPhoto2;
    /** 发布交易-上传图片-选择即将要上传的图片 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[3]")
    WebElement uploadAlbumPhoto3;
    /** 发布交易-上传图片-选择即将要上传的图片 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[4]")
    WebElement uploadAlbumPhoto4;
    /** 发布交易-上传图片-选取图片-完成 */
    @AndroidFindBy(id="com.tnaot.news:id/done")
    WebElement donePhoto;



    /** 发布交易-交易买卖地址 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_location")
    WebElement locationText;

    /** 发布交易-交易买卖地址-请选择省份 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_province")
    WebElement proviceText;
    /** 发布交易-交易买卖地址-请选择省份-省份选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvName'][@text='金边']")
    WebElement proviceText1;
    /** 发布交易-交易买卖地址-请选择省份-省份选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvName'][@text='西港']")
    WebElement proviceText2;
    /** 发布交易-交易买卖地址-请选择省份-省份选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvName'][@text='柴桢']")
    WebElement proviceText3;
    /** 发布交易-交易买卖地址-请选择省份-省份选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvName'][@text='贡布']")
    WebElement proviceText4;
    /** 发布交易-交易买卖地址-请选择省份-省份选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvName'][@text='白马']")
    WebElement proviceText5;
    /** 发布交易-交易买卖地址-请选择省份-省份选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvName'][@text='马德望']")
    WebElement proviceText6;
    /** 发布交易-交易买卖地址-请选择省份-省份选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvName'][@text='干丹']")
    WebElement proviceText7;
    /** 发布交易-交易买卖地址-请选择省份-省份选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvName'][@text='磅针']")
    WebElement proviceText8;

    /** 发布交易-交易买卖地址-请选择省份-省份选择-保存 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_save")
    WebElement saveButton;

    /** 发布交易-类型 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_release_second_hand_content")
    WebElement transactionType;
    /** 发布交易-类型-手机/平板 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='手机/平板']")
    WebElement transactionType1;
    /** 发布交易-类型-电脑 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='电脑']")
    WebElement transactionType2;
    /** 发布交易-类型-电子数码 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='电子数码']")
    WebElement transactionType3;
    /** 发布交易-类型-服装 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='服装']")
    WebElement transactionType4;
    /** 发布交易-类型-书籍 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='书籍']")
    WebElement transactionType5;
    /** 发布交易-类型-家具 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='家具']")
    WebElement transactionType6;
    /** 发布交易-类型-宠物 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='宠物']")
    WebElement transactionType7;
    /** 发布交易-类型-食品 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='食品']")
    WebElement transactionType8;
    /** 发布交易-类型-办公设备 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='办公设备']")
    WebElement transactionType9;
    /** 发布交易-类型-文体户外 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='文体户外']")
    WebElement transactionType10;
    /** 发布交易-类型-家电 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='家电']")
    WebElement transactionType11;
    /** 发布交易-类型-美容保障 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='美容保障']")
    WebElement transactionType12;

    /** 发布交易-价格 */
    @AndroidFindBy(id="com.tnaot.news:id/edit_release_price_content")
    WebElement priceText;
    /** 发布交易-输入价格 */
    @AndroidFindBy(id="com.tnaot.news:id/edit_price_custom")
    WebElement inputPrice;
    /** 发布交易-保存价格 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_save")
    WebElement savePrice;
    /** 联系方式-电话 */
    @AndroidFindBy(id="com.tnaot.news:id/etPhone")
    WebElement telephoneText;
    /** 联系方式-微信 */
    @AndroidFindBy(id="com.tnaot.news:id/etWeChat")
    WebElement wechatText;
    /** 联系方式-邮箱 */
    @AndroidFindBy(id="com.tnaot.news:id/etEmail")
    WebElement emailText;
    /** 联系方式-Facebook */
    @AndroidFindBy(id="com.tnaot.news:id/etFaceBook")
    WebElement facebookText;


    /** 发布求职招聘 */
    @AndroidFindBy(xpath="//android.widget.TextView[@text='发布求职招聘']")
    WebElement sendJob;
    /** 发布求职招聘-求职者位置 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_location_content")
    WebElement locationContent;
    /** 发布求职招聘-求职者位置-请选择省份 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_province")
    WebElement chooseProvince;
//    /** 发布求职招聘-求职者位置-请选择省份-选择省份 */
//    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tvName'][@text='金边']")
//    WebElement sendJob;
    /** 发布求职招聘-求职者位置-详细地址 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_detail_location")
    WebElement detailLocation;
    /** 发布求职招聘-求职者位置-详细地址-输入小区/写字楼/商品房 */
    @AndroidFindBy(id="com.tnaot.news:id/etSearch")
    WebElement inputSearch;
    /** 发布求职招聘-求职者位置-详细地址-输入小区/写字楼/商品房-查找 */
    @AndroidFindBy(id="com.tnaot.news:id/tvSearch")
    WebElement searchButton;
    /** 发布求职招聘-求职者位置-详细地址-拖动地图定位 */
    @AndroidFindBy(id="com.tnaot.news:id/btnGoMap")
    WebElement btnGoMap;



    /** 发布求职招聘-我要-求职 */
    @AndroidFindBy(id="com.tnaot.news:id/rb_job_wanted")
    WebElement jobWanted;
    /** 发布求职招聘-我要-招聘 */
    @AndroidFindBy(id="com.tnaot.news:id/rb_recruit")
    WebElement jobRecruit;
    /** 发布求职招聘-职位 */
    @AndroidFindBy(id="com.tnaot.news:id/et_position_content")
    WebElement positionText;
    /** 发布求职招聘-类型 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_release_job_content")
    WebElement jobType;
    /** 发布求职招聘-类型-求职招聘类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='技工/保养']")
    WebElement jobType1;
    /** 发布求职招聘-类型-求职招聘类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='交货/仓储']")
    WebElement jobType2;
    /** 发布求职招聘-类型-求职招聘类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='市场营销']")
    WebElement jobType3;
    /** 发布求职招聘-类型-求职招聘类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='媒体广告']")
    WebElement jobType4;
    /** 发布求职招聘-类型-求职招聘类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='医疗健康护理']")
    WebElement jobType5;
    /** 发布求职招聘-类型-求职招聘类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='跟单/采购']")
    WebElement jobType6;
    /** 发布求职招聘-类型-求职招聘类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='操作/生产']")
    WebElement jobType7;
    /** 发布求职招聘-类型-求职招聘类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='度假村/赌场']")
    WebElement jobType8;
    /** 发布求职招聘-类型-求职招聘类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='销售']")
    WebElement jobType9;
    /** 发布求职招聘-类型-求职招聘类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='律师/法务']")
    WebElement jobType10;
    /** 发布求职招聘-类型-求职招聘类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='翻译']")
    WebElement jobType11;
    /** 发布求职招聘-类型-求职招聘类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='旅行社']")
    WebElement jobType12;

    /** 发布求职招聘-月薪-请选择薪资区间 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_release_salary_content")
    WebElement salaryText;
    /** 发布求职招聘-月薪-请选择薪资区间-月薪选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='面议']")
    WebElement salaryType1;
    /** 发布求职招聘-月薪-请选择薪资区间-月薪选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='$ 100-180']")
    WebElement salaryType2;
    /** 发布求职招聘-月薪-请选择薪资区间-月薪选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='$ 180-250']")
    WebElement salaryType3;
    /** 发布求职招聘-月薪-请选择薪资区间-月薪选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='$ 250-500']")
    WebElement salaryType4;
    /** 发布求职招聘-月薪-请选择薪资区间-月薪选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='$ 500-800']")
    WebElement salaryType5;
    /** 发布求职招聘-月薪-请选择薪资区间-月薪选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='$ 800-1200']")
    WebElement salaryType6;
    /** 发布求职招聘-月薪-请选择薪资区间-月薪选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='$ 1200-2000']")
    WebElement salaryType7;
    /** 发布求职招聘-月薪-请选择薪资区间-月薪选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='$ 2000-3000']")
    WebElement salaryType8;
    /** 发布求职招聘-月薪-请选择薪资区间-月薪选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='$ 3000-5000']")
    WebElement salaryType9;
    /** 发布求职招聘-月薪-请选择薪资区间-月薪选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='$ 5000+']")
    WebElement salaryType10;


    /** 发布求职招聘-月薪-面议 */
    @AndroidFindBy(id="com.tnaot.news:id/cb_face_to_face")
    WebElement salaryFace;



    /** 发布优惠 */
    @AndroidFindBy(xpath="//android.widget.TextView[@text='发布优惠']")
    WebElement sendDiscount;
    /** 发布优惠-类型 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_release_discount_content")
    WebElement discountType;
    /** 发布优惠-类型-折扣优惠类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='美食餐饮']")
    WebElement discountType1;
    /** 发布优惠-类型-折扣优惠类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='休闲娱乐']")
    WebElement discountType2;
    /** 发布优惠-类型-折扣优惠类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='婚庆服务']")
    WebElement discountType3;
    /** 发布优惠-类型-折扣优惠类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='家居装饰']")
    WebElement discountType4;
    /** 发布优惠-类型-折扣优惠类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='购物卖场']")
    WebElement discountType5;
    /** 发布优惠-类型-折扣优惠类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='时尚女性']")
    WebElement discountType6;
    /** 发布优惠-类型-折扣优惠类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='汽车服务']")
    WebElement discountType7;
    /** 发布优惠-类型-折扣优惠类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='培训机构']")
    WebElement discountType8;
    /** 发布优惠-类型-折扣优惠类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='旅游酒店']")
    WebElement discountType9;
    /** 发布优惠-类型-折扣优惠类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='亲子母婴']")
    WebElement discountType10;
    /** 发布优惠-类型-折扣优惠类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='健身美体']")
    WebElement discountType11;
    /** 发布优惠-类型-折扣优惠类型选择 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='服装']")
    WebElement discountType12;



    /** 发布房地产 */
    @AndroidFindBy(xpath="//android.widget.TextView[@text='发布房地产']")
    WebElement sendEstate;
    /** 发布房地产-出售 */
    @AndroidFindBy(id="com.tnaot.news:id/ivEstateSaleMethod1")
    WebElement estateSell;
    /** 发布房地产-出租 */
    @AndroidFindBy(id="com.tnaot.news:id/ivEstateSaleMethod2")
    WebElement estateRent;
    /** 发布房地产-出售-上传照片 */
    @AndroidFindBy(id="com.tnaot.news:id/llUploadImage")
    WebElement uploadImage;

    /** 发布房地产-出售-上传照片-完成 */
    @AndroidFindBy(id="com.tnaot.news:id/tvComplete")
    WebElement tvComplete;


    /** 发布房地产-出售-标题 */
    @AndroidFindBy(id="com.tnaot.news:id/edit_title")
    WebElement sellTitle;

    /** 发布房地产-出售-类别 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_release_estate_content")
    WebElement estateCategoryType;
    /** 发布房地产-出售-类别-选择发布类别 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='二手房']")
    WebElement estateCategoryType1;
    /** 发布房地产-出售-类别-选择发布类别 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='新房']")
    WebElement estateCategoryType2;
    /** 发布房地产-出售-类别-选择发布类别 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='写字楼']")
    WebElement estateCategoryType3;
    /** 发布房地产-出售-类别-选择发布类别 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='厂房']")
    WebElement estateCategoryType4;
    /** 发布房地产-出售-类别-选择发布类别 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='仓库']")
    WebElement estateCategoryType5;
    /** 发布房地产-出售-类别-选择发布类别 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='商铺']")
    WebElement estateCategoryType6;
    /** 发布房地产-出售-类别-选择发布类别 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='土地']")
    WebElement estateCategoryType7;


    /** 发布房地产-出售-类型 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_release_estate_content2")
    WebElement estateSellType;
    /** 发布房地产-出售-类型-选择产品类型 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='普通住宅']")
    WebElement estateSellType1;
    /** 发布房地产-出售-类型-选择产品类型 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='别墅']")
    WebElement estateSellType2;
    /** 发布房地产-出售-类型-选择产品类型 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='双子别墅']")
    WebElement estateSellType3;
    /** 发布房地产-出售-类型-选择产品类型 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='排屋']")
    WebElement estateSellType4;
    /** 发布房地产-出售-类型-选择产品类型 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='联排别墅']")
    WebElement estateSellType5;
    /** 发布房地产-出售-类型-选择产品类型 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='公寓']")
    WebElement estateSellType6;
    /** 发布房地产-出售-类型-选择产品类型 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='可出租式公寓']")
    WebElement estateSellType7;
    /** 发布房地产-出售-类型-选择产品类型 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='酒店式公寓']")
    WebElement estateSellType8;
    /** 发布房地产-出售-类型-选择产品类型 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='单间']")
    WebElement estateSellType9;


    /** 发布房地产-出售-价格 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_release_price_content")
    WebElement sellPrice;
    /** 发布房地产-出售-面积 */
    @AndroidFindBy(id="com.tnaot.news:id/edit_release_estate_area_content")
    WebElement sellArea;
    /** 发布房地产-出售-房产地址 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_release_detail_address_content")
    WebElement sellAddress;
    /** 发布房地产-出售-联系人 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_contact_content")
    WebElement sellContact;
    /** 发布房地产-出售-房屋描述 */
    @AndroidFindBy(id="com.tnaot.news:id/edit_contact_des")
    WebElement sellDescription;




    /** 商家入驻 */
    @AndroidFindBy(xpath="//android.widget.TextView[@text='商家入驻']")
    WebElement sendBusiness;
    /** 商家入驻-类型 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_release_discount_content")
    WebElement businessType;
    /** 商家入驻-类型-美食 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='美食']")
    WebElement businessType1;
    /** 商家入驻-类型-娱乐 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='娱乐']")
    WebElement businessType2;
    /** 商家入驻-类型-旅行 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='旅行']")
    WebElement businessType3;
    /** 商家入驻-类型-购物 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='购物']")
    WebElement businessType4;
    /** 商家入驻-类型-健身 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='健身']")
    WebElement businessType5;
    /** 商家入驻-类型-医疗 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='医疗']")
    WebElement businessType6;
    /** 商家入驻-类型-教育 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='教育']")
    WebElement businessType7;
    /** 商家入驻-类型-服务 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='服务']")
    WebElement businessType8;

    /** 商家入驻-参考价格 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_province_content")
    WebElement referencePrice;





    /** 寻人求助 */
    @AndroidFindBy(xpath="//android.widget.TextView[@text='寻人求助']")
    WebElement sendHelp;
    /** 寻人求助-类型 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_type")
    WebElement helpType;
    /** 寻人求助-类型-寻人 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='寻人']")
    WebElement helpType1;
    /** 寻人求助-类型-寻物 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='寻物']")
    WebElement helpType2;
    /** 寻人求助-类型-求助 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_content'][@text='求助']")
    WebElement helpType3;

    /** 我要爆料 */
    @AndroidFindBy(xpath="//android.widget.TextView[@text='我要爆料']")
    WebElement sendFact;

    /** 商业互助 */
    @AndroidFindBy(xpath="//android.widget.TextView[@text='商业互助']")
    WebElement sendBusinessHelp;

    /** 发布类型-取消按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/pop_rl_click")
    WebElement dismissButton;


    /** 资讯详情-分享-Facebook */
    @AndroidFindBy(id="com.tnaot.news:id/tv_more_facebook")
    WebElement moreFacebook;

    /** 资讯详情-分享-Messager */
    @AndroidFindBy(id="com.tnaot.news:id/tv_more_messenger")
    WebElement moreMessenger;

    /** 资讯详情-分享-微信 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_more_wechat")
    WebElement moreWechat;

    /** 资讯详情-分享-朋友圈 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_more_moments")
    WebElement moreMoments;

    /** 资讯详情-分享-Line */
    @AndroidFindBy(id="com.tnaot.news:id/tv_more_line")
    WebElement moreLine;

    /** 资讯详情-分享-Twitter */
    @AndroidFindBy(id="com.tnaot.news:id/tv_more_twitter")
    WebElement moreTwitter;

    /** 资讯详情-分享-QQ */
    @AndroidFindBy(id="com.tnaot.news:id/tv_more_qq")
    WebElement moreQq;

    /** 资讯详情-分享-QQ空间 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_more_qqzone")
    WebElement moreQqZone;

    /** 资讯详情-分享-复制链接 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_more_copy_link")
    WebElement copyLink;

    /** 资讯详情-分享-收藏 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_more_favorite")
    WebElement moreFavorite;

    /** 资讯详情-分享-举报文章 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_more_report_news")
    WebElement reportNews;

    /** 资讯详情-分享-举报文章-理由-虚假广告 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='虚假广告']")
    WebElement vulgarContent;

    /** 资讯详情-分享-举报文章-理由-低俗色情 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='低俗色情']")
    WebElement fakeTitle;

    /** 资讯详情-分享-举报文章-理由-垃圾内容 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='低俗色情']")
    WebElement garbageContent;

    /** 资讯详情-分享-举报文章-理由-确定 */
    @AndroidFindBy(xpath="//android.view.View[@content-desc='举报理由确定']")
    WebElement reportReasonAccept;




    /** 资讯详情-分享-转发 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_more_republish")
    WebElement moreRepublish;

    /** 资讯详情-分享-转发页面-取消 */
    @AndroidFindBy(id="com.tnaot.news:id/tvCancel")
    WebElement tvCancel;

    /** 资讯详情-分享-转发页面-发布 */
    @AndroidFindBy(id="com.tnaot.news:id/tvRelease")
    WebElement tvRelease;

    /** 资讯详情-分享-转发页面-文本编辑框 */
    @AndroidFindBy(id="com.tnaot.news:id/editText")
    WebElement editText;


    /** 资讯详情-分享-系统分享 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_more_share_to_system")
    WebElement sysShare;

    /** 资讯详情-分享-取消按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_more_cancel")
    WebElement cancelButton;

    @AndroidFindBy(id="com.tnaot.news:id/iv_update_close")
    WebElement mainCloseButton;






}
