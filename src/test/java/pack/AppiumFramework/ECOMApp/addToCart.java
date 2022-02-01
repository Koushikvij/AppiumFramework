package pack.AppiumFramework.ECOMApp;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pack.AppiumFramework.Base;

public class addToCart extends Base{

	@Test
	public void addtoCartTest() throws InterruptedException, IOException {
		AndroidDriver<AndroidElement> driver=getDriver("GeneralStoreApp");
		//to hide the keyboard
		driver.hideKeyboard();

		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello");
		driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
		
		//Handling spinner utility
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");		
		//This type of scrolling is not working in some OSs and to avoid this we have the below command
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));   
		
		driver.findElementByXPath("//android.widget.TextView[@text='Argentina']").click();
		
		//Let's Shop Button
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
		//Clicking the right Add to Cart Button
		clickAddtoCartOfItemByID(driver,"com.androidsample.generalstore:id/productName","Jordan 6 Rings");
		//clickAddtoCartOfItemByID(driver,"com.androidsample.generalstore:id/productName","Air Jordan 4 Retro");
		
		//Click Cart button
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		waitForElementByID(driver,"com.androidsample.generalstore:id/productName");

		int count=driver.findElementsById("com.androidsample.generalstore:id/productName").size();
		int matchCount=0;
		for(int i=0;i<count;i++)
		{
			String itemName=driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
			if(itemName.equalsIgnoreCase("Jordan 6 Rings") || itemName.equalsIgnoreCase("Air Jordan 4 Retro"))
			{
				matchCount++;
			}			
		}
		if(matchCount==2)
		{
			System.out.println("Both items matches successfully");
		}
		else if(matchCount==1)
		{
			System.out.println("Only one item matches successfully");			
		}
		else
		{
			System.out.println("Both items match Failed");
		}
		
		int priceCount=driver.findElementsById("com.androidsample.generalstore:id/productPrice").size();
		double sum=0;
		for(int j=0; j<priceCount;j++)
		{
			String priceAmt=driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(j).getText();
			sum=sum+Double.parseDouble(priceAmt.substring(1));
		}
		double totalAmt=Double.parseDouble(driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText().substring(1));
		System.out.println("Sum = "+sum+"  totalAmt="+totalAmt);
		Assert.assertEquals(totalAmt, sum);
		
		//Long Press
		TouchAction actions=new TouchAction(driver);
		WebElement termsButton=driver.findElementById("com.androidsample.generalstore:id/termsButton");
		actions.longPress(longPressOptions().withElement(element(termsButton)).withDuration(ofSeconds(3))).release().perform();
		waitForElementByID(driver,"com.androidsample.generalstore:id/alertTitle");
		System.out.println(driver.findElementById("com.androidsample.generalstore:id/alertTitle").isDisplayed());
		driver.findElementByXPath("//android.widget.Button[@text='CLOSE']").click();
		
		//Tap check box
		waitForElementByXPath(driver,"//android.widget.CheckBox[1]");		
		WebElement checkBox=driver.findElementByXPath("//android.widget.CheckBox[1]");
		actions.tap(tapOptions().withElement(element(checkBox))).perform();
		
		//Click Proceed button
		driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
		
		Thread.sleep(10000);

		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
		    System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
		}
		driver.context((contextNames.toArray())[2].toString()); // set context to WEBVIEW_1

		//do some web testing
		driver.findElementByXPath("//*[@name='q']").sendKeys("Hello");
		driver.findElementByXPath("//*[@name='q']").sendKeys(Keys.ENTER);
		
		//code to press the back button on the Android device
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		// do more native testing if we want
		driver.context((contextNames.toArray())[0].toString());
	}
	
	public static void clickAddtoCartOfItemByID(AndroidDriver<AndroidElement> driver,String listID, String itemName)
	{
		//Searching for a product in the PDP and scrolling into view
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView("
                + "new UiSelector().text(\""+itemName+"\"));");
				
		int itemCount=driver.findElementsById(listID).size();
		int index=0;
		boolean blnFlag=false;
		for(index=0;index<itemCount;index++)
		{
			String itmName=driver.findElementsById(listID).get(index).getText();
			if(itmName.equalsIgnoreCase(itemName))
			{
				blnFlag=true;
				break;
			}
		}
		if(blnFlag==true)	
		{
			waitForElementByXPath(driver,"(//android.widget.TextView[@text='ADD TO CART'])["+index+"]");
			driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(index).click();
		}
		else
		{
				System.out.println("Item Not Found !");
		}
	}
	
	public static boolean waitForElementByID(AndroidDriver<AndroidElement> driver, String targetResourceId)
	{
		boolean isElementPresent;
		try{
			MobileElement mobileElement =  (MobileElement) driver.findElementById(targetResourceId);
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
