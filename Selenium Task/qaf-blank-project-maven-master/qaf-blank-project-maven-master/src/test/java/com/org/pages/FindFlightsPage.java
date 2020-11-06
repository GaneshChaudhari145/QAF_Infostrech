package com.org.pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class FindFlightsPage extends WebDriverBaseTestPage<WebDriverTestPage>{
	
	@FindBy(locator="findflightspage.username.txt")
	private QAFWebElement userNametxt;
	
	@FindBy(locator="findflightspage.password.txt")
	private QAFWebElement passwordtxt;
	
	@FindBy(locator="findflightspage.login.btn")
	private QAFWebElement loginbtn;
	
	@FindBy(locator="findflightspage.flight.img")
	private QAFWebElement findFlightimg;
	
	@FindBy(locator="findflightspage.continue.btn")
	private QAFWebElement continuebtn;
	
	@FindBy(locator="selectflightspage.continue.btn")
	private QAFWebElement selectFlightsContinuebtn;
	
	@FindBy(locator="bookflightpage.securepurchase.btn")
	private QAFWebElement securePurchasebtn;
	
	@FindBy(locator="confirmationpage.logout.img")
	private QAFWebElement logoutbtn;
	
	@FindBy(locator="signonpage.signon.img")
	private QAFWebElement SignOnimg;
	
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
	
	public QAFWebElement getContinuebtn() {
		return continuebtn;
	}
	
	public QAFWebElement getSelectFlightsbtn() {
		return selectFlightsContinuebtn;
	}
	
	public QAFWebElement getSecurePurchasebtn() {
		return securePurchasebtn;
	}
	
	public QAFWebElement getLogoutbtn() {
		return logoutbtn;
	}
	
	public QAFWebElement getSignOnimg() {
		return SignOnimg;
	}
	
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		driver.get("/");
		driver.manage().window().maximize();
		
	}
	
	public void SignIn(String username,String password) {
		userNametxt.waitForPresent();
		getUserNametxt().sendKeys(username);
		getPasswordtxt().sendKeys(password);
		getLoginbtn().click();
		findFlightimg.waitForPresent();
		findFlightimg.assertPresent();
	}
	
	public boolean FlightDetils() {
		continuebtn.isDisplayed();
		getContinuebtn().click();
		Reporter.log("Clicked on Continue Button on Flight Page.");
		return true;
	}
	
	public boolean SelectFilght() {
		selectFlightsContinuebtn.isDisplayed();
		getSelectFlightsbtn().click();
		Reporter.log("Clicked on Continue Button on Select Flight Page.");
		return  true;
	}
	
	public boolean bookFlight() {
		securePurchasebtn.waitForPresent();
		getSecurePurchasebtn().click();
		Reporter.log("Clicked on Secure Purchase Button on Book Flight Page.");
		return true;
	}
	
	public void Logout() {
		logoutbtn.waitForPresent();
		getLogoutbtn().isDisplayed();
		getLogoutbtn().click();
		Reporter.log("Clicked on Log Out Button on Flight Confirmation Page.");
		getSignOnimg().isPresent();
		Reporter.log("Sign On Page  is Displayed");
		Reporter.logWithScreenShot("Sign On Page");
		getSignOnimg().waitForPresent();
		getSignOnimg().assertPresent();
	}
	
	
	public void closeAll() {
		driver.close();
	}

}
