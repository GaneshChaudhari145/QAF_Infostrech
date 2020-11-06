package com.amazon.page;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class LoginPage extends WebDriverBaseTestPage<WebDriverTestPage>{
	
	@FindBy(locator = "Login.Password.txt")
	private QAFWebElement passwordtxt;
	
	@FindBy(locator = "Login.login.btn")
	private QAFWebElement loginbtn;
	
	@FindBy(locator = "Login.shopcategory.menu")
	private QAFWebElement shopcategorylbl;
	
	@FindBy(locator = "Login.search.edittext")
	private QAFWebElement searcheditbox;
	
	@FindBy(locator = "Login.deliverylocation.txt")
	private QAFWebElement deliverylocationtxt;
	
	@FindBy(locator = "Login.filter.dd")
	private QAFWebElement filterdd;
	

	public QAFWebElement getFilterdd() {return filterdd;}

	public QAFWebElement getDeliverylocationtxt() {	return deliverylocationtxt;	}

	public QAFWebElement getSearcheditbox() {return searcheditbox;}

	public QAFWebElement getShopcategorylbl() {	return shopcategorylbl;}

	public QAFWebElement getLoginbtn() {return loginbtn;}

	public QAFWebElement getPasswordtxt() {	return passwordtxt;	}

	@QAFTestStep(description="enter valid password for the entered username.")
	public void validpassword(String password) {
		getPasswordtxt().sendKeys(password);
		Reporter.log("Valid password:"+password);
		Reporter.logWithScreenShot("Valid password");
		getLoginbtn().click();
		Reporter.log("User logged in successfully.");
	}
	
	
	public void verificationHomePage() {
		getShopcategorylbl().waitForPresent();
		getShopcategorylbl().isDisplayed();
		Reporter.log("Shop By Category label is displayed.");
		getSearcheditbox().isDisplayed();
		Reporter.log("Shearch Edit Box is displayed.");
		
		Reporter.log("User land on the Home page.");
	}
	
	public void verificationSearchBox() {
		getSearcheditbox().isDisplayed();
		Reporter.log("Shearch Edit Box is displayed.");
		Reporter.log("User land on the Home page.");
	}
	public void searchproduct(String productname){
		getSearcheditbox().isDisplayed();
		getSearcheditbox().sendKeys(productname);
		Reporter.log("Search Edit Box is displayed.");
		
		new ScrollAction().Enter();
		
		getFilterdd().waitForPresent();
		
		Reporter.log("Search Results is displayed.");
	}
	
	@Override
	protected void openPage(PageLocator locator, Object... args) {
	}

}
