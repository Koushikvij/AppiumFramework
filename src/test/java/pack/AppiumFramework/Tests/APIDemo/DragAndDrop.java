package pack.AppiumFramework.Tests.APIDemo;

import static io.appium.java_client.touch.offset.ElementOption.element;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pack.AppiumFramework.Base;

public class DragAndDrop extends Base{

	public static void main(String[] args) throws IOException {
		AndroidDriver<AndroidElement> driver=getDriver("APIDemoApp");
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
		
		//drag and drop
		TouchAction actions=new TouchAction(driver);
		WebElement sourceObj=driver.findElementsByClassName("android.view.View").get(0);
		WebElement destObj=driver.findElementsByClassName("android.view.View").get(2);
		//actions.longPress(longPressOptions().withElement(element(sourceObj))).moveTo(element(destObj)).release().perform();
		//Use the below syntax when we are not doing additional activities on a single element
		actions.longPress(element(sourceObj)).moveTo(element(destObj)).release().perform();
	
	}

}
