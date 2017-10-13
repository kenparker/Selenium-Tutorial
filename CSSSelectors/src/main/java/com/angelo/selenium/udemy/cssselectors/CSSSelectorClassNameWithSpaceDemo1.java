package com.angelo.selenium.udemy.cssselectors;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSSelectorClassNameWithSpaceDemo1 {

    private static WebDriver driver;
    
    public static void main(String[] args) {

        driver = setupWebDriver();
        final String cssSelectorClassNameWithSpaceOption1 = "div.od-airportselector.airportselector_root input[class='airportselector_input']";
        final String cssSelectorClassNameWithSpaceOption2 = "div[class='od-airportselector airportselector_root'] input[class='airportselector_input']";

        List<WebElement> findElements1 = findElements(cssSelectorClassNameWithSpaceOption1);
        List<WebElement> findElements2 = findElements(cssSelectorClassNameWithSpaceOption2);

        System.out.println(" Are both cssSelectors equals : ? " + (findElements1.size() == findElements2.size()));
        
        driver.close();
    }

    private  static List<WebElement> findElements(String cssselector) {
        return driver.findElements(By.cssSelector(cssselector));
    }

    private static WebDriver setupWebDriver() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Angelo\\Downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maggioni\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.opodo.de/");
        return driver;
    }

}
