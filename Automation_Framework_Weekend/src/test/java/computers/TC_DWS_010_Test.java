package computers;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.ListenerUtility;
import objectrepository.HomePage;

@Listeners(ListenerUtility.class)
public class TC_DWS_010_Test extends BaseClass {
	@Test
	public void clickOnComputers()
	{
		HomePage home = new HomePage(driver);
		home.getComputersLink().click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. ");
		test.log(Status.PASS, "Computers Page is executed");
	}
}
