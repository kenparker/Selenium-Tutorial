package com.angelo.loadtestdemo1;

import java.io.IOException;

import static org.testng.Assert.fail;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLogin extends LoginToCampusManagement {

    @BeforeClass
    public static void before() {
    }

    @Test(invocationCount = 10, threadPoolSize = 5, enabled = true)
    public static void testLogin() {
        testOneLoginLocal();
    }

    @Test(enabled = false)
    public static void testOneLoginLocal() {
        LoginToCampusManagement login = new LoginToCampusManagement();
        login.setWebdriverpropertyfile("src/main/java/com/angelo/properties/WebDriverAttributes.properties");
        login(login);
    }

    @Test(enabled = false)
    public static void testOneLoginRemote() {
        LoginToCampusManagement login = new LoginToCampusManagement();
        login.setWebdriverpropertyfile("src/main/java/com/angelo/properties/WebDriverAttributes1.properties");
        login(login);
    }

    private static void login(LoginToCampusManagement login) {
        try {
            login.loginManagement();
            login.driver.quit();
        } catch (IOException ex) {
            fail();
        }
    }

    @AfterClass
    public static void end() {
    }
}
