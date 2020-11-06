package com.org.tests;

import org.testng.annotations.Test;

import com.org.pages.HomePage;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class SignInPageTest extends WebDriverTestCase{
	
	@Test(description="verify user is able to sign in from sign in section of home page.",enabled=false)//[JIRA] (QEO-14784)
	public void SignInTest() {
		
		String	username=ConfigurationManager.getBundle().getString("valid.username");
		String password=ConfigurationManager.getBundle().getString("valid.password");
		HomePage home=new HomePage();
		home.SignIn(username, password);
		home.closeAll();
	}

}
