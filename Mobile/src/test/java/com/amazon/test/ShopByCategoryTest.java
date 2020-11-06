package com.amazon.test;

import org.testng.annotations.Test;

import com.amazon.page.LandingPage;
import com.amazon.page.LoginPage;
import com.amazon.page.ShopByCategoryPage;
import com.amazon.page.WelcomePage;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class ShopByCategoryTest extends WebDriverTestCase{
	
	@Test(description=" verify that user is able to navigate through all the products across different categories",enabled=true)//[JIRA] (QEO-14803)
	public void navigate_Product(){
		
		LandingPage land=new LandingPage();
		WelcomePage welcome=new WelcomePage();
		LoginPage login=new LoginPage();
		ShopByCategoryPage shop=new ShopByCategoryPage();
		
		
		land.alreadyCustomer();
		welcome.login();
		welcome.validusername(ConfigurationManager.getBundle().getString("Email"));
		login.validpassword(ConfigurationManager.getBundle().getString("password"));
		shop.shopByMenu();
		shop.productdetails();
		
		shop.goToMenu();
		shop.productlaptopdetails();
	}

}
