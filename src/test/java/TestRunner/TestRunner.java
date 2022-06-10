package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"./src/test/java/Feature/G_Catalog_productAttributes.feature",},
		glue = {"StepDefinations"},
		plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json", // generate the diffrent
				"junit:target/cucumber-reports/Cucumber.xml",// reports
				"html:target/cucumber-reports/Cucumber.html" ,
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		publish = true,
		monochrome = true, 
		dryRun = false
		//tags = "@DeleteAttrbute"
				)
public class TestRunner {
	
}
