package bases;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseTest {
    protected static WebDriver driver ;
   @Before
    public void setup(){
       driver = new ChromeDriver();
       driver.manage().deleteAllCookies();
       driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        if( driver != null ){
            driver.quit();
        }
    }
}
