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

public class PruefungsAnmeldungPOM extends BasePage {

    private final String pageLoadedText = "Prüfungsanmeldung";
    
    @FindBy(css = "#idRegisterToExamMask > div > div > table > tbody")
    @CacheLookup
    private WebElement pruefungsAnmeldungMaske;
    
    private By pruefungsbezogeneDaten = By.xpath("//*[@id='idRegisterToExamMask']/div/div/table/tbody/tr[2]/td[2]/div/table/tbody/tr[1]/td/div/table/tbody/tr/td[1]/div/table/tbody/tr/td/fieldset/table");

    private By pruefungsNummer = By.xpath("tbody/tr/td[1]/div/table/tbody/tr[1]/td[2]");

    private By stellungImStudienplan = By.cssSelector("#idCsNodeNrContainer > table > tbody > tr > td > span");
   
    private By anmeldenButton = By.cssSelector("[class*=examOffer_icButton]");
 
    private By abbrechenSchliessenButton = By.cssSelector("[class*='mkClose commandButton']");
    
    public PruefungsAnmeldungPOM(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public boolean ispruefungsAnmeldungMaskePresent() {
        getWebElementIfClickable(pruefungsAnmeldungMaske);
        return true;
    }
   
    public boolean isStellungImStudienplanPresentAlt() {
        WebElement webElementIfClickable = getWebElementIfClickable(stellungImStudienplan);
        String text = webElementIfClickable.getText();
        return true;
    }
    
     
    public boolean isStellungImStudienplanPresent() {
        /*
        replace with getWebElementIfClickable
        or implement generic findElement with two parameters
        */
        final WebElement pruefungsAnmeldungMaskeElement = getWebElementIfClickable(pruefungsAnmeldungMaske);
        WebElement pruefungsbezogeneDatenElement = pruefungsAnmeldungMaskeElement.findElement(pruefungsbezogeneDaten);
        WebElement pruefungsNummerElement = pruefungsbezogeneDatenElement.findElement(pruefungsNummer);
        String text1 = pruefungsNummerElement.getText();
        
        WebElement stellungImStudienplanElement = pruefungsAnmeldungMaskeElement.findElement(stellungImStudienplan);
        String text2 = stellungImStudienplanElement.getText();
        
        WebElement anmeldenButtonElement = pruefungsAnmeldungMaskeElement.findElement(anmeldenButton);
        String text3 = anmeldenButtonElement.getText();
        
        WebElement abbrechenElement = pruefungsAnmeldungMaskeElement.findElement(abbrechenSchliessenButton);
        String text4 = abbrechenElement.getText();
        return true;
    }
     
    public void verifyPageLoaded() {
        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) d -> d.getPageSource().contains(pageLoadedText));
    }
}
