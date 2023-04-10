package test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.NaptolHomePage;
import pom.ProductSearchResultPage;
import utility.Reports;

@Listeners(test.Listeners.class)
public class VerifySearchWithExistingProduct extends BaseTest {
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void setUpReports() {
	 reports =Reports.createReports();
	}
	
	@BeforeMethod
	@Parameters({"browser"})
	public void launchBrowser(String browser) {
		driver =Browser.launchBrowser(browser);
	}
	
	@Test
	public void verifySearchWithExistingProductTest() {
		test =reports.createTest("verifySearchWithExistingProductTest");
		NaptolHomePage naptolHomePage = new NaptolHomePage(driver);
		naptolHomePage.enterProductToBeSearch("cooker");
		naptolHomePage.clickOnSearchbutton();
		
		ProductSearchResultPage productSearchResultPage = new ProductSearchResultPage(driver);
		int products =productSearchResultPage.getNumberOfProductDisplayed();
		Assert.assertTrue(products > 0);

	}
	
	@Test
	public void verifySearchWithNonExistingProductTest() {
		test = reports.createTest("verifySearchWithNonExistingProductTest");
		NaptolHomePage naptolHomePage = new NaptolHomePage(driver);
		naptolHomePage.enterProductToBeSearch("iphone");
		naptolHomePage.clickOnSearchbutton();
		
		ProductSearchResultPage productSearchResultPage = new ProductSearchResultPage(driver);
		int products =productSearchResultPage.getNumberOfProductDisplayed();
		Assert.assertTrue(products==0);
		
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
