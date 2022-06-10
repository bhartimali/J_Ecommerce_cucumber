package StepDefinations;

import PageObject.G_Catalog_productAttrPage;
import Utility.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class G_Catalog_productAttributes extends BaseClass{

	public String attributeName = GenerateManufactureName();
	
	//*******Common Steps*******
	@When("User click on the Attribute menu Item")
	public void user_click_on_the_attribute_menu_item() {
		logger.info("*******Common Steps*******");
		logger.info("User click on the Attribute menu Item");
		productAttrPage = new G_Catalog_productAttrPage(driver);
		productAttrPage.setAttributeMenu();
	}
	@When("User click on the Product Attribute sub menu")
	public void user_click_on_the_product_attribute_sub_menu() {
		logger.info("User click on the Product Attribute sub menu");
		productAttrPage.setProductAttrMenu();
	}
	@Then("User should be on the Product attribute Page")
	public void user_should_be_on_the_product_attribute_page() {
		logger.info("User should be on the Product attribute Page");
	    Assert.assertEquals(driver.getTitle(), "Product attributes / nopCommerce administration");
	}
	
	//*******Add new product Attribute*******
	@Given("User click on the attribute add new button")
	public void user_click_on_the_attribute_add_new_button() {
		logger.info("User click on the attribute add new button");
		productAttrPage.setAddProductAttrBtn();
	}
	@Then("User should be on add new product attribute page")
	public void user_should_be_on_add_new_product_attribute_page() {
		logger.info("User should be on add new product attribute page");
		Assert.assertEquals(driver.getTitle(), "Add a new product attribute / nopCommerce administration");
	}
	@When("User Enter the attribute name")
	public void user_enter_the_attribute_name() {
		logger.info("User Enter the attribute name");
		productAttrPage.setAttributeName(attributeName);
	}
	@When("User click on the attribute SAVE button")
	public void user_click_on_the_attribute_save_button() {
		logger.info("User click on the attribute SAVE button");
		productAttrPage.setAttriSaveBtn();
	}
	@Then("Added attribute conformation Message should be {string}")
	public void added_attribute_conformation_message_should_be(String expectedMsg) {
		logger.info("Validate the Conformation message");
		String actualMsg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
	    Assert.assertTrue(actualMsg.contains(expectedMsg));
	}

	//*******Update product Attribute Info*******
	@When("User click on the added attribute Edit button")
	public void user_click_on_the_added_attribute_edit_button() {
		logger.info("*****Update product Attribute Info******");
		logger.info("User click on the added attribute Edit button");
	    driver.findElement(By.xpath("//td[text()='"+attributeName+"']/following-sibling::td/child::a")).click();
	}
	@Then("It should be open Edit product attribute details page")
	public void it_should_be_open_edit_product_attribute_details_page() {
		logger.info("It should be open Edit product attribute details page");
		Assert.assertEquals(driver.getTitle(), "Edit product attribute details / nopCommerce administration");
	}
	@When("User updates the attribute description")
	public void user_updates_the_attribute_description() {
		logger.info("User updates the attribute description");
		productAttrPage.setAttributeDesc("It's computer Attribute");
	}
	@Then("Attribute updated Message should be {string}")
	public void attribute_updated_message_should_be(String expectedMsg) {
		logger.info("Validate the Conformation message");
		String actualMsg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
	    Assert.assertTrue(actualMsg.contains(expectedMsg));
	}

	//*******Delete product Attribute*******
	@When("User click on the added attribute checkbox")
	public void user_click_on_the_added_attribute_checkbox() {
	   logger.info("*******Delete product Attribute*******");
	   logger.info("User click on the added attribute checkbox");
	   driver.findElement(By.xpath("//td[text()='"+attributeName+"']/preceding-sibling::td/child::input")).click();
	}
	@When("User click on the attribute delete button")
	public void user_click_on_the_attribute_delete_button() {
	    logger.info("User click on the attribute delete button");
	    productAttrPage.setDeleteAttrBtn();
	}
	@When("User click on the conform attribute delete button")
	public void user_click_on_the_conform_attribute_delete_button() {
		logger.info("User click on the conform attribute delete button");
		productAttrPage.setConformYesBtn();
	}
	@Then("Attribute should be deleted from attribute list table")
	public void attribute_should_be_deleted_from_attribute_list_table() {
	   String ActualAttributName = driver.findElement(By.xpath("//td[text()='Custom Text']")).getText();
	   Assert.assertFalse(ActualAttributName, false);
	}

}
