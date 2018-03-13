package com.angelo.login;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebDriverAttributesController {

    private final Properties WebDriverAttributes = new Properties();

    public void loadPropertyFile(String srcmainjavacomangelopropertiesWebDriverAt) throws IOException {

        File file = new File(srcmainjavacomangelopropertiesWebDriverAt);

        try (FileInputStream fileInput = new FileInputStream(file)) {
            WebDriverAttributes.load(fileInput);
        }

    }

    public String getLocation() {
        return WebDriverAttributes.getProperty("location");
    }

    public boolean isLocal() {
        String property = WebDriverAttributes.getProperty("localOrRemote");
        if (property.equals("local")) {
            return true;
        }
        return false;
    }

    public String getLocalWebDriverLocation() {
        return WebDriverAttributes.getProperty("local.webdriver.chrome.driver");
    }

    public String getRemoteUserName() {
        return WebDriverAttributes.getProperty("remote.UserName");
    }

    public String getRemoteAccessKey() {
        return WebDriverAttributes.getProperty("remote.ACCESS_KEY");
    }

    public String getRemotePlatform() {
        return WebDriverAttributes.getProperty("remote.Platform");
    }

    public String getRemoteVersion() {
        return WebDriverAttributes.getProperty("remote.Version");
    }
}
