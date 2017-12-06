package com.angelo.sampleamaggionipom;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ToptalLoginPOM {

    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(css = "a[href='https://www.toptal.com/companies/apply']")
    @CacheLookup
    private WebElement company;

    @FindBy(css = "a[href='https://www.toptal.com/talent/apply']")
    @CacheLookup
    private WebElement freelancer;

    @FindBy(id = "save_new_user")
    @CacheLookup
    private WebElement login;

    @FindBy(css = "a.login-forgot_link.no_flexbox-login_link")
    @CacheLookup
    private WebElement lostPassword;

    private final String pageLoadedText = "Toptal: Hire Freelancers from the Top 3%";

    private final String pageUrl = "/users/login";

    @FindBy(id = "user_email")
    @CacheLookup
    private WebElement rememberMe1;

    @FindBy(id = "user_password")
    @CacheLookup
    private WebElement rememberMe2;

    @FindBy(id = "user_remember_me")
    @CacheLookup
    private WebElement rememberMe3;

    @FindBy(css = "a.logo.is-big.is-white")
    @CacheLookup
    private WebElement toptalHireFreelancersFromTheTop;

    public ToptalLoginPOM() {
    }

    public ToptalLoginPOM(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public ToptalLoginPOM(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public ToptalLoginPOM(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Company Link.
     *
     * @return the ToptalLoginPOM class instance.
     */
    public ToptalLoginPOM clickCompanyLink() {
        company.click();
        return this;
    }

    /**
     * Click on Freelancer Link.
     *
     * @return the ToptalLoginPOM class instance.
     */
    public ToptalLoginPOM clickFreelancerLink() {
        freelancer.click();
        return this;
    }

    /**
     * Click on Login Button.
     *
     * @return the ToptalLoginPOM class instance.
     */
    public ToptalLoginPOM clickLoginButton() {
        login.click();
        return this;
    }

    /**
     * Click on Lost Password Link.
     *
     * @return the ToptalLoginPOM class instance.
     */
    public ToptalLoginPOM clickLostPasswordLink() {
        lostPassword.click();
        return this;
    }

    /**
     * Click on Toptal Hire Freelancers From The Top 3 Link.
     *
     * @return the ToptalLoginPOM class instance.
     */
    public ToptalLoginPOM clickToptalHireFreelancersFromTheTopLink() {
        toptalHireFreelancersFromTheTop.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the ToptalLoginPOM class instance.
     */
    public ToptalLoginPOM fill() {
        setRememberMe1PasswordField();
        setRememberMe2PasswordField();
        setRememberMe3CheckboxField();
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the ToptalLoginPOM class instance.
     */
    public ToptalLoginPOM fillAndSubmit() {
        fill();
        return submit();
    }

    /**
     * Set default value to Remember Me Password field.
     *
     * @return the ToptalLoginPOM class instance.
     */
    public ToptalLoginPOM setRememberMe1PasswordField() {
        return setRememberMe1PasswordField(data.get("REMEMBER_ME_1"));
    }

    /**
     * Set value to Remember Me Password field.
     *
     * @return the ToptalLoginPOM class instance.
     */
    public ToptalLoginPOM setRememberMe1PasswordField(String rememberMe1Value) {
        rememberMe1.sendKeys(rememberMe1Value);
        return this;
    }

    /**
     * Set default value to Remember Me Password field.
     *
     * @return the ToptalLoginPOM class instance.
     */
    public ToptalLoginPOM setRememberMe2PasswordField() {
        return setRememberMe2PasswordField(data.get("REMEMBER_ME_2"));
    }

    /**
     * Set value to Remember Me Password field.
     *
     * @return the ToptalLoginPOM class instance.
     */
    public ToptalLoginPOM setRememberMe2PasswordField(String rememberMe2Value) {
        rememberMe2.sendKeys(rememberMe2Value);
        return this;
    }

    /**
     * Set Remember Me Checkbox field.
     *
     * @return the ToptalLoginPOM class instance.
     */
    public ToptalLoginPOM setRememberMe3CheckboxField() {
        if (!rememberMe3.isSelected()) {
            rememberMe3.click();
        }
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the ToptalLoginPOM class instance.
     */
    public ToptalLoginPOM submit() {
        clickLoginButton();
        return this;
    }

    /**
     * Unset Remember Me Checkbox field.
     *
     * @return the ToptalLoginPOM class instance.
     */
    public ToptalLoginPOM unsetRememberMe3CheckboxField() {
        if (rememberMe3.isSelected()) {
            rememberMe3.click();
        }
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the ToptalLoginPOM class instance.
     */
    public ToptalLoginPOM verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    public void waitForPageLoaded1() {
        new WebDriverWait(driver, timeout).until(d -> ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete"));
    }

    public void waitForPageLoaded2() {
        ExpectedCondition<Boolean> expectation = (WebDriver d) -> ((JavascriptExecutor) d).executeScript("return document.readyState").toString().equals("complete");
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    public void waitForPageLoaded3(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = (WebDriver d) -> ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

    public void waitForPageLoaded4(WebDriver driver) {
        String baseUrl = "amaggioni.com";
        // wait for the application to get fully loaded
        WebElement findOwnerLink;
        findOwnerLink = (new WebDriverWait(driver, 30)).until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver d) {
                d.get(baseUrl);
                return d.findElement(By.linkText("Find owner"));
            }
        });
    }

    /**
     * Verify that current page URL matches the expected URL.
     *
     * @return the ToptalLoginPOM class instance.
     */
    public ToptalLoginPOM verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
