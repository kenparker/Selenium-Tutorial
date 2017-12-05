package com.angelo.loadtestdemo1;

import static org.testng.Assert.fail;

public class TestLogin {

    protected LoginController loginController;

    void login(String webDriverPropertyFile) {
        loginController = new LoginController();
        try {
            loginController.login(webDriverPropertyFile);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    public void close() {
        loginController.close();
    }
}
