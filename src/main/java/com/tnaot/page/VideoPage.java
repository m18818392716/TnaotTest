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
public class VideoPage extends AppiumBaseExecutor {

    public VideoPage(AppiumDriver<?> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    /** 视频-频道header */
    @AndroidFindBy(id="com.tnaot.news:id/tab_channel")
    WebElement videoHeader;

    /** 视频列表-播放按钮 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/start")
    WebElement startOpen;

    /** 视频列表-播放次数 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_video_play_count")
    WebElement openCount;

    /** 视频列表-播放时长 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_duration")
    WebElement openTimes;

    /** 视频列表-点击有效区域-查看视频详情 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/rl_video_author")
    WebElement viewDetails;

    /** 视频列表-视频标题 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/title")
    WebElement viewTitle;

    /** 视频列表-作者 详情里面的作者与列表中的作者控件一致 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_author")
    WebElement tvAuthor;

    /** 视频列表-评论数 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/tv_comment_count")
    WebElement commentCount;

    /** 视频列表-分享按钮 */
    @FindElementBy(type = "id", value = "com.tnaot.news:id/iv_video_share")
    WebElement videoShare;


    /** 视频详情-标题 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_video_title")
    WebElement videoTitle;

    /** 视频详情-作者 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_author")
    WebElement videoAuthor;


    /** 视频详情-发布时间 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_release_time")
    WebElement videoReleaseTime;

    /** 视频详情-点赞 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_like_count")
    WebElement videoLikeCount;

    /** 视频详情-点踩 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_dislike_count")
    WebElement videoDislikeCount;

    /** 视频详情-重播 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_video_replay")
    WebElement videoReplay;
    /** 视频详情-分享-Twitter */
    @AndroidFindBy(id="com.tnaot.news:id/tv_share_twitter")
    WebElement videoTwitter;
    /** 视频详情-分享-Facebook */
    @AndroidFindBy(id="com.tnaot.news:id/tv_share_facebook")
    WebElement videoFacebook;
    /** 视频详情-分享-Messenger */
    @AndroidFindBy(id="com.tnaot.news:id/tv_share_messenger")
    WebElement videoMessenger;
    /** 视频详情-分享-Line */
    @AndroidFindBy(id="com.tnaot.news:id/tv_share_line")
    WebElement videoLine;

    /** 视频详情-分享到-twitter */
    @AndroidFindBy(id="com.tnaot.news:id/iv_video_share_twitter")
    WebElement videoShareTwitter;
    /** 视频详情-分享到-facebook */
    @AndroidFindBy(id="com.tnaot.news:id/iv_video_share_facebook")
    WebElement videoShareFacebook;

    /** 视频详情-播放次数 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_video_play_times")
    WebElement videoPlayTimes;


    /** 视频详情-返回按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_back")
    WebElement backButton;













}
