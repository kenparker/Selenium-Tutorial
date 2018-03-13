package com.angelo.visitenkarteTest;

import com.angelo.pages.VisitenkarteStudiPOM;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;


public class VisitenkarteStudiTest extends TestBase {

    protected VisitenkarteStudiPOM visitenkarteStudi;

    @BeforeClass
    public void beforeVisitenkarte() {
        visitenkarteStudi = new VisitenkarteStudiPOM(loginController.getDriver());
    }

    @Test(enabled = true, priority = 0)
    public void testTitel() {
        Boolean pageTitle = visitenkarteStudi.isPageTitle();
        assertTrue(pageTitle);
    }

    @Test(enabled = true, priority = 0)
    public void testLinkToPruefungsAnAbmeldungIsClickable() {
            boolean linkToPruefungAnAbmeldungClickable = visitenkarteStudi.islinkToPruefungAnAbmeldungClickable();
            assertTrue(linkToPruefungAnAbmeldungClickable);
    }

    @Test(enabled = true, priority = 0)
    public void testVerifyUrl() {
            visitenkarteStudi.verifyPageUrl();
    }

    @Test(enabled = true, priority = 0)
    public void testPageVisitenkarte() {
        visitenkarteStudi.verifyPageLoaded();
    }

}
