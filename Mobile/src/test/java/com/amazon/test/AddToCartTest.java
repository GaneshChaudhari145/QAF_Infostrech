package com.amazon.test;

import org.testng.annotations.Test;

import com.amazon.page.AddToCartPage;
import com.amazon.page.LandingPage;
import com.amazon.page.LoginPage;
import com.amazon.page.ShopByCategoryPage;
import com.amazon.page.WelcomePage;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class AddToCartTest extends WebDriverTestCase{
	
	@Test(description=" verify that user can add to cart one or more products",enabled=true)//[JIRA] (QEO-14808)
	public void add_to_cart(){
		LandingPage land=new LandingPage();
		WelcomePage welcome=new WelcomePage();
		LoginPage login=new LoginPage();
		ShopByCategoryPage shop=new ShopByCategoryPage();
		AddToCartPage add=new AddToCartPage();
		
		land.alreadyCustomer();
		welcome.login();
		welcome.validusername(ConfigurationManager.getBundle().getString("Email"));
		login.validpassword(ConfigurationManager.getBundle().getString("password"));
		
		shop.addItems();
		add.verifyCartPage();
		
		//for 2nd product
		shop.goToMenuForSecondFilter();
		add.verifyCartPage();
	}
}
