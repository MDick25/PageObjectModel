package com.dickens.testing.gmail.parent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ModelPage {

	protected WebDriver driver;
	
	public void inputfield(WebElement webElement, String value) {
		webElement.sendKeys(value);
	}
	public void click(WebElement webElement) {
		webElement.click();
	}
	public String getText(WebElement webElement) {
		return webElement.getText();
	}
	public void open(String url) {
		driver.get(url);
	}
}
