package com.org.pages;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class ConfirmFlightPage extends WebDriverBaseTestPage<WebDriverTestPage>{

	
	@FindBy(locator="confirmflight.confirmationtitle.lbl")
	private QAFWebElement titlelbl;
	
	@FindBy(locator="confirmflight.totalprice.lbl")
	private QAFWebElement totalPricelbl;
	
	@FindBy(locator="confirmflight.logout.btn")
	private QAFWebElement logoutbtn;
	
	@FindBy(locator="confirmflight.deptplace.lbl")
	private QAFWebElement deptPlacelbl;
	
	@FindBy(locator="confirmflight.returnplace.lbl")
	private QAFWebElement returnPlacelbl;
	
	@FindBy(locator="confirmflight.flights.btn")
	private QAFWebElement Flightsbtn;
	
	
	public QAFWebElement getTitlelbl() {return titlelbl;}

	public QAFWebElement getTotalPricelbl() {	return totalPricelbl;}

	public QAFWebElement getLogoutbtn() {	return logoutbtn;	}

	public QAFWebElement getDeptPlacelbl() {	return deptPlacelbl;}

	public QAFWebElement getReturnPlacelbl() {	return returnPlacelbl;	}
	
	public QAFWebElement getFlightsbtn() {	return Flightsbtn;	}

	public String pageTitle() {
		return driver.getTitle();
	}
	
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		driver.get("/");
		driver.manage().window().maximize();

	}
	
	@QAFTestStep(description="flight confirmation page")
	public void confirmationPage() {
		Validator.verifyTrue(getTitlelbl().getText().equals(ConfigurationManager.getBundle().getString("ConfirmationMessage")), "Confirmation message not match", "Confirmation message match");
		Validator.verifyTrue(pageTitle().equals(ConfigurationManager.getBundle().getString("ConfirmationPageTitle")), "Confirmation title not match", "Confirmation title  match");
		Validator.verifyTrue(getDeptPlacelbl().getText().equals(ConfigurationManager.getBundle().getString("OriginToDestination")),"Wrong Place", "Departure Place Matched");
		Validator.verifyTrue(getReturnPlacelbl().getText().equals(ConfigurationManager.getBundle().getString("DestinationToOrigin")), "Wrong Place", "Returned Place Matched");
	}
	
	@QAFTestStep(description="flight finder page")
	public void FlightFinderPage() {
		getFlightsbtn().click();
		Validator.verifyTrue(pageTitle().equals(ConfigurationManager.getBundle().getString("FlightFinderPageTitle")), "Flight Finder Page Title not match", "Flight Finder Page Title match");
	}

}
