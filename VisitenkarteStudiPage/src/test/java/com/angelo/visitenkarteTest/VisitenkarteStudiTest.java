package com.angelo.visitenkarteTest;

import com.angelo.pages.VisitenkarteStudi;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;


public class VisitenkarteStudiTest extends TestBase{

    @Test
    public void testTitel() {

        VisitenkarteStudi visitenkarteStudi = PageFactory.initElements(loginController.getDriver(),VisitenkarteStudi.class);
        try {
            String title = visitenkarteStudi.getTitle();
            assertTrue(title.contains("Visitenkarte"));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testLinkToPruefungsAnAbmeldungIsClickable() {

        VisitenkarteStudi visitenkarteStudi = PageFactory.initElements(loginController.getDriver(),VisitenkarteStudi.class);
        try {
            visitenkarteStudi.clicklinkToPruefungAnAbmeldung();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

}