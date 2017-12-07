package com.angelo.loadtestdemo1;

import com.angelo.common.load.WebDriverManagement;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class TestWebDriverManagement {

    WebDriverManagement webDriverManagement = new WebDriverManagement();

    @Test
    public void testLocalWebDriver() throws IOException {
        webDriverManagement.build("src/main/java/com/angelo/properties/WebDriverAttributes.properties");
        WebDriver webDriver = webDriverManagement.getWebDriver();
        String s = webDriver.getClass().toString();
        assertEquals("class org.openqa.selenium.chrome.ChromeDriver", s);
        webDriver.close();
    }

    @Test
    public void testRemoteWebDriver() throws IOException {
        webDriverManagement.build("src/main/java/com/angelo/properties/WebDriverAttributes1.properties");
        WebDriver webDriver = webDriverManagement.getWebDriver();
        String s = webDriver.getClass().toString();
        assertEquals("class org.openqa.selenium.remote.RemoteWebDriver", s);
        webDriver.quit();
    }

    @Test
    public void testPropertyFileIsWrong()  {
        try {
            webDriverManagement.build("src/main/java/com/angelo/properties/blablabal.properties");
            fail();
        } catch (IOException e) {
            // ok
        }

    }
}
