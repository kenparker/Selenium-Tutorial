package com.angelo.loadtestdemo1;

import static org.testng.Assert.fail;

import com.angelo.common.WebDriverManagement;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLogin {

    private WebDriverManagement wdm;
    private String webDriverPropertyFile;
    private WebDriver driver;

    @BeforeClass
    public static void before() {

    }

    @Test(invocationCount = 10, threadPoolSize = 5, enabled = false)
    public void testLogin() {
        testOneLoginLocal();
    }

    @Test(enabled = true)
    public void testOneLoginLocal() {
        webDriverPropertyFile = "src/main/java/com/angelo/properties/WebDriverAttributes.properties";
        login();
    }

    @Test(enabled = true)
    public void testOneLoginRemote() {
        webDriverPropertyFile = "src/main/java/com/angelo/properties/WebDriverAttributes1.properties";
        login();
    }

    private void login() {
        wdm = new WebDriverManagement();
        try {
            wdm.build(webDriverPropertyFile);
            driver = wdm.getWebDriver();
            LoginToCampusManagement login = new LoginToCampusManagement(driver);

            login.loginManagement();
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }


    @AfterClass
    public static void end() {
    }

}
