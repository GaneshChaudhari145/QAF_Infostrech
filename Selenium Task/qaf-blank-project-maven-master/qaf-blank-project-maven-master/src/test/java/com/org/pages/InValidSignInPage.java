package com.org.pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class InValidSignInPage extends WebDriverBaseTestPage<WebDriverTestPage>{
	
	@FindBy(locator="invalidsigninpage.username.txt")
	private QAFWebElement userNametxt;
	
	@FindBy(locator="invalidsigninpage.password.txt")
	private QAFWebElement passwordtxt;
	
	@FindBy(locator="invalidsigninpage.login.btn")
	private QAFWebElement loginbtn;
	
	@FindBy(locator="invalidsigninpage.signon.img")
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
		Reporter.log("Sign On Page  is Displayed");
		Reporter.logWithScreenShot("Sign On Page");
		SignOnimg.waitForPresent();
		SignOnimg.assertPresent();
	}
}
