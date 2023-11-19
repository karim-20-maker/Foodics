package tests;

import bases.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static helpers.DriverHelpers.*;
import static helpers.DriverHelpers.waitUntilPageLoaded;

public class PriceFilterTest extends BaseTest {
    private List<String> prices = new ArrayList<>();
    private int index = 2;
    private By result = By.xpath("//span[@class='a-size-medium-plus a-color-base a-text-bold']");
    List<WebElement> priceElements = driver.findElements(By.cssSelector("span.a-color-base"));


    public void retrieveAllProducts() {

        for (WebElement element : priceElements) {
            retrievePricesOnCurrentPage();
        }

        System.out.println(prices);
    }


    private boolean retrievePricesOnCurrentPage() {

        for (WebElement element : priceElements) {
            waitForVisibility(element);
            String text = element.getText();

            if (text.matches("EGP\\s[0-9,.]+")) {
                waitUntilPageLoaded();
                double price = extractPrice(text);
                System.out.println(text);

                if (price <= 15000) {
                    prices.add(text);
                } else {
                    System.out.println("No products below 15k");
                    return true; // Stop processing if any price is <= 15000
                }

            }
        }
        return false; // Continue processing on the next page
    }

    private void navigateToNextPage() {
        By next = By.xpath("//a[@aria-label='Go to next page, page " + index + "']");
        scrollToElement(driver.findElement(next));
        waitForVisibility(next);
        driver.findElement(next).click();
        waitUntilPageLoaded();
        index++;
    }

    private double extractPrice(String text) {
        String numericValue = text.replaceAll("[^0-9.]", "");
        return Double.parseDouble(numericValue);
    }
}
