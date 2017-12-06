package com.angelo.visitenkarteTest;

import com.angelo.loadtestdemo1.LoginController;
import com.angelo.page.visitenkartestudipage.VisitenkarteStudi;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;


public class VisitenkarteStudiTest {

    private LoginController loginController;

    @Test
    public void test1() {

        VisitenkarteStudi visitenkarteStudi = new VisitenkarteStudi(loginController.getDriver());
        try {
            WebElement linkToPruefungAnAbmeldung = visitenkarteStudi.getLinkToPruefungAnAbmeldung();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    @Test(enabled = false )
    public void test2() {
        System.out.println("hello 2");
    }

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
        //loginController.close();
    }

}