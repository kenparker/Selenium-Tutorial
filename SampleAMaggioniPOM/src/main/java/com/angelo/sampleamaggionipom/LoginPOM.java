import java.util.List;
import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPOM {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    private final String pageLoadedText = "systemStatus\" TARGET=\"detail\" id=\"menue_frame_info_icon\" accesskey=\"i\" title=\"Systemstatus und Informationen\" &gt;&lt;IMG SRC=\"/qtum/img/icon_info_normal_tumprod";

    private final String pageUrl = "/QSYSTEM_TUM/webnav.ini";

    public LoginPOM() {
    }

    public LoginPOM(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public LoginPOM(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public LoginPOM(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the LoginPOM class instance.
     */
    public LoginPOM verifyPageLoaded() {
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
     * @return the LoginPOM class instance.
     */
    public LoginPOM verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
