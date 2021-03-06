package com.tnaot.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.tnaot.enums.DriverContext;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.Data;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import org.testng.ITestContext;
import io.appium.java_client.AppiumDriver;

@SuppressWarnings("unchecked")
@Component
@Data
public class SelectDriver {

    private DriverContext driverContext = DriverContext.NATIVE_APP;

    //声明driver
//    public  AppiumDriver<WebElement> driver;
    public static ThreadLocal<AppiumDriver> appiumDriver = new ThreadLocal<>();
    //声明DesiredCapabilities
    public DesiredCapabilities capabilities;
    //声明ITestContext，用于获取testng配置文件内容
    public ITestContext testContext;
    //测试环境environment
    public String environment;
    //appium server地址
    public String serverURL;
    //测试引擎名字
    public String automationName;
    //测试平台名字
    public String platformName;
    //测试平台版本号
    public String platformVersion;
    //设备名字
    public String deviceName;
    //ios app的路径
    public String iosAppPath;
    //android app路径
    public String androidAppPath;
    //android app的 package
    public String appPackage;
    //android app的activity
    public String appActivity;
    //安卓独有 - 是否使用unicode键盘，使用此键盘可以输入中文字符
    public boolean unicodeKeyboard;
    //android独有 - 是否重置键盘，如果设置了unicodeKeyboard键盘，可以将此参数设置为true，然后键盘会重置为系统默认的
    public boolean resetKeyboard;
    //是否覆盖已有的seesssion，这个用于多用例执行，如果不设置的话，会提示前一个session还没有结束，用例就不能继续执行了
    public boolean sessionOverride;
    //暂停的等待时间
    public int sleepTime;
    //元素等待超时时间
    public int elementTimeOut;
    //app文件路径，主要存储的是app的名字
    public String appFilePath;
    //webview的名字或者叫标识符,一般以WEBVIEW开头，例如WEBVIEW_com.microsoft.bing
    public final static String WEBVIEW_NAME = null;
    //原生app的名字或者标识符，一般是NATIVE_APP
    public final static String NATIVEAPP_NAME = null;
    //实例化本类的日志输出对象
    public static Logger logger = Logger.getLogger(SelectDriver.class);

    public AppiumDriver<WebElement> selectDriver(ITestContext context, AppiumUtil appiumUtil) {
        //测试环境environment
        //environment = context.getCurrentXmlTest().getParameter("environment");

        //通过testng的xml文件获取serverURL参数值，并赋给  serverURL变量
        serverURL = context.getCurrentXmlTest().getParameter("serverURL");
//        //通过testng的xml文件获取automationName参数值，并赋给  automationName变量
        automationName = context.getCurrentXmlTest().getParameter("automationName");
        //通过testng的xml文件获取platformName参数值，并赋给  platformName变量
        platformName = context.getCurrentXmlTest().getParameter("platformName");
        //通过testng的xml文件获取platformVersion参数值，并赋给  platformVersion变量
        platformVersion = context.getCurrentXmlTest().getParameter("platformVersion");
        //通过testng的xml文件获取deviceName参数值，并赋给  deviceName变量
        deviceName = context.getCurrentXmlTest().getParameter("deviceName");
        //通过testng的xml文件获取androidAppPath参数值，并赋给  androidAppPath变量
        androidAppPath = context.getCurrentXmlTest().getParameter("androidAppPath");
        //通过testng的xml文件获取iosAppPath参数值，并赋给  iosAppPath变量
        iosAppPath = context.getCurrentXmlTest().getParameter("iosAppPath");
        //通过testng的xml文件获取appPackage参数值，并赋给  appPackage变量
        appPackage = context.getCurrentXmlTest().getParameter("appPackage");

//        if (androidAppPath.contains("release")) {
//            ExcelUtil.excelPath = "ProduceTnaot.xls";
//        } else {
//            ExcelUtil.excelPath = "TestTnaot_1.xls";
//        }


        //通过testng的xml文件获取appActivity参数值，并赋给  appActivity变量
        appActivity = context.getCurrentXmlTest().getParameter("appActivity");
//        //通过testng的xml文件获取unicodeKeyboard参数值，并赋给  unicodeKeyboard变量
//        unicodeKeyboard = Boolean.parseBoolean(context.getCurrentXmlTest().getParameter("unicodeKeyboard"));
//        //通过testng的xml文件获取resetKeyboard参数值，并赋给  resetKeyboard变量
//        resetKeyboard = Boolean.parseBoolean(context.getCurrentXmlTest().getParameter("resetKeyboard"));
//        //通过testng的xml文件获取sessionOverride参数值，并赋给  sessionOverride变量
//        sessionOverride = Boolean.parseBoolean(context.getCurrentXmlTest().getParameter("sessionOverride"));
//        //通过testng的xml文件获取sleepTime参数值，并赋给  sleepTime变量
//        sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));
        //通过testng的xml文件获取elementTimeOut参数值，并赋给  elementTimeOut变量
        elementTimeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("elementTimeOut"));
        //通过testng的xml文件获取appFilePath参数值，并赋给  appFilePath变量
        appFilePath = context.getCurrentXmlTest().getParameter("appFilePath");
        this.testContext = context;
        capabilities = new DesiredCapabilities();
        //告诉测试程序，当前项目目录在哪里
        File classpathRoot = new File(System.getProperty("user.dir"));
        //设置capability，以便和appium创建session
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("sessionOverride", sessionOverride);

