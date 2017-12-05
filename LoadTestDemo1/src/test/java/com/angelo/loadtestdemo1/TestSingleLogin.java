package com.angelo.loadtestdemo1;

import org.testng.annotations.Test;

public class TestSingleLogin{

    @Test(enabled = true)
    public void testOneLoginLocal() {
        String webDriverPropertyFile = "src/main/java/com/angelo/properties/WebDriverAttributes.properties";
        new Login().doLogin(webDriverPropertyFile);
    }

    @Test(enabled = true)
    public void testOneLoginRemote() {
        String webDriverPropertyFile = "src/main/java/com/angelo/properties/WebDriverAttributes1.properties";
        new Login().doLogin(webDriverPropertyFile);
    }
}
