package StepDefinations;

import PageObject.E_Catalog_ProductReviewPage;
import Utility.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class E_Catalog_ProductReview extends BaseClass{

	//****common Steps*******
	@When("User click on the product review menu Item")
	public void user_click_on_the_product_review_menu_item() throws InterruptedException {
		logger.info("****common Steps****");
		productReviewPage = new E_Catalog_ProductReviewPage(BaseClass.driver); 
		productReviewPage.setProductReviewMenu();
		Thread.sleep(2000);
	}
	@Then("User should be on the product review Page")
	public void user_should_be_on_the_product_review_page() {
		logger.info("User should be on the product review Page");
	    Assert.assertEquals(driver.getTitle(), "Product reviews / nopCommerce administration");
	}
	
	//****Search product review by name*******
	@Given("User Enter the product name in the search box")
	public void user_enter_the_product_name_in_the_searchbox() throws InterruptedException {
		logger.info("****Search product review by name****");
		productReviewPage.setSearchProductName("HTC One Mini Blue");
		logger.info("User Enter the product name in the search box");
		Thread.sleep(2000);
		
	}
	@And("User click on the review search button")
	public void user_click_on_the_review_search_button() throws InterruptedException {
		productReviewPage.setsearchBtn();
		logger.info("User click on the review search button");
		Thread.sleep(2000);
	}
	@Then("User should found the product reviews in the reviews table")
	public void user_should_found_the_reviews_in_the_product_review_table() {
		logger.info("User should found the categoryName from the category Table");
	    String actualCatName= driver.findElement(By.xpath("//a[text()='HTC One Mini Blue']")).getText();
		Assert.assertTrue(actualCatName.contains("HTC One Mini Blue"));
	}
	
	//****Update product review Info*******
	@When("User click on the searched product review Edit button")
	public void user_click_on_the_product_review_edit_button() {
		logger.info("****Update product review Info*******");
		productReviewPage.setProductReviewEditBtn();
		logger.info("User click on the product review Edit button");
	}
	@Then("It should be open Edit product review details page")
	public void it_should_be_open_edit_product_review_details_page() {
	    Assert.assertEquals(driver.getTitle(), "Edit product review details / nopCommerce administration");
	    logger.info("It should be open Edit product review details page");
	}
	@When("User update the review Text")
	public void user_update_the_review_text() throws InterruptedException {
		productReviewPage.setReviewText("and its Very good product");
		Thread.sleep(2000);
		logger.info("User update the review Text");
	}
	@And("User click on the review SAVE  button")
	public void user_click_on_the_review_save_button() throws InterruptedException {
		productReviewPage.setSaveBtn();
		Thread.sleep(2000);
		logger.info("User click on the review SAVE  button");
	}
	@Then("Conformation message should be displayed as {string}")
	public void conformation_message_should_be_displayed_as(String expectedMsg) {
		String actualMsg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
		Assert.assertTrue(actualMsg.contains(expectedMsg));
		logger.info("Validate the Conformation message");
	}

	//**** Approve Selected Product Review*******
	@Then("User check the checkbox of searched product review")
	public void user_check_the_checkbox_of_searched_product_review() throws InterruptedException {
		logger.info("**** Approve Selected Product Review*****");
		productReviewPage.setProductReviewChkbox();
		logger.info("User check the checkbox of searched product review");
		Thread.sleep(2000);
	}
	@Then("User click on the approve selected button")
	public void user_click_on_the_approve_selected_button() throws InterruptedException {
		productReviewPage.setApproveSelectedBtn();
		logger.info("User click on the approve selected button");
		Thread.sleep(2000);
	}
	@Then("User should found the tick mark in product review table in is approved field")
	public void user_should_found_the_tick_mark_in_product_review_table_in_is_approved_field() {
		WebElement itag = driver.findElement(By.xpath("//i[@nop-value='true']"));
	    Assert.assertEquals(itag.getAttribute("nop-value"), "true");
	    logger.info("User should found the tick mark in product review table in is approved field");
	}
	
	//**** DisApprove Selected Product Review*******
	@Then("User click on the DisApprove selected button")
	public void user_click_on_the_dis_approve_selected_button() throws InterruptedException {
		logger.info("**** DisApprove Selected Product Review*******");
		productReviewPage.setDisapproveSelectedBtn();
		logger.info("User click on the DisApprove selected button");
		Thread.sleep(2000);
	}
	@Then("User should found the Cross mark in product review table in is approved field")
	public void user_should_found_the_cross_mark_in_product_review_table_in_is_approved_field() {
		logger.info("User should found the Cross mark in product review table in is approved field");
		WebElement itag = driver.findElement(By.xpath("//i[@nop-value='false']"));
	    Assert.assertEquals(itag.getAttribute("nop-value"), "false");
	}
	
	//**** Delete Selected Product Review*******
	@Given("User check the checkbox of product review in the table")
	public void user_check_the_checkbox_of_product_review_in_the_table() {
		logger.info("**** Delete Selected Product Review*******");
		productReviewPage.deleteProductReview("Asus N551JK-XO076H Laptop");
	}
	
	@Then("User click on the review Delete selected button")
	public void user_click_on_the_review_delete_selected_button() {
		logger.info("User click on the Delete selected button");
		productReviewPage.setDeleteSelectedBtn();
	}
	@Then("User click on the conform review delete YES button")
	public void user_click_on_the_conform_review_delete_yes_button() {
		logger.info("User click on the conform Yes popup button");
		productReviewPage.setConformDeleteYESBtn();
	}
	
}
