package com.angelo.selenium.udemy.exercises;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PruefungsmanagementMenueOeffnenDemo1 {

    private static WebDriver driver;

    public static void main(String[] args) {
        setupWebDriverChrome();

        navigateToLogin();
        doLogin();
        manageInformationFrame();
        navigateToHome();
        navigateToPruefungsmanagementMenue();
        navigationToAbschluesse();
        
        manageWindowAbschluesse();
      
    }

    private static void manageWindowAbschluesse() {
        String currentWindow = driver.getWindowHandle();
        switchToWindowAbschluesse(currentWindow);     
        checkPresenceWebElements();
    }

    private static void checkPresenceWebElements() {
        By actionBlock = By.cssSelector("#idPageNavi");
        isElementPresent(actionBlock);
        By search = By.cssSelector("#idSearchBox");
        isElementPresent(search);
        By table = By.cssSelector("#idAbschlTable > tbody");
        isElementPresent(table);
        By rows = By.cssSelector("#idAbschlTable > tbody > tr");
        List<WebElement> rowsElements = driver.findElements(rows);
        rowsElements.forEach(a -> listAllElements(a));
    }

    private static void switchToWindowAbschluesse(String currentWindow) {
        Set<String> windowHandles = driver.getWindowHandles();
        windowHandles.stream().filter((a) -> (!a.equals(currentWindow)))
                .forEachOrdered((b) -> {driver.switchTo().window(b);});
    }

    private static void doLogin() {
        final By benutzerElement = By.xpath("//*[@name='cp1']");
        final String benutzerValue = enterSomethingFromConsole("Benutzer");
        checkAndReturnElement(benutzerElement, 2).sendKeys(benutzerValue);

        final By passwordElement = By.xpath("//*[@name='cp2']");
        final String passwordValue = enterSomethingFromConsole("Password");
        checkAndReturnElement(passwordElement, 2).sendKeys(passwordValue);

        clickButtonAnmeldung();
    }

    private static void clickButtonAnmeldung() {
        final By anmeldungButton = By.xpath("//button[contains(text(),'Anmeldung')]");
        checkAndReturnElement(anmeldungButton, 2).click();
    }

    private static void clickButtonAnmelden() {
        final By anmeldungButton = By.xpath("//button[contains(text(),'Anmelden')]");
        checkAndReturnElement(anmeldungButton, 2).click();
    }

    private static void navigateToHome() {
        switchToMenueFrame();
        final By HomeButton = By.cssSelector("#menue_frame_myOrg_icon");
        checkAndReturnElement(HomeButton, 2).click();
    }

    private static void switchToMenueFrame() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("menue");
    }

    private static void manageInformationFrame() {
        try {
            final By InformationenMaskeButtonWeiter = By.cssSelector("#ff");
            checkAndReturnElement(InformationenMaskeButtonWeiter, 2).click();
        } catch (TimeoutException e) {
            // do nothing
        }
    }

    private static void navigateToLogin() {
        switchToMenueFrame();
        final By menue_frame = By.id("menue_frame_key_icon");
        checkAndReturnElement(menue_frame, 2).click();

        switchToFrameDetail();
    }

    private static void navigateToPruefungsmanagementMenue() {
        switchToFrameDetail();
        final By PruefungsManagementLink = By.cssSelector("a[title='Prüfungsmanagement']");
        checkAndReturnElement(PruefungsManagementLink, 2).click();

        doPINAnmeldung();
    }

    private static void switchToFrameDetail() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("detail");
    }

    private static void doPINAnmeldung() {
        try {
            final By passwordElement = By.cssSelector("input[type='password']");
            final String passwordValue = enterSomethingFromConsole("PIN");
            checkAndReturnElement(passwordElement, 2).sendKeys(passwordValue);
            clickButtonAnmelden();
        } catch (TimeoutException e) {
            // if not present, do nothing
        }
    }

    private static WebElement checkAndReturnElement(By selector, int timeOutInSeconds) throws TimeoutException {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        return wait.until(ExpectedConditions.elementToBeClickable(selector));
    }

    private static void setupWebDriverChrome() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Angelo\\Downloads\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maggioni\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        setupLocation();
    }

    private static void setupLocation() {
        driver.get("https://campusquality.tum.de/");
    }

    private static void isElementPresent(By selector) {
        try {
            WebElement checkAndReturnElement = checkAndReturnElement(selector, 5);
            System.out.println("-> Element :>" + selector + "< is present");
        } catch (TimeoutException e) {
            System.out.println("-> Element :>" + selector + "< is NOT present");
        }
    }

    private static void listAllElements(WebDriver driver, String xPath) {
        List<WebElement> findElementsInFrame = driver.findElements(By.xpath(xPath));
        System.out.println("elements in Frame size :" + findElementsInFrame.size());
        findElementsInFrame.forEach(a -> System.out.println("tag : >" + a.getTagName() + "<  id : >" + a.getAttribute("id") + "<  name : >" + a.getAttribute("name") + "<  text : >" + a.getText() + "<"));
    }

    private static String enterSomethingFromConsole(String text) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.err.println("Enter " + text + " :");
            String input = scanner.nextLine();
            if ("q".equals(input)) {
                System.out.println("Exist :");
                System.exit(0);
            }
            System.out.println("Input is : " + input);
            return input;
        }
    }

    private static void navigationToAbschluesse() {
        final By AbschluesseLink = By.cssSelector("a[name='pv_finalexam']");
        WebElement element = checkAndReturnElement(AbschluesseLink, 2);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element);
    }

    private static void listAllElements(WebElement a) {
        System.out.println("-> " + a.getAttribute("id"));
    }

}
