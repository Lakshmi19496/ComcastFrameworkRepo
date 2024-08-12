package com.comcast.crm.generic.webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	
	//implicit wait
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	//explicit wait
	public void waitForElementPresent(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	//maximize browser
	public void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	//minimize browser
	public void minimizeBrowser(WebDriver driver)
	{
		driver.manage().window().minimize();;
	}
	//select methods
	public Select dropDown(WebElement element)
	{
		Select sel=new Select(element);
		return sel;
	}
	public void handlingDropDown(WebElement element,String text)
	{

		dropDown(element).selectByVisibleText(text);
	}
	public void handlingDropDown(WebElement element,int index)
	{

		dropDown(element).selectByIndex(index);;
	}
	public void handlingDropDown(String value,WebElement element)
	{

		dropDown(element).selectByValue(value);;;
	}
	//alert methods
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	//Actions methods
	public Actions actions(WebDriver driver)
	{
		Actions act=new Actions(driver);
		return act;
	}
	public void actionsMoveToElement(WebDriver driver,WebElement element)
	{

		actions(driver).moveToElement(element).perform();

	}
	public void actionsDragAndDrop(WebDriver driver,WebElement src,WebElement target)
	{

		actions(driver).dragAndDrop(src, target).perform();;
	}
	public void actionsContextClick(WebDriver driver,WebElement element)
	{

		actions(driver).contextClick(element).perform();;
	}
	public void actionsScrollByAmount(WebDriver driver,int amt)
	{

		actions(driver).scrollByAmount(0, amt);		
	}
	public void actionsScrollToElement(WebDriver driver,WebElement element)
	{

		actions(driver).scrollToElement(element).perform();

	}
	//take screen shot
	public void takeScreenShot(WebDriver driver,String fileName) throws IOException
	{
		TakesScreenshot t=(TakesScreenshot) driver;
		File src=t.getScreenshotAs(OutputType.FILE);
		File tar=new File("./ScreenShot/"+fileName+".png");
		FileHandler.copy(src,tar);

	}
	public void takeScreenshotOfElement(WebDriver driver,WebElement element,String fileName) throws IOException
	{
		TakesScreenshot t=(TakesScreenshot) driver;
		File src=element.getScreenshotAs(OutputType.FILE);
		File tar=new File("./ScreenShot/"+fileName+".png");
		FileHandler.copy(src, tar);
		
	}
	//frames
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver,String nameId)
	{
		driver.switchTo().frame(nameId);
	}
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}

	//swithTowindows
	public void switchToWindowByURL(WebDriver driver,String partialUrl)
	{
		Set<String> allwh = driver.getWindowHandles();
		Iterator<String> it=allwh.iterator();
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			String actUrl=driver.getCurrentUrl();
			if(actUrl.contains(partialUrl)){
				break;
			}

		}
	}
	public void switchToWindowByTitle(WebDriver driver,String partialTitle)
	{
		Set<String> allwh = driver.getWindowHandles();
		Iterator<String> it=allwh.iterator();
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			String actTitle=driver.getTitle();
			if(actTitle.contains(partialTitle)){
				break;
			}

		}
	}
	//javascriptexecutor
	public void scrollUntilElementIsVisible(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")");
	}

	public void scrollToElementByJS(WebDriver driver,WebElement element)
	{

		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoview()",element);

	}
	public void clickElementByJS(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",element);
	}
	
	
}
