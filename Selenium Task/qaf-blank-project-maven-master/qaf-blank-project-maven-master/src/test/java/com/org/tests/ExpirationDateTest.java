package com.org.tests;

import java.util.Map;

import org.testng.annotations.Test;

import com.org.pages.BookFlightPage;
import com.org.pages.ConfirmFlightPage;
import com.org.pages.SelectFlightPage;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class ExpirationDateTest extends WebDriverTestCase{
	
	@QAFDataProvider(key="date.data")
	@Test(description="expiration date data source",enabled=false)//[JIRA] (QEO-14795)
	public void Expiration_Date_Validations(Map<String,String>data){
		
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
		book.fillExpirationDate(data.get("month"), data.get("year"));
		
		ConfirmFlightPage confirm=new ConfirmFlightPage();
		confirm.confirmationPage();
	}
	
	@Test(description="verify pop up message upon changing country from flight selection.",enabled=false)//[JIRA] (QEO-14796)
	public void verifyCountryAlert() {
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
		book.fillCountry(ConfigurationManager.getBundle().getString("DeliveryCountry"),ConfigurationManager.getBundle().getString("expectedmsg"));
	}
	
	@Test(description="verify navigation on back to flights button.",enabled=true)//[JIRA] (QEO-14797)
	public void verifyNavigation() {
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
		book.fillPassenger();
		
		ConfirmFlightPage confirm=new ConfirmFlightPage();
		confirm.FlightFinderPage();
	}
	
	
	
}
