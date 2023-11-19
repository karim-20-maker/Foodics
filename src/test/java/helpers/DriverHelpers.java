package helpers;

import bases.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverHelpers extends BaseTest {
    public static void navigateToUrl(String url){
        driver.get(url);
    }
    public static void waitForVisibility(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
    }
    public static void waitForVisibility(WebElement by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));
        wait.until(ExpectedConditions.visibilityOf(by));
    }
    public static void scrollToElement(WebElement element){
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",element);
    }
    public static void waitUntilPageLoaded() {
//        try{
//            Thread.sleep(10000);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }

    }
    public static boolean isElementPresent( By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element != null;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
