package com.angelo.visitenkarteTest;

import com.angelo.loadtestdemo1.LoginController;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.fail;

public class TestBase {
    protected LoginController loginController;

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("before method");
        String webDriverPropertyFile = "src/main/java/com/angelo/properties/WebDriverAttributes.properties";
        loginController = new LoginController();
        try {
            loginController.login(webDriverPropertyFile);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }


    @AfterMethod
    public void afterMethod() {
        System.out.println("after method");
        loginController.close();
    }
}
