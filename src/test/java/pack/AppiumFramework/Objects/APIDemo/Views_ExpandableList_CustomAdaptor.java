package pack.AppiumFramework.Objects.APIDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Views_ExpandableList_CustomAdaptor {

	public Views_ExpandableList_CustomAdaptor(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);//AppiumFieldDecorator provides compatibility for Android and iOS
	}

	@AndroidFindBy(xpath="//android.widget.TextView[@text='People Names']") 
	public WebElement PeopleNamesLink;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Sample menu']")
	public WebElement SampleMenuLink;
}
