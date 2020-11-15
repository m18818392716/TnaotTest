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
public class NewsPage extends AppiumBaseExecutor {

    public NewsPage(AppiumDriver<?> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    /** 资讯tab键 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_Home")
    WebElement rlHome;


    /** 资讯列表刷新-提示刷新**条 */
    @AndroidFindBy(id="com.tnaot.news:id/tip_view")
    WebElement tipView;

    /** 长按资讯-收藏 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_collect")
    WebElement collectButton;

    /** 长按资讯-不感兴趣 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_dislike")
    WebElement dislikeButton;
    /** 长按资讯-不感兴趣-不想看 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_1")
    WebElement dislikeReason1;
    /** 长按资讯-不感兴趣-内容重复，看过了 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_2")
    WebElement dislikeReason2;
    /** 长按资讯-不感兴趣-内容太水 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_3")
    WebElement dislikeReason3;
    /** 长按资讯-不感兴趣-确定 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_complete")
    WebElement dislikeReasonAccept;

    /** 长按资讯-分享到.. */
    @AndroidFindBy(id="com.tnaot.news:id/tv_share")
    WebElement shareButton;

    /** 长按资讯-举报文章 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_report")
    WebElement reportButton;

    /** 长按资讯-转发 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_forward")
    WebElement forwardButton;


    /** 资讯-本地 */
    @FindElementBy(type = "accessibilityId", value = "本地")
    @AndroidFindBy(xpath="//androidx.appcompat.app.ActionBar$Tab[@content-desc='本地']")
    WebElement localChannel;

    /** 资讯-推荐 */
    @FindElementBy(type = "accessibilityId", value = "推荐")
    @AndroidFindBy(xpath="//androidx.appcompat.app.ActionBar$Tab[@content-desc='推荐']")
    WebElement recommendedChannel;

    /** 资讯-娱乐 */
    @FindElementBy(type = "accessibilityId", value = "娱乐")
    @AndroidFindBy(xpath="//androidx.appcompat.app.ActionBar$Tab[@content-desc='娱乐']")
    WebElement entertainmentChannel;

    /** 资讯-社会 */
    @FindElementBy(type = "accessibilityId", value = "社会")
    @AndroidFindBy(xpath="//androidx.appcompat.app.ActionBar$Tab[@content-desc='社会']")
    WebElement socialChannel;

    /** 资讯-科技 */
    @FindElementBy(type = "accessibilityId", value = "科技")
    @AndroidFindBy(xpath="//androidx.appcompat.app.ActionBar$Tab[@content-desc='科技']")
    WebElement scienceChannel;

    /** 资讯-健康 */
    @FindElementBy(type = "accessibilityId", value = "健康")
    @AndroidFindBy(xpath="//androidx.appcompat.app.ActionBar$Tab[@content-desc='健康']")
    WebElement healthChannel;

    /** 资讯-体育 */
    @FindElementBy(type = "accessibilityId", value = "体育")
    @AndroidFindBy(xpath="//androidx.appcompat.app.ActionBar$Tab[@content-desc='体育']")
    WebElement sportsChannel;

    /** 资讯-美食 */
    @FindElementBy(type = "accessibilityId", value = "美食")
    @AndroidFindBy(xpath="//androidx.appcompat.app.ActionBar$Tab[@content-desc='美食']")
    WebElement foodChannel;

    /** 资讯-生活 */
    @FindElementBy(type = "accessibilityId", value = "生活")
    @AndroidFindBy(xpath="//androidx.appcompat.app.ActionBar$Tab[@content-desc='生活']")
    WebElement lifeChannel;

    /** 资讯-图片 */
    @FindElementBy(type = "accessibilityId", value = "图片")
    WebElement imageChannel;

    /** 资讯-小说 */
    @FindElementBy(type = "accessibilityId", value = "小说")
    WebElement novelChannel;






    /** 资讯-频道控件header */
    @AndroidFindBy(id="com.tnaot.news:id/tabLayout")
    WebElement channelHeader;
    /** 资讯-频道列表img */
    @AndroidFindBy(id="com.tnaot.news:id/iv_channel")
    WebElement channelListButton;
    /** 资讯-频道列表img-图片 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv'][contains(@text, '图片')]")
    WebElement channelListImage;
    /** 资讯-频道列表img-小说 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv'][contains(@text, '小说')]")
    WebElement channelListNovel;
    /** 资讯-频道列表img-本地 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv'][contains(@text, '本地')]")
    WebElement channelListLocal;
    /** 资讯-频道列表img-推荐 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv'][contains(@text, '推荐')]")
    WebElement channelListLocal1;
    /** 资讯-频道列表img-娱乐 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv'][contains(@text, '娱乐')]")
    WebElement channelListEnjoy;
    /** 资讯-频道列表img-科技 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv'][contains(@text, '科技')]")
    WebElement channelListTechno;
    /** 资讯-频道列表img-体育 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv'][contains(@text, '体育')]")
    WebElement channelListSports;
    /** 资讯-频道列表img-社会 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv'][contains(@text, '社会')]")
    WebElement channelListSocienty;
    /** 资讯-频道列表img-健康 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv'][contains(@text, '健康')]")
    WebElement channelListHealth;
    /** 资讯-频道列表img-美食 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv'][contains(@text, '美食')]")
    WebElement channelListFood;
    /** 资讯-频道列表img-生活 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv'][contains(@text, '生活')]")
    WebElement channelListLife;




    /** 资讯-频道列表img-关闭按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_close")
    WebElement channelListCloseButton;

    /** 资讯列表-删除图标 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_x")
    WebElement deleteNewsIcon;

    /** 资讯列表-标题 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_title")
    WebElement imageNewsListTitle;

    /** 资讯列表-作者 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tvAuthor")
    WebElement imageNewsAuthor;

    /** 资讯列表-评论数 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_comment_num")
    WebElement imageNewsCommentCount;





    /** 图文资讯详情-点赞图标 */
    @AndroidFindBy(id="com.tnaot.news:id/ivPraise")
    WebElement praiseButton;
    /** 图文资讯详情-点赞图标-点赞数 */
    @AndroidFindBy(id="com.tnaot.news:id/tvPraiseCount")
    WebElement praiseCount;
    /** 图文资讯详情-延展阅读换一批 */
    @AndroidFindBy(id="com.tnaot.news:id/ll_another")
    WebElement changeAnother;


    /** 资讯详情-右上角-更多按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/ivShare")
    WebElement ivShare;

    /** 资讯详情-评论输入框 */
    @AndroidFindBy(id="com.tnaot.news:id/etComment")
    WebElement tvComment;

    /** 资讯详情-表情头像 */
    @AndroidFindBy(id="com.tnaot.news:id/ibtn_face")
    WebElement faceButton;

    /** 资讯详情-评论编辑框 */
    @AndroidFindBy(id="com.tnaot.news:id/et_comment_input")
    WebElement commentInput;

    /** 资讯详情-发布按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_comment_push")
    WebElement commentPush;

    /** 资讯详情-评论图标 */
    @AndroidFindBy(xpath="待定")
    WebElement tabMine;

    /** 资讯详情-收藏图标 */
    @AndroidFindBy(id="com.tnaot.news:id/ivFavorite")
    WebElement ivFavorite;

    /** 资讯详情-分享图标 */
    @AndroidFindBy(id="com.tnaot.news:id/ivShare2")
    WebElement ivShare2;

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

    /** 资讯详情-分享-举报文章-理由-低俗色情 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_vulgar")
    WebElement vulgarContent;

    /** 资讯详情-分享-举报文章-理由-标题党 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_fake_title")
    WebElement fakeTitle;

    /** 资讯详情-分享-举报文章-理由-内容不实 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_fake_content")
    WebElement fakeContent;

    /** 资讯详情-分享-举报文章-理由-旧闻重复 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_same_content")
    WebElement sameContent;

    /** 资讯详情-分享-举报文章-理由-垃圾内容 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_garbage_content")
    WebElement garbageContent;


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

    /** 资讯详情-分享-转发页面-勾选同时并评论 */
    @AndroidFindBy(id="com.tnaot.news:id/ivCheck")
    WebElement ivCheck;



    /** 资讯详情-分享-系统分享 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_more_share_to_system")
    WebElement sysShare;

    /** 资讯详情-分享-取消按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_more_cancel")
    WebElement cancelButton;




    /** 资讯详情-评论列表-热门 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_hot_comments")
    WebElement hotComments;

    /** 资讯详情-评论列表-最新 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_newest_comments")
    WebElement newestComments;

    /** 资讯详情-评论列表-评论第一条 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_content")
    @AndroidFindBy(id="com.tnaot.news:id/ll_parent")
    WebElement llParent;

    /** 资讯详情-评论列表-评论点赞 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_like_count")
    @AndroidFindBy(id="com.tnaot.news:id/tv_like_count")
    WebElement likeCount;

    /** 资讯详情-评论列表-评论删除 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_delete_comment")
    @AndroidFindBy(id="com.tnaot.news:id/tv_delete_comment")
    WebElement deleteComment;
    /** 资讯详情-评论列表-评论删除-确定 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_right")
    WebElement deleteCommentAccept;
    /** 资讯详情-评论列表-评论删除-取消 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_left")
    WebElement deleteCommentDismiss;




    /** 资讯详情-评论列表-长按评论复制 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_copy")
    WebElement commentCopy;

    /** 资讯详情-评论列表-长按评论举报 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_report")
    WebElement commentReport;
    /** 资讯详情-评论列表-长按评论举报-低俗色情 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_vulgar")
    WebElement comReportReason1;
    /** 资讯详情-评论列表-长按评论举报-欺诈诱导 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_cheat")
    WebElement comReportReason2;
    /** 资讯详情-评论列表-长按评论举报-营销广告 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_ad")
    WebElement comReportReason3;
    /** 资讯详情-评论列表-长按评论举报-恶意攻击 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_attack")
    WebElement comReportReason4;



//    /** 资讯详情-评论列表-评论第一条-详情-下方的回复评论输入框 */
//    @AndroidFindBy(id="com.tnaot.news:id/et_comment_input")
//    WebElement commentInput;
//
//    /** 资讯详情-评论列表-评论第一条-详情-下方的发布按钮 */
//    @AndroidFindBy(id="com.tnaot.news:id/tv_comment_push")
//    WebElement commentPush;

    /** 图文资讯详情-换一批 */
    //@FindElementBy(type = "name", value = "换一批")com.tnaot.news:id/tvTitle
    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text, '换一批')]")
    WebElement changeContactList;
    /** 图文资讯详情-换一批-延展阅读列表第一条数据-资讯标题 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tvTitle")
    WebElement contactListTitle;
    /** 资讯详情-返回按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/ivBack")
    WebElement backButton;

    /** 资讯详情-阅读资讯30秒-获取金币弹窗 */
    @AndroidFindBy(id="com.tnaot.news:id/ivBackground")
    WebElement getCoinsOverlay;


    /** 图集资讯详情-发布时间 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tvTime")
    WebElement imageNewsDetailReleaseTime;
    /** 图集资讯详情-换一批-四条相关资讯图集 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/textView")
    WebElement relativeNewsList;
    /** 图集资讯详情-图片页数 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_img_count")
    WebElement imgCount;


    /** 资讯列表-资讯title */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_title")
    //@AndroidFindBy(id="com.tnaot.news:id/tv_title")
    WebElement newsTitleList;
    /** 资讯列表-置顶-红色字样 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_top")
    //@AndroidFindBy(id="com.tnaot.news:id/tv_title")
    WebElement topNewsListLogo;











    /** 视频tab键 */
    @AndroidFindBy(id="com.tnaot.news:id/rlVideo")
    WebElement rlVideo;

    /** 首页tab键 */
    @AndroidFindBy(id="com.tnaot.news:id/rlLife")
    WebElement rlLife;

    /** 动态tab键 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_dynamic")
    WebElement rlDynamic;

    /** 我的tab键 */
    @AndroidFindBy(id="com.tnaot.news:id/rlMine")
    WebElement rlMine;


    /** 热搜词输入框 */
    @AndroidFindBy(id="com.tnaot.news:id/ll_search")
    WebElement searchText;
    /** 热搜词编辑框-输入内容 */
    @AndroidFindBy(id="com.tnaot.news:id/et_search_keywords")
    WebElement searchKeywords;
    /** 热搜词编辑框-搜索按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_search")
    WebElement searchButton;
    /** 热搜词编辑框-搜索按钮-搜索结果-图片 */
    @AndroidFindBy(xpath="//*[contains(@text, '图片')]")
    WebElement imageTab;
    /** 热搜词编辑框-搜索按钮-搜索结果-视频 */
    @AndroidFindBy(xpath="//*[contains(@text, '视频')]")
    WebElement videoTab;
    /** 热搜词编辑框-搜索按钮-搜索结果-生活 */
    @AndroidFindBy(xpath="//*[contains(@text, '生活')]")
    WebElement lifeTab;
    /** 热搜词编辑框-搜索按钮-搜索结果-综合 */
    //@AndroidFindBy(xpath="//*[contains(@text, '综合')]")
    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text, '综合')]")
    WebElement comprehensiveTab;

    /** 热搜词编辑框-搜索按钮-搜索结果-图片、视频、综合-列表中的资讯标题 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_title")
    WebElement searchNewsListTitle;
    /** 热搜词编辑框-搜索按钮-搜索结果-生活列表中的生活标题 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_life_content")
    WebElement searchLifeListTitle;



    /** 资讯-新手引导页-关闭按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/ivClose")
    WebElement noviceBootPageCloseButton;











}
