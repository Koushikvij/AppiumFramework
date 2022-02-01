package pack.AppiumFramework.ECOMApp;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pack.AppiumFramework.Base;

public class validateToastMsgs extends Base{

	@Test
	public void validateToastMessages() throws IOException {
		AndroidDriver<AndroidElement> driver=getDriver("GeneralStoreApp");
		
		//The default class name for toast message is android.widget.Toast
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		String toastMsgName = driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
		System.out.println("Encountered the following error message:");
		System.out.println(toastMsgName);		
		Assert.assertEquals("Please enter your name",toastMsgName);
	}

}
