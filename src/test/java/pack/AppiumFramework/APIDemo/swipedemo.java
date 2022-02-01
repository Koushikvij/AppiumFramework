package pack.AppiumFramework.APIDemo;

import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pack.AppiumFramework.Base;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class swipedemo extends Base{

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver=getDriver("emulator");
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='2. Inline']").click();
		driver.findElementByXPath("//*[@content-desc='9']").click();
		
		//swipe
		TouchAction actions=new TouchAction(driver);
		WebElement num15=driver.findElementByXPath("//*[@content-desc='15']");
		WebElement num45=driver.findElementByXPath("//*[@content-desc='45']");
		actions.longPress(longPressOptions().withElement(element(num15)).withDuration(ofSeconds(2))).moveTo(element(num45)).release().perform();
	}

}
