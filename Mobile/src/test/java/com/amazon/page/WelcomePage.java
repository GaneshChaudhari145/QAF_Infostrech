package com.amazon.page;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;

public class WelcomePage extends WebDriverBaseTestPage<WebDriverTestPage>{
	
	@FindBy(locator = "Create.Welcome.radio")
	private QAFWebElement Createradio;
	
	@FindBy(locator = "Login.Welcome.radio")
	private QAFWebElement Loginradio;
	
	@FindBy(locator = "Welcome.Mobile.txt")
	private QAFWebElement Mobiletxt;
	
	@FindBy(locator = "Welcome.Continue.button")
	private QAFWebElement Continuebtn;
	
	@FindBy(locator = "Welcome.Name.txt")
	private QAFWebElement Nametxt;
	
	@FindBy(locator = "Welcome.createmobile.txt")
	private QAFWebElement createmobiletxt;
	
	@FindBy(locator = "Welcome.createemail.txt")
	private QAFWebElement createemailtxt;
	
	@FindBy(locator = "Welcome.createpassword.txt")
	private QAFWebElement createpasswordtxt;
	
	@FindBy(locator = "Welcome.showpassword.checkbox")
	private QAFWebElement showpasswordcbx;
	
	@FindBy(locator = "Welcome.verifymobile.button")
	private QAFWebElement verifymobilebtn;
	
	@FindBy(locator = "Welcome.verifytext.label")
	private QAFWebElement verifytextlbl;
	
	@FindBy(locator = "Welcome.OTP.txt")
	private QAFWebElement OTPtext;
	
	@FindBy(locator = "Welcome.verifyOTP.button")
	private QAFWebElement verifyOTPbtn;
	
	@FindBy(locator = "Welcome.message.lbl")
	private QAFWebElement messagelbl;
	
	@FindBy(locator = "Welcome.mobilemessage.lbl")
	private QAFWebElement mobilemessagelbl;
	
	
	public QAFWebElement getVerifytextlbl() {return verifytextlbl;}

	public QAFWebElement getOTPtext() {	return OTPtext;	}

	public QAFWebElement getVerifyOTPbtn() {return verifyOTPbtn;}

	public QAFWebElement getCreateradio() {	return Createradio;	}

	public QAFWebElement getLoginradio() {return Loginradio;}

	public QAFWebElement getMobiletxt() {return Mobiletxt;}

	public QAFWebElement getContinuebtn() {	return Continuebtn;	}
	
	
	public QAFWebElement getNametxt() {	return Nametxt;	}

	public QAFWebElement getCreatemobiletxt() {	return createmobiletxt;	}

	public QAFWebElement getCreateemailtxt() {return createemailtxt;}

	public QAFWebElement getCreatepasswordtxt() {return createpasswordtxt;}

	public QAFWebElement getShowpasswordcbx() {return showpasswordcbx;}

	public QAFWebElement getVerifymobilebtn() {return verifymobilebtn;}
	
	public QAFWebElement getMessagelbl() {return messagelbl;}
	
	public QAFWebElement getMobileMessagelbl() {return mobilemessagelbl;}

	@QAFTestStep(description="select create an account option")
	public void createAccount() {
		getCreateradio().waitForPresent();
		getCreateradio().click();
		Reporter.logWithScreenShot("Click Create an account Radio Button");
	}

	@QAFTestStep(description="enter user details into all fields")
	public void FillUserdata(String name,String mobile,String password){
		getNametxt().isDisplayed();
		getCreatemobiletxt().isDisplayed();
		getCreateemailtxt().isDisplayed();
		getCreatepasswordtxt().isDisplayed();
		
		
		getNametxt().sendKeys(name);
		Reporter.log("User Name:"+name);
		getCreatemobiletxt().sendKeys(mobile);
		Reporter.log("User Mobile Number:"+mobile);
		getCreatepasswordtxt().sendKeys(password);
		Reporter.log("User Password:"+password);
		
		driver.navigate().back();
		Reporter.logWithScreenShot("Fill with User Data");
	
		getVerifymobilebtn().click();
	}

	@QAFTestStep(description="verification of mobile number")
	public void verifyMobileNumber() {
		getVerifytextlbl().isDisplayed();
		getVerifyOTPbtn().isDisplayed();
		getOTPtext().isDisplayed();
		Reporter.log("Verification of Mobile Number Page");
		Reporter.logWithScreenShot("Verification of Mobile Number Page");
	}
	
	@QAFTestStep(description="verification of important message!")
	public void verifyMessage() {
		
		String actualimpmsg=getMessagelbl().getText().trim()+getMobileMessagelbl().getText();
		String expectedimpmsg=ConfigurationManager.getBundle().getString("ImportantMessage")+"+91"+ConfigurationManager.getBundle().getString("MessageMobileNumber");
		Validator.verifyTrue(actualimpmsg.equals(expectedimpmsg), "Wrong Message!", "Important Message! Matched");
		Reporter.log(actualimpmsg);
		Reporter.log("Message Page");
		Reporter.logWithScreenShot("Important Message Page!");
	}
	
	@QAFTestStep(description="select login option")
	public void login() {
		getLoginradio().waitForPresent();
		getLoginradio().click();
		Reporter.logWithScreenShot("Click Login Radio Button");
	}
	
	@QAFTestStep(description="enter valid user name")
	public void validusername(String username) {
		getMobiletxt().waitForPresent();
		getMobiletxt().sendKeys(username);
		Reporter.log("Valid Email:"+username);
		Reporter.logWithScreenShot("Valid Email");
		getContinuebtn().click();
	}
	
	@Override
	protected void openPage(PageLocator locator, Object... args) {
	}

}
