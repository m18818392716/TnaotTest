package com.tnaot.step;

import com.tnaot.page.LoginPage;
import com.tnaot.page.NewsPage;
import com.tnaot.page.TaskCenterPage;
import com.tnaot.utils.AppiumUtil;
import com.tnaot.utils.SelectDriver;
import com.tnaot.utils.listener.TestNGRetry;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import lombok.Data;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

@Data
public class LoginStep implements ITest {

    @BeforeSuite
    public void initProject(ITestContext context) {
        AppiumUtil appiumUtil = new AppiumUtil();
        SelectDriver selectDriver = new SelectDriver();
        AppiumDriver appiumDriver = selectDriver.selectDriver(context, appiumUtil);
        System.out.println("--------------"+appiumDriver);
    }

    /**失败用例重跑*/
    //@Test(retryAnalyzer= TestNGRetry.class)
    @Test
    public void login() throws InterruptedException {

        LoginPage loginPage = new LoginPage(SelectDriver.getAppiumDriver());
        NewsPage newsPage = new NewsPage(SelectDriver.getAppiumDriver());
        TaskCenterPage taskCenterPage = new TaskCenterPage(SelectDriver.getAppiumDriver());

//        PageFactory.initElements(new AppiumFieldDecorator(loginPage.getDriver()), loginPage);

        System.out.println("--------------"+loginPage);

        if(loginPage.getDialogContainer().isDisplayed()) {

            loginPage.getAllowButton().click();

        }

        Thread.sleep(35000);


        loginPage.getRlMine().click();
        loginPage.getPhoneLoginType().click();
        Thread.sleep(5000);
        loginPage.getAreaText().click();
        Thread.sleep(3000);
        loginPage.getAreaSelect().click();
        loginPage.getPhoneText().sendKeys("18818392716");
        Thread.sleep(3000);
        loginPage.getPwdText().sendKeys("cq183158");
        Thread.sleep(3000);
        loginPage.getLoginButton().click();
        Thread.sleep(3000);

        taskCenterPage.getBackButton().click();
        Thread.sleep(3000);

//        //点击“资讯”
//        newsPage.getRlHome().click();
        Thread.sleep(10000);

        //点击“第一条资讯查看详情”
//        loginPage.getNewsOne().click();

        //点击“收藏”按钮
        if(!loginPage.getIsCollect().isSelected()) {
            AndroidDriver androidDriver = (AndroidDriver)SelectDriver.getAppiumDriver();
            loginPage.getIsCollect().click();
//            AppiumUtil.assertToast(androidDriver,"收藏成功");
            AppiumUtil.assertToast(androidDriver,"取消收藏成功");
        }



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


    @Override
    public String getTestName() {
//        return String.format("%s(%s)", testCase.getId(), testCase.getDescription());
        return "loginTest";
    }

    @AfterSuite
    public void quitProject(){

        System.out.println("项目完结！！！！");
        SelectDriver.getAppiumDriver().quit();
    }


}
