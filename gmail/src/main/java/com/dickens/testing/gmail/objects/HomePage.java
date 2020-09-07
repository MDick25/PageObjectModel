package com.dickens.testing.gmail.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
	
	@FindBy(className="whsOnd zHQkBf")
	public WebElement emailField;
	
	@FindBy(how = How.NAME, using="password")
	public WebElement passwordField;
	
	@FindBy(className="VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc")
	public WebElement loginBtn;
	
	@FindBy(className="jibhHc")
	public WebElement errorMsgSpan;
	
	
	
	
}
