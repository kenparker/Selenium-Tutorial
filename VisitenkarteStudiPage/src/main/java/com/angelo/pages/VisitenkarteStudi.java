package com.angelo.pages;

import com.angelo.commonNew.BasePage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VisitenkarteStudi extends BasePage {

    private final String pageLoadedText = "Visitenkarte/Arbeitsplatz";
    private final String pageUrl = "/QSYSTEM_TUM/webnav.ini";

    @FindBy(css = "a[href='wbExamRegistration.wbMyNawiExams']")
    @CacheLookup
    private WebElement linkToPruefungAnAbmeldung;

    public VisitenkarteStudi(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean islinkToPruefungAnAbmeldungClickable() {
        getWebElementIfClickable(linkToPruefungAnAbmeldung);
        return true;
    }
    
    public VisitenkarteStudi clicklinkToPruefungAnAbmeldung() {
        click(linkToPruefungAnAbmeldung);
        return this;
    }

    public VisitenkarteStudi verifyPageLoaded() {
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    public VisitenkarteStudi verifyPageUrl() {
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
