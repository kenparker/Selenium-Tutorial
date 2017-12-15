package testng;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseTest {

    @Parameters({ "platform", "browser", "version", "url" })
    @BeforeTest
    public void setUp(String platform, String browser, String version, String url) {

        System.out.printf("\n Setup : platform = %s, browser = %s, version = %s, url = %s",platform, browser, version, url);
        
    }

    @Test
    public void test1() {
        System.out.println("Hi, I'm test1");
    }

    @Test
    public void test2() {
        System.out.println("Hi, I'm test2");
    }
}
