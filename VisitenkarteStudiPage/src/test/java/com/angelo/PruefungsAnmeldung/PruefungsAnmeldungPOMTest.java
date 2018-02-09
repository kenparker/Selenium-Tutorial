package com.angelo.PruefungsAnmeldung;

import com.angelo.PruefungsAnAbmeldungSuche.PruefungsAnAbmeldungSuchePOMTest;
import com.angelo.pages.PruefungsAnmeldungPOM;
import org.testng.annotations.Test;
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
    public void testSeiteIsRichtig() {
        pruefungsAnmeldungPOM.get().verifyPageLoaded();
    }
    
    @Test(enabled = true, priority = 6, dependsOnMethods = "testPruefungsAnmeldungDurchfuehrung")
    public void testIspruefungsAnmeldungMaskePresent() {
        assertTrue(pruefungsAnmeldungPOM.get().ispruefungsAnmeldungMaskePresent());
    }
    
       
    @Test(enabled = true, priority = 6, dependsOnMethods = "testPruefungsAnmeldungDurchfuehrung")
    public void testIsStellungImStudienplanPresent() {
        assertTrue(pruefungsAnmeldungPOM.get().isStellungImStudienplanPresent());
    }
}
