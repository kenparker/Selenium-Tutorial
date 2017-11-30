package com.angelo.loadtestdemo1;


import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginToCampusManagement extends Utility {

    WebDriver driver;

    private WebDriverManagement wdm;
    private CredentialsController cc;
    private String webDriverPropertyFile;

    public static void main(String[] args) throws Exception {

        new LoginToCampusManagement().startLogin();
    }

    public void setWebDriverPropertyFile(String webDriverPropertyFile) {
        this.webDriverPropertyFile = webDriverPropertyFile;
    }

    private void startLogin() throws Exception {
        loginManagement();
        driver.close();
    }

    public  void loginManagement() throws Exception {

        loadProperties();
        setupWebDriverChrome();
        navigateToLogin();
        doLogin();
        manageInformationFrame();
    }

    private void loadProperties() throws IOException {
        cc = new CredentialsController();
        cc.loadPropertyFile();

        wdm = new WebDriverManagement();
        wdm.build(webDriverPropertyFile);
    }

    protected  void doLogin() throws Exception {

        final By benutzerElement = By.xpath("//*[@name='cp1']");
        checkAndReturnElement(benutzerElement, 2).sendKeys(cc.getUser());
        final By passwordElement = By.xpath("//*[@name='cp2']");
        checkAndReturnElement(passwordElement, 2).sendKeys(cc.getPassword());
        clickButtonAnmeldung();
    }

    protected  void clickButtonAnmeldung() throws Exception {
        final By anmeldungButton = By.xpath("//button[contains(text(),'Anmeldung')]");
        checkAndReturnElement(anmeldungButton, 2).click();
    }

    protected  void clickButtonAnmelden() throws Exception {
        final By anmeldungButton = By.xpath("//button[contains(text(),'Anmelden')]");
        checkAndReturnElement(anmeldungButton, 2).click();
    }

    protected  void switchToMenueFrame() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("menue");
    }

    protected  void manageInformationFrame() throws Exception {
        try {
            final By InformationenMaskeButtonWeiter = By.cssSelector("#ff");
            checkAndReturnElement(InformationenMaskeButtonWeiter, 2).click();
        } catch (TimeoutException e) {
            // do nothing
        }
    }

    protected  void navigateToLogin() throws Exception {
        switchToMenueFrame();
        final By menue_frame = By.id("menue_frame_key_icon");
        checkAndReturnElement(menue_frame, 2).click();
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
            checkAndReturnElement(passwordElement, 2).sendKeys(passwordValue);
            clickButtonAnmelden();
        } catch (TimeoutException e) {
            // if not present, do nothing
        }
    }

    public  WebElement checkAndReturnElement(By selector, int timeOutInSeconds) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        return wait.until(ExpectedConditions.elementToBeClickable(selector));
    }

    public  WebElement checkAndReturnElement(WebElement element, By selector, int timeOutInSeconds) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        final WebElement findElement = element.findElement(selector);
        return wait.until(ExpectedConditions.elementToBeClickable(findElement));
    }

    protected  void setupWebDriverChrome() {
        driver = wdm.getWebDriver();
        setupLocation();
    }

    protected  void setupLocation() {
        driver.get(wdm.getLocation());
    }

    protected  void isElementPresent(By selector) throws Exception {
        try {
            WebElement checkAndReturnElement = checkAndReturnElement(selector, 5);
            System.out.println("-> Element :>" + selector + "< is present");
        } catch (TimeoutException e) {
            System.out.println("-> Element :>" + selector + "< is NOT present");
        }
    }

    protected  void listAllElements(WebDriver driver, String xPath) {
        List<WebElement> findElementsInFrame = driver.findElements(By.xpath(xPath));
        System.out.println("elements in Frame size :" + findElementsInFrame.size());
        findElementsInFrame.forEach((WebElement a) -> System.out.println("tag : >" + a.getTagName() + "<  id : >" + a.getAttribute("id") + "<  name : >" + a.getAttribute("name") + "<  text : >" + a.getText() + "<"));
    }

    public static void listAllElements(WebElement a) {
        System.out.println("-> " + a.getAttribute("id"));
    }

}
