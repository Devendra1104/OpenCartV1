package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductsPage;
import testBase.BaseClass;

public class TC_004_SearchProduct extends BaseClass {

	@Test(priority = 1,groups = {"Sanity"})
	public void searchValidProduct() {
		
		HomePage hp = new HomePage(driver);
		hp.searchProduct("imac");
		hp.clickSearchBtn();
		
		
		ProductsPage pd = new ProductsPage(driver);
		boolean prod = pd.prodConfirm();
		
		if(prod == true) {
			Assert.assertEquals(true, true);
		}
		
		else {
			Assert.assertEquals(true, false);
		}
		
	}
	
	@Test(priority = 2, groups = {"Sanity"})
	public void searchInvalidProduct() {
		
		HomePage hp = new HomePage(driver);
		hp.searchProduct("fitbit");
		hp.clickSearchBtn();
		
		ProductsPage pd = new ProductsPage(driver);
		Assert.assertEquals(pd.invalidProdMsg(), "There is no product that matches the search criteria.");
		
	}
	
	@Test(priority = 3, groups = {"Sanity"})
	public void searchBlankProduct() {
		
		HomePage hp = new HomePage(driver);
		hp.searchProduct(" ");
		hp.clickSearchBtn();
		
		ProductsPage pd = new ProductsPage(driver);
		Assert.assertEquals(pd.invalidProdMsg(), "There is no product that matches the search criteria.");
		
	}
}
