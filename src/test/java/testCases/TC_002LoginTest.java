package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_002LoginTest extends BaseClass{

	@Test(groups= {"Sanity","Master"})
	public void testLogin() {
		
		//Working with HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyacc();
		hp.clickLogin();
		
		//Working with login page
		LoginPage lp = new LoginPage(driver);
		lp.enterUserName(propObj.getProperty("id"));
		lp.enterPassword(propObj.getProperty("pass"));
		lp.clickLogin();
		
		//Working with MyAccountPage
		MyAccountPage mp = new MyAccountPage(driver);
		boolean msg = mp.confirmMessage();
		Assert.assertEquals(msg, true);
		
	}
}
