package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import retry.Retry;
import utilities.ExcelUtility;

public class LoginTest extends Base
{
	@Test (retryAnalyzer = Retry.class, description = "Verify whether theUserIsAbleToLoginWithValidCredentials", groups = {"regression"})
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
	
	@Test (retryAnalyzer = Retry.class, description = "Verify whether theUserIsNotAbleToLoginWithInvalidCredentials", groups = {"smoke"})
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
	
	@Test (retryAnalyzer = Retry.class, description = "Verify whether TheUserIsNotAbleToLoginWithInvalidUsernameAndValidPassword")
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
	
	@Test (retryAnalyzer = Retry.class, description = "Verify whether TheUserIsNotAbleToLoginWithValidUsernameAndInvalidPassword", dataProvider= "LoginProvider")
	public void verifyWhetherTheUserIsNotAbleToLoginWithValidUsernameAndInvalidPassword(String userName, String password) throws IOException
	{
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSigninButton();
		boolean isAlertMessageDisplayed = loginpage.isAlertPopupDisplayed();
		assertTrue(isAlertMessageDisplayed,"The user is able to login with a valid username and a invalid password");
	}
	
	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() throws IOException 
	{
		return new Object[][] { { ExcelUtility.getStringData(1, 6, "LoginPage"), ExcelUtility.getStringData(1, 7, "LoginPage") }};
}
}
