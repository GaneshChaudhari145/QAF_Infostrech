package com.org.components;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class SelectFlightComponent extends QAFWebComponent{

	public SelectFlightComponent(String locator) {
		super(locator);
	}
	
	@FindBy(locator="BookFlight.selectflight.btn")
	private QAFWebElement selectFlightbtn;
	
	@FindBy(locator="bookflight.all.rb")
	private QAFWebElement allrb;
	
	@FindBy(locator="bookflight.flight.name")
	private QAFWebElement flightname;
	
	@FindBy(locator="bookflight.returnflight.name")
	private QAFWebElement returnflight;
	
	@FindBy(locator="bookflight.return.rb")
	private QAFWebElement returnrb;
	
	public QAFWebElement getSelectFlightbtn() {
		return selectFlightbtn;
	}
	
	public QAFWebElement getRadiobtn() {
		return allrb;
	}
	
	public QAFWebElement getFlightName() {
		return flightname;
	}
	
	public QAFWebElement getReturnflightName() {
		return returnflight;
	}
	public QAFWebElement getReturnRadiobtn() {
		return returnrb;
	}
}
