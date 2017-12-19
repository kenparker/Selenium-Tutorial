package com.angelo.pages;

import com.angelo.commonNew.BasePage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PruefungsAnAbmeldungSuchePOM extends BasePage {

    private final String pageLoadedText = "Prüfungssuche";
    private final String pageUrl = "...";

    @FindBy(css = "#idExamSearchMainMask #idExamSearchTerm")
    @CacheLookup
    private WebElement searchField;

    @FindBy(css = "#idExamSearchButton")
    @CacheLookup
    private WebElement examSearchButton;

    private By tabellePruefungsTermine = By.cssSelector("#idExamOfferTable");
    private By tabellePruefungsTermineZeile = By.cssSelector("#idExamOfferTable [class*='coTableR']");
    private By tabellePruefungsTermineSpalteNummer = By.cssSelector("td:nth-child(2)");
    private By tabellePruefungsTermineSpalteTitel = By.cssSelector("td:nth-child(5) > div:nth-child(1) > span:nth-child(1)");
    private By tabellePruefungsTermineSpalteAnmeldenButton = By.cssSelector("td:nth-child(11) > a");


    public PruefungsAnAbmeldungSuchePOM(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public boolean isSearchFieldClickable() {
        getWebElementIfClickable(searchField);
        return true;
    }

    public boolean isTabellePruefungsTermineVisible() {
        return isElementVisible(tabellePruefungsTermine);
    }

    public Boolean isSearchResultsCorrect(String search) {
        isElementEnabled(examSearchButton);
        WebElement webElementTablePruefungsTermine = getWebElementIfVisible(tabellePruefungsTermine);
        try {
            checkTabellePruefungsTermine(webElementTablePruefungsTermine, search.toLowerCase());
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    private void checkTabellePruefungsTermine(WebElement table, String search) throws Exception {
        List<WebElement> getAllRows = table.findElements(tabellePruefungsTermineZeile);
        System.out.println("total elements : " + getAllRows.size());
        for (WebElement row : getAllRows) checkRow(row, search);
    }

    private void checkRow(WebElement element, String search) throws Exception {
        String terminNumber = element.findElement(tabellePruefungsTermineSpalteNummer).getText();
        String terminTitel = element.findElement(tabellePruefungsTermineSpalteTitel).getText();
        String anmeldeButton = element.findElement(tabellePruefungsTermineSpalteAnmeldenButton).getAttribute("title");
        if (terminNumber.toLowerCase().contains(search) || terminTitel.toLowerCase().contains(search)) {
            System.out.printf("\n termin >%-10s<  titel >%s< anmeldebutton >%s<", terminNumber, terminTitel, anmeldeButton);
        } else {
            throw new Exception();
        }
    }

    private PruefungsAnAbmeldungSuchePOM setSearchField(String examSearch) {
        sendKeys(searchField, examSearch);
        return this;
    }

    public boolean isExamSearchButtonClickable() {
        getWebElementIfClickable(examSearchButton);
        return true;
    }

    private PruefungsAnAbmeldungSuchePOM submitSearch() {
        click(examSearchButton);
        return this;
    }

    public PruefungsAnAbmeldungSuchePOM searchExamByNumber(String examNumber) {
        setSearchField(examNumber);
        submitSearch();
        return this;
    }

    public PruefungsAnAbmeldungSuchePOM searchExamByName(String examName) {
        setSearchField(examName);
        submitSearch();
        return this;
    }


    public PruefungsAnAbmeldungSuchePOM verifyPageLoaded() {
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }
    /*
    By tabellePruefungsTermineAlleZeilen = By.cssSelector("#idExamOfferTable tr");
    #idExamOfferTable  [class*="coTableR"] > td:nth-child(2) oder #idExamOfferTable   td:nth-child(2)
    By spaltePruefungsterminNummer = By.cssSelector("td:nth-child(2)");
    By spalteAnmeldeButton = By.cssSelector("td:nth-child(11) > a");
    
    By overlayFenster = By.cssSelector("div.overlayWindow");
    By selectStudium = By.cssSelector("#idStDegreeProgNr");
    By inBaumWaehlen = By.cssSelector("#idOpenCsTree");
    */

}
