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
	@FindBy(xpath = "//div[@class=\'alert alert-success alert-dismissible\']") WebElement alertMessage;
	
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
}
