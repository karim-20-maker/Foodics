package tests;

import bases.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static helpers.DriverHelpers.*;

public class AddItemsToCart extends BaseTest {
    private int index = 2;
    private By pricesLoc = By.xpath("//span[@class='a-price-whole']");
    private By AddToCartBtn = By.id("add-to-cart-button");
    private By AddedToCartMsg = By.xpath("//*[@id=\"NATC_SMART_WAGON_CONF_MSG_SUCCESS\"]/span");
    private By WarrantyCard = By.xpath("document.querySelector(\"#attach-warranty-header\")");
    private By WarrantyNoThanksBtn = By.xpath("//input[@aria-labelledby='attachSiNoCoverage-announce']");
    public static double totalAmount=0;
    Actions action = new Actions(driver);


    public void OpenItemInNewTap(WebElement item){

        String originalWindow = driver.getWindowHandle();
        scrollToElement(item);
        action.keyDown(Keys.CONTROL).click(item).keyUp(Keys.CONTROL).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        System.out.println(tabs);
        driver.switchTo().window(tabs.get(1));
        AddToCart();
        driver.close();
        driver.switchTo().window(originalWindow);
    }

    public void AddToCart(){
        waitForVisibility(AddToCartBtn);
        driver.findElement(AddToCartBtn).click();
        try {
            waitForVisibility(WarrantyNoThanksBtn);
            driver.findElement(WarrantyNoThanksBtn).click();
        }
        catch (Exception e){
            System.out.println("warranty card is not displayed");
        }
        waitForVisibility(AddedToCartMsg);
        Assert.assertTrue(driver.findElement(AddedToCartMsg).isDisplayed());

    }

    private void navigateToNextPage() {
        By next = By.xpath("//a[@aria-label='Go to next page, page " + index + "']");
        scrollToElement(driver.findElement(next));
        waitForVisibility(next);
        driver.findElement(next).click();
        index++;
        AddSpecificItemsToCart();

    }



    public void AddSpecificItemsToCart(){
        int i,count=0;
        double val;
        waitForVisibility(pricesLoc);
        List<WebElement> pricesList = driver.findElements(pricesLoc);
        for(i=0;i<pricesList.size();i++){
            val = Double.parseDouble(pricesList.get(i).getText().replaceAll(",",""));
            if(val < 15000.0){
                totalAmount=totalAmount+val;
                count ++;
                OpenItemInNewTap(pricesList.get(i));
            }
        }
        if(count == 0) {
            navigateToNextPage();
        }
    }
}
