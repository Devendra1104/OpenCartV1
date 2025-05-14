package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
	
	//Constructor declaration
	public RegistrationPage(WebDriver driver){
			super(driver);
		}
	
	//Locators
	@FindBy(xpath = "//input[@id='input-firstname']") 
	WebElement txtFirstName;
	
	@FindBy(xpath = "//input[@id='input-lastname']") 
	WebElement txtLastName;
	
	@FindBy(xpath = "//input[@id='input-email']") 
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='input-telephone']") 
	WebElement txtTelephone;
	
	@FindBy(xpath = "//input[@id='input-password']") 
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@id='input-confirm']") 
	WebElement txtConfirmPass;
	
	@FindBy(xpath = "//input[@value='0']") 
	WebElement radioNewLet;
	
	@FindBy(xpath = "//input[@name='agree']") 
	WebElement checkTerms;
	
	@FindBy(xpath = "//input[@value='Continue']") 
	WebElement buttonContinue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']") 
	WebElement msgConfirm;
	
	//Action Methods
	
	public void enterFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}
	
	public void enterLastName(String lname) {
		txtLastName.sendKeys(lname);
	}
	
	public void enterEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void enterTelephone(String telephone) {
		txtTelephone.sendKeys(telephone);
	}
	
	public void enterPassword(String pass) {
		txtPassword.sendKeys(pass);
	}
	
	public void confirmPassword(String cPassword) {
		txtConfirmPass.sendKeys(cPassword);
	}
	
	public void subsNewsLetter() {
		radioNewLet.click();
	}
	
	public void checkTerms() {
		checkTerms.click();
	}
	
	public void confirmDetails() {
		buttonContinue.click();
	}
	
	public String confirmMessage() {
		try {
			return(msgConfirm.getText());
		}
		catch(Exception e) {
			return(e.getMessage());
		}
		
	}
	
	
	

}
