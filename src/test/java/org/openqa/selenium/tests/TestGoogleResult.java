package org.openqa.selenium.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.pageobjects.GoogleSearchPage;
import org.openqa.selenium.pageobjects.ResultPage;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestGoogleResult {

    private FirefoxDriver driver;

    @Before
    public void setupSelenium() {
        driver = new FirefoxDriver();
    }

    @After
    public void closeSelenium() {
        driver.close();
        driver.quit();
    }

    @Test
    public void ResearchContainsText() {
        GoogleSearchPage homePage = GoogleSearchPage.navigateTo(driver);
        String keystring = "Cheese";
        ResultPage resultsPage = homePage.searchFor(keystring);
        Assert.assertTrue(resultsPage.allResultsContainString(keystring));
    }
}