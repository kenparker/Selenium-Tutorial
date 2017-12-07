package com.angelo.commonNew;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected  JSWaiter jsWaiter;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.jsWaiter = new JSWaiter(driver);
    }

    public void click(By by) {
        jsWaiter.waitUntilJSReady();
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public void click(WebElement webElement) {
        jsWaiter.waitUntilJSReady();
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
