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
    protected JSWaiter jsWaiter;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.jsWaiter = new JSWaiter(driver);
    }

    public void click(By by) {
        getWebElementIfClickable(by).click();
    }

    public void click(WebElement webElement) {
        getWebElementIfClickable(webElement).click();
    }

    public void sendKeys(WebElement webElement, String key) {
        getWebElementIfClickable(webElement).sendKeys(key);
    }

    public WebElement getWebElementIfClickable(By by) {
        jsWaiter.waitUntilJSReady();
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public boolean isElementReady(By by) {
        WebElement element = getWebElementIfReady(by);
        return element != null;
    }

    public boolean isElementPresent(By by) {
        WebElement element = getWebElementIfPresent(by);
        return element != null;
    }

    public boolean isElementDisabled(By by) {
        String disabled = driver.findElement(by).getAttribute("disabled");
        if (disabled != null && disabled.equals("true")) return true;
        return false;
    }

    public boolean isElementDisabled(WebElement element) {
        String disabled = element.getAttribute("disabled");
        if (disabled != null && disabled.equals("true")) return true;
        return false;
    }

    public WebElement getWebElementIfReady(By by) {
        jsWaiter.waitUntilJSReady();
        jsWaiter.waitUntilJQueryReady();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement getWebElementIfPresent(By by) {
        jsWaiter.waitUntilJSReady();
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
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
        findElementsInFrame.forEach((WebElement a) -> System.out.println("tag : >" + a.getTagName() + "<  id : >" + a.getAttribute("id") + "<  name : >" + a.getAttribute("name") + "<  text : >" + "<"));
    }

    public void listAllElements(WebElement a) {
        List<WebElement> elements = a.findElements(By.cssSelector("[class*='coTableR']"));
        System.out.println("Total elements :" + elements.size());
        elements.forEach(
                element -> System.out.println(element.getTagName() + " " + element.getAttribute("id"))
        );
    }
}
