package com.angelo.page.visitenkartestudipage;

import com.angelo.common.WebElementManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VisitenkarteStudi {

    private WebDriver driver;
    private WebElementManagement webElementManagement;

    By linkToPruefungAnAbmeldung = By.cssSelector("a[href=\'wbExamRegistration.wbMyNawiExams']");

    public VisitenkarteStudi(WebDriver driver) {
        this.driver = driver;
        this.webElementManagement = new WebElementManagement(driver);
    }

    public WebElement getLinkToPruefungAnAbmeldung() throws Exception {
        return webElementManagement.checkAndReturnElement(linkToPruefungAnAbmeldung, 2);
    }
}
