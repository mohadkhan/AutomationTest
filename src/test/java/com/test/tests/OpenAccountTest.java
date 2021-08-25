package com.test.tests;

import com.test.pages.HomePage;
import com.test.pages.OpenAccountPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
public class OpenAccountTest {
    WebDriver driver;

    @Before
    public void setup() throws IOException {
        String classpathStr = new File(".").getCanonicalPath();
        System.setProperty("webdriver.chrome.driver", classpathStr+"\\src\\test\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void openDirectDepositAccount() {
        HomePage home = new HomePage(driver);
        home.clickOnOpenAccountButton();

        OpenAccountPage openAccountPage= new OpenAccountPage(driver);
        openAccountPage.applyForCertificatesOfDepositAccount();
        Assert.assertTrue(openAccountPage.isCertificatesOfDepositAccountSelected());
    }

    @After
    public void close(){
        driver.close();
    }
}
