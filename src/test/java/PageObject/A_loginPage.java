package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class A_loginPage {

	public WebDriver driver;
	
	public A_loginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="Email") WebElement emailId;
	@FindBy(id="Password") WebElement upass;
	@FindBy(xpath="//button[text()='Log in']") WebElement loginbtn;
	@FindBy(xpath="//a[text()='Logout']") WebElement logOutbtn;
	
	public void setemailId(String eid) {
		emailId.clear();
		emailId.sendKeys(eid);
	}
	public void setPassword(String password) {
		upass.clear();
		upass.sendKeys(password);
	}
	public void setloginbtn() {
		loginbtn.click();
	}
	public void setLogOutbtn() {
		logOutbtn.click();
	}
}
