package com.angelo.selenium.udemy.TestFall.Commons;

import org.openqa.selenium.By;

public class NavigateToHomeDemo1 extends LoginToCampusManagement {
    

    public static void zuHomeNavigieren() {
        loginManagement();
        zuHomeSeiteNavigieren();
    }


    protected static void zuHomeSeiteNavigieren() {
        switchToMenueFrame();
        final By HomeButton = By.cssSelector("#menue_frame_myOrg_icon");
        checkAndReturnElement(HomeButton, 2).click();
    }

    
}
