package com.angelo.common;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebElementManagement {

    private WebDriver driver;

    public WebElementManagement() {
        this.driver = null;
    }

    public WebElementManagement(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement checkAndReturnElement(By selector, int timeOutInSeconds) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        return wait.until(ExpectedConditions.elementToBeClickable(selector));
    }

    public WebElement checkAndReturnElement(WebElement element, By selector, int timeOutInSeconds) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        final WebElement findElement = element.findElement(selector);
        return wait.until(ExpectedConditions.elementToBeClickable(findElement));
    }

    protected void isElementPresent(By selector) throws Exception {
        try {
            WebElement checkAndReturnElement = checkAndReturnElement(selector, 5);
            System.out.println("-> Element :>" + selector + "< is present");
        } catch (TimeoutException e) {
            System.out.println("-> Element :>" + selector + "< is NOT present");
        }
    }

    protected void listAllElements(WebDriver driver, String xPath) {
        List<WebElement> findElementsInFrame = driver.findElements(By.xpath(xPath));
        System.out.println("elements in Frame size :" + findElementsInFrame.size());
        findElementsInFrame.forEach((WebElement a) -> System.out.println("tag : >" + a.getTagName() + "<  id : >" + a.getAttribute("id") + "<  name : >" + a.getAttribute("name") + "<  text : >" + a.getText() + "<"));
    }

    public static void listAllElements(WebElement a) {
        System.out.println("-> " + a.getAttribute("id"));
    }
}