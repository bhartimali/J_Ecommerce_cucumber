package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class C_Catalog_CategoriesPage{

	public WebDriver driver;
	
	public C_Catalog_CategoriesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//OBJECTS
	//**********Add Category***********
	@FindBy(xpath="//a[@href='/Admin/Category/List']") private WebElement CategoryMenuItem;
	@FindBy(xpath="//a[@href='/Admin/Category/Create']") private WebElement addNewCatBtn;
	@FindBy(xpath="//input[@id='Name']") private WebElement categoryName;
	@FindBy(xpath="//iframe[@id='Description_ifr']") private WebElement iframe;
	@FindBy(xpath="//body[@data-id='Description']/child::p") private WebElement CategoryDesc;
	@FindBy(xpath="//button[@name='save']") private WebElement saveBtn;
	
	//**********Search Category***********
	@FindBy(id="SearchCategoryName")private WebElement SearchCategoryName;
	@FindBy(id="search-categories")private WebElement SearchCategoryButton;
	
	//**********Delete added Category ***********
	@FindBy(id="delete-selected")private WebElement deleteBtn;
	@FindBy(xpath="//button[normalize-space(text()) = 'Yes']")private WebElement conformYesBtn;
	
	//**********Export Category List in excel file ***********
	@FindBy(xpath="//button[@data-toggle='dropdown']") private WebElement exportDrpBtn;
	@FindBy(xpath="//a[@href='/Admin/Category/ExportXlsx']") private WebElement ExportXlsxOption;
	
	//**********Import Category form Excel file**********
	@FindBy(name="importexcel")private WebElement importBtn;
	@FindBy(id="importexcelfile")private WebElement importExcelFile;
	@FindBy(xpath="//button[normalize-space(text())= 'Import from Excel']")private WebElement importFromExcelBtn;
	
	//**********Add Category***********
	public void setCategoryMenu() {
		CategoryMenuItem.click();
	}
	public void setAddNewCatBtn() {
		addNewCatBtn.click();
	}
	public void setCategoryName(String catName) {
		categoryName.sendKeys(catName);;
	}
	public void setCategoryDesc(String catDescription) {
		driver.switchTo().frame(iframe);
		CategoryDesc.clear();
		CategoryDesc.sendKeys(catDescription);	
	}
	public void setSaveBtn() {
		driver.switchTo().defaultContent();
		saveBtn.click();
	}
	
	//**********Search Category***********
	public void setSearchCategoryName(String catName) {
		SearchCategoryName.sendKeys(catName);;
	}
	public void setSearchCategoryButton() {
		SearchCategoryButton.click();
	}
	
	//**********Delete added Category ***********
	public void setDeleteBtn() {
		deleteBtn.click();
	}
	public void setConformYesBtn() {
		conformYesBtn.click();
	}
	
	//**********Export Category List in excel file ***********
	public void setExportDrpBtn() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", exportDrpBtn);
	}
	public void setExportXlsxOption() {
		ExportXlsxOption.click();
	}

	//**********Import Category form Excel file**********
	public void setImportBtn() {
		importBtn.click();
	}
	public void setImportExcelFile(String excelFile) {
		importExcelFile.sendKeys(excelFile);
	}
	public void setimportFromExcelBtn() {
		importFromExcelBtn.click();
	}
}
