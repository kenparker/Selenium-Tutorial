package com.angelo.pages;

import com.angelo.commonNew.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PruefungsAnAbmeldungSuchePOM extends BasePage {

    private final String pageLoadedText = "Prüfungssuche";

    @FindBy(css = "#idExamSearchMainMask #idExamSearchTerm")
    @CacheLookup
    private WebElement searchField;

    @FindBy(css = "#idExamSearchButton")
    @CacheLookup
    private WebElement examSearchButton;

    private PruefungsTermineTablePOM pruefungsTermineTablePOM;

    public PruefungsAnAbmeldungSuchePOM(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public boolean isSearchFieldClickable() {
        getWebElementIfClickable(searchField);
        return true;
    }

    private void setSearchField(String examSearch) {
        sendKeys(searchField, examSearch);
    }

    public boolean isExamSearchButtonClickable() {
        getWebElementIfClickable(examSearchButton);
        return true;
    }

    private PruefungsTermineTablePOM submitSearch() {
        click(examSearchButton);
        isElementEnabled(examSearchButton);
        return pruefungsTermineTablePOM = new PruefungsTermineTablePOM(this.driver);
    }

    public PruefungsTermineTablePOM searchExamByNumber(String examNumber) {
        setSearchField(examNumber);
        return submitSearch();
    }

    public PruefungsTermineTablePOM searchExamByName(String examName) {
        setSearchField(examName);
        return submitSearch();
    }

    public void verifyPageLoaded() {
        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) d -> d.getPageSource().contains(pageLoadedText));
    }

}


