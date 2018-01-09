package com.angelo.PruefungsAnAbmeldungSuche;

import com.angelo.PruefungsAnAbmeldung.PruefungsAnAbmeldungPOMTest;
import com.angelo.pages.PruefungsAnAbmeldungSuchePOM;
import com.angelo.pages.PruefungsTermineTablePOM;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class PruefungsAnAbmeldungSuchePOMTest extends PruefungsAnAbmeldungPOMTest {

    public PruefungsAnAbmeldungSuchePOM pruefungsAnAbmeldungSuchePOM;

    @Test(enabled = true, priority = 5)
    public void testMoveToLinkToSearch() {
        pruefungsAnAbmeldungSuchePOM = pruefungsAnAbmeldung.moveToIdTabSearch();
        pruefungsAnAbmeldungSuchePOM.verifyPageLoaded();
    }


}
