package StepDefinations;

import PageObject.F_Catalog_ProductTagPage;
import Utility.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class F_Catalog_ProductTag extends  BaseClass{
	
	

	//*****common Steps*****
	@When("User click on the product Tags menu Item")
	public void user_click_on_the_product_tags_menu_item() throws InterruptedException {
		logger.info("*****common Steps*****");
		ProductTagPage = new F_Catalog_ProductTagPage(driver);
		ProductTagPage.setProductTagMenu();
		Thread.sleep(2000);
	}
	@Then("User should be on the product tags Page")
	public void user_should_be_on_the_product_tags_page() {
	   Assert.assertEquals(driver.getTitle(), "Product tags / nopCommerce administration");
	   logger.info("User should be on the product tags Page");
	}
	
	//*****Search product tag by tag name*****
	@Given("User enter the product tag name in the searchbox")
	public void user_enter_the_product_tag_name_in_the_searchbox() throws InterruptedException {
		logger.info("//*****Search product tag by tag name*****");
		ProductTagPage.setSearchTagName("cool");
		Thread.sleep(2000);
		logger.info("User enter the product tag name");
	}
	@When("User click on the search tag button")
	public void user_click_on_the_search_tag_button() throws InterruptedException {
		ProductTagPage.setSearchTagBtn();
		Thread.sleep(2000);
		logger.info("User click on the search tag button");
	}
	@Then("User should found the tag name in the tag table")
	public void user_should_found_the_tag_name_in_the_tag_table() {
	    String actualText = driver.findElement(By.xpath("//td[text()='cool']")).getText();
	    Assert.assertEquals(actualText, "cool");
	    logger.info("User should found the tag name in the tag table");
	}

	//*****Update product tag name*****
	@Given("User click on the tag edit button")
	public void user_click_on_the_tag_edit_button() throws InterruptedException {
	   logger.info("*****Update product tag name*****");
	   ProductTagPage.setTagEditBtn();
	   Thread.sleep(2000);
	   logger.info("User click on the tag edit button");
	}
	@Then("It should be open tag edit page")
	public void it_should_be_open_tag_edit_page() {
	   Assert.assertEquals(driver.getTitle(), "Edit product tag details / nopCommerce administration");
	   logger.info("It should be open tag edit page");
	}
	@When("User update the tag name")
	public void user_update_the_tag_name() throws InterruptedException {
		ProductTagPage.setTagName("Fantastick");
		Thread.sleep(2000);
		logger.info("User update the tag name");
	}
	@When("User Click on the tag SAVE button")
	public void user_click_on_the_tag_save_button() throws InterruptedException {
		logger.info("User Click on the tag save button");
		ProductTagPage.setTagSaveBtn();
		Thread.sleep(2000);
	}
	@Then("Updated Conformation message should be {string}")
	public void updated_conformation_message_should_be(String expectedMsg) {
		logger.info("Validate the Conformation message");
		String actualMsg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
		Assert.assertTrue(actualMsg.contains(expectedMsg));
	}
	
	//*****Delete product tag name*****
	@Given("User check the checkbox of tag name in the table")
	public void user_check_the_checkbox_of_tag_name_in_the_table() throws InterruptedException {
		logger.info("*****Delete product tag name*****");
		ProductTagPage.setDeleteTagchkBox("computer");
		logger.info("User check the checkbox of tag name in the table");
		Thread.sleep(2000);
	}
	@When("User click on the tag delete\\(Selected) button")
	public void user_click_on_the_tag_delete_selected_button() throws InterruptedException {
		ProductTagPage.setDeleteTagBtn();
		logger.info("User click on the tag delete\\(Selected) button");
		Thread.sleep(2000);
	}
	@When("User click on the conform YES delete button")
	public void user_click_on_the_conform_yes_delete_button() {
		ProductTagPage.setConformTagYesBtn();
		logger.info("User click on the conform YES delete button");
	}
	@Then("Tag name should be deleted from the table")
	public void tag_name_should_be_deleted_from_the_table() {
	    logger.info("Tag name should be deleted from the table");
	}

}
