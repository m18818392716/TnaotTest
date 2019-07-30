package com.tnaot.page;

import com.tnaot.core.AppiumBaseExecutor;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Data;

@Data
public class VedioPage extends AppiumBaseExecutor {

    public VedioPage(AppiumDriver<?> driver) {
        super(driver);
    }

    /** 我的 */
    @AndroidFindBy(id="cn.dbyl.young.tianqi:id/tab_home")
    MobileElement tabMine;

    /** 手机号登录 */
    @AndroidFindBy(id="cn.dbyl.young.tianqi:id/tab_personal")
    MobileElement phoneLoginType;

    /** 区域 */
    @AndroidFindBy(id="cn.dbyl.young.tianqi:id/tab_personal")
    MobileElement areaText;

    /** 手机号 */
    @AndroidFindBy(id="cn.dbyl.young.tianqi:id/tab_personal")
    MobileElement phoneText;

    /** 密码 */
    @AndroidFindBy(id="cn.dbyl.young.tianqi:id/tab_personal")
    MobileElement pwdText;

    /** 登录按钮 */
    @AndroidFindBy(id="cn.dbyl.young.tianqi:id/tab_personal")
    MobileElement loginButton;

}
