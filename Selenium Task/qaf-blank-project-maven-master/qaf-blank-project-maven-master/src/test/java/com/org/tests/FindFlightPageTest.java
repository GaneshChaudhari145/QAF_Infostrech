package com.org.tests;

import org.testng.annotations.Test;

import com.org.pages.FindFlightsPage;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class FindFlightPageTest extends WebDriverTestCase{
	
	@Test(description="verify the navigation on log out button.",enabled=false)//[JIRA] (QEO-14785)
	public void LogOut() {
		String	username=ConfigurationManager.getBundle().getString("valid.username");
		String password=ConfigurationManager.getBundle().getString("valid.password");
		
		FindFlightsPage flights =new FindFlightsPage();
		flights.launchPage(null);
	
		flights.SignIn(username, password);
		
		flights.FlightDetils();
		flights.SelectFilght();
		flights.bookFlight();
		flights.Logout();
		flights.closeAll();
	}

}
