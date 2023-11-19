package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( features="src/test/java/features",glue={"stepdefins"},tags = "@Regression",
        plugin={"pretty", "html:target/reports/cucumber/html.html",
                "json:target/cucumber.json", "usage:target/usage.jsonx",
                "testng:target/junit.xml"},monochrome=true)
public class TestRunner extends AbstractTestNGCucumberTests {



}
