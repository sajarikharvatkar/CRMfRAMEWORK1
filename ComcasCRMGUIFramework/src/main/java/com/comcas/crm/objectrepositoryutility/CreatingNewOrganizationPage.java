package com.comcas.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(name="accountname")
private WebElement orgNameEdt;
@FindBy(name="industry")
private WebElement orgindustryEdt;
@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveBtn;

public WebElement getOrgName() {
	return orgNameEdt;
}
public WebElement getOrgindustryEdt() {
	return orgindustryEdt;
}
public WebElement getSaveBtn() {
	return saveBtn;
}

//provide buss method for save orgnaization
public void createOrg(String orgname)
{
	orgNameEdt.sendKeys(orgname);
	saveBtn.click();
	
}

public void createOrg(String orgname,String indusname)
{
	orgNameEdt.sendKeys(orgname);
	Select s=new Select(orgindustryEdt);
	s.selectByVisibleText(indusname);
	
	saveBtn.click();
	
}

}
