package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobileSliderPage 
{
	public WebDriver driver;
	public MobileSliderPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//p[text()='Mobile Slider']//parent::a") WebElement mobileSliderOption;
	@FindBy(xpath = "(//span[text()='Active'])[1]") WebElement activeStatusButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement alertMessage;
	
	public void clickOnMobileSliderOption()
	{
		mobileSliderOption.click();
	}
	public void clickOnStatusButton()
	{
		activeStatusButton.click();
	}
	public boolean isStatusChangedSuccessfullyAlertDisplayed()
	{
		return alertMessage.isDisplayed();
	}
}
