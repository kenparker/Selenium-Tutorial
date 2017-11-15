package com.angelo.properties.demos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReadPropertiesXmlFile {

    private Properties properties = new Properties();

    @BeforeTest
    public void loadPropertiesXmlFile() {

        File file = new File("text.xml");

        try (FileInputStream fileInput = new FileInputStream(file)) {
            properties.loadFromXML(fileInput);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @Test
    public void testName() {
        
        String name = properties.getProperty("name");
        assertEquals("Angelo", name);
    }
}
