package utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTime {

	public static String getDateAndTime(){
		
		LocalDateTime date =LocalDateTime.now();
		DateTimeFormatter pattern=DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
		String dateAndTime =date.format(pattern);
		return dateAndTime;
		
	}
}
