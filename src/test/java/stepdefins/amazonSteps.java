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
    CardTest card = new CardTest();
    BuyTest buy = new BuyTest();
    AddItemsToCart addToCard = new AddItemsToCart();


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

    }


    @When("i navigate to card screen")
    public void iNavigateToCardScreen() {
        card.navigateToCard();
    }

    @Then("i should validate all elements into card")
    public void iShouldValidateAllElementsIntoCard() {
        card.vaildateCardOpenedSuccessfully();
    }

    @When("i proceed to buy")
    public void iProceedToBuy() {
        buy.proceedToBuy();

    }

    @Then("i Should redirect to login flow successfully using {string} and {string}")
    public void iShouldRedirectToLoginFlowSuccessfullyUsingAnd(String arg0, String arg1) {
        buy.login(arg0 , arg1);
    }


    @And("i should to be able to add all products from specific price")
    public void iShouldToBeAbleToAddAllProductsFromSpecificPrice() {
        addToCard.AddSpecificItemsToCart();
    }
}
