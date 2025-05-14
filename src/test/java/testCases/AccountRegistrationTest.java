package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class AccountRegistrationTest extends BaseClass{
	

	@Test(groups= {"Sanity"})
	public void testAccountRegistration() {
		
		logger.info("***********Test case started*************");
		//Interacting with Home Page elements
		
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyacc();
		
		logger.info("*******Here we clicked on myaccount link");
		hp.clickRegister();
		logger.info("*******Here we clicked on register link");
		
		//Interacting with Registration Page
		
		logger.info("********Providing customer details***************");
		RegistrationPage rp = new RegistrationPage(driver);
		rp.enterFirstName("John");
		rp.enterLastName("Doe");
		rp.enterEmail("johndoe11232@gmail.com");
		rp.enterTelephone("46516846");
		rp.enterPassword("test@123");
		rp.confirmPassword("test@123");
		rp.subsNewsLetter();
		rp.checkTerms();
		rp.confirmDetails();
		String message = rp.confirmMessage();
		
		logger.info("**********Validating the account creation message.");
		
		if(message.equals("Your Account Has Been Created!")) {
			Assert.assertEquals(true, true);
		}
		
		else {
			logger.error("**************Validation failed**************");
			logger.debug("************Test case failed, please debug the logs**************");
			Assert.assertEquals(true, false);
		}
//		Assert.assertEquals(message, "Your Account Has Been Created!");
		
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("**********Test case execution finished***********");
	}
	

}
