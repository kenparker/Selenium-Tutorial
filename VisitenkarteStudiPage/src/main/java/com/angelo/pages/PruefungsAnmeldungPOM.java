package com.angelo.pages;

import com.angelo.commonNew.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Optional;

public class PruefungsAnmeldungPOM extends BasePage {

    private final String pageLoadedText = "Prüfungsanmeldung";

    private By pruefungsAnmeldungMaske = By.cssSelector("#idRegisterToExamMask > div > div > table > tbody");
    private WebElement pruefungsAnmeldungMaskeElement;

    private By pruefungsbezogeneDaten = By.xpath("//*[@id='idRegisterToExamMask']/div/div/table/tbody/tr[2]/td[2]/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[1]/div/table/tbody/tr/td/fieldset/table");
    private WebElement pruefungsbezogeneDatenElement;

    private By pruefungsNummer = By.xpath("tbody/tr/td[1]/div/table/tbody/tr[1]/td[2]");
    private WebElement pruefungsNummerElement;

    private By stellungImStudienplan = By.cssSelector("#idCsNodeNrContainer > table > tbody > tr > td > span");
    private WebElement stellungImStudienplanElement;

    private By imBaumWaehlen = By.cssSelector("#idOpenCsTree");
    private WebElement imBaumWaehlenElement;

    private By anmeldenButton = By.cssSelector("[class*=examOffer_icButton]");
    private WebElement anmeldenButtonElement;

    private By abbrechenSchliessenButton = By.cssSelector("[class*='mkClose commandButton']");
    private WebElement abbrechenSchliessenButtonElement;

    public PruefungsAnmeldungPOM(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public Optional<WebElement> getPruefungsAnmeldungMaske() {
        pruefungsAnmeldungMaskeElement = getWebElementIfClickable(pruefungsAnmeldungMaske);
        return Optional.of(pruefungsAnmeldungMaskeElement);
    }

    public void initAllWebElements() {

        pruefungsbezogeneDatenElement = findElement(pruefungsAnmeldungMaskeElement, pruefungsbezogeneDaten);
        pruefungsNummerElement = findElement(pruefungsbezogeneDatenElement, pruefungsNummer);
        stellungImStudienplanElement = findElement(pruefungsAnmeldungMaskeElement, stellungImStudienplan);
        imBaumWaehlenElement = findElement(pruefungsAnmeldungMaskeElement, imBaumWaehlen);
        anmeldenButtonElement = findElement(pruefungsAnmeldungMaskeElement, anmeldenButton);
        abbrechenSchliessenButtonElement = findElement(pruefungsAnmeldungMaskeElement, abbrechenSchliessenButton);
        /*
        String text1 = pruefungsNummerElement.getText();
        String text2 = stellungImStudienplanElement.getText();
        String text3 = anmeldenButtonElement.getText();
        String text4 = abbrechenSchliessenButtonElement.getText();
        */
    }

    public boolean isAnmeldeButtonDisabled() {
        return isElementDisabled(anmeldenButtonElement);
    }

    public boolean isAbbrechenButtonDisabled() {
        return isElementDisabled(abbrechenSchliessenButtonElement);
    }

    public boolean isAbbrechenButtonEnabled() {
        return isElementEnabled(abbrechenSchliessenButtonElement);
    }

    public boolean isStellungImStudienplanEnabled() {
        return isElementEnabled(stellungImStudienplanElement);
    }

    public boolean isStellungImStudienplanBitteWaehlen() {
        return (isStellungImStudienplanEnabled() && stellungImStudienplanElement.getText().equalsIgnoreCase("Bitte wählen"));
    }

    public boolean isImBaumWaehlenEnabled() {
        return isElementEnabled(imBaumWaehlenElement);
    }

    public void stellungImStudienplanAuswaelen() {
        if (isImBaumWaehlenEnabled()) {
            click(imBaumWaehlenElement);
        }
    }

    public void verifyPageLoaded() {
        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) d -> d.getPageSource().contains(pageLoadedText));
    }
}
