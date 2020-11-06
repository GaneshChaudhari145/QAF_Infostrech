package com.org.pages;



import java.util.List;

import org.hamcrest.Matchers;

import com.org.beans.FlightDataBean;
import com.org.components.SelectFlightComponent;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;

public class SelectFlightPage extends WebDriverBaseTestPage<WebDriverTestPage>{


	@FindBy(locator="bookflight.username.txt")
	private QAFWebElement userNametxt;

	@FindBy(locator="bookflight.password.txt")
	private QAFWebElement passwordtxt;

	@FindBy(locator="bookflight.login.btn")
	private QAFWebElement loginbtn;

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

	@FindBy(locator="bookflight.continue.btn")
	private QAFWebElement continuebtn;
	
	@FindBy(locator="bookflight.departlocation.lbl")
	private QAFWebElement departlocationlbl;
	
	@FindBy(locator="bookflight.returnlocation.lbl")
	private QAFWebElement returnlocationlbl;
	
	
	@FindBy(locator="bookflight.flightrow.row")
	private List<SelectFlightComponent> flightname;
	
	public List<SelectFlightComponent> getFlightList() { 	return flightname;}
	
	
	@FindBy(locator="bookflight.selectflight.contbtn")
	private QAFWebElement selectflightbtn;

	public QAFWebElement getUserNametxt() {
		return userNametxt;
	}
	public QAFWebElement getPasswordtxt() {
		return passwordtxt;
	}

	public QAFWebElement getLoginbtn() {
		return loginbtn;
	}

	public QAFWebElement getPassengers() {
		return passengers;
	}
	public QAFWebElement getDeptFrom() {
		return DeptFrom;
	}
	public QAFWebElement getFromMonth() {
		return FromMonth;
	}
	public QAFWebElement getFromday() {
		return Fromday;
	}
	public QAFWebElement getArrive() {
		return Arrive;
	}
	public QAFWebElement getToMonth() {
		return toMonth;
	}
	public QAFWebElement getToday() {
		return today;
	}
	public QAFWebElement getcontinuebtn() {
		return continuebtn;
	}
	
	public QAFWebElement getSelectFlightContbtn() {
		return selectflightbtn;
	}
	
	public QAFWebElement getDepartLocationlbl() {
		return departlocationlbl;
	}
	
	public QAFWebElement getReturnLocationlbl() {
		return returnlocationlbl;
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		driver.get("/");
		driver.manage().window().maximize();

	}
	

	public void SignIn(String username,String password) {
		getUserNametxt().sendKeys(username);
		getPasswordtxt().sendKeys(password);
		getLoginbtn().click();
	}

	public void flight_finder(){
		FlightDataBean fbean=new FlightDataBean();
		Reporter.log("Flight Finder");

		fbean.fillFromConfig("data.register.user");
		fbean.fillUiElements();
		Reporter.logWithScreenShot("Flight Finder Page");
		getcontinuebtn().click();

	}
	
	public void GetDepartFlight(String dept_flight,String ret_flight){
		List<SelectFlightComponent> flights=getFlightList();
		for(SelectFlightComponent lists: flights)
		{
			if(lists.getFlightName().getText().contains(dept_flight)) {
				String radiobtn=lists.getRadiobtn().getAttribute("value");
				if(radiobtn.contains(dept_flight))
				{	
					lists.getRadiobtn().click();
				}
			}
			if(lists.getReturnflightName().getText().contains(ret_flight)) {
				String radiobtn=lists.getReturnRadiobtn().getAttribute("value");
				if(radiobtn.contains(ret_flight))
				{	
					lists.getReturnRadiobtn().click();
				}
			}
		}
		Reporter.logWithScreenShot("Book Flight Page");
		getSelectFlightContbtn().click();
	}
	public String pageTitle() {
		return driver.getTitle();
	}
	
	@QAFTestStep(description="verify flight location")
	public void FlightLocationDetails() {
		
		Validator.verifyThat(pageTitle(),Matchers.equalTo(ConfigurationManager.getBundle().getString("SelectFlightPageTitle")));
		
		String Location = ConfigurationManager.getBundle().getString("SameTravelLocation");
		String travel=Location +" to "+ Location;
		
		Validator.verifyTrue(getDepartLocationlbl().getText().equals(travel), "Depart Location not match", "Depart Location match");
		
		Validator.verifyTrue(getReturnLocationlbl().getText().equals(travel), "Return Location not match", "Return Location match");
	
	}
	
	@QAFTestStep(description="verify flight dates")
	public void FlightDateDetails() {
		
		Validator.verifyThat(pageTitle(),Matchers.equalTo(ConfigurationManager.getBundle().getString("SelectFlightPageTitle")));
	}
	
}
