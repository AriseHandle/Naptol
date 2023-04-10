package test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.CartPage;
import pom.NaptolHomePage;
import pom.ProductSearchResultPage;
import pom.ProductSpecificationPage;
import utility.Reports;


@Listeners(test.Listeners.class)
public class CartTest extends BaseTest {
	
	ExtentReports reports;
	ExtentTest test;
	
	
	@BeforeTest
	public void setUpReports() {
	 reports =Reports.createReports();
	}
	
	
	@BeforeMethod
	public void launchBrowser() {
		driver =Browser.launchBrowser("Chrome");
	}
	
	
	@Test
	public void verifyCustomerIsAbleToAddProductToCart() {
		test =reports.createTest("verifyCustomerIsAbleToAddProductToCart()");
		NaptolHomePage naptolHomePage = new NaptolHomePage(driver);
		naptolHomePage.enterProductToBeSearch("cooker");
		naptolHomePage.clickOnSearchbutton();
		
		ProductSearchResultPage productSearchResultPage = new ProductSearchResultPage(driver);
		String productName =productSearchResultPage.getProductName(0);
		productSearchResultPage.clickOnProduct(0, driver, productName);
		
		ProductSpecificationPage productSpecificationPage = new ProductSpecificationPage(driver);
		productSpecificationPage.clickOnClickToBuy();
		
		CartPage cartPage =new CartPage(driver);
		cartPage.waitForCloseToBeDisplayed(driver);
		int numberOfCartItems =cartPage.getNumerOfItemsInCart();
		Assert.assertTrue(numberOfCartItems == 1);	
		Assert.assertEquals(cartPage.getTotalOrderAmount(), cartPage.getTotalCartAmount());
	}
	
	@Test
	public void verifyIfCutomerIsAbleToRemoveProductFromCart() {
		test =reports.createTest("verifyIfCutomerIsAbleToRemoveProductFromCart");
		NaptolHomePage naptolHomePage = new NaptolHomePage(driver);
		naptolHomePage.enterProductToBeSearch("cooker");
		naptolHomePage.clickOnSearchbutton();
		
		ProductSearchResultPage productSearchResultPage = new ProductSearchResultPage(driver);
		String productName =productSearchResultPage.getProductName(0);
		productSearchResultPage.clickOnProduct(0, driver, productName);
		
		ProductSpecificationPage productSpecificationPage = new ProductSpecificationPage(driver);
		productSpecificationPage.clickOnClickToBuy();
		
		CartPage cartPage =new CartPage(driver);
		cartPage.waitForCloseToBeDisplayed(driver);
		int numberOfCartItems =cartPage.getNumerOfItemsInCart();
		cartPage.removeItemFromCart(0);
		int numberOfItemsPostRemove =cartPage.getNumerOfItemsInCart();
		Assert.assertTrue(numberOfItemsPostRemove==1);
		Assert.assertNotEquals(numberOfCartItems,numberOfItemsPostRemove);
		
		
	}
	
	@Test
	public void verifyIfCustomerIsAbletoAddProductToCartUsingQuickView() {
		test =reports.createTest("verifyIfCustomerIsAbletoAddProductToCartUsingQuickView");
		NaptolHomePage naptolHomePage = new NaptolHomePage(driver);
		naptolHomePage.enterProductToBeSearch("cooker");
		naptolHomePage.clickOnSearchbutton();
		
		ProductSearchResultPage productSearchResultPage = new ProductSearchResultPage(driver);
		productSearchResultPage.howeringoOnProduct(driver, 1);
		productSearchResultPage.clickOnQuickView(1);
		
	}
	
	@AfterMethod
	public void getTestResult(ITestResult result) {
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName());
		}
		else if (result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, result.getName());
		}
		else if (result.getStatus()== ITestResult.SKIP)
		{
			test.log(Status.SKIP, result.getName());
		}
	}
	
	@AfterTest
	public void publishReports() {
		reports.flush();
	}
	
	
}
