package com.amazon.test;

import java.util.Map;

import org.testng.annotations.Test;

import com.amazon.page.HomePage;
import com.amazon.page.LandingPage;
import com.amazon.page.WelcomePage;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class LandingPageTest extends WebDriverTestCase{
	
	@QAFDataProvider(key="user.data")
	@Test(description="verify user can register himself by providing correct details",enabled=false)//[JIRA] (QEO-14800)
	public void userRegister(Map<String,String>data){
		LandingPage land=new LandingPage();
		HomePage home =new HomePage();
		WelcomePage welcome=new WelcomePage();
		
		land.skipSignIn();
	
		home.clickmenu();
		welcome.createAccount();
		welcome.FillUserdata(data.get("Name"),data.get("Mobile"),data.get("password"));
		welcome.verifyMobileNumber();
	}
	
	
	@QAFDataProvider(key="Existuser.data")
	@Test(description="registering with existing user",enabled=true)//[JIRA] (QEO-14801)
	public void Existinguser(Map<String,String>data){
		LandingPage land=new LandingPage();
		HomePage home =new HomePage();
		WelcomePage welcome=new WelcomePage();
		
		land.skipSignIn();
	
		home.clickmenu();
		welcome.createAccount();
		welcome.FillUserdata(data.get("Name"),data.get("Mobile"),data.get("password"));
		welcome.verifyMessage();
	}
}
