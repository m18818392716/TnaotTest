package com.tnaot.core;

import com.tnaot.utils.AppiumAPI;
import com.tnaot.utils.Locator;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public abstract class AppiumBaseExecutor implements AppiumAPI {

    /** The driver. */
    private AppiumDriver<?> driver;

    /**
     * Instantiates a new appium base executor.
     *
     * @param driver
     *            the driver
     */
    public AppiumBaseExecutor(AppiumDriver<?> driver) {
        this.driver = driver;
//        if (driver instanceof AndroidDriver) {
//            System.out.println("Android driver");
//        } else if (driver instanceof IOSDriver) {
//            System.out.println("IOS driver");
//        }
    }

    /**
     * This Method is for type.
     *
     * @author Young
     * @param locator
     *            the locator
     * @param message
     *            the message
     */
    public void type(Locator locator, String message) {
        WebElement e = (WebElement) findElement(locator);
        e.sendKeys(message);

    }

    /**
     * Click.
     *
     * @param locator
     *            the locator
     */
    public void click(Locator locator) {
        WebElement e = (WebElement) findElement(locator);
        e.click();

    }

    /**
     * Gets the driver.
     *
     * @return the driver
     */
    public AppiumDriver<?> getDriver() {
        return driver;
    }

    /**
     * Sets the driver.
     *
     * @param driver
     *            the new driver
     */
    public void setDriver(AppiumDriver<?> driver) {
        this.driver = driver;
    }

    /**
     * Find element.
     *
     * @param locator
     *            the locator
     * @return the mobile element
     */
    public WebElement findElement(Locator locator) {
        WebElement e = null;
        switch (locator.getBy()) {
            case xpath:
                e = driver.findElementByXPath(locator.getElement());
                break;
            case id:
                e = driver.findElementById(locator.getElement());
                break;
            case name:
                e = driver.findElementByName(locator.getElement());
                break;
            case cssSelector:
                e = driver.findElementByCssSelector(locator.getElement());
                break;
            case className:
                e = driver.findElementByClassName(locator.getElement());
                break;
            case tagName:
                e = driver.findElementByTagName(locator.getElement());
                break;
            case linkText:
                e = driver.findElementByLinkText(locator.getElement());
                break;
            case partialLinkText:
                e = driver.findElementByPartialLinkText(locator.getElement());
                break;
            case accessibilityId:
                e = driver.findElementByAccessibilityId(locator.getElement());
            case androidUIAutomator:
                e = ((AndroidDriver) driver).findElementByAndroidUIAutomator(locator.getElement());
                break;
            case iOSUIAutomation:
                break;
            case by:
                break;
            default:

        }
        return e;

    }

    /*
     * (non-Javadoc)
     *
     * @see
     * main.java.com.dbyl.appiumCore.utils.AppiumAPI#click(io.appium.java_client.
     * MobileElement)
     */
    @Override
    public void click(MobileElement e) {
        e.click();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * main.java.com.dbyl.appiumCore.utils.AppiumAPI#type(io.appium.java_client.
     * MobileElement, java.lang.String)
     */
    @Override
    public void type(MobileElement e, String message) {
        e.sendKeys(message);

    }

    /*
     * (non-Javadoc)
     *
     * @see
     * main.java.com.dbyl.appiumCore.utils.AppiumAPI#getText(io.appium.java_client.
     * MobileElement)
     */
    @Override
    public String getText(MobileElement e) {
        return e.getText();
    }

    /*
     * (non-Javadoc)
     *
     * @see main.java.com.dbyl.appiumCore.utils.AppiumAPI#scrollToElement(io.appium.
     * java_client.MobileElement)
     */
    @Override
    public void scrollToElement(MobileElement e) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     *
     * @see
     * main.java.com.dbyl.appiumCore.utils.AppiumAPI#isElementPresent(io.appium.
     * java_client.MobileElement)
     */
    @Override
    public boolean isElementPresent(MobileElement e) {
        return e.isDisplayed();
    }



    @Override
    public void assertToast(AndroidDriver<AndroidElement> driver, String message) {

        WebElement showClose = new AndroidDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'" + message + "')]")));
        Assert.assertNotNull(showClose);
    }
}
