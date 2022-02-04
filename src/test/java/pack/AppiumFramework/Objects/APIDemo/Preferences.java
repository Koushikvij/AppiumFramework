package pack.AppiumFramework.Objects.APIDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Preferences {


	public Preferences(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);//AppiumFieldDecorator provides compatibility for Android and iOS
	}

	@AndroidFindBy(xpath="//android.widget.TextView[@text='3. Preference dependencies']") 
	public WebElement PreferenceDependenciesLink;
}
