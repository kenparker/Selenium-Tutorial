package com.angelo.selenium.udemy.howtoruntestwithchrome;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TUMOnlineAnmeldungDemo2 {

    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Angelo\\Downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maggioni\\Downloads\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://campusquality.tum.de/QSYSTEM_TUM/webnav.ini");
              
        navigateToLogin(driver);

        doLogin(driver);
        
        driver.close();
    }

    private static void doLogin(WebDriver driver) {
        driver.findElement(By.xpath("//*[@name='cp1']")).sendKeys("gu32fur");
        driver.findElement(By.xpath("//*[@name='cp2']")).sendKeys("12TeRo34");
        driver.findElement(By.xpath("//*[text()='Anmeldung']")).click();

    }

    private static void navigateToLogin(WebDriver driver) {
        listAllElements(driver, "//frame");
        
        driver.switchTo().frame("menue");
        listAllElements(driver, "//a");
        driver.findElement(By.id("menue_frame_key_icon")).click();
        
        driver.switchTo().defaultContent();
        driver.switchTo().frame("detail");
        listAllElements(driver, "//input|//button");
    }

    private static void listAllElements(WebDriver driver, String xPath) {
        List<WebElement> findElementsInFrame = driver.findElements(By.xpath(xPath));
        System.out.println("elements in Frame size :" + findElementsInFrame.size());
        findElementsInFrame.forEach(a -> System.out.println("tag : " + a.getTagName() + "  id : " + a.getAttribute("id") + "  name : " + a.getAttribute("name") + "  text : " + a.getText()));
    }

}
