package overflow.suites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Base {

    protected WebDriver driver;

    @BeforeClass
    public void before() {
        System.out.println("before");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maggioni\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.de/");
    }

    @AfterClass
    public void after() {
        System.out.println("after");
        driver.close();
    }
}
