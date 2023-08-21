package API.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	public void onStart(ITestContext testContext) {
		
		String timeStamp =new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName="Test-report-"+timeStamp+".html";
		
		sparkReporter= new ExtentSparkReporter(".\\Reports\\"+repName); // specify location of the report
		
		sparkReporter.config().setDocumentTitle("RestAssuredAutomationProject"); //Title of report
		sparkReporter.config().setReportName("API Test"); // name of report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent= new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "API Test");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name",System.getProperty("user.name"));
		extent.setSystemInfo("Enviorment", "QA");
		extent.setSystemInfo("user", "Abrar");
	
		
	}
	
	public void onTestSuccess(ITestResult result) {
		
		test= extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.PASS, "Test Passed");
	
	}
	
   public void onTestfailures(ITestResult result) {
		
		test= extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
	
	}
	
   public void onTestSkip(ITestResult result) {
		
		test= extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	
	}
	
   public void onTestFinish(ITestResult result) {
   
   extent.flush();
   }
   
}
