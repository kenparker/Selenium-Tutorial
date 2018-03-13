package com.angelo.visitenkarteTest;

import com.angelo.login.LoginController;
import org.testng.annotations.*;

import static org.testng.Assert.fail;

public class TestBase {
    protected LoginController loginController;

    @BeforeClass
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


    @AfterClass
    public void after() {
        System.out.println("after method");
        loginController.close();
    }
}
