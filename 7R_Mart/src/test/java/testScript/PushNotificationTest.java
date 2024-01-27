package testScript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.PushNotificationPage;

public class PushNotificationTest extends Base 
{
	@Test
	public void verifyPushNotificationMessageIsSendSuccessfully() 
	{
		String userName ="admin";
		String password ="admin";
		String enterTitleField ="Site down";
		String enterDescriptionField ="This site is not responding";
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSigninButton();
		
		PushNotificationPage pushnotificationpage = new PushNotificationPage(driver);
		pushnotificationpage.clickOnPushNotificationOption();
		pushnotificationpage.enterTitleInTitleField(enterTitleField);
		pushnotificationpage.enterDescriptionInDescriptionField(enterDescriptionField);
		pushnotificationpage.clickOnSendButton();
		boolean isPushNotificationMessageIsSendSuccessfully = pushnotificationpage.isPushNotificationMessageIsSendSuccessfully();
		assertTrue(isPushNotificationMessageIsSendSuccessfully, "Push Notification is not created successfully");
	}
}
