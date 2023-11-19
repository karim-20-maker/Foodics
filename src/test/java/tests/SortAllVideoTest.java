package tests;

import bases.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;
import static helpers.DriverHelpers.scrollToElement;
import static helpers.DriverHelpers.waitForVisibility;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

public class SortAllVideoTest extends BaseTest {
    private By sort_menu = By.id("s-result-sort-select");

    public void validateSortList (){
        scrollToElement(driver.findElement(sort_menu));
        waitForVisibility(sort_menu);
        Assert.assertTrue(driver.findElement(sort_menu).isDisplayed());
    }
    private void selectFromDropDown(String option){
        findDropDownElement().selectByVisibleText(option);
    }

    private List<String> getSelectedOptions(){
        List<WebElement> selectedElements = findDropDownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    private Select findDropDownElement(){
        return new Select(driver.findElement(sort_menu));
    }
    public void sortByPriceFromHighToLow(){
        String option = "Price: High to Low";
        selectFromDropDown(option);
    }
    public void validateSortingByPriceFromHighToLow(){
        var selectedOptions = getSelectedOptions();
        assertTrue(selectedOptions.contains("Price: High to Low"), "Option not selected");
    }
}
