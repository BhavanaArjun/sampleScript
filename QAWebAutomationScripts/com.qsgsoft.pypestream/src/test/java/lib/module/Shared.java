package lib.module;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import qaframework.custom.WaitForElement;
import qaframework.webElements.ElementList;

public class Shared extends ElementList {

	AndroidDriver<MobileElement> driver;
	WaitForElement wait;

	public Shared(AndroidDriver<MobileElement> _driver) throws Exception {
		super(_driver);
		this.driver = _driver;
		wait = new WaitForElement(this.driver);
	}

	private String selectEnvQa = "com.pypestream:id/qa",
				   //selectEnvQa = "com.pypestream:id/tv_intro_qabox",
			// selectProductionEnv = "com.pypestream:id/live",
			// selectEnvQa = "//android.widget.TextView[contains(@resource-id,
			// 'com.pypestream:id/qa') and @text = 'V3-QA']",
			// selectEnvQa = "com.pypestream:id/qa",
			// selectEnvStage = "com.pypestream:id/staging",
			// selectProductionEnv = "com.pypestream:id/live",
		//	selectEnvQabox = "com.pypestream:id/tv_intro_qabox",
			closeChooseEnv = "com.pypestream:id/close", settingTab = "com.pypestream:id/tab4",
			// Jan 18
			exploreTab = "com.pypestream:id/tab4", searchPype = "com.pypestream:id/edit_search",
			logoutButton = "com.pypestream:id/btn_logout";
	

	public void checkLogin() throws Exception {
		// driver.findElementById(clickAllowOnLoginPermissionAccessPopUp).click();
		// if
		// (this.element_wait("//android.widget.Button[contains(@resource-id,'com.android.packageinstaller:id/permission_allow_button')
		// and @text='Allow']"));

		if (this.element_wait("com.pypestream:id/login", "id").isElementPresent()) {
			clickToSelectEnvironment();
		} else {
			
			clickSettingTab();
			clickLogoutButton();
			clickToSelectEnvironment();
		}

	}

	/**********************************************************************************
	 * Description : This function click on home screen to select environment
	 * Date : 12-Oct-2016 Author : Bhavana
	 **********************************************************************************/
	public Shared clickToSelectEnvironment() throws Exception {
		for (int i = 0; i < 7; i++) {
			// driver.tap(1,0,38,1);
//			 driver.tap(1,0,48,1); //Moto g
//			driver.tap(1, 0, 228, 1);
			// Moto e
			// driver.tap(1, 0, 456, 1); //Emulator 4.95
//			 driver.tap(1,0,72,1); //(Lenevo)
			String logo = "com.pypestream:id/ic_intro";
			WebElement element = driver.findElement(By.id(logo));
			driver.tap(1, element, 1);
			/*
			 * WebElement s =
			 * driver.findElementById("com.pypestream:id/intro_layout");
			 * driver.tap(1, s, 1); //Jenkins Emulator
			 */ 
		}
		this.element_wait(selectEnvQa, "id").waitForVisibilityOfElement();
		this.element(selectEnvQa, "id").click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function re-launch the app Date : 12-Oct-2016 Author :
	 * Bhavana
	 **********************************************************************************/

	public Shared lApp() throws Exception {
		this.driver.closeApp();
		this.driver.launchApp();
		return this;
	}

	/************************************************************************************************
	 * Description : This function verifies the appropriate environment is
	 * selected and close pop-up Date : 05-Nov-2016 Author : Bhavana
	 *************************************************************************************************/

	public Shared verifyEnvSelected() throws Exception {
		for (int i = 0; i < 7; i++) {
			// driver.tap(1, 0, 38, 1);
//			driver.tap(1,0,48,1);  //Moto g
//			driver.tap(1, 0, 228, 1); // Moto e
			// driver.tap(1, 0, 456, 1); //Emulator 4.95
//			 driver.tap(1,0,72,1); //(Lenovo)
			String logo = "com.pypestream:id/ic_intro";
			WebElement element = driver.findElement(By.id(logo));
			driver.tap(1, element, 1);
		}
		driver.findElementById(selectEnvQa).isDisplayed();
		this.element(closeChooseEnv, "id").click();
		return this;
	}

	/**********************************************************************************
	 * Description : This function clicks on "Setting" tab Date : 12-Oct-2016
	 * Author : Bhavana
	 **********************************************************************************/
	public void clickSettingTab() throws Exception {
		
		this.element_wait(settingTab, "id").waitForVisibilityOfElement();
		this.element(settingTab, "id").click();
	}

	/**********************************************************************************
	 * Description : This function click on "Logout" button Date : 12-Oct-2016
	 * Author : Bhavana
	 **********************************************************************************/
	public void clickLogoutButton() throws Exception {
		this.element_wait(logoutButton, "id").waitForVisibilityOfElement();
		this.element(logoutButton, "id").click();
		
	}

	/**********************************************************************************
	 * Description : This function is used to install the 'Pypestream' app Date
	 * : 30-Sep-2016 Author : Bhavana
	 ***********************************************************************************/
	public Shared unInstallandInstallApp(String appPath) throws Exception {
		this.driver.installApp("C:/Users/manjula/AppData/Local/Android/sdk1/platform-tools/pypeStream-debug(265).apk");
		this.driver.launchApp();
		return this;
	}

	/**********************************************************************************
	 * Description : This function scrolls the Pypes in "Explore" tab Date :
	 * 30-Sep-2016 Author : Bhavana
	 ***********************************************************************************/
	public void scrollDown() throws Exception {
		Dimension dimensions = driver.manage().window().getSize();
		// System.out.println("Size of Window= " +dimensions);
		int scrollStart = (int) (dimensions.getHeight() * 0.5);
		// System.out.println("Size of scrollStart= " +scrollStart);
		int scrollEnd = (int) (dimensions.getHeight() * 0.2);
		// System.out.println("Size of cscrollEnd= " + scrollEnd);
		driver.swipe(0, scrollStart, 0, scrollEnd, 1000);

	}

	/**********************************************************************************
	 * Description : This function close the app Date : 09-Jan-2017 Author
	 * :Manjula
	 **********************************************************************************/

	public Shared closeApp() throws Exception {
		this.driver.closeApp();
		// this.driver.launchApp();
		return this;
	}
	


	/**********************************************************************************
	 * Description : This function launch the app Date : 09-Jan-2017 Author
	 * :Manjula
	 **********************************************************************************/

	public Shared launchApp() throws Exception {
		this.driver.launchApp();
		return this;
	}
}
