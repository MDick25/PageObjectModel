package com.dickens.testing.gmail.loginTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.dickens.testing.gmail.login.Login;
import com.dickens.testing.gmail.parent.Browser;

public class LoginTest {

	public WebDriver webDriver;
	
	@BeforeSuite
	public void setUp() {
		this.webDriver = Browser.getDriver();
	}
	@AfterSuite
	public void tearDown() {
		webDriver.close();
	}
	@Test
	public void validcredentialsLoginTest() {
		Login login = new Login(webDriver);
		login.initiate("johnny.bright774@gmail.com", "Welcome632");
		Assert.assertTrue(login.getAvatar().contains("gb_La gbii"));
		
		
		
	}
}
