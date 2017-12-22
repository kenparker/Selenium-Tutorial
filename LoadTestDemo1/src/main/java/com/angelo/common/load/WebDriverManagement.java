package com.angelo.common.load;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverManagement {

    private WebDriver driver;
    private WebDriverAttributesController wdac = new WebDriverAttributesController();
    
    public void build(String srcmainjavacomangelopropertiesWebDriverAt) throws IOException {
        wdac.loadPropertyFile(srcmainjavacomangelopropertiesWebDriverAt);
        if (wdac.isLocal()) {
            buildLocalWebDriver();
        } else {
            buildRemoteWebDriver();
        }
        driver.get(wdac.getLocation());
        //Dimension d = new Dimension(1024,786);
        driver.manage().window().maximize();
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    private void buildLocalWebDriver() {
        System.setProperty("webdriver.chrome.driver", wdac.getLocalWebDriverLocation());
        driver = new ChromeDriver();
    }

    private void buildRemoteWebDriver() throws MalformedURLException {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", wdac.getRemotePlatform());
        caps.setCapability("version", wdac.getRemoteVersion());

        String URL = "https://" + wdac.getRemoteUserName() + ":" + wdac.getRemoteAccessKey() + "@ondemand.saucelabs.com:443/wd/hub";
        driver = new RemoteWebDriver(new URL(URL), caps);
    }
}
