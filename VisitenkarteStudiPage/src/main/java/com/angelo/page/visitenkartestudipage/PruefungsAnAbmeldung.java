package com.angelo.page.visitenkartestudipage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PruefungsAnAbmeldung {

    private WebDriver driver;

    By tabSuche = By.cssSelector("#idTabSearch");
    By suchBegriff = By.cssSelector("#idExamSearchMainMask #idExamSearchTerm");
    
    By tabellePruefungsTermine = By.cssSelector("#idExamOfferTable");
    By tabellePruefungsTermineAlleZeilen = By.cssSelector("#idExamOfferTable tr");
    By spaltePruefungsterminNummer = By.cssSelector("td:nth-child(2)");
    By spalteAnmeldeButton = By.cssSelector("td:nth-child(11) > a");
    
    By overlayFenster = By.cssSelector("div.overlayWindow");
    By selectStudium = By.cssSelector("#idStDegreeProgNr");
    By inBaumWaehlen = By.cssSelector("#idOpenCsTree");

}
