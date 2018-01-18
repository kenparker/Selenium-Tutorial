package com.angelo.PruefungsAnmeldung;

import com.angelo.PruefungsAnAbmeldungSuche.PruefungsAnAbmeldungSuchePOMTest;
import com.angelo.pages.PruefungsAnmeldungPOM;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import java.util.Optional;

public class PruefungsAnmeldungPOMTest extends PruefungsAnAbmeldungSuchePOMTest {

    @Test(enabled = true, priority = 6)
    public void testPruefungsAnmeldungDurchfuehrung() {
        Optional<PruefungsAnmeldungPOM> pruefungsAnmeldungPOM = pruefungsAnAbmeldungSuchePOM.pruefungsAnmeldungdurchfuehren("WZ1922");
        assertTrue(pruefungsAnmeldungPOM.isPresent());

    }
}
