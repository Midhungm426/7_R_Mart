package testScript;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import utilities.WaitUtility;

public class ManageDeliveryBoyTest extends Base
{
	@Test
	public void verifySearchDeliveryBoyInDeliveryBoyPage()
	{
		String userName = "admin";
		String password = "admin";
		String deliveryBoyName = "Camden Abernathy";
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSigninButton();
		
		ManageDeliveryBoyPage managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.navigateToManageDeliveryBoyPage();
		managedeliveryboypage.clickOnMoreInfo();
		
		managedeliveryboypage.clickOnSearchDeliveryBoyButton();
		managedeliveryboypage.enterNameOnDeliveryBoyNameField(deliveryBoyName);
		managedeliveryboypage.clickOnDeliveryBoyFilterSearchButton();
		
		boolean isdeliveryboysearchresultdisplayed = managedeliveryboypage.isDeliveryBoySearchResultDisplayed();
		assertTrue(isdeliveryboysearchresultdisplayed,"Search result not found for"+deliveryBoyName);
	}
	@Test
	public void verifyAddDeliveryBoyInManageDeliveryBoyPage()
	{
		String userName = "admin";
		String password = "admin";
		String newDeliveryBoyName= "Anuu";
		String deliveryBoyEmail = "anu@gmail.com";
		String deliveryBoyPhoneNumber = "7736565717";
		String deliveryBoyAddress ="ABC House Trivandrum Kerala";
		String deliveryBoyUserName = "anu@1234";
		String deliveryBoyPassword = "anu@1234";
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSigninButton();
		
		ManageDeliveryBoyPage managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.navigateToManageDeliveryBoyPage();
		managedeliveryboypage.clickOnMoreInfo();
		managedeliveryboypage.clickOnAddDeliveryBoyButton();
		managedeliveryboypage.enterDeliveryBoyNameOnEnterTheNameField(newDeliveryBoyName);
		managedeliveryboypage.enterDeliveryBoyEmailOnEnterEmailField(deliveryBoyEmail);
		managedeliveryboypage.enterPhoneNumberOnEnterPhoneNumberField(deliveryBoyPhoneNumber);
		managedeliveryboypage.enterAddressOnEnterAddressField(deliveryBoyAddress);
		managedeliveryboypage.enterUserNameOnEnterUserNameField(deliveryBoyUserName);
		managedeliveryboypage.enterPasswordOnEnterPasswordField(deliveryBoyPassword);
		
		managedeliveryboypage.clickOnSaveButton();
		boolean isNewDeliveryBoyCreatedSuccessfullyAlertDisplayed = managedeliveryboypage.isNewDeliveryBoyCreatedSuccessfullyAlertDisplayed();
		assertTrue(isNewDeliveryBoyCreatedSuccessfullyAlertDisplayed,"New delivery boy not created successfully");
	}
}
