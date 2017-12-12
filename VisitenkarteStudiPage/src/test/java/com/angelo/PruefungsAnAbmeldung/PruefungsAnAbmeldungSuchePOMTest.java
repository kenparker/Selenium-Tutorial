package com.angelo.PruefungsAnAbmeldung;

import com.angelo.pages.PruefungsAnAbmeldungSuchePOM;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class PruefungsAnAbmeldungSuchePOMTest extends PruefungsAnAbmeldungPOMTest{

    protected PruefungsAnAbmeldungSuchePOM pruefungsAnAbmeldungSuchePOM;

    @BeforeTest
    public void beforePruefungsSuche() {

    }

    @Test(enabled = true, priority = 5)
    public void testMoveToLinkToSearch() {
        try {
            pruefungsAnAbmeldungSuchePOM = pruefungsAnAbmeldung.moveToIdTabSearch();
            pruefungsAnAbmeldungSuchePOM.verifyPageLoaded();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }


    @Test(enabled = true, dependsOnMethods = "testMoveToLinkToSearch", priority = 6)
    public void testSearchExamByNumber() {
        try {
            pruefungsAnAbmeldungSuchePOM.searchExamByNumber("IN");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

}
