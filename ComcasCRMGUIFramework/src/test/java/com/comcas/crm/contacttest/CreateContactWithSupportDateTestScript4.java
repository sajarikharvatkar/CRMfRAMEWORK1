package com.comcas.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.comcas.crm.generic.fileutility.ExcelUtility;
import com.comcas.crm.generic.fileutility.FileUtility;
import com.comcas.crm.generic.webdriverutility.JavaUtility;
import com.comcas.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithSupportDateTestScript4 {

	public static void main(String[] args) throws IOException {
		FileUtility fu=new FileUtility();
		JavaUtility ju=new JavaUtility();
		ExcelUtility eu=new ExcelUtility();
		WebDriverUtility wu=new WebDriverUtility();
		
		String BROWSER=fu.getDataFromPropertyFile("Browser");
		
		String URL=fu.getDataFromPropertyFile("url");
	
		String USERNAME=fu.getDataFromPropertyFile("username");
		String PASSWORD=fu.getDataFromPropertyFile("password");
		
		WebDriver driver=null;
		if(BROWSER.equals("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("Edge"))
		{
			driver=new EdgeDriver();
		}
		else 
		{
			driver=new ChromeDriver();
		}
		
		
		driver.manage().window().maximize();
		wu.WaitFirPageToLoad(driver);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
	
		driver.findElement(By.linkText("Contacts")).click();
		
		//create contact
		
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		
        
        
        
        
		//DDT using Random Number and Excel sheet using
         String data= eu.getDataFromExceFile("contact", 7, 3)+ju.getRandomNum();
				
				driver.findElement(By.name("lastname")).sendKeys(data);
				
				
		//get support start date formatted using Generic Utility 		
	String currentSupportdate=	ju.getSystemDateyyyyMMddFormat();
				
			//get 30 Dys after date		
			
	String supportEnddate=ju.getDateAfterThirtyDays();
				
				
				
		//locate support start date and support end date
	driver.findElement(By.name("support_start_date")).clear();
	driver.findElement(By.name("support_start_date")).sendKeys(currentSupportdate);
	
				
	  driver.findElement(By.name("support_end_date")).clear();
	  driver.findElement(By.name("support_end_date")). sendKeys(supportEnddate);
       
		driver.findElement(By.name("button")).click(); 
				
				
      //verify supportstart date
				
	String actsupstrtdate=driver.findElement(By.id("dtlview_Support Start Date")).getText();
	if(actsupstrtdate.equals(currentSupportdate))
	{
		System.out.println("verified"+actsupstrtdate);
	}
	else
	{
		System.out.println("not verified"+actsupstrtdate);
	}
		
	//verify supportend date
	
	String actsupenddate=driver.findElement(By.id("dtlview_Support End Date")).getText();
	if(actsupenddate.equals(supportEnddate))
	{
		System.out.println("verified"+actsupenddate);
	}
	else
	{
		System.out.println("not verified"+actsupenddate);
	}
	}

}
