package com.org.tests;

import java.util.Map;

import org.testng.annotations.Test;

import com.org.pages.FlightFinderPage;
import com.org.pages.SelectFlightPage;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class FlightDateTest extends WebDriverTestCase{

	@QAFDataProvider(dataFile="resources/Testdata/XLSDateData.xls",
			sheetName="DateData",key="XLSDataSP")
	@Test(description="excel file use for date as data provider")//[JIRA] (QEO-14792)
	
	public void verify_Date_Validations(Map<String, String>data){

		String	username=ConfigurationManager.getBundle().getString("valid.username");
		String password=ConfigurationManager.getBundle().getString("valid.password");

		SelectFlightPage select =new SelectFlightPage();
		select.launchPage(null);
		select.SignIn(username, password);
		
		FlightFinderPage findflight =new FlightFinderPage();
		findflight.fillFlightDateDetails(data.get("DepartMonth"),data.get("DepartDate"),data.get("ReturnMonth"),data.get("ReturnDate"));
		
		select.FlightDateDetails();
		
		
		
	}

}
