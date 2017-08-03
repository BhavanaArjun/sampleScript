package qaframework.configuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class Config_MobileAndWeb {

	public static AndroidDriver<MobileElement> driver;
	public static WebDriver wdriver = null;
	public static WebDriverWait waitVar = null;

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
	
	private static final String[] WIN_RUNTIME = { "cmd.exe", "/C" };
	private static final String[] OS_LINUX_RUNTIME = { "/bin/bash", "-l", "-c" };
	Date_Time_settings dts = new Date_Time_settings();
	
	public String screenShotsPath;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {

		String strDownloadPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Downloads";
		
		Properties pathProps = objPathProperties.Read_FilePath();
		String path = Paths.get(".").toAbsolutePath().normalize().toString();
		System.out.println(path);
		screenShotsPath = path + pathProps.getProperty("failedScreenshots");

		DesiredCapabilities cap = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-extensions");
		/*System.setProperty("webdriver.chrome.wdriver", System.getProperty(
				"webdriver.chrome.wdriver", "C:\\Windows\\chromedriver.exe"));*/
		//System.setProperty("webdriver.chrome.driver","C:/Windows/chromedriver.exe");
		System.setProperty("webdriver.chrome.wdriver", System.getProperty(
				"webdriver.chrome.wdriver", "/var/lib/jenkins/node_modules/chromedriver/lib/chromedriver/chromedriver"));
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		cap.setBrowserName("Chrome");
		wdriver = new ChromeDriver(cap);
		wdriver.manage().deleteAllCookies();
		wdriver.manage().timeouts()
				.implicitlyWait(WaitTimeConstants.WAIT_TIME, TimeUnit.SECONDS);
		wdriver.manage()
				.timeouts()
				.pageLoadTimeout(WaitTimeConstants.WAIT_TIME_TOO_LONG,
						TimeUnit.SECONDS);
		wdriver.manage().window().maximize();

		// Launch mobile app
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");

		// Moto G
		/*capabilities.setCapability("VERSION", "6.0");
		capabilities.setCapability("deviceName", "ZX1D63B2HD");
		capabilities.setCapability("platformVersion", "23");*/
		
		// Moto E
		/*capabilities.setCapability("VERSION", "5.1");
		capabilities.setCapability("deviceName", "ZX1B33TBVS");
		capabilities.setCapability("platformVersion", "22");*/
		
		// Lenovo
		/*capabilities.setCapability("VERSION", "6.0");
		capabilities.setCapability("deviceName", "TS8TOJI7NVNJZDRO");
		capabilities.setCapability("platformVersion", "23");*/
		
		//Android 6 emulator
		/*capabilities.setCapability("VERSION", "6.0");
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("platformVersion", "23");*/
		
		String command = "echo $ANDROID_ADB_SERVER_PORT";
		java.util.List<String> port_list = runProcess(false, command);
		
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
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4");
		capabilities.setCapability(AndroidMobileCapabilityType.ADB_PORT, Integer.valueOf(port));
		capabilities.setCapability(MobileCapabilityType.APP, "/var/lib/jenkins/workspace/WebSmokeAutomation/pypeStream-debug(282).apk");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "hudson_en-US_480_1080x1920_android-19_google_apis-armeabi-v7a_Emulator");
	
		capabilities.setCapability("platform", "Windows");

		capabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
		  
		Android_Driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), 
				capabilities);

		Android_Driver.manage()
					  .timeouts()
					  .implicitlyWait(WaitTimeConstants.WAIT_TIME_LONG, TimeUnit.SECONDS);

		gstrResult = "FAIL";
		
		gstrTimetake = dts.timeNow("HH:mm:ss");
		gstrdate = dts.getCurrentDate("yyyy-MM-dd");
		gdtStartDate = new Date();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws Exception {

		if (ITestResult.FAILURE == result.getStatus()) {
			TakesScreenshot ts = (TakesScreenshot) wdriver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String FailedTC_ID = "";
			FailedTC_ID = TCID + "_" + dts.getCurrentDate("d_M_yyyy_HH_mm");
			System.out.println(screenShotsPath + FailedTC_ID + ".png");
			FileUtils.copyFile(source, new File(screenShotsPath + FailedTC_ID + ".png"));
		}

		if (ITestResult.FAILURE == result.getStatus()) {
			TakesScreenshot ts = (TakesScreenshot) Android_Driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String FailedTC_ID = "";
			FailedTC_ID = TCID + "_Mobile" + "_" + dts.getCurrentDate("d_M_yyyy_HH_mm");
			System.out.println(screenShotsPath + FailedTC_ID + ".png");
			FileUtils.copyFile(source, new File(screenShotsPath + FailedTC_ID + ".png"));
		}

		try {
			if (wdriver != null) {
				wdriver.close();
				wdriver.quit();
				wdriver = null;
			}
			if (Android_Driver != null) {
				Android_Driver.quit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Properties pathProps = objPathProperties.Read_FilePath();
		QnetFunctions objQnet = new QnetFunctions();
		// gdbTimeTaken = objOfficeFunctions.TimeTaken(gdtStartDate);
		gstrBuild = pathProps.getProperty("Build");
		// Write the test result to excel.
		String Resultpath = pathProps.getProperty("ResultsPath");
		strResultPath = System.getProperty("user.dir") + Resultpath;

		objQnet.WriteResultdb_Excel(TCID, strTO, gstrResult, strResultPath);

	}
	
	private static <T> T[] concat(T[] first, T[] second) {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    public static java.util.List<String> runProcess(boolean isWin, String... command) {
        System.out.print("command to run: ");
        for (String s : command) {
            System.out.print(s);
        }
        System.out.print("\n");
        String[] allCommand = null;
        try {
            if (isWin) {
                allCommand = concat(WIN_RUNTIME, command);
            } else {
                allCommand = concat(OS_LINUX_RUNTIME, command);
            }
            ProcessBuilder pb = new ProcessBuilder(allCommand);
            pb.redirectErrorStream(true);
            Process p = pb.start();
            p.waitFor();
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String _temp = null;
            java.util.List<String> line = new ArrayList<String>();
            while ((_temp = in.readLine()) != null) {
                System.out.println("temp line: " + _temp);
                line.add(_temp);
            }
            System.out.println("result after command: " + line);
            return line;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}