package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_loginDDT extends BaseClass {
	
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class,groups= {"Regression","Master"})
	public void testLogin(String id, String pwd, String exp) {
		
		//Working with HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyacc();
		hp.clickLogin();
		
		//Working with login page
		LoginPage lp = new LoginPage(driver);
		lp.enterUserName(id);
		lp.enterPassword(pwd);
		lp.clickLogin();
		
		//Working with MyAccountPage
		MyAccountPage mp = new MyAccountPage(driver);
		boolean msg = mp.confirmMessage();
//		Assert.assertEquals(msg, true);
		
		if(exp.equalsIgnoreCase("valid")) {
			if(msg == true) {
				mp.clickLogout();
				Assert.assertTrue(true);
				
			}
			
			else {
				Assert.assertTrue(false);
			}
			
		}
		
		if(exp.equalsIgnoreCase("invalid")) {
			if(msg == true) {
				mp.clickLogout();
				Assert.assertTrue(false);
			}
			
			else {
				Assert.assertTrue(true);
			}
		}
		
	}

}
