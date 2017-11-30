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

    @Test(enabled = true)
    public static void testOneLoginLocal() {
        LoginToCampusManagement login = new LoginToCampusManagement();
        login.setWebDriverPropertyFile("src/main/java/com/angelo/properties/WebDriverAttributes.properties");
        try {
            login(login);
        } catch (Exception e) {
            System.out.println("error");
            fail();
        }
    }

    @Test(enabled = false)
    public static void testOneLoginRemote() {
        LoginToCampusManagement login = new LoginToCampusManagement();
        login.setWebDriverPropertyFile("src/main/java/com/angelo/properties/WebDriverAttributes1.properties");
        try {
            login(login);
        } catch (Exception e) {
            fail();
        }
    }

    private static void login(LoginToCampusManagement login) throws Exception {

            login.loginManagement();
            login.driver.quit();

    }

    @AfterClass
    public static void end() {
    }
}
