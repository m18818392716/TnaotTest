package com.tnaot.demo;
import com.tnaot.anotation.FindElementBy;
import com.tnaot.page.LoginPage;
import com.tnaot.utils.AppiumUtil;
import com.tnaot.utils.ExcelUtil;
import com.tnaot.utils.Locator;
import com.tnaot.utils.SelectDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class LoginPageTest {

    public static Map<String,WebElement> elementList = new HashMap<String,WebElement>();


    @Test
    public void run(ITestContext context) {
        initProject(context);
        List<String> findElementBys = new ArrayList<String>();
        Collections.addAll(findElementBys, "id","xpath");
        trackUseCases(findElementBys, LoginPage.class);

        for (Map.Entry<String,WebElement> entry : elementList.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

        elementList.get("tvLanguage").click();
        AppiumUtil.sleep(5000);

    }

    public void initProject(ITestContext context){
        System.out.println("初始化项目开始！");
        AppiumUtil appiumUtil = new AppiumUtil();
        SelectDriver selectDriver = new SelectDriver();
        selectDriver.selectDriver(context, appiumUtil);
        AppiumUtil.sleep(5000);
    }

    public static void trackUseCases(List<String> findElementBys, Class<?> cl) {

        for (Field m : cl.getDeclaredFields()) {
            //获得注解的对象
            FindElementBy uc = m.getAnnotation(FindElementBy.class);
            if (uc != null) {
                System.out.println("Found Use Case:" + uc.type() + " ---- "
                        + uc.value());
                findElementBys.remove(new String(uc.type()));
                WebElement webElement = AppiumUtil.getWebElement(new Locator(uc.value(), Locator.ByType.valueOf(uc.type())));
                elementList.put(m.getName(),webElement);
            }
        }
        for (String i : findElementBys) {
            System.out.println("Warning: Missing use case-" + i);
        }

    }

    @AfterSuite
    public void quitProject(ITestContext context){
        System.out.println("项目完结！！！！");
        SelectDriver.getAppiumDriver().quit();
    }
}
