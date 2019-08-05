package com.tnaot.page;

import com.tnaot.core.AppiumBaseExecutor;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Data;

@Data
public class NewsPage extends AppiumBaseExecutor {

    public NewsPage(AppiumDriver<?> driver) {
        super(driver);
    }

    /** 资讯tab键 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_Home")
    MobileElement rlHome;

    /** 资讯详情-评论输入框 */
    @AndroidFindBy(id="com.tnaot.news:id/tvComment")
    MobileElement tvComment;

    /** 资讯详情-头像 */
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
    @AndroidFindBy(id="com.tnaot.news:id/ll_parent")
    MobileElement llParent;

    /** 资讯详情-评论列表-评论点赞 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_like_count")
    MobileElement likeCount;

    /** 资讯详情-评论列表-评论删除 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_delete_comment")
    MobileElement deleteComment;

//    /** 资讯详情-评论列表-评论第一条-详情-下方的回复评论输入框 */
//    @AndroidFindBy(id="com.tnaot.news:id/et_comment_input")
//    MobileElement commentInput;
//
//    /** 资讯详情-评论列表-评论第一条-详情-下方的发布按钮 */
//    @AndroidFindBy(id="com.tnaot.news:id/tv_comment_push")
//    MobileElement commentPush;

    /** 资讯详情-返回按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/ivBack")
    MobileElement backButton;





    /** 视频tab键 */
    @AndroidFindBy(id="com.tnaot.news:id/rlVideo")
    MobileElement rlVideo;

    /** 首页tab键 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_life")
    MobileElement rlLife;

    /** 动态tab键 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_dynamic")
    MobileElement rlDynamic;

    /** 我的tab键 */
    @AndroidFindBy(id="com.tnaot.news:id/rlMine")
    MobileElement rlMine;



    /** 热搜词输入框 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_search_hot_text")
    MobileElement searchText;



}