        logger.info("--------初始化Driver开始--------");
        logger.info("ServerURL: " + serverURL);
        logger.info("AutomationName: " + automationName);
        logger.info("PlatformName: " + platformName);
        logger.info("PlatformVersion: " + platformVersion);
        logger.info("DeviceName: " + deviceName);
        logger.info("ElementTimeOut: " + elementTimeOut + "s");

        //如果测试平台是android的话，执行下面这个if语句内容
        if (platformName.equalsIgnoreCase("android")) {
            /**
             * 设置和android  测试相关的capability并实例化driver对象
             * */
            if (environment.equalsIgnoreCase("test")) {// 测试环境
                ExcelUtil.excelPath = "TestTnaot.xls";
                //File app = new File(classpathRoot, "src/main/resources/news_v3.2.0_google_debug_20190904.apk");
                File app = new File(classpathRoot, "src/main/resources/TNAOT_Android_v5.2.0_gtest_20210319.apk");
                logger.info("App: " + app.getAbsolutePath());
                capabilities.setCapability("app", app.getAbsolutePath());
            } else {// 正式环境
                ExcelUtil.excelPath = "ProduceTnaot.xls";
                File app = new File(classpathRoot, "src/main/resources/news_v5.1.0_googleNewspro_test_20210128.apk");
                logger.info("App: " + app.getAbsolutePath());
                capabilities.setCapability("app", app.getAbsolutePath());
            }
            capabilities.setCapability("unicodeKeyboard", unicodeKeyboard);
            capabilities.setCapability("resetKeyboard", resetKeyboard);
            capabilities.setCapability("automationName", automationName);
            //capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
            capabilities.setCapability("appPackage", appPackage);
            capabilities.setCapability("appActivity", appActivity);
            capabilities.setCapability(MobileCapabilityType.NO_RESET, false); // 打开App清除本地数据
            appiumDriver.set(appiumUtil.getDriver(serverURL, capabilities, platformName));
            testContext.setAttribute("APPIUM_DRIVER", appiumDriver.get());
//            logger.info(PropertiesDataProvider.getTestData(appFilePath, appPackage)+"已经启动");这个地方刚才是这里出的错。这里的意思是获取你配置文件里面的值打印出来。也就是properties里面的。你里面没有写东西所以报错
            //this.getContextHandle(getAppiumDriver());

            //如果测试平台是ios的话，执行下面这个if语句内容
        } else if (platformName.equalsIgnoreCase("ios")) {
            /**
             * 设置和ios  测试相关的capability并实例化driver对象
             * */
            if (environment.equalsIgnoreCase("test")) {
                ExcelUtil.excelPath = "TestTnaot.xls";
                File app = new File(classpathRoot, "src/main/resources/Tnaot_test.ipa");
                logger.info("App: " + app.getAbsolutePath());
                capabilities.setCapability("app", app.getAbsolutePath());
            } else {
                ExcelUtil.excelPath = "ProduceTnaot.xls";
                File app = new File(classpathRoot, "src/main/resources/Tnaot_produce.ipa");
                logger.info("App: " + app.getAbsolutePath());
                capabilities.setCapability("app", app.getAbsolutePath());
            }
            //ios设置自动接收系统alert，注意IOS弹出的alert，APPIUM可以自动处理掉，支持ios8以上系统
            capabilities.setCapability("autoAcceptAlerts", true);
            appiumDriver.set(appiumUtil.getDriver(serverURL, capabilities, platformName));
            testContext.setAttribute("APPIUM_DRIVER", appiumDriver.get());
        } else {
            logger.error("--------初始化Driver失败--------");
            Assert.fail("初始化Driver失败");
        }
        getAppiumDriver().manage().timeouts().implicitlyWait(elementTimeOut, TimeUnit.SECONDS);

