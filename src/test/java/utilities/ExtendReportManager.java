package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import java.util.Properties;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestNG;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Testbase.BaseClass;


public class ExtendReportManager implements ITestListener
{

	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest test;
	
	String Repname;
	
	
	public void onStart(ITestContext context) {
		
		String ts = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Repname = "Report Name"+ts+".html";
		
		spark = new ExtentSparkReporter(".\\reports\\"+ Repname);
		spark.config().setDocumentTitle("OpenCart Automation Report");
		spark.config().setReportName("opencart Functional Testing");
		spark.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Application", "Opencart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("subModule", "Customer");
		extent.setSystemInfo("User",System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		
		String operatingSystem = context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("os", operatingSystem);
		String browser = context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
		extent.setSystemInfo("Groups", includedGroups.toString());	
		}
		
	}
	
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName()+"got successfully Executed");
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getTestName()+"test case failed");
		test.log(Status.INFO,result.getThrowable().getMessage());
		
		try {
			String img = new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(img);
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getTestName()+"Test case skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}
	
	
	public void onFinish(ITestContext context) {
		extent.flush();
		String pathofExtentReport = System.getProperty("user.dir")+"\\reports\\"+Repname;
		File extentReport = new File(pathofExtentReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		
	}
}
