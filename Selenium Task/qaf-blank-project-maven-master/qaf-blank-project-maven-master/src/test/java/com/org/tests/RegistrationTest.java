package com.org.tests;

import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.org.pages.RegistrationExcelPage;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Validator;

public class RegistrationTest extends WebDriverTestCase{
	
	
	@QAFDataProvider(dataFile="resources/Testdata/XLSTestData.xls",
			sheetName="XLSData",key="XLSDataSP")
	@Test(description="excel file as data provider")//[JIRA] (QEO-14789)
	public void UserRegister_Invalid_Data(Map<String, String>data){
		
		RegistrationExcelPage invalid=new RegistrationExcelPage();
		invalid.launchPage(null);
		invalid.RegisterUser(data.get("firstName"),data.get("lastName"),data.get("phone"),data.get("email"));
		
		Validator.verifyThat(invalid.welcomeuser(),Matchers.equalTo("Dear Elena Gilbert,"));
		Validator.verifyThat(invalid.signin(),Matchers.equalTo("Thank you for registering. "
				+ "You may now sign-in using the user name and password you've just entered."));
		
		
		
	}

}
