package org.openqa.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.Integer;
import java.util.List;

/**
 * Created by StaniE on 11/7/2014.
        */
public class ResultPage {

    private WebDriver driver;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findDynamicElement(By by, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public boolean allResultsContainString(String text) {
        boolean contains = true;

        WebElement rcnt = findDynamicElement(By.id("rcnt"), 10);

        List<WebElement> allSuggestions = null;
        if (rcnt.getText().isEmpty()){
            System.out.println("list empty");
        }
        else {
            allSuggestions = rcnt.findElements(By.className("g"));
        }

        if(allSuggestions != null) {
            System.out.println(allSuggestions.size());
            for (WebElement result : allSuggestions) {
                if (!(result.getText().toLowerCase().contains(text.toLowerCase()))) {
                    contains = false;
                    break;
                }
            }
        }
        else {
            System.out.println("list is null");
            contains = false;
        }
        return contains;
    }

    public WikipediaPage clickOnTheResult(Integer result){
        WebElement rcnt = findDynamicElement(By.id("rcnt"), 1);

        WebElement firstLink = null;
        if (rcnt.getText().isEmpty()){
            System.out.println("list empty");
        }
        else {
            firstLink = rcnt.findElements(By.className("g")).get(result).findElement(By.tagName("a"));
        }
        firstLink.click();
        return PageFactory.initElements(driver, WikipediaPage.class);

    }




}
