package pack.AppiumFramework.Tests.APIDemo;

import java.io.IOException;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pack.AppiumFramework.Base;

public class ScrollDemo extends Base{

	public static void main(String[] args) throws IOException {
		AndroidDriver<AndroidElement> driver=getDriver("APIDemoApp");
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		
		//scroll
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Radio Group\"));");
		
	}

}
