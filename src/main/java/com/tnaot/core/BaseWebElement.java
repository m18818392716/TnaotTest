package com.tnaot.core;

import lombok.Getter;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class BaseWebElement {

    @Getter
    private WebElement webElement;


    public boolean isExisted() {
        try {
            webElement.isDisplayed();
            return true;
        } catch (NoSuchElementException wdp) {
            return false;
        }
    }

    public boolean isVisible() {
        try {
            return webElement.isDisplayed();
        } catch (NoSuchElementException wdp) {
            return false;
        }
    }

    public void click() {
        webElement.click();
    }

    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    public boolean isEnabled() {
        return webElement.isEnabled();
    }

    public boolean isSelected() {
        return webElement.isSelected();
    }

    public String getTag() {
        return webElement.getTagName();
    }

    public String getContent() {
        return webElement.getText();
    }

    public void sendKeys(String value) {
        webElement.sendKeys(value);
    }


}
