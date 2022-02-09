package pack.AppiumFramework.Objects.ECOMApp;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage {

	public CartPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
//		PageFactory.initElements(driver, this);//AppiumFieldDecorator provides compatibility for Android and iOS
	}

	@AndroidFindBy(id="com.androidsample.generalstore:id/productName") 
	public List<WebElement> productName;
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice") 
	public List<WebElement> productPrice;
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl") 
	public WebElement totalAmount;
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton") 
	public WebElement termsButton;
	@AndroidFindBy(id="com.androidsample.generalstore:id/alertTitle") 
	public WebElement alertTitle;
	@AndroidFindBy(xpath="//android.widget.Button[@text='CLOSE']") 
	public WebElement alertCloseBtn;
	@AndroidFindBy(xpath="//android.widget.CheckBox[1]") 
	public WebElement checkBox;
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed") 
	public WebElement ProceedBtn;
}
