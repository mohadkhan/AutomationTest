package com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    //Page URL
    private static String PAGE_URL="https://www.citi.com/";

    //Locators
    @FindBy(how = How.ID, using = "navcreditCardmainAnchor0")
    private WebElement creditCardsAnchor;

    @FindBy(how = How.ID, using = "navOpenAccmainAnchor7")
    private WebElement openAccountButton;

    public HomePage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    public void clickOnOpenAccountButton(){
        openAccountButton.click();
    }
}
