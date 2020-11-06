package com.org.tests;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.org.pages.HomePage;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Validator;

public class HomePageTest extends WebDriverTestCase {

	@Test(description="verify different components and links of the homepage.",enabled=false)//[JIRA] (QEO-14783)
	public void testHomePage() {

		HomePage home=new HomePage();
		home.launchPage(null);
		home.waitForPageToLoad();
		

		Validator.verifyThat(home.verifyHomeLink(), Matchers.equalTo(true));
		
		Validator.verifyThat(home.verifyFlightsLink(), Matchers.equalTo(true));
		
		Validator.verifyThat(home.verifyHotelsLink(), Matchers.equalTo(true));
		
		Validator.verifyThat(home.verifyCarLink(), Matchers.equalTo(true));
		
		Validator.verifyThat(home.verifyCruisesLink(), Matchers.equalTo(true));
		
		Validator.verifyThat(home.verifyDestinationsLink(), Matchers.equalTo(true));
		
		Validator.verifyThat(home.verifyVacationsLink(), Matchers.equalTo(true));
		
		Validator.verifyThat(home.verifySignOnLink(), Matchers.equalTo(true));
		
		Validator.verifyThat(home.verifyRegisterLink(), Matchers.equalTo(true));
		
		Validator.verifyThat(home.verifySupportLink(), Matchers.equalTo(true));
		
		Validator.verifyThat(home.verifyContactLink(), Matchers.equalTo(true));
		
		Validator.verifyThat(home.verifyFindFlight(), Matchers.equalTo(true));
		
		Validator.verifyThat(home.verifySpecial(), Matchers.equalTo(true));
		
		Validator.verifyThat(home.verifyTourtips(), Matchers.equalTo(true));
		
	}

}
