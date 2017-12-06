import java.util.List;
import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class amaggioniPOM {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(css = "nav.navbar.navbar-default.navbar-fixed-top div.container div:nth-of-type(2) ul.nav.navbar-nav li:nth-of-type(1) a")
    @CacheLookup
    private WebElement about;

    @FindBy(css = "a.navbar-brand")
    @CacheLookup
    private WebElement angeloMaggioni;

    @FindBy(css = "a[href='http://creativecommons.org/licenses/by/3.0/']")
    @CacheLookup
    private WebElement ccBy30;

    @FindBy(css = "a[href='html/contact.html']")
    @CacheLookup
    private WebElement contact;

    @FindBy(css = "a[href='http://www.facebook.com/angeloATmaggioni']")
    @CacheLookup
    private WebElement facebook;

    @FindBy(css = "a[href='http://twitter.com/fat']")
    @CacheLookup
    private WebElement fat;

    @FindBy(css = "a[href='http://fontawesome.io']")
    @CacheLookup
    private WebElement fontAwesome;

    @FindBy(css = "a[href='https://github.com/kenparker']")
    @CacheLookup
    private WebElement github;

    @FindBy(css = "div.intro-header div.container div.row div.col-lg-12 div.intro-message h3 a")
    @CacheLookup
    private WebElement here;

    @FindBy(css = "a[href='html/impressum.html']")
    @CacheLookup
    private WebElement impressum;

    @FindBy(css = "a[href='http://twitter.com/mdo']")
    @CacheLookup
    private WebElement mdo;

    @FindBy(css = "a[href='https://github.com/twbs/bootstrap/blob/master/LICENSE']")
    @CacheLookup
    private WebElement mit;

    private final String pageLoadedText = "My name is Angelo Maggioni,";

    private final String pageUrl = "/";

    @FindBy(css = "button.navbar-toggle")
    @CacheLookup
    private WebElement toggleNavigation;

    @FindBy(css = "a[href='http://www.xing.com/profile/Angelo_Maggioni']")
    @CacheLookup
    private WebElement xing;

    public amaggioniPOM() {
    }

    public amaggioniPOM(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public amaggioniPOM(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public amaggioniPOM(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on About Link.
     *
     * @return the amaggioniPOM class instance.
     */
    public amaggioniPOM clickAboutLink() {
        about.click();
        return this;
    }

    /**
     * Click on Angelo Maggioni Link.
     *
     * @return the amaggioniPOM class instance.
     */
    public amaggioniPOM clickAngeloMaggioniLink() {
        angeloMaggioni.click();
        return this;
    }

    /**
     * Click on Cc By 3.0 Link.
     *
     * @return the amaggioniPOM class instance.
     */
    public amaggioniPOM clickCcBy30Link() {
        ccBy30.click();
        return this;
    }

    /**
     * Click on Contact Link.
     *
     * @return the amaggioniPOM class instance.
     */
    public amaggioniPOM clickContactLink() {
        contact.click();
        return this;
    }

    /**
     * Click on Facebook Link.
     *
     * @return the amaggioniPOM class instance.
     */
    public amaggioniPOM clickFacebookLink() {
        facebook.click();
        return this;
    }

    /**
     * Click on Fat Link.
     *
     * @return the amaggioniPOM class instance.
     */
    public amaggioniPOM clickFatLink() {
        fat.click();
        return this;
    }

    /**
     * Click on Font Awesome Link.
     *
     * @return the amaggioniPOM class instance.
     */
    public amaggioniPOM clickFontAwesomeLink() {
        fontAwesome.click();
        return this;
    }

    /**
     * Click on Github Link.
     *
     * @return the amaggioniPOM class instance.
     */
    public amaggioniPOM clickGithubLink() {
        github.click();
        return this;
    }

    /**
     * Click on Here Link.
     *
     * @return the amaggioniPOM class instance.
     */
    public amaggioniPOM clickHereLink() {
        here.click();
        return this;
    }

    /**
     * Click on Impressum Link.
     *
     * @return the amaggioniPOM class instance.
     */
    public amaggioniPOM clickImpressumLink() {
        impressum.click();
        return this;
    }

    /**
     * Click on Mdo Link.
     *
     * @return the amaggioniPOM class instance.
     */
    public amaggioniPOM clickMdoLink() {
        mdo.click();
        return this;
    }

    /**
     * Click on Mit Link.
     *
     * @return the amaggioniPOM class instance.
     */
    public amaggioniPOM clickMitLink() {
        mit.click();
        return this;
    }

    /**
     * Click on Toggle Navigation Button.
     *
     * @return the amaggioniPOM class instance.
     */
    public amaggioniPOM clickToggleNavigationButton() {
        toggleNavigation.click();
        return this;
    }

    /**
     * Click on Xing Link.
     *
     * @return the amaggioniPOM class instance.
     */
    public amaggioniPOM clickXingLink() {
        xing.click();
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the amaggioniPOM class instance.
     */
    public amaggioniPOM verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    /**
     * Verify that current page URL matches the expected URL.
     *
     * @return the amaggioniPOM class instance.
     */
    public amaggioniPOM verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
