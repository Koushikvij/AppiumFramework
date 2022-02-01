package pack.AppiumFramework.ECOMApp;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pack.AppiumFramework.Base;

public class FormFill extends Base{

	@Test
	public void filltheForm() throws IOException {
		AndroidDriver<AndroidElement> driver=getDriver("GeneralStoreApp");
		//to hide the keyboard
		driver.hideKeyboard();

		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello");
		driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
		
		//Handling spinner utility
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));");		
		//This type of scrolling is not working in some OSs and to avoid this we have the below command
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));   
		
		driver.findElementByXPath("//android.widget.TextView[@text='India']").click();
		
		//Let's Shop Button
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
	}

}
