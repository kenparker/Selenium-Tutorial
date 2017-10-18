package com.angelo.selenium.udemy.exercises;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListAllLinksOnPageDemo1 {

    private static WebDriver driver;

    public static void main(String[] args) {
        setupWebDriver();

        By cssSelector = By.cssSelector("*[href]");

        List<WebElement> hrefElements = driver.findElements(cssSelector);
        System.out.println("total number of hrefs : " + hrefElements.size());
        hrefElements.forEach(a -> System.out.println("--> " + a.getAttribute("href")));

        driver.close();
    }

    private static void setupWebDriver() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Angelo\\Downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maggioni\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driverWait = new WebDriverWait(driver, 20);
        driver.get("https://codemo1.tugraz.at/demo/ee/ui/ca2/app/desktop/#/login");
    }
}
