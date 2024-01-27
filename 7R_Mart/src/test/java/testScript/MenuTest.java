package testScript;

import org.testng.annotations.Test;

import pages.MenuPage;
import pages.LoginPage;

public class MenuTest extends Base
{
	@Test
	public void verifyWhetherTheSelectedMenuTilesAreDisplayed()
	
	{
		String userName = "admin";
		String password = "admin";
		String selectedMenu = "Manage Orders";
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSigninButton();
		
		MenuPage menupage = new MenuPage(driver);
		menupage.clickOnMenu(selectedMenu);
	}
}
