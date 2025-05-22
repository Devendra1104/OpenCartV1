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
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchBox;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement searcBtn;
	
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
	
	public void searchProduct(String prod_name) {
		searchBox.sendKeys(prod_name);
	}
	
	public void clickSearchBtn() {
		searcBtn.click();
	}
	
}
