package pack.AppiumFramework.Tests.ECOMApp;

import java.io.IOException;

import pack.AppiumFramework.Base;
import pack.AppiumFramework.Utilities;
import pack.AppiumFramework.Objects.ECOMApp.FormPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class FormFill extends Base{

	public static void main(String[] args) throws IOException, InterruptedException {
		startServer();
		AndroidDriver<AndroidElement> driver=getDriver("GeneralStoreApp");
		FormPage formPage=new FormPage(driver);
		Utilities util=new Utilities(driver);
		
		//to hide the keyboard
		driver.hideKeyboard();
		formPage.nameField.sendKeys("Hello");
		formPage.FemaleRadioBtn.click();
		
		//Handling spinner utility
		formPage.CountrySpinner.click();
		util.scrollIntoView("India");	
		formPage.India.click();
		
		//Let's Shop Button
		formPage.LetsShopButton.click();
		stopServer();
	}

}
