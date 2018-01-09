package com.angelo.PruefungsAnAbmeldungSuche;

import com.angelo.pages.PruefungsTermineTablePOM;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class PruefungsAnAbmeldungSucheBasicPOMTest extends PruefungsAnAbmeldungSuchePOMTest {

    private PruefungsTermineTablePOM pruefungsTermineTablePOM;
    private String numberToSearch;
    private String nameToSearch;

    @Test(enabled = true, priority = 6)
    public void testKickOffSearchExamByNumber() {
        numberToSearch = "IN8024";
        pruefungsTermineTablePOM = pruefungsAnAbmeldungSuchePOM.searchExamByNumber(numberToSearch);
    }

    @Test(enabled = true, dependsOnMethods = "testKickOffSearchExamByNumber", priority = 6)
    public void testSearchExamByNumberResults() {
        assertTrue(pruefungsTermineTablePOM.isSearchResultsCorrect(numberToSearch));
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
