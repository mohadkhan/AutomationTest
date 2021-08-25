package com.test.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OpenAccountPage {
    private WebDriver driver;
    public final String certificatesOfDepositString = "Certificates of Deposit";
    //Locators
    @FindBy(how = How.ID, using = "myDropdown")
    private WebElement dropDownButton;

    @FindBy(how = How.XPATH, using = "//input[@name=\"zipcode\"]")
    private WebElement zipCode;

    @FindBy(how = How.XPATH, using = "//*[@idstr=\"zipcode-modal\"]//*[text()=\"Submit\"]")
    private WebElement submitButton;

    @FindBy(how = How.XPATH, using = "//citi-text-header//h2[1]")
    private WebElement titleHeader;

    public OpenAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void applyForCertificatesOfDepositAccount() {
        try {
            zipCode.isDisplayed();
            zipCode.sendKeys("10001");
            submitButton.click();
        } catch (NoSuchElementException e) {

            System.out.println("Zipcode modal wasn't  displayed");
        } catch (Exception e) {
            System.out.println("Zipcode modal wasn't  displayed");
        }//Execute select operation if zipcode had already been entered in the previous sessions.
        finally {
            Select select = new Select(dropDownButton);
            select.selectByValue(certificatesOfDepositString);
        }
    }

    public boolean isCertificatesOfDepositAccountSelected() {
        return isGivenAccountSelected(certificatesOfDepositString);
    }

    private boolean isGivenAccountSelected(String inputAccount) {
        return titleHeader.getText().toString().contains(inputAccount);
    }
}

