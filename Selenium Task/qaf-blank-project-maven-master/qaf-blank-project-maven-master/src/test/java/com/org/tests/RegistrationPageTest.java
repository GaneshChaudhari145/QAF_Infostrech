package com.org.tests;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.org.pages.RegistrationPage;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Validator;

public class RegistrationPageTest extends WebDriverTestCase{
	
	@Test(description="verify user registration by filling all valid data.",enabled=false)//[JIRA] (QEO-14788)
	public void RegisterData_ByDataBean(){
		RegistrationPage register=new RegistrationPage();
		register.launchPage(null);
		register.RegisterUser();
		
		Validator.verifyThat(register.welcomeuser(),Matchers.equalTo("Dear Elena Gilbert,"));
		Validator.verifyThat(register.signin(),Matchers.equalTo("Thank you for registering. "
				+ "You may now sign-in using the user name and password you've just entered."));
		
		
		}
}
