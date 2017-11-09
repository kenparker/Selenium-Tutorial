package com.angelo.selenium.udemy.testngbasics;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AnnotationsDemo2 {
    
    public AnnotationsDemo2() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Before Class");
    }
    
    @Test
    public void test1() {
        System.out.println("hey, this is a test");
    }
    
}
