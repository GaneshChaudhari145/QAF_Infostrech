package com.amazon.page;

import java.time.Duration;

import org.openqa.selenium.Dimension;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ScrollAction extends WebDriverBaseTestPage<WebDriverTestPage>{


	public void Scroll() {

		AndroidDriver myDriver = (AndroidDriver) driver.getUnderLayingDriver();
		TouchAction action = new TouchAction(myDriver);
		Dimension size = driver.manage().window().getSize();
		int startx = size.getWidth()/2;
		int endx = size.getWidth()/2;
		int starty = (int)(size.getHeight()* 0.90);
		int endy = (int)(size.getHeight()* 0.20);	

		action.press(PointOption.point(startx, starty)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(4))).moveTo(PointOption.point(startx, endy)).release().perform();

	}


	public void Enter()
	{
		AndroidDriver myDriver = (AndroidDriver) driver.getUnderLayingDriver();

		myDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
	}

	public void scroll(String visibleText) {
	 AndroidDriver myDriver = (AndroidDriver) driver.getUnderLayingDriver();
	 myDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+visibleText+"\"));");
	} 

	@Override
	protected void openPage(PageLocator locator, Object... args) {

	}

}
