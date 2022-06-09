package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class B_Catalog_ProductPage {

	public WebDriver driver;
	
	public B_Catalog_ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Add new Product Objects
	@FindBy(xpath="//a/child::p[normalize-space(text()) = 'Catalog']")private WebElement catalogMenu;
	@FindBy(xpath="//p[normalize-space(text()) = 'Products']")private WebElement productLink;
	@FindBy(xpath="//a[@href='/Admin/Product/Create']") private WebElement addNewProductBtn;
	@FindBy(id="Name") private WebElement productName;
	@FindBy(id="ShortDescription") private WebElement shortDescription;
	@FindBy(xpath="//div[@role='listbox']") private WebElement category;
	@FindBy(xpath="//*[@id=\"product-price-area\"]/div[2]/span[1]/span/input[1]") private WebElement productPrice;
	@FindBy(name="save") private WebElement saveBtn;
	
	//Search product Objects
	@FindBy(id="SearchProductName") private WebElement searchProductName;
	@FindBy(id="search-products") private WebElement searchBtn;
	
	//Update Product information
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Edit')]") private WebElement editBtn;
	
	//Delete selected Product
	@FindBy(xpath="//input[@name='checkbox_products']")private WebElement CheckBoxBtn;
	@FindBy(id="delete-selected")private WebElement deleteBtn;
	@FindBy(xpath="//button[normalize-space(text()) = 'Yes']")private WebElement conformYesBtn;
	
	//Download Catalog as PDF 
	@FindBy(xpath="//input[@value='1']") private WebElement downloadCatalogProduct;
	@FindBy(xpath="//button[@name='download-catalog-pdf']") private WebElement downloadCatalog;
	
	//Export Selected Product
	@FindBy(xpath="//button[@data-toggle='dropdown']") private WebElement exportProductBtn;
	@FindBy(xpath="//button[@id='exportexcel-selected']") private WebElement exportExcelOption;
	
	//*****************METHODS*************
	//Add new Product
	public void setCatalogMenu() {
		catalogMenu.click();
	}
	public void setProductSubItem() {
		productLink.click();
	}
	public void setAddNewProductBtn() {
		addNewProductBtn.click();
	}
	public void setProductName(String pname) {
		productName.sendKeys(pname);
	}
	public void setShortDescription(String shortDes) {
		shortDescription.sendKeys(shortDes);
	}
	public void setCategory() throws InterruptedException {
		category.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='Computers >> Desktops']")).click();
		Thread.sleep(2000);
	}
	public void setPrice(String price) {
		//productPrice.clear();
		productPrice.sendKeys(price);
	}
	public void setSaveBtn() {
		saveBtn.click();
	}
	
	//Search product Methods
	public void setSearchProductName(String pname) {
		searchProductName.sendKeys(pname);
	}
	public void setSearchBtn() {
		searchBtn.click();
	}
	
	//Update Product information
	public void setEditBtn() {
		editBtn.click();
	}
	//Delete selected product
	public void setCheckBoxBtn() {
		CheckBoxBtn.click();
	}
	public void setdeleteBtn() {
		deleteBtn.click();
	}
	public void setConformYesBtn() {
		conformYesBtn.click();
	}
	
	//Download Catalog as PDF downloadCatalogProduct
	
	public void setDownloadCatalogProduct() {
		downloadCatalogProduct.click();
	}
	public void setDownloadCatalog() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", downloadCatalog);
		
	}
	
	//Export Selected Product
	public void setExportProductBtn() {
		exportProductBtn.click();
	}
	public void SetExportExcelOption() {
		exportExcelOption.click();
	}
	
}
