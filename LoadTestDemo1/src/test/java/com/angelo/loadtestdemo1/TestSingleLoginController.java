package com.angelo.loadtestdemo1;

import org.testng.annotations.Test;

public class TestSingleLoginController extends TestLogin {


    @Test(enabled = true)
    public void testOneLoginLocal() {
        String webDriverPropertyFile = "src/main/java/com/angelo/properties/WebDriverAttributes.properties";
        login(webDriverPropertyFile);
        loginController.close();
    }

    @Test(enabled = true)
    public void testOneLoginRemote() {
        String webDriverPropertyFile = "src/main/java/com/angelo/properties/WebDriverAttributes1.properties";
        login(webDriverPropertyFile);
        loginController.close();
    }
}
