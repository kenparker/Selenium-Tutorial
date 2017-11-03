package com.angelo.selenium.udemy.TestFall.Commons;

import org.openqa.selenium.By;

public class PruefungsManagementOeffnenDemo1 extends NavigateToHomeDemo1 {


    public static void zuPruefungsmanagementNavigieren() {

        zuHomeNavigieren();
        zuPruefungsmanagementMenueNavigieren();
    }

    protected static void zuPruefungsmanagementMenueNavigieren() {
        switchToFrameDetail();
        final By PruefungsManagementLink = By.cssSelector("a[title='Prüfungsmanagement']");
        checkAndReturnElement(PruefungsManagementLink, 2).click();
        doPINAnmeldung();
    }


}
