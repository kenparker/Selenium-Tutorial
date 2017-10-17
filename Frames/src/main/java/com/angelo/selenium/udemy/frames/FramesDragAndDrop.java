package com.angelo.selenium.udemy.frames;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesDragAndDrop {

    public static void main(String[] args) {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maggioni\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://jqueryui.com/droppable/");
        
        WebElement element = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(element);
        
        List<WebElement> elements = driver.findElements(By.cssSelector("div"));
        elements.forEach(a -> System.out.println(" "+ a.getAttribute("id")));
        
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, droppable).build().perform();
    }
    
}
