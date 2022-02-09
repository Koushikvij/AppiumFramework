package pack.AppiumFramework.Objects.ECOMApp;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pack.AppiumFramework.Utilities;

public class ProductDetailPage {
	AndroidDriver<AndroidElement> driver;
	
	public ProductDetailPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver=driver;
	}

	@AndroidFindBy(id="com.androidsample.generalstore:id/productName") 
	public List<WebElement> productName;
	@AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart") 
	public List<WebElement> addtoCartBtn;
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart") 
	public WebElement appBarAddtoCartBtn;

	
	public void clickAddtoCartOfItemByID(String itemName)
	{
		//Searching for a product in the PDP and scrolling into view
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView("
                + "new UiSelector().text(\""+itemName+"\"));");
		Utilities util=new Utilities(driver);
						
		int itemCount=productName.size();
		int index=0;
		boolean blnFlag=false;
		for(index=0;index<itemCount;index++)
		{
			String itmName=productName.get(index).getText();
			if(itmName.equalsIgnoreCase(itemName))
			{
				blnFlag=true;
				break;
			}
		}
		if(blnFlag==true)	
		{
			util.waitForElement(addtoCartBtn.get(index));
			addtoCartBtn.get(index).click();
		}
		else
		{
				System.out.println("Item Not Found !");
		}
	}

}
