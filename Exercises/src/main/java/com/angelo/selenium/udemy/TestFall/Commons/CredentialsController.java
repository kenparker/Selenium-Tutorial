package com.angelo.selenium.udemy.TestFall.Commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CredentialsController {

    private static final Properties credentials = new Properties();

    public static void main(String[] args) {
        loadPropertyFile();
        System.out.println("user " + getUser() );
        System.out.println("password " + getPassword());
    }

    public static void loadPropertyFile() {
        File file = new File("src/main/java/com/angelo/properties/Credentials.properties");

        try (FileInputStream fileInput = new FileInputStream(file)) {
            credentials.load(fileInput);
            System.out.println("load success");            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getUser() {
        return credentials.getProperty("user");
    }
    
    public static String getPassword() {
        return credentials.getProperty("password");
    }
}
