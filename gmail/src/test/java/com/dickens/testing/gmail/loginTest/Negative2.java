package com.dickens.testing.gmail.loginTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.dickens.testing.gmail.login.Login;
import com.dickens.testing.gmail.parent.Browser;

public class Negative2 {

	public WebDriver webDriver;
	
	@BeforeSuite
	public void setUp() {
		webDriver = Browser.getDriver();
	}
	
	@AfterSuite
	public void powerDown() {
		webDriver.close();
	}
	public void wrongPassword() {
		Login login = new Login(webDriver);
		login.initiate("johnny.bright774@gmail.com", "ChickenDinner");
		Assert.assertTrue(login.getErrorMessage().contains("Wrong password. Try again or click Forgot password to reset it."));
	}
}
