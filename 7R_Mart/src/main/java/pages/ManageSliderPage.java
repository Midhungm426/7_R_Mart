package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;

public class ManageSliderPage 
{
	public WebDriver driver;
	public ManageSliderPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//p[text()='Manage Slider']//parent::a") WebElement manageSlider;
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newButton;
	@FindBy(xpath="//input[@id='main_img']") WebElement chooseFileButton;
	@FindBy(xpath="//input[@id='link']") WebElement linkTextField;
	@FindBy(xpath="//button[text()='Save']") WebElement saveButton;
	@FindBy(xpath="//h5[text()=' Alert!']//parent::div") WebElement alertText;
	
	public void clickOnManageSliderOption()
	{
		manageSlider.click();
	}
	public void clickOnNewSliderButton()
	{
		newButton.click();
	}
	public void clickOnChooseFileButton()
	{
		chooseFileButton.click();
	}
	
	//FileUploadUtility fileuploadutility =new FileUploadUtility();
	//fileuploadutility.fileUploadUsingRobotClass(chooseFileButton,linkText);
	
	public void enterLinkTextOnLinkTextField(String linkText)
	{
		linkTextField.sendKeys(linkText);
	}
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	public boolean isSliderCreatedSuccessfullyAlertDisplayed()
	{
		return alertText.isDisplayed();
	}
}
