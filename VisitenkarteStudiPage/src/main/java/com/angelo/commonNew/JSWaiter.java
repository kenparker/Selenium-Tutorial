package com.angelo.commonNew;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JSWaiter {

    private WebDriver driver;
    private WebDriverWait jsWait;
    private JavascriptExecutor jsExec;

    public JSWaiter(WebDriver driver) {
        this.driver = driver;
        this.jsWait = new WebDriverWait(this.driver, 10);
        this.jsExec = (JavascriptExecutor) this.driver;
    }

    public Boolean waitUntilJSReady() {
        ExpectedCondition<Boolean> jsLoad = (WebDriver d) -> ((JavascriptExecutor) d).executeScript("return document.readyState").toString().equals("complete");
        return jsWait.until(jsLoad);
    }
}
