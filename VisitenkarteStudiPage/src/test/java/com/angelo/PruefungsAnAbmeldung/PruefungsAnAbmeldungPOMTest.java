package com.angelo.PruefungsAnAbmeldung;

import com.angelo.pages.PruefungsAnAbmeldungPOM;
import com.angelo.visitenkarteTest.VisitenkarteStudiTest;

import java.util.Objects;

import org.testng.Assert;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PruefungsAnAbmeldungPOMTest extends VisitenkarteStudiTest {

    protected PruefungsAnAbmeldungPOM pruefungsAnAbmeldung;

    @BeforeClass
    public void beforePruefungsAnAbmeldung() {
        pruefungsAnAbmeldung = new PruefungsAnAbmeldungPOM(loginController.getDriver());
    }

    @Test(enabled = true, priority = 1)
    public void testClickLinkToPruefungAnAbmeldung() {
        visitenkarteStudi.clicklinkToPruefungAnAbmeldung();
    }

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
