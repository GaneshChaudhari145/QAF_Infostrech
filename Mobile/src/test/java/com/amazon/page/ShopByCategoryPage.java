package com.amazon.page;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class ShopByCategoryPage extends WebDriverBaseTestPage<WebDriverTestPage>{


	@FindBy(locator = "Shop.shopcategory.btn")
	private QAFWebElement shopcategorybtn;

	@FindBy(locator = "Shop.mensfashion.menu")
	private QAFWebElement mensfashionmenu;

	@FindBy(locator = "Shop.mensAmazonFashion.option")
	private QAFWebElement mensAmazonFashionopt;

	@FindBy(locator = "Shop.mensFashionfootwear.option")
	private QAFWebElement mensfootwear;

	@FindBy(locator = "Shop.menssportsShoes.lbl")
	private QAFWebElement menssportsShoes;

	@FindBy(locator = "Shop.mensBourgeShoes.box")
	private QAFWebElement mensBourgeShoesbox;

	@FindBy(locator = "Shop.share.icon")
	private QAFWebElement shareicon;

	@FindBy(locator = "Shop.Buynow.btn")
	private QAFWebElement Buynowbtn;

	@FindBy(locator = "Shop.addtocart.btn")
	private QAFWebElement addtocartbtn;

	@FindBy(locator = "home.menu.lnk")
	private QAFWebElement menuoption;

	@FindBy(locator = "home.shopcategory.menu")
	private QAFWebElement shopcategoryoption;

	@FindBy(locator = "Shop.mensbackpacks.option")
	private QAFWebElement mensbackpacks;

	@FindBy(locator = "Shop.mensLaptop.lbl")
	private QAFWebElement mensLaptop;

	@FindBy(locator = "Shop.mensBestsellerBag.box")
	private QAFWebElement mensBestsellerBagBox;
	
	@FindBy(locator = "Shop.Buynowbagpack.btn")
	private QAFWebElement Buynowbagpackbtn;
	
	@FindBy(locator = "Shop.Shoessize.btn")
	private QAFWebElement Shoessizebtn;
	
	@FindBy(locator = "Shop.addtosize.box")
	private QAFWebElement addtosizebox;
	
	@FindBy(locator = "Shop.size.btn")
	private QAFWebElement sizebtn;
	
	@FindBy(locator = "Shop.Done.lbl")
	private QAFWebElement Donelbl;
	
	
	@FindBy(locator = "Shop.mensBestsellerBag.Filterbox")
	private QAFWebElement mensBestsellerBag;
	
	@FindBy(locator = "Shop.mensFormalShoes.lbl")
	private QAFWebElement mensFormalShoes;
	
	@FindBy(locator = "Shop.addFormal.box")
	private QAFWebElement addFormal;
	
	@FindBy(locator = "Shop.formalsize.btn")
	private QAFWebElement formalsizebtn;
	
	@FindBy(locator = "Shop.formalShoes.lbl")
	private QAFWebElement formalShoes;

	public QAFWebElement getFormalShoes() {	return formalShoes;	}
	
	public QAFWebElement getFormalsizebtn() {return formalsizebtn;}

	public QAFWebElement getAddFormal() {return addFormal;}

	public QAFWebElement getMensFormalShoes() {	return mensFormalShoes;}

	public QAFWebElement getDonelbl() {return Donelbl;}

	public QAFWebElement getSizebtn() {return sizebtn;}

	public QAFWebElement getAddtosizebox() {return addtosizebox;}

	public QAFWebElement getBuynowbagpackbtn() {return Buynowbagpackbtn;}

	public QAFWebElement getShoessizebtn() {return Shoessizebtn;}

	public QAFWebElement getMensBestsellerBagBox() {return mensBestsellerBagBox;}

	public QAFWebElement getMensLaptop() {return mensLaptop;}

	public QAFWebElement getMensbackpacks() {return mensbackpacks;}

	public QAFWebElement getShopcategoryoption() {return shopcategoryoption;}

	public QAFWebElement getMenuoption() {return menuoption;}

	public QAFWebElement getBuynowbtn() {return Buynowbtn;}

	public QAFWebElement getAddtocartbtn() {return addtocartbtn;}

	public QAFWebElement getShareicon() {return shareicon;}

	public QAFWebElement getMensBourgeShoesbox() {return mensBourgeShoesbox;}

	public QAFWebElement getMenssportsShoes() {return menssportsShoes;}

	public QAFWebElement getMensfootwear() {return mensfootwear;}

	public QAFWebElement getMensAmazonFashionopt() {return mensAmazonFashionopt;}

	public QAFWebElement getMensfashionmenu() {return mensfashionmenu;}

	public QAFWebElement getShopcategorylbl() {	return shopcategorybtn;}
	
	public QAFWebElement getMensBestsellerBag() {return mensBestsellerBag;}


	@QAFTestStep(description="tap on 'shop by category' button")
	public void shopByMenu(){
		getShopcategorylbl().waitForPresent();
		getShopcategorylbl().click();
		Reporter.log("Tap on Shop By Category Button.");

		getMensfashionmenu().waitForPresent();
		getMensfashionmenu().click();
		Reporter.log("Click on Men's Fashion Menu.");

		getMensAmazonFashionopt().waitForPresent();
		getMensAmazonFashionopt().click();
		Reporter.log("Click on Amazon Fashion in Men's Fashion Menu.");


		new ScrollAction().Scroll();
		new ScrollAction().Scroll();

		getMensfootwear().waitForPresent();
		getMensfootwear().click();
		Reporter.log("Click on Footwear in Men's Fashion Category.");

		getMenssportsShoes().waitForPresent();
		getMenssportsShoes().click();
		Reporter.log("Click on Sports Shoes.");

		getMensBourgeShoesbox().waitForPresent();
		getMensBourgeShoesbox().click();
		Reporter.log("Click on Bourge Men's Running Shoes.");
	}

	@QAFTestStep(description="navigate the product details page")
	public void productdetails() {
		getShareicon().waitForPresent();
		getShareicon().isDisplayed();
		Reporter.log("Share Icon is Displayed");

		new ScrollAction().Scroll();

		getBuynowbtn().waitForPresent();
		getBuynowbtn().isDisplayed();
		Reporter.log("Buy Now Button is Displayed");

		getAddtocartbtn().waitForPresent();
		getAddtocartbtn().isDisplayed();
		Reporter.log("Add to Cart Button is Displayed");
	}

	@QAFTestStep(description="navigate to menu option")
	public void goToMenu() {
		getMenuoption().waitForPresent();
		getMenuoption().click();

		getShopcategoryoption().waitForPresent();
		getShopcategoryoption().click();

		getMensfashionmenu().waitForPresent();
		getMensfashionmenu().click();
		Reporter.log("Click on Men's Fashion Menu.");

		getMensAmazonFashionopt().waitForPresent();
		getMensAmazonFashionopt().click();
		Reporter.log("Click on Amazon Fashion in Men's Fashion Menu.");


		new ScrollAction().Scroll();
		new ScrollAction().Scroll();

		getMensbackpacks().waitForPresent();
		getMensbackpacks().click();
		Reporter.log("Click on Backpacks in Men's Fashion Category.");

		getMensLaptop().waitForPresent();
		getMensLaptop().click();
		Reporter.log("Click on Laptop");

		getMensBestsellerBagBox().waitForPresent();
		getMensBestsellerBagBox().click();
		Reporter.log("Click on POLE STAR HERO Navy Casual Backpack.");
	}

	@QAFTestStep(description="navigate the product details page")
	public void productlaptopdetails() {
		getShareicon().waitForPresent();
		getShareicon().isDisplayed();
		Reporter.log("Share Icon is Displayed");

		new ScrollAction().Scroll();
		

		getBuynowbagpackbtn().waitForPresent();
		getBuynowbagpackbtn().isDisplayed();
		Reporter.log("Buy Now Button is Displayed");

		getAddtocartbtn().waitForPresent();
		getAddtocartbtn().isDisplayed();
		Reporter.log("Add to Cart Button is Displayed");
	}
	
	@QAFTestStep(description="tap on 'shop by category' button")
	public void addItems(){
		
		getShopcategorylbl().waitForPresent();
		getShopcategorylbl().click();
		Reporter.log("Tap on Shop By Category Button.");

		getMensfashionmenu().waitForPresent();
		getMensfashionmenu().click();
		Reporter.log("Click on Men's Fashion Menu.");

		getMensAmazonFashionopt().waitForPresent();
		getMensAmazonFashionopt().click();
		Reporter.log("Click on Amazon Fashion in Men's Fashion Menu.");

		
		new ScrollAction().Scroll();

		getMensfootwear().waitForPresent();
		getMensfootwear().click();
		Reporter.log("Click on Footwear in Men's Fashion Category.");

		getMenssportsShoes().waitForPresent();
		getMenssportsShoes().click();
		Reporter.log("Click on Sports Shoes.");
		
		new ScrollAction().Scroll();

		getAddtosizebox().waitForPresent();
		getAddtosizebox().click();
		Reporter.log("Click on Shoe.");
		
		getShareicon().waitForPresent();
		getShareicon().isDisplayed();
		Reporter.log("Share Icon is Displayed");

		
		getShoessizebtn().waitForPresent();
		getShoessizebtn().click();
		Reporter.logWithScreenShot("Size Icon is Displayed");
		
		getSizebtn().click();
		Reporter.log("Size "+getSizebtn().getText()+" is Selected");
		
		getDonelbl().click();

		new ScrollAction().Scroll();
		new ScrollAction().Scroll();
		new ScrollAction().Scroll();
		
		getAddtocartbtn().waitForPresent();
		getAddtocartbtn().click();
		Reporter.log("Click on Add to Cart Button");
		Reporter.logWithScreenShot("'added to cart' message is Displayed");
	}
	
	@QAFTestStep(description="navigate to menu option")
	public void goToMenuForSecondFilter() {
		getMenuoption().waitForPresent();
		getMenuoption().click();

		getShopcategoryoption().waitForPresent();
		getShopcategoryoption().click();

		getMensfashionmenu().waitForPresent();
		getMensfashionmenu().click();
		Reporter.log("Click on Men's Fashion Menu.");

		getMensAmazonFashionopt().waitForPresent();
		getMensAmazonFashionopt().click();
		Reporter.log("Click on Amazon Fashion in Men's Fashion Menu.");

		
		new ScrollAction().Scroll();
		
		getMensfootwear().waitForPresent();
		getMensfootwear().click();
		Reporter.log("Click on Footwear in Men's Fashion Category.");
		
		getFormalShoes().waitForPresent();
		getFormalShoes().click();
		Reporter.log("Click on Formal Shoes.");
		
		
		
		new ScrollAction().scroll(pageProps.getString("SecondProduct"));

		getAddFormal().waitForPresent();
		getAddFormal().click();
		Reporter.log("Click on Shoe.");
		
		getShareicon().waitForPresent();
		getShareicon().isDisplayed();
		Reporter.log("Share Icon is Displayed");
		
		getFormalsizebtn().waitForPresent();
		getFormalsizebtn().click();
		Reporter.logWithScreenShot("Size Icon is Displayed");
		
		getSizebtn().click();
		Reporter.log("Size "+getSizebtn().getText()+" is Selected");
		
		getDonelbl().click();
		new ScrollAction().Scroll();
		new ScrollAction().Scroll();
		new ScrollAction().Scroll();
		
		getAddtocartbtn().waitForPresent();
		getAddtocartbtn().click();
		Reporter.log("Click on Add to Cart Button");
		Reporter.logWithScreenShot("'added to cart' message is Displayed");
		
	}
	@Override
	protected void openPage(PageLocator locator, Object... args) {

	}

}
