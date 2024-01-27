package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class ManageDeliveryBoyPage 
{
	public WebDriver driver;
	public ManageDeliveryBoyPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//p[text()='Manage Delivery Boy']//parent::div") WebElement manageDeliveryBoyPage;
	@FindBy(xpath = "//i[contains(@class,'fas fa-arrow-circle-right')]//parent :: a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy']") WebElement moreInfo;
	@FindBy(xpath ="//a[@class='btn btn-rounded btn-primary']") WebElement searchDeliveryBoyButton;
	@FindBy(xpath = "//input[@id=\"un\"]") WebElement deliveryBoyNameField;
	@FindBy(xpath = "//button[@value=\"sr\"]") WebElement deliveryBoyFilterSearchButton;
	@FindBy(xpath = "//div[@class=\"card\"]//tr[1]//td[1]") WebElement deliveryBoySearchResult;
	
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement addDeliveryBoyButton;
	@FindBy(xpath = "//input[@id='name']") WebElement deliveryBoyNameFields;
	@FindBy(xpath = "//input[@id='email']") WebElement deliveryBoyEmailField;
	@FindBy(xpath = "//input[@id='phone']") WebElement deliveryBoyPhoneNumberField;
	@FindBy(xpath = "//textarea[@id='address']") WebElement deliveryBoyAddressField;
	@FindBy(xpath = "//input[@id='username']") WebElement deliveryBoyUserNameField;
	@FindBy(xpath = "//input[@id='password']")WebElement deliveryBoyPasswordField;
	@FindBy(xpath = "//button[text()='Save']") WebElement saveButton;
	@FindBy(xpath = "//i[contains(@class,'icon fas fa-check')]//parent::h5") WebElement alertMessage;
	
	public String navigateToManageDeliveryBoyPage()
	{
		return manageDeliveryBoyPage.getText();
	}
	public void clickOnMoreInfo()
	{
		moreInfo.click();
	}
	public void clickOnSearchDeliveryBoyButton()
	{
		searchDeliveryBoyButton.click();
	}
	public void enterNameOnDeliveryBoyNameField(String deliveryBoyName)
	{
		deliveryBoyNameField.sendKeys(deliveryBoyName);
	}
	public void clickOnDeliveryBoyFilterSearchButton()
	{
		deliveryBoyFilterSearchButton.click();
	}
	public boolean isDeliveryBoySearchResultDisplayed()
	
	{
		return deliveryBoySearchResult.isDisplayed();
	}
	public void clickOnAddDeliveryBoyButton()
	{
		addDeliveryBoyButton.click();
	}
	public void enterDeliveryBoyNameOnEnterTheNameField(String newDeliveryBoyName)
	{
		deliveryBoyNameFields.sendKeys(newDeliveryBoyName);
	}
	public void enterDeliveryBoyEmailOnEnterEmailField(String deliveryBoyEmail)
	{
		deliveryBoyEmailField.sendKeys(deliveryBoyEmail);
	}
	public void enterPhoneNumberOnEnterPhoneNumberField(String deliveryBoyPhoneNumber)
	{
		deliveryBoyPhoneNumberField.sendKeys(deliveryBoyPhoneNumber);
	}
	public void enterAddressOnEnterAddressField(String deliveryBoyAddress)
	{
		deliveryBoyAddressField.sendKeys(deliveryBoyAddress);
	}
	public void enterUserNameOnEnterUserNameField(String deliveryBoyUserName)
	{
		deliveryBoyUserNameField.sendKeys(deliveryBoyUserName);
	}
	public void enterPasswordOnEnterPasswordField(String deliveryBoyPassword)
	{
		deliveryBoyPasswordField.sendKeys(deliveryBoyPassword);
	}
	public void clickOnSaveButton()
	{
		//WaitUtility waitutility = new WaitUtility();
		//waitutility.waitForElement(driver, saveButton);
		saveButton.click();
	}
	public boolean isNewDeliveryBoyCreatedSuccessfullyAlertDisplayed()
	{
		return alertMessage.isDisplayed();
	}
}
