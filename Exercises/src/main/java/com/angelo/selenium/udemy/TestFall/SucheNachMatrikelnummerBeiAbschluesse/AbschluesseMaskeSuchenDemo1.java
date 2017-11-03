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
        suchenNachMatrikelnummerBeiAbschluesse();
    }

    protected static void suchenNachMatrikelnummerBeiAbschluesse() {
        zuPruefungsmanagementNavigieren();
        zuAbschluesseNavigieren();
        sucheNachMatrikelnummerDurchfueren();
    }

    protected static void zuAbschluesseNavigieren() {
        final By AbschluesseLink = By.cssSelector("a[name='pv_finalexam']");
        WebElement element = checkAndReturnElement(AbschluesseLink, 2);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element);
    }

    private static void sucheNachMatrikelnummerDurchfueren() {
        String currentWindow = driver.getWindowHandle();
        zuAbschluesseFensterGehen(currentWindow);
        //checkPresenceWebElements();
        nachMatrikelNummerSuchen("03643962");
        abschluesseTabelleVerarbeiten();
    }

    protected static void zuAbschluesseFensterGehen(String currentWindow) {
        Set<String> windowHandles = driver.getWindowHandles();
        windowHandles.stream().filter((String a) -> (!a.equals(currentWindow))).forEachOrdered((String b) -> {
            driver.switchTo().window(b);
        });
    }

    private static void webElementenPruefen() {
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
    
    private static final By STATUS_GUELTIG = By.cssSelector("img[src='/qtum/img/xgreen.gif?20051124161356']");
    private static final By STATUS_ORANGE = By.cssSelector("img[src='/qtum/img/nyellow.gif?20031217211215']");
    private static final By STATUS_GELB = By.cssSelector("img[src='/qtum/img/nyellow_2.gif?20090610160200']");
    
    private static void abschlussSatzVerarbeiten(WebElement a) {
        By matrikelnummerBy = By.cssSelector("a[title='zur Studierendenkartei']");
        final String matrikelnummer = checkAndReturnElement(a, matrikelnummerBy, 2).getAttribute("innerText");
        String status;
        status = abschlussStatusErmitteln(a);
        System.out.println("Matrikelnummer " + matrikelnummer + " status :" + status);
    }

    private static String abschlussStatusErmitteln(WebElement a) {
        String status;
        status = statusErkennen(a, STATUS_GELB, "gelb", "");
        status = statusErkennen(a, STATUS_ORANGE, "orange", status);
        status = statusErkennen(a, STATUS_GUELTIG, "grün", status);
        return status;
    }

    private static String statusErkennen(WebElement element, By selector, String statusString, String previousStatus) {
        String status = previousStatus;
        try {
            checkAndReturnElement(element, selector, 2);
            status = statusString;
        } catch (Exception e) {
        }
        return status;
    }
}
