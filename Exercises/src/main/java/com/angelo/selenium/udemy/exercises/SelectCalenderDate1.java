package com.angelo.selenium.udemy.exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectCalenderDate1 {

    private static WebDriver driver;
    private static WebDriverWait driverWait;

    public static void main(String[] args) throws InterruptedException {
        setupWebDriver();
        Thread.sleep(500);
        openDatePicker();       
        findTargetMonth();
    }

    private static void findTargetMonth() {
        //findElement(".od-ui-calendar-wrapper.open").click();
        
        while (!isTargetMonth()) {
            pageToNextMonth();
        }
    }

    private static void openDatePicker() {
        String date = "//*[@id=\"flights-manager\"]/div[2]/div[2]/div[1]/div[3]/div[1]/div[2]/div/div[1]/div[1]/div[3]/span";
        findElement(date).click();
    }

    private static void pageToNextMonth() {
        WebElement findElement1 = findElement(".od-ui-calendar-body [data-direction='next']");
        findElement1.click();
    }

    private static boolean isTargetMonth() {
        final String text = findElement(".od-ui-calendar.calendar:nth-child(1) .od-ui-calendar-title").getText();
        System.out.println("->> " + text);
        return text.equalsIgnoreCase("Dezember '17");
    }

    private static WebElement findElement(final String selectorString) {
        final By selector;
        if (selectorString.contains("//")) {
            selector = By.xpath(selectorString);
        } else {
            selector = By.cssSelector(selectorString);
        }
        driverWait.until(ExpectedConditions.elementToBeClickable(selector));
        return driver.findElement(selector);
    }

    private static void setupWebDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Angelo\\Downloads\\chromedriver_win32\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maggioni\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, 10);
        driver.get("https://www.opodo.de/");
    }
}
