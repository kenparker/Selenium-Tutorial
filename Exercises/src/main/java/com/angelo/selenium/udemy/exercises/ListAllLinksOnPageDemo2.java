package com.angelo.selenium.udemy.exercises;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListAllLinksOnPageDemo2 {

    private static WebDriver driver;

    public static void main(String[] args) {
        setupWebDriver();

        By cssSelector = By.cssSelector("footer a[href]");
        listElemnts(cssSelector);

        By tagName = By.tagName("a");
        listElemnts(tagName);
        
        cssSelector = By.cssSelector("footer td:nth-child(2) a[href]");
        listElemnts(cssSelector);
        
        driver.close();
    }

    private static void listElemnts(By selector) {
        List<WebElement> hrefElements = driver.findElements(selector);
        System.out.println( selector + ": total number of hrefs : " + hrefElements.size());
        hrefElements.forEach(a -> System.out.println("--> " + a.getAttribute("href")));
    }

    private static void setupWebDriver() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Angelo\\Downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maggioni\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driverWait = new WebDriverWait(driver, 20);
        driver.get("https://www.ebay.de/");
    }
}
