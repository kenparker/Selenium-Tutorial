package com.angelo.selenium.udemy.TestFall.SucheNachMatrikelnummerBeiAbschluesse;

import com.angelo.selenium.udemy.TestFall.Commons.PruefungsManagementOeffnenDemo1;
import static com.angelo.selenium.udemy.TestFall.Commons.PruefungsManagementOeffnenDemo1.checkAndReturnElement;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class AbschluesseMaskeSuchenDemo1 extends PruefungsManagementOeffnenDemo1 {

    public static void main(String[] args) {
        navigateToAbschluesseControl();
    }

    protected static void navigateToAbschluesseControl() {
        navigateToPruefungsmanagementControl();
        navigationToAbschluesse();
        manageWindowAbschluesse();
    }

    protected static void navigationToAbschluesse() {
        final By AbschluesseLink = By.cssSelector("a[name='pv_finalexam']");
        WebElement element = checkAndReturnElement(AbschluesseLink, 2);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element);
    }

    private static void manageWindowAbschluesse() {
        String currentWindow = driver.getWindowHandle();
        switchToWindowAbschluesse(currentWindow);
        //checkPresenceWebElements();
        nachMatrikelNummerSuchen("03643962");
        abschluesseTabelleVerarbeiten();
    }

    protected static void switchToWindowAbschluesse(String currentWindow) {
        Set<String> windowHandles = driver.getWindowHandles();
        windowHandles.stream().filter((String a) -> (!a.equals(currentWindow))).forEachOrdered((String b) -> {
            driver.switchTo().window(b);
        });
    }

    private static void checkPresenceWebElements() {
        By actionBlock = By.cssSelector("#idPageNavi");
        isElementPresent(actionBlock);
        By search = By.cssSelector("#idSearchBox");
        isElementPresent(search);
        By table = By.cssSelector("#idAbschlTable > tbody");
        isElementPresent(table);
        /*By rows = By.cssSelector("#idAbschlTable > tbody > tr");
        List<WebElement> rowsElements = driver.findElements(rows);
        rowsElements.forEach(a -> listAllElements(a));*/
        abschluesseTabelleVerarbeiten();
    }

    private static void nachMatrikelNummerSuchen(String matrikelNummer) {
        By search = By.cssSelector("#idSearchBox");
        checkAndReturnElement(search, 2).sendKeys(matrikelNummer);
        By surchKnopf = By.cssSelector("#idHalloIchBinDerSuchKnopf");
        checkAndReturnElement(surchKnopf, 2).click();
    }

    private static void abschluesseTabelleVerarbeiten(){
        By rows = By.cssSelector("#idAbschlTable > tbody > tr");
        List<WebElement> rowsElements = driver.findElements(rows);
        rowsElements.forEach(a -> abschlussSatzVerarbeiten(a));
    }

    // #idHalloIchBinDerSuchKnopf
    // Matrikelnummer =  #idRealRow2602816 > td:nth-child(5) > a
    // Matrikelnummer =  a[title='zur Studierendenkartei']
    // status #idRealRow2602816 > td:nth-child(3) > div > span > a > img
    // status #idRealRow2602816   img[src='/qtum/img/nyellow_2.gif?20090610160200']
    //                                      /qtum/img/nyellow.gif?20031217211215
    //                                      /qtum/img/xgreen.gif?20051124161356  
    
    private static final By STATUS_GUELTIG = By.cssSelector("img[src='/qtum/img/xgreen.gif?20051124161356']");
    private static final By STATUS_ORANGE = By.cssSelector("img[src='/qtum/img/nyellow.gif?20031217211215']");
    private static final By STATUS_GELB = By.cssSelector("img[src='/qtum/img/nyellow_2.gif?20090610160200']");
    
    private static void abschlussSatzVerarbeiten(WebElement a) {
        By matrikelnummerBy = By.cssSelector("a[title='zur Studierendenkartei']");
        final String matrikelnummer = checkAndReturnElement(a, matrikelnummerBy, 2).getAttribute("innerText");
        String status;
        status = statusPruefenControl(a);
        System.out.println("Matrikelnummer " + matrikelnummer + " status :" + status);
    }

    private static String statusPruefenControl(WebElement a) {
        String status;
        status = statusPruefen(a, STATUS_GELB, "gelb", "");
        status = statusPruefen(a, STATUS_ORANGE, "orange", status);
        status = statusPruefen(a, STATUS_GUELTIG, "grün", status);
        return status;
    }

    private static String statusPruefen(WebElement element, By selector, String statusString, String previousStatus) {
        String status = previousStatus;
        try {
            checkAndReturnElement(element, selector, 2);
            status = statusString;
        } catch (Exception e) {
        }
        return status;
    }
}
