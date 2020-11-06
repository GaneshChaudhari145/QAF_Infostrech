package com.org.pages;



import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class HomePage extends WebDriverBaseTestPage<WebDriverTestPage>{

	@FindBy(locator = "homepage.home.lnk")
	private QAFWebElement Homelnk;

	@FindBy(locator = "homepage.flights.lnk")
	private QAFWebElement Flightslnk;

	@FindBy(locator = "homepage.hotels.lnk")
	private QAFWebElement Hotelslnk;

	@FindBy(locator = "homepage.carrentals.lnk")
	private QAFWebElement CarRentalslnk;

	@FindBy(locator = "homepage.cruises.lnk")
	private QAFWebElement Cruiseslnk;

	@FindBy(locator = "homepage.destinations.lnk")
	private QAFWebElement Destinationslnk;

	@FindBy(locator = "homepage.vacations.lnk")
	private QAFWebElement Vacationslnk;

	@FindBy(locator = "homepage.signon.lnk")
	private QAFWebElement SignOnlnk;

	@FindBy(locator = "homepage.register.lnk")
	private QAFWebElement Registerlnk;

	@FindBy(locator = "homepage.support.lnk")
	private QAFWebElement Supportlnk;

	@FindBy(locator = "homepage.contact.lnk")
	private QAFWebElement Contactlnk;


	@FindBy(locator = "homepage.special.img")
	private QAFWebElement Specialimg;

	@FindBy(locator = "homepage.findFlight.img")
	private QAFWebElement FindFlightimg;

	@FindBy(locator = "homepage.tourtips.img")
	private QAFWebElement Tourtipsimg;

	@FindBy(locator="homepage.username.txt")
	private QAFWebElement userNametxt;

	@FindBy(locator="homepage.password.txt")
	private QAFWebElement passwordtxt;

	@FindBy(locator="homepage.login.btn")
	private QAFWebElement loginbtn;
	
	@FindBy(locator="findflightpage.flight.img")
	private QAFWebElement findFlightimg;

	public QAFWebElement getHomelnk() {
		return Homelnk;
	}
	public QAFWebElement getFlightslnk() {
		return Flightslnk;
	}

	public QAFWebElement getHotelslnk() {
		return Hotelslnk;
	}
	public QAFWebElement getCarRentalslnk() {
		return CarRentalslnk;
	}
	public QAFWebElement getCruiseslnk() {
		return Cruiseslnk;
	}
	public QAFWebElement getDestinationslnk() {
		return Destinationslnk;
	}
	public QAFWebElement getVacationslnk() {
		return Vacationslnk;
	}
	public QAFWebElement getSignOnlnk() {
		return SignOnlnk;
	}
	public QAFWebElement getRegisterlnk() {
		return Registerlnk;
	}
	public QAFWebElement getSupportlnk() {
		return Supportlnk;
	}
	public QAFWebElement getContactlnk() {
		return Contactlnk;
	}

	public QAFWebElement getSpecialimg() {
		return Specialimg;
	}
	public QAFWebElement getFindFlightimg() {
		return FindFlightimg;
	}
	public QAFWebElement getTourtipsimg() {
		return Tourtipsimg;
	}

	public QAFWebElement getUserNametxt() {
		return userNametxt;
	}
	public QAFWebElement getPasswordtxt() {
		return passwordtxt;
	}

	public QAFWebElement getLoginbtn() {
		return loginbtn;
	}
	
	public QAFWebElement getfindFlightimg() {
		return findFlightimg;
	}

	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		driver.get("/");
		driver.manage().window().maximize();
	}

	

	public boolean verifyHomeLink() {
		Reporter.log("Home Link is Displayed");
		Reporter.logWithScreenShot("Home Link");
		return  Homelnk.isDisplayed();

	}
	@Override
	public void waitForPageToLoad() {
		Homelnk.waitForPresent();
	}
	public String verifyHomePage() {
		Reporter.log("Home Page Title is Displayed");
		return driver.getTitle();
	}

	public boolean verifyFlightsLink() {
		Reporter.log("Flights Link is Displayed");
		Reporter.logWithScreenShot("Flights Link");
		return  Flightslnk.isDisplayed();
	}
	public boolean verifyHotelsLink() {
		Reporter.log("Hotels Link is Displayed");
		Reporter.logWithScreenShot("Hotels Link");
		return  Hotelslnk.isDisplayed();
	}

	public boolean verifyCarLink() {
		Reporter.log("Car Link is Displayed");
		Reporter.logWithScreenShot("Car Link");
		return  CarRentalslnk.isDisplayed();
	}
	public boolean verifyCruisesLink() {
		Reporter.log("Cruises Link is Displayed");
		Reporter.logWithScreenShot("Cruises Link");
		return  Cruiseslnk.isDisplayed();
	}

	public boolean verifyDestinationsLink() {
		Reporter.log("Destinations Link is Displayed");
		Reporter.logWithScreenShot("Destinations Link");
		return  Destinationslnk.isDisplayed();
	}

	public boolean verifyVacationsLink() {
		Reporter.log("Vacations Link is Displayed");
		Reporter.logWithScreenShot("Vacations Link");
		return  Vacationslnk.isDisplayed();
	}

	public boolean verifySignOnLink() {
		Reporter.log("SignOn Link is Displayed");
		Reporter.logWithScreenShot("SignOn Link");
		return  SignOnlnk.isDisplayed();
	}
	public boolean verifyRegisterLink() {
		Reporter.log("Register Link is Displayed");
		Reporter.logWithScreenShot("Register Link");
		return  Registerlnk.isDisplayed();
	}
	public boolean verifySupportLink() {
		Reporter.log("Support Link is Displayed");
		Reporter.logWithScreenShot("Support Link");
		return  Supportlnk.isDisplayed();
	}
	public boolean verifyContactLink() {
		Reporter.log("Contact Link is Displayed");
		Reporter.logWithScreenShot("Contact Link");
		return  Contactlnk.isDisplayed();
	}


	public boolean verifyFindFlight() {
		Reporter.log("FindFlight Img is Displayed");
		Reporter.logWithScreenShot("FindFlight Link");
		return FindFlightimg.isPresent();
	}
	public boolean verifySpecial() {
		Reporter.log("Special Img is Displayed");
		Reporter.logWithScreenShot("Special Link");
		return Specialimg.isPresent();
	}
	public boolean verifyTourtips() {
		Reporter.log("Tourtips Img is Displayed");
		Reporter.logWithScreenShot("Tourtips Link");
		return Tourtipsimg.verifyPresent();
	}

	public void SignIn(String username,String password) {
		getUserNametxt().waitForPresent();
		getUserNametxt().sendKeys(username);
		getPasswordtxt().sendKeys(password);
		getLoginbtn().click();
		getfindFlightimg().waitForPresent();
		getfindFlightimg().assertPresent();
	}


	public void closeAll() {
		driver.close();
	}

}
