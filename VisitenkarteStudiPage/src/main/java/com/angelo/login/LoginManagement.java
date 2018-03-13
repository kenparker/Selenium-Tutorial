package com.angelo.login;


import com.angelo.common.load.CredentialsController;
import com.angelo.common.load.Utility;
import com.angelo.common.load.WebElementManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginManagement extends Utility {

    private WebDriver driver;
    private WebElementManagement webElementManagement;
    private CredentialsController cc;

    public LoginManagement(WebDriver driver) {
        this.driver = driver;
    }

    public  void loginManagement() throws Exception {
        loadProperties();
        webElementManagement = new WebElementManagement(driver);
        navigateToLogin();
        doLogin();
        manageInformationFrame();
    }

    private void loadProperties() throws IOException {
        cc = new CredentialsController();
        cc.loadPropertyFile();
    }

    protected  void doLogin() throws Exception {
        final By benutzerElement = By.xpath("//*[@name='cp1']");
        webElementManagement.checkAndReturnElement(benutzerElement, 2).sendKeys(cc.getUser());
        final By passwordElement = By.xpath("//*[@name='cp2']");
        webElementManagement.checkAndReturnElement(passwordElement, 2).sendKeys(cc.getPassword());
        clickButtonAnmeldung();
    }

    protected  void clickButtonAnmeldung() throws Exception {
        final By anmeldungButton = By.xpath("//button[contains(text(),'Anmeldung')]");
        webElementManagement.checkAndReturnElement(anmeldungButton, 2).click();
    }

    protected  void clickButtonAnmelden() throws Exception {
        final By anmeldungButton = By.xpath("//button[contains(text(),'Anmelden')]");
        webElementManagement.checkAndReturnElement(anmeldungButton, 2).click();
    }

    protected  void switchToMenueFrame() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("menue");
    }

    protected  void manageInformationFrame() throws Exception {
        try {
            final By InformationenMaskeButtonWeiter = By.cssSelector("#ff");
            webElementManagement.checkAndReturnElement(InformationenMaskeButtonWeiter, 2).click();
        } catch (TimeoutException e) {
            // do nothing
        }
    }

    protected  void navigateToLogin() throws Exception {
        switchToMenueFrame();
        final By menue_frame = By.id("menue_frame_key_icon");
        webElementManagement.checkAndReturnElement(menue_frame, 2).click();
        switchToFrameDetail();
    }

    protected  void switchToFrameDetail() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("detail");
    }

    protected  void doPINAnmeldung() throws Exception {
        try {
            final By passwordElement = By.cssSelector("input[type='password']");
            final String passwordValue = enterSomethingFromConsole("PIN");
            webElementManagement.checkAndReturnElement(passwordElement, 2).sendKeys(passwordValue);
            clickButtonAnmelden();
        } catch (TimeoutException e) {
            // if not present, do nothing
        }
    }

}
