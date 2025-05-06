package com.PomDesignPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcas.crm.objectrepositoryutility.LoginPage;

public class D {
	WebDriver driver=new ChromeDriver();
	String ele1;
	String ele3;
	
	@Test
public void a1()
{ System.out.println("1");
		driver.get("http://localhost:8888");
		LoginPage l=new LoginPage(driver);
		l.getUsernameEdt().sendKeys("admin");
		l.getPasswordEdt().sendKeys("admin");
		l.getLoginBtn().click();
		
	}
}
