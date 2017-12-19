package com.angelo.PruefungsAnAbmeldung;

import com.angelo.pages.PruefungsAnAbmeldungSuchePOM;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class PruefungsAnAbmeldungSuchePOMTest extends PruefungsAnAbmeldungPOMTest{

    protected PruefungsAnAbmeldungSuchePOM pruefungsAnAbmeldungSuchePOM;

    @BeforeClass
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
    public void testKickOffSearchExamByNumber() {
        try {
            String numberToSearch = "IN";
            pruefungsAnAbmeldungSuchePOM.searchExamByNumber(numberToSearch);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test(enabled = true, dependsOnMethods = "testKickOffSearchExamByNumber", priority = 6)
    public void testSearchExamByNumberResults() {
        try {
            String numberToSearch = "IN";
            assertTrue(pruefungsAnAbmeldungSuchePOM.isSearchResultsCorrect(numberToSearch));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test(enabled = true, dependsOnMethods = "testSearchExamByNumberResults", priority = 6)
    public void testKickOffSearchExamByName() {
        try {
            String nameToSearch = "Innovation";
            pruefungsAnAbmeldungSuchePOM.searchExamByName(nameToSearch);
            assertTrue(pruefungsAnAbmeldungSuchePOM.isSearchResultsCorrect(nameToSearch));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

}
