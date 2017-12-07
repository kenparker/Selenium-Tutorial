package com.angelo.pages;

import com.angelo.commonNew.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class VisitenkarteStudi extends BasePage {

    private final String pageLoadedText = "systemStatus\" TARGET=\"detail\" id=\"menue_frame_info_icon\" accesskey=\"i\" title=\"Systemstatus und Informationen\" &gt;&lt;IMG SRC=\"/qtum/img/icon_info_normal_tumprod";
    private final String pageUrl = "/QSYSTEM_TUM/webnav.ini";

    @FindBy(css = "a[href='wbExamRegistration.wbMyNawiExams']")
    @CacheLookup
    private WebElement linkToPruefungAnAbmeldung;

    public VisitenkarteStudi(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public VisitenkarteStudi clicklinkToPruefungAnAbmeldung() {
        click(linkToPruefungAnAbmeldung);
        return this;
    }

}
