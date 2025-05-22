package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductsPage;
import testBase.BaseClass;

public class TC_004_SearchProduct extends BaseClass {

	@Test(groups = {"Sanity"})
	public void searchProduct() {
		
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
}
