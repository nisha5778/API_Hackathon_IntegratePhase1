package Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class RAHExtentReoprts {
	static ExtentReports extentreport;

	public static ExtentReports getExtentReport()
	{
		String extentreportspath=System.getProperty("user.dir")+"\\DSAlgoreports\\extentreport.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(extentreportspath);
		reporter.config().setReportName("DSAlgo test results");
		reporter.config().setDocumentTitle("Test results");
		
		extentreport=new ExtentReports();
		extentreport.attachReporter(reporter);
		extentreport.setSystemInfo("operatingsystem", "windows10");
		extentreport.setSystemInfo("testedby", "Ninjago");
		
		return extentreport;
	}
}
