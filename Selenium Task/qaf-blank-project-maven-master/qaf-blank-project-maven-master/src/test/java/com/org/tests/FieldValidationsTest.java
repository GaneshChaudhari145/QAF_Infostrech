package com.org.tests;

import java.util.Map;

import org.testng.annotations.Test;

import com.org.pages.BookFlightPage;
import com.org.pages.ConfirmFlightPage;
import com.org.pages.SelectFlightPage;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class FieldValidationsTest extends WebDriverTestCase{
	
	
	@QAFDataProvider(key="name.data")
	@Test(description="XML Data Source")//[JIRA] (QEO-14793)
	public void Flight_Confirmation_invoice(Map<String,String>data){
		
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
		book.fillPassengerName(data.get("FName"), data.get("LName"));
		
		ConfirmFlightPage confirm=new ConfirmFlightPage();
		confirm.confirmationPage();
	}

}
