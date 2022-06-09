package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class D_Catalog_ManufacturePage {

	public WebDriver driver;

	public D_Catalog_ManufacturePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// OBJECTS

	// ********Add new Menufactures*********
	@FindBy(xpath = "//a[@href='/Admin/Manufacturer/List']")private WebElement menufacturesMenu;
	@FindBy(xpath = "//a[@href='/Admin/Manufacturer/Create']")private WebElement addNewMenufactureBtn;
	@FindBy(id = "Name")private WebElement menufactureName;
	@FindBy(name = "save")private WebElement saveBtn;

	// ********Search Menufactures Name**********
	@FindBy(xpath = "//input[@id='SearchManufacturerName']")private WebElement searchManufacturerName;
	@FindBy(xpath = "//button[@id='search-manufacturers']")private WebElement searchManufactureBtn;
	
	//********Update Menufactures**********
	@FindBy(xpath="//body[@data-id='Description']/child::p")private WebElement manufactureDesc;
	
	// **********Delete added Category ***********
	@FindBy(id = "delete-selected")private WebElement deleteBtn;
	@FindBy(xpath = "//button[normalize-space(text()) = 'Yes']")private WebElement conformYesBtn;

	//**********Export Category List in excel file ***********
	@FindBy(xpath="//button[@data-toggle='dropdown']") private WebElement exportDrpBtn;
	@FindBy(xpath="//a[@href='/Admin/Manufacturer/ExportXlsx']") private WebElement ExportXlsxOption;
	
	//**********Import Category form Excel file**********
	@FindBy(name="importexcel")private WebElement importBtn;
	@FindBy(id="importexcelfile")private WebElement importExcelFile;
	@FindBy(xpath="//button[normalize-space(text())= 'Import from Excel']")private WebElement importFromExcelBtn;
	
	// METHODS

	// ********Add new Menufactures**********
	public void setMenufacturesMenu() {
		menufacturesMenu.click();
	}

	public void setAddNewMenufactureBtn() {
		addNewMenufactureBtn.click();
	}

	public void setMenufactureName(String mName) {
		menufactureName.clear();
		menufactureName.sendKeys(mName);
	}

	public void setSaveBtn() {
		saveBtn.click();
	}

	// ********Search Menufactures Name**********
	public void setsearchManufacturerName(String sMName) {
		searchManufacturerName.sendKeys(sMName);
	}

	public void setSearchManufactureBtn() {
		searchManufactureBtn.click();
	}
	
	// ********Update Menufactures Name**********
	public void setManufactureDesc(String MDesc) {
		manufactureDesc.sendKeys(MDesc);
	}
	
	// **********Delete added Category ***********
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
