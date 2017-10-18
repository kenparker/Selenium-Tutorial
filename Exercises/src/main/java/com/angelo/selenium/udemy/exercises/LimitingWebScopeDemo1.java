package com.angelo.selenium.udemy.exercises;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LimitingWebScopeDemo1 {

    private static WebDriver driver;

    public static void main(String[] args) {
        setupWebDriver();

        // version 1
        By footerASection1 = By.cssSelector("footer a");
        List<WebElement> aElements1 = driver.findElements(footerASection1);
        
        // version 2
        WebElement footerASection2 = driver.findElement(By.cssSelector("footer"));
        List<WebElement> aElements2 = footerASection2.findElements(By.tagName("a"));
        
        // version 3
        By footerSection3 = By.xpath("//*[@id='glbfooter']");
        WebElement footerElement3 = driver.findElement(footerSection3);
        List<WebElement> aElements3 = footerElement3.findElements(By.tagName("a"));
        
        boolean equalsStatement = (aElements3.size() == aElements1.size()) && (aElements1.size() == aElements2.size());
        
        System.out.println(" Total number is : " + aElements3.size() + " and are equals? :" + equalsStatement  );
        
        driver.close();
    }

    private static void setupWebDriver() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Angelo\\Downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maggioni\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.ebay.de/");
    }
}
