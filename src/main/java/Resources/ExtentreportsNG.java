package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentreportsNG {
	static ExtentReports Extent;
	public static ExtentReports getReportObject() {
		
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Testing");
		reporter.config().setDocumentTitle("Test Results");
		Extent = new ExtentReports();
		Extent.attachReporter(reporter);
		Extent.setSystemInfo("Tester", "Yuvaraj Srinivasan");
		return Extent;
		
	}
	

}
