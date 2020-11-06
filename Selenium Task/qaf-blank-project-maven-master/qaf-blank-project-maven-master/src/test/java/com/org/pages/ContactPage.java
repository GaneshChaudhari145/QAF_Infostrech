package com.org.pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class ContactPage extends WebDriverBaseTestPage<WebDriverTestPage>{
	
	@FindBy(locator = "contactpage.contact.lnk")
	private QAFWebElement Contactlnk;
	
	@FindBy(locator = "contactpage.construction.txt")
	private QAFWebElement constructiontxt;
	
	@FindBy(locator = "contactpage.backtohome.btn")
	private QAFWebElement backtohomebtn;

	public QAFWebElement getContactlnk() {
		return Contactlnk;
	}
	
	public QAFWebElement getConstructiontxt() {
		return constructiontxt;
	}
	
	public QAFWebElement getBackToHomebtn() {
		return backtohomebtn;
	}
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		driver.get("/");
		driver.manage().window().maximize();
	}

	
	public String contact() {
		getContactlnk().waitForPresent();
		getContactlnk().isDisplayed();
		getContactlnk().click();
		Reporter.log("Clicked on Contact Link on Home Page.");
		Reporter.logWithScreenShot("Contact Link on Home Page");
		
		getConstructiontxt().waitForPresent();
		getConstructiontxt().assertPresent();
		
		getBackToHomebtn().verifyVisible();
		getBackToHomebtn().assertVisible();
		getBackToHomebtn().waitForPresent();
		getBackToHomebtn().click();
		Reporter.log("Clicked on Back To Home Button on Contact Page.");
		Reporter.logWithScreenShot("Back To Home Button on Contact Page");
		String title=driver.getTitle();
		return title;
	}
	public void closeAll() {
		driver.close();
	}
}
