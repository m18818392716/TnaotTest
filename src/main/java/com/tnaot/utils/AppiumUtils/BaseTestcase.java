package com.tnaot.utils.AppiumUtils;

import io.appium.java_client.AppiumDriver;

public class BaseTestcase {

    public AppiumDriver driver;

    public void setdriver(AppiumDriver driver){
        this.driver=driver;
    }

    public void takescreen(String filename){
        ScreenScr.getScreen(driver, filename);
    }
}
