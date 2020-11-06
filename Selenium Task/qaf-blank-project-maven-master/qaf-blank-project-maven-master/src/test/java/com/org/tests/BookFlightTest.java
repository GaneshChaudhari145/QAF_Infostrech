package com.org.tests;

import org.testng.annotations.Test;

import com.org.pages.BookFlightPage;
import com.org.pages.ConfirmFlightPage;
import com.org.pages.SelectFlightPage;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class BookFlightTest extends WebDriverTestCase{
	
	
	@Test(description="verify user is able to book flight with appropriate details with flight type round trip",enabled=false)//[JIRA] (QEO-14790)
	public void Book_Flight(){
		String	username=ConfigurationManager.getBundle().getString("valid.username");
		String password=ConfigurationManager.getBundle().getString("valid.password");
		
		SelectFlightPage select =new SelectFlightPage();
		select.launchPage(null);
		
		select.SignIn(username, password);
		select.flight_finder();
		String	dept_flight=ConfigurationManager.getBundle().getString("dept_flight");
		String ret_flight=ConfigurationManager.getBundle().getString("ret_flight");
		
		select.GetDepartFlight(dept_flight, ret_flight);
		
		BookFlightPage book=new BookFlightPage();
		book.validate_Flight();
		book.fillPassenger();
		
		ConfirmFlightPage confirm=new ConfirmFlightPage();
		confirm.confirmationPage();
	}
}
