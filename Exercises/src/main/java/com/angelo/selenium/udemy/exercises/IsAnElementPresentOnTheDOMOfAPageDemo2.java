package com.angelo.selenium.udemy.exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IsAnElementPresentOnTheDOMOfAPageDemo2 {

    private static WebDriver driver;

    public static void main(String[] args) {
        setupWebDriverChrome();

        By element = By.cssSelector("iframe[title='reCAPTCHA-Widget']");
        isElementPresent(element);
        
        element = By.cssSelector("iframe[title='reCAPTCHA-jdldjalksdjlasd']");
        isElementPresent(element);

        driver.close();
    }

    private static void isElementPresent(By cssSelector) {
        try {
            WebElement checkAndReturnElement = checkAndReturnElement(cssSelector, 5);
            System.out.println("-> Element :" + cssSelector + " is present");
        } catch (TimeoutException e) {
            System.out.println("-> Element :" + cssSelector + " is NOT present");
        }
    }

    private static WebElement checkAndReturnElement(By cssSelector, int timeOutInSeconds) throws TimeoutException{
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        return wait.until(ExpectedConditions.presenceOfElementLocated(cssSelector));
    }

    private static void setupWebDriverChrome() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Angelo\\Downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maggioni\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        setupLocation();
    }

    private static void setupLocation() {

        driver.get("https://www.google.com/recaptcha/api2/demo");
    }
}
