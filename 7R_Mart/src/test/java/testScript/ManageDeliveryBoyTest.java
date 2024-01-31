package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import utilities.ExcelUtility;

public class ManageDeliveryBoyTest extends Base
{
	@Test
	public void verifySearchDeliveryBoyInDeliveryBoyPage() throws IOException
	{
		String userName = ExcelUtility.getStringData(0, 1, "ManageDeliveryBoy");
		String password = ExcelUtility.getStringData(1, 1, "ManageDeliveryBoy");
		String deliveryBoyName = ExcelUtility.getStringData(2, 1, "ManageDeliveryBoy");
		
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
	public void verifyAddDeliveryBoyInManageDeliveryBoyPage() throws IOException
	{
		String userName = ExcelUtility.getStringData(0, 1, "ManageDeliveryBoy");
		String password = ExcelUtility.getStringData(1, 1, "ManageDeliveryBoy");
		String newDeliveryBoyName= ExcelUtility.getStringData(3, 1, "ManageDeliveryBoy");
		String deliveryBoyEmail = ExcelUtility.getStringData(4, 1, "ManageDeliveryBoy");
		String deliveryBoyPhoneNumber = ExcelUtility.getIntegerData(5, 1, "ManageDeliveryBoy");
		String deliveryBoyAddress = ExcelUtility.getStringData(6, 1, "ManageDeliveryBoy");
		String deliveryBoyUserName = ExcelUtility.getStringData(7, 1, "ManageDeliveryBoy");
		String deliveryBoyPassword = ExcelUtility.getStringData(8, 1, "ManageDeliveryBoy");
		
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
