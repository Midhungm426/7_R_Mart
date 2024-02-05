package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.PushNotificationPage;
import utilities.ExcelUtility;

public class PushNotificationTest extends Base 
{
	@Test (description ="verify whether PushNotificationMessageIsSendSuccessfully")
	public void verifyPushNotificationMessageIsSendSuccessfully() throws IOException 
	{
		String userName = ExcelUtility.getStringData(0, 1,"PushNotificationPage" );
		String password = ExcelUtility.getStringData(1, 1,"PushNotificationPage" );
		String enterTitleField = ExcelUtility.getStringData(2, 1,"PushNotificationPage" );
		String enterDescriptionField = ExcelUtility.getStringData(3, 1,"PushNotificationPage" );
		
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
