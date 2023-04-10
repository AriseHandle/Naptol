package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaptolHomePage {
	@FindBy (xpath = "//a[text()='Log In / Register']") private WebElement loginOrRegister;
	
	@FindBy (xpath = "//a[text()='Track Order']") private WebElement trackOrder;
	
	@FindBy (xpath = "//div[@class='cate_head']") private WebElement categories;
	
	@FindBy (xpath = "//input[@name='header_search_text']") private WebElement searchField;
	
	@FindBy (xpath = "(//a[@href='javascript:autoSuggestion.headerSearch()'])[2]") private WebElement searchButton;
	
	@FindBy (xpath = "(//a[@id='cart-panel-link'])[2]") private WebElement cart;
	
	
	public NaptolHomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLogin() {
		
		loginOrRegister.click();
	}
	
	public void clickOnTrackOrder() {
		trackOrder.click();
	}
	
	public void mouseHoverOnShoppingCategories(WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveToElement(categories);
	}
	
	public void enterProductToBeSearch(String product) {
		searchField.sendKeys(product);
	}
	
	public void clickOnSearchbutton() {
		searchButton.click();
	}
	
	public void clickOnCart() {
		cart.click();
	}
}
