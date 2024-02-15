package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import retry.Retry;
import utilities.ExcelUtility;
import utilities.RandomUtility;

public class ManageDeliveryBoyTest extends Base
{
	@Test (retryAnalyzer = Retry.class, description = "Verify whether TheUserIsAbleToSearchDeliveryBoyInDeliveryBoyPage", priority =1)
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
	
	@Test (retryAnalyzer = Retry.class, description = "Verify whether TheUserIsAbleToAddDeliveryBoyInManageDeliveryBoyPage", priority =2)
	public void verifyAddDeliveryBoyInManageDeliveryBoyPage() throws IOException
	{
		String userName = ExcelUtility.getStringData(0, 1, "ManageDeliveryBoy");
		String password = ExcelUtility.getStringData(1, 1, "ManageDeliveryBoy");
	
		String newDeliveryBoyName = RandomUtility.getRandomFirstName();
		String deliveryBoyPhoneNumber = RandomUtility.getRandomPhoneNumber();
		String deliveryBoyAddress = RandomUtility.getRandomFullAddress();
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSigninButton();
		
		ManageDeliveryBoyPage managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.navigateToManageDeliveryBoyPage();
		managedeliveryboypage.clickOnMoreInfo();
		managedeliveryboypage.clickOnAddDeliveryBoyButton();
		managedeliveryboypage.enterDeliveryBoyNameOnEnterTheNameField(newDeliveryBoyName);
		managedeliveryboypage.enterDeliveryBoyEmailOnEnterEmailField(newDeliveryBoyName+"@gmail.com");
		managedeliveryboypage.enterPhoneNumberOnEnterPhoneNumberField(deliveryBoyPhoneNumber);
		managedeliveryboypage.enterAddressOnEnterAddressField(deliveryBoyAddress);
		managedeliveryboypage.enterUserNameOnEnterUserNameField(newDeliveryBoyName+"@123");
		managedeliveryboypage.enterPasswordOnEnterPasswordField(newDeliveryBoyName+"@123");	
		managedeliveryboypage.clickOnSaveButton();
		boolean isNewDeliveryBoyCreatedSuccessfullyAlertDisplayed = managedeliveryboypage.isNewDeliveryBoyCreatedSuccessfullyAlertDisplayed();
		assertTrue(isNewDeliveryBoyCreatedSuccessfullyAlertDisplayed,"New delivery boy not created successfully");
	}
}
