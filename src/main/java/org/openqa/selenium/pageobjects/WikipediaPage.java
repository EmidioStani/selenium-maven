package org.openqa.selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by StaniE on 14/7/2014.
 */
public class WikipediaPage {

    @FindBy(id="firstHeading")
    private WebElement title;

    private WebDriver driver;

    public WikipediaPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHeaderPage(){
        System.out.println(title.getText());
        return title.getText();
    }

}
