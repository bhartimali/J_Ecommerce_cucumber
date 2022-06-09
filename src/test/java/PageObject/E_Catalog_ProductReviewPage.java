package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class E_Catalog_ProductReviewPage {

	public WebDriver driver;
	
	public E_Catalog_ProductReviewPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Object
	
	//****Search product review by name*******
	@FindBy(xpath="//a[@href='/Admin/ProductReview/List']")private WebElement productReviewMenu;
	@FindBy(id="search-product-name")private WebElement searchProductName;
	@FindBy(id="search-productreviews")private WebElement searchBtn;
	
	
	//****Update product review Info*******
	@FindBy(xpath="//a[text()='HTC One Mini Blue']/parent::td/following-sibling::td/child::a[@href='Edit/12']") private WebElement productReviewEditBtn;
	@FindBy(id="ReviewText")private WebElement reviewText;
	@FindBy(name="save")private WebElement saveBtn;
	
	//****Approve and disapproved Selected product Review*******
	@FindBy(xpath="//a[text()='HTC One Mini Blue']/parent::td/preceding-sibling::td/child::input") private WebElement productReviewChkbox;
	@FindBy(id="approve-selected")private WebElement approveSelectedBtn;
	@FindBy(id="disapprove-selected")private WebElement disapproveSelectedBtn;
	@FindBy(id="delete-selected")private WebElement deleteSelectedBtn;
	@FindBy(id="delete-selected-action-confirmation-submit-button") private WebElement conformDeleteYESBtn;
	
	//Methods
	
	//****Search product review by name*******
	public void setProductReviewMenu() {
		productReviewMenu.click();
	}
	public void setSearchProductName(String pname) throws InterruptedException {
		searchProductName.sendKeys(pname);
		Thread.sleep(2000);
		List<WebElement> autoSuggest = driver.findElements(By.id("ui-id-1"));
		for(WebElement a:autoSuggest) {
			if(a.getText().equalsIgnoreCase("Apple MacBook Pro 13-inch")) {
				Thread.sleep(2000);
				a.click();
				Thread.sleep(2000);
				break;
			}
				
		}
	}
	public void setsearchBtn() {
		searchBtn.click();
	}
	
	//****Update product review Info*******
	public void setProductReviewEditBtn() {
		productReviewEditBtn.click();
	}
	public void setReviewText(String reviewTxt) {
		reviewText.sendKeys(reviewTxt);
	}
	public void setSaveBtn() {
		saveBtn.click();
	}
	
	//****Approve and disapproved Selected product Review*******
	public void setProductReviewChkbox() {
		productReviewChkbox.click();
	}
	public void setApproveSelectedBtn() {
		approveSelectedBtn.click();
	}
	public void setDisapproveSelectedBtn() {
		disapproveSelectedBtn.click();
	}
	
	//****Delete product review *******
	public void deleteProductReview(String productName) {
		WebElement productReviewName = driver.findElement(By.xpath("//a[text()='"+productName+"']/parent::td/preceding-sibling::td/child::input"));
		productReviewName.click();
	}
	public void setDeleteSelectedBtn() {
		deleteSelectedBtn.click();
	}
	public void setConformDeleteYESBtn() {
		conformDeleteYESBtn.click();
	}
	
}
