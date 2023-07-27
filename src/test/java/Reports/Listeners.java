package Reports;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners {
	WebDriver driver=null;
	ExtentReports extentreport=RAHExtentReoprts.getExtentReport();
	ExtentTest extenttest;
	ThreadLocal<ExtentTest> extenttestthread=new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult tr)
	{
		String testname=tr.getName();
		extenttest=extentreport.createTest(testname+"executon stareted");
		extenttestthread.set(extenttest);
		System.out.println("hi");
		
	}
	public void onTestSuccess(ITestResult tr)
	{
		extenttest.log(Status.PASS,"test passed");
		extenttest.pass(tr.getThrowable());
		String testName=tr.getName();
		try
		{
			driver=(WebDriver)tr.getTestClass().getRealClass().getDeclaredField("driver").get(tr.getInstance());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		try
		{
			takescreenshot(testName,driver);
		}
	    catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	//extenttestthread.get(extenttest.log(Status.PASS,"test passed");
		
	}
	
	private void takescreenshot(String testName, WebDriver driver2) {
		// TODO Auto-generated method stub
		
	}
	public void onFinish(ITestContext context)
	{
	extentreport.flush();
	}
}
