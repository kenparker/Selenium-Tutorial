package com.angelo.PruefungsAnAbmeldung;

import com.angelo.visitenkarteTest.VisitenkarteStudiTest;
import static org.testng.Assert.fail;
import org.testng.annotations.Test;

public class PruefungsAnAbmeldungTest extends VisitenkarteStudiTest{
    
    @Test(enabled = true, priority = 1)
    public void testClickLinkToPruefungAnAbmeldung() {
    
        try {
            visitenkarteStudi.clicklinkToPruefungAnAbmeldung();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
