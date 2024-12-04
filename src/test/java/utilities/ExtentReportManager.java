package utilities;

import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testcases.Random_details;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter spartReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String repname;

	public void onStart(ITestContext textcontext) {

		/*
		 * SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss"); Date dt =
		 * new Date(); String currentdatetimestamp = df.format(dt);
		 */

		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repname = "Test-Report-" + timestamp + ".html";
		spartReporter = new ExtentSparkReporter(".\\reports\\" + repname);

		spartReporter.config().setDocumentTitle("Opencart Automation Report");
		spartReporter.config().setReportName("Opencart Functional Testing");
		spartReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(spartReporter);
		extent.setSystemInfo("Application", "Opencart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customers");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");

		String os = textcontext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operation System", os);

		String browser = textcontext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);

		List<String> includedGroups = textcontext.getCurrentXmlTest().getIncludedGroups();
		if (!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includedGroups.toString());
		}

	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName() + "Got Successfully Executed");
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName() + "Got failes");
		test.log(Status.INFO, result.getThrowable().getMessage());

		try {
			String imgpath = new Random_details().capturescreen(result.getName());
			test.addScreenCaptureFromPath(imgpath);
		} catch (Exception e) {
			e.printStackTrace();// print warning in console for printstacktrace
		}
	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName() + "Got Skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}

	public void onFinish(ITestContext textcontext) {
		extent.flush();
		String pathofExtentReport = System.getProperty("user.dir") + "\\reports\\" + repname;
		File extentReport = new File(pathofExtentReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
