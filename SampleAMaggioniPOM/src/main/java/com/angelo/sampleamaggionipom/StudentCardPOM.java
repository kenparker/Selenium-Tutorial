import java.util.List;
import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StudentCardPOM {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    private final String pageLoadedText = "systemStatus\" TARGET=\"detail\" id=\"menue_frame_info_icon\" accesskey=\"i\" title=\"Systemstatus und Informationen\" &gt;&lt;IMG SRC=\"/qtum/img/icon_info_normal_tumprod";

    private final String pageUrl = "/QSYSTEM_TUM/webnav.ini";

    public StudentCardPOM() {
    }

    public StudentCardPOM(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public StudentCardPOM(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public StudentCardPOM(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the StudentCardPOM class instance.
     */
    public StudentCardPOM verifyPageLoaded() {
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
     * @return the StudentCardPOM class instance.
     */
    public StudentCardPOM verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
