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
    /** 开启宝箱-关闭弹窗 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_box_close")
    MobileElement closeBoxTip;


    /** 签到拿金币 */
    @AndroidFindBy(id="com.tnaot.news:id/tv_sign")
    MobileElement signButton;
    /** 签到拿金币-关闭弹窗 */
    @AndroidFindBy(id="com.tnaot.news:id/iv_box_close")
    MobileElement closeSignButton;




//    /** 输入邀请码-展开 */
//    @AndroidFindBy(id="com.tnaot.news:id/iv_mine")
//    MobileElement rlMine;
//    /** 去完成 */
//    @AndroidFindBy(id="com.tnaot.news:id/iv_mine")
//    MobileElement rlMine;
//
//
//
//    /** 邀请好友 */
//    @AndroidFindBy(id="com.tnaot.news:id/iv_mine")
//    MobileElement rlMine;
//    /** 去完成 */
//    @AndroidFindBy(id="com.tnaot.news:id/iv_mine")
//    MobileElement rlMine;
//
//
//    /** 阅读资讯 */
//    @AndroidFindBy(id="com.tnaot.news:id/iv_mine")
//    MobileElement rlMine;
//    /** 去完成 */
//    @AndroidFindBy(id="com.tnaot.news:id/iv_mine")
//    MobileElement rlMine;
//
//
//    /** 阅读推送文章 */
//    @AndroidFindBy(id="com.tnaot.news:id/iv_mine")
//    MobileElement rlMine;
//    /** 去完成 */
//    @AndroidFindBy(id="com.tnaot.news:id/iv_mine")
//    MobileElement rlMine;
//
//
//    /** 分享被阅读 */
//    @AndroidFindBy(id="com.tnaot.news:id/iv_mine")
//    MobileElement rlMine;
//    /** 去完成 */
//    @AndroidFindBy(id="com.tnaot.news:id/iv_mine")
//    MobileElement rlMine;
//
//
//    /** 评论被点赞 */
//    @AndroidFindBy(id="com.tnaot.news:id/iv_mine")
//    MobileElement rlMine;
//    /** 去完成 */
//    @AndroidFindBy(id="com.tnaot.news:id/iv_mine")
//    MobileElement rlMine;
//
//
//    /** 动态被点赞 */
//    @AndroidFindBy(id="com.tnaot.news:id/iv_mine")
//    MobileElement rlMine;
//    /** 去完成 */
//    @AndroidFindBy(id="com.tnaot.news:id/iv_mine")
//    MobileElement rlMine;
}
