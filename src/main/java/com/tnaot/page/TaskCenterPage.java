package com.tnaot.page;

import com.tnaot.core.AppiumBaseExecutor;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


@Data
public class TaskCenterPage extends AppiumBaseExecutor {

    public TaskCenterPage(AppiumDriver<?> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    /** 左上方返回按钮 */
    @AndroidFindBy(id="com.tnaot.news:id/ivBack")
    WebElement backButton;

    /** 开启宝箱 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_box_tip")
    WebElement boxTip;
    /** 开启宝箱-弹窗 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_title")
    WebElement boxOverlayText;
    /** 开启宝箱-关闭弹窗 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_box_close")
    WebElement closeBoxTip;


    /** 签到拿金币 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_sign")
    WebElement signButton;
    /** 签到拿金币-弹窗 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_value")
    WebElement signOverlayText;
    /** 签到拿金币-关闭弹窗 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_box_close")
    WebElement closeSignButton;


    /** 任务中心-新手任务-输入邀请码 */
    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_task_title'][contains(@text, '输入邀请码')]")
    WebElement inputInviteCode;
    /** 去完成 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_go2")
    WebElement toFinished;
    /** 任务中心-新手任务-输入邀请码-输入向推荐人索取的邀请码 */
    @AndroidFindBy(id="com.tnaot.news:id/editText")
    WebElement editText;
    /** 任务中心-新手任务-输入邀请码-输入向推荐人索取的邀请码-立即领取/完成 */
    @AndroidFindBy(id="com.tnaot.news:id/tvConfirm")
    WebElement tvConfirm;
    /** 任务中心-新手任务-输入邀请码-输入向推荐人索取的邀请码-立即领取-文本（填写邀请码成功） */
    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text, '填写邀请码成功')]")
    WebElement getConinsText1;
    /** 任务中心-新手任务-输入邀请码-输入向推荐人索取的邀请码-立即领取-文本（恭喜您获得） */
    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text, '恭喜您获得')]")
    WebElement getConinsText2;
    /** 任务中心-新手任务-输入邀请码-输入向推荐人索取的邀请码-立即领取-文本（200金币） */
    @AndroidFindBy(id="com.tnaot.news:id/tvCoin")
    WebElement getCoinsValue;








    /** 任务中心-日常任务-阅读资讯 */
    @AndroidFindBy(id="//*[@resource-id='com.tnaot.news:id/tv_task_title'][contains(@text, '阅读资讯')]")
    WebElement readNews;
    /** 任务中心-日常任务--阅读资讯-去完成 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_go2")
    WebElement toReadNews;
    /** 阅读资讯30秒-获取金币-80金币 */
    @AndroidFindBy(id="com.tnaot.news:id/tvCoins")
    WebElement getCoins;

    /** 任务中心-日常任务-邀请好友 */
    @AndroidFindBy(id="//*[@resource-id='com.tnaot.news:id/tv_task_title'][contains(@text, '邀请好友')]")
    WebElement inviteFriends;

    /** 任务中心-日常任务-阅读推送文章 */
    @AndroidFindBy(id="//*[@resource-id='com.tnaot.news:id/tv_task_title'][contains(@text, '阅读推送文章')]")
    WebElement readPushAticles;

    /** 任务中心-日常任务-分享被阅读 */
    @AndroidFindBy(id="//*[@resource-id='com.tnaot.news:id/tv_task_title'][contains(@text, '分享被阅读')]")
    WebElement shareToBeRead;

    /** 任务中心-日常任务-评论被点赞 */
    @AndroidFindBy(id="//*[@resource-id='com.tnaot.news:id/tv_task_title'][contains(@text, '评论被点赞')]")
    WebElement commentsByThumbUp;

    /** 任务中心-日常任务-动态被点赞 */
    @AndroidFindBy(id="//*[@resource-id='com.tnaot.news:id/tv_task_title'][contains(@text, '动态被点赞')]")
    WebElement dynamicByThumbUp;

    /** 任务中心-日常任务-转盘抽奖 */
    @AndroidFindBy(id="//*[@resource-id='com.tnaot.news:id/tv_task_title'][contains(@text, '转盘抽奖')]")
    WebElement rotaryDraw;




//    /** 输入邀请码-展开 */
//    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_task_title'][contains(@text, '输入邀请码')]")
//    WebElement rlMine;
//    /** 去完成 */
//    @AndroidFindBy(id="com.tnaot.news:id/tv_go2")
//    WebElement rlMine;
//
//
//
//    /** 邀请好友 */
//    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_task_title'][contains(@text, '邀请好友')]")
//    WebElement rlMine;
//    /** 去完成 */
//    @AndroidFindBy(id="com.tnaot.news:id/tv_go2")
//    WebElement rlMine;
//
//
//    /** 阅读资讯 */
//    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_task_title'][contains(@text, '阅读资讯')]")
//    WebElement rlMine;
//    /** 去完成 */
//    @AndroidFindBy(id="com.tnaot.news:id/tv_go2")
//    WebElement rlMine;
//
//
//    /** 阅读推送文章 */
//    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_task_title'][contains(@text, '阅读推送文章')]")
//    WebElement rlMine;
//    /** 去完成 */
//    @AndroidFindBy(id="com.tnaot.news:id/tv_go2")
//    WebElement rlMine;
//
//
//    /** 分享被阅读 */
//    @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_task_title'][contains(@text, '分享被阅读')]")
//    WebElement rlMine;
//    /** 去完成 */
//    @AndroidFindBy(id="com.tnaot.news:id/tv_go2")
//    WebElement rlMine;
//
//
//    /** 评论被点赞 */
//   @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_task_title'][contains(@text, '评论被点赞')]")
//    WebElement rlMine;
//    /** 去完成 */
//    @AndroidFindBy(id="com.tnaot.news:id/tv_go2")
//    WebElement rlMine;
//
//
//    /** 动态被点赞 */
//   @AndroidFindBy(xpath="//*[@resource-id='com.tnaot.news:id/tv_task_title'][contains(@text, '动态被点赞')]")
//    WebElement rlMine;
//    /** 去完成 */
//    @AndroidFindBy(id="com.tnaot.news:id/tv_go2")
//    WebElement rlMine;
}
