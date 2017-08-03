package lib.page;

import java.util.ArrayList;

import lib.dataObject.WebData;
import lib.locators.WebAdminTab.locators;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaframework.configuration.Config_MobileAndWeb;
import qaframework.custom.WaitForElement;
import qaframework.webElements.WaitTimeConstants;

public class WebAdminTab {

	private static String downloadPath = "D:\\SeleniumDownloads";
	public WebDriver wdriver = Config_MobileAndWeb.wdriver;
	public WebDriverWait explicitWait;
	public WaitForElement waitForElement = new WaitForElement(wdriver);
	WaitForElement objWaitForElement;

	
	 public WebAdminTab(WebDriver wdriver) {
  		this.wdriver = wdriver;
	 }
	
	/**********************************************************************************
	 * Description : This function click on "Admin" tab in Web PM Date:
	 * 09-Dec-2016 Author : Bhavana
	 **********************************************************************************/
	public void clickAdminTab() throws Exception {
		wdriver.findElement(By.xpath(locators.clickAdminTab)).click();

	}

	/**********************************************************************************
	 * Description : This function verifies the Agents page Date: 09-Dec-2016
	 * Author : Bhavana
	 **********************************************************************************/
	public void verifyAgentPageIsDisplayed() throws Exception {

		wdriver.findElement(By.xpath(WebData.verifyAgentScreen)).isDisplayed();
	}

	/**********************************************************************************
	 * Description : This function clicks on Add Agent link Date: 09-Dec-2016
	 * Author : Bhavana
	 **********************************************************************************/
	public void clickAddAgent() throws Exception {
		waitForElement.waitForElement(locators.clickAddAgent);
		wdriver.findElement(By.xpath(locators.clickAddAgent)).click();
	}

	/**********************************************************************************
	 * Description : This function verifies Add Agent page Date: 09-Dec-2016
	 * Author : Bhavana
	 **********************************************************************************/
	public void verifyAddAgentPage() throws Exception {

		wdriver.findElement(By.xpath(WebData.verifyAddAgentPage)).isDisplayed();
	}

	/**********************************************************************************
	 * Description : This function enter Agent First Name Date: 09-Dec-2016
	 * Author : Bhavana
	 **********************************************************************************/
	public void enterAgentFirstName(String aFName) throws Exception {

		wdriver.findElement(By.xpath(locators.enterAgentFN)).click();
		wdriver.findElement(By.xpath(locators.enterAgentFN)).clear();
		wdriver.findElement(By.xpath(locators.enterAgentFN)).sendKeys(aFName);
	}

	/**********************************************************************************
	 * Description : This function enter Agent Last Name Date: 09-Dec-2016
	 * Author : Bhavana
	 **********************************************************************************/
	public void enterAgentLastName(String aLName) throws Exception {

		wdriver.findElement(By.xpath(locators.enterAgentLN)).click();
		wdriver.findElement(By.xpath(locators.enterAgentLN)).clear();
		wdriver.findElement(By.xpath(locators.enterAgentLN)).sendKeys(aLName);
	}

	/**********************************************************************************
	 * Description : This function enter Agent email address Date: 09-Dec-2016
	 * Author : Bhavana
	 **********************************************************************************/
	public void enterAgentEmailAddress(String aEmail) throws Exception {

		wdriver.findElement(By.xpath(locators.enterAgentEmail)).click();
		wdriver.findElement(By.xpath(locators.enterAgentEmail)).clear();
		wdriver.findElement(By.xpath(locators.enterAgentEmail)).sendKeys(aEmail);
	}

	/**********************************************************************************
	 * Description : This function clicks on Send Invitation button Date:
	 * 09-Dec-2016 Author : Bhavana
	 **********************************************************************************/
	public void clickSendInvitationButton() throws Exception {
		wdriver.findElement(By.xpath(locators.clickSendInvitationButton)).click();
	}

	/**********************************************************************************
	 * Description : This function verifies the agent invitation sent message
	 * Date: 09-Dec-2016 Author : Bhavana
	 **********************************************************************************/
	public void verifyAgentInvitationSentMsg(String aFName, String aLName) throws Exception {
		wdriver.findElement(By.xpath("//span[contains(text(),'Agent invitation to' + " + aFName + " + " + aLName
				+ " + 'was sent successfully.')]")).click();

	}

