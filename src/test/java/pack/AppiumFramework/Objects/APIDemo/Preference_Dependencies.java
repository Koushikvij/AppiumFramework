package pack.AppiumFramework.Objects.APIDemo;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Preference_Dependencies {

	public Preference_Dependencies(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);//AppiumFieldDecorator provides compatibility for Android and iOS
	}

	@AndroidFindBy(id="android:id/checkbox") 
	public WebElement checkBox;
	@AndroidFindBy(xpath="(//android.widget.RelativeLayout)[2]") 
	public WebElement layout;
	@AndroidFindBy(className="android.widget.EditText") 
	public WebElement layoutEdit;
	@AndroidFindBy(className="android.widget.Button") 
	public List<WebElement> layoutButtons;
}
