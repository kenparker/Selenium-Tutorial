package com.angelo.PruefungsAnAbmeldungSuche;

import com.angelo.PruefungsAnAbmeldung.PruefungsAnAbmeldungPOMTest;
import com.angelo.pages.PruefungsAnAbmeldungSuchePOM;
import org.testng.annotations.Test;


public class PruefungsAnAbmeldungSuchePOMTest extends PruefungsAnAbmeldungPOMTest {

    public PruefungsAnAbmeldungSuchePOM pruefungsAnAbmeldungSuchePOM;

    @Test(enabled = true, priority = 5)
    public void testMoveToLinkToSearch() {
        pruefungsAnAbmeldungSuchePOM = pruefungsAnAbmeldung.moveToIdTabSearch();
        pruefungsAnAbmeldungSuchePOM.verifyPageLoaded();
    }


}
