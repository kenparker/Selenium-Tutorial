package com.angelo.pages;

import com.angelo.commonNew.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PruefungsTermineTablePOM extends BasePage {

    //private WebElement pruefungsTermineTable;

    private By tabellePruefungsTermine = By.cssSelector("#idExamOfferTable");
    private By tabellePruefungsTermineZeile = By.cssSelector("#idExamOfferTable [class*='coTableR']");
    private By tabellePruefungsTermineSpalteNummer = By.cssSelector("td:nth-child(2)");
    private By tabellePruefungsTermineSpalteTitel = By.cssSelector("td:nth-child(5) > div:nth-child(1) > span:nth-child(1)");
    private By tabellePruefungsTermineSpalteButton = By.cssSelector("td:nth-child(11) > a");
    private By tabellePruefungsTermineAnmeldenButton = By.cssSelector("a[href*='wbExamRegistration.wbRegisterToExam']");
    private By tabellePruefungsTermineAbmeldenButton = By.cssSelector("a[href*='wbExamRegistration.wbDeRegisteredConfirm']");
    private By buttonEnabled = By.cssSelector("a[class*='examOffer_icButton commandButton']");
    private By buttonDisabled = By.cssSelector("a[class*='examOffer_icButton disabled commandButton']");

    public PruefungsTermineTablePOM(WebDriver driver) {
        super(driver);
    }

    public WebElement getTabellePruefungsTermine() {
        return getWebElementIfVisible(tabellePruefungsTermine);
    }

    public Boolean isSearchResultsCorrect(String search) {
        try {
            checkTabellePruefungsTermine(getTabellePruefungsTermine(), search.toLowerCase());
            return true;
        } catch (SearchNotCorrect | NoElementsInTabellePruefungsTermineException e) {
            return false;
        }
    }

    private void checkTabellePruefungsTermine(WebElement table, String search) throws SearchNotCorrect, NoElementsInTabellePruefungsTermineException {
        List<WebElement> getAllRows = table.findElements(tabellePruefungsTermineZeile);
        System.out.println("total elements : " + getAllRows.size());
        if (getAllRows.size() == 0)
            throw new NoElementsInTabellePruefungsTermineException("no elements in the result table");
        for (WebElement row : getAllRows) checkTableRow(row, search);
    }

    private void checkTableRow(WebElement element, String search) throws SearchNotCorrect {

        String terminNumber = element.findElement(tabellePruefungsTermineSpalteNummer).getText();
        String terminTitel = element.findElement(tabellePruefungsTermineSpalteTitel).getText();

        Boolean isButtonAnmelden = isElementPresent(element, tabellePruefungsTermineAnmeldenButton);
        Boolean isButtonAbmelden = !isButtonAnmelden & isElementPresent(element, tabellePruefungsTermineAbmeldenButton);
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
}

class SearchNotCorrect extends Exception {
    public SearchNotCorrect(String message) {
        super(message);
    }
}

class NoElementsInTabellePruefungsTermineException extends Exception {
    public NoElementsInTabellePruefungsTermineException(String message) {
        super(message);
    }
}
