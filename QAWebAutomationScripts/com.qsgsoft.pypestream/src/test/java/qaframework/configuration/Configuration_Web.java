package qaframework.configuration;
 
 
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
 
import java.lang.reflect.Method;
import java.net.URL;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.UserDefinedFunctions.QnetFunctions;
import qaframework.webElements.WaitTimeConstants;

 
public class Configuration_Web {
 
    public WebDriver wdriver = null;
    public static WebDriverWait waitVar = null;
 
    @SuppressWarnings("rawtypes")
    public static Class className;
    public static String strReason, gstrdate, gstrBuild, gstrTimetake, gstrFailureReason, TCID, strTO, strResultPath,
            strSessionId = "";
    public static Date gdtStartDate;
    public String gstrResult;
    protected String gstrReason;
    protected double gdbTimeTaken;
    public static long gslsysDateTime;
	private String sessionId;
 
    PathsProperties objPathProperties = new PathsProperties();
    OfficeCommonFunctions objOfficeFunctions = new OfficeCommonFunctions();
 
 
    @SuppressWarnings("static-access")
	@Parameters({"myBrowser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String myBrowser) throws Exception {
 
        String strDownloadPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Downloads";
 
        /*
         * FirefoxProfile profile = new FirefoxProfile();
         * 
         * profile.setPreference("browser.download.folderList", 2);
         * profile.setPreference("browser.download.dir", strDownloadPath);
         * profile.setPreference("browser.download.manager.alertOnEXEOpen",
         * false); profile.setPreference(
         * "browser.helperApps.neverAsk.saveToDisk",
         * "application/msword, application/csv, application/ris, text/csv, image/png, application/pdf, text/html, text/plain, application/zip, application/x-zip, application/x-zip-compressed, application/download, application/octet-stream"
         * ); profile.setPreference("browser.download.manager.showWhenStarting",
         * false);
         * profile.setPreference("browser.download.manager.focusWhenStarting",
         * false); profile.setPreference("browser.download.useDownloadDir",
         * true); profile.setPreference("browser.helperApps.alwaysAsk.force",
         * false);
         * profile.setPreference("browser.download.manager.alertOnEXEOpen",
         * false);
         * profile.setPreference("browser.download.manager.closeWhenDone",
         * true);
         * profile.setPreference("browser.download.manager.showAlertOnComplete",
         * false); profile.setPreference("browser.download.manager.useWindow",
         * false); profile.setPreference(
         * "services.sync.prefs.sync.browser.download.manager.showWhenStarting",
         * false); profile.setPreference("pdfjs.disabled", true);
         */
        
        if(myBrowser.equals("chrome")){
            //DesiredCapabilities capability = new DesiredCapabilities().chrome();
            
            System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
            /*capability.setBrowserName("chrome");
            capability.setPlatform(Platform.LINUX);*/
            wdriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities().chrome());
            
            wdriver.manage().deleteAllCookies();
            wdriver.manage().timeouts().implicitlyWait(WaitTimeConstants.WAIT_TIME, TimeUnit.SECONDS);
            wdriver.manage().timeouts().pageLoadTimeout(WaitTimeConstants.WAIT_TIME_TOO_LONG, TimeUnit.SECONDS);
            wdriver.manage().window().maximize();
        }
        else if (myBrowser.equals("firefox")){
        	
			DesiredCapabilities cap = new DesiredCapabilities().firefox();
			cap.setJavascriptEnabled(true);
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WINDOWS);
			
			wdriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			wdriver.manage().window().maximize();
			wdriver.manage().timeouts().implicitlyWait(WaitTimeConstants.WAIT_TIME, TimeUnit.SECONDS);
			System.out.println("Firefox driver Session has Started");
          /*  DesiredCapabilities capability = new DesiredCapabilities().firefox();
            capability.setBrowserName("firefox");
            capability.setPlatform(Platform.WINDOWS);
            wdriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);*/
        }
 
        //DesiredCapabilities cap = new DesiredCapabilities();
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
	    
       //System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver"); 
       System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");*/
        //System.setProperty("webdriver.chrome.wdriver", System.getProperty(
                 //"webdriver.chrome.wdriver", "/usr/local/bin/chromedriver")); //"/var/lib/jenkins/node_modules/chromedriver/lib/chromedriver/chromedriver"));
     
