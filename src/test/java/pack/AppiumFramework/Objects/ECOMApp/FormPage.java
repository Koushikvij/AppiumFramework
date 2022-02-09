package pack.AppiumFramework.Objects.ECOMApp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {

	public FormPage(AndroidDriver<AndroidElement> driver)
	{
//		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
//		PageFactory.initElements(driver, this);//AppiumFieldDecorator provides compatibility for Android and iOS
	}

	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField") 
	public WebElement nameField;
	@AndroidFindBy(xpath = "//*[@text='Female']") 
	public WebElement FemaleRadioBtn;
	@AndroidFindBy(id="android:id/text1") 
	public WebElement CountrySpinner;
	@AndroidFindBy(xpath="//*[@text='India']") 
	public WebElement India;
	@AndroidFindBy(xpath="//*[@text='Argentina']")
	public WebElement Argentina;
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop") 
	public WebElement LetsShopButton;
	@AndroidFindBy(xpath="//android.widget.Toast[1]") 
	public WebElement ToastMessage;
}
