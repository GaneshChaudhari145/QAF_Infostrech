package com.amazon.test;

import org.testng.annotations.Test;

import com.amazon.page.LandingPage;
import com.amazon.page.LoginPage;
import com.amazon.page.SearchByProductPage;
import com.amazon.page.WelcomePage;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class SearchByProductTest extends WebDriverTestCase{
	
	@Test(description="verify that on searching all the product satisfying the search criteria are visible on the search result page",enabled=false)//[JIRA] (QEO-14804)
	public void search_Product(){
		LandingPage land=new LandingPage();
		WelcomePage welcome=new WelcomePage();
		LoginPage login=new LoginPage();
		SearchByProductPage search =new SearchByProductPage();
		
		land.alreadyCustomer();
		welcome.login();
		welcome.validusername(ConfigurationManager.getBundle().getString("Email"));
		login.validpassword(ConfigurationManager.getBundle().getString("password"));
		login.verificationSearchBox();
		login.searchproduct(ConfigurationManager.getBundle().getString("productname"));
		search.VerifyProduct();
	}
	
	@Test(description="verify the more relevant product for the search term are displayed on the top for a particular search term",enabled=true)//[JIRA] (QEO-14805)
	public void relevant_Product(){
		LandingPage land=new LandingPage();
		WelcomePage welcome=new WelcomePage();
		LoginPage login=new LoginPage();
		SearchByProductPage search =new SearchByProductPage();
		
		land.alreadyCustomer();
		welcome.login();
		welcome.validusername(ConfigurationManager.getBundle().getString("Email"));
		login.validpassword(ConfigurationManager.getBundle().getString("password"));
		login.verificationSearchBox();
		login.searchproduct(ConfigurationManager.getBundle().getString("Womensproductname"));
		search.RelevantProduct();
	}
}
