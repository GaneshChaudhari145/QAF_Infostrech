package com.org.tests;

import java.util.Map;

import org.testng.annotations.Test;

import com.org.pages.BookFlightPage;
import com.org.pages.ConfirmFlightPage;
import com.org.pages.SelectFlightPage;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class CardValidationsTest extends WebDriverTestCase{

	@QAFDataProvider(dataFile="resources/Testdata/XLSTestData.xls",
			sheetName="CardNumber",key="ccNumber")
	@Test(description="check validations for card number field.",enabled=false)//[JIRA] (QEO-14794)
	public void Excess_Card_Validations(Map<String, String>data){

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
		boolean cardnumber=book.fillCardDetails(data.get("cardNumber"));
		if(cardnumber) {

			ConfirmFlightPage confirm=new ConfirmFlightPage();
			confirm.confirmationPage();
		}
	}

}
