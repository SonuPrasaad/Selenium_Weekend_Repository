package genericutility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import objectrepository.HomePage;
import objectrepository.LoginPage;
import objectrepository.WelcomePage;

public class BaseClass {
	public static WebDriver driver;
	public static ExtentTest test;
	public static ExtentReports eReport;
	public WebDriverUtility webUtil = new WebDriverUtility();
	public JavaUtility jutil = new JavaUtility();
	public FileUtility futil = new FileUtility();
	public ExcelUtility eutil = new ExcelUtility();
	@BeforeSuite
	public void reportConfig()
	{
	    ExtentSparkReporter spark = new ExtentSparkReporter("./HTML_reports/extentreport_"+jutil.getSystemTime()+".html");
	    eReport = new ExtentReports();
	    eReport.attachReporter(spark);
	}
	
	@BeforeClass
	public void openBrowser() throws IOException
	{
		driver = new EdgeDriver();
		webUtil.maximize(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(futil.getPropertyData("url"));
	}
	
	@BeforeMethod
	public void login() throws IOException
	{
		WelcomePage welcome = new WelcomePage(driver);
		welcome.getLoginLink().click();
		
		LoginPage log = new LoginPage(driver);
		log.getEmailLink().sendKeys(futil.getPropertyData("username"));
		log.getPasswordLink().sendKeys(futil.getPropertyData("password"));
		log.getLoginButton().click();
	}
	
	@AfterMethod
	public void logout()
	{
		HomePage home = new HomePage(driver);
		home.getLogoutLink().click();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		webUtil.minimize(driver);
		driver.quit();
	}
	
	@AfterSuite
	public void reportBackUp()
	{
		eReport.flush();
	}
}
