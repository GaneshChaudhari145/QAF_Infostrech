package com.org.pages;

import org.hamcrest.Matchers;
import org.openqa.selenium.support.ui.Select;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;

public class BookFlightPage extends WebDriverBaseTestPage<WebDriverTestPage>{

	@FindBy(locator="passenger.firstname.txt")
	private QAFWebElement firstNametxt;

	@FindBy(locator="passenger.lastname.txt")
	private QAFWebElement lastNametxt;

	@FindBy(locator="passenger.creditcard.dd")
	private QAFWebElement creditCarddd;

	@FindBy(locator="passenger.creditnumber.txt")
	private QAFWebElement creditNumbertxt;

	@FindBy(locator="passenger.expirymonth.dd")
	private QAFWebElement expirymonthdd;

	@FindBy(locator="passenger.expiryyear.dd")
	private QAFWebElement expiryyeardd;

	@FindBy(locator="passenger.securepurchase.btn")
	private QAFWebElement SecurePurchasebtn;

	@FindBy(locator="summary.departflightplace.label")
	private QAFWebElement departFlightPlacelbl;

	@FindBy(locator="summary.departflightdate.label")
	private QAFWebElement departFlightDatelbl;

	@FindBy(locator="summary.departflightname.label")
	private QAFWebElement departFlightNamelbl;

	@FindBy(locator="summary.departflightclass.label")
	private QAFWebElement departFlightClasslbl;

	@FindBy(locator="summary.departflightprice.label")
	private QAFWebElement departFlightPricelbl;

	@FindBy(locator="summary.returnflightplace.label")
	private QAFWebElement returnFlightPlacelbl;

	@FindBy(locator="summary.returnflightdate.label")
	private QAFWebElement returnFlightDatelbl;

	@FindBy(locator="summary.returnflightname.label")
	private QAFWebElement returnFlightNamelbl;

	@FindBy(locator="summary.returnflightclass.label")
	private QAFWebElement returnFlightClasslbl;

	@FindBy(locator="summary.returnflightprice.label")
	private QAFWebElement returnFlightPricelbl;

	@FindBy(locator="summary.passengerno.label")
	private QAFWebElement passengernolbl;

	@FindBy(locator="summary.taxes.label")
	private QAFWebElement taxeslbl;

	@FindBy(locator="summary.totalprice.label")
	private QAFWebElement totalPricelbl;

	@FindBy(locator="passenger.deliverycountry.dd")
	private QAFWebElement deliverycountrydd;

	public QAFWebElement getDepartFlightPlacelbl() { return departFlightPlacelbl;}

	public QAFWebElement getDepartFlightDatelbl() {	return departFlightDatelbl;	}

	public QAFWebElement getDepartFlightNamelbl() {	return departFlightNamelbl;	}

	public QAFWebElement getDepartFlightClasslbl() { return departFlightClasslbl;}

	public QAFWebElement getDepartFlightPricelbl() { return departFlightPricelbl; }

	public QAFWebElement getReturnFlightPlacelbl() { return returnFlightPlacelbl; }

	public QAFWebElement getReturnFlightDatelbl() {	return returnFlightDatelbl;	}

	public QAFWebElement getReturnFlightNamelbl() {	return returnFlightNamelbl;	}

	public QAFWebElement getReturnFlightClasslbl() {return returnFlightClasslbl;}

	public QAFWebElement getReturnFlightPricelbl() {return returnFlightPricelbl;	}

	public QAFWebElement getPassengernolbl() {	return passengernolbl;	}

	public QAFWebElement getTaxeslbl() {	return taxeslbl;	}

	public QAFWebElement getTotalPricelbl() {	return totalPricelbl;	}

	public QAFWebElement getFirstNametxt() {return firstNametxt; }

	public QAFWebElement getLastNametxt() {return lastNametxt; }

	public QAFWebElement getCreditCardDD() {return creditCarddd; }

	public QAFWebElement getCreditNumbertxt() {return creditNumbertxt; }

	public QAFWebElement getExpirymonthDD() {return expirymonthdd; }

	public QAFWebElement getExpiryyearDD() {return expiryyeardd; }

	public QAFWebElement getSecurePurchasebtn() {return SecurePurchasebtn; }
	
	public QAFWebElement getDeliveryCountry() {return deliverycountrydd; }


	@Override
	protected void openPage(PageLocator locator, Object... args) {
		driver.get("/");
		driver.manage().window().maximize();

	}

