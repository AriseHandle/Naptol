package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {

	public static void takescreenShot(WebDriver driver,String name) throws IOException {
		String dateAndTime =DateAndTime.getDateAndTime();
		
		File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File destination = new File("C:\\Users\\91877\\OneDrive\\Documents\\AutomationMorning\\Naptool\\Screenshot\\"+name+dateAndTime+".png");
		
		FileHandler.copy(source, destination);
	}
	
}
