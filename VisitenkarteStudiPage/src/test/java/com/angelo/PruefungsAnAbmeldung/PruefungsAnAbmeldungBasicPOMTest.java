package com.angelo.PruefungsAnAbmeldung;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class PruefungsAnAbmeldungBasicPOMTest extends PruefungsAnAbmeldungPOMTest{


    @Test(enabled = true, priority = 2)
    public void testPagePruefungsAnAbmeldung() {
        pruefungsAnAbmeldung.verifyPageLoaded();
    }

    @Test(enabled = true, priority = 2)
    public void testLinkToSearchIsClickable() {
        assertTrue(pruefungsAnAbmeldung.isIdTabSearchClickable());
    }

    @Test(enabled = true, priority = 2)
    public void testLinkToMeinePruefungsTermineIsClickable() {
        assertTrue(pruefungsAnAbmeldung.isMeinePruefungsTermineClickable());
    }

    @Test(enabled = true, dependsOnMethods = "testLinkToSearchIsClickable", priority = 2)
    public void testClickLinkToSearch() {
        pruefungsAnAbmeldung.clickIdTabSearch();
    }

    @Test(enabled = true, dependsOnMethods = "testLinkToMeinePruefungsTermineIsClickable", priority = 2)
    public void testClickLinkToMeinePruefungsTermine() {
        pruefungsAnAbmeldung.clickmeinePruefungsTermine();

    }
}