	@QAFTestStep(description="validate book flight")
	public void validate_Flight() {
		Validator.assertTrue(getDepartFlightPlacelbl().getText().equals(ConfigurationManager.getBundle().getString("OriginToDestination")), "Wrong Place", "Departure Place Matched");

		Validator.assertTrue(getDepartFlightDatelbl().getText().equals(ConfigurationManager.getBundle().getString("OriginToDestinationDate")), "Wrong Date", "Date Match");
		Validator.assertTrue(getDepartFlightNamelbl().getText().equals(ConfigurationManager.getBundle().getString("departFlightName")), "Incorrect FlightName", "FlightName Match");
		Validator.assertTrue(getDepartFlightClasslbl().getText().equals(ConfigurationManager.getBundle().getString("SummaryDepartClass")), "Incorrect Class", "Class Match");
		Validator.assertTrue(getDepartFlightPricelbl().getText().equals(ConfigurationManager.getBundle().getString("SummaryDepartPrice")), "Incorrect Price", "Price Match");
		Validator.assertTrue(getReturnFlightPlacelbl().getText().equals(ConfigurationManager.getBundle().getString("DestinationToOrigin")), "Incorrect Origin", "Origin  Place Match");
		Validator.assertTrue(getReturnFlightDatelbl().getText().equals(ConfigurationManager.getBundle().getString("DestinationToOrigindate")), "Wrong Date", "Date Match");
		Validator.assertTrue(getReturnFlightNamelbl().getText().equals(ConfigurationManager.getBundle().getString("returnFlightName")), "Incorrect FlightName", "FlightName Match");
		Validator.assertTrue(getReturnFlightClasslbl().getText().equals(ConfigurationManager.getBundle().getString("SummaryReturnClass")), "Incorrect Class", "Class Match");
		Validator.assertTrue(getReturnFlightPricelbl().getText().equals(ConfigurationManager.getBundle().getString("SummaryReturnPrice")), "Incorrect Price", "Price Match");
		Validator.assertTrue(getPassengernolbl().getText().equals(ConfigurationManager.getBundle().getString("SummaryPassengers")), "Incorrect Passengers", "Passengers Match");
		Validator.assertTrue(getTaxeslbl().getText().equals(ConfigurationManager.getBundle().getString("SummaryTaxes")), "Incorrect Taxe", "Taxe Match");
		Validator.assertTrue(getTotalPricelbl().getText().equals(ConfigurationManager.getBundle().getString("SummaryTotalPricewithTaxes")), "Incorrect Total Price with Taxes", "Total Price with Taxes Match");

	}


	@QAFTestStep(description="fill passengers details")
	public void fillPassenger() {
		getFirstNametxt().sendKeys(ConfigurationManager.getBundle().getString("SummaryFirstName"));
		getLastNametxt().sendKeys(ConfigurationManager.getBundle().getString("SummaryLastName"));
		Selectoption(getCreditCardDD(),ConfigurationManager.getBundle().getString("SummaryCardType"));
		getCreditNumbertxt().sendKeys(ConfigurationManager.getBundle().getString("SummaryNumber"));
		Selectoption(getExpirymonthDD(), ConfigurationManager.getBundle().getString("SummaryExpirationMonth"));
		Selectoption(getExpiryyearDD(), ConfigurationManager.getBundle().getString("SummaryExpirationYear"));

		Reporter.logWithScreenShot("Book Flight Page");
		getSecurePurchasebtn().click();
	}

	public void Selectoption(QAFWebElement element,String value) {
		Select select=new Select(element);
		select.selectByVisibleText(value);
	}

	@QAFTestStep(description="fill passengers name")
	public void fillPassengerName(String FName,String LName) {
		getFirstNametxt().sendKeys(FName);
		getLastNametxt().sendKeys(LName);

		Reporter.logWithScreenShot("Book Flight Page");
		getSecurePurchasebtn().click();
	}

	@QAFTestStep(description="fill card details")
	public boolean fillCardDetails(String cardNumber){

		String maxlength=getCreditNumbertxt().getAttribute("maxlength");
		Reporter.log("Attribute Length is "+maxlength);
		int ccnumber=cardNumber.length();

		Reporter.log("Provided  Length is "+ccnumber);

		if(ccnumber<=Integer.parseInt(maxlength))
		{
			getCreditNumbertxt().sendKeys(cardNumber);
			getSecurePurchasebtn().click();
			return true;
		}
		else
		{
			Validator.verifyFalse(ccnumber<=Integer.parseInt(maxlength), "Credit Card Field accepts more than 16 digits","Credit Card Field accepts only 16 digits");
			return false;
		}
		

	}
	
	@QAFTestStep(description="fill expiration date field")
	public void fillExpirationDate(String month,String year) {
		getCreditNumbertxt().sendKeys(ConfigurationManager.getBundle().getString("SummaryNumber"));
		Selectoption(getExpirymonthDD(),month);
		Selectoption(getExpiryyearDD(),year);

		Reporter.logWithScreenShot("Book Flight Page");
		getSecurePurchasebtn().click();
	}

	@QAFTestStep(description="verify country pop up")
	public void fillCountry(String deliveryCountry,String expectedmsg) {
		Selectoption(getDeliveryCountry(), ConfigurationManager.getBundle().getString("DeliveryCountry"));
		String actalrtmsg=driver.switchTo().alert().getText();
		
		Validator.verifyThat(actalrtmsg,Matchers.equalTo(expectedmsg));
		
		driver.switchTo().alert().accept();
		
		Select se=new Select(getDeliveryCountry());
		QAFWebElement qaf=(QAFWebElement) se.getFirstSelectedOption();
		String country=qaf.getText().trim();
		Validator.verifyThat(country,Matchers.equalTo(ConfigurationManager.getBundle().getString("DeliveryCountry")));
	}

}
