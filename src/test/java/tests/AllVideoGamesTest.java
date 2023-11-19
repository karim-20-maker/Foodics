package tests;

import bases.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static helpers.DriverHelpers.scrollToElement;
import static helpers.DriverHelpers.waitForVisibility;

public class AllVideoGamesTest extends BaseTest {
    private By New_arrivals = By.xpath("//span[normalize-space()='New Arrivals']");
    private By Video_Games = By.xpath("//b[normalize-space()='Video Games']");
    private By freeShipping_CheckBox = By.xpath("//label[@for='apb-browse-refinements-checkbox_2']//i[@class='a-icon a-icon-checkbox']");
    private By CheckedBox = By.cssSelector("label > input[type='checkbox'][checked]");
    private By New = By.xpath("//span[@class='a-size-base a-color-base'][normalize-space()='New']");
    private By BoldedNew = By.xpath("//span[@class='a-size-base a-color-base a-text-bold'][normalize-space()='New']");
    private By result = By.xpath("//span[@class='a-size-medium-plus a-color-base a-text-bold']");
    public void validateVideoGamesScreenDisplayedSuccessfully(){
        waitForVisibility(Video_Games);
        Assert.assertTrue(driver.findElement(New_arrivals).isDisplayed());
        Assert.assertTrue(driver.findElement(Video_Games).isDisplayed());
    }
    private void checkFreeShippingBox(){
        waitForVisibility(freeShipping_CheckBox);
        if (driver.findElement(freeShipping_CheckBox).getAttribute("checked")!= null){

            System.out.println("Checkbox is checked.");
        } else {

            driver.findElement(freeShipping_CheckBox).click();
            System.out.println("Checkbox was not checked and i checked it now");
        }
        validateScreenAfterFreeShippingFilter();
    }
    private void validateScreenAfterFreeShippingFilter(){
        waitForVisibility(result);
        Assert.assertTrue(driver.findElement(result).isDisplayed());
    }
    private void filterWithNew(){
        scrollToElement(driver.findElement(New));
        waitForVisibility(New);
        implementNewFilter();
    }
    private void implementNewFilter(){
        String classAttributeValue = driver.findElement(New).getAttribute("class");
        boolean isBold = classAttributeValue.contains("a-text-bold");
        if (isBold) {
            System.out.println("New filter implemented");
        } else {
            driver.findElement(New).click();
            waitForVisibility(result);

        }
    }
    public void filterWithFreeShippingAndNewCustom(){
        checkFreeShippingBox();
        filterWithNew();
    }
    private void validateNewFilter(){
        scrollToElement(driver.findElement(BoldedNew));
        String NewClassAttributeValue = driver.findElement(BoldedNew).getAttribute("class");
        Assert.assertTrue(NewClassAttributeValue.contains("a-text-bold"));
    }
    private void validateFreeShippingCheckBox(){
        waitForVisibility(CheckedBox);
        WebElement label = driver.findElement(CheckedBox);
        boolean isChecked = label.isSelected();
        Assert.assertTrue(isChecked);
    }
    public void validateAllFilters(){
        validateFreeShippingCheckBox();
        validateNewFilter();
    }
}

