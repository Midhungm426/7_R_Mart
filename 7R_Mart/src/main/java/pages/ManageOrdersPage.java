package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageOrdersPage 
{
	public WebDriver driver;
	public ManageOrdersPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-order']//parent::li") WebElement manageOrdersOption;
	@FindBy(xpath = "(//i[@class='fas fa-trash-alt'])[1]") WebElement deleteButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement alertMessage;
	
	@FindBy(xpath = "(//a[text()='Assign Delivery Boy'])[1]") WebElement assignDeliveryBoy;
	@FindBy(xpath = "(//select[@id='delivery_boy_id'])[1]") WebElement selectDeliveryBoy;
	@FindBy(xpath = "(//button[@name='assign_del'])[1]") WebElement updateButton;
	
	@FindBy(xpath = "(//a[@class=\'btn btn-primary btn-sm\'])[1]") WebElement changeDeliveryDate;
	@FindBy(xpath = "(//input[@name='del_up_date'])[1]") WebElement deliveryDateField;
	@FindBy(xpath = "(//input[@id='basicExample'])[1]") WebElement timeFromField;
	@FindBy(xpath = "(//input[@id='basicExample1'])[1]") WebElement timeToField;
	@FindBy(xpath = "(//button[@name='Update_st'])[2]") WebElement updateButtn;
	
	public void clickOnManageOrdersOption()
	{
		manageOrdersOption.click();
	}
	public void clickOnDeleteButton()
	{
		deleteButton.click();
	}	
	public boolean isOrderDeletedSuccessfully()
	{
		PageUtility pageutility = new PageUtility();
		pageutility.acceptAlert(driver);
		return alertMessage.isDisplayed();
	}
	
	public void clickOnAssignDeliveryBoy()
	{
		assignDeliveryBoy.click();
	}
	public void selectDeliveryBoy()
	{
		WaitUtility waitutility = new WaitUtility();
		waitutility.ExplicitWaitForAnElementToBeClickable(driver, updateButton);
		selectDeliveryBoy.click();
		PageUtility pageutility = new PageUtility();
		pageutility.selectValueUsingSelectByIndex(selectDeliveryBoy, 8);
	}
	public void clickOnUpdateButton()
	{
		updateButton.click();
	}
	public boolean isDeliveryBoyAssignedSuccessfully()
	{
		return alertMessage.isDisplayed();
	}
	
	public void clickOnChangeDeliveryDate()
	{
		changeDeliveryDate.click();
	}
	public void enterDeliveryDate(String deliveryDate)
	{
		deliveryDateField.sendKeys(String.valueOf(deliveryDate));
	}
	public void enterTimeFrom(String timeFrom)
	{
		timeFromField.clear();
		timeFromField.sendKeys(String.valueOf(timeFrom));
	}
	public void enterTimeTo(String timeTo)
	{
		timeToField.clear();
		timeToField.sendKeys(String.valueOf(timeTo));
	}
	public void clickOnUpdateButtn()
	{
		PageUtility pageutility = new PageUtility();
		pageutility.javaScriptClick(driver, updateButtn);
	}
	public boolean isDeliveryDateChangedSuccessfully()
	{
		return alertMessage.isDisplayed();
	}
}
