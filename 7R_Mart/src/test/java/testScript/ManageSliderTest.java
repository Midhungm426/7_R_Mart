package testScript;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageSliderPage;
import retry.Retry;
import utilities.ExcelUtility;

public class ManageSliderTest extends Base
{	
	@Test (retryAnalyzer = Retry.class, description = "Verify whether theUserIsAbleToAddANewMobileSlider")
	public void verifyTheUserIsAbleToAddANewMobileSlider() throws AWTException, IOException
	{
		String userName = ExcelUtility.getStringData(0, 1,"ManageSlider" );
		String password = ExcelUtility.getStringData(1, 1,"ManageSlider" );
		String linkText = ExcelUtility.getStringData(2, 1,"ManageSlider" );
		
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
