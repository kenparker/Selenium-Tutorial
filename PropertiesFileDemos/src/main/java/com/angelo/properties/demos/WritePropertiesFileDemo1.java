package com.angelo.properties.demos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;



public class WritePropertiesFileDemo1 {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("name", "Angelo");
        properties.setProperty("adress", "Reigersbachstr");
        
        File file = new File("test2.properties");
        try (FileOutputStream fileOut = new FileOutputStream(file)) {
            properties.store(fileOut, "My Date");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
