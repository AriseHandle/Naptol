package utility;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class SwitchToWindow {

	public static void switchToChildBrowser(WebDriver driver,String expectedTitle) {
		
		Set<String> handles =driver.getWindowHandles();
		
		Iterator<String> i= handles.iterator();
		
		while(i.hasNext())
		{
			String handle =i.next();
			driver.switchTo().window(handle);
			String currentTitle =driver.getTitle();
			
			if(currentTitle.contains(expectedTitle))
			{
				break;
			}
			
		}
		
	}
	
}
