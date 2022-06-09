package StepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import PageObject.B_Catalog_ProductPage;
import Utility.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.File;

import org.junit.Assert;

public class B_Catalog_Product extends BaseClass {

	public String productName = GenerateProductName();
	//public static String searchproduct = GenerateProductName();
	
	// *********Common Steps**************
	@When("User click on the Catalog Menu")
	public void user_click_on_the_catalog_menu() throws InterruptedException {
		logger.info("*********Common Steps**************");
		productPage = new B_Catalog_ProductPage(driver);
		productPage.setCatalogMenu();
		logger.info("User click on the Catalog Menu");
		Thread.sleep(2000);
	}

	@And("User click on the product menu Item")
	public void user_click_on_the_product_menu_item() throws InterruptedException {
		productPage.setProductSubItem();
		logger.info("User click on the product menu Item");
		Thread.sleep(2000);
	}
	
	@Then("User is on the products page")
	public void user_is_on_the_products_page() {
		Assert.assertEquals(driver.getTitle(), "Products / nopCommerce administration");
		logger.info("User is on the product page");
	}
	
	// *********Add new Product**************
	@Given("User click on the Add new button")
	public void user_click_on_the_add_new_button() throws InterruptedException {
		logger.info("*********Add new Product**************");
		productPage.setAddNewProductBtn();
		logger.info("User click on the Add new button");
		Thread.sleep(3000);
	}

	@Then("It should be open Add product page")
	public void it_should_be_open_Add_product_page() {
		Assert.assertEquals(driver.getTitle(), "Add a new product / nopCommerce administration");
		logger.info("It should be open Add product page");
	}

	@When("User fill up the Add product form")
	public void user_fill_up_the_product_form() throws InterruptedException {

		productPage.setProductName(productName);
		Thread.sleep(2000);
		productPage.setShortDescription("Write code here that turns the phrase");
		Thread.sleep(2000);
		productPage.setCategory();
		Thread.sleep(2000);
		productPage.setPrice("100");
		Thread.sleep(2000);
		logger.info("User fill up the Add product form");
	}

	@And("User click on the product save button")
	public void user_click_on_the_product_save_button() throws InterruptedException {
		productPage.setSaveBtn();
		Thread.sleep(3000);
		logger.info("User click on the product save button");
	}

	@Then("Verify the conformation message {string}")
	public void verify_the_conformation_message(String expectedMsg) {
		String actualMsg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
		Assert.assertTrue(actualMsg.contains(expectedMsg));
		logger.info("Verify the conformation message");
	}

	//**********Search Product***********
	@When("User enter product name in the product search box")
	public void user_enter_product_name_in_the_product_search_box() throws InterruptedException {
		logger.info("**********Search Product***********");
		productPage.setSearchProductName(productName);
		Thread.sleep(2000);
		logger.info("User enter product name in the product search box");
	}

	@When("Click on the product search button")
	public void click_on_the_product_search_button() throws InterruptedException {
		productPage.setSearchBtn();
		Thread.sleep(2000);
		logger.info("Click on the product search button");
	}

	@Then("User should found product name in the Search table")
	public void user_should_found_product_name_in_the_Search_table() {
		String actualProductNamet= driver.findElement(By.xpath("//td[text()='"+productName+"']")).getText();
		Assert.assertTrue(actualProductNamet.contains(productName));
		logger.info("User should found product name in the Search table:" + productName);
	}

	// ************Update Product information********
	@When("User Click on the serached product Edit button")
	public void user_click_on_the_product_edit_button() throws InterruptedException {
		logger.info("************Update Product information********");
		WebElement productEditBtn = driver.findElement(By.xpath("//td[text()='"+productName+"']/following-sibling::td/child::a[text()='Edit']"));
		productEditBtn.click();
		logger.info("User Click on the serached product Edit button");
		Thread.sleep(2000);
	}

	@Then("It should be open Edit product detail page")
	public void it_should_be_open_Edit_product_detail_page() {
		Assert.assertEquals(driver.getTitle(), "Edit product details / nopCommerce administration");
		logger.info("It should be open Edit product detail page");
	}

