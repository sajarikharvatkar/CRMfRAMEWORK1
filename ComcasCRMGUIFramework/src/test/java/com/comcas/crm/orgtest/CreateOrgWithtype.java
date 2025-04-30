package com.comcas.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Row;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.comcas.crm.generic.fileutility.ExcelUtility;
import com.comcas.crm.generic.fileutility.FileUtility;
import com.comcas.crm.generic.webdriverutility.JavaUtility;
import com.comcas.crm.generic.webdriverutility.WebDriverUtility;

public class CreateOrgWithtype {

	public static void main(String[] args) throws IOException {
		
		
		FileUtility fu=new FileUtility();
		WebDriverUtility wu=new WebDriverUtility();
		JavaUtility ju=new JavaUtility();
		ExcelUtility eu=new ExcelUtility();
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
		
	
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		
        
        
        
		//DDT using Random Number
		
				
				   
				String orgdt=eu.getDataFromExceFile("organizations", 1, 2)+ju.getRandomNum();
				String indust=eu.getDataFromExceFile("organizations", 1, 3);
				String type=eu.getDataFromExceFile("organizations", 1, 4) ; 
				
				driver.findElement(By.name("accountname")).sendKeys(orgdt);;
				WebElement industry=driver.findElement(By.name("industry"));
				wu.selectByvisibletext(indust,industry);
				WebElement type1=driver.findElement(By.name("accounttype"));
				wu.selectByvisibletext(type, type1);
			        driver.findElement(By.name("emailoptout")).click();
			        driver.findElement(By.name("assigntype")).click();
			        driver.findElement(By.name("button")).click(); 
        
  String ele=driver.findElement(By.className("dvHeaderText")).getText();
  
  if(ele.contains(orgdt))
  {
	  System.out.println("header is matched");
  }else
  {
  System.out.println("header not matched");
  }
  Actions act=new Actions(driver);
  
WebElement logout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
act.moveToElement(logout).perform();

WebElement element=driver.findElement(By.xpath("//a[text()='Sign Out']"));



 element.click();


//driver.close();
		

	}

}
