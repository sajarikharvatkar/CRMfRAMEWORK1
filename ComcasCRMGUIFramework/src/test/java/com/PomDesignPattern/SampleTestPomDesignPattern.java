package com.PomDesignPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SampleTestPomDesignPattern {
@FindBy(name="user_name")
WebElement ele1;
@FindBy(name="user_password")
WebElement ele2;
@FindBy(id="submitButton")
WebElement ele3;
private WebDriver driver;
@Test
public void sampleTest()
{
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888/");
//	SampleTestPomDesignPattern s=	PageFactory.initElements(driver,SampleTestPomDesignPattern.class);
//	s.ele1.sendKeys("admin");
//	s.ele2.sendKeys("admin");
//	driver.navigate().refresh();
//	s.ele1.sendKeys("admin");
//	s.ele2.sendKeys("admin");
//	s.ele3.click();
	
	SampleTestPomDesignPattern s=new SampleTestPomDesignPattern(driver);
	
	s.ele1.sendKeys("admin");
	s.ele2.sendKeys("admin");

   s.ele3.click();
	
	
	
	}
public SampleTestPomDesignPattern(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public WebElement getEle1() {
	return ele1;
}
public WebElement getEle2() {
	return ele2;
}
public WebElement getEle3() {
	return ele3;
}

}
