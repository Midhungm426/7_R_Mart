package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.MenuPage;
import retry.Retry;
import utilities.ExcelUtility;
import pages.LoginPage;

public class MenuTest extends Base
{
	@Test (retryAnalyzer = Retry.class, description = "Verify whether TheSelectedMenuTilesAreDisplayed")
	public void verifyWhetherTheSelectedMenuTilesAreDisplayed() throws IOException
	
	{
		String userName = ExcelUtility.getStringData(0, 1,"MenuPage" );
		String password = ExcelUtility.getStringData(1, 1,"MenuPage" );
		String selectedMenu = ExcelUtility.getStringData(2, 1,"MenuPage" );
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSigninButton();
		
		MenuPage menupage = new MenuPage(driver);
		menupage.clickOnMenu(selectedMenu);
		boolean isSelectedMenuPageDisplayed = menupage.isSelectedMenuPageDisplayed();
		assertTrue(isSelectedMenuPageDisplayed, "The selected menu is not displayed");
	}
}