        // System.setProperty("webdriver.chrome.wdriver", System.getProperty(
	//			"webdriver.chrome.wdriver", "/chromedriver.exe"));
 
        /*cap.setCapability(ChromeOptions.CAPABILITY, options);
        cap.setBrowserName("Chrome");
        wdriver = new ChromeDriver(cap);*/
	    
        //DesiredCapabilities caps = DesiredCapabilities.chrome();
      //  cap.setCapability("browserName", "chrome");
        //cap.setCapability("platform", "Windows 10");
       // cap.setCapability("version", "56.0");
        //cap.setCapability("screenResolution", "1024x768");
      //  cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);	

       // cap.setCapability("name", "Sauce lab test");
 	
     	//cap.setCapability("build", System.getenv("JOB_NAME") + "__" + System.getenv("BUILD_NUMBER"));
        
        
	//cap.setCapability(CapabilityType.BROWSER_NAME, "Chrome");

       //cap.setCapability(CapabilityType.VERSION, "56.0.2924.87");

      // cap.setCapability(CapabilityType.PLATFORM, "Windows 7");	 
      // cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);	

      // cap.setCapability("name", "Sauce lab test");
	
    	//cap.setCapability("build", System.getenv("JOB_NAME") + "__" + System.getenv("BUILD_NUMBER"));
       // wdriver = new RemoteWebDriver(new URL("http://192.168.25.113:5566/wd/hub"),cap);
        //wdriver = new RemoteWebDriver(new URL("http://192.168.25.97:5588/wd/hub"),cap);
	/*wdriver = new RemoteWebDriver(
                new URL("https://bhavanaqsg:55464ac9-d4b5-4fee-b055-8d4fe5e0a0ae@ondemand.saucelabs.com:443/wd/hub"),
                cap);*/

	  //  sessionId = (((RemoteWebDriver) wdriver).getSessionId()).toString();
	    
	    //wdriver.manage().window().setSize(new Dimension(1024, 768));
	    
        /*wdriver.manage().deleteAllCookies();
        wdriver.manage().timeouts().implicitlyWait(WaitTimeConstants.WAIT_TIME, TimeUnit.SECONDS);
        wdriver.manage().timeouts().pageLoadTimeout(WaitTimeConstants.WAIT_TIME_TOO_LONG, TimeUnit.SECONDS);
        wdriver.manage().window().maximize();*/

        Config_MobileAndWeb.wdriver = wdriver;
        
	           /* String message = String.format("SauceOnDemandSessionID=%1$s job-name=%2$s",
        	    (((RemoteWebDriver) wdriver).getSessionId()).toString(), "WebChatWidget Job");
        	    System.out.println(message);*/
        
        
        /*
         * wdriver = new FirefoxDriver(profile);
         * wdriver.manage().deleteAllCookies(); wdriver.manage().timeouts()
         * .implicitlyWait(WaitTimeConstants.WAIT_TIME, TimeUnit.SECONDS);
         * wdriver.manage() .timeouts()
         * .pageLoadTimeout(WaitTimeConstants.WAIT_TIME_TOO_LONG,
         * TimeUnit.SECONDS); wdriver.manage().window().maximize();
         * 
         * waitVar = new WebDriverWait(wdriver, 180);
         */
 
        gstrResult = "FAIL";
        Date_Time_settings dts = new Date_Time_settings();
 
        gstrTimetake = dts.timeNow("HH:mm:ss");
        gstrdate = dts.getCurrentDate("yyyy-MM-dd");
        gdtStartDate = new Date();
    }
	
    private DesiredCapabilities DesiredCapabilities() {
		// TODO Auto-generated method stub
		return null;
	}

	@DataProvider(name = "hardCodedBrowsers", parallel = true)
    public static Object[][] sauceBrowserDataProvider(Method testMethod) {
        return new Object[][]{
                new Object[]{"chrome", "Windows 7"},
        };
    }
    
 
    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        Thread.sleep(1000);

        try {
            if (wdriver != null) {
                wdriver.close();
                wdriver.quit();
                wdriver = null;
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
 
       // objQnet.WriteResultdb_Excel(TCID, strTO, gstrResult, strResultPath);
    }
}
