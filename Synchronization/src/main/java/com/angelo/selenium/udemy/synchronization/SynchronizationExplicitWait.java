package com.angelo.selenium.udemy.synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SynchronizationExplicitWait {
    private static WebDriver driver;
    private static WebDriverWait driverWait;
    
    public static void main(String[] args) throws InterruptedException {

        setupWebDriver();

        final String cssSelectorFromAirport = "div.od-airportselector.airportselector_root input[tabindex='11']";
        WebElement fromAirportElement = findElement(cssSelectorFromAirport);
        
        System.out.println("--> " +  fromAirportElement.isDisplayed() +  " " + fromAirportElement.isEnabled() + " " + fromAirportElement.isSelected());
        
        fromAirportElement.clear();
        fromAirportElement.sendKeys("München");
        
        final String cssSelectorFromAiportSelector1 = "div.od-airportselector-suggestions li[data-iata='MUC']";
        WebElement fromAirportSelectorElement = findElement(cssSelectorFromAiportSelector1);
        
        fromAirportSelectorElement.click();
       
        final String cssSelectorToAirport = "div.od-airportselector.airportselector_root input[tabindex='13']";
        WebElement toAirportElement = findElement(cssSelectorToAirport);
        
        toAirportElement.clear();
        toAirportElement.sendKeys("TFS");
        
        final String cssSelectorToAirportSelector2=  "div.od-airportselector-suggestions li[data-iata='TFS']";
        WebElement toAirportSelectorElement = findElement(cssSelectorToAirportSelector2);
        toAirportSelectorElement.click();
    }

    private static WebElement findElement(final String cssSelectorToAirport) throws InterruptedException {
        final By cssSelector = By.cssSelector(cssSelectorToAirport);
        driverWait.until(ExpectedConditions.elementToBeClickable(cssSelector));
        return driver.findElement(cssSelector);
   
    }

    private static void setupWebDriver() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Angelo\\Downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maggioni\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        driverWait = new WebDriverWait(driver, 20);
        driver.get("https://www.opodo.de/");
    }
}
