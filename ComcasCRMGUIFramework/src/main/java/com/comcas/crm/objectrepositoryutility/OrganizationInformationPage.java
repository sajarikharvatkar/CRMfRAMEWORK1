package com.comcas.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	WebDriver driver;
	@FindBy(className="dvHeaderText")
	private WebElement headermsg;
	public WebElement getHeadermsg() {
		return headermsg;
	}
	public OrganizationInformationPage(WebDriver driver)
	{   this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
