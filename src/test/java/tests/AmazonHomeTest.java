package tests;

import bases.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


import static helpers.DriverHelpers.navigateToUrl;
import static helpers.DriverHelpers.waitForVisibility;

public class AmazonHomeTest extends BaseTest {
    private By Amazon_Logo = By.xpath("//a[@id='nav-logo-sprites']");

    public void navigateToAmazonUrl(String url){
        navigateToUrl(url);
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(url));
    }
    public void validateAmazonHomeScreen(){
        waitForVisibility(Amazon_Logo);
        Assert.assertTrue(driver.findElement(Amazon_Logo).isDisplayed());
        System.out.println(driver.findElement(Amazon_Logo).getAttribute("aria-label"));
        Assert.assertTrue(driver.findElement(Amazon_Logo).getAttribute("aria-label").contains("Amazon"));

    }
}
