package com.dickens.testing.gmail.loginTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.dickens.testing.gmail.login.Login;
import com.dickens.testing.gmail.parent.Browser;

public class Negative1 {

	public WebDriver webDriver;
	
	
	
	
	@BeforeSuite
	public void setUp() {
		this.webDriver = Browser.getDriver();
		
	}
	@AfterSuite
	public void shutDown() {
		webDriver.close();
	}
	@Test
	public void wrongEmailTest() {
		Login login = new Login(webDriver);
		
		login.initiate("ghhdh", "Welcome632");
		Assert.assertTrue(login.getErrorMessage().contains("Enter an email or mobile phone"));
		
	} 
	
}
