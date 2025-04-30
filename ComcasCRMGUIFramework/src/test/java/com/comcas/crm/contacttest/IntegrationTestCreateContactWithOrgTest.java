package com.comcas.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.comcas.crm.generic.fileutility.ExcelUtility;
import com.comcas.crm.generic.fileutility.FileUtility;
import com.comcas.crm.generic.webdriverutility.JavaUtility;
import com.comcas.crm.generic.webdriverutility.WebDriverUtility;

public class IntegrationTestCreateContactWithOrgTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileUtility fu=new FileUtility();
		ExcelUtility eu=new ExcelUtility();
		JavaUtility ju=new JavaUtility();
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
		
	
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		
        
        
        
        
		//DDT using Random Number and Excel File
		        String orgna  =eu.getDataFromExceFile("contact", 7, 2)+ju.getRandomNum();
				
		        String contn  =eu.getDataFromExceFile("contact", 7, 3)+ju.getRandomNum();
				  
				
				driver.findElement(By.name("accountname")).sendKeys(orgna);;
				
				driver.findElement(By.name("button")).click(); 
			        
				
				//navigate to contact module
			
			driver.findElement(By.linkText("Contacts"));
				
			WebElement contc=driver.findElement(By.linkText("Contacts"));
				
				wu.Explicitwait(driver, contc);
				contc.click();
				
				
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				
				driver.findElement(By.name("lastname")).sendKeys(contn);
				
				//to locate the lookup following sibling syntax used here
			driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
			

			
				//switch to new window
			   wu.SwitchToNewWindowOnUrl(driver,"module=Accounts");
			
				driver.findElement(By.name("search_text")).sendKeys(orgna);
				driver.findElement(By.name("search")).click();
				
				//use dynamic xpath because there is dynamic element
				driver.findElement(By.xpath("//a[text()='"+orgna+"']")).click();
				
				// switch back to parent window
				wu.SwitchToNewWindowOnUrl(driver,"module=Contacts");
				
				driver.findElement(By.name("button")).click();
				               
				//verify header	        
		          
//		          String headertext=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//		          if(headertext.contains(contn))
//		          {
//		        	  System.out.println("available"+headertext);
//		          }
//		          else
//		          {
//		        	  System.out.println("not available"+headertext);
//		          }
					   
					//verify header orgName info Expected Result     
			        
//		          String actorg=driver.findElement(By.id("mouseArea_Organization Name")).getText();
//		          if(actorg.equals(orgna))
//		          {
//		        	  System.out.println("available"+actorg);
//		          }
//		          else
//		          {
//		        	  System.out.println("not available"+actorg);
//		          }
	}

}
