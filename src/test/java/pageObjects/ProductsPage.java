package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

	//Constructor declaration
	public ProductsPage(WebDriver driver){
		super(driver);
	}
	
	//Locators
	@FindBy(xpath = "//a[normalize-space()='iMac']")
	WebElement imacLink;
	
	@FindBy(xpath="//p[contains(text(),'There is no product that matches the search criter')]")
	WebElement searchMsg;
	
	//ActionMethods
	
	public boolean prodConfirm() {
		try {
			boolean prodVisible = imacLink.isDisplayed();
			return prodVisible;
		}
		
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public String invalidProdMsg() {
		return searchMsg.getText();
	}
}
