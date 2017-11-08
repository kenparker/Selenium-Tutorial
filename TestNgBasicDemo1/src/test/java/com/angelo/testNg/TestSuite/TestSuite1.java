package com.angelo.testNg.TestSuite;

import org.testng.annotations.BeforeSuite;

public class TestSuite1 {

    @BeforeSuite
    public void suite1() {
        System.out.println("Hi, I'm from suite1");
    }
}
