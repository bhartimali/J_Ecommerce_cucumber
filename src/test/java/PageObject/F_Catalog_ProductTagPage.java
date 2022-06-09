package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class F_Catalog_ProductTagPage {

public WebDriver driver;
	
	public F_Catalog_ProductTagPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//*****Search product tag by tag name*****
	@FindBy(xpath="//a[@href='/Admin/Product/ProductTags']") private WebElement productTagMenu;
	@FindBy(id="SearchTagName") private WebElement searchTagName;
	@FindBy(id="search-product-tags") private WebElement searchTagBtn;
	
	//*****Update product tag name*****
	@FindBy(xpath="//td[text()='awesome']/following-sibling::td/child::a") private WebElement tagEditBtn;
	@FindBy(xpath="//input[@id='Name']") private WebElement tagName;
	@FindBy(name="save") private WebElement tagSaveBtn;
	
	//*****Delete selected product tag name*****
	@FindBy(id="delete-selected") private WebElement deleteTagBtn;
	@FindBy(xpath = "//button[normalize-space(text()) = 'Yes']")private WebElement conformYesBtn;
	
	//*****Search product tag by tag name*****
	public void setProductTagMenu() {
		productTagMenu.click();
	}
	public void setSearchTagName(String tagName) {
		searchTagName.sendKeys(tagName);
	}
	public void setSearchTagBtn() {
		searchTagBtn.click();
	}
	
	//*****Update product tag name*****
	public void setTagEditBtn() {
		tagEditBtn.click();
	}
	public void setTagName(String tName) {
		tagName.clear();
		tagName.sendKeys(tName);;
	}
	public void setTagSaveBtn() {
		tagSaveBtn.click();
	}
	
	//*****Delete selected product tag name*****
	public void setDeleteTagchkBox(String tagName) {
		WebElement chkbox = driver.findElement(By.xpath("//td[text()='"+tagName+"']/preceding-sibling::td/child::input"));
		chkbox.click();
	}
	public void setDeleteTagBtn() {
		deleteTagBtn.click();
	}
	public void setConformTagYesBtn() {
		conformYesBtn.click();
	}
	
}
