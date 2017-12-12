using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using NUnit.Framework;
using System.Collections;
using System.Xml.Linq;
using OpenQA.Selenium;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Support;
using OpenQA.Selenium.Support.UI;

namespace BMICalculator
{
    [TestFixture]
    public class BMICalculatorNUnitTest
    {
        IWebDriver driver;

        [SetUp]
        public void TestSetup()
        {
            // Create a instance of the Firefox driver using IWebDriver Interface
            driver = new FirefoxDriver();
        }

        [TestCaseSource("BmiTestData")]
	    public void TestBmiCalculator(string height, string weight, string expectedBmi, string expectedCategory)
	    {
            driver.Navigate().GoToUrl("http://cookbook.seleniumacademy.com/bmicalculator.html");

            IWebElement heightElement = driver.FindElement(By.Name("heightCMS"));
            heightElement.SendKeys(height);

            IWebElement weightElement = driver.FindElement(By.Name("weightKg"));
            weightElement.SendKeys(weight);

            IWebElement calculateButton = driver.FindElement(By.Id("Calculate"));
            calculateButton.Click();

            IWebElement bmiElement = driver.FindElement(By.Name("bmi"));
            Assert.AreEqual(expectedBmi, bmiElement.GetAttribute("value"));

            IWebElement bmiCatElement = driver.FindElement(By.Name("bmi_category"));
            Assert.AreEqual(expectedCategory, bmiCatElement.GetAttribute("value"));

	    }

        [TearDown]
        public void TestCleanUp()
        {
            // Close the browser   
            driver.Quit();
        }
                
        private IEnumerable BmiTestData
        {
            get { return GetBmiTestData(); }
        }
        private IEnumerable GetBmiTestData()
        {
            var doc = XDocument.Load(@"c:\data.xml");
            return
                from vars in doc.Descendants("vars")
                let height = vars.Attribute("height").Value
                let weight = vars.Attribute("weight").Value
                let expectedBmi = vars.Attribute("bmi").Value
                let expectedCategory = vars.Attribute("bmi_category").Value
                
                select new object[] { height, weight, expectedBmi, expectedCategory };
        }
    }
}