	@When("User update the product price")
	public void user_update_the_product_price() throws InterruptedException {
		productPage.setPrice("100");
		logger.info("User update the product price");
		Thread.sleep(2000);
	}

	@And("Click on the product update SAVE button")
	public void click_on_the_Update_button() throws InterruptedException {
		productPage.setSaveBtn();
		logger.info("Click on the product update SAVE button");
		Thread.sleep(2000);
	}

	@Then("Validate the conformation message as {string}")
	public void validate_the_conformation_message_as(String expectedMsg) {
		String actualMsg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
		Assert.assertTrue(actualMsg.contains(expectedMsg));
		logger.info("Validate the conformation message");
	}

	// ************Delete Selected information********
	@When("User check the searched product checkbox")
	public void user_check_the_searched_product_chekbox() throws InterruptedException {
		logger.info("************Delete Selected information********");
		driver.findElement(By.xpath("//td[text()='"+productName+"']/preceding-sibling::td/child::input")).click();
		logger.info("User check the searched product checkbox");
		Thread.sleep(2000);
	}

	@And("User click on the delete button")
	public void user_click_on_the_delete_button() throws InterruptedException {
		productPage.setdeleteBtn();
		logger.info("User click on the delete button");
		Thread.sleep(2000);
	}

	@And("Click on the conform product delete YES button")
	public void click_on_the_conform_product_delete_yes_button() throws InterruptedException {
		productPage.setConformYesBtn();
		logger.info("Click on the conform product delete YES button");
		Thread.sleep(2000);
	}
	@Then("Varify the text in the product table as {string}")
	public void Varify_the_text_in_the_product_table_as(String expectedText) {
		String actualText= driver.findElement(By.xpath("//td[text() = 'No data available in table']")).getText();
		Assert.assertEquals(actualText, expectedText);
		logger.info("Varify the text in the product table");
	}
	
	// *********Download Catalog as PDF*************
	@Given("User click on the Download calatlog as PDF button")
	public void user_click_on_the_download_calatlog_as_pdf_button() throws InterruptedException {
		logger.info("*********Download Catalog as PDF*************");
		Thread.sleep(2000);
		productPage.setDownloadCatalog();
		Thread.sleep(2000);
		logger.info("User Click on download catalog button");
	}

	@Then("Validate the downloaded catalog PDF")
	public void validate_the_downloaded_catalog_pdf() {
		
		logger.info("Validate the downloaded catalog pdf");
		
		File listOfFiles[] = folder.listFiles();

		// make sure that the directory is not empty
		Assert.assertTrue(listOfFiles.length > 0);

		for (File file : listOfFiles) {
			// make sure that the downloaded file is not empty
			Assert.assertTrue(file.length() > 0);
		}

		
	}
	
	// ********Export selected product in Excel File********
	@Given("User select the product from product table")
	public void user_select_the_product_from_product_table() {
		logger.info("********Export selected product in Excel File********");
		productPage.setDownloadCatalogProduct();
		logger.info("select the product from product table");

	}

	@When("User click on the Export droupdown button")
	public void user_click_on_the_export_droupdown_button() throws InterruptedException {
		productPage.setExportProductBtn();
		Thread.sleep(2000);
		logger.info("click on the Export droupdown button");
	}

	@When("User select the Export to Excel\\(Selected) option")
	public void user_select_the_export_to_excel_selected_option() throws InterruptedException {
		productPage.SetExportExcelOption();
		Thread.sleep(2000);
		logger.info("select the Export to Excel (Selected) option");
	}

	@Then("Validate the downloaded product catalog excel file")
	public void validate_the_downloaded_product_catalog_excel_file() {
		
		logger.info("Validate the downloaded product catalog excel file");

		File listOfFiles[] = folder.listFiles();

		// make sure that the directory is not empty
		Assert.assertTrue(listOfFiles.length > 0);

		for (File file : listOfFiles) {
			// make sure that the downloaded file is not empty
			Assert.assertTrue(file.length() > 0);
		}

	}

}
