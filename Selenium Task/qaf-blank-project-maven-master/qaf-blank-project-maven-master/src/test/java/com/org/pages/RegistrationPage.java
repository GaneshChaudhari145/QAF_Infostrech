package com.org.pages;

import com.org.beans.RegisterDataBean;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class RegistrationPage extends WebDriverBaseTestPage<WebDriverTestPage>{
	
	@FindBy(locator="register.register.lnk")
	private QAFWebElement registerlnk;
	
	@FindBy(locator="register.fname.txt")
	private QAFWebElement fnametxt;
	
	@FindBy(locator="register.lname.txt")
	private QAFWebElement lnametxt;
	
	@FindBy(locator="register.phone.txt")
	private QAFWebElement phonetxt;
	
	@FindBy(locator="register.email.txt")
	private QAFWebElement emailtxt;
	
	@FindBy(locator="register.address.txt")
	private QAFWebElement addresstxt;
	
	@FindBy(locator="register.city.txt")
	private QAFWebElement citytxt;
	
	@FindBy(locator="register.state.txt")
	private QAFWebElement statetxt;
	
	@FindBy(locator="register.pincode.txt")
	private QAFWebElement pincodetxt;
	
	@FindBy(locator="register.username.txt")
	private QAFWebElement usernametxt;
	
	@FindBy(locator="register.password.txt")
	private QAFWebElement passwordtxt;
	
	
	@FindBy(locator="register.submit.btn")
	private QAFWebElement submitbtn;
	
	@FindBy(locator="register.country.dd")
	private QAFWebElement countrydd;
	
	@FindBy(locator="register.welcome.text")
	private QAFWebElement welcometxt;
	
	@FindBy(locator="register.sign.text")
	private QAFWebElement signtxt;
	

	public QAFWebElement getRegisterlnk() {
		return registerlnk;
	}
	public QAFWebElement getfnametxt() {
		return fnametxt;
	}
	public QAFWebElement getlnametxt() {
		return lnametxt;
	}
	public QAFWebElement getphonetxt() {
		return phonetxt;
	}
	public QAFWebElement getemailtxt() {
		return emailtxt;
	}
	public QAFWebElement getaddresstxt() {
		return addresstxt;
	}
	public QAFWebElement getcitytxt() {
		return citytxt;
	}
	public QAFWebElement getstatetxt() {
		return statetxt;
	}
	public QAFWebElement getpincodetxt() {
		return pincodetxt;
	}
	public QAFWebElement getusernametxt() {
		return usernametxt;
	}
	public QAFWebElement getpasswordtxt() {
		return passwordtxt;
	}
	public QAFWebElement getcountrydd() {
		return countrydd;
	}
	
	public QAFWebElement getsubmitbtn() {
		return submitbtn;
	}
	public QAFWebElement getWelcomtxt() {
		return welcometxt;
	}
	public QAFWebElement getSigntxt() {
		return signtxt;
	}
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		driver.get("/");
		driver.manage().window().maximize();
	}
	
	public void RegisterUser(){
		RegisterDataBean rbean =new RegisterDataBean();
		getRegisterlnk().click();
		rbean.fillFromConfig("data.register.user");
		rbean.fillUiElements();
		getsubmitbtn().click();
		Reporter.log("Registered");
		Reporter.logWithScreenShot("Register Page");
	}
	public String welcomeuser() {
		return getWelcomtxt().getText();
	}
	public String signin() {
		return getSigntxt().getText();
	}
}
