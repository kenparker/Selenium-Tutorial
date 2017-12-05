package com.angelo.loadtestdemo1;

import com.angelo.common.Login;
import com.angelo.common.WebDriverManagement;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class TestMultipleLogins {

    @Test(invocationCount = 5, threadPoolSize = 2, enabled = true)
    public void testLogin() {
        testOneLoginLocal();
    }

    public void testOneLoginLocal() {
        String webDriverPropertyFile = "src/main/java/com/angelo/properties/WebDriverAttributes.properties";
        new Login().doLogin(webDriverPropertyFile);
    }

    public void testOneLoginRemote() {
        String webDriverPropertyFile = "src/main/java/com/angelo/properties/WebDriverAttributes1.properties";
        new Login().doLogin(webDriverPropertyFile);
    }
}
