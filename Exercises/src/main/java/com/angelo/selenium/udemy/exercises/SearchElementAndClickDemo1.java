package com.angelo.selenium.udemy.exercises;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchElementAndClickDemo1 {

    private static WebDriver driver;
    private static WebDriverWait driverWait;

    public static void main(String[] args) {
        setupWebDriver();

        By cssSelector = By.cssSelector("footer  #gf-BIG td:nth-child(2) a");
        List<WebElement> listElemnts = listElemnts(cssSelector);

        listElemnts.forEach( a -> findAndClick(a));
        
        
        driver.close();
    }

    private static List<WebElement> listElemnts(By selector) {
        List<WebElement> hrefElements = driver.findElements(selector);
        System.out.println( selector + ": total number of hrefs : " + hrefElements.size());
        //hrefElements.forEach(a -> System.out.println("--> " + a.getAttribute("href") + " innerText : "+ a.getAttribute("innerText") ));
        hrefElements.forEach(a -> System.out.println("--> " + a.getAttribute("innerText") + " " + a.isDisplayed() + " " + a.isEnabled() ));
        return hrefElements;
    }

    private static void setupWebDriver() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Angelo\\Downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maggioni\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, 20);
        driver.get("https://www.ebay.de/");
    }

    private static void findAndClick(WebElement a) {
        boolean ElektronikCheck = a.getAttribute("innerText").contains("Elektronik-Ankauf");
        if (ElektronikCheck) {
            //driverWait.until(ExpectedConditions.elementToBeClickable(a));
            System.out.println(" --->>> " + a.isDisplayed() + " " + a.isEnabled() );;
        }
    }
}
