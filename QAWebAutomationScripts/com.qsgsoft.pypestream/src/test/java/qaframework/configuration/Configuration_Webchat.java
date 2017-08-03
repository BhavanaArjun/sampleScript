package qaframework.configuration;
 
 
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
 
 
 
 
 


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
 


import qaframework.lib.UserDefinedFunctions.Date_Time_settings;
import qaframework.lib.UserDefinedFunctions.OfficeCommonFunctions;
import qaframework.lib.UserDefinedFunctions.PathsProperties;
import qaframework.lib.UserDefinedFunctions.QnetFunctions;
import qaframework.webElements.WaitTimeConstants;
 
public class Configuration_Webchat {
 
    public static WebDriver wdriver = null;
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
 
    PathsProperties objPathProperties = new PathsProperties();
    OfficeCommonFunctions objOfficeFunctions = new OfficeCommonFunctions();
 
 
    @BeforeMethod(alwaysRun = true)
    public void setUp1() throws Exception { 
    	gstrResult = "FAIL";
    	Date_Time_settings dts = new Date_Time_settings();
        
        gstrTimetake = dts.timeNow("HH:mm:ss");
        gstrdate = dts.getCurrentDate("yyyy-MM-dd");
        gdtStartDate = new Date();
    }
    
 
    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
 
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
 
        DesiredCapabilities cap = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
	    
      // System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver"); 
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.wdriver", System.getProperty(
                 //"webdriver.chrome.wdriver", "/usr/local/bin/chromedriver")); //"/var/lib/jenkins/node_modules/chromedriver/lib/chromedriver/chromedriver"));
     
        // System.setProperty("webdriver.chrome.wdriver", System.getProperty(
	//			"webdriver.chrome.wdriver", "/chromedriver.exe"));
 
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        cap.setBrowserName("Chrome");
        wdriver = new ChromeDriver(cap);
        wdriver.manage().deleteAllCookies();
        wdriver.manage().timeouts().implicitlyWait(WaitTimeConstants.WAIT_TIME, TimeUnit.SECONDS);
        wdriver.manage().timeouts().pageLoadTimeout(WaitTimeConstants.WAIT_TIME_TOO_LONG, TimeUnit.SECONDS);
        wdriver.manage().window().maximize();
 
        Config_MobileAndWeb.wdriver = wdriver;
        
        
        
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
 
    @AfterClass(alwaysRun = true)
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
    }
        @AfterMethod(alwaysRun = true)
        public void tearDown1() throws Exception {
            Thread.sleep(1000);
        Properties pathProps = objPathProperties.Read_FilePath();
        QnetFunctions objQnet = new QnetFunctions();
        // gdbTimeTaken = objOfficeFunctions.TimeTaken(gdtStartDate);
        gstrBuild = pathProps.getProperty("Build");
        // Write the test result to excel.
        String Resultpath = pathProps.getProperty("ResultsPath");
        strResultPath = System.getProperty("user.dir") + Resultpath;
 
        //objQnet.WriteResultdb_Excel(TCID, strTO, gstrResult, strResultPath);
    }
}
