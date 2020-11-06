package com.org.pages;

import org.openqa.selenium.support.ui.Select;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class FlightFinderPage extends WebDriverBaseTestPage<WebDriverTestPage>{

	
	@FindBy(locator="bookflight.passengers.dd")
	private QAFWebElement passengers;
	
	@FindBy(locator="bookflight.deptfrom.dd")
	private QAFWebElement DeptFrom;

	@FindBy(locator="bookflight.frommonth.dd")
	private QAFWebElement FromMonth;
	
	@FindBy(locator="bookflight.fromday.dd")
	private QAFWebElement Fromday;
	
	@FindBy(locator="bookflight.arrive.dd")
	private QAFWebElement Arrive;

	@FindBy(locator="bookflight.tomonth.dd")
	private QAFWebElement toMonth;

	@FindBy(locator="bookflight.today.dd")
	private QAFWebElement today;
	
	@FindBy(locator="bookFlight.continue.btn")
	private QAFWebElement continuebtn;
	
	
	public QAFWebElement getPassengers() {	return passengers;	}
	
	public QAFWebElement getDeptFrom() {	return DeptFrom;}
	
	public QAFWebElement getFromMonth() {	return FromMonth;}
	
	public QAFWebElement getFromday() {	return Fromday;	}
	
	public QAFWebElement getArrive() {	return Arrive;	}
	
	public QAFWebElement getToMonth() {	return toMonth;	}
	
	public QAFWebElement getToday() {	return today;	}
	
	public QAFWebElement getcontinuebtn() {		return continuebtn;	}
	
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		driver.get("/");
		driver.manage().window().maximize();

	}
	
	
	@QAFTestStep(description="fill passengers details")
	public void fillFlightDetails() {
		
		Selectoption(getPassengers(), ConfigurationManager.getBundle().getString("SummaryPassengers"));
		Selectoption(getDeptFrom(), ConfigurationManager.getBundle().getString("SameTravelLocation"));
		Selectoption(getFromMonth(), ConfigurationManager.getBundle().getString("DepartMonth"));
		Selectoption(getFromday(), ConfigurationManager.getBundle().getString("DepartDate"));
		Selectoption(getArrive(), ConfigurationManager.getBundle().getString("SameTravelLocation"));
		Selectoption(getToMonth(), ConfigurationManager.getBundle().getString("ReturnMonth"));
		Selectoption(getToday(), ConfigurationManager.getBundle().getString("ReturnDate"));
		
		Reporter.logWithScreenShot("Flight Finder Page");
		getcontinuebtn().click();
		
	}
	public void Selectoption(QAFWebElement element,String value) {
		Select select=new Select(element);
		select.selectByVisibleText(value);
	}
	@QAFTestStep(description="fill flight date details")
	public void fillFlightDateDetails(String DepartMonth,String DepartDate,String ReturnMonth,String ReturnDate) {
	
		Selectoption(getFromMonth(),DepartMonth);
		Selectoption(getFromday(),DepartDate);
		Selectoption(getToMonth(),ReturnMonth);
		Selectoption(getToday(), ReturnDate);
		
		Reporter.logWithScreenShot("Flight Finder Page");
		getcontinuebtn().click();
	}
}
