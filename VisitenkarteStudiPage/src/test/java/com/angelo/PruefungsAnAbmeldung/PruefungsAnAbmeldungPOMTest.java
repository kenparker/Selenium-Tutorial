package com.angelo.PruefungsAnAbmeldung;

import com.angelo.pages.PruefungsAnAbmeldungPOM;
import com.angelo.pages.PruefungsAnAbmeldungSuchePOM;
import com.angelo.visitenkarteTest.VisitenkarteStudiTest;
import static org.testng.Assert.fail;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PruefungsAnAbmeldungPOMTest extends VisitenkarteStudiTest{

    protected PruefungsAnAbmeldungPOM pruefungsAnAbmeldung;

    @BeforeTest
    public void beforePruefungsAnAbmeldung() {
        pruefungsAnAbmeldung = new PruefungsAnAbmeldungPOM(loginController.getDriver());
    }

    @Test(enabled = true, priority = 1)
    public void testClickLinkToPruefungAnAbmeldung() {
        try {
            visitenkarteStudi.clicklinkToPruefungAnAbmeldung();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test(enabled = true, priority = 2)
    public void testLinkToSearchIsClickable() {
        try {
            pruefungsAnAbmeldung.isIdTabSearchClickable();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test(enabled = true, priority = 2)
    public void testLinkToMeinePruefungsTermineIsClickable() {
        try {
            pruefungsAnAbmeldung.isMeinePruefungsTermineClickable();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test(enabled = true, dependsOnMethods = "testLinkToSearchIsClickable", priority = 2)
    public void testClickLinkToSearch() {
        try {
            pruefungsAnAbmeldung.clickIdTabSearch();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test(enabled = true, dependsOnMethods = "testLinkToMeinePruefungsTermineIsClickable", priority = 2)
    public void testClickLinkToMeinePruefungsTermine() {
        try {
            pruefungsAnAbmeldung.clickmeinePruefungsTermine();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
