package com.angelo.commonNew;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
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
        WebElement webElementIfClickable = getWebElementIfClickable(webElement);
        webElementIfClickable.clear();
        webElementIfClickable.sendKeys(key);
    }

    public WebElement getWebElementIfClickable(By by) {
        waiter();
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public Boolean isElementVisible(By by) {
        WebElement element = getWebElementIfVisible(by);
        return element != null;
    }

    public Boolean isElementPresent(WebElement element, By by) {
        return element.findElements(by).size() > 0;
    }

    public Boolean isElementEnabled(WebElement element) {
        return wait.until(new WebElementIsEnabled(element));
    }

    public Boolean isElementDisabled(WebElement element) {
        return wait.until(new WebElementIsDisabled(element));
    }

    public Boolean isElementNowDisabled(WebElement element) {
        String disabled = element.getAttribute("disabled");
        return disabled != null && disabled.equals("true");
    }

    public WebElement getWebElementIfVisible(By by) {
        waiter();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement getWebElementIfPresent(By by) {
        waiter();
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    
    public WebElement getWebElementIfClickable(WebElement webElement) {
        waiter();
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public Boolean isSpinnerReady() {
        ExpectedCondition<Boolean> spinner = (WebDriver driver) -> !driver.getPageSource().contains("loading_24x24.gif");
        return wait.until(spinner);     
    }
    
    private void waiter() {
        jsWaiter.waitUntilJSReady();
        jsWaiter.waitUntilJQueryReady();
    }

    public String getTitle() {
        return driver.getTitle();
    }
    
    public Boolean isPageTitleOK(String titleToCheck) {
        ExpectedCondition<Boolean> titleCheck = (WebDriver driver) -> driver.getTitle().contains(titleToCheck);
        return wait.until(titleCheck);
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

    class WebElementIsEnabled implements ExpectedCondition<Boolean> {

        private WebElement element;

        public WebElementIsEnabled(WebElement element) {
            this.element = element;
        }

        @Override
        public Boolean apply(WebDriver driver) {
            return !isElementNowDisabled(this.element);
        }
    }

    class WebElementIsDisabled implements ExpectedCondition<Boolean> {

        private WebElement element;

        public WebElementIsDisabled(WebElement element) {
            this.element = element;
        }

        @Override
        public Boolean apply(WebDriver driver) {
            return isElementNowDisabled(this.element);
        }
    }

}
