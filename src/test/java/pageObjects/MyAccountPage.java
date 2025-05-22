package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MyAccountPage extends BasePage {

	//Constructor
	public MyAccountPage(WebDriver driver){
		super(driver);
	}
	
	//Locators
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement confMsg;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement btnLogout;
	
	//Actions
	public boolean confirmMessage() {
		try {
		return (confMsg.isDisplayed());
		}
		catch(Exception e) {
			System.out.println("Message not displayed");
			return false;
		}
	}
	
	public void clickLogout() {
		btnLogout.click();	
	}
	
}
