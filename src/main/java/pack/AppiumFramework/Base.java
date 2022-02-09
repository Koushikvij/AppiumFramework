package pack.AppiumFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base {

	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void killAllServive() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(2000);
	}

	public static void startServer() throws InterruptedException
	{
		boolean serverStatus=checkIfServerIsRunning(4723);
		System.out.println(serverStatus);
		if(!serverStatus)
		{
			service=AppiumDriverLocalService.buildDefaultService();
//					.buildService(new
//					AppiumServiceBuilder()
//					.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe")).withAppiumJS(new
//					File("C:\\Users\\koush\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\appium.js"))
//					.withIPAddress("127.0.0.1")
//					.usingPort(4723));
			service.start();
			Thread.sleep(3000);
		}
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
	
	public static void startEmulator() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\startEmulator.bat");
		Thread.sleep(10000);
	}
	
	@AfterSuite
	public static void stopEmulator() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\stopEmulator.bat");
	}
	
	public static AndroidDriver<AndroidElement> getDriver(String appName) throws IOException, InterruptedException{
		// Setting the properties of Android Driver
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\pack\\AppiumFramework\\global.properties");
		
		Properties prop=new Properties();
		prop.load(fis);
		String GSApp=prop.get(appName).toString();
//		String deviceName=prop.get("device").toString();
		String deviceName=System.getProperty("deviceName");
		
		File appDir=new File("src");
		File app=new File(appDir, GSApp);
		DesiredCapabilities cap = new DesiredCapabilities();
		if(deviceName.contains("emulator"))
		{
			//Emulator based approach
			startEmulator();
		}
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);
		//cap.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 20);
		cap.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		
		//Instantiates the driver object and then deploys the APK file in the emulator and installs and launches the same
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;		
	}
	
	public static void getScreenshot(String testName) throws IOException
	{
		Date date = new Date();
        System.out.println(new Timestamp(date.getTime()));
        String datetimestamp=new Timestamp(date.getTime()).toString().replace("-", "");
        datetimestamp=datetimestamp.replace(" ", "");
        datetimestamp=datetimestamp.replace(":", "");
        datetimestamp=datetimestamp.replace(".", "");
        String ScreenShotFileName=testName+"_screenshot_"+datetimestamp;
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(System.getProperty("user.dir")+"\\src\\test\\java\\screenshot\\"+ScreenShotFileName+".png"));
	}
}
