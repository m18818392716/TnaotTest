package com.tnaot.page;

import com.tnaot.anotation.FindElementBy;
import com.tnaot.core.AppiumBaseExecutor;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@Data
public class DynamicPage extends AppiumBaseExecutor {

    public DynamicPage(AppiumDriver<?> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    /** 动态列表刷新提示语-暂无最新动态 */
    @AndroidFindBy(id="//*[@text='暂无最新动态']")
    WebElement tipRefreshMessage;

    /** 发布-摄像机按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_top_release")
    WebElement releaseButton;

    /** 发布-发布动态 */
    @AndroidFindBy(id="cn.dbyl.young.tianqi:id/tab_personal")
    WebElement releaseDynamic;

    /** 发布-发布交易 */
    @AndroidFindBy(id="cn.dbyl.young.tianqi:id/tab_personal")
    WebElement releaseTrade;

    /** 发布-发布求职招聘 */
    @AndroidFindBy(id="cn.dbyl.young.tianqi:id/tab_personal")
    WebElement releaseJob;

    /** 发布-发布优惠 */
    @AndroidFindBy(id="cn.dbyl.young.tianqi:id/tab_personal")
    WebElement releasePreferential;

    /** 发布-发布房地产 */
    @AndroidFindBy(id="cn.dbyl.young.tianqi:id/tab_personal")
    WebElement releaseRealEstate;

    /** 发布-商家入驻 */
    @AndroidFindBy(id="cn.dbyl.young.tianqi:id/tab_personal")
    WebElement releaseBusiness;

    /** 发布-寻人求助 */
    @AndroidFindBy(id="cn.dbyl.young.tianqi:id/tab_personal")
    WebElement releaseHelp;

    /** 发布-我要爆料 */
    @AndroidFindBy(id="cn.dbyl.young.tianqi:id/tab_personal")
    WebElement releaseFact;

    /** 发布-商家互助 */
    @AndroidFindBy(id="cn.dbyl.young.tianqi:id/tab_personal")
    WebElement releaseBusinessHelp;

    /** 发布-退出按钮 */
    @AndroidFindBy(id="cn.dbyl.young.tianqi:id/tab_personal")
    WebElement exitButton;


    /** 发布页面-动态 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_send")
    WebElement sendButton;

    /** 发布页面-发布内容 */
    @AndroidFindBy(id="com.tnaot.news:id/edit_content")
    WebElement editContent;

    /** 发布页面-上传图片按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_add_photo")
    WebElement addPhotoButton;

    /** 发布页面-上传图片按钮-拍摄（照片和视频） */
    @AndroidFindBy(id="com.tnaot.news:id/rl_add_photo")
    WebElement addPhotoButton1;

    /** 发布页面-上传图片按钮-从手机相册中获取 */
    @AndroidFindBy(id="com.tnaot.news:id/rl_add_photo")
    WebElement addPhotoButton2;


    /** 动态列表-作者名 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_name")
    WebElement dynamicAuthor;

    /** 动态列表-发布时间 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_time")
    WebElement dynamicReleaseTime;

    /** 动态列表-动态标题 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_content_comment")
    WebElement dynamicTitle;

    /** 动态列表-动态点赞图标 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/iv_like")
    WebElement dynamicPraise;
    /** 动态列表-动态点赞数量 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tvPraise")
    WebElement dynamicPraiseCount;

    /** 动态列表-动态评论图标 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_comment")
    WebElement dynamicComment;
    /** 动态列表-动态评论数量 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tvComment")
    WebElement dynamicCommentCount;

    /** 动态列表-动态分享图标 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tvShare")
    WebElement dynamicShare;


    /** 动态详情-作者名 */
    @AndroidFindBy(xpath="")
    WebElement dynamicDetailAuthor;

    /** 动态详情-发布时间 */
    @AndroidFindBy(xpath="")
    WebElement dynamicDetailReleaseTime;

    /** 动态详情-动态标题 */
    @AndroidFindBy(xpath="")
    WebElement dynamicDetailTitle;






}