	/**********************************************************************************
	 * Description : This function launches yopmail.com website Date:
	 * 09-Dec-2016 Author : Bhavana
	 **********************************************************************************/
	public void launchYopmail() throws Exception {
		wdriver.get(WebData.urlOfYopmail);
	}

	/**********************************************************************************
	 * Description : This function enter email of the agent and click to login
	 * see email Date: 09-Dec-2016 Author : Bhavana
	 **********************************************************************************/
	public void enterAgentEmailAddressInYopmail(String aEmail) throws Exception {
		wdriver.findElement(By.id("login")).click();
		wdriver.findElement(By.id("login")).clear();
		wdriver.findElement(By.id("login")).sendKeys(aEmail);
		wdriver.findElement(By.cssSelector("input.sbut")).click();

	}

	/**********************************************************************************
	 * Description : This function click on 'Continue' button in yopmail Date:
	 * 09-Dec-2016 Author : Bhavana
	 **********************************************************************************/
	public void clickOnContinueButton() throws Exception {
		wdriver.switchTo().frame("ifmail");
		waitForElement.waitForElement("html/body/div[1]/div[3]/div[2]/div/div[1]/table[1]/tbody/tr[1]/td[2]/a");
		wdriver.findElement(By.xpath("html/body/div[1]/div[3]/div[2]/div/div[1]/table[1]/tbody/tr[1]/td[2]/a")).click();
	}

	/**********************************************************************************
	 * Description : This function navigates the to the tab where yopmail is
	 * open Date: 13-Dec-2016 Author : Bhavana
	 **********************************************************************************/
	public void navigateToBrowserTab(String text) throws Exception {

		ArrayList<String> tabs2 = new ArrayList<String>(wdriver.getWindowHandles());
		wdriver.switchTo().window(tabs2.get(1));
		wdriver.findElement(By.xpath("//div[text()='" + text + "']")).isDisplayed();
	}

	/**********************************************************************************
	 * Description : This function enter Agent password Date: 09-Dec-2016 Author
	 * : Bhavana
	 **********************************************************************************/
	public void enterAgentPassword(String aPassword) throws Exception {

		wdriver.findElement(By.xpath("//input[@placeholder ='Please enter a password']")).click();
		wdriver.findElement(By.xpath("//input[@placeholder='Please enter a password']")).clear();
		wdriver.findElement(By.xpath("//input[@placeholder='Please enter a password']")).sendKeys(aPassword);

	}

	/**********************************************************************************
	 * Description : This function re-enter Agent password Date: 09-Dec-2016
	 * Author : Bhavana
	 **********************************************************************************/
	public void reEnterAgentPassword(String reAPwd) throws Exception {

		wdriver.findElement(By.xpath("//input[@placeholder='Please re-enter your password']")).click();
		wdriver.findElement(By.xpath("//input[@placeholder='Please re-enter your password']")).clear();
		wdriver.findElement(By.xpath("//input[@placeholder='Please re-enter your password']")).sendKeys(reAPwd);
	}

