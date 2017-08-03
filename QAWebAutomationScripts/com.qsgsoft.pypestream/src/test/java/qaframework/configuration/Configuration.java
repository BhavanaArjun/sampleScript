package qaframework.configuration;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.UserDefinedFunctions.QnetFunctions;
import qaframework.webElements.WaitTimeConstants;

public class Configuration {

	AndroidDriver<MobileElement> driver;

	public AndroidDriver<MobileElement> Android_Driver;

	@SuppressWarnings("rawtypes")
	public static Class className;
	public static String strReason, gstrdate, gstrBuild, gstrTimetake,
			gstrFailureReason, TCID, strTO, strResultPath, strSessionId = "";
	public static Date gdtStartDate;
	public String gstrResult = "";
	protected String gstrReason;
	protected double gdbTimeTaken;
	public static long gslsysDateTime;

	PathsProperties objPathProperties = new PathsProperties();
	OfficeCommonFunctions objOfficeFunctions = new OfficeCommonFunctions();
	
	Date_Time_settings dts = new Date_Time_settings();

	public String screenShotsPath;
	
	@BeforeMethod(alwaysRun = true)
	public AndroidDriver<MobileElement> setUp() throws Exception {

		Properties pathProps = objPathProperties.Read_FilePath();
		String path = Paths.get(".").toAbsolutePath().normalize().toString();
		System.out.println(path);
		screenShotsPath = path + pathProps.getProperty("failedScreenshots");
		
		// Launch mobile app
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");

		// Lenovo
		/*capabilities.setCapability("VERSION", "6.0");
		capabilities.setCapability("deviceName", "TS8TOJI7NVNJZDRO");
		capabilities.setCapability("platformVersion", "23");*/
		
		// Moto G
		/*capabilities.setCapability("VERSION", "6.0");
		capabilities.setCapability("deviceName", "ZX1D63B2HD");
		capabilities.setCapability("platformVersion", "23");*/

		//Emulator 4.95
		/*capabilities.setCapability("VERSION", "6.0");
		capabilities.setCapability("deviceName","emulator-5554");
		capabilities.setCapability("platformVersion", "23");*/
		
		// Moto E
		/*capabilities.setCapability("VERSION", "5.1");
		capabilities.setCapability("deviceName", "ZX1B33TBVS");
		capabilities.setCapability("platformVersion", "22");*/
		
		//Lenevo 4.4
		/*capabilities.setCapability("VERSION", "4.4");
		capabilities.setCapability("deviceName", "0123456789ABCDEF");
		capabilities.setCapability("platformVersion", "19");*/
		
		// Android 6 emulator
		/*capabilities.setCapability("VERSION", "6.0");
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("platformVersion", "23");*/
		
		String command = "echo $ANDROID_ADB_SERVER_PORT";
		List<String> port_list = Config_MobileAndWeb.runProcess(false, command);
		
		String port = "";
		
		for (String s : port_list) {
		    port += s;
		}
		
		if (port.isEmpty()) {
			port = "5037";
		}
		System.out.println("Adb server port " + port);
		// Jenkins Emulator
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0");
		capabilities.setCapability(AndroidMobileCapabilityType.ADB_PORT, Integer.valueOf(port));
		capabilities.setCapability(MobileCapabilityType.APP, "/var/lib/jenkins/workspace/WebSmokeAutomation/pypeStream-debug(282).apk");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "hudson_en-US_480_1080x1920_android-21_google_apis-armeabi-v7a_Emulator");
	    capabilities.setCapability("appPackage", "com.pypestream");
        capabilities.setCapability("appActivity", "com.pypestream.SplashScreenActivity");
		
		capabilities.setCapability("platform", "Windows");
		capabilities.setCapability("no-reset", "true");
		capabilities.setCapability("full-reset", "false");
		capabilities.setCapability("newCommandTimeout", 300); 

		Android_Driver = new AndroidDriver<MobileElement>(new URL(
				"http://127.0.0.1:4723/wd/hub"), capabilities);

		Android_Driver.manage()
					  .timeouts()
					  .implicitlyWait(WaitTimeConstants.WAIT_TIME_SMALL, TimeUnit.SECONDS);

		gstrResult = "FAIL";
		gstrTimetake = dts.timeNow("HH:mm:ss");
		gstrdate = dts.getCurrentDate("yyyy-MM-dd");
		gdtStartDate = new Date();

		return Android_Driver;
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws Exception {

		if (ITestResult.FAILURE == result.getStatus()) {
			TakesScreenshot ts = (TakesScreenshot) Android_Driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String FailedTC_ID = "";
			FailedTC_ID = TCID + "_Mobile" + "_" + dts.getCurrentDate("d_M_yyyy_HH_mm");
			System.out.println(screenShotsPath + FailedTC_ID + ".png");
			FileUtils.copyFile(source, new File(screenShotsPath + FailedTC_ID + ".png"));
		}

		try {
			if (Android_Driver != null) {
				Android_Driver.quit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Properties pathProps = objPathProperties.Read_FilePath();
		QnetFunctions objQnet = new QnetFunctions();
		gdbTimeTaken = objOfficeFunctions.TimeTaken(gdtStartDate);
		gstrBuild = pathProps.getProperty("Build");
		// Write the test result to excel.
		String Resultpath = pathProps.getProperty("ResultsPath");
		strResultPath = System.getProperty("user.dir") + Resultpath;

		objQnet.WriteResultdb_Excel(TCID, strTO, gstrResult, strResultPath);
	}
}