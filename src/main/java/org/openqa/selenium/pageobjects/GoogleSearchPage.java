package org.openqa.selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {
    // Here's the element
    @FindBy(how = How.NAME, using="q")
    private WebElement searchbox;

    @FindBy(name="btnG")
    private WebElement searchButton;

    private WebDriver driver;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public static GoogleSearchPage navigateTo(WebDriver driver) {
        driver.get("http://www.google.com/");
        return PageFactory.initElements(driver, GoogleSearchPage.class);
    }

    public ResultPage searchFor(String text) {
        searchbox.sendKeys(text);
        searchButton.click();
        return PageFactory.initElements(driver, ResultPage.class);
    }
}