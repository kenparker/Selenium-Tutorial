package com.angelo.PruefungsAnmeldung;

import com.angelo.PruefungsAnAbmeldungSuche.PruefungsAnAbmeldungSuchePOMTest;
import com.angelo.pages.PruefungsAnmeldungPOM;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Optional;

public class PruefungsAnmeldungPOMTest extends PruefungsAnmeldungBasicPOMTest {

    @Test(enabled = true, priority = 7)
    public void testImBaumWaehlen2() throws Exception {
        pruefungsAnmeldungPOM.get().stellungImStudienplanAuswaelen();
    }
}
