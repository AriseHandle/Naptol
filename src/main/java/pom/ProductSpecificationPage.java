package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSpecificationPage {

	@FindBy (xpath = "//div[contains(@class,'grid_Square')]")private List <WebElement> products ;
	@FindBy (xpath = "//span[text()='Click here to Buy']")private WebElement clickHereToBuyButton ;
	@FindBy (xpath = "//input[@placeholder='Enter Pincode']")private WebElement pincodeField ;
	@FindBy (linkText = "Add in Wishlist ")private WebElement addToWhishlist  ;
	@FindBy (xpath = "//span[text()=' Check ']")private WebElement checkPincodeButton ;
	@FindBy (xpath = "//div[@id='main_image']") private WebElement productFrame;
	@FindBy (xpath = "//a[@title='Close']")private WebElement  close;
	@FindBy (xpath = "//a[text()='More Sellers']")private WebElement moreSellers ;
	@FindBy (xpath = "(//a[text()=' « Continue Shopping '])[1]")private WebElement continueShopping;
	
	public ProductSpecificationPage (WebDriver driver) {
		PageFactory.initElements(driver,this);	
	}
	
	public void enteringPincode (String pincode) {
		pincodeField.sendKeys(pincode);
	}
	
	public void clickOnCheckPincode () {
		checkPincodeButton.click();
	}
	public void clickOnClickToBuy () {
		clickHereToBuyButton.click();
	}
	
	public void addToWishlist () {
		addToWhishlist.click();
	}
	
	public void checkIfProductIsDisplayed () {	
	boolean display = productFrame.isDisplayed();
	System.out.println(display);
		
	}
	public void clickOnContinueShopping () {
		continueShopping.click();
	}
	
	
}
