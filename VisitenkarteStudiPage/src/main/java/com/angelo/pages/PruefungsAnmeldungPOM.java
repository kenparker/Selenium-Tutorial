package com.angelo.pages;

import com.angelo.commonNew.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PruefungsAnmeldungPOM extends BasePage {

    private final String pageLoadedText = "Prüfungsanmeldung";
    
    @FindBy(css = "#idRegisterToExamMask > div > div > table > tbody")
    @CacheLookup
    private WebElement pruefungsAnmeldungMaske;
    
    @FindBy(xpath = "//*[@id='idRegisterToExamMask']/div/div/table/tbody/tr[2]/td[2]/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[1]/div/table/tbody/tr/td/fieldset/table")
    @CacheLookup
    private WebElement pruefungsbezogeneDaten;

    @FindBy(xpath = "tbody/tr/td[1]/div/table/tbody/tr[1]/td[2]")
    @CacheLookup
    private WebElement pruefungsNummer;

    @FindBy(css = "#idCsNodeNrContainer > table > tbody > tr > td > span")
    @CacheLookup
    private WebElement stellungImStudienplan;
    
    @FindBy(css = "[class*=examOffer_icButton]")
    @CacheLookup
    private WebElement anmeldenButton;
    
    @FindBy(css = "class*='mkClose commandButton']")
    @CacheLookup
    private WebElement abbrechenSchliessenButton;
    
    public PruefungsAnmeldungPOM(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public boolean ispruefungsAnmeldungMaskePresent() {
        getWebElementIfClickable(pruefungsAnmeldungMaske);
        return true;
    }
   
    public boolean isStellungImStudienplanPresent() {
        WebElement webElementIfClickable = getWebElementIfClickable(stellungImStudienplan);
        String text = webElementIfClickable.getText();
        return true;
    }
     
    public void verifyPageLoaded() {
        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) d -> d.getPageSource().contains(pageLoadedText));
    }
}
