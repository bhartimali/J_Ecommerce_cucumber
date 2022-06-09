package StepDefinations;

import PageObject.D_Catalog_ManufacturePage;
import Utility.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.File;

import org.junit.Assert;
import org.openqa.selenium.By;

public class D_Catalog_Manufactures extends BaseClass {

	public String ManufactureName = GenerateManufactureName();

	// *********common Steps*********
	@When("User click on the Menufactures menu Item")
	public void user_click_on_the_menufactures_menu_item() {
		logger.info("*********common Steps*********");
		manufacturePage = new D_Catalog_ManufacturePage(BaseClass.driver);
		manufacturePage.setMenufacturesMenu();
		logger.info("User click on the Menufactures menu Item");
	}

	@Then("User should be on the Menufactures Page")
	public void user_should_be_on_the_menufactures_page() {
		Assert.assertEquals(driver.getTitle(), "Manufacturers / nopCommerce administration");
		logger.info("User should be on the Menufactures Page");
	}

	// *********Add new Manufacture*********
	@Given("User click on add new button")
	public void user_click_on_add_new_button() {
		logger.info("*********Add new Manufacture*********");
		manufacturePage.setAddNewMenufactureBtn();
		logger.info("User click on add new button");
	}

	@Then("It should be open add new manufacture page")
	public void it_should_be_open_add_new_manufacture_page() {
		Assert.assertEquals(driver.getTitle(), "Add a new manufacturer / nopCommerce administration");
		logger.info("It should be open add new manufacture page");
	}

	@When("User enter manufacture name")
	public void user_enter_manufacture_name() throws InterruptedException {
		//open the product category tab
		driver.findElement(By.id("manufacturer-info")).click();
		Thread.sleep(2000);
		manufacturePage.setMenufactureName(ManufactureName);
		Thread.sleep(2000);
		logger.info("User enter manufacture name");
	}

	@When("User click on manufacture save button")
	public void user_click_on_manufacture_save_button() throws InterruptedException {
		manufacturePage.setSaveBtn();
		Thread.sleep(2000);
		logger.info("User click on manufacture save button");
	}

	@Then("Message should be display as {string}")
	public void message_should_be_display_as(String expectedMsg) {
		String actualMsg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
		Assert.assertTrue(actualMsg.contains(expectedMsg));
		logger.info("Validate the Conformation message");
	}

	// *********Search Manufacture Name*********
	@When("User Enter the manufature name in the search box")
	public void user_enter_the_manufature_name_in_the_search_box() throws InterruptedException {
		logger.info("*******Search Manufacture Name*******");
		manufacturePage.setsearchManufacturerName(ManufactureName);
		Thread.sleep(2000);
		logger.info("User Enter the manufature name in the search box");
	}

	@And("User click on the search Manufacture button")
	public void user_click_on_the_search_manufacture_button() throws InterruptedException {
		manufacturePage.setSearchManufactureBtn();
		Thread.sleep(2000);
		logger.info("User click on the search Manufacture button");
	}
	
	@Then("User should be found the manufacture name from the manufacture Table")
	public void user_should_be_found_the_manufacture_name_from_the_manufacture_table() {
	    String actualCatName= driver.findElement(By.xpath("//td[text()='"+ManufactureName+"']")).getText();
		Assert.assertTrue(actualCatName.contains(ManufactureName));
		logger.info("User should found the categoryName from the category Table");
	}
	
	// *********Update Manufacture Info*********
	@When("User click on the edit button in the manufactures table")
	public void user_click_on_the_edit_button_in_the_manufactures_table() {
		logger.info("********Update Manufacture Info*******");
	    driver.findElement(By.xpath("//td[text()='"+ManufactureName+"']/following-sibling::td/child::a")).click();
	    logger.info("User click on the edit button in the manufactures table");
	}
	@Then("It should be open Edit manufacture page")
	public void it_should_be_open_edit_manufacture_page() {
	    Assert.assertEquals(driver.getTitle(), "Edit manufacturer details / nopCommerce administration");
	    logger.info("It should be open Edit manufacture page");
	}
	@When("User update the manufacture name")
	public void user_update_the_manufacture_name() throws InterruptedException {
		manufacturePage.setMenufactureName(ManufactureName);
		Thread.sleep(2000);
		logger.info("User update the manufacture name");
	}
	@Then("Conformation msg should be {string}")
	public void conformation_msg_should_be(String expectedMsg) {
		String actualMsg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
	    Assert.assertTrue(actualMsg.contains(expectedMsg));
	    logger.info("Validate the Conformation message");
	}
	
