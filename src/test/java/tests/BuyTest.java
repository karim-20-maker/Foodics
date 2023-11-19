package tests;

import bases.BaseTest;
import org.openqa.selenium.By;

import static helpers.DriverHelpers.waitForVisibility;

public class BuyTest extends BaseTest {
    private By proceedToBuyCTA = By.xpath("//input[@name='proceedToRetailCheckout']");
    private By email = By.xpath("//input[@id='ap_email']");
    private By continueCTA = By.xpath("//input[@id='continue']");
    private By password = By.xpath("//input[@id='ap_password']");
    private By signin = By.xpath("//input[@id='signInSubmit']");
    public void proceedToBuy(){
        waitForVisibility(proceedToBuyCTA);
        driver.findElement(proceedToBuyCTA).click();
        waitForVisibility(email);
    }
    private void instertMail(String Email){
        waitForVisibility(email);
        driver.findElement(email).sendKeys(Email);
        waitForVisibility(continueCTA);
        driver.findElement(continueCTA).click();
        waitForVisibility(password);
    }
    private void insertPassword(String Password){
        waitForVisibility(password);
        driver.findElement(password).sendKeys(Password);
        waitForVisibility(signin);
        driver.findElement(signin).click();
    }
    public void login(String mail , String pass){
        instertMail(mail);
        insertPassword(pass);

    }
}
