package com.angelo.pages;

import com.angelo.commonNew.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class PruefungsTermineTablePOM extends BasePage {

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

    public Optional<PruefungsAnmeldungPOM> pruefungsAnmeldungDurchfuehren(String pruefungsTermin) {
        Optional<WebElement> rowWithPruefungsTermin = Optional.empty();
        try {
            rowWithPruefungsTermin = searchPruefungsTermin(getTabellePruefungsTermine(), pruefungsTermin.toLowerCase());
            if (rowWithPruefungsTermin.isPresent()) {
                WebElement anmeldeButton = rowWithPruefungsTermin.get().findElement(tabellePruefungsTermineAnmeldenButton);
                click(anmeldeButton);
                return Optional.of(new PruefungsAnmeldungPOM(this.driver));
            } else return Optional.empty();
        } catch (NoElementsInTabellePruefungsTermineException e) {
            return Optional.empty();
        }
    }

    private Optional<WebElement> searchPruefungsTermin(WebElement table, String pruefungsTermin) throws NoElementsInTabellePruefungsTermineException {
        List<WebElement> getAllRows = getWebElements(table);
        return getAllRows.stream().filter(row -> isAnmeldenButtonForPruefungsTerminActive(row, pruefungsTermin)).findFirst();
    }

    private boolean isAnmeldenButtonForPruefungsTerminActive(WebElement row, String pruefungsTermin) {
        String terminNumber = row.findElement(tabellePruefungsTermineSpalteNummer).getText();
        return terminNumber.toLowerCase().contains(pruefungsTermin) &&
                isElementPresent(row, tabellePruefungsTermineAnmeldenButton) &&
                !isElementPresent(row, buttonDisabled);
    }



    private void checkTabellePruefungsTermine(WebElement table, String search) throws SearchNotCorrect, NoElementsInTabellePruefungsTermineException {
        List<WebElement> getAllRows = getWebElements(table);
        for (WebElement row : getAllRows) checkTableRow(row, search);
    }

    private void checkTableRow(WebElement row, String search) throws SearchNotCorrect {

        String terminNumber = row.findElement(tabellePruefungsTermineSpalteNummer).getText();
        String terminTitel = row.findElement(tabellePruefungsTermineSpalteTitel).getText();

        Boolean isButtonAnmelden = isElementPresent(row, tabellePruefungsTermineAnmeldenButton);
        Boolean isButtonAbmelden = !isButtonAnmelden & isElementPresent(row, tabellePruefungsTermineAbmeldenButton);
        Boolean isButtonDisabled = isElementPresent(row, buttonDisabled);
        Boolean isButtonEnabled = !isButtonDisabled & isElementPresent(row, buttonEnabled);

        String buttonTitle = row.findElement(tabellePruefungsTermineSpalteButton).getAttribute("title");
        String format = String.format("\n termin >%-10s< AnmeldeButton >%b< AbmeldenButton >%s< Disabled? >%b< >%b<", terminNumber, isButtonAnmelden, isButtonAbmelden, isButtonDisabled, isButtonEnabled);
        System.out.println(format);
        if (isTerminNumerOrTitleCorrect(search, terminNumber, terminTitel)) {
        } else {
            throw new SearchNotCorrect(format);
        }
    }

    private List<WebElement> getWebElements(WebElement table) throws NoElementsInTabellePruefungsTermineException {
        List<WebElement> getAllRows = table.findElements(tabellePruefungsTermineZeile);
        System.out.println("total elements : " + getAllRows.size());
        if (getAllRows.size() == 0)
            throw new NoElementsInTabellePruefungsTermineException("no elements in the result table");
        return getAllRows;
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
