package com.angelo.saucelabdemo1;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class AppTest {

    public static final String USERNAME = "KenP";
    public static final String ACCESS_KEY = "b74d5d08-2298-452f-8598-225a5ab42947";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

    @Test
    public void testSauceLab() throws MalformedURLException {
        WebDriver driver = getDriver();
        
        driver.get("https://saucelabs.com/test/guinea-pig");
        System.out.println("title of page is: " + driver.getTitle());

        driver.quit();

    }

    private WebDriver getDriver() throws MalformedURLException {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("version", "54.0");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        return driver;
    }
}