	// *********Delete Manufacture Info*********
	@When("User check the searched manufacture checkbox")
	public void user_check_the_searched_manufacture_checkbox() {
		logger.info("*********Delete Manufacture Info*********");
		driver.findElement(By.xpath("//td[text()='"+ManufactureName+"']/preceding-sibling::td/child::input")).click();
		logger.info("User Enter the manufature name in the search box");
	}
	@And("User click on the manufacture delete button")
	public void user_click_on_the_manufacture_delete_button() {
		manufacturePage.setDeleteBtn();
		logger.info("User click on the delete\\(Selected) button");
	}
	@When("User click on the manufacture conform YES popup button")
	public void user_click_on_the_manufacture_conform_yes_popup_button() {
		manufacturePage.setConformYesBtn();
		logger.info("User click on the conform YES popup button");
	}
	@Then("Display the Message in the manufacture table should be {string}")
	public void display_the_message_in_the_manufacture_table_should_be(String expectedMsg) {
		String actualMsg= driver.findElement(By.xpath("//td[text() = 'No data available in table']")).getText();
		Assert.assertEquals(actualMsg, expectedMsg);
		logger.info("Category should be deleted from the category Table");
	}
	
	// *********Export Manufacture List in excel File*********
	@Given("User click on the Export droupdown Manufacture page")
	public void user_click_on_the_export_droupdown_manufacture_page() throws InterruptedException {
		logger.info("User click on the Export droupdown Manufacture page");
		manufacturePage.setExportDrpBtn();
		Thread.sleep(2000);
	}
	@When("User select the Export to excel option under droupdown")
	public void user_select_the_export_to_excel_option_under_droupdown() throws InterruptedException {
		logger.info("User select the Export to excel option under droupdown");
		manufacturePage.setExportXlsxOption();
		Thread.sleep(2000);
	}
	@Then("Manufacture List should be downloaded in a excel file")
	public void manufacture_list_should_be_downloaded_in_a_excel_file() {
	    
		logger.info("Manufacture List should be downloaded in a excel file");
		
		File listOfFiles[] = folder.listFiles();

		// make sure that the directory is not empty
		Assert.assertTrue(listOfFiles.length > 0);

		for (File file : listOfFiles) {
			// make sure that the downloaded file is not empty
			Assert.assertTrue(file.length() > 0);
		}
		
	}

	// *********Import Manufacture List from excel File*********
	@Given("User click on the manufacture IMPORT button")
	public void user_click_on_the_manufacture_import_button() throws InterruptedException {
		logger.info("User click on the manufacture IMPORT button");
		manufacturePage.setImportBtn();
		Thread.sleep(2000);
	}
	@When("User upload the Manufacture excel file")
	public void user_upload_the_manufacture_excel_file() throws InterruptedException {
		logger.info("User upload the Manufacture excel file");
		manufacturePage.setImportExcelFile(System.getProperty("user.dir")+"\\productFiles\\manufacturers.xlsx");
		Thread.sleep(2000);
	}
	
	@When("User click on the import to excel button for upload the file")
	public void user_click_on_the_import_to_excel_button_for_upload_the_file() {
		logger.info("User click on the import to excel button for upload the file");
		manufacturePage.setimportFromExcelBtn();
	}

	@Then("Import file Message should be {string}")
	public void import_file_message_should_be(String expectedMsg) {
		logger.info("Validate the Conformation message");
		String actualMsg = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
	    Assert.assertTrue(actualMsg.contains(expectedMsg));
	}
}