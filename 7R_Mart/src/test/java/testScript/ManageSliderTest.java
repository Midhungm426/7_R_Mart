package testScript;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageSliderPage;
import utilities.FileUploadUtility;

public class ManageSliderTest extends Base
{	
	@Test
	public void verifyTheUserIsAbleToAddANewMobileSlider()
	{
		String userName = "admin";
		String password = "admin";
		String linkText = "https:ThefieryEnglish";
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSigninButton();
		
		ManageSliderPage managesliderpage = new ManageSliderPage(driver);
		managesliderpage.clickOnManageSliderOption();
		managesliderpage.clickOnNewSliderButton();
		managesliderpage.clickOnChooseFileButton();
		
	}
}
