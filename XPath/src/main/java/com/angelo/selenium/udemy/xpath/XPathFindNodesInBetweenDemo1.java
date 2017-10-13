package com.angelo.selenium.udemy.xpath;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathFindNodesInBetweenDemo1 {

    public static void main(String[] args) {
         WebDriver driver = setupWebDriver();
         
         
        /*
         <ul class="responsive-tabs__list" role="tablist">
            <li class="responsive-tabs__list__item responsive-tabs__list__item--active" id="tablist1-tab1" aria-controls="tablist1-panel1" role="tab" tabindex="0"> Appium </li>
            <li class="responsive-tabs__list__item" id="tablist1-tab2" aria-controls="tablist1-panel2" role="tab" tabindex="0"> Selenium </li>
            <li class="responsive-tabs__list__item" id="tablist1-tab3" aria-controls="tablist1-panel3" role="tab" tabindex="0"> Soap UI </li>
            <li class="responsive-tabs__list__item" id="tablist1-tab4" aria-controls="tablist1-panel4" role="tab" tabindex="0"> Testing </li>
         </ul>
        */ 
               
        String searchSibling = "//*[preceding-sibling::li=' Selenium ' and following-sibling::li=' Testing ']";            
        searchAndListElements(driver, searchSibling);
        /*
        elements nr : 1
        Soap UI
        */
        //                                                                                   "//*[@id='tablist1-tab2']/preceding-sibling::li"
        searchSibling = "//*[contains(text(), ' Selenium ')]/following-sibling::li and //*[contains(text(), ' Testing ')]/preceding-sibling::li";            
        searchAndListElements(driver, searchSibling);
        /*
        elements nr : 1
        Soap UI
        */
        
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
        driver.get("http://www.qaclickacademy.com/interview.php");
        return driver;
    }
}
