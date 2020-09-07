package com.dickens.testing.gmail.parent;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class Browser {

	public static WebDriver getDriver() {
		String driverUsed = System.getProperty("browser");
		
		if(StringUtils.isEmpty(driverUsed)) {
			return new ChromeDriver();
		}
		if(driverUsed.equalsIgnoreCase("chrome"))
			return new ChromeDriver();
		else if(driverUsed.equalsIgnoreCase("ie"))
			return new InternetExplorerDriver();
		else if(driverUsed.equalsIgnoreCase("firefox"))
			return new FirefoxDriver();
		else
			return new ChromeDriver();
	}
		
}
