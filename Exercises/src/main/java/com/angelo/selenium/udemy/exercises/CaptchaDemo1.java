package com.angelo.selenium.udemy.exercises;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptchaDemo1 {

    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        setupWebDriverChrome();
        
        By cssSelector = By.cssSelector("iframe[title='reCAPTCHA-Widget']");
        driver.findElements(cssSelector).isEmpty();
        WebElement findElement = driver.findElement(cssSelector);
        System.out.println("-->> " + findElement.isDisplayed() + " " + findElement.isEnabled());
        
        WebDriver frame = driver.switchTo().frame(findElement);
        /*List<WebElement> findElements = frame.findElements(By.cssSelector("div"));
        findElements.forEach(a -> System.out.println(" -> " + a.getTagName() + " " + a.getAttribute("Class")));*/
        
        WebElement findElement1 = frame.findElement(By.cssSelector(".recaptcha-checkbox-checkmark"));
        findElement1.click();
        
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
          
        By cssSelector1 = By.cssSelector("iframe[title='reCAPTCHA-Aufgabe']");
        WebElement findElement2 = frame.findElement(cssSelector1);
        System.out.println("-->> " + findElement2.isDisplayed() + " " + findElement2.isEnabled());
        
        
        WebDriver frame1 = driver.switchTo().frame(findElement2);
        
        //driver.close();
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
