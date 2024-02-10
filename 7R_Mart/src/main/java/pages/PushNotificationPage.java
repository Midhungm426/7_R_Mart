package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PushNotificationPage 
{
	public WebDriver driver;
	public PushNotificationPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//p[text()='Push Notifications']//parent::a")private WebElement pushNotificationOption;
	@FindBy(xpath = "//input[@id='title']")private WebElement titleField;
	@FindBy(xpath="//input[@id='description']")private WebElement descriptionField;
	@FindBy(xpath="//button[contains(@class,'btn btn-block-sm btn-info')]")private WebElement sendButton;
	@FindBy(xpath="//i[contains(@class,'icon fas fa-check')]//parent::h5")private WebElement alertMessage;
	
	
	public void clickOnPushNotificationOption()
	{
		pushNotificationOption.click();
	}
	public void enterTitleInTitleField(String enterTitleField)
	{
		titleField.sendKeys(enterTitleField);
	}
	public void enterDescriptionInDescriptionField(String enterDescriptionField)
	{
		descriptionField.sendKeys(enterDescriptionField);
	}
	public void clickOnSendButton()
	{
		sendButton.click();
	}
	public boolean isPushNotificationMessageIsSendSuccessfully()
	{
		return alertMessage.isDisplayed();
	}
	
}
