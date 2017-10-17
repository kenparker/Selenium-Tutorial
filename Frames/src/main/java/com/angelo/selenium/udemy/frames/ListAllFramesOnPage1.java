package com.angelo.selenium.udemy.frames;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListAllFramesOnPage1 {

    public static void main(String[] args) {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maggioni\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://jqueryui.com/droppable/");

        List<WebElement> elements = driver.findElements(By.xpath("//iframe"));
        elements.forEach(a -> System.out.println("--> " + a.getTagName() + " " + a.getAttribute("class")));

        driver.close();
    }

}
