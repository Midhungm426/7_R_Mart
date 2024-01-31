package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base
{
	@Test(description = "Verify whether theUserIsAbleToLoginWithValidCredentials")
	public void verifyWhetherTheUserIsAbleToLoginWithValidCredentials() throws IOException
	{
		String userName = ExcelUtility.getStringData(1, 0,"LoginPage" );
		String password = ExcelUtility.getStringData(1, 1,"LoginPage" );
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSigninButton();
		boolean isHomePageDisplayed = loginpage.isHomeDisplayed();
		assertTrue(isHomePageDisplayed,"User is unable to login with Valid Credentials");
	}
	@Test
	public void verifyWhetherTheUserIsNotAbleToLoginWithInvalidCredentials() throws IOException
	{
		String userName = ExcelUtility.getStringData(1, 2, "LoginPage");
		String password = ExcelUtility.getStringData(1, 3, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSigninButton();
		boolean isAlertMessageDisplayed = loginpage.isAlertPopupDisplayed();
		assertTrue(isAlertMessageDisplayed,"The user is able to login with invalid credentials");
	}
	
	@Test
	public void verifyWhetherTheUserIsNotAbleToLoginWithInvalidUsernameAndValidPassword() throws IOException
	{
		String userName = ExcelUtility.getStringData(1, 4, "LoginPage");
		String password = ExcelUtility.getStringData(1, 5, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSigninButton();
		boolean isAlertMessageDisplayed = loginpage.isAlertPopupDisplayed();
		assertTrue(isAlertMessageDisplayed,"The user is able to login with invalid username and a valid password");
	}
	
	@Test
	public void verifyWhetherTheUserIsNotAbleToLoginWithValidUsernameAndInvalidPassword() throws IOException
	{
		String userName = ExcelUtility.getStringData(1, 6, "LoginPage");
		String password = ExcelUtility.getStringData(1, 7, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSigninButton();
		boolean isAlertMessageDisplayed = loginpage.isAlertPopupDisplayed();
		assertTrue(isAlertMessageDisplayed,"The user is able to login with a valid username and a invalid password");
	}
}
