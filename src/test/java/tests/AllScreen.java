package tests;

import bases.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static helpers.DriverHelpers.scrollToElement;
import static helpers.DriverHelpers.waitForVisibility;

public class AllScreen extends BaseTest {
   private By all_icon = By.xpath("//a[@id='nav-hamburger-menu']");
    private By Trending = By.xpath("//div[normalize-space()='trending']");
    private By seeAll_Chevron = By.xpath("//i[@class='nav-sprite hmenu-arrow-more']");
    private By video_games = By.xpath("//div[normalize-space()='Video Games']");
    private By All_Video_games = By.xpath("//a[@class='hmenu-item' and text()='All Video Games']");

    public void openAllMenu(){
        waitForVisibility(all_icon);
        driver.findElement(all_icon).click();
    }
    public void validateAllMenuOpened(){
        waitForVisibility(Trending);
        Assert.assertTrue(driver.findElement(Trending).isDisplayed());
    }
    private void expandSeeAllIFDisplayed() {
        try {
            if (driver.findElement(seeAll_Chevron).isDisplayed()) {
                driver.findElement(seeAll_Chevron).click();
            }
        } catch (Exception e) {
            System.out.println("seeAll Chevron is already expanded");
        }
    }
    public void navigateToVideoGAmeScreen(){
        expandSeeAllIFDisplayed();
        scrollToElement(driver.findElement(video_games));
        waitForVisibility(video_games);
        driver.findElement(video_games).click();
        chooseAllVideoGames();

    }
    private void chooseAllVideoGames(){
        waitForVisibility(All_Video_games);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(All_Video_games)).click().perform();
    }

}
