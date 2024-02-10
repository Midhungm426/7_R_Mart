package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{	
	public WebDriver driver;
	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='username']")private WebElement userNameField;
	@FindBy(xpath="//input[@name='password']")private WebElement passwordField;
	@FindBy(xpath="//button[@type='submit']")private WebElement signInButton;
	@FindBy(xpath="//li[@class='breadcrumb-item']")private WebElement home;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")private WebElement alertPopup;
	
	public void enterUserNameOnUserNameField(String userName)
	{
		userNameField.sendKeys(userName);
	}
	
	public void enterPasswordOnPasswordField(String password)
	{
		passwordField.sendKeys(password);
	}
	public void clickOnSigninButton()
	{
		signInButton.click();
	}
	public boolean isHomeDisplayed()
	{
		return home.isDisplayed();
	}
	public boolean isAlertPopupDisplayed()
	{
		return alertPopup.isDisplayed();
	}
}

