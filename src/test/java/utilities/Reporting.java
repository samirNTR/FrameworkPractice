package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testClasses.baseClass;

public class Reporting extends baseClass implements ITestListener {

	ExtentSparkReporter htmlReporter;// user interface/ look & feel of the report
	ExtentReports reports;// common information
	ExtentTest test;// entries for test

	public void configureReport() {

		String timestamp = new SimpleDateFormat("yyyy.dd.MM.HH.mm.ss").format(new Date()); // TIME STAMP
		String reportName = "SauceLabs-Report-" + timestamp + ".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add system information/environment info to reports
		reports.setSystemInfo("Machine:", "testpc1");
		reports.setSystemInfo("OS", "windows 11");
		reports.setSystemInfo("user name:", "Samir");

		// configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
		htmlReporter.config().setReportName("This is my First Report");
		htmlReporter.config().setTheme(Theme.DARK);

	}

	// OnStart method is called when any Test starts.
	public void onStart(ITestContext Result) {
		System.out.println("On Start method invoked....");
		configureReport();
	
	}

	// onFinish method is called after all Tests are executed
	public void onFinish(ITestContext Result) {
		System.out.println("On Finished method invoked....");
		reports.flush();// it is mandatory to call flush method to ensure information is written to the
						// started reporter.

	}

	public void onTestSuccess(ITestResult Result) {
		System.out.println("Name of test method sucessfully executed:" + Result.getName());

		test = reports.createTest(Result.getName());

		test.log(Status.PASS,
				MarkupHelper.createLabel("Name of the passed test case is: " + Result.getName(), ExtentColor.GREEN));
	}

	// When Test case get failed, this method is called.

	public void onTestFailure(ITestResult Result) 
	{
		
		System.out.println("Name of test method failed:" + Result.getName());
		test = reports.createTest(Result.getName());// create entry in html report
		test.log(Status.FAIL,
				MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName(), ExtentColor.RED));

		
		 TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
		 File screenshotFile = screenshotDriver.getScreenshotAs(OutputType.FILE);
		
		 String screenshotDirPath = System.getProperty("user.dir") + File.separator + "Screenshots";
		 
		 // Create the Screenshots directory if it doesn't exist
	        File screenshotDir = new File(screenshotDirPath);
	        if (!screenshotDir.exists()) {
	            screenshotDir.mkdir();
	        }

	        // Define the path for the screenshot file
	        String screenShotPath = screenshotDirPath + File.separator + Result.getName() + ".jpg";

	        try {
	            // Copying the screenshot file to the specified location
	            FileUtils.copyFile(screenshotFile, new File(screenShotPath));

	            // Adding screenshot to the Extent Report
	            test.fail("Captured Screenshot is below:" + test.addScreenCaptureFromPath(screenShotPath));

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
		

		// test.addScreenCaptureFromPath(null)

	

	// When Test case get Skipped, this method is called.

	public void onTestSkipped(ITestResult Result) {
		System.out.println("Name of test method skipped:" + Result.getName());

	
		test = reports.createTest(Result.getName());
		test.log(Status.SKIP,
				MarkupHelper.createLabel("Name of the skip test case is: " + Result.getName(), ExtentColor.YELLOW));
	}

	// When Test case get Started, this method is called.

	public void onTestStart(ITestResult Result) {
		System.out.println("Name of test method started:" + Result.getName());

	}

	// When Test case get passed, this method is called.

	/*
	 * public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
	 * 
	 * }
	 */

}
