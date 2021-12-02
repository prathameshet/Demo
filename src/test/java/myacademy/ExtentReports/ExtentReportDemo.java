package myacademy.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	
	ExtentReports extents;
	
	@BeforeTest
	public void config()
	{
		//ExtentReports,ExtentSparkReporter
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("WebAutomationResults");
		reporter.config().setDocumentTitle("Test Results");
		
		extents=new ExtentReports();
		extents.attachReporter(reporter);
		extents.setSystemInfo("Tester", "Prathamesh");
		
		
	}
    @Test
	public void initialDemo()
	{
    	ExtentTest test=extents.createTest("Initial Demo");
		System.setProperty("webdriver.chrome.driver","D:\\JavaInstallationsetups\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http:/www.google.com");
		System.out.println(driver.getTitle());
		driver.close();
		test.fail("Result do not match");
		extents.flush();
	}
}
