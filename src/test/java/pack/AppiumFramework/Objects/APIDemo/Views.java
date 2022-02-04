package pack.AppiumFramework.Objects.APIDemo;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Views {
	
	public Views(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);//AppiumFieldDecorator provides compatibility for Android and iOS
	}

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Drag and Drop']") 
	public WebElement DragAndDropLink;
	@AndroidFindBy(className="android.view.View") 
	public List<WebElement> DragObjects;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Expandable Lists']") 
	public WebElement ExpandableListLink;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Date Widgets']") 
	public WebElement DateWidgetsLink;
}
