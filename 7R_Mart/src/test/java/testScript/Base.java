package testScript;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import testScript.Base;
import utilities.ScreenshotUtility;
import utilities.WaitUtility;

public class Base 
{
	public WebDriver driver;
		
	@BeforeMethod (alwaysRun=true)
	@Parameters("browser")
	
	public void initializeBrowser(String browser) throws Exception
	
	{
		if (browser.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			throw new Exception("Invalid browser");
		}
		
		driver.manage().window().maximize();
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
	}
	
	@AfterMethod (alwaysRun=true)
	
	public void browserQuit(ITestResult iTestResult) throws IOException
	{
		if (iTestResult.getStatus()== iTestResult.FAILURE)
		{
			ScreenshotUtility screenshotutility = new ScreenshotUtility();
			screenshotutility.getScreenShot(driver, iTestResult.getName());
		}
		driver.quit();

	}
}

