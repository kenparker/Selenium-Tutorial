package com.angelo.selenium.udemy.howtoruntestwithchrome;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SynchronizationUsingCompositeAction1 {

    private static WebDriver driver;
    private static Actions actions;

    public static void main(String[] args) throws InterruptedException {
        setupWebDriverChrome();
        final String cssSelectorFromAirport = "div.od-airportselector.airportselector_root input[tabindex='11']";
        final By cssSelector = By.cssSelector(cssSelectorFromAirport);
        WebElement fromAirportElement = driver.findElement(cssSelector);
        int i = 0;
        while (!fromAirportElement.isDisplayed()) {
            System.out.println("-->> " + i++ + " " + fromAirportElement.isDisplayed());
        }
        System.out.println("-->> " + i++ + " " + fromAirportElement.isDisplayed() + " " + fromAirportElement.isEnabled() + " " + fromAirportElement.isSelected());
        actions
                .moveToElement(fromAirportElement)
                .doubleClick()
                .sendKeys(Keys.DELETE)
                .sendKeys("MUC")
                .build()
                .perform();
        
        driver.close();
    }

    private static void setupWebDriverChrome() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Angelo\\Downloads\\chromedriver_win32\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maggioni\\Downloads\\chromedriver_win32\\chromedriver.exe");       
        driver = new ChromeDriver();
        setupLocation();
    }

    private static void setupLocation() {
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        actions = new Actions(driver);
        driver.get("https://www.opodo.de/");
    }

    private static void setupWebDriverGecko() {
        //System.setProperty("webdriver.gecko.driver", "C:\\Users\\maggioni\\Downloads\\geckodriver-v0.19.0-win64\\geckodriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\angelo\\Downloads\\geckodriver-v0.19.0-win64\\geckodriver.exe");
        //System.setProperty("webdriver.gecko.driver", "C:\\Users\\maggioni\\Downloads\\geckodriver-v0.18.0-win32\\geckodriver.exe");
        driver = new FirefoxDriver();
        setupLocation();
    }

}
