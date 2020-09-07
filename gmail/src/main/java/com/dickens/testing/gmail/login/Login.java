package com.dickens.testing.gmail.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.dickens.testing.gmail.objects.HomePage;
import com.dickens.testing.gmail.objects.MailPage;
import com.dickens.testing.gmail.parent.ModelPage;

public class Login extends ModelPage {

	HomePage hPage;
	MailPage mPage;
	
	public Login(WebDriver webDriver) {
		this.driver = webDriver;
		hPage = PageFactory.initElements(webDriver, HomePage.class);
		mPage = PageFactory.initElements(webDriver, MailPage.class);
				
		
	}
	public void initiate(String username, String password) {
		open("https://gmail.com");
		inputfield(hPage.emailField, username);
		click(hPage.loginBtn);
		inputfield(hPage.passwordField, password);
		click(hPage.loginBtn);
		
	}
	public String getErrorMessage() {
		return getText(hPage.errorMsgSpan);
	}
	public String getAvatar()
	{
		return mPage.profileIcon.getClass().toString();
	}
}
