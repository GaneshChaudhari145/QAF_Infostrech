package com.org.tests;

import java.util.Map;

import org.testng.annotations.Test;

import com.org.pages.InValidSignInPage;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class InValidSignInPageTest extends WebDriverTestCase{
	
	@QAFDataProvider(key="login.data")
	@Test(description="xml data source")//[JIRA] (QEO-14786)
	public void InvalidCredentials(Map<String,String>data) {
		InValidSignInPage invalid=new InValidSignInPage();
		invalid.launchPage(null);
		invalid.SignIn(data.get("username"), data.get("password"));
	}
	
}
