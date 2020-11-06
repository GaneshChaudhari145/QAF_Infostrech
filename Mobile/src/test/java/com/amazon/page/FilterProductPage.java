package com.amazon.page;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class FilterProductPage extends WebDriverBaseTestPage<WebDriverTestPage>{

	@FindBy(locator = "Login.filter.dd")
	private QAFWebElement filterdd;

	@FindBy(locator = "Filter.AmazonPrime.dd")
	private QAFWebElement AmazonPrimedd;

	@FindBy(locator = "Filter.PayOnDelivery.dd")
	private QAFWebElement PODdd;

	@FindBy(locator = "Filter.format.dd")
	private QAFWebElement formatdd;

	@FindBy(locator = "Filter.Department.dd")
	private QAFWebElement Departmentdd;

	@FindBy(locator = "Filter.Paperback.dd")
	private QAFWebElement Paperbackdd;

	@FindBy(locator = "Filter.Paperback.checkbox")
	private QAFWebElement Paperbackcbx;

	@FindBy(locator = "Filter.closefilter.dd")
	private QAFWebElement closefilterdd;

	@FindBy(locator = "Filter.sortby.dd")
	private QAFWebElement sortbydd;

	@FindBy(locator = "Filter.pricelowtohigh.rb")
	private QAFWebElement pricelowtohighrb;

	@FindBy(locator = "Filter.pricehightolow.rb")
	private QAFWebElement pricehightolowrb;

	@FindBy(locator = "Filter.lowprice.lbl")
	private QAFWebElement lowpricelbl;

	@FindBy(locator = "Filter.highprice.lbl")
	private QAFWebElement highpricelbl;


	public QAFWebElement getLowpricelbl() {return lowpricelbl;}

	public QAFWebElement getHighpricelbl() {return highpricelbl;}

	public QAFWebElement getPricelowtohighrb() {return pricelowtohighrb;}

	public QAFWebElement getPricehightolowrb() {return pricehightolowrb;}

	public QAFWebElement getSortbydd() {return sortbydd;}

	public QAFWebElement getClosefilterdd() {return closefilterdd;}

	public QAFWebElement getPaperbackcbx() {return Paperbackcbx;}

	public QAFWebElement getPaperbackdd() {return Paperbackdd;}

	public QAFWebElement getDepartmentdd() {return Departmentdd;}

	public QAFWebElement getAmazonPrimedd() {return AmazonPrimedd;}

	public QAFWebElement getPODdd() {return PODdd;}

	public QAFWebElement getFormatdd() {return formatdd;}

	public QAFWebElement getFilterdd() {return filterdd;}


	@QAFTestStep(description="tap on filter button")
	public void clickFilterButton() {
		getFilterdd().waitForPresent();
		getFilterdd().click();
		Reporter.log("Tap on Filter button");
		getDepartmentdd().isDisplayed();
		Reporter.log("Department Options is displayed");
		getAmazonPrimedd().isDisplayed();
		Reporter.log("Amazon Prime Options is displayed");
		getPODdd().isDisplayed();
		Reporter.log("Pay On Delivery Options is displayed");
		getFormatdd().isDisplayed();
		Reporter.log("Format Options is displayed");
	}
	@QAFTestStep(description="select particular filter option")
	public void clickFilter(){

		new ScrollAction().Scroll();
		getFormatdd().waitForPresent();
		getFormatdd().click();
		Reporter.log("Click on Format Options");
		Reporter.logWithScreenShot("Click on Format");

		getPaperbackdd().waitForPresent();
		getPaperbackdd().click();
		Reporter.log("Click on Paperback Options");
		Reporter.logWithScreenShot("Click on Paperback");

		getPaperbackcbx().isSelected();
		Reporter.log("Selected options as checked");

		getClosefilterdd().waitForPresent();
		getClosefilterdd().click();
		Reporter.log("Click to close filter menu");
		Reporter.logWithScreenShot("close filter menu");
	}

	@QAFTestStep(description="select sort by option")
	public void clickSort(){

		getSortbydd().waitForPresent();
		getSortbydd().click();
		Reporter.log("Click on Sort by Options");
		Reporter.logWithScreenShot("Click on Sort by");

		getPricelowtohighrb().isDisplayed();
		Reporter.log("Price: Low to High Radio Button is displayed");

		getPricehightolowrb().isDisplayed();
		Reporter.log("Price: High to Low Radio Button is displayed");

		getPricelowtohighrb().waitForPresent();
		getPricelowtohighrb().click();
		Reporter.log("Click on Price: Low to High Radio Button");
		Reporter.logWithScreenShot("Click on Price: Low to High Radio Button");

		getPricelowtohighrb().isSelected();
		Reporter.log("Selected options as marked");

		getClosefilterdd().waitForPresent();
		getClosefilterdd().click();
		Reporter.log("Click to close filter menu");
		Reporter.logWithScreenShot("close filter menu");

		String lowprice=getLowpricelbl().getText();
		int lowresult=Integer.parseInt(lowprice);
		Reporter.log("First Lower Result Starts");
		Reporter.logWithScreenShot("Lower Results..");


		new ScrollAction().scroll(pageProps.getString("SortingPrice"));
		Reporter.log("Now Higher Result Starts");
		Reporter.logWithScreenShot("Higher Result..");
		String highprice=getHighpricelbl().getText();
		
		int highresult=Integer.parseInt(highprice);
		if(lowresult<highresult) {
			Reporter.log("Result is displayed in Low to High Format");
		}
		else
		{
			Reporter.log("Wrong Result Displayed");
		}
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {

	}

}
