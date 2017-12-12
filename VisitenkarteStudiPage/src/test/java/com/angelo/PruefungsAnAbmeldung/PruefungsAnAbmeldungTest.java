package com.angelo.PruefungsAnAbmeldung;

import com.angelo.pages.PruefungsAnAbmeldungPOM;
import com.angelo.visitenkarteTest.VisitenkarteStudiTest;
import static org.testng.Assert.fail;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PruefungsAnAbmeldungTest extends VisitenkarteStudiTest{

    protected PruefungsAnAbmeldungPOM pruefungsAnAbmeldung;

    @BeforeTest
    public void beforePriefungsAnAbmeldung() {
        pruefungsAnAbmeldung = PageFactory.initElements(loginController.getDriver(),PruefungsAnAbmeldungPOM.class);
    }

    @Test(enabled = true, priority = 1)
    public void testClickLinkToPruefungAnAbmeldung() {
    
        try {
            visitenkarteStudi.clicklinkToPruefungAnAbmeldung();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test(enabled = true, priority = 2)
    public void testLinkToSearchIsClickable() {
        try {
            pruefungsAnAbmeldung.isIdTabSearchClickable();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test(enabled = true, dependsOnMethods = "testLinkToSearchIsClickable", priority = 2)
    public void testClickLinkToSearch() {
        try {
            pruefungsAnAbmeldung.clickIdTabSearch();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test(enabled = true, dependsOnMethods = "testLinkToSearchIsClickable", priority = 3)
    public void testSearchExamByNumber() {
        try {
            pruefungsAnAbmeldung.searchExamByNumber("IN");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
