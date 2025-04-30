package com.PomDesignPattern;

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
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.comcas.crm.generic.fileutility.ExcelUtility;
import com.comcas.crm.generic.fileutility.FileUtility;
import com.comcas.crm.generic.webdriverutility.JavaUtility;
import com.comcas.crm.generic.webdriverutility.WebDriverUtility;
import com.comcas.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcas.crm.objectrepositoryutility.HomePage;
import com.comcas.crm.objectrepositoryutility.LoginPage;
import com.comcas.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcas.crm.objectrepositoryutility.OrganizationsPage;

public class SearchAndDeleteOrgTestWithPom {

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
		
		
		
		
	//	Rule 3=Object Initialization using PageFactory.initElement() these one way 
		//LoginPage l=PageFactory.initElements(driver,LoginPage.class);

	//rule3=Object Utilization using constructor of pom class
		 
	 LoginPage l1=new LoginPage(driver);
	 
		//rule5=Object Utilization using getters()
	 
	 //login to application
		//provide Action Login
		l1.LoginToApp(URL,USERNAME, PASSWORD);
		

		
		
		//navigate to organaization link
		HomePage h=new HomePage(driver);
		h.getOrgLink().click();
		
		//create Organization
		OrganizationsPage o=new OrganizationsPage(driver);
		o.getCreateOrg().click();
		
		//data from Excel sheet and random number
		String orgName=eu.getDataFromExceFile("organizations", 1, 2)+ju.getRandomNum();
		String indust=eu.getDataFromExceFile("organizations", 1, 3);
		
		//enter fields and save
		CreatingNewOrganizationPage crogp=new CreatingNewOrganizationPage(driver);
		
		crogp.createOrg(orgName, indust);
		
		//validate headermasg with org name
		
		OrganizationInformationPage orginfo=new OrganizationInformationPage(driver);
	  String Acthrmsg=	orginfo.getHeadermsg().getText();
	  if(Acthrmsg.contains(orgName))
	  {
		  System.out.println("Header is matched");
	  }
		
	  else
	  {
		  System.out.println("Header is not match");
	  }
	  
	  //go back to the organization
	  h.getOrgLink().click();
		
	  
	  //search for organization
	  o.getSearchOrg().sendKeys(orgName);
	
	  wu.selectByvisibletext("Organization Name",o.getSelectdd());
	  o.getSearchBtn().click();
	  
	  //in dynamic web select and delete org
	  driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();
	  wu.switchToAlertAccept(driver);
	  //logout from apllication
	  h.GoToSignOut();
	  
     // driver.close();
		

	}

}
