package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	

	//Constructor declaration
	public HomePage(WebDriver driver){
		super(driver);
	}
	
	//Locators using PageFactory
	@FindBy(xpath = "//span[normalize-space()='My Account']") 
	WebElement myacc;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement register;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement login;
	
	//Action Methods
	
	public void clickMyacc() {
		myacc.click();
	}
	
	public void clickRegister() {
		register.click();
	}
	
	public void clickLogin() {
		login.click();	
		}
}
