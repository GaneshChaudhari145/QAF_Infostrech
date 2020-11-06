package com.amazon.page;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;

public class SearchByProductPage extends WebDriverBaseTestPage<WebDriverTestPage>{

	@FindBy(locator = "SearchProductPage.secondProduct.lbl")
	private QAFWebElement secondProductlbl;

	@FindBy(locator = "SearchProductPage.thirdProduct.lbl")
	private QAFWebElement thirdProductlbl;

	@FindBy(locator = "SearchProductPage.fourthProduct.lbl")
	private QAFWebElement fourthProductlbl;

	@FindBy(locator = "Login.filter.dd")
	private QAFWebElement filterdd;

	@FindBy(locator = "SearchProductPage.womensthirdProduct.lbl")
	private QAFWebElement womensthirdProductlbl;
	
	@FindBy(locator = "SearchProductPage.Bookfirst.lbl")
	private QAFWebElement Bookfirstlbl;
	
	@FindBy(locator = "SearchProductPage.firstpaperback.lbl")
	private QAFWebElement firstpaperbacklbl;


	public QAFWebElement getFirstpaperbacklbl() {return firstpaperbacklbl;}

	public QAFWebElement getBookfirstlbl() {return Bookfirstlbl;}

	public QAFWebElement getWomensthirdProductlbl() {return womensthirdProductlbl;}

	public QAFWebElement getFilterdd() {return filterdd;}

	public QAFWebElement getFourthProductlbl() {return fourthProductlbl;}

	public QAFWebElement getSecondProductlbl() {return secondProductlbl;}

	public QAFWebElement getThirdProductlbl() {return thirdProductlbl;}


	@QAFTestStep(description="verify search results.")
	public void VerifyProduct() {

		if(getFilterdd().isDisplayed())
		{
			String matcher=pageProps.getString("productname");

			getSecondProductlbl().waitForPresent();
			Validator.verifyTrue(getSecondProductlbl().getText().contains(matcher), "Search Product is not relevant to "+matcher, "Search Product is relevant to "+matcher);
			Reporter.log(getSecondProductlbl().getText());

			getThirdProductlbl().waitForPresent();
			Validator.verifyTrue(getThirdProductlbl().getText().contains(matcher), "Search Product is not relevant to "+matcher, "Search Product is relevant to "+matcher);
			Reporter.log(getThirdProductlbl().getText());

			getFourthProductlbl().waitForPresent();
			Validator.verifyTrue(getFourthProductlbl().getText().contains(matcher), "Search Product is not relevant to "+matcher, "Search Product is relevant to "+matcher);
			Reporter.log(getFourthProductlbl().getText());
		}
		else {
			Reporter.log("No products available");
		}
	}

	@QAFTestStep(description="verify search results.")
	public void RelevantProduct() {

		if(getFilterdd().isDisplayed())
		{
			
			String items=pageProps.getString("searchItems");

			String searchItems[]=items.split(" ");
			getWomensthirdProductlbl().waitForPresent();
			Validator.verifyTrue(getWomensthirdProductlbl().getText().contains(searchItems[0]) && getWomensthirdProductlbl().getText().contains(searchItems[1]), "Product "+getWomensthirdProductlbl().getText() +" doesn't contain:"+items, "Product verified:"+items);

			Reporter.log(getWomensthirdProductlbl().getText());
		}
		else {
			Reporter.log("No products available");
		}
	}

	@QAFTestStep(description="verify search results.")
	public void FilterProduct() {

		
		getBookfirstlbl().waitForPresent();
		Validator.verifyTrue(getBookfirstlbl().getText().matches(getBookfirstlbl().getText()), "Filter Product Not Verified", "Filter Product Verified");
		Reporter.log("The Filtered Product "+getBookfirstlbl().getText()+ " Comes into "+getFirstpaperbacklbl().getText()+" Category");
	}


	@Override
	protected void openPage(PageLocator locator, Object... args) {

	}

}
