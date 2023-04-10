package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	
	@FindBy(xpath="//ul[@id='cartData']")private List<WebElement> cartItems;
	@FindBy(xpath="(//a[@class='red_button2'])[1]")private WebElement proceedToCheckout;
	@FindBy(xpath="(//a[text()=' « Continue Shopping '])[1]")private WebElement continueShopping;
	@FindBy(xpath="//li[@class='head_qty']") private List <WebElement> quantity;
	@FindBy(xpath="//li[@class='head_UPrice']")private List<WebElement> unitPrice;
	@FindBy(xpath="//li[@class='head_ship']")private List<WebElement> shippingPrice;
	@FindBy(xpath="//li[@class='head_Amount']")private List<WebElement> orderAmount;
	@FindBy(xpath="(//div//label)[1]")private WebElement cartAmount;
	@FindBy(xpath="(//div//label)[2]")private WebElement giftVoucherDiscount;
	@FindBy(xpath="(//div//label)[3]") private WebElement totalAmount;
	@FindBy(xpath="//a[text()='Remove']")private List<WebElement> remove;
	@FindBy(xpath ="//a[@title='Close']")private WebElement close;
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public int getNumerOfItemsInCart() {
	    return	cartItems.size();	
	}
	
	public String getProductQuantity(int index) {
		return quantity.get(index).getText();
	}
	
	public double getProductUnitPrice(int index) {
		String price = unitPrice.get(index).getText();
		return Double.parseDouble(price.substring(3));
	}

	public double getShppingPrice(int index) {
		String price =shippingPrice.get(index).getText();
		return Double.parseDouble(price.substring(3));
	}
	
	public double getCartAmount() {
		String price =cartAmount.getText();
		return Double.parseDouble(price.substring(3));
	}
	
	public double getGiftVoucherDiscount() {
		String price = giftVoucherDiscount.getText();
		return Double.parseDouble(price.substring(3));
	}
	
	public double getTotalCartAmount() {
		String price = totalAmount.getText();
		return Double.parseDouble(price.substring(3));
	}
	
	public void clickOnContinueShopping() {
		continueShopping.click();
	}
	
	public void clickOnProceedToCheckout() {
		proceedToCheckout.click();
	}
	
	public void removeItemFromCart(int index) {
		remove.get(index).click();
	}
	
	public void waitForCloseToBeDisplayed(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(close));
	}
	
	public double getOrderAmount(int index ) {
		String price =orderAmount.get(index).getText();
		return Double.parseDouble(price.substring(2));
	}
	
	public double getTotalOrderAmount() {
		double total = 0;
		for(int i =0; i< orderAmount.size(); i++)
		{
			total = getOrderAmount(i)+total;
		}
		total = total - getGiftVoucherDiscount();
		return total;
		
	}
}
