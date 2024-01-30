package testScript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageOrdersPage;

public class ManageOrdersTest extends Base 
{
	@Test
	public void verifyThatTheUserIsAbleToDeleteAnOrder() 
	{
		String userName = "admin";
		String password = "admin";
		
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
}
