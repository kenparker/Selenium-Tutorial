package com.angelo.visitenkarteTest;

import com.angelo.common.Login;
import com.angelo.common.WebDriverManagement;
import com.angelo.loadtestdemo1.LoginToCampusManagement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.fail;


public class VisitenkarteStudiTest {

    private WebDriverManagement wdm;
    @Test
    public void test1() {
        System.out.println("hello 1");
    }

    @Test
    public void test2() {
        System.out.println("hello 2");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("before method");
        String webDriverPropertyFile = "src/main/java/com/angelo/properties/WebDriverAttributes.properties";
        wdm = wdm = new WebDriverManagement();
        try {
            wdm.build(webDriverPropertyFile);
            LoginToCampusManagement login = new LoginToCampusManagement(wdm.getWebDriver());
            login.loginManagement();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("after method");
        wdm.getWebDriver().close();
    }

}