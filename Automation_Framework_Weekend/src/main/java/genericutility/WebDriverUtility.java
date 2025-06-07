package genericutility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

/**
 * @author SonuPrasaad
 */
public class WebDriverUtility {
	/**
	 * It is used to maximize the window
	 * @param driver
	 */
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void minimize(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * It is used to capture the height and width
	 * @param driver
	 * @return
	 */
	public Dimension captureSize(WebDriver driver)
	{
		return driver.manage().window().getSize();
	}
	
	public void mouseHover(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void doubleClick(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public void clickAndHold(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}
	
	public void selectDropdownByIndex(WebElement element, int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void selectDropdownByValue(WebElement element, String text)
	{
		Select select = new Select(element);
		select.selectByValue(text);
	}
	
	public void selectDropdownByVisibleText(WebElement element, String text)
	{
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	public void switchToFrame(WebDriver driver, WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	
	public void switchBackToHome(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	public Alert switchToAlert(WebDriver driver)
	{
		 return driver.switchTo().alert();
	}
	
	public void getScreenShot(WebDriver driver) throws IOException
	{
		JavaUtility jutil = new JavaUtility();
		TakesScreenshot ss = (TakesScreenshot) driver;
		File temp = ss.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/"+jutil.getSystemTime()+".png");
		FileHandler.copy(temp, dest);
	}
}
