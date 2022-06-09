package StepDefinations;

import PageObject.C_Catalog_CategoriesPage;
import Utility.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C_Catalog_Categories extends BaseClass{

	
	public String CategoryName = GenerateProductName();
	
	//****************Common Steps*********************
	@When("User click on the Categories menu Item")
	public void user_click_on_the_categories_menu_item() {
		logger.info("*********Common Steps***********");
		categoryPage = new C_Catalog_CategoriesPage(driver);
		categoryPage.setCategoryMenu();
	}
	@Then("User should be on the Categories Page")
	public void user_is_on_the_categories_page() {
		logger.info("User is on the Categories Page");
	    Assert.assertEquals(driver.getTitle(), "Categories / nopCommerce administration");
	}
	
	//****************Add category*********************
	@Given("User click on the Add new Category button")
	public void user_click_on_the_add_new_category_button() {
		logger.info("****************Add category*********************");
		categoryPage.setAddNewCatBtn();
		logger.info("User click on the Add new Category button");
	}
	@Then("It should be open Add new Category Page")
	public void it_should_be_open_add_new_category_page() {
		logger.info("It should be open Add new Category Page");
	   Assert.assertEquals(driver.getTitle(), "Add a new category / nopCommerce administration");
	}
	@When("User Enter the categoryName and Description")
	public void user_enter_the_category_name_and_description() throws InterruptedException {
		logger.info("User Enter the categoryName and Description");
		categoryPage.setCategoryName(CategoryName);
		Thread.sleep(2000);
		categoryPage.setCategoryDesc("It's computer Category");
	}
	@When("User Click on the category SAVE button")
	public void user_click_on_the_category_save_button() throws InterruptedException {
		logger.info("User Click on the category SAVE button");
		Thread.sleep(2000);
		categoryPage.setSaveBtn();
	}
	@Then("Conformation message should be {string}")
	public void conformation_message_should_be(String expectedMsg) {
		logger.info("Validate the Conformation message");
		String actualMsg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
	    Assert.assertTrue(actualMsg.contains(expectedMsg));
	}
	
	//****************Search category*********************
	@When("User enter the category name in the search input box")
	public void user_enter_the_category_name() {
		logger.info("*********Search Category***********");
		categoryPage.setSearchCategoryName(CategoryName);
	}
	@And("User click on the category search button")
	public void user_click_on_the_category_search_button() {
		logger.info("User click on the search button");
		categoryPage.setSearchCategoryButton();
	}
	@Then("User should found the categoryName from the category Table")
	public void user_should_found_the_category_name_from_the_category_table() {
	    logger.info("User should found the categoryName from the category Table");
	    String actualCatName= driver.findElement(By.xpath("//td[text()='"+CategoryName+"']")).getText();
		Assert.assertTrue(actualCatName.contains(CategoryName));
	}
	
	//****************Update category Info*********************
	@When("User click on the searched category edit button")
	public void user_click_on_the_searched_category_edit_button() throws InterruptedException {
		logger.info("************Update category Info*************");
		WebElement productEditBtn = driver.findElement(By.xpath("//td[text()='"+CategoryName+"']/following-sibling::td/child::a[text()='Edit']"));
		productEditBtn.click();
		Thread.sleep(2000);
		logger.info("User click on the searched category edit button");
	}
	@Then("It should be open Edit category page")
	public void it_should_be_open_edit_category_page() {
	   Assert.assertEquals(driver.getTitle(), "Edit category details / nopCommerce administration");
	   logger.info("It should be open Edit category page");
	}
	@When("User update the Category descripton")
	public void user_update_the_category_descripton() throws InterruptedException {
		categoryPage.setCategoryDesc("Its computer category");
		Thread.sleep(2000);
		logger.info("User update the Category descripton");
	}
	
	@Then("It should be displya the conformation msg {string}")
	public void it_should_be_displya_the_conformation_msg(String expectedMsg) {
		String actualMsg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
	    Assert.assertTrue(actualMsg.contains(expectedMsg));
	    logger.info("Validate the Conformation message");
	}
	
	//****************Delete Category *********************
	@When("User check the searched category checkbox")
	public void user_check_the_category_s_checkbox_in_the_category_table() throws InterruptedException {
		logger.info("***********Delete Category**********");
	    driver.findElement(By.xpath("//td[text() = '"+CategoryName+"']/preceding-sibling::td/child::input")).click();
	    Thread.sleep(2000);
	    logger.info("User check the searched category checkbox");
	}
	@And("User click on the delete\\(Selected) button")
	public void user_click_on_the_delete_selected_button() throws InterruptedException {
		categoryPage.setDeleteBtn();
		Thread.sleep(2000);
		logger.info("User click on the delete(Selected) button");
	}
	@When("User click on the conform YES popup button")
	public void user_click_on_the_conform_yes_popup_button() throws InterruptedException {
		logger.info("User click on the conform YES popup button");
		categoryPage.setConformYesBtn();
		Thread.sleep(2000);
	}
	@Then("Display the msg in the Category table should be {string}")
	public void category_should_be_deleted_from_the_category_table(String expectedMsg) {
		logger.info("Category should be deleted from the category Table");
		String actualMsg= driver.findElement(By.xpath("//td[text() = 'No data available in table']")).getText();
		Assert.assertEquals(actualMsg, expectedMsg);
	}
	
	//****************Export Category List in Excel File *********************
	@Given("User click on the Export droupdown")
	public void user_click_on_the_export_droupdown() throws InterruptedException {
		logger.info("********Export Category List in Excel File******");
		categoryPage.setExportDrpBtn();
		Thread.sleep(2000);
		logger.info("User click on the Export droupdown");
	}
	@When("User select the Export to excel option")
	public void user_select_the_export_to_excel_option() throws InterruptedException {
		categoryPage.setExportXlsxOption();
		Thread.sleep(2000);
		logger.info("User select the Export to excel option");
	}
	@Then("Excel file should be downloaded")
	public void excel_file_should_be_downloaded() {
	   
		logger.info("Excel file should be downloaded");
		
		File listOfFiles[] = folder.listFiles();

		// make sure that the directory is not empty
		Assert.assertTrue(listOfFiles.length > 0);

		for (File file : listOfFiles) {
			// make sure that the downloaded file is not empty
			Assert.assertTrue(file.length() > 0);
		}
	}
	
	//**********Import the Category from Excel file*********
	@Given("User click on the import button")
	public void user_click_on_the_import_button() throws InterruptedException {
		logger.info("User click on the import button");
		categoryPage.setImportBtn();
		Thread.sleep(2000);
		logger.info("User click on the import button");
	}
	@When("User upload the category excel file")
	public void user_upload_the_excel_file() throws InterruptedException, IOException {
		
		categoryPage.setImportExcelFile(System.getProperty("user.dir")+"\\productFiles\\categories.xlsx");
		Thread.sleep(2000);
		logger.info("User upload the category excel file");
	}
	@When("User click on the import to excel button")
	public void user_click_on_the_import_to_excel_button() throws InterruptedException {
		categoryPage.setimportFromExcelBtn();
		Thread.sleep(2000);
		logger.info("User click on the import to excel button");
	}
	@Then("Message should be Display as {string}")
	public void message_should_be_display_as(String expectedMsg) {
		String actualMsg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
	    Assert.assertTrue(actualMsg.contains(expectedMsg));
	    logger.info("Validate the Conformation message");
	}

}
