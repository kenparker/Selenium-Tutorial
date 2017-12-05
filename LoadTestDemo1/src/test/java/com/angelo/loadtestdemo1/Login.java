package com.angelo.loadtestdemo1;

import com.angelo.common.WebDriverManagement;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.fail;

public class Login {
    private WebDriver driver;

    public void doLogin(String webDriverPropertyFile ) {
        login(webDriverPropertyFile);
        close();
    }

    public void login(String webDriverPropertyFile) {
        WebDriverManagement wdm = new WebDriverManagement();
        try {
            wdm.build(webDriverPropertyFile);
            driver = wdm.getWebDriver();
            LoginToCampusManagement login = new LoginToCampusManagement(driver);
            login.loginManagement();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    public void close() {
        driver.close();
    }
}
