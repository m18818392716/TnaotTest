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
public class NewsPage extends AppiumBaseExecutor {

    public NewsPage(AppiumDriver<?> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    /** 资讯tab键 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_Home")
    MobileElement rlHome;


    /** 资讯列表刷新-提示刷新**条 */
    @AndroidFindBy(id="com.tnaot.news:id/tip_view")
    MobileElement tipView;

    /** 长按资讯-收藏 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_collect")
    MobileElement collectButton;

    /** 长按资讯-不感兴趣 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_dislike")
    MobileElement dislikeButton;
    /** 长按资讯-不感兴趣-不想看 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_1")
    MobileElement dislikeReason1;
    /** 长按资讯-不感兴趣-内容重复，看过了 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_2")
    MobileElement dislikeReason2;
    /** 长按资讯-不感兴趣-内容太水 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_3")
    MobileElement dislikeReason3;
    /** 长按资讯-不感兴趣-确定 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_complete")
    MobileElement dislikeReasonAccept;

    /** 长按资讯-分享到.. */
    @AndroidFindBy(id="com.tnaot.news:id/tv_share")
    MobileElement shareButton;

    /** 长按资讯-举报文章 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_report")
    MobileElement reportButton;

    /** 长按资讯-转发 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_forward")
    MobileElement forwardButton;


    /** 资讯-本地 */
    @FindElementBy(type = "accessibilityId", value = "本地")
    @AndroidFindBy(xpath="//androidx.appcompat.app.ActionBar$Tab[@content-desc='本地']")
    MobileElement localChannel;

    /** 资讯-推荐 */
    @FindElementBy(type = "accessibilityId", value = "推荐")
    @AndroidFindBy(xpath="//androidx.appcompat.app.ActionBar$Tab[@content-desc='推荐']")
    MobileElement recommendedChannel;

    /** 资讯-娱乐 */
    @FindElementBy(type = "accessibilityId", value = "娱乐")
    @AndroidFindBy(xpath="//androidx.appcompat.app.ActionBar$Tab[@content-desc='娱乐']")
    MobileElement entertainmentChannel;

    /** 资讯-社会 */
    @FindElementBy(type = "accessibilityId", value = "社会")
    @AndroidFindBy(xpath="//androidx.appcompat.app.ActionBar$Tab[@content-desc='社会']")
    MobileElement socialChannel;

    /** 资讯-科技 */
    @FindElementBy(type = "accessibilityId", value = "科技")
    @AndroidFindBy(xpath="//androidx.appcompat.app.ActionBar$Tab[@content-desc='科技']")
    MobileElement scienceChannel;

    /** 资讯-健康 */
    @FindElementBy(type = "accessibilityId", value = "健康")
    @AndroidFindBy(xpath="//androidx.appcompat.app.ActionBar$Tab[@content-desc='健康']")
    MobileElement healthChannel;

    /** 资讯-体育 */
    @FindElementBy(type = "accessibilityId", value = "体育")
    @AndroidFindBy(xpath="//androidx.appcompat.app.ActionBar$Tab[@content-desc='体育']")
    MobileElement sportsChannel;

    /** 资讯-美食 */
    @FindElementBy(type = "accessibilityId", value = "美食")
    @AndroidFindBy(xpath="//androidx.appcompat.app.ActionBar$Tab[@content-desc='美食']")
    MobileElement foodChannel;

    /** 资讯-生活 */
    @FindElementBy(type = "accessibilityId", value = "生活")
    @AndroidFindBy(xpath="//androidx.appcompat.app.ActionBar$Tab[@content-desc='生活']")
    MobileElement lifeChannel;

    /** 资讯-图片 */
    @FindElementBy(type = "accessibilityId", value = "图片")
    MobileElement imageChannel;

    /** 资讯-小说 */
    @FindElementBy(type = "accessibilityId", value = "小说")
    MobileElement novelChannel;






    /** 资讯-频道控件header */
    @AndroidFindBy(id="com.tnaot.news:id/tabLayout")
    MobileElement channelHeader;
    /** 资讯-频道列表img */
    @AndroidFindBy(id="com.tnaot.news:id/iv_channel")
    MobileElement channelListButton;
    /** 资讯-频道列表img-图片 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv'][contains(@text, '图片')]")
    MobileElement channelListImage;
    /** 资讯-频道列表img-小说 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv'][contains(@text, '小说')]")
    MobileElement channelListNovel;
    /** 资讯-频道列表img-关闭按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_close")
    MobileElement channelListCloseButton;












    /** 图文资讯详情-点赞图标 */
    @AndroidFindBy(id="com.tnaot.news:id/ivPraise")
    MobileElement praiseButton;
    /** 图文资讯详情-点赞图标-点赞数 */
    @AndroidFindBy(id="com.tnaot.news:id/tvPraiseCount")
    MobileElement praiseCount;
    /** 图文资讯详情-延展阅读换一批 */
    @AndroidFindBy(id="com.tnaot.news:id/ll_another")
    MobileElement changeAnother;


    /** 资讯详情-评论输入框 */
    @AndroidFindBy(id="com.tnaot.news:id/etComment")
    MobileElement tvComment;

    /** 资讯详情-表情头像 */
    @AndroidFindBy(id="com.tnaot.news:id/ibtn_face")
    MobileElement faceButton;

    /** 资讯详情-评论编辑框 */
    @AndroidFindBy(id="com.tnaot.news:id/et_comment_input")
    MobileElement commentInput;

    /** 资讯详情-发布按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_comment_push")
    MobileElement commentPush;

    /** 资讯详情-评论图标 */
    @AndroidFindBy(xpath="待定")
    MobileElement tabMine;

    /** 资讯详情-收藏图标 */
    @AndroidFindBy(id="com.tnaot.news:id/ivFavorite")
    MobileElement ivFavorite;

    /** 资讯详情-分享图标 */
    @AndroidFindBy(id="com.tnaot.news:id/ivShare2")
    MobileElement ivShare2;

    /** 资讯详情-分享-Facebook */
    @AndroidFindBy(id="com.tnaot.news:id/tv_more_facebook")
    MobileElement moreFacebook;

    /** 资讯详情-分享-Messager */
    @AndroidFindBy(id="com.tnaot.news:id/tv_more_messenger")
    MobileElement moreMessenger;

    /** 资讯详情-分享-微信 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_more_wechat")
    MobileElement moreWechat;

    /** 资讯详情-分享-朋友圈 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_more_moments")
    MobileElement moreMoments;

    /** 资讯详情-分享-Line */
    @AndroidFindBy(id="com.tnaot.news:id/tv_more_line")
    MobileElement moreLine;

    /** 资讯详情-分享-Twitter */
    @AndroidFindBy(id="com.tnaot.news:id/tv_more_twitter")
    MobileElement moreTwitter;

    /** 资讯详情-分享-QQ */
    @AndroidFindBy(id="com.tnaot.news:id/tv_more_qq")
    MobileElement moreQq;

    /** 资讯详情-分享-QQ空间 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_more_qqzone")
    MobileElement moreQqZone;

    /** 资讯详情-分享-复制链接 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_more_copy_link")
    MobileElement copyLink;

    /** 资讯详情-分享-收藏 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_more_favorite")
    MobileElement moreFavorite;

    /** 资讯详情-分享-举报文章 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_more_report_news")
    MobileElement reportNews;

    /** 资讯详情-分享-举报文章-理由-低俗色情 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_vulgar")
    MobileElement vulgarContent;

    /** 资讯详情-分享-举报文章-理由-标题党 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_fake_title")
    MobileElement fakeTitle;

    /** 资讯详情-分享-举报文章-理由-内容不实 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_fake_content")
    MobileElement fakeContent;

    /** 资讯详情-分享-举报文章-理由-旧闻重复 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_same_content")
    MobileElement sameContent;

    /** 资讯详情-分享-举报文章-理由-垃圾内容 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_garbage_content")
    MobileElement garbageContent;


    /** 资讯详情-分享-转发 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_more_republish")
    MobileElement moreRepublish;

    /** 资讯详情-分享-转发页面-取消 */
    @AndroidFindBy(id="com.tnaot.news:id/tvCancel")
    MobileElement tvCancel;

    /** 资讯详情-分享-转发页面-发布 */
    @AndroidFindBy(id="com.tnaot.news:id/tvRelease")
    MobileElement tvRelease;

    /** 资讯详情-分享-转发页面-文本编辑框 */
    @AndroidFindBy(id="com.tnaot.news:id/editText")
    MobileElement editText;

    /** 资讯详情-分享-转发页面-勾选同时并评论 */
    @AndroidFindBy(id="com.tnaot.news:id/ivCheck")
    MobileElement ivCheck;



    /** 资讯详情-分享-系统分享 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_more_share_to_system")
    MobileElement sysShare;

    /** 资讯详情-分享-取消按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_more_cancel")
    MobileElement cancelButton;




    /** 资讯详情-评论列表-热门 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_hot_comments")
    MobileElement hotComments;

    /** 资讯详情-评论列表-最新 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_newest_comments")
    MobileElement newestComments;

    /** 资讯详情-评论列表-评论第一条 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_content")
    @AndroidFindBy(id="com.tnaot.news:id/ll_parent")
    MobileElement llParent;

    /** 资讯详情-评论列表-评论点赞 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_like_count")
    @AndroidFindBy(id="com.tnaot.news:id/tv_like_count")
    MobileElement likeCount;

    /** 资讯详情-评论列表-评论删除 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_delete_comment")
    @AndroidFindBy(id="com.tnaot.news:id/tv_delete_comment")
    MobileElement deleteComment;
    /** 资讯详情-评论列表-评论删除-确定 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_right")
    MobileElement deleteCommentAccept;
    /** 资讯详情-评论列表-评论删除-取消 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_left")
    MobileElement deleteCommentDismiss;




    /** 资讯详情-评论列表-长按评论复制 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_copy")
    MobileElement commentCopy;

    /** 资讯详情-评论列表-长按评论举报 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_report")
    MobileElement commentReport;
    /** 资讯详情-评论列表-长按评论举报-低俗色情 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_vulgar")
    MobileElement comReportReason1;
    /** 资讯详情-评论列表-长按评论举报-欺诈诱导 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_cheat")
    MobileElement comReportReason2;
    /** 资讯详情-评论列表-长按评论举报-营销广告 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_ad")
    MobileElement comReportReason3;
    /** 资讯详情-评论列表-长按评论举报-恶意攻击 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_attack")
    MobileElement comReportReason4;



//    /** 资讯详情-评论列表-评论第一条-详情-下方的回复评论输入框 */
//    @AndroidFindBy(id="com.tnaot.news:id/et_comment_input")
//    MobileElement commentInput;
//
//    /** 资讯详情-评论列表-评论第一条-详情-下方的发布按钮 */
//    @AndroidFindBy(id="com.tnaot.news:id/tv_comment_push")
//    MobileElement commentPush;

    /** 图文资讯详情-换一批 */
    //@FindElementBy(type = "name", value = "换一批")
    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text, '换一批')]")
    MobileElement changeContactList;

    /** 图文资讯详情-换一批-延展阅读列表第一条数据-资讯标题 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/cn.bingoogolapple.swipebacklayout.BGASwipeBackLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView")
    MobileElement contactListTitle;

    /** 资讯详情-返回按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/ivBack")
    MobileElement backButton;

    /** 资讯详情-阅读资讯30秒-获取金币弹窗 */
    @AndroidFindBy(id="com.tnaot.news:id/ivBackground")
    MobileElement getCoinsOverlay;


    /** 图集资讯详情-换一批-四条相关资讯图集 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/textView")
    @AndroidFindBy(id="com.tnaot.news:id/textView")
    MobileElement relativeNewsList;
    /** 图集资讯详情-图片页数 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_img_count")
    @AndroidFindBy(id="com.tnaot.news:id/tv_img_count")
    MobileElement imgCount;


    /** 资讯列表-资讯title */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_title")
    //@AndroidFindBy(id="com.tnaot.news:id/tv_title")
    MobileElement newsTitleList;
    /** 资讯列表-置顶-红色字样 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_top")
    //@AndroidFindBy(id="com.tnaot.news:id/tv_title")
    MobileElement topNewsListLogo;











    /** 视频tab键 */
    @AndroidFindBy(id="com.tnaot.news:id/rlVideo")
    MobileElement rlVideo;

    /** 首页tab键 */
    @AndroidFindBy(id="com.tnaot.news:id/rlLife")
    MobileElement rlLife;

    /** 动态tab键 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_dynamic")
    MobileElement rlDynamic;

    /** 我的tab键 */
    @AndroidFindBy(id="com.tnaot.news:id/rlMine")
    MobileElement rlMine;


    /** 热搜词输入框 */
    @AndroidFindBy(id="com.tnaot.news:id/ll_search")
    MobileElement searchText;
    /** 热搜词编辑框-输入内容 */
    @AndroidFindBy(id="com.tnaot.news:id/et_search_keywords")
    MobileElement searchKeywords;
    /** 热搜词编辑框-搜索按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_search")
    MobileElement searchButton;
    /** 热搜词编辑框-搜索按钮-搜索结果-图片 */
    @AndroidFindBy(xpath="//*[contains(@text, '图片')]")
    MobileElement imageTab;
    /** 热搜词编辑框-搜索按钮-搜索结果-视频 */
    @AndroidFindBy(xpath="//*[contains(@text, '视频')]")
    MobileElement videoTab;
    /** 热搜词编辑框-搜索按钮-搜索结果-生活 */
    @AndroidFindBy(xpath="//*[contains(@text, '生活')]")
    MobileElement lifeTab;
    /** 热搜词编辑框-搜索按钮-搜索结果-综合 */
    //@AndroidFindBy(xpath="//*[contains(@text, '综合')]")
    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text, '综合')]")
    MobileElement comprehensiveTab;

    /** 热搜词编辑框-搜索按钮-搜索结果-图片、视频、综合-列表中的资讯标题 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_title")
    MobileElement searchNewsListTitle;
    /** 热搜词编辑框-搜索按钮-搜索结果-生活列表中的生活标题 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_life_content")
    MobileElement searchLifeListTitle;











}
