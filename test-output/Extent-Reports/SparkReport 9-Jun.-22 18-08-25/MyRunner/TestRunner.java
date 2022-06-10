package MyRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "D:\\Eclipse\\Eclipse Project\\J_Cucumber_OrangeHRM\\src\\main\\java\\Features\\A_Login.feature", 
		glue = {"StepDefinations" },
		plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json", // generate the diffrent																				// reports
				"junit:target/cucumber-reports/Cucumber.xml",
				"html:target/cucumber-reports/Cucumber.html", 
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		tags = "@LoginTest",
		publish = true,
		monochrome = true, 
		dryRun = false
				)
public class TestRunner {

}
