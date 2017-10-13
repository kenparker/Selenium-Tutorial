package com.angelo.selenium.udemy.xpath;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathContainsDemo1 {

    public static void main(String[] args) {
         WebDriver driver = setupWebDriver();
         
        String xpathsearchbyText = "//a[contains(text(),'TESTING')]";            
        searchAndListElements(driver, xpathsearchbyText);
        
        String xpathsearchbyAttribute = "//h4/a[contains(@href,'sap')]";            
        searchAndListElements(driver, xpathsearchbyAttribute);
        driver.close();
    }

    private static void searchAndListElements(WebDriver driver, final String xpath) {
        List<WebElement> elements = driver.findElements(By.xpath(xpath));
        System.out.println("elements nr : " +  elements.size());
        elements.forEach(a -> System.out.println(a.getText()));
    }
    
    private static WebDriver setupWebDriver() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Angelo\\Downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maggioni\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/selenium/guru99home/");
        return driver;
    }
}
