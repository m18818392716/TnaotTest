package com.tnaot.page;

import com.tnaot.core.AppiumBaseExecutor;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.support.PageFactory;

@Data
public class VideoPage extends AppiumBaseExecutor {

    public VideoPage(AppiumDriver<?> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    /** 视频-频道header */
    @AndroidFindBy(id="com.tnaot.news:id/tab_channel")
    MobileElement videoHeader;

    /** 视频列表-播放按钮 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ImageView\n")
    MobileElement startOpen;

    /** 视频列表-播放次数 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[1]")
    MobileElement openCount;

    /** 视频列表-播放时长 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[3]")
    MobileElement openTimes;

    /** 视频列表-点击有效区域-查看视频详情 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout")
    MobileElement viewDetails;

    /** 视频列表-视频标题 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.TextView")
    MobileElement viewTitle;

    /** 视频列表-作者 详情里面的作者与列表中的作者控件一致 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.TextView")
    MobileElement tvAuthor;

    /** 视频列表-评论数 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView")
    MobileElement commentCount;

    /** 视频列表-分享按钮 */
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.ImageView\n")
    MobileElement videoShare;


    /** 视频详情-标题 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_video_title")
    MobileElement videoTitle;

    /** 视频详情-作者 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_author")
    MobileElement videoAuthor;


    /** 视频详情-发布时间 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_release_time")
    MobileElement videoReleaseTime;

    /** 视频详情-点赞 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_like_count")
    MobileElement videoLikeCount;

    /** 视频详情-点踩 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_dislike_count")
    MobileElement videoDislikeCount;

    /** 视频详情-重播 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_video_replay")
    MobileElement videoReplay;
    /** 视频详情-分享-Twitter */
    @AndroidFindBy(id="com.tnaot.news:id/tv_share_twitter")
    MobileElement videoTwitter;
    /** 视频详情-分享-Facebook */
    @AndroidFindBy(id="com.tnaot.news:id/tv_share_facebook")
    MobileElement videoFacebook;
    /** 视频详情-分享-Messenger */
    @AndroidFindBy(id="com.tnaot.news:id/tv_share_messenger")
    MobileElement videoMessenger;
    /** 视频详情-分享-Line */
    @AndroidFindBy(id="com.tnaot.news:id/tv_share_line")
    MobileElement videoLine;

    /** 视频详情-分享到-twitter */
    @AndroidFindBy(id="com.tnaot.news:id/iv_video_share_twitter")
    MobileElement videoShareTwitter;
    /** 视频详情-分享到-facebook */
    @AndroidFindBy(id="com.tnaot.news:id/iv_video_share_facebook")
    MobileElement videoShareFacebook;

    /** 视频详情-播放次数 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_video_play_times")
    MobileElement videoPlayTimes;


    /** 视频详情-返回按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_back")
    MobileElement backButton;













}
