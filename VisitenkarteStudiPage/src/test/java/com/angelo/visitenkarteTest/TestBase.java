package com.angelo.visitenkarteTest;

import com.angelo.loadtestdemo1.LoginController;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.fail;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
    protected LoginController loginController;

    @BeforeTest
    public void before() {
        System.out.println("before method 1");
        String webDriverPropertyFile = "src/main/java/com/angelo/properties/WebDriverAttributes.properties";
        loginController = new LoginController();
        try {
            loginController.login(webDriverPropertyFile);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }


    @AfterTest
    public void after() {
        System.out.println("after method");
        loginController.close();
    }
}
