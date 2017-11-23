package com.angelo.loadtestdemo1;

import com.angelo.selenium.udemy.TestFall.Commons.LoginToCampusManagement;
import org.testng.annotations.Test;

public class TestLogin {

    @Test
    public void testLogin() {
        LoginToCampusManagement.loginManagement();
    }
}
