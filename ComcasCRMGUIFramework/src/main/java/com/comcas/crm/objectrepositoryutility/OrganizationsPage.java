package com.comcas.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	WebDriver driver;
@FindBy(xpath="//img[@alt='Create Organization...']")
private WebElement createOrg;
@FindBy(name="search_text")
private WebElement searchOrg;
@FindBy(id="bas_searchfield")
private WebElement selectdd;
@FindBy(name="submit")
private WebElement searchBtn;

public WebElement getSearchBtn() {
	return searchBtn;
}

public WebElement getSelectdd() {
	return selectdd;
}

public WebElement getSearchOrg() {
	return searchOrg;
}

public OrganizationsPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public WebElement getCreateOrg() {
	return createOrg;
}

}
