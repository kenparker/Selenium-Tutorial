package com.angelo.selenium.udemy.howtoruntestwithchrome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDemo1 {
        public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver","C:\\Users\\Angelo\\Downloads\\chromedriver_win32\\chromedriver.exe");
            WebDriver chromeDriver = new ChromeDriver();
            chromeDriver.get("http://www.tum.de");
    }
}
