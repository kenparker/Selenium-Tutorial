package com.angelo.commonNew;

import java.util.List;
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
        getWebElementIfClickable(webElement).click();
    }
    
    public WebElement getWebElementIfClickable(WebElement webElement) {
        jsWaiter.waitUntilJSReady();
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public String getTitle() {
        return driver.getTitle();
    }
    
    public void listAllElements(String xPath) {
        List<WebElement> findElementsInFrame = driver.findElements(By.xpath(xPath));
        System.out.println("-->>elements in Frame size :" + findElementsInFrame.size());
        findElementsInFrame.forEach((WebElement a) -> System.out.println("tag : >" + a.getTagName() + "<  id : >" + a.getAttribute("id") + "<  name : >" + a.getAttribute("name") + "<  text : >"  + "<"));
    }

    public void listAllElements(WebElement a) {
        System.out.println("-> " + a.getAttribute("id"));
    }
}
