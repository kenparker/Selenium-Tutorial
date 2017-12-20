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
    private By tabellePruefungsTermineSpalteButton = By.cssSelector("td:nth-child(11) > a");
    private By tabellePruefungsTermineAnmeldenButton = By.cssSelector("a[href*='wbExamRegistration.wbRegisterToExam']");
    private By tabellePruefungsTermineAbmeldenButton = By.cssSelector("a[href*='wbExamRegistration.wbDeRegisteredConfirm']");
    private By buttonEnabled = By.cssSelector("a[class*='examOffer_icButton commandButton']");
    private By buttonDisabled = By.cssSelector("a[class*='examOffer_icButton disabled commandButton']");


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
        } catch (SearchNotCorrect | NoElementsInTabellePruefungstermineException e) {
            return false;
        }

    }

    private void checkTabellePruefungsTermine(WebElement table, String search) throws SearchNotCorrect, NoElementsInTabellePruefungstermineException {
        List<WebElement> getAllRows = table.findElements(tabellePruefungsTermineZeile);
        System.out.println("total elements : " + getAllRows.size());
        if (getAllRows.size() == 0)
            throw new NoElementsInTabellePruefungstermineException("no elements in the result table");
        for (WebElement row : getAllRows) checkTableRow(row, search);
    }

    private void checkTableRow(WebElement element, String search) throws SearchNotCorrect {

        String terminNumber = element.findElement(tabellePruefungsTermineSpalteNummer).getText();
        String terminTitel = element.findElement(tabellePruefungsTermineSpalteTitel).getText();

        Boolean isButtonAnmelden = isElementPresent(element, tabellePruefungsTermineAnmeldenButton);
        Boolean isButtonAbmelden = !isButtonAnmelden  & isElementPresent(element, tabellePruefungsTermineAbmeldenButton);
        Boolean isButtonDisabled = isElementPresent(element, buttonDisabled);
        Boolean isButtonEnabled = !isButtonDisabled & isElementPresent(element, buttonEnabled);

        String buttonTitle = element.findElement(tabellePruefungsTermineSpalteButton).getAttribute("title");
        String format = String.format("\n termin >%-10s< AnmeldeButton >%b< AbmeldenButton >%s< Disabled? >%b< >%b<", terminNumber, isButtonAnmelden, isButtonAbmelden, isButtonDisabled, isButtonEnabled);
        System.out.println(format);
        if (isTerminNumerOrTitleCorrect(search, terminNumber, terminTitel)) {
        } else {
            throw new SearchNotCorrect(format);
        }
    }

    private boolean isTerminNumerOrTitleCorrect(String search, String terminNumber, String terminTitel) {
        return terminNumber.toLowerCase().contains(search) || terminTitel.toLowerCase().contains(search);
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
class SearchNotCorrect extends Exception {
    public SearchNotCorrect(String message) {
        super(message);
    }
}

class NoElementsInTabellePruefungstermineException extends Exception {
    public NoElementsInTabellePruefungstermineException(String message) {
        super(message);
    }
}
