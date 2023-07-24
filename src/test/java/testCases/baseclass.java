package testCases;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import data.PropertyReader;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class baseclass extends PropertyReader {
	public static RequestSpecification httprequest;
	public static ExtentReports extent;
	public static ExtentTest extentTest;

	static {
		String log4jConfigFile = System.getProperty("user.dir") + File.separator + "log4j.properties";
		Configurator.initialize(null, log4jConfigFile);
		
	}

	public static Logger log = LogManager.getLogger(baseclass.class);
	

	@BeforeMethod
	public void Main() {
		RestAssured.baseURI = getProperty("baseURI");
		httprequest = RestAssured.given();
		
	}

	@BeforeSuite
	public void setReports() {
		extent = new ExtentReports("./Reports/ExtentReport.html");
		
	}
	
	
	@BeforeMethod
	public void startTest(Method name) {
		String testname = name.getName();
		extentTest = extent.startTest(testname);
	}

	@AfterMethod
	public void testCaseResult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "Test Case Failed ");
		} else {
			if (result.getStatus() == ITestResult.SUCCESS) {
				extentTest.log(LogStatus.PASS, "Test case passed successfully");
			}
		}
	}

	@AfterMethod
	public void endTest() {
		extent.endTest(extentTest);
	}

	@AfterSuite
	public void endReport() {
		extent.flush();
		extent.close();
	}

}
