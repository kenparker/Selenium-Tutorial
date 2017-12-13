package com.angelo.commonNew;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class JSWaiter {

    private WebDriver driver;
    private WebDriverWait jsWait;
    private JavascriptExecutor jsExec;

    public JSWaiter(WebDriver driver) {
        this.driver = driver;
        this.jsWait = new WebDriverWait(this.driver, 10);
        this.jsExec = (JavascriptExecutor) this.driver;
    }

    public Boolean waitUntilJSReady() {
        ExpectedCondition<Boolean> jsLoad = (WebDriver d) -> ((JavascriptExecutor) d).executeScript("return document.readyState").toString().equals("complete");
        Boolean jsReady = jsWait.until(jsLoad);
        if (!jsReady) {
            System.out.println("JS is NOT ready");
        }
        return jsReady;
    }

    //Wait Until JQuery and JS Ready
    public boolean waitUntilJQueryReady() {

        //Object o = ((JavascriptExecutor) driver).executeScript("return (window.jQuery);");
        //Object o = ((JavascriptExecutor) driver).executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
        //System.out.println("-> " + o);
        //Object return_typeof_jQuery = jsExec.executeScript("return typeof jQuery");
        //System.out.println("-> " +  return_typeof_jQuery);
        //First check that JQuery is defined on the page. If it is, then wait AJAX
        Boolean jQueryDefined = (Boolean) jsExec.executeScript("return typeof jQuery != 'undefined'");
        if (jQueryDefined == true) {
            //Pre Wait for stability (Optional)
            sleep(20);

            //Wait JQuery Load
            boolean jQueryLoad = waitForJQueryLoad();

            //Wait JS Load
            Boolean jsReady = waitUntilJSReady();

            //Post Wait for stability (Optional)
            sleep(20);
            return jQueryLoad | jsReady;
        } else {
            System.out.println("jQuery is not defined on this site!");
            return true;
        }
    }

    //Wait for JQuery Load
    public boolean waitForJQueryLoad() {
        //Wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) jsWait)
                .executeScript("return jQuery.active") == 0);

        //Get JQuery is Ready
        boolean jqueryReady = (Boolean) jsExec.executeScript("return jQuery.active==0");

        //Wait JQuery until it is Ready!
        if (!jqueryReady) {
            System.out.println("JQuery is NOT Ready!");
            //Wait for jQuery to load
            return jsWait.until(jQueryLoad);
        } else {

        }
        return jqueryReady;
    }


    public void sleep(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
