package com.amazon.page;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class AddToCartPage extends WebDriverBaseTestPage<WebDriverTestPage>{

	@FindBy(locator = "Add.CartSymbol.lbl")
	private QAFWebElement CartSymbol;
	
	@FindBy(locator = "Add.proceed.btn")
	private QAFWebElement proceedbtn;
	
	@FindBy(locator = "Add.firstproduct.txt")
	private QAFWebElement firstproducttxt;
	
	
	public QAFWebElement getCartSymbol() {return CartSymbol;}
	
	public QAFWebElement getProceedbtn() {return proceedbtn;}
	
	public QAFWebElement getFirstproducttxt() {return firstproducttxt;}
	


	@QAFTestStep(description="verify the product in cart page")
	public void verifyCartPage() {
		getCartSymbol().waitForPresent();
		getCartSymbol().click();
		
		getProceedbtn().isDisplayed();
		Reporter.log("Proceed to Buy Button is Displayed");
		
		getFirstproducttxt().waitForPresent();
		Reporter.log("Recently added Product is "+getFirstproducttxt().getText());
	}
	
	
	@Override
	protected void openPage(PageLocator locator, Object... args) {
	}

}
