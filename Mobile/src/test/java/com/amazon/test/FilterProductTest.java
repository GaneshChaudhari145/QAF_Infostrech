package com.amazon.test;

import org.testng.annotations.Test;

import com.amazon.page.FilterProductPage;
import com.amazon.page.LandingPage;
import com.amazon.page.LoginPage;
import com.amazon.page.SearchByProductPage;
import com.amazon.page.WelcomePage;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class FilterProductTest extends WebDriverTestCase{
	
	@Test(description="verify that filtering works correctly on the search result page",enabled=true)//[JIRA] (QEO-14807)
	public void filter_Product(){
		LandingPage land=new LandingPage();
		WelcomePage welcome=new WelcomePage();
		LoginPage login=new LoginPage();
		FilterProductPage filter=new FilterProductPage();
		SearchByProductPage search =new SearchByProductPage();
		
		land.alreadyCustomer();
		welcome.login();
		welcome.validusername(ConfigurationManager.getBundle().getString("Email"));
		login.validpassword(ConfigurationManager.getBundle().getString("password"));
		login.verificationSearchBox();
		login.searchproduct(ConfigurationManager.getBundle().getString("Filterproduct"));
		filter.clickFilterButton();
		filter.clickFilter();
		search.FilterProduct();
	}

}