        logger.info("--------初始化Driver成功--------");

        //最后返回dirver对象
        return getAppiumDriver();

    }

    public static AppiumDriver getAppiumDriver() {
        return appiumDriver.get();
    }


    public void getContextHandle(AppiumDriver<WebElement> driver) {
        Set<String> context = null ;
        context = driver.getContextHandles();
        for(String contextName : context) {
            System.out.println(contextName);//打印当前上下文
            //if(contextName != null && contextName.contains("WEBVIEW_com.tnaot.news")){
            if(contextName.contains("WEBVIEW_com.tnaot.newspro")){
                driver.context("WEBVIEW_com.tnaot.newspro");//切换至H5页面
                System.out.println("已经进入webview");
                System.out.println("当前context" + driver.getContext());
                System.out.println(driver.getContext());
                //driver.findElement(By.className("none-accounts")).click();
                driver.getPageSource();
                return;
            }
            else {
                driver.context("NATIVE_APP");
                return;
            }
        }



//        for(int i=1;i<=5;i++){
//            context = driver.getContextHandles();
//            for(String contextName : context) {
//                System.out.println(contextName);//打印当前上下文
//                if(contextName!=null && contextName.contains("WEBVIEW_com.tnaot.news")||contextName.contains("WEBVIEW_com.tencent.mm:tools")){
//                    switchTo_WEBVIEW(driver);
//                    driver.getPageSource();
//                    return;
//                }
//                //if(i==20) assert false;
//            }
//            //Log.goSleep(1);
        AppiumUtil.sleep(500);

    }


    public void switchTo_WEBVIEW(AppiumDriver<WebElement> driver) {

//        String targetContext;
//        AppiumDriver appiumDriver = getAppiumDriver();
//        List<String> contextList = new ArrayList<String>(appiumDriver.getContextHandles());
//
//
//        if (DriverContext.WEBVIEW.equals(driverContext)) {
//            targetContext = contestList.get(contestList.size() - 1);
//
//        } else {
//            targetContext = contestList.get(0);
//        }
//
//        appiumDriver.context(targetContext);
//
//        this.driverContext = driverContext;
        //String str = appActivity;//检查当前APP
        try {
            if(appActivity.contains(".MainActivity")){
                //driver.context("WEBVIEW_com.tnaot.newspro");
                driver.context("WEBVIEW");
                return;
            }
        } catch (Exception e) {

        } finally{
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        }


    }

    public static void switchToWindowTitle(String windowTitle) {

        AppiumDriver driver = getAppiumDriver();
        try {
            String currentHandle = driver.getWindowHandle();
            Set<String> handles = driver.getWindowHandles();
            for (String s : handles) {
                if (s.equals(currentHandle))
                    continue;
                else {
                    driver.switchTo().window(s);
                    if (driver.getTitle().contains(windowTitle)) {
                        System.out.println("Switch to window: "
                                + windowTitle + " successfully!");
                        break;
                    } else
                        continue;
                }
            }
        } catch (NoSuchWindowException e) {
            System.out.println("Window: " + windowTitle
                    + " cound not found!" + e.fillInStackTrace());
        }
    }


    /**
     * Switch to NATIVE_APP or WEBVIEW
     * @param sWindow window name
     */
    private void switchToWindow(String sWindow) {
        LogManager.getLogger(this.getClass()).info("Swith to window: " + sWindow);
        Set<String> contextNames = SelectDriver.getAppiumDriver().getContextHandles();
        LogManager.getLogger(this.getClass()).info("Exists windows: " + contextNames.toString());
        for (String contextName : contextNames) {
            if (contextName.contains(sWindow)) {
                SelectDriver.getAppiumDriver().context(contextName);
                break;
            }
        }
    }


    public void swith_app(AndroidDriver AndroidDriver){
        //切换到源生app
        System.out.println(AndroidDriver.getContextHandles());//输出现有的context
        System.out.println("切换到NATIVE_APP");
        AndroidDriver.context("NATIVE_APP");

    }

    public void swith_web(AndroidDriver AndroidDriver){
        //切换到webview
        System.out.println(AndroidDriver.getContextHandles());
        System.out.println("切换到WEBVIEW_com.tnaot.newpro");
        AndroidDriver.context("WEBVIEW_com.tnaot.newspro");


        // 切换原生或者Webview
        AndroidDriver.context("WEBVIEW"); //切换到webview
        AndroidDriver.findElementById("").click(); //点击webview里边的元素，一个m站的网页元素。
        AndroidDriver.context("NATIVE_APP"); //切换到原生app

    }

}
