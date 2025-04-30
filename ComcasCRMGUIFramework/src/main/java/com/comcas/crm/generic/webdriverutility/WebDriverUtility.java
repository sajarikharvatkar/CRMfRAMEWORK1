package com.comcas.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	//for implicitky wait
	public void WaitFirPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}
	
	
	//for Explicite Wait
	public void Explicitwait(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//switch to new window
	public void SwitchToNewWindowOnUrl(WebDriver driver,String partialUrl)
    {
		Set<String> set1=driver.getWindowHandles();
		Iterator<String>  itr= set1.iterator();
		while(itr.hasNext())
		{
			String windowId=itr.next();
			driver.switchTo().window(windowId);
			String actuUrl=driver.getCurrentUrl();
			if(actuUrl.equals(partialUrl))
			{
				break;
			}
		}
    }
		
		
		//switch to new window
		public void SwitchToNewWindowBasedOnTitle(WebDriver driver,String partialTitle)
	    {
			Set<String> set1=driver.getWindowHandles();
			Iterator<String>  itr= set1.iterator();
			while(itr.hasNext())
			{
				String windowId=itr.next();
				driver.switchTo().window(windowId);
				String actuUrl=driver.getTitle();
				if(actuUrl.equals(partialTitle))
				{
					break;
				}
			}
	    }
		
		//switch new Frame By Index
			public void SwitchToNewFrame(WebDriver driver,int index)
		    {
				driver.switchTo().frame(index);
			}
			
			//switch new Frame by Name or Id
			public void SwitchToNewFrame(WebDriver driver,String nameId)
		    {
				driver.switchTo().frame(nameId);
			}
		//switch to frame by webelement
			public void SwitchToNewFrame(WebDriver driver,WebElement element)
		    {
				driver.switchTo().frame(element);
			}
			//switch to alert ok
			public void switchToAlertAccept(WebDriver driver)
			{
				driver.switchTo().alert().accept();
			}
			//switch to alert cancel
			public void switchToAlertDismiss(WebDriver driver)
			{
				driver.switchTo().alert().dismiss();
			}
			//switch to alert and pass the data
			public void switchToAlertSendData(WebDriver driver,String data)
			{
				driver.switchTo().alert().sendKeys(data);;
			}
			//handle drpodown by index
			public void selectByIndex(int index,WebElement element)
			{
				Select s=new Select(element);
				s.selectByIndex(index);
			}
			
			//handle dropdown by value
			public void selectByvisibletext(String visibletext,WebElement element)
			{
				Select s=new Select(element);
				s.selectByVisibleText(visibletext);
			}
			//for mousehover action
			public void mouseHoverActions(WebDriver driver,WebElement element)
			{
				Actions act=new Actions(driver);
			    act.moveToElement(element).perform();;
			}
			//for doubleclick
			public void mouseDoubleclick(WebDriver driver,WebElement element)
			{
				Actions act=new Actions(driver);
			    act.doubleClick(element).perform();;
			}
			
			
	}

