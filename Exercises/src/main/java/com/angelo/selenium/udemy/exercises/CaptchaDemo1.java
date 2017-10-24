package com.angelo.selenium.udemy.exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptchaDemo1 {

    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        setupWebDriverChrome();

        By captchaWidget = By.cssSelector("iframe[title='reCAPTCHA-Widget']");
        WebElement findElement = checkAndReturnElement(captchaWidget);
        driver.switchTo().frame(findElement);

        WebElement captchaCheckbox = checkAndReturnElement(By.cssSelector(".recaptcha-checkbox-checkmark"));
        captchaCheckbox.click();

        Thread.sleep(2000);
        driver.switchTo().defaultContent();

        By captchaAufgabe = By.cssSelector("iframe[title='reCAPTCHA-Aufgabe']");
        WebElement findElement2 = checkAndReturnElement(captchaAufgabe);
        driver.switchTo().frame(findElement2);

        By bestaetigenButton = By.cssSelector(".rc-button-default.goog-inline-block");
        WebElement checkAndReturnElement = checkAndReturnElement(bestaetigenButton);
        checkAndReturnElement.click();
        //driver.close();
    }

    private static WebElement checkAndReturnElement(By cssSelector) {
        boolean isEmpty = driver.findElements(cssSelector).isEmpty();
        if (!isEmpty) {
            final WebElement findElement = driver.findElement(cssSelector);
            System.out.println("-->> " + findElement + " " + findElement.isDisplayed() + " " + findElement.isEnabled());
            return findElement;
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
