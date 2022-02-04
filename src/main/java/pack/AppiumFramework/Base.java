package pack.AppiumFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {

	public static AppiumDriverLocalService service;

	public static void startServer()
	{
		boolean serverStatus=checkIfServerIsRunning(4723);
		if(serverStatus)
		{
			service.stop();
		}
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
	}
	
	public static void stopServer()
	{
		service.stop();
	}

	public static boolean checkIfServerIsRunning(int port)
	{
		boolean isServerRunning=false;
		ServerSocket serverSocket;
		try {
			serverSocket=new ServerSocket(port);
			serverSocket.close();
		}
		catch(Exception e)
		{
			isServerRunning=true;
		}
		finally
		{
			serverSocket=null;
		}
		return isServerRunning;
	}
	
	public static AndroidDriver<AndroidElement> getDriver(String appName) throws IOException{
		// Setting the properties of Android Driver
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\pack\\AppiumFramework\\global.properties");
		
		Properties prop=new Properties();
		prop.load(fis);
		String GSApp=prop.get(appName).toString();
		String deviceName=prop.get("device").toString();
		
		File appDir=new File("src");
		File app=new File(appDir, GSApp);
		DesiredCapabilities cap = new DesiredCapabilities();
		if(deviceName.equalsIgnoreCase("emulator"))
		{
			//Emulator based approach
			cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel4");			
		}
		else if(deviceName.equalsIgnoreCase("realdevice"))
		{
			//Physical Device based approach
			cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");
		}
		//cap.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 20);
		cap.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		
		//Instantiates the driver object and then deploys the APK file in the emulator and installs and launches the same
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;		
	}
}
