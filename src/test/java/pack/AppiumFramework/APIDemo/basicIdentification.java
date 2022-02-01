package pack.AppiumFramework.APIDemo;

import java.net.MalformedURLException;

import com.mobile.objects.*;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pack.AppiumFramework.Base;

public class basicIdentification extends Base{
	
	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver=getDriver("APIDemoApp");
		//xpath syntax
		//tagname[@attributename='value']
		HomePage HP=new HomePage(driver);
		Preferences Pref=new Preferences(driver);
		Preference_Dependencies Pref_Def=new Preference_Dependencies(driver);
		
		HP.PreferenceLink.click();
		Pref.PreferenceDependenciesLink.click();
		Pref_Def.checkBox.click();
		Pref_Def.layout.click();
		Pref_Def.layoutEdit.click();
		Pref_Def.layoutEdit.sendKeys("Hello World");
		Pref_Def.layoutButtons.get(1).click();
		
//		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
//		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
//		driver.findElementById("android:id/checkbox").click();
//		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
//		driver.findElementByClassName("android.widget.EditText").click();
//		driver.findElementByClassName("android.widget.EditText").sendKeys("Hello World");
//		driver.findElementsByClassName("android.widget.Button").get(1).click();
	}

}
