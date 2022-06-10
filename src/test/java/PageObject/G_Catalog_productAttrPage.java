package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class G_Catalog_productAttrPage {

public WebDriver driver;
	
	public G_Catalog_productAttrPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a/child::p[normalize-space(text()) = 'Attributes']")private WebElement attributesMenu;
	@FindBy(xpath="//p[normalize-space(text()) = 'Product attributes']")private WebElement productAttrMenu;
	@FindBy(xpath="//a[@href='/Admin/ProductAttribute/Create']") private WebElement addProductAttrBtn;
	@FindBy(id="Name")private WebElement attributeName;
	@FindBy(name="save")private WebElement attriSaveBtn;
	
	@FindBy(xpath="//iframe[@id='Description_ifr']") private WebElement iframe;
	@FindBy(xpath="//body[@data-id='Description']/child::p")private WebElement attributeDesc;
	
	@FindBy(id="delete-selected") private WebElement deleteAttrBtn;
	@FindBy(xpath="//button[normalize-space(text()) = 'Yes']")private WebElement conformYesBtn;
	
	public void setAttributeMenu() {
		attributesMenu.click();
	}
	public void setProductAttrMenu() {
		productAttrMenu.click();
	}
	public void setAddProductAttrBtn() {
		addProductAttrBtn.click();
	}
	public void setAttributeName(String attrName) {
		attributeName.sendKeys(attrName);
	}
	public void setAttriSaveBtn() {
		driver.switchTo().defaultContent();
		attriSaveBtn.click();
	}
	public void setAttributeDesc(String attrDesc) {
		driver.switchTo().frame(iframe);
		attributeDesc.sendKeys(attrDesc);
	}
	public void setDeleteAttrBtn() {
		deleteAttrBtn.click();
	}
	public void setConformYesBtn() {
		conformYesBtn.click();
	}
}
