package pack.AppiumFramework.Tests.Browser;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pack.AppiumFramework.Base;

public class Browse extends Base{

	public static void main(String[] args) throws InterruptedException, IOException {
		AndroidDriver<AndroidElement> driver=getDriver("emulator");
		//to hide the keyboard
		driver.hideKeyboard();
		driver.get("https://www.rahulshettyacademy.com/angularAppdemo/");
		driver.findElementByCssSelector(".navbar-toggler").click();
		driver.findElementByXPath("(//a[contains(text(),'roducts')])[1]").click();
		
		waitForElementByXPath(driver,"//h1[contains(text(),'Product List')]");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)","");
		waitForElementByXPath(driver,"//*[@class='list-group-item']//*[contains(text(),'Devops')]");
		String text=driver.findElementByXPath("//*[@class='list-group-item']//*[contains(text(),'Devops')]").getText();
		Assert.assertEquals(text,"Devops");
		

	}

	public static boolean waitForElementByXPath(AndroidDriver<AndroidElement> driver, String targetResourceXPath)
	{
		boolean isElementPresent;
		try{
			MobileElement mobileElement =  (MobileElement) driver.findElementByXPath(targetResourceXPath);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(mobileElement));
			isElementPresent = mobileElement.isDisplayed();
			return isElementPresent;	
		}catch(Exception e){
			isElementPresent = false;
			System.out.println(e.getMessage());
			return isElementPresent;
		}
	}
}
