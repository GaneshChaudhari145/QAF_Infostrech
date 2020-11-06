package com.amazon.test;

import org.testng.annotations.Test;

import com.amazon.page.LandingPage;
import com.amazon.page.LoginPage;
import com.amazon.page.WelcomePage;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class LoginPageTest extends WebDriverTestCase{
	
	@Test(description="verify existing user can login",enabled=false)//[JIRA] (QEO-14802)
	public void Successfully_Login(){
		LandingPage land=new LandingPage();
		WelcomePage welcome=new WelcomePage();
		LoginPage login=new LoginPage();
		
		land.alreadyCustomer();
		welcome.login();
		welcome.validusername(ConfigurationManager.getBundle().getString("Email"));
		login.validpassword(ConfigurationManager.getBundle().getString("password"));
		login.verificationHomePage();
	}
	
}
