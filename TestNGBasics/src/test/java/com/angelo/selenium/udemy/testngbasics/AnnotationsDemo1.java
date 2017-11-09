package com.angelo.selenium.udemy.testngbasics;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsDemo1 {
    
    @BeforeTest
    public void setUp() {
        System.out.println("setup");
    }
    
    @AfterTest
    public void closeDown() {
        
    }
    
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("method");
    }
    
    @AfterMethod
    public void afterMethod() {
        
    }
    
    @Test
    public void openBrowser() {
        System.out.println("browser");
    }
    
    @Test
    public void doSomething() {
        System.out.println("something");
    }
}