	/**********************************************************************************
	 * Description : This function re-enter Agent password Date: 09-Dec-2016
	 * Author : Bhavana
	 **********************************************************************************/
	public void clickContinueInAgentPage() throws Exception {

		wdriver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	/**********************************************************************************
	 * Description : This function clicks on Chatlog attachments in mail Date:
	 * 16-Dec-2016 Author : Manjula
	 **********************************************************************************/
	public void clickAttachmentOfChatLog() throws Exception {

		wdriver.switchTo().frame("ifmail");
		wdriver.findElement(By.xpath("//div[1]/a[@class = 'mgif pj']")).click();

		// Assert.assertTrue(isFileDownloaded_Ext(downloadPath, ".json"),
		// "Failed to download document which has extension .json");

	}

	/**************************************************************************************
	 * Description : This function clicks on Edit Agent button Date :
	 * 24-Jan-2017 Author : Yugender
	 **************************************************************************************/
	public boolean clickOnEditAgentButton(String AgentName) throws Exception {
		
		String xpath = String.format(
				"//div[contains(text(),'%s')]/parent::div/parent::div/parent::div/parent::div/"
				+ "parent::div/div/div/div/div/div[@class='public_fixedDataTableCell_cellContent']/img",
				AgentName);
		if (waitForElement.isElementPresent(By.xpath(xpath))) {
			wdriver.findElement(By.xpath(xpath)).click();
			return true;
		} else {
			return false;
		}
	}

	/**************************************************************************************
	 * Description : This function clicks on Remove Agent button Date :
	 * 24-Jan-2017 Author : Yugender
	 **************************************************************************************/
	public void clickRemoveAgentButton() throws Exception {
		wdriver.findElement(By.xpath(WebData.removeAgentButton)).click();
	}

	/**************************************************************************************
	 * Description : This function verifies agent removal confirmation in Web PM
	 * Date : 24-Jan-2017 Author : Yugender
	 **************************************************************************************/
	public void verifyAgentRemovalConfirmation(String confirm_text) throws Exception {
		String pypeNameFromGetElement = wdriver.findElement(By.xpath(WebData.confirmAgentRemoval)).getText();

		Assert.assertEquals(pypeNameFromGetElement, confirm_text);
	}

	/**************************************************************************************
	 * Description : This function clicks on Confirm Remove Agent button Date :
	 * 24-Jan-2017 Author : Yugender
	 **************************************************************************************/
	public void clickConfirmRemoveAgentButton() throws Exception {

		wdriver.findElement(By.xpath(WebData.confirmRemoveAgentButton)).click();
	}

	/**************************************************************************************
	 * Description : This function verifies Agent Removed Notification Date :
	 * 24-Jan-2017 Author : Yugender
	 **************************************************************************************/
	public void verifyAgentRemovedMessage() throws Exception {

		String confirmMessage = wdriver.findElement(By.xpath(WebData.notificationMessage)).getText();
		Assert.assertEquals(confirmMessage, "Agent was successfully removed");
	}

	/**************************************************************************************
	 * Description : This function clicks on Edit Agent button Date :
	 * 24-Jan-2017 Author : Yugender
	 **************************************************************************************/
	public void verifyAgentEmailIdExist(String AgentEmail) throws Exception {

		wdriver.findElement(By.xpath("//div[contains(text(),'" + AgentEmail + "')]")).isDisplayed();
	}

	/**************************************************************************************
	 * Description : This function verifies the notification message Date :
	 * 24-Jan-2017 Author : Yugender
	 **************************************************************************************/
	public void verifyNotificationMessage(String mMessage) throws Exception {

		// waitForElement.waitForElement(WebData.notificationMessage);
		String confirmMessage = ""; //wdriver.findElement(By.xpath(WebData.notificationMessage)).getText();
//		System.out.println("confirmMessage: " + confirmMessage);
		while (confirmMessage == null || confirmMessage.isEmpty()) {
			confirmMessage = wdriver.findElement(By.xpath(WebData.notificationMessage)).getText();
			if (!confirmMessage.isEmpty()) {
				wdriver.findElement(By.xpath(WebData.notificationClose)).click();
			}
			System.out.println("confirmMessage: " + confirmMessage);
		}
		Assert.assertEquals(confirmMessage, mMessage);
	}

	/**************************************************************************************
	 * Description : This function verifies the notification message Date :
	 * 24-Jan-2017 Author : Yugender
	 **************************************************************************************/
	public void clickOnAutoresponse() throws Exception {
		wdriver.findElement(By.xpath(WebData.autoresponses)).isDisplayed();
		wdriver.findElement(By.xpath(WebData.autoresponses)).click();
	}

	/**************************************************************************************
	 * Description : This function verifies the notification message Date :
	 * 24-Jan-2017 Author : Yugender
	 **************************************************************************************/
	public void verifyOfflineAutoresponseIsEnabled() throws Exception {
		wdriver.findElement(By.xpath(WebData.offlineAutoresponseCheckboxEnabled)).isDisplayed();
	}

	/**************************************************************************************
	 * Description : This function verifies the notification message Date :
	 * 24-Jan-2017 Author : Yugender
	 **************************************************************************************/
	public String getOfflineAutoresponseMessage() throws Exception {
		wdriver.findElement(By.xpath(WebData.offlineAutoresponseMessage)).isDisplayed();
		return wdriver.findElement(By.xpath(WebData.offlineAutoresponseMessage)).getText();
	}

	/**************************************************************************************
	 * Description : This function clicks on checkbox of Autoresponder in Admin
	 * tab Date :154-Feb-2017 Author : Sowmya
	 **************************************************************************************/
	public void clickToEnableTheOfflineAutoresponder() throws Exception {
		waitForElement.waitForElement(WebData.clickOnAutoresponderCheckbox);
		wdriver.findElement(By.xpath(WebData.clickOnAutoresponderCheckbox)).click();
	}

	/**************************************************************************************
	 * Description : This function clicks on checkbox of Autoresponder in Admin
	 * tab Date :154-Feb-2017 Author : Sowmya
	 **************************************************************************************/
	public void clickToSaveAutoresponderChanges() throws Exception {
		waitForElement.waitForElement(WebData.saveAutoresponderChanges);
		wdriver.findElement(By.xpath(WebData.saveAutoresponderChanges)).click();
	}

	/**************************************************************************************
	 * Description : This function verifies busy auto-response is enabled Date :
	 * 20-Feb-2017 Author : Yugender
	 **************************************************************************************/
	public void verifyBusyeAutoresponseIsEnabled() throws Exception {
		wdriver.findElement(By.xpath(WebData.busyAutoResponseCheckboxEnabled)).isDisplayed();
	}

	/**************************************************************************************
	 * Description : This function fetches busy auto-response message Date :
	 * 20-Feb-2017 Author : Yugender
	 **************************************************************************************/
	public String getBusyAutoresponseMessage() throws Exception {
		return wdriver.findElement(By.xpath(WebData.busyAutoResponseMessage)).getText();
	}

	/**************************************************************************************
	 * Description : This function disable agent initiate chat Date : 6-Mar-2017
	 * Author : Yugender
	 **************************************************************************************/
	public void disableAgentInitiateChat() throws Exception {
		wdriver.findElement(By.xpath(WebData.agentInitiateChatEnabled)).isDisplayed();
		wdriver.findElement(By.xpath(WebData.agentInitiateChatEnabled)).click();
		wdriver.findElement(By.xpath(WebData.clickConfirmButton)).click();
	}

	/**************************************************************************************
	 * Description : This function enable agent initiate chat Date : 6-Mar-2017
	 * Author : Yugender
	 **************************************************************************************/
	public void enableAgentInitiateChat() throws Exception {
		wdriver.findElement(By.xpath(WebData.agentInitiateChatDisabled)).isDisplayed();
		wdriver.findElement(By.xpath(WebData.agentInitiateChatDisabled)).click();
		wdriver.findElement(By.xpath(WebData.clickConfirmButton)).click();
	}

	/**************************************************************************************
	 * Description : This function clicks on agent tab in web Date :3-april-2017
	 * Author : Sowmya
	 **************************************************************************************/
	public void clickAgentTab() throws Exception {
		waitForElement.waitForElement(WebData.clickAgentTab);
		wdriver.findElement(By.xpath(WebData.clickAgentTab)).click();
	}

	public void verifyInitiateChat() throws Exception {
		waitForElement.waitForElement(WebData.initiateChats);
		wdriver.findElement(By.xpath(WebData.initiateChats)).isDisplayed();
	}

	public void clickNotificationClose() throws Exception {
		if (wdriver.findElement(By.xpath(WebData.notificationClose)).isDisplayed()) {
			wdriver.findElement(By.xpath(WebData.notificationClose)).click();
		}
	}
	
	/**********************************************************************************
	 * Description : This function is to click on 'Web chat widget'.  
	 * Date        : 08-Feb-2016
	 * Author      : QSG
	 **********************************************************************************/
	public void clickOnWebChatWidget() throws Exception {
		wdriver.findElement(By.xpath(WebData.webChatWidget)).click();
	}
}
