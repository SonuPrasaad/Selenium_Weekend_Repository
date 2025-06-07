package genericutility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class ListenerUtility extends BaseClass implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		test = eReport.createTest("clickOnBooks");
		test = eReport.createTest("clickOnComputers");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test script is failed!");
		TakesScreenshot ss = (TakesScreenshot) driver;
		String screenshot = ss.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(screenshot);
		
		try {
			webUtil.getScreenShot(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
