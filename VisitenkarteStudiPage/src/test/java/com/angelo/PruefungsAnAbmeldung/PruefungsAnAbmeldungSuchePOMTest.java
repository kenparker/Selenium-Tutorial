package com.angelo.PruefungsAnAbmeldung;

import com.angelo.pages.PruefungsAnAbmeldungSuchePOM;
import com.angelo.pages.PruefungsTermineTablePOM;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class PruefungsAnAbmeldungSuchePOMTest extends PruefungsAnAbmeldungPOMTest {

    protected PruefungsAnAbmeldungSuchePOM pruefungsAnAbmeldungSuchePOM;
    private PruefungsTermineTablePOM pruefungsTermineTablePOM;
    private String numberToSearch;
    private String nameToSearch;

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
            numberToSearch = "IN8024";
            pruefungsTermineTablePOM = pruefungsAnAbmeldungSuchePOM.searchExamByNumber(numberToSearch);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test(enabled = true, dependsOnMethods = "testKickOffSearchExamByNumber", priority = 6)
    public void testSearchExamByNumberResults() {
        try {
            assertTrue(pruefungsTermineTablePOM.isSearchResultsCorrect(numberToSearch));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test(enabled = true, dependsOnMethods = "testSearchExamByNumberResults", priority = 6)
    public void testKickOffSearchExamByName() {
        nameToSearch = "Innovation";
        pruefungsTermineTablePOM = pruefungsAnAbmeldungSuchePOM.searchExamByName(nameToSearch);
    }

    @Test(enabled = true, dependsOnMethods = "testKickOffSearchExamByName", priority = 6)
    public void testSearchExamByNameResults() {
        assertTrue(pruefungsTermineTablePOM.isSearchResultsCorrect(nameToSearch));
    }

}
