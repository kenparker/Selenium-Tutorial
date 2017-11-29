package com.angelo.loadtestdemo1;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLogin extends LoginToCampusManagement{

    @BeforeClass
    public static void before() {
        
    }
    
    @Test(invocationCount = 5, threadPoolSize = 2)
    public static void testLogin() {
        LoginToCampusManagement loginToCampusManagement = new LoginToCampusManagement();
       loginToCampusManagement.loginManagement();
        loginToCampusManagement.driver.close();
    }
    
        
    @AfterClass
    public static void end() {
    }
}
