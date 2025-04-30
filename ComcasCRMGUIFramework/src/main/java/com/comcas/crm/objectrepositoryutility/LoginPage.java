package com.comcas.crm.objectrepositoryutility;
//Rule 1=create seperate java class for each page

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.internal.BaseClassFinder;

import com.comcas.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage  {
	WebDriverUtility wu=new WebDriverUtility();
	//rule2 =Object Identification using @findBy Annotation
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//rule 3=Object Initialization using constructor and use initelement method inside constructor
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//rule4=Object Encapsulation using getters()
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//provide Actions
	public void LoginToApp(String url,String Username,String Password) {
		
		
	 driver.manage().window().maximize();
wu.WaitFirPageToLoad(driver);
	 driver.get(url);
		usernameEdt.sendKeys(Username);
		passwordEdt.sendKeys(Password);
		loginBtn.click();
	}
	

}
