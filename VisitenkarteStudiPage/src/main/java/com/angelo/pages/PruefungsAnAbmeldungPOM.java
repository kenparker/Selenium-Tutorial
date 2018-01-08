package com.angelo.pages;

import com.angelo.commonNew.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PruefungsAnAbmeldungPOM extends BasePage{

    private final String pageLoadedText = "Prüfungsan-/abmeldung - Prüfungstermine";
    private final String pageUrl = "...";

    @FindBy(css = "#idTabSearch")
    @CacheLookup
    private WebElement idTabSearch;

    @FindBy(css = "a[id*='tab_button']")
    @CacheLookup
    private WebElement meinePruefungsTermine;

    public PruefungsAnAbmeldungPOM(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public boolean isIdTabSearchClickable() {
        getWebElementIfClickable(idTabSearch);
        return true;
    }

    public boolean isMeinePruefungsTermineClickable() {
        getWebElementIfClickable(meinePruefungsTermine);
        return true;
    }

    public void clickIdTabSearch() {
        click(idTabSearch);
    }

    public void clickmeinePruefungsTermine() {
        click(meinePruefungsTermine);
    }

    public PruefungsAnAbmeldungSuchePOM moveToIdTabSearch() {
        click(idTabSearch);
        return new PruefungsAnAbmeldungSuchePOM(this.driver);
    }

    public void verifyPageLoaded() {
        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) d -> d.getPageSource().contains(pageLoadedText));
    }
  
}
