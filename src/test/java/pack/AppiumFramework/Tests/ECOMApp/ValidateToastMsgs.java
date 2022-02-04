package pack.AppiumFramework.Tests.ECOMApp;

import java.io.IOException;

import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pack.AppiumFramework.Base;
import pack.AppiumFramework.Objects.ECOMApp.FormPage;

public class ValidateToastMsgs extends Base{

	public static void main(String[] args) throws IOException {
		startServer();
		AndroidDriver<AndroidElement> driver=getDriver("GeneralStoreApp");
		FormPage formPage=new FormPage(driver);
		
		//The default class name for toast message is android.widget.Toast
		formPage.LetsShopButton.click();		
		String toastMsgName = formPage.ToastMessage.getAttribute("name");
		System.out.println("Encountered the following error message:");
		System.out.println(toastMsgName);		
		Assert.assertEquals("Please enter your name",toastMsgName);
		stopServer();
	}
}