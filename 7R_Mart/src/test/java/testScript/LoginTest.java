package testScript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends Base
{
	@Test(description = "Verify whether theUserIsAbleToLoginWithValidCredentials")
	public void verifyWhetherTheUserIsAbleToLoginWithValidCredentials()
	{
		String userName = "admin";
		String password = "admin";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSigninButton();
		boolean isHomePageDisplayed = loginpage.isHomeDisplayed();
		assertTrue(isHomePageDisplayed,"User is unable to login with Valid Credentials");
	}
	@Test
	public void verifyWhetherTheUserIsNotAbleToLoginWithInvalidCredentials()
	{
		String userName = "admins";
		String password = "admins";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSigninButton();
		boolean isAlertMessageDisplayed = loginpage.isAlertPopupDisplayed();
		assertTrue(isAlertMessageDisplayed,"The user is able to login with invalid credentials");
	}
	
	@Test
	public void verifyWhetherTheUserIsNotAbleToLoginWithInvalidUsernameAndValidPassword()
	{
		String userName = "admins";
		String password = "admin";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSigninButton();
		boolean isAlertMessageDisplayed = loginpage.isAlertPopupDisplayed();
		assertTrue(isAlertMessageDisplayed,"The user is able to login with invalid username and a valid password");
	}
	
	@Test
	public void verifyWhetherTheUserIsNotAbleToLoginWithValidUsernameAndInvalidPassword()
	{
		String userName = "admin";
		String password = "admins";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSigninButton();
		boolean isAlertMessageDisplayed = loginpage.isAlertPopupDisplayed();
		assertTrue(isAlertMessageDisplayed,"The user is able to login with a valid username and a invalid password");
	}
}
