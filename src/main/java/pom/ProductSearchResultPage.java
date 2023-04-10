package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.SwitchToWindow;

public class ProductSearchResultPage {

	@FindBy (xpath = "//div[contains(@class,'grid_Square ')]") private List<WebElement> products;
	@FindBy (xpath = "//span[text()='Quick View']")private List <WebElement> quickView ;
	@FindBy (xpath = "//div[@class='item_title']/descendant::a") private static List <WebElement> productName;
	
	
	public ProductSearchResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void howeringoOnProduct(WebDriver driver, int index) {
		
		WebElement product = products.get(index);
		Actions action = new Actions (driver);
		action.moveToElement(product).perform();
	}
	
	public void clickOnQuickView(int index) {
		WebElement quickview = quickView.get(index);
		quickview.click();
	}
	
	public void clickOnProduct(int index, WebDriver driver, String expectedTitle) {
		WebElement product = products.get(index);
		product.click();
		SwitchToWindow.switchToChildBrowser(driver, expectedTitle);
	}
	
	public int getNumberOfProductDisplayed () {
		int size = products.size();
		return size;	
	}
	
	public String getProductName (int index) {
		
		WebElement handle = productName.get(index);
		String title = handle.getText();
		return title;																	
	}

	
}
