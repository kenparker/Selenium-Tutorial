package com.angelo.loadtestdemo1;

import com.angelo.common.WebDriverManagement;
import org.openqa.selenium.WebDriver;

public class LoginController {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void login(String webDriverPropertyFile) throws Exception {
        WebDriverManagement wdm = new WebDriverManagement();
        wdm.build(webDriverPropertyFile);
        driver = wdm.getWebDriver();
        LoginManagement login = new LoginManagement(driver);
        login.loginManagement();
    }

    public void close() {
        driver.close();
    }
}
