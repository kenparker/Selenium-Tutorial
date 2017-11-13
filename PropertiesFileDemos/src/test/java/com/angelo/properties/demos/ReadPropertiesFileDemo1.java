package com.angelo.properties.demos;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReadPropertiesFileDemo1 {

    @BeforeTest
    public void readPropertyFile() {
        File file = new File("test.properties");
        Properties properties;
        try (FileInputStream fileInput = new FileInputStream(file)) {
            properties = new Properties();
            properties.load(fileInput);
            Enumeration<Object> keys = properties.keys();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                Object value = properties.get(key);
                System.out.println(key + " value : " + value);

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    @Test
    public void dummyTest() {
        
    }
}
