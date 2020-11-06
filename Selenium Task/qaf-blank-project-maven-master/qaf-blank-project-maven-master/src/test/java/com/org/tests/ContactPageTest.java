package com.org.tests;

import org.testng.annotations.Test;

import com.org.pages.ContactPage;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Validator;

public class ContactPageTest extends WebDriverTestCase{
	
	@Test(description="clicking 'contact' link on the homepage, verify Under Construction message is displayed",enabled=false)//[JIRA] (QEO-14787)
	public void ContactTest() {
		ContactPage contact=new ContactPage();
		contact.launchPage(null);
		String title= contact.contact();
		Validator.verifyTrue(title.equals("Welcome: Mercury Tours"),"Inavlid Page", "Validated Welcome: Mercury Tours");
		contact.closeAll();
	}

}
