package tests;

import bases.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static helpers.DriverHelpers.waitForVisibility;
import static tests.AddItemsToCart.totalAmount;

public class CardTest extends BaseTest {
    String total ;
    private By card = By.xpath("//span[@id='nav-cart-count']");
    private By shopping_card = By.xpath("//h1[normalize-space()='Shopping Cart']");
    private By total_Price = By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']");
    public void navigateToCard(){
        waitForVisibility(card);
        driver.findElement(card).click();
    }
    public void vaildateCardOpenedSuccessfully(){
        waitForVisibility(shopping_card);
        Assert.assertTrue(driver.findElement(shopping_card).isDisplayed());
        validateTotalPrice();
    }

    private void validateTotalPrice(){
        String TotalVal = driver.findElement(total_Price).getText().replaceAll("EGP","").
                replaceAll(" ","").replaceAll(",","");

        double value = Double.parseDouble(TotalVal);
        Assert.assertEquals(value,totalAmount);
    }
}
