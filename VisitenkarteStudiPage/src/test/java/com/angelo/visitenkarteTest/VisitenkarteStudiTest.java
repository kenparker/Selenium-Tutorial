package com.angelo.visitenkarteTest;

import com.angelo.pages.VisitenkarteStudiPOM;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import org.testng.annotations.BeforeTest;

public class VisitenkarteStudiTest extends TestBase {

    protected VisitenkarteStudiPOM visitenkarteStudi;
    
    @BeforeClass
    public void beforeVisitenkarte() {
         visitenkarteStudi = new VisitenkarteStudiPOM(loginController.getDriver());
    }
    
    @Test(enabled = true, priority = 0)
    public void testTitel() {

        try {
            String title = visitenkarteStudi.getTitle();
            assertTrue(title.contains("Visitenkarte"));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test(enabled = true, priority = 0)
    public void testLinkToPruefungsAnAbmeldungIsClickable() {

        try {
            boolean linkToPruefungAnAbmeldungClickable = visitenkarteStudi.islinkToPruefungAnAbmeldungClickable();
            assertTrue(linkToPruefungAnAbmeldungClickable);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test(enabled = true, priority = 0)
    public void testVerifyUrl() {

        try {
            visitenkarteStudi.verifyPageUrl();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test(enabled = true, priority = 0)
    public void testVerifyPageIsCorrect() {

        try {
            visitenkarteStudi.verifyPageLoaded();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

}
