package testScript;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageSliderPage;
import utilities.FileUploadUtility;

public class ManageSliderTest extends Base
{	
	@Test
	public void verifyTheUserIsAbleToAddANewMobileSlider() throws AWTException
	{
		String userName = "admin";
		String password = "admin";
		String linkText = "https://www.amazon.in";
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSigninButton();
		
		ManageSliderPage managesliderpage = new ManageSliderPage(driver);
		managesliderpage.clickOnManageSliderOption();
		managesliderpage.clickOnNewSliderButton();
		managesliderpage.useSendKeysForFileUpload();
		managesliderpage.enterLinkTextOnLinkTextField(linkText);
		managesliderpage.clickOnSaveButton();
		
		boolean isSliderCreatedSuccessfullyAlertDisplayed = managesliderpage.isSliderCreatedSuccessfullyAlertDisplayed();
		assertTrue(isSliderCreatedSuccessfullyAlertDisplayed, "New slider not added Successfully");
	}
}
