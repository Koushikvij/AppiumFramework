package pack.AppiumFramework.Objects.APIDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Views_DateWidgets {
	
	public Views_DateWidgets(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);//AppiumFieldDecorator provides compatibility for Android and iOS
	}

	@AndroidFindBy(xpath="//android.widget.TextView[@text='2. Inline']") 
	public WebElement InlineLink;
	@AndroidFindBy(xpath="//*[@content-desc='9']") 
	public WebElement Link9;
	@AndroidFindBy(xpath="//*[@content-desc='15']") 
	public WebElement Link15;
	@AndroidFindBy(xpath="//*[@content-desc='45']") 
	public WebElement Link45;
}
