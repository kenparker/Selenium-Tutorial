package com.angelo.selenium.udemy.howtoruntestwithchrome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TUMOnlineAnmeldungDemo3 {

    public static void main(String[] args) {
        WebDriver driver = setupWebDriver();
              
        navigateToLogin(driver);
        doLogin(driver);
        
        driver.close();
    }

    private static WebDriver setupWebDriver() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Angelo\\Downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maggioni\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://campusquality.tum.de/QSYSTEM_TUM/webnav.ini");
        return driver;
    }
    
    private static void navigateToLogin(WebDriver driver) {             
        driver.switchTo().frame("menue");
        driver.findElement(By.id("menue_frame_key_icon")).click();      
        driver.switchTo().defaultContent();
        driver.switchTo().frame("detail");
    }

    private static void doLogin(WebDriver driver) {
        final By user = By.xpath("//*[@name='cp1']");
        final By password = By.xpath("//*[@name='cp2']");
        driver.findElement(user).sendKeys("gu32fur");
        driver.findElement(password).sendKeys("12TeRo34");
        driver.findElement(By.xpath("//*[text()='Anmeldung']")).click();

    }


}
