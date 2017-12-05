package com.angelo.loadtestdemo1;

import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class TestMultipleLogins {

    @Test(invocationCount = 5, threadPoolSize = 2, enabled = true)
    public void testLogin() {
        testOneLoginLocal();
    }

    public void testOneLoginLocal() {
        String webDriverPropertyFile = "src/main/java/com/angelo/properties/WebDriverAttributes.properties";
        TestLogin testLogin = new TestLogin();
        testLogin.login(webDriverPropertyFile);
        testLogin.close();
    }

    public void testOneLoginRemote() {
        String webDriverPropertyFile = "src/main/java/com/angelo/properties/WebDriverAttributes1.properties";
        TestLogin testLogin = new TestLogin();
        testLogin.login(webDriverPropertyFile);
        testLogin.close();
    }
}
