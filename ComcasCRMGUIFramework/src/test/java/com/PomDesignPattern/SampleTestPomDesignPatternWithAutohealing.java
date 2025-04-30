package com.PomDesignPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SampleTestPomDesignPatternWithAutohealing {
@FindBy(name="user_name")
private WebElement ele1;
@FindBy(name="user_password")
private WebElement ele2;

//Autohealing using findAll()
//@FindAll({@FindBy(id="submi"),@FindBy(xpath="//input[@type='submit']")})
//private WebElement ele3;

// using findBys()
@FindBys({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
private WebElement ele3;
@Test
public void sampleTest()
{
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888/");
	SampleTestPomDesignPatternWithAutohealing s=	PageFactory.initElements(driver,SampleTestPomDesignPatternWithAutohealing.class);
	s.ele1.sendKeys("admin");
	s.ele2.sendKeys("admin");
	s.ele3.click();
	
	}

}
