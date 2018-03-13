package com.angelo.PruefungsAnmeldung;

import com.angelo.PruefungsAnAbmeldungSuche.PruefungsAnAbmeldungSuchePOMTest;
import com.angelo.pages.PruefungsAnmeldungPOM;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class PruefungsAnmeldungBasicPOMTest extends PruefungsAnAbmeldungSuchePOMTest {

    public Optional<PruefungsAnmeldungPOM> pruefungsAnmeldungPOM;

    @Test(enabled = true, priority = 6)
    public void testPruefungsAnmeldungDurchfuehrung() {
        pruefungsAnmeldungPOM = pruefungsAnAbmeldungSuchePOM.pruefungsAnmeldungdurchfuehren("MA3403");
        assertTrue(pruefungsAnmeldungPOM.isPresent());
    }

    @Test(enabled = true, priority = 6, dependsOnMethods = "testPruefungsAnmeldungDurchfuehrung")
    public void testPruefungsAnmeldungMaskeIstRichtig() {
        pruefungsAnmeldungPOM.get().verifyPageLoaded();
    }

    @Test(enabled = true, priority = 6, dependsOnMethods = "testPruefungsAnmeldungMaskeIstRichtig")
    public void testGetpruefungsAnmeldungMaskeIfPresent() {
        Optional<WebElement> pruefungsAnmeldungMaske = pruefungsAnmeldungPOM.get().getPruefungsAnmeldungMaske();
        assertTrue(pruefungsAnmeldungMaske.isPresent());
    }

    @Test(enabled = true, priority = 6, dependsOnMethods = "testGetpruefungsAnmeldungMaskeIfPresent")
    public void testInitAllElements() {
        pruefungsAnmeldungPOM.get().initAllWebElements();
    }

    @Test(enabled = true, priority = 6, dependsOnMethods = "testInitAllElements")
    public void testIsAnmeldeButtonDisabled() {
        assertTrue(pruefungsAnmeldungPOM.get().isAnmeldeButtonDisabled());
    }

    @Test(enabled = true, priority = 6, dependsOnMethods = "testInitAllElements")
    public void testIsAbbrechenButtonDisabled() {
        assertFalse(pruefungsAnmeldungPOM.get().isAbbrechenButtonDisabled());
    }

    @Test(enabled = true, priority = 6, dependsOnMethods = "testInitAllElements")
    public void testIsAbbrechenButtonEnabled() {
        assertTrue(pruefungsAnmeldungPOM.get().isAbbrechenButtonEnabled());
    }

    @Test(enabled = true, priority = 6, dependsOnMethods = "testInitAllElements")
    public void testImBaumWaehlen() throws Exception {
        assertTrue(pruefungsAnmeldungPOM.get().isImBaumWaehlenEnabled());
    }

    @Test(enabled = true, priority = 6, dependsOnMethods = "testInitAllElements")
    public void testIsStellungImStudienplanBitteWaehlen() throws Exception {
        assertTrue(pruefungsAnmeldungPOM.get().isStellungImStudienplanBitteWaehlen());
    }

}
