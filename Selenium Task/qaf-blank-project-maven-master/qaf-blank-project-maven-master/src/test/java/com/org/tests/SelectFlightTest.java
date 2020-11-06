package com.org.tests;

import org.testng.annotations.Test;

import com.org.pages.FlightFinderPage;
import com.org.pages.SelectFlightPage;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class SelectFlightTest extends WebDriverTestCase{
	
	@Test(description="user should be able to continue to next page after selected same locations on arrival and departure.",enabled=false)//[JIRA] (QEO-14791)
	public void Select_Flight(){
		
		String	username=ConfigurationManager.getBundle().getString("valid.username");
		String password=ConfigurationManager.getBundle().getString("valid.password");
		
		SelectFlightPage select =new SelectFlightPage();
		select.launchPage(null);
		select.SignIn(username, password);
		
		FlightFinderPage findflight =new FlightFinderPage();
		findflight.fillFlightDetails();
		
		select.FlightLocationDetails();
		
	}
}
