package com.amazon.test;

import org.testng.annotations.Test;

import com.amazon.page.FilterProductPage;
import com.amazon.page.LandingPage;
import com.amazon.page.LoginPage;
import com.amazon.page.WelcomePage;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class SortingProductTest extends WebDriverTestCase{
	
	@Test(description="sorting - verify that sorting works correctly on the search result page",enabled=true)//[JIRA] (QEO-14809)
	public void Sort_Product(){
		LandingPage land=new LandingPage();
		WelcomePage welcome=new WelcomePage();
		LoginPage login=new LoginPage();
		FilterProductPage filter=new FilterProductPage();
		
		land.alreadyCustomer();
		welcome.login();
		welcome.validusername(ConfigurationManager.getBundle().getString("Email"));
		login.validpassword(ConfigurationManager.getBundle().getString("password"));
		login.verificationSearchBox();
		login.searchproduct(ConfigurationManager.getBundle().getString("Filterproduct"));
		filter.clickFilterButton();
		filter.clickSort();
		
	}
}
