package com.angelo.pages;

import com.angelo.commonNew.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class PruefungsAnAbmeldungPOM extends BasePage{

    private final String pageLoadedText = "...";
    private final String pageUrl = "...";

    @FindBy(css = "#idTabSearch")
    @CacheLookup
    private WebElement idTabSearch;

    @FindBy(css = "#idExamSearchMainMask #idExamSearchTerm")
    @CacheLookup
    private WebElement searchField;

    @FindBy(css = "#idExamSearchButton")
    @CacheLookup
    private WebElement examSearchButton;

    public PruefungsAnAbmeldungPOM(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isIdTabSearchClickable() {
        getWebElementIfClickable(idTabSearch);
        return true;
    }

    public PruefungsAnAbmeldungPOM clickIdTabSearch() {
        click(idTabSearch);
        isSearchFieldClickable();
        return this;
    }

    public boolean isSearchFieldClickable() {
        getWebElementIfClickable(searchField);
        return true;
    }

    private PruefungsAnAbmeldungPOM setSearchField(String examSearch) {
        sendKeys(searchField,examSearch);
        return this;
    }

    public boolean isExamSearchButtonClickable() {
        getWebElementIfClickable(examSearchButton);
        return true;
    }

    private PruefungsAnAbmeldungPOM submitSearch() {
        click(examSearchButton);
        return this;
    }

    public PruefungsAnAbmeldungPOM searchExamByNumber(String examNumber) {
        setSearchField(examNumber);
        submitSearch();
        return this;
    }

    public PruefungsAnAbmeldungPOM searchExamByName(String examName) {
        return this;
    }
    /*

    By tabellePruefungsTermine = By.cssSelector("#idExamOfferTable");
    By tabellePruefungsTermineAlleZeilen = By.cssSelector("#idExamOfferTable tr");
    By spaltePruefungsterminNummer = By.cssSelector("td:nth-child(2)");
    By spalteAnmeldeButton = By.cssSelector("td:nth-child(11) > a");
    
    By overlayFenster = By.cssSelector("div.overlayWindow");
    By selectStudium = By.cssSelector("#idStDegreeProgNr");
    By inBaumWaehlen = By.cssSelector("#idOpenCsTree");
    */


}
