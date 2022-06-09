package StepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import PageObject.A_loginPage;
import Utility.BaseClass;

public class A_Login extends BaseClass {


	// Login Feature
	@Given("User is already on the login page")
	public void user_is_already_on_the_login_page() {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "Your store. Login");
		logger.info("User is already on the login page");
	}

	@When("User Enters the emailid as {string} and password as {string}")
	public void user_enters_emailId_and_password(String emailid, String pass) {
		loginpage = new A_loginPage(BaseClass.driver);
		loginpage.setemailId(emailid);
		loginpage.setPassword(pass);
		logger.info("User Enter email id and password");

	}

	@And("User click on the login button")
	public void user_click_on_the_login_button() {
		loginpage.setloginbtn();
		logger.info("click on the login button");
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTtile) {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTtile);
		logger.info("Verify the title of the Dashbord");
	}

	@Then("User click on the logout Link")
	public void user_click_on_the_logout_link() {
		loginpage.setLogOutbtn();
		logger.info("User click on the logout Link");
	}

	@Then("LoginPage Title should be {string}")
	public void login_page_title_should_be(String expectedTitle) {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		logger.info("Verify the title of the login page");
	}

}
