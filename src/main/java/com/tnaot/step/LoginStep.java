package com.tnaot.step;

import com.tnaot.page.LoginPage;
import com.tnaot.utils.AppiumUtil;
import com.tnaot.utils.SelectDriver;
import com.tnaot.utils.listener.TestNGRetry;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginStep {

    /**失败用例重跑*/
    @Test(retryAnalyzer= TestNGRetry.class)
    public void login(ITestContext context) {

        AppiumUtil appiumUtil = new AppiumUtil();
        SelectDriver selectDriver = new SelectDriver();
        AppiumDriver appiumDriver = selectDriver.selectDriver(context, appiumUtil);
        System.out.println("--------------"+appiumDriver);

        LoginPage loginPage = new LoginPage(appiumDriver);
//        PageFactory.initElements(new AppiumFieldDecorator(loginPage.getDriver()), loginPage);

        System.out.println("--------------"+loginPage);
        loginPage.getTabMine().click();
        loginPage.getPhoneLoginType().click();
        loginPage.getAreaText().click();
        loginPage.getPhoneText().sendKeys("18818392716");
        loginPage.getPwdText().sendKeys("cq183158");
        loginPage.getLoginButton().click();



//        loginPage.getOpenButton1().click();
//        loginPage.getOpenButton2().click();

        Assert.assertTrue(true);

//        return  new AppiumDriverWait(driver,DriverBase.stepInterval).until(new  ExpectedConditionForAppium<WebElement>(){
//  public WebElement apply(AppiumDriver driver){
//   WebElement element =  DriverBase.Andriver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\""+locator+"\")");
//   return element.isDisplayed() ? element : null;
//  }
// });
    }

    /**
     * ITestResult是TestNG提供的一个接口 结合@AfterMethod使用类似监听器 可以监听@Test方法的执行状态等信息
     * @param result
     */
    @AfterMethod
    public void ITestResult_Demo(ITestResult result){

        //如果失败或者成功 对@Test方法进行操作处理
        if(result.getStatus() == ITestResult.FAILURE){

            System.out.println("正在运行的方法是失败的方法："+result.getName());
        } else {
            System.out.println("正在运行的方法是成功的方法："+result.getName());
        }

    }


}
