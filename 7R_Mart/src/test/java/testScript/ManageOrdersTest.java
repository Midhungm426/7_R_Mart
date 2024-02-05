package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageOrdersPage;
import utilities.ExcelUtility;

public class ManageOrdersTest extends Base 
{
	@Test (description = "Verify whether TheUserIsAbleToDeleteAnOrder")
	public void verifyThatTheUserIsAbleToDeleteAnOrder() throws IOException 
	{
		String userName = ExcelUtility.getStringData(0, 1,"ManageOrders" );
		String password = ExcelUtility.getStringData(1, 1,"ManageOrders" );
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSigninButton();
		
		ManageOrdersPage manageorderspage = new ManageOrdersPage(driver);
		manageorderspage.clickOnManageOrdersOption();
		manageorderspage.clickOnDeleteButton();
		
		boolean isorderdeletedsuccessfully = manageorderspage.isOrderDeletedSuccessfully();
		assertTrue(isorderdeletedsuccessfully, "Order not deleted");
	}
	
	@Test (description = "Verify whether TheuserIsAbleToAssignADeliveryBoy")
	public void verifyThatTheuserIsAbleToAssignADeliveryBoy() throws IOException
	{
		String userName = ExcelUtility.getStringData(0, 1,"ManageOrders" );
		String password = ExcelUtility.getStringData(1, 1,"ManageOrders" );
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSigninButton();
		
		ManageOrdersPage manageorderspage = new ManageOrdersPage(driver);
		manageorderspage.clickOnManageOrdersOption();
		manageorderspage.clickOnAssignDeliveryBoy();
		manageorderspage.selectDeliveryBoy();
		manageorderspage.clickOnUpdateButton();
		boolean isDeliveryBoyAssignedSuccessfully = manageorderspage.isDeliveryBoyAssignedSuccessfully();
		assertTrue(isDeliveryBoyAssignedSuccessfully, "Delivery Boy not assigned successfully");
	}
	
	@Test (description = "Verify whether TheuserIsAbleToChangeTheDeliveryDate")
	public void verifyThatTheuserIsAbleToChangeTheDeliveryDate() throws IOException
	{
		String userName = ExcelUtility.getStringData(0, 1,"ManageOrders" );
		String password = ExcelUtility.getStringData(1, 1,"ManageOrders" );
		String deliveryDate = ExcelUtility.getIntegerData(2, 1,"ManageOrders" );
		String timeFrom = ExcelUtility.getStringData(3, 1,"ManageOrders" );
		String timeTo = ExcelUtility.getStringData(4, 1,"ManageOrders" );
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSigninButton();
		
		ManageOrdersPage manageorderspage = new ManageOrdersPage(driver);
		manageorderspage.clickOnManageOrdersOption();
		
		manageorderspage.clickOnChangeDeliveryDate();
		manageorderspage.enterDeliveryDate(deliveryDate);
		manageorderspage.enterTimeFrom(timeFrom);
		manageorderspage.enterTimeTo(timeTo);
		manageorderspage.clickOnUpdateButtn();
		boolean isDeliveryDateChangedSuccessfully = manageorderspage.isDeliveryDateChangedSuccessfully();
		assertTrue(isDeliveryDateChangedSuccessfully, "Delivery date not changed successfully");
	}
}
