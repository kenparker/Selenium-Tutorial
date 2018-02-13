package com.angelo.PruefungsAnmeldung;

import com.angelo.PruefungsAnAbmeldungSuche.PruefungsAnAbmeldungSuchePOMTest;
import com.angelo.pages.PruefungsAnmeldungPOM;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Optional;

public class PruefungsAnmeldungPOMTest extends PruefungsAnAbmeldungSuchePOMTest {

    private Optional<PruefungsAnmeldungPOM> pruefungsAnmeldungPOM;

    @Test(enabled = true, priority = 6)
    public void testPruefungsAnmeldungDurchfuehrung() {
        pruefungsAnmeldungPOM = pruefungsAnAbmeldungSuchePOM.pruefungsAnmeldungdurchfuehren("WZ1922");
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
}
