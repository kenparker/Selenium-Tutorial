package com.secookbook.examples.chapter13;

import static org.junit.Assert.*;
import static org.testng.Assert.assertEquals;

import java.net.URL;
import java.text.MessageFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceTest {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		String SAUCE_USER = "<your username>";
		String SAUCE_KEY = "<your key>";
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platform", "OS X 10.9");
		caps.setCapability("browserName", "Safari");
		caps.setCapability("name", "BMI Calculator Test");
		driver = new RemoteWebDriver(new URL(MessageFormat.format("http://{0}:{1}@ondemand.saucelabs.com:80/wd/hub'", 
				SAUCE_USER, SAUCE_KEY)), caps);
		driver.get("http://bit.ly/1zdNrFZ");
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testBmiCalc() {
		WebElement height = driver.findElement(By.name("heightCMS"));
		height.sendKeys("181");

		WebElement weight = driver.findElement(By.name("weightKg"));
		weight.sendKeys("80");

		WebElement calculateButton = driver.findElement(By.id("Calculate"));
		calculateButton.click();

		WebElement bmi = driver.findElement(By.name("bmi"));
		assertEquals(bmi.getAttribute("value"), "24.4");

		WebElement bmi_category = driver.findElement(By.name("bmi_category"));
		assertEquals(bmi_category.getAttribute("value"), "Normal");
	}

}
