package pack.AppiumFramework.APIDemo;

import java.net.MalformedURLException;
import static java.time.Duration.ofSeconds;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pack.AppiumFramework.Base;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class tapAndLongPress extends Base{

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver=getDriver("emulator");
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		//Tap
		TouchAction actions=new TouchAction(driver);
		WebElement expList=driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
		actions.tap(tapOptions().withElement(element(expList))).perform();
		driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
		
		//Long Press
		WebElement pplNames=driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
		actions.longPress(longPressOptions().withElement(element(pplNames)).withDuration(ofSeconds(2))).release().perform();
		System.out.println(driver.findElementByXPath("//android.widget.TextView[@text='Sample menu']").isDisplayed());
	}

}
