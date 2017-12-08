package com.angelo.visitenkarteTest;

import com.angelo.pages.VisitenkarteStudi;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class VisitenkarteStudiTest extends TestBase {

    @Test(enabled = true)
    public void testTitel() {

        VisitenkarteStudi visitenkarteStudi = PageFactory.initElements(loginController.getDriver(), VisitenkarteStudi.class);
        try {
            String title = visitenkarteStudi.getTitle();
            assertTrue(title.contains("Visitenkarte"));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test(enabled = true)
    public void testLinkToPruefungsAnAbmeldungIsClickable() {

        VisitenkarteStudi visitenkarteStudi = PageFactory.initElements(loginController.getDriver(), VisitenkarteStudi.class);
        try {
            boolean linkToPruefungAnAbmeldungClickable = visitenkarteStudi.islinkToPruefungAnAbmeldungClickable();
            assertTrue(linkToPruefungAnAbmeldungClickable);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test(enabled = true)
    public void testVerifyUrl() {

        VisitenkarteStudi visitenkarteStudi = PageFactory.initElements(loginController.getDriver(), VisitenkarteStudi.class);
        try {
            visitenkarteStudi.verifyPageUrl();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test(enabled = true)
    public void testVerifyPageIsCorrect() {

        VisitenkarteStudi visitenkarteStudi = PageFactory.initElements(loginController.getDriver(), VisitenkarteStudi.class);
        try {
            visitenkarteStudi.verifyPageLoaded();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

}
