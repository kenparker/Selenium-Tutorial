package com.angelo.pages;

import com.angelo.commonNew.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VisitenkarteStudiPOM extends BasePage {

    private final String pageLoadedText = "Visitenkarte/Arbeitsplatz";
    private final String pageUrl = "/webnav.ini";
    private final String pageTitel = "Visitenkarte";

    @FindBy(css = "a[href='wbExamRegistration.wbMyNawiExams']")
    @CacheLookup
    private WebElement linkToPruefungAnAbmeldung;

    public VisitenkarteStudiPOM(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public boolean islinkToPruefungAnAbmeldungClickable() {
        getWebElementIfClickable(linkToPruefungAnAbmeldung);
        return true;
    }
    
    public void clicklinkToPruefungAnAbmeldung() {
        click(linkToPruefungAnAbmeldung);
    }

    public void verifyPageLoaded() {
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) d -> d.getPageSource().contains(pageLoadedText));
    }

    public void verifyPageUrl() {
        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) d -> d.getCurrentUrl().contains(pageUrl));
    }

    public Boolean isPageTitle() {
        return isPageTitleOK(pageTitel);
    }
}
