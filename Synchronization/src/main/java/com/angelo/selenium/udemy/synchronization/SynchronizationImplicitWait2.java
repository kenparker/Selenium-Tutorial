package com.angelo.selenium.udemy.synchronization;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SynchronizationImplicitWait2 {

    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        setupWebDriverChrome();
        //Thread.sleep(1000);
        final String cssSelectorFromAirport = "div.od-airportselector.airportselector_root input[tabindex='11']";
        final By cssSelector = By.cssSelector(cssSelectorFromAirport);
        WebElement fromAirportElement = driver.findElement(cssSelector);
        int i = 0;
        while (!fromAirportElement.isDisplayed()) {
            System.out.println("-->> " + i++ + " " + fromAirportElement.isDisplayed());
        }
        System.out.println("-->> " + i++ + " " + fromAirportElement.isDisplayed() + " " + fromAirportElement.isEnabled() + " " + fromAirportElement.isSelected());
        System.out.println("clear");
        fromAirportElement.clear();
        System.out.println("MUC");
        fromAirportElement.sendKeys("MUC");
    }

    private static void setupWebDriverChrome() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Angelo\\Downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maggioni\\Downloads\\chromedriver_win32\\chromedriver.exe");       
        driver = new ChromeDriver();
        setupLocation();
    }

    private static void setupLocation() {
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        driver.get("https://www.opodo.de/");
    }

    private static void setupWebDriverGecko() {
        //System.setProperty("webdriver.gecko.driver", "C:\\Users\\maggioni\\Downloads\\geckodriver-v0.19.0-win64\\geckodriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\angelo\\Downloads\\geckodriver-v0.19.0-win64\\geckodriver.exe");
        //System.setProperty("webdriver.gecko.driver", "C:\\Users\\maggioni\\Downloads\\geckodriver-v0.18.0-win32\\geckodriver.exe");
        driver = new FirefoxDriver();
        setupLocation();
    }

    //fromAirportElement.click();
    /*
        1508397813056	geckodriver	INFO	geckodriver 0.19.0
        -->> false true false
        Exception in thread "main" org.openqa.selenium.ElementNotInteractableException: 
     */
 /*
        Starting ChromeDriver 2.32.498550 (9dec58e66c31bcc53a9ce3c7226f0c1c5810906a) on port 4229
        -->> false true false
        Exception in thread "main" org.openqa.selenium.ElementNotVisibleException: element not visible
     */
}
