package com.tnaot.page;

import com.tnaot.core.AppiumBaseExecutor;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.support.PageFactory;


@Data
public class TaskCenterPage extends AppiumBaseExecutor {

    public TaskCenterPage(AppiumDriver<?> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    /** 左上方返回按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/ivBack")
    MobileElement backButton;

    /** 开启宝箱 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_box_tip")
    MobileElement boxTip;
    /** 开启宝箱-弹窗 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_title")
    MobileElement boxOverlayText;
    /** 开启宝箱-关闭弹窗 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_box_close")
    MobileElement closeBoxTip;


    /** 签到拿金币 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_sign")
    MobileElement signButton;
    /** 签到拿金币-弹窗 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_value")
    MobileElement signOverlayText;
    /** 签到拿金币-关闭弹窗 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_box_close")
    MobileElement closeSignButton;


    /** 任务中心-新手任务-输入邀请码 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_task_title'][contains(@text, '输入邀请码')]")
    MobileElement inputInviteCode;
    /** 去完成 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_go2")
    MobileElement toFinished;
    /** 任务中心-新手任务-输入邀请码-输入向推荐人索取的邀请码 */
    @AndroidFindBy(id="com.tnaot.news:id/editText")
    MobileElement editText;
    /** 任务中心-新手任务-输入邀请码-输入向推荐人索取的邀请码-立即领取/完成 */
    @AndroidFindBy(id="com.tnaot.news:id/tvConfirm")
    MobileElement tvConfirm;
    /** 任务中心-新手任务-输入邀请码-输入向推荐人索取的邀请码-立即领取-文本（填写邀请码成功） */
    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text, '填写邀请码成功')]")
    MobileElement getConinsText1;
    /** 任务中心-新手任务-输入邀请码-输入向推荐人索取的邀请码-立即领取-文本（恭喜您获得） */
    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text, '恭喜您获得')]")
    MobileElement getConinsText2;
    /** 任务中心-新手任务-输入邀请码-输入向推荐人索取的邀请码-立即领取-文本（200金币） */
    @AndroidFindBy(id="com.tnaot.news:id/tvCoin")
    MobileElement getCoinsValue;








    /** 任务中心-日常任务-阅读资讯 */
    @AndroidFindBy(id="//*[@resource-id='com.tnaot.news:id/tv_task_title'][contains(@text, '阅读资讯')]")
    MobileElement readNews;
    /** 任务中心-日常任务--阅读资讯-去完成 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_go2")
    MobileElement toReadNews;
    /** 阅读资讯30秒-获取金币 */
    @AndroidFindBy(id="com.tnaot.news:id/tvCoins")
    MobileElement getCoins;

    /** 任务中心-日常任务-邀请好友 */
    @AndroidFindBy(id="//*[@resource-id='com.tnaot.news:id/tv_task_title'][contains(@text, '邀请好友')]")
    MobileElement inviteFriends;

    /** 任务中心-日常任务-阅读推送文章 */
    @AndroidFindBy(id="//*[@resource-id='com.tnaot.news:id/tv_task_title'][contains(@text, '阅读推送文章')]")
    MobileElement readPushAticles;

    /** 任务中心-日常任务-分享被阅读 */
    @AndroidFindBy(id="//*[@resource-id='com.tnaot.news:id/tv_task_title'][contains(@text, '分享被阅读')]")
    MobileElement shareToBeRead;

    /** 任务中心-日常任务-评论被点赞 */
    @AndroidFindBy(id="//*[@resource-id='com.tnaot.news:id/tv_task_title'][contains(@text, '评论被点赞')]")
    MobileElement commentsByThumbUp;

    /** 任务中心-日常任务-动态被点赞 */
    @AndroidFindBy(id="//*[@resource-id='com.tnaot.news:id/tv_task_title'][contains(@text, '动态被点赞')]")
    MobileElement dynamicByThumbUp;

    /** 任务中心-日常任务-转盘抽奖 */
    @AndroidFindBy(id="//*[@resource-id='com.tnaot.news:id/tv_task_title'][contains(@text, '转盘抽奖')]")
    MobileElement rotaryDraw;




//    /** 输入邀请码-展开 */
//    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_task_title'][contains(@text, '输入邀请码')]")
//    MobileElement rlMine;
//    /** 去完成 */
//    @AndroidFindBy(id="com.tnaot.news:id/tv_go2")
//    MobileElement rlMine;
//
//
//
//    /** 邀请好友 */
//    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_task_title'][contains(@text, '邀请好友')]")
//    MobileElement rlMine;
//    /** 去完成 */
//    @AndroidFindBy(id="com.tnaot.news:id/tv_go2")
//    MobileElement rlMine;
//
//
//    /** 阅读资讯 */
//    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_task_title'][contains(@text, '阅读资讯')]")
//    MobileElement rlMine;
//    /** 去完成 */
//    @AndroidFindBy(id="com.tnaot.news:id/tv_go2")
//    MobileElement rlMine;
//
//
//    /** 阅读推送文章 */
//    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_task_title'][contains(@text, '阅读推送文章')]")
//    MobileElement rlMine;
//    /** 去完成 */
//    @AndroidFindBy(id="com.tnaot.news:id/tv_go2")
//    MobileElement rlMine;
//
//
//    /** 分享被阅读 */
//    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_task_title'][contains(@text, '分享被阅读')]")
//    MobileElement rlMine;
//    /** 去完成 */
//    @AndroidFindBy(id="com.tnaot.news:id/tv_go2")
//    MobileElement rlMine;
//
//
//    /** 评论被点赞 */
//   @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_task_title'][contains(@text, '评论被点赞')]")
//    MobileElement rlMine;
//    /** 去完成 */
//    @AndroidFindBy(id="com.tnaot.news:id/tv_go2")
//    MobileElement rlMine;
//
//
//    /** 动态被点赞 */
//   @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_task_title'][contains(@text, '动态被点赞')]")
//    MobileElement rlMine;
//    /** 去完成 */
//    @AndroidFindBy(id="com.tnaot.news:id/tv_go2")
//    MobileElement rlMine;
}
