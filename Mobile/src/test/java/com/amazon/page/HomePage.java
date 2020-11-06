package com.amazon.page;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class HomePage extends WebDriverBaseTestPage<WebDriverTestPage>{

	@FindBy(locator = "home.menu.lnk")
	private QAFWebElement menulnk;
	
	@FindBy(locator = "home.SignIn.option")
	private QAFWebElement HelloSignIn;
	
	@FindBy(locator = "home.home.menu")
	private QAFWebElement homemenu;
	
	@FindBy(locator = "home.shopcategory.menu")
	private QAFWebElement shopcategorymenu;
	
	@FindBy(locator = "home.Todaysdeals.menu")
	private QAFWebElement Todaysdealsmenu;
	
	public QAFWebElement getTodaysdealsmenu() {	return Todaysdealsmenu;	}

	public QAFWebElement getHomemenu() {return homemenu;}

	public QAFWebElement getShopcategorymenu() {return shopcategorymenu;}

	public QAFWebElement getMenulnk() {	return menulnk;}

	public QAFWebElement getHelloSignIn() {	return HelloSignIn;}
	
	@QAFTestStep(description="select 'hello sign in' option")
	public void clickmenu() {
		getMenulnk().waitForPresent();
		getMenulnk().click();
		
		getHelloSignIn().isDisplayed();
		getHomemenu().isDisplayed();
		getShopcategorymenu().isDisplayed();
		getTodaysdealsmenu().isDisplayed();
		
		Reporter.logWithScreenShot("Click 'Hello Sign IN' option");
		getHelloSignIn().click();
	}
	@Override
	protected void openPage(PageLocator locator, Object... args) {
	}

}
