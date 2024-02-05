package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MobileSliderPage;
import utilities.ExcelUtility;

public class MobileSliderTest extends Base
{
	@Test (description = "Verify whether TheUserIsAbleToChangeTheStatusOfMobileSlider")
	public void verifyThatTheUserIsAbleToChangeTheStatusOfMobileSlider() throws IOException
	{
		String userName = ExcelUtility.getStringData(0, 1, "MobileSlider");
		String password = ExcelUtility.getStringData(1, 1, "MobileSlider");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSigninButton();
		
		MobileSliderPage mobilesliderpage = new MobileSliderPage(driver);
		mobilesliderpage.clickOnMobileSliderOption();
		mobilesliderpage.clickOnStatusButton();
		boolean isStatusChangedSuccessfullyAlertDisplayed = mobilesliderpage.isStatusChangedSuccessfullyAlertDisplayed();
		assertTrue(isStatusChangedSuccessfullyAlertDisplayed, "Status is not changed");
	}
}
