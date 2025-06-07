package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(id = "Email")
	private WebElement emailLink;
	
	@FindBy(id = "Password")
	private WebElement passwordLink;
	
	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmailLink() {
		return emailLink;
	}

	public WebElement getPasswordLink() {
		return passwordLink;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
}
