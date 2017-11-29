package com.angelo.loadtestdemo1;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginToCampusManagement extends Utility {

    public  WebDriver driver;

    public  String benutzerValue;
    public  String passwordValue;

    public static void main(String[] args) {

        new LoginToCampusManagement().startLogin();
    }

    private void startLogin() {
        loginManagement();
        driver.close();
    }

    public  void loginManagement() {
        CredentialsController.loadPropertyFile();
        benutzerValue = CredentialsController.getUser();
        passwordValue = CredentialsController.getPassword();
        setupWebDriverChrome();
        navigateToLogin();
        doLogin();
        manageInformationFrame();
    }

    protected  void doLogin() {

        final By benutzerElement = By.xpath("//*[@name='cp1']");
        checkAndReturnElement(benutzerElement, 2).sendKeys(benutzerValue);
        final By passwordElement = By.xpath("//*[@name='cp2']");
        checkAndReturnElement(passwordElement, 2).sendKeys(passwordValue);
        clickButtonAnmeldung();
    }

    protected  void clickButtonAnmeldung() {
        final By anmeldungButton = By.xpath("//button[contains(text(),'Anmeldung')]");
        checkAndReturnElement(anmeldungButton, 2).click();
    }

    protected  void clickButtonAnmelden() {
        final By anmeldungButton = By.xpath("//button[contains(text(),'Anmelden')]");
        checkAndReturnElement(anmeldungButton, 2).click();
    }

    protected  void switchToMenueFrame() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("menue");
    }

    protected  void manageInformationFrame() {
        try {
            final By InformationenMaskeButtonWeiter = By.cssSelector("#ff");
            checkAndReturnElement(InformationenMaskeButtonWeiter, 2).click();
        } catch (TimeoutException e) {
            // do nothing
        }
    }

    protected  void navigateToLogin() {
        switchToMenueFrame();
        final By menue_frame = By.id("menue_frame_key_icon");
        checkAndReturnElement(menue_frame, 2).click();
        switchToFrameDetail();
    }

    protected  void switchToFrameDetail() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("detail");
    }

    protected  void doPINAnmeldung() {
        try {
            final By passwordElement = By.cssSelector("input[type='password']");
            final String passwordValue = enterSomethingFromConsole("PIN");
            checkAndReturnElement(passwordElement, 2).sendKeys(passwordValue);
            clickButtonAnmelden();
        } catch (TimeoutException e) {
            // if not present, do nothing
        }
    }

    public  WebElement checkAndReturnElement(By selector, int timeOutInSeconds) throws TimeoutException {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        return wait.until(ExpectedConditions.elementToBeClickable(selector));
    }

    public  WebElement checkAndReturnElement(WebElement element, By selector, int timeOutInSeconds) throws TimeoutException {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        final WebElement findElement = element.findElement(selector);
        return wait.until(ExpectedConditions.elementToBeClickable(findElement));
    }

    protected  void setupWebDriverChrome() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Angelo\\Downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maggioni\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        setupLocation();
    }

    protected  void setupLocation() {
        driver.get("https://campusquality.tum.de/");
    }

    protected  void isElementPresent(By selector) {
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
