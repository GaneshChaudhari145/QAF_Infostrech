package com.org.pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class RegistrationExcelPage extends WebDriverBaseTestPage<WebDriverTestPage>{

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
	
	@FindBy(locator="register.submit.btn")
	private QAFWebElement submitbtn;
	
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
	
	
	public void RegisterUser(String firstName,String lastName,String phone,String email){
		getRegisterlnk().click();
		getfnametxt().sendKeys(firstName);
		getlnametxt().sendKeys(lastName);
		getphonetxt().sendKeys(phone);
		getemailtxt().sendKeys(email);
		
		getsubmitbtn().click();
		Reporter.log("Registered...");
		Reporter.logWithScreenShot("Register Page");
	}
	
	public String welcomeuser() {
		return getWelcomtxt().getText();
	}
	public String signin() {
		return getSigntxt().getText();
	}

}
