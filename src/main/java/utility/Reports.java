package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

	public static ExtentReports createReports() {
		
		ExtentSparkReporter htmlReports = new ExtentSparkReporter("NaptolTestResult.html");
		ExtentReports reports = new ExtentReports();
		reports.attachReporter(htmlReports);
		reports.setSystemInfo("TestedBy", "Subodh Patil");
		reports.setSystemInfo("TestType", "Regression");
		return reports;

	}
	
}
