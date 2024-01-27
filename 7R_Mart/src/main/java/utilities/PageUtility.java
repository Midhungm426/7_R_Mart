package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility 
{
	public void selectValueUsingSelectByIndex(WebElement element, int index)
	{
		Select select= new Select(element);
		select.selectByIndex(index);
	}
	public void selectValueUsingSelectByValue(WebElement element, String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}
	public void selectValueUsingSelectByVisibleText(WebElement element, String text)
	{
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	public void dragAndDrop(WebElement dragItem,WebElement dropItem, WebDriver driver)
	{
		Actions actions = new Actions(driver);
		actions.dragAndDrop(dragItem, dropItem).build().perform();
	}
	public void doubleClick(WebElement targetItem, WebDriver driver)
	{
		Actions actions = new Actions(driver);
		actions.doubleClick(targetItem).build().perform();
	}
	public void rightClick(WebElement targetItem, WebDriver driver)
	{
		Actions actions = new Actions(driver);
		actions.contextClick(targetItem).build().perform();
	}
	public void alertAccept(WebElement alertElement, WebDriver driver)
	{
		alertElement.click();
		driver.switchTo().alert().accept();
	}
	public void alertDismiss(WebElement alertElement, WebDriver driver)
	{
		alertElement.click();
		driver.switchTo().alert().dismiss();
	}
	public void promtAlert (WebElement alertElement,String input, WebDriver driver)
	{
		alertElement.click();
		driver.switchTo().alert().sendKeys(input);
   	  	driver.switchTo().alert().accept();
	}
	public void frame(WebElement iframe, WebDriver driver)
	{
		driver.switchTo().frame(iframe);
	}
}

