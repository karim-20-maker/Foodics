package stepdefins;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.*;

public class amazonSteps {
    AmazonHomeTest hometest = new AmazonHomeTest();
    AllScreen allscreen = new AllScreen();
    AllVideoGamesTest videoGames = new AllVideoGamesTest();
    SortAllVideoTest sort = new SortAllVideoTest();
    PriceFilterTest price = new PriceFilterTest();


    @Given("I navigated to {string}")
    public void iNavigatedTo(String arg0) {
        hometest.navigateToAmazonUrl(arg0);
    }

    @Then("I should validate amazon welcome screen")
    public void iShouldValidateAmazonWelcomeScreen() {
        hometest.validateAmazonHomeScreen();

    }


    @And("I Click on all icon")
    public void iClickOnAllIcon() {
        allscreen.openAllMenu();
    }


    @Then("I should validated that all menu opened successfully")
    public void iShouldValidatedThatAllMenuOpenedSuccessfully() {
        allscreen.validateAllMenuOpened();
    }

    @Then("I should be navigated dto video game screen")
    public void iShouldBeNavigatedDtoVideoGameScreen() {
        videoGames.validateVideoGamesScreenDisplayedSuccessfully();
    }

    @When("I click on video games element")
    public void iClickOnVideoGamesElement() {
        allscreen.navigateToVideoGAmeScreen();
    }

    @When("I filter screen with free shipping and with new from condition filter")
    public void iFilterScreenWithFreeShippingAndWithNewFromConditionFilter() {
        videoGames.filterWithFreeShippingAndNewCustom();
    }

    @Then("I Should validate That Filter done successfully")
    public void iShouldValidateThatFilterDoneSuccessfully() {
        videoGames.validateAllFilters();

    }

    @When("I open sort menu")
    public void iOpenSortMenu() {
        sort.validateSortList();
    }

    @And("I sort by price from high to low")
    public void iSortByPriceFromHighToLow() {
        sort.sortByPriceFromHighToLow();
    }

    @Then("I should validate screen after sort")
    public void iShouldValidateScreenAfterSort() {
        sort.validateSortingByPriceFromHighToLow();
        price.retrieveAllProducts();
    }
}
