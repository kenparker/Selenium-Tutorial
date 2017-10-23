package com.angelo.selenium.udemy.exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsAnElementPresentOnTheDOMOfAPageDemo1 {

    private static WebDriver driver;

    public static void main(String[] args) {
        setupWebDriverChrome();

        By element = By.cssSelector("iframe[title='reCAPTCHA-Widget']");
        isElementPresent(element);
        
        element = By.cssSelector("iframe[title='reCAPTCHA-jdldjalksdjlasd']");
        isElementPresent(element);

        driver.close();
    }

    private static void isElementPresent(By cssSelector) throws IllegalStateException {
        try {
            WebElement checkAndReturnElement = checkAndReturnElement(cssSelector);
            System.out.println("-> Element :" + cssSelector + " is present");
        } catch (NoSuchElementException e) {
            System.out.println("-> Element :" + cssSelector + " is NOT present");
        }
    }

    private static WebElement checkAndReturnElement(By cssSelector)  {
        boolean isEmpty = driver.findElements(cssSelector).isEmpty();
        if (!isEmpty) {
            return driver.findElement(cssSelector);
        } else {
            throw new NoSuchElementException("Element not present");
        }
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
