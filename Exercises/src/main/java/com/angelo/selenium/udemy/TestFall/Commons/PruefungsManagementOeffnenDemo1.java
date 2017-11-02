package com.angelo.selenium.udemy.TestFall.Commons;

import org.openqa.selenium.By;

public class PruefungsManagementOeffnenDemo1 extends NavigateToHomeDemo1 {


    public static void navigateToPruefungsmanagementControl() {

        navigateToHomeControl();
        navigateToPruefungsmanagementMenue();
    }

    protected static void navigateToPruefungsmanagementMenue() {
        switchToFrameDetail();
        final By PruefungsManagementLink = By.cssSelector("a[title='Prüfungsmanagement']");
        checkAndReturnElement(PruefungsManagementLink, 2).click();
        doPINAnmeldung();
    }


}
