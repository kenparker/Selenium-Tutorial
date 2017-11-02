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
        checkPresenceWebElements();
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
        By rows = By.cssSelector("#idAbschlTable > tbody > tr");
        List<WebElement> rowsElements = driver.findElements(rows);
        rowsElements.forEach(a -> listAllElements(a));
    }

}
