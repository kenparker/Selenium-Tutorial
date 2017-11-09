package com.angelo.selenium.udemy.testngbasics;

import org.testng.annotations.BeforeSuite;

public class TestSuite1 {
    @BeforeSuite
    public void suite() {
        System.out.println("suite");
    }
}
