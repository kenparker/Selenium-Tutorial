package com.angelo.pages;

import com.angelo.commonNew.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PruefungsAnAbmeldungSuchePOM extends BasePage{

    private final String pageLoadedText = "Prüfungssuche";
    private final String pageUrl = "...";

    @FindBy(css = "#idExamSearchMainMask #idExamSearchTerm")
    @CacheLookup
    private WebElement searchField;

    @FindBy(css = "#idExamSearchButton")
    @CacheLookup
    private WebElement examSearchButton;

    By tabellePruefungsTermine = By.cssSelector("#idExamOfferTable");
    By tabellePruefungsTermineZeile = By.cssSelector("#idExamOfferTable [class*='coTableR']");
    By tabellePruefungsTermineSpalteNummer = By.cssSelector("td:nth-child(2)");
    By tabellePruefungsTermineSpalteAnmeldenButton = By.cssSelector("td:nth-child(11) > a");


    public PruefungsAnAbmeldungSuchePOM(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public boolean isSearchFieldClickable() {
        getWebElementIfClickable(searchField);
        return true;
    }

    public boolean isTabellePruefungsTermineReady() {
        return isElementReady(tabellePruefungsTermine);
    }

    public WebElement getTabellePruefungsTermine() {
        waitUntilEnabled2();
        System.out.println("-> search button is : " + isElementNowDisabled(examSearchButton));
        WebElement webElementIfReady = getWebElementIfReady(tabellePruefungsTermine);
        listAllElements(webElementIfReady);
        return webElementIfReady;
    }

    private void waitUntilEnabled2() {
        isElementEnabled(examSearchButton);
    }

    private void waitUntilEnabled1() {
        int i = 1;
        while (isElementNowDisabled(examSearchButton)) {
            try {
                System.out.println("/ "+ i++);
                System.out.println("isEnabled   " + examSearchButton.isEnabled());
                boolean contains = driver.getPageSource().contains("loading_24x24.gif");
                System.out.println("isLoading   " + contains);
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void waitUntilLoading() {
        boolean contains = driver.getPageSource().contains("loading_24x24.gif");
    }


    private PruefungsAnAbmeldungSuchePOM setSearchField(String examSearch) {
        sendKeys(searchField,examSearch);
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
