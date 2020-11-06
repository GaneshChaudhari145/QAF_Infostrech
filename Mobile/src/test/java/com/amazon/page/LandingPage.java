package com.amazon.page;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class LandingPage extends WebDriverBaseTestPage<WebDriverTestPage>{
	
	@FindBy(locator = "SkipSignIn.landing.btn")
	private QAFWebElement SkipSignInbtn;
	
	@FindBy(locator = "AlreadyCustomer.landing.btn")
	private QAFWebElement alreadyCustomerbtn;
	

	public QAFWebElement getSkipSignInbtn() {return SkipSignInbtn;}
	
	public QAFWebElement getAlreadyCustomerbtn() {return alreadyCustomerbtn;}


	@QAFTestStep(description="click skip sign in button")
	public void skipSignIn() {
		getSkipSignInbtn().waitForPresent();
		Reporter.logWithScreenShot("Skip Sign In Button");
		getSkipSignInbtn().click();
	}

	@QAFTestStep(description="click alrady customer button")
	public void alreadyCustomer() {
		getAlreadyCustomerbtn().waitForPresent();
		Reporter.logWithScreenShot("Click on Alrady Customer Button");
		getAlreadyCustomerbtn().click();
	}
	
	@Override
	protected void openPage(PageLocator locator, Object... args) {
	}

}
