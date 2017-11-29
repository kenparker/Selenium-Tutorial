package com.angelo.loadtestdemo1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CredentialsController {

    private final Properties credentials = new Properties();

    public static void main(String[] args) {
        CredentialsController cc = new CredentialsController();
        cc.loadPropertyFile();
        System.out.println("user " + cc.getUser() );
        System.out.println("password " + cc.getPassword());
    }

    public void loadPropertyFile() {
        File file = new File("src/main/java/com/angelo/properties/Credentials.properties");

        try (FileInputStream fileInput = new FileInputStream(file)) {
            credentials.load(fileInput);
            System.out.println("load success");            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getUser() {
        return credentials.getProperty("user");
    }
    
    public String getPassword() {
        return credentials.getProperty("password");
    }
}
