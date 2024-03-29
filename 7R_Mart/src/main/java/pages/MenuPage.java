package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage 
{
	public WebDriver driver;
	public MenuPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[contains(@class,'small')]//child::div[@class='inner']")private List<WebElement> menuList;
	@FindBy(xpath = "//a[@class='small-box-footer']")private List<WebElement> menuLink;
	@FindBy(xpath = "//a[@class=\"btn btn-rounded btn-warning\"]")private WebElement resetButton;
	
	public void clickOnMenu(String selectedMenu)
	{
		int menuIndex;
		for (WebElement menuItem : menuList) 
		{
			menuIndex = menuList.indexOf(menuItem);
			if(menuIndex!=-1 && menuItem.getText().contains(selectedMenu)) 
			{
				menuLink.get(menuIndex).click();
				break;
			}
		}
	}
	public boolean isSelectedMenuPageDisplayed()
	{
		return resetButton.isDisplayed();
	}
}
