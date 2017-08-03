package lib.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import lib.dataObject.WebData;
import lib.locators.WebSignUpAndSignIn.locators;
import qaframework.configuration.Config_MobileAndWeb;
import qaframework.custom.WaitForElement;

public class WebSignUpAndSignIn {

	public WebDriver wdriver = Config_MobileAndWeb.wdriver;
	// public WebDriver wChdriver = Config_MobileAndWeb.wChdriver;
	public WebDriverWait explicitWait;
	public WaitForElement waitForElement = new WaitForElement(wdriver);

	/**********************************************************************************
	 * Description : This function launches Pypestream application in Web PM
	 * Date : 07-Oct-2016 Author : Bhavana
	 *********************************************************************************/
	public void launchPypestreamGetPypeUrl() throws Exception {
		wdriver.get(WebData.urlQAToAddPype);

	}

	/**********************************************************************************
	 * Description : This function launches Pypestream application in Web PM
	 * Date : 07-Oct-2016 Author : Bhavana
	 *********************************************************************************/
	public void launchPypestream() throws Exception {
		wdriver.get(locators.QAUrl);
		wdriver.findElement(By.xpath(locators.signin)).isDisplayed();
	}

	/**********************************************************************************
	 * Description : This function click on Get a Pype link in Web PM Date :
	 * 07-Oct-2016 Author : Bhavana
	 *********************************************************************************/
	public void clickOnGetAPypeLink() throws Exception {
		wdriver.findElement(By.xpath(WebData.getPypeLink)).click();

	}

	/**************************************************************************************
	 * Description : This function verifies "Set Your Password" page is
	 * displayed in Web PM Date : 07-Oct-2016 Author : Bhavana
	 **************************************************************************************/
	public void verifySetYourPassword() throws Exception {
		wdriver.findElement(By.xpath(WebData.setPwdHeader)).isDisplayed();
	}

	/**************************************************************************************
	 * Description : This function enters email in Web PM Date : 07-Oct-2016
	 * Author : Bhavana
	 **************************************************************************************/
	public void enterEmail() throws Exception {
		wdriver.findElement(By.xpath(locators.wloginId)).click();
		wdriver.findElement(By.xpath(locators.wloginId)).sendKeys(WebData.wEmailId);
	}

	/**************************************************************************************
	 * Description : This function enters password in "Password" field Web PM
	 * Date : 07-Oct-2016 Author : Bhavana
	 **************************************************************************************/
	public void enterPwd() throws Exception {
		wdriver.findElement(By.xpath(locators.wPassword)).click();
		wdriver.findElement(By.xpath(locators.wPassword)).sendKeys(WebData.wpassword);
	}

	/**************************************************************************************
	 * Description : This function enters password in "Confirm Password" field
	 * in Web PM Date : 07-Oct-2016 Author : Bhavana
	 **************************************************************************************/
	public void enterConfirmPwd() throws Exception {
		wdriver.findElement(By.xpath(WebData.wConfirmPwd)).click();
		wdriver.findElement(By.xpath(WebData.wConfirmPwd)).sendKeys(WebData.wpassword);
	}

	/**************************************************************************************
	 * Description : This function click on "Continue" button Web PM Date :
	 * 07-Oct-2016 Author : Bhavana
	 **************************************************************************************/
	public void clickSetPwdContinue() throws Exception {
		wdriver.findElement(By.xpath(WebData.setPwdContinue)).click();

	}

	/**************************************************************************************
	 * Description : This function verifies "Company Info" page is displayed Web
	 * PM Date : 07-Oct-2016 Author : Bhavana
	 **************************************************************************************/
	public void verifyCompanyInfoPage() throws Exception {
		wdriver.findElement(By.xpath(WebData.yourCompanyInfo)).isDisplayed();
		// assertTrue(waitForElement.isElementPresent(By.xpath(WebData.yourCompanyInfo)));

	}

	/**************************************************************************************
	 * Description : This function enters Pype name in Web PM Date : 07-Oct-2016
	 * Author : Bhavana
	 **************************************************************************************/
	public void enterPypeName() throws Exception {
		waitForElement.waitForElement(WebData.nameOfPype);
		// wdriver.findElement(By.xpath(WebData.nameOfPype)).clear();
		wdriver.findElement(By.xpath(WebData.nameOfPype)).sendKeys(WebData.pypeName);
	}

	/**************************************************************************************
	 * Description : This function select Industry in Web PM Date : 07-Oct-2016
	 * Author : Bhavana
	 **************************************************************************************/
	public void selectIndustry() throws Exception {
		WebElement element = wdriver.findElement(By.xpath(WebData.industry));
		Select se = new Select(element);
		se.selectByIndex(1);

	}

	/**************************************************************************************
	 * Description : This function click on "Continue" button Web PM Date :
	 * 07-Oct-2016 Author : Bhavana
	 **************************************************************************************/
	public void clickContinueInPypeInfoPage() throws Exception {
		wdriver.findElement(By.xpath(WebData.companyInfoContinue)).click();

	}

	/**************************************************************************************
	 * Description : This function verifies that "Almost Done" page is displayed
	 * in Web PM Date : 07-Oct-2016 Author : Bhavana
	 **************************************************************************************/
	public void verifyAlmostDonePage() throws Exception {
		wdriver.findElement(By.xpath(WebData.almostDoneHeader)).isDisplayed();
		// Assert.assertTrue(waitForElement.isElementPresent(By.xpath(WebData.almostDoneHeader)));

	}

	/**************************************************************************************
	 * Description : This function enter first name in Web PM Date : 07-Oct-2016
	 * Author : Bhavana
	 **************************************************************************************/
	public void enterFName() throws Exception {
		waitForElement.waitForElement(WebData.wfName);
		// wdriver.findElement(By.xpath(WebData.wfName)).click();
		wdriver.findElement(By.xpath(WebData.wfName)).sendKeys(WebData.firstname);

	}

	/**************************************************************************************
	 * Description : This function enter last name in Web PM Date : 07-Oct-2016
	 * Author : Bhavana
	 **************************************************************************************/
	public void enterLName() throws Exception {
		// wdriver.findElement(By.xpath(WebData.wlName)).click();
		wdriver.findElement(By.xpath(WebData.wlName)).sendKeys(WebData.lastname);

	}

	/**************************************************************************************
	 * Description : This function enter phone number in Web PM Date :
	 * 07-Oct-2016 Author : Bhavana
	 **************************************************************************************/
	public void enterPhoneNumb() throws Exception {
		wdriver.findElement(By.xpath(WebData.wPhone)).click();
		wdriver.findElement(By.xpath(WebData.wPhone)).sendKeys(WebData.phoneNumb);

	}

	/**************************************************************************************
	 * Description : This function click on Continue button in Web PM Date :
	 * 07-Oct-2016 Author : Bhavana
	 **************************************************************************************/
	public void clickAlmostDoneContinue() throws Exception {
		wdriver.findElement(By.xpath(WebData.almostDoneContinue)).click();

	}

	/**************************************************************************************
	 * Description : This function verifies newly created Pype name in Web PM
	 * Date : 07-Oct-2016 Author : Bhavana
	 **************************************************************************************/
	public void verifyPypeName() throws Exception {
		waitForElement.waitForElement(WebData.verifyPypeName);
		wdriver.findElement(By.xpath(WebData.verifyPypeName)).isDisplayed();
		// Assert.assertTrue(waitForElement.isElementPresent(By.xpath(WebData.verifyPypeName)));

	}

	/**************************************************************************************
	 * Description : This function verifies Pype name in Web PM Date :
	 * 07-Oct-2016 Author : Bhavana
	 **************************************************************************************/
	public void verifyNameOfThePype(String PypeName) throws Exception {
		waitForElement.waitForElement(WebData.verifyPypeName);
		String pypeNameFromGetElement = wdriver.findElement(By.xpath(WebData.verifyNameOfThePype)).getText();
		Assert.assertEquals(pypeNameFromGetElement, PypeName);
	}

	/**************************************************************************************
	 * Description : This function click on Overview tab in Web PM Date :
	 * 07-Oct-2016 Author : Bhavana
	 **************************************************************************************/
	public void clickOverViewTab() throws Exception {
		WebDriverWait wait = new WebDriverWait(wdriver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locators.clickOverViewTab)));
		wdriver.findElement(By.xpath(locators.clickOverViewTab)).click();

	}

	/**************************************************************************************
	 * Description : This function click on SignOut link in Web PM Date :
	 * 07-Oct-2016 Author : Bhavana
	 **************************************************************************************/
	public void clickSignout() throws Exception {
		WebDriverWait wait = new WebDriverWait(wdriver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locators.signout)));
		// waitForElement.waitForElement(WebData.signout);
		wdriver.findElement(By.xpath(locators.signout)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locators.signin)));
	}

	/**************************************************************************************
	 * Description : This function Verifies login page of PM Date : 07-Oct-2016
	 * Author : Bhavana
	 **************************************************************************************/
	public void verifySignInPage() throws Exception {
		// wdriver.get(WebData.urlQA);
		waitForElement.waitForElement(locators.signin);
		wdriver.findElement(By.xpath(locators.signin)).isDisplayed();

	}

	/**************************************************************************************
	 * Description : This function enter email address to login to Web PM Date :
	 * 07-Oct-2016 Author : Bhavana
	 **************************************************************************************/
	public WebSignUpAndSignIn wLogin(String wLoginId) throws Exception {

		wdriver.findElement(By.xpath(locators.wloginId)).click();
		wdriver.findElement(By.xpath(locators.wloginId)).sendKeys(wLoginId);
		return this;
	}

	/**************************************************************************************
	 * Description : This function enter password to login to Web PM Date :
	 * 07-Oct-2016 Author : Bhavana
	 **************************************************************************************/
	public WebSignUpAndSignIn wPassword(String wPasswordId) throws Exception {

		wdriver.findElement(By.xpath(locators.wPassword)).click();
		wdriver.findElement(By.xpath(locators.wPassword)).sendKeys(wPasswordId);
		return this;

	}

	/**************************************************************************************
	 * Description : This function click on SignIn button in Web PM Date :
	 * 07-Oct-2016 Author : Bhavana
	 **************************************************************************************/
	public void clickSignin() throws Exception {

		wdriver.findElement(By.xpath(locators.signin)).click();
		/*WebDriverWait wait = new WebDriverWait(wdriver, 80);
  		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locators.signout)));*/
		//wdriver.get("https://qa-wpm-v3r2.pype.tech/overview");
	}

	/**************************************************************************************
	 * Description : This function click on Endchat button in Web PM Date :
	 * 15-Dec-2016 Author : Manjula
	 **************************************************************************************/
	public void clickEndChat() throws Exception {

		wdriver.findElement(By.xpath(WebData.endchat)).click();

	}

	/**************************************************************************************
	 * Description : This function click on Confirm Endchat button in Web PM
	 * Date : 15-Dec-2016 Author : Manjula
	 **************************************************************************************/
	public void clickConfirmEndChat() throws Exception {

		wdriver.findElement(By.xpath(WebData.endchatconfirmation)).click();

	}

	/**************************************************************************************
	 * Description : This function selects disposition code field in Web PM Date
	 * : 15-Dec-2016 Author : Manjula
	 **************************************************************************************/
	public void selectDispositionCodeField() throws Exception {

		wdriver.findElement(By.xpath(WebData.selectDispositionCodefield)).click();
		//
		// WebElement element =
		// wdriver.findElement(By.xpath(WebData.selectTag));
		wdriver.findElement(By.xpath(WebData.inputselectDispositionCodefield)).sendKeys("End");

		wdriver.findElement(By.xpath(WebData.selectTag)).click();

	}

	/**************************************************************************************
	 * Description : This function selects Leave your comment field in Web PM
	 * Date : 15-Dec-2016 Author : Manjula
	 **************************************************************************************/
	public void selectLeaveYourcommentField() throws Exception {

		wdriver.findElement(By.xpath(WebData.selectleaveYourComment)).click();

		wdriver.findElement(By.xpath(WebData.selectleaveYourComment)).sendKeys("Consumer query was resolved");

	}

	/**************************************************************************************
	 * Description : This function clicks on confrim button in Web PM Date :
	 * 15-Dec-2016 Author : Manjula
	 **************************************************************************************/
	public void clickConfirmButton() throws Exception {

		wdriver.findElement(By.xpath(WebData.clickConfirmButton)).click();

	}

	/**************************************************************************************
	 * Description : This function clicks on UsersTab in Web PM Date :
	 * 15-Dec-2016 Author : Manjula
	 **************************************************************************************/
	public void clickUserTab() throws Exception {

		wdriver.findElement(By.xpath(WebData.clickUserTab)).click();

	}

	/**************************************************************************************
	 * Description : This function selects search field in Web PM Date :
	 * 15-Dec-2016 Author : Manjula
	 **************************************************************************************/
	public void selectSearchField() throws Exception {

		wdriver.findElement(By.xpath(WebData.SelectSearchField)).click();

		wdriver.findElement(By.xpath(WebData.SelectSearchField)).sendKeys("9632587425");

		wdriver.findElement(By.xpath(WebData.SelectUserName)).click();

	}

	/**************************************************************************************
	 * Description : This function selects View chat history in Web PM Date :
	 * 15-Dec-2016 Author : Manjula
	 **************************************************************************************/
	public void clickviewchathistory() throws Exception {

		wdriver.findElement(By.xpath(WebData.clickViewChatHistory)).click();

		// wdriver.findElement(By.xpath("//div[@class = 'first-chat-message']/div/span[contains(text(),' "This
		// is the Message sent by Agent" + System.currentTimeMillis() )]"));

		// span[contains(text(),'" + consumerName + "')]"
	}

	/**************************************************************************************
	 * Description : This function clicks on Tag button in Web PM Date :
	 * 15-Dec-2016 Author : Manjula
	 **************************************************************************************/
	public void clickonTagToVerify(String tagAdded) throws Exception {

		wdriver.findElement(By.xpath(WebData.clickTags)).click();
		String tagName = wdriver.findElement(By.xpath(WebData.verifyTag)).getText();

		Assert.assertEquals(tagName, tagAdded);

	}

	/**************************************************************************************
	 * Description : This function login to yopmail PM Date : 16-Dec-2016 Author
	 * : Manjula
	 **************************************************************************************/
	public void loginToYopMail() throws Exception {

		wdriver.findElement(By.xpath(WebData.clickLogin)).click();

		wdriver.findElement(By.xpath(WebData.clickLogin)).clear();

		wdriver.findElement(By.xpath(WebData.clickLogin)).sendKeys("manju");

		wdriver.findElement(By.xpath(WebData.clickCheckMailButton)).click();
		wdriver.switchTo().frame("ifmail");

	}

	// Function After Jan 18

	/**********************************************************************************
	 * Description : This function launches Pypestream application Web PM Login
	 * page Date : 18-Jan-2017 Author : Sowmya
	 *********************************************************************************/
	public WebSignUpAndSignIn launchQALoginPage() throws Exception {

		//wdriver.get(WebData.verifyloginUrlQA);
		wdriver.get("https://qa-wpm-v3r2.pype.tech/");
		return this;

		// wdriver.findElement(By.xpath(WebData.signin)).isDisplayed();
	}

	/**************************************************************************************
	 * Description : This function is used to add stream by business user :
	 * 18-Jan-2017 Author : Sowmya
	 **************************************************************************************/

	public void clickStreamtab() throws Exception {
		wdriver.findElement(By.xpath(WebData.clickStreamTab)).click();

	}

	public void clickAddorEditStream() throws Exception {
		wdriver.findElement(By.xpath(WebData.selectAddStream)).click();

	}

	public void addStream() throws Exception {
		wdriver.findElement(By.xpath(WebData.addStream)).click();
		wdriver.findElement(By.xpath(WebData.enterNewStreamName)).click();
		wdriver.findElement(By.xpath(WebData.enterNewStreamName)).sendKeys(WebData.streamName);
		wdriver.findElement(By.xpath(WebData.saveStream)).click();

	}

	public void closeStreamButton() throws Exception {
		wdriver.findElement(By.xpath(WebData.streamCloseButton)).click();

	}

	/**************************************************************************************
	 * Description : This function get Pype name in Web PM: 24-Jan-2017 Author :
	 * Yugender
	 **************************************************************************************/
	public String getNameOfThePype() throws Exception {

		String pypeNameFromGetElement = wdriver.findElement(By.xpath(WebData.verifyNameOfThePype)).getText();
		return pypeNameFromGetElement;
	}

	/**************************************************************************************
	 * Description : This function is used to check Admin email and invited
	 * agent email should not be the same : 31-Jan-2017 Author : Sowmya
	 **************************************************************************************/
	public void clicAdminTab() throws Exception {
		wdriver.findElement(By.xpath(WebData.clickAdmintab)).click();

	}

	public void addAgent(String FN, String LN, String strAgentEmail) throws Exception {
		wdriver.findElement(By.xpath(WebData.clickAddAgentButton)).click();
		wdriver.findElement(By.xpath(WebData.clickAgentFirstName)).click();
		wdriver.findElement(By.xpath(WebData.clickAgentFirstName)).sendKeys(FN);
		wdriver.findElement(By.xpath(WebData.clickAgentSecondName)).click();
		wdriver.findElement(By.xpath(WebData.clickAgentSecondName)).sendKeys(LN);
		wdriver.findElement(By.xpath(WebData.clickAgentEmail)).click();
		wdriver.findElement(By.xpath(WebData.clickAgentEmail)).sendKeys(strAgentEmail);

	}

	public void clickAgentInviteBtn() throws Exception {
		wdriver.findElement(By.xpath(WebData.clickSendInvitationBtn)).click();

	}

	public void verifyErrorMessage() throws Exception {
		wdriver.findElement(By.xpath(WebData.errorMessage)).isDisplayed();

	}

	/**************************************************************************************
	 * Description : This function is used to click on Edit Email or Password
	 * Date : 16-Feb-2017 Author : Yugender
	 **************************************************************************************/
	public void clickOnEditEmailOrPassword() throws Exception {
		wdriver.findElement(By.xpath(WebData.editEmailOrPassword)).click();
	}

	/**************************************************************************************
	 * Description : This function is used to verify the security check popup
	 * Date : 16-Feb-2017 Author : Yugender
	 **************************************************************************************/
	public void verifySecurityCheckPopupIsDisplayed() throws Exception {
		waitForElement.waitForElement(WebData.passwordSecurityCheck);
		wdriver.findElement(By.xpath(WebData.passwordSecurityCheck)).click();
	}

	/**************************************************************************************
	 * Description : This function is used to enter the current password Date :
	 * 16-Feb-2017 Author : Yugender
	 **************************************************************************************/
	public void enterCurrentPassword(String password) throws Exception {
		wdriver.findElement(By.xpath(WebData.currentPassword)).click();
		wdriver.findElement(By.xpath(WebData.currentPassword)).clear();
		wdriver.findElement(By.xpath(WebData.currentPassword)).sendKeys(password);
	}

	/**************************************************************************************
	 * Description : This function is used to click on Continue button Date :
	 * 16-Feb-2017 Author : Yugender
	 **************************************************************************************/
	public void clickOnContinueButton() throws Exception {
		wdriver.findElement(By.xpath(WebData.continueButton)).click();
	}

	/**************************************************************************************
	 * Description : This function is used to verify edit email or password
	 * popup Date : 16-Feb-2017 Author : Yugender
	 **************************************************************************************/
	public void verifyEditEmailOrPasswordPopup() throws Exception {

		wdriver.findElement(By.xpath(WebData.editEmailOrPasswordPopup)).isDisplayed();
	}

	/**************************************************************************************
	 * Description : This function is used to verify change your password title
	 * Date : 16-Feb-2017 Author : Yugender
	 **************************************************************************************/
	public void verifyChangeYourPasswordTitle() throws Exception {

		wdriver.findElement(By.xpath(WebData.changeYourPasswordTitle)).isDisplayed();
	}

	/**************************************************************************************
	 * Description : This function is used to enter new password Date :
	 * 16-Feb-2017 Author : Yugender
	 **************************************************************************************/
	public void enterNewPassword(String password) throws Exception {
		wdriver.findElement(By.xpath(WebData.newPassword)).click();
		wdriver.findElement(By.xpath(WebData.newPassword)).clear();
		wdriver.findElement(By.xpath(WebData.newPassword)).sendKeys(password);
	}

	/**************************************************************************************
	 * Description : This function is used to enter confirm new password Date :
	 * 16-Feb-2017 Author : Yugender
	 **************************************************************************************/
	public void enterConfirmNewPassword(String password) throws Exception {
		wdriver.findElement(By.xpath(WebData.confirmNewPassword)).click();
		wdriver.findElement(By.xpath(WebData.confirmNewPassword)).clear();
		wdriver.findElement(By.xpath(WebData.confirmNewPassword)).sendKeys(password);
	}

	/**************************************************************************************
	 * Description : This function is used to click on Save Changes button Date
	 * : 16-Feb-2017 Author : Yugender
	 **************************************************************************************/
	public void clickOnSaveButton() throws Exception {
		wdriver.findElement(By.xpath(WebData.saveChanges)).click();
	}

	/**************************************************************************************
	 * Description : This function is used to verify change your email title
	 * Date : 21-Feb-2017 Author : Sowmya
	 **************************************************************************************/
	public void verifyChangeYourEmailTitle() throws Exception {

		wdriver.findElement(By.xpath(WebData.changeYourEmailTitle)).isDisplayed();
	}

	/**************************************************************************************
	 * Description : This function is used to enter new email Date : 21-Feb-2017
	 * Author : Sowmya
	 **************************************************************************************/
	public void enterNewEmail(String strEmail) throws Exception {
		wdriver.findElement(By.xpath(WebData.newEmail)).click();
		wdriver.findElement(By.xpath(WebData.newEmail)).clear();
		wdriver.findElement(By.xpath(WebData.newEmail)).sendKeys(strEmail);
	}

	/**************************************************************************************
	 * Description : This function verifies Agent email in Web PM Date :
	 * 21-Feb-2016 Author : Sowmya
	 **************************************************************************************/
	public void verifyAgentEmailinAdminTab(String strAgentEmail) throws Exception {
		String path = String.format(WebData.agentemail, strAgentEmail);
		wdriver.findElement(By.xpath(path)).isDisplayed();
		/*
		 * String pypeNameFromGetElement = wdriver.findElement(
		 * By.xpath(String)).getText();
		 * 
		 * Assert.assertEquals(pypeNameFromGetElement, strAgentEmail);
		 */
	}

	/**************************************************************************************
	 * Description : This function is used to verify invalid email or password.
	 * Date : 21-Feb-2017 Author : Yugender
	 **************************************************************************************/
	public void verifyInvalidEmailPassword() throws Exception {

		wdriver.findElement(By.xpath(WebData.invalidEmailPassword)).isDisplayed();
	}

	/**************************************************************************************
	 * Description : This function is used to click on edit icon in admin tab
	 * Date : 22-Feb-2017 Author : Sowmya
	 **************************************************************************************/
	public void clickOnAgentNameEditIcon() throws Exception {
		wdriver.findElement(By.xpath(WebData.agentNameEditIcon)).click();
	}

	/**************************************************************************************
	 * Description : This function is used to verify FN text. Date : 22-Feb-2017
	 * Author : Sowmya
	 **************************************************************************************/
	public void verifyFnIsDisplayed() throws Exception {

		wdriver.findElement(By.xpath(WebData.agentFirstNameText)).isDisplayed();
	}

	/**************************************************************************************
	 * Description : This function is used to verify FN text. Date : 22-Feb-2017
	 * Author : Sowmya
	 **************************************************************************************/
	public void verifyLnIsDisplayed() throws Exception {

		wdriver.findElement(By.xpath(WebData.agentFirstNameText)).isDisplayed();
	}

	/**************************************************************************************
	 * Description : This function is used to enter new First name Date :
	 * 22-Feb-2017 Author : Sowmya
	 **************************************************************************************/
	public void enterNewFN(String strFn) throws Exception {
		wdriver.findElement(By.xpath(WebData.agentFirstNameEditText)).click();
		wdriver.findElement(By.xpath(WebData.agentFirstNameEditText)).clear();
		wdriver.findElement(By.xpath(WebData.agentFirstNameEditText)).sendKeys(strFn);
	}

	/**************************************************************************************
	 * Description : This function is used to enter new Last name Date :
	 * 22-Feb-2017 Author : Sowmya
	 **************************************************************************************/
	public void enterNewLN(String strLn) throws Exception {
		wdriver.findElement(By.xpath(WebData.agentSecondNameEditText)).click();
		wdriver.findElement(By.xpath(WebData.agentSecondNameEditText)).clear();
		wdriver.findElement(By.xpath(WebData.agentSecondNameEditText)).sendKeys(strLn);
	}

	/**************************************************************************************
	 * Description : This function is used to reset new First name Date :
	 * 22-Feb-2017 Author : Sowmya
	 **************************************************************************************/
	public void enterResetNewFN(String strFn) throws Exception {
		wdriver.findElement(By.xpath(WebData.agentNewFirstNameEditText)).click();
		wdriver.findElement(By.xpath(WebData.agentNewFirstNameEditText)).clear();
		wdriver.findElement(By.xpath(WebData.agentNewFirstNameEditText)).sendKeys(strFn);
	}

	/**************************************************************************************
	 * Description : This function is used to reset new Last name Date :
	 * 22-Feb-2017 Author : Sowmya
	 **************************************************************************************/
	public void enterResetNewLN(String strLn) throws Exception {
		wdriver.findElement(By.xpath(WebData.agentNewSecondNameEditText)).click();
		wdriver.findElement(By.xpath(WebData.agentNewSecondNameEditText)).clear();
		wdriver.findElement(By.xpath(WebData.agentNewSecondNameEditText)).sendKeys(strLn);
	}

	/**************************************************************************************
	 * Description : This function is used to click save button Date :
	 * 22-Feb-2017 Author : Sowmya
	 **************************************************************************************/
	public void clickOnSaveChanges() throws Exception {
		wdriver.findElement(By.xpath(WebData.saveEditAgentNames)).click();
	}

	/**************************************************************************************
	 * Description : This function is used to verify toast message Date :
	 * 22-Feb-2017 Author : Sowmya
	 **************************************************************************************/
	public void verifyToastMessage() throws Exception {
		wdriver.findElement(By.xpath(WebData.verifyToastMessage)).isDisplayed();

	}

	/**************************************************************************************
	 * Description : This function is used to verify Agent new name in agent
	 * overview tab. Date : 22-Feb-2017 Author : Sowmya
	 **************************************************************************************/
	public void verifyAgentName(String agentName) throws Exception {
		String path = String.format(WebData.agentName, agentName);
		waitForElement.waitForElement(path);
		wdriver.findElement(By.xpath(path)).isDisplayed();
	}

	/**************************************************************************************
	 * Description : This function verifies Agent Login Date :01-March-2017
	 * Author : Sowmya
	 **************************************************************************************/
	public void verifyAgentLoginErrorMessage() throws Exception {

		String confirmMessage = wdriver.findElement(By.xpath(WebData.loginErrorMessage)).getText();
		Assert.assertEquals(confirmMessage, "Invalid email or password");
	}

	/**************************************************************************************
	 * Description : This function is used to click on arrow button of status
	 * Date :10-March-2017 Author : Yugender
	 **************************************************************************************/
	public String fetchAgentCurrentStatus() throws Exception {

		return wdriver.findElement(By.xpath(WebData.agentCurrentStatus)).getText();
	}

	/**************************************************************************************
	 * Description : This function is used to click on arrow button of status
	 * Date :10-March-2017 Author : Yugender
	 **************************************************************************************/
	public void clickOnAgentStatusArrowButton() throws Exception {

		wdriver.findElement(By.xpath(WebData.agentStatusArrowButton)).click();
	}

	/**************************************************************************************
	 * Description : This function is used to click on arrow button of status
	 * Date :10-March-2017 Author : Yugender
	 **************************************************************************************/
	public void clickOnAgentSelectAwayStatus() throws Exception {

		wdriver.findElement(By.xpath(WebData.agentStatusAway)).click();
	}

	/**************************************************************************************
	 * Description : This function is used to click on arrow button of status
	 * Date :10-March-2017 Author : Yugender
	 **************************************************************************************/
	public void clickOnAgentSelectOnlineStatus() throws Exception {

		wdriver.findElement(By.xpath(WebData.agentStatusOnline)).click();
	}

	/**************************************************************************************
	 * Description : This function is used to fetch the user count from agent
	 * acount before removing user Date :07-March-2017 Author : Sowmya
	 **************************************************************************************/
	public String userCountInAgentAccount() throws Exception {
		waitForElement.waitForElement(WebData.userCountInAgentAcount);
		String userCountInAgentBefore = wdriver.findElement(By.xpath(WebData.userCountInAgentAcount)).getText();

		return userCountInAgentBefore;
	}

	/**************************************************************************************
	 * Description : This function is used to fetch the user count from agent
	 * acount after removing user Date :07-March-2017 Author : Sowmya
	 **************************************************************************************/
	public String userCountInAgentAcc() throws Exception {
		String userCountInAgentAfter = wdriver.findElement(By.xpath(WebData.userCountInAgentAcount)).getText();

		return userCountInAgentAfter;

	}

	/**************************************************************************************
	 * Description : This function is used to fetch the user count from stream
	 * table before removing the user Date :08-March-2017 Author : Sowmya
	 **************************************************************************************/
	public String userCountInStreamTable() throws Exception {
		String userCountInSTBefore = wdriver.findElement(By.xpath(WebData.userCountInStreamtab)).getText();

		return userCountInSTBefore;
	}

	/**************************************************************************************
	 * Description : This function is used to click the username of the pype to
	 * remove Date :06-March-2017 Author : Sowmya
	 **************************************************************************************/
	public void clickConsumerNameToRemove() throws Exception {
		wdriver.findElement(By.cssSelector("a.list-item")).click();
		wdriver.findElement(By.xpath(WebData.clickRemoveUserLink)).click();

	}

	/**************************************************************************************
	 * Description : This function is used to click the disconnect user button
	 * Date :06-March-2017 Author : Sowmya
	 **************************************************************************************/
	public void clickDisconnectUserButton() throws Exception {
		wdriver.findElement(By.xpath(WebData.clickDisconnectUser)).click();

	}

	/**************************************************************************************
	 * Description : This function is used to click on the All Time in Stream
	 * Tab Date :06-March-2017 Author : Sowmya
	 **************************************************************************************/
	public void clickAllTime() throws Exception {
		waitForElement.waitForElement(WebData.clickAllTimeLink);
		wdriver.findElement(By.xpath(WebData.clickAllTimeLink)).click();
	}

	/**************************************************************************************
	 * Description : This function is used to fetch the user count from stream
	 * table after removing the user Date :08-March-2017 Author : Sowmya
	 **************************************************************************************/
	public String userCountInStreamTab() throws Exception {
		String userCountInSTAfter = wdriver.findElement(By.xpath(WebData.userCountInStreamtab)).getText();
		return userCountInSTAfter;

	}

	/**************************************************************************************
	 * Description : This function is used to verify the user count in stream
	 * table Date :08-March-2017 Author : Sowmya
	 **************************************************************************************/
	public void verifyUserCountInStreamTab(String userCountInSTBefore, String userCountInSTAfter) throws Exception {
		Assert.assertNotEquals(userCountInSTBefore, userCountInSTAfter);
	}

	/**************************************************************************************
	 * Description : This function is used to verify the user count in stream
	 * table Date :08-March-2017 Author : Sowmya
	 **************************************************************************************/
	public void verifyUserCountAgentAccount(String userCountInAgentBefore, String userCountInAgentAfter)
			throws Exception {
		Assert.assertNotEquals(userCountInAgentBefore, userCountInAgentAfter);
	}

	/**************************************************************************************
	 * Description : This function is used to verify agent Online (busy) status
	 * Date :10-March-2017 Author : Sowmya
	 **************************************************************************************/
	public void verifyAgentOnlineBusyStatus() throws Exception {

		String statusValue = wdriver.findElement(By.xpath("//span[text()='Online (busy)']")).getText();
		Assert.assertEquals(statusValue, "Online (busy)");
	}

	/**************************************************************************************
	 * Description : This function click on chat tab in Web PM Date :
	 * 10-march-2017 Author : Sowmya
	 **************************************************************************************/
	public void clickChatTab() throws Exception {

		wdriver.findElement(By.xpath(WebData.clickChat)).click();

	}

	/**********************************************************************************************
	 * Description : This function verifies consumer message is displayed in
	 * Chat conversation in Web Date : 10-march-2017 Author : Sowmya
	 **********************************************************************************************/
	public void verifyConsumerMessageInChatConversation(String consumerName) throws Exception {

		String name = wdriver.findElement(By.xpath("//h5[contains(text(),'" + consumerName + "')]")).getText();
		Assert.assertNotEquals(name, WebData.consumerName2);

	}

	/**************************************************************************************
	 * Description : This function click on chat tab in Web PM Date :
	 * 10-march-2017 Author : Sowmya
	 **************************************************************************************/
	public void clickUserNameTab() throws Exception {

		wdriver.findElement(By.cssSelector("div.message-text")).click();

	}

	/**********************************************************************************************
	 * Description : This function verifies consumer message is displayed in
	 * Chat conversation in Web Date : 10-march-2017 Author : Sowmya
	 **********************************************************************************************/
	public void verifyConsumerMsgInAgentChatConversation(String consumerName) throws Exception {

		String xpath = String.format("//h5[contains(text(),'%s')]", consumerName);
		waitForElement.waitForElement(xpath);
		wdriver.findElement(By.xpath(xpath)).isDisplayed();
	}

	/**************************************************************************************
	 * Description : This function is used to set the agent's status as 'away'
	 * Date :06-March-2017 Author : Sowmya
	 **************************************************************************************/
	public void setAgentStatus() throws Exception {
		wdriver.findElement(By.xpath(WebData.agentStatusArrow)).click();
		wdriver.findElement(By.xpath(WebData.agentStatusAway)).click();

	}

	/**************************************************************************************
	 * Description : This function is used to click 'users' tab Date
	 * :06-March-2017 Author : Sowmya
	 **************************************************************************************/
	public void clickUsersTab() throws Exception {
		wdriver.findElement(By.xpath(WebData.userTab)).click();

	}

	/**************************************************************************************
	 * Description : This function is used to verify agent status Date
	 * :06-March-2017 Author : Sowmya
	 **************************************************************************************/
	public void verifyAgentStatus() throws Exception {
		String statusValue = wdriver.findElement(By.xpath("//div/div/span[text()='Away']")).getText();
		Assert.assertEquals(statusValue, "Away");
	}

	/**************************************************************************************
	 * Description : This function is used to click the Edit Pype link Date
	 * :06-March-2017 Author : Sowmya
	 **************************************************************************************/
	public void clickEditPype() {
		wdriver.findElement(By.xpath(WebData.editPypeLink)).click();
	}

	/**************************************************************************************
	 * Description : This function is used to verify pypename title Date
	 * :06-March-2017 Author : Sowmya
	 **************************************************************************************/
	public void verifyPypeNameTitle() throws Exception {
		wdriver.findElement(By.xpath(WebData.pypeNameTitle)).isDisplayed();

	}

	/**************************************************************************************
	 * Description : This function is used to Edit the pypename Date
	 * :06-March-2017 Author : Sowmya
	 **************************************************************************************/

	public void enterNewPypeName(String strLn) throws Exception {
		wdriver.findElement(By.xpath(WebData.pypeNameEditTextBox)).click();
		wdriver.findElement(By.xpath(WebData.pypeNameEditTextBox)).clear();
		wdriver.findElement(By.xpath(WebData.pypeNameEditTextBox)).sendKeys(strLn);
	}

	/**************************************************************************************
	 * Description : This function is used to verify pype description title Date
	 * :06-March-2017 Author : Sowmya
	 **************************************************************************************/
	public void verifyPypeDescriptionTitle() throws Exception {
		wdriver.findElement(By.xpath(WebData.pypeDescriptionTitle)).isDisplayed();

	}

	/**************************************************************************************
	 * Description : This function is used to Edit the pype description Date
	 * :06-March-2017 Author : Sowmya
	 **************************************************************************************/

	public void enterNewPypeDescription(String strLn) throws Exception {
		wdriver.findElement(By.xpath(WebData.pypeDescriptionTextBox)).click();
		wdriver.findElement(By.xpath(WebData.pypeDescriptionTextBox)).clear();
		wdriver.findElement(By.xpath(WebData.pypeDescriptionTextBox)).sendKeys(strLn);

	}

	/**************************************************************************************
	 * Description : This function is used to click continue tab and save
	 * changes tab of the edit pype Date :06-March-2017 Author : Sowmya
	 **************************************************************************************/
	public void clickContinueAndSaveChangesTab() throws Exception {

		wdriver.findElement(By.xpath(WebData.clickContinue)).click();
		wdriver.findElement(By.xpath(WebData.saveChanges1)).click();

	}

	/**************************************************************************************
	 * Description : This function is used to verify PypeDescription in admin
	 * account Date :06-March-2017 Author : Sowmya
	 **************************************************************************************/
	public void verifyPypeDesc() throws Exception {
		String statusValue = wdriver.findElement(By.xpath(WebData.adminPypeDesc)).getText();
		Assert.assertEquals(statusValue, "Welcome to the Unique pype");
	}

	/**************************************************************************************
	 * Description : This function is used to verify PypeDescription in agent
	 * account Date :06-March-2017 Author : Sowmya
	 **************************************************************************************/
	public void verifyPypeDescAgentAccount() throws Exception {
		String statusValue = wdriver.findElement(By.xpath(WebData.pypeDesc)).getText();
		Assert.assertEquals(statusValue, "Welcome to the Unique pype");
	}

	/**************************************************************************************
	 * Description : This function is used to add stream by business user :
	 * 13-march-2017 Author : Sowmya
	 **************************************************************************************/

	public void clickStream() throws Exception {
		waitForElement.waitForElement(WebData.clickStream);
		wdriver.findElement(By.xpath(WebData.clickStream)).click();
	}

	/**************************************************************************************
	 * Description : This function is used to click on private option in pype
	 * visibility Date : 23-March-2017 Author : Sowmya
	 **************************************************************************************/
	public void clickOnPrivateOption() throws Exception {
		wdriver.findElement(By.xpath(WebData.privateOption)).click();

	}

	/**************************************************************************************
	 * Description : This function is used to verify private pype notification
	 * is displayed Date : 23-March-2017 Author : Sowmya
	 **************************************************************************************/
	public void verifyNotificationOfprivatePype() throws Exception {
		wdriver.findElement(By.xpath(WebData.notification)).isDisplayed();
		wdriver.findElement(By.xpath(WebData.notification)).click();

	}

	/**************************************************************************************
	 * Description : This function is used to click on public option in pype
	 * visibility Date : 23-March-2017 Author : Sowmya
	 **************************************************************************************/
	public void clickOnPublicOption() throws Exception {
		wdriver.findElement(By.xpath(WebData.publicOption)).click();

	}

	/**************************************************************************************
	 * Description : This function is used to verify public option is selected
	 * in pype visibility Date : 23-March-2017 Author : Sowmya
	 **************************************************************************************/
	public void verifyPublicOptionIsSelected() throws Exception {
		wdriver.findElement(By.xpath(WebData.publicRadioButton)).isSelected();

		wdriver.findElement(By.xpath(WebData.cancelMark)).click();

	}

	/**********************************************************************************
	 * Description : This function launches Pypestream application in Web PM
	 * Date : 28-March-2017 Author : Soumya
	 *********************************************************************************/
	/*
	 * public void launchPypestream() throws Exception {
	 * wdriver.get(WebData.QaboxUrl);
	 * 
	 * wdriver.findElement(By.xpath(WebData.signin)).isDisplayed(); }
	 */

	/**************************************************************************************
	 * Description : This function is used to click on arrow button of status
	 * Date :14-March-2017 Author : Yugender
	 **************************************************************************************/
	public String getCurrentWaitlist() throws Exception {
		return wdriver.findElement(By.xpath(WebData.currentWaitList)).getText();
	}

	public void verifyEmailId(String oldEmailID, String emailID) throws Exception {

		while (oldEmailID.equalsIgnoreCase(wdriver.findElement(By.xpath(WebData.emailId)).getText())) {
			// Old email id is displayed.
			// System.out.printf("%s is displayed\n", oldEmailID);
		}

		Assert.assertEquals(emailID, wdriver.findElement(By.xpath(WebData.emailId)).getText());
	}

	/**************************************************************************************
	 * Description : This function is to launch configured website. Date :
	 * 13-Feb-2017 Author : QSG
	 **************************************************************************************/
	public void launchConfiguredWebsite() throws Exception {
		wdriver.get(WebData.configuredSiteUrl);
		wdriver.findElement(By.xpath(WebData.templateThirdPartySite)).isDisplayed();
	}

	/**************************************************************************************
	 * Description : This function is to click on 'streams' tab. Date :
	 * 10-Feb-2017 Author : QSG
	 **************************************************************************************/
	public void clickOnStreams() throws Exception {
		wdriver.findElement(By.xpath(WebData.streams)).click();
	}

	/**************************************************************************************
	 * Description : This function is to click on 'Add a new stream' link. Date
	 * : 10-Feb-2017 Author : QSG
	 **************************************************************************************/
	public void clickOnAddAStream() throws Exception {
		WebDriverWait wait = new WebDriverWait(wdriver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(WebData.addANewStream)));
		wdriver.findElement(By.xpath(WebData.addANewStream)).click();
	}

	/**************************************************************************************
	 * Description : This function is to enter stream name. Date : 10-Feb-2017
	 * Author : QSG
	 **************************************************************************************/
	public void enterStreamName(String sn) throws Exception {
		wdriver.findElement(By.xpath(WebData.enterNewStreamName)).click();
		wdriver.findElement(By.xpath(WebData.enterNewStreamName)).sendKeys(sn);
	}

	/**************************************************************************************
	 * Description : This function is to click on save in 'edit streams' page.
	 * Date : 10-Feb-2017 Author : QSG
	 **************************************************************************************/
	public void clickOnSave() throws Exception {
		wdriver.findElement(By.xpath(WebData.savestream)).click();
	}

	/**************************************************************************************
	 * Description : This function is to click on save in 'edit streams' page.
	 * Date : 10-Feb-2017 Author : QSG
	 **************************************************************************************/
	public void clickOnSave1(String stream) throws Exception {
		wdriver.findElement(
				By.xpath("//input[@value='" + stream + "']/following-sibling::span//span/button[text()='Save']"))
				.click();

	}

	/**************************************************************************************
	 * Description : This function is to click on required stream in 'edit
	 * streams'. Date : 10-Feb-2017 Author : QSG
	 **************************************************************************************/
	public void clickOnReqStream(String stream) throws Exception {
		String str = "//button[text()='" + stream + "']";
		wdriver.findElement(By.xpath(str)).click();
	}

	/**************************************************************************************
	 * Description : This function is to modify the stream name 'edit streams'.
	 * Date : 10-Feb-2017 Author : QSG
	 **************************************************************************************/
	public void modifyStream(String stream, String modstream) throws Exception {
		String str = "//input[@value='" + stream + "']";
		wdriver.findElement(By.xpath(str)).clear();
		wdriver.findElement(By.xpath(WebData.enterNewStreamName)).click();
		wdriver.findElement(By.xpath(WebData.enterNewStreamName)).sendKeys(modstream);
	}

	/**************************************************************************************
	 * Description : This function is to launch configured website. Date :
	 * 13-Feb-2017 Author : QSG
	 **************************************************************************************/
	public void clickOnlineDropDown() throws Exception {
		wdriver.findElement(By.xpath("//span[text()='Online']")).click();
		;
	}

	/**************************************************************************************
	 * Description : This function is to launch configured website. Date :
	 * 13-Feb-2017 Author : QSG
	 **************************************************************************************/
	public void clickOnline() throws Exception {
		wdriver.findElement(By.xpath("//div[@class='agent-status-status is-enabled']")).click();
		;
	}

	/**************************************************************************************
	 * Description : This function is to launch configured website. Date :
	 * 13-Feb-2017 Author : QSG
	 **************************************************************************************/
	public void clickToolTip() throws Exception {

		boolean agents = wdriver
				.findElement(
						By.xpath("/div[@class='walkme-click-and-hover walkme-custom-balloon-close-button walkme-action-close']"))
				.isDisplayed();

		if (agents == true) {
			wdriver.findElement(
					By.xpath("/div[@class='walkme-click-and-hover walkme-custom-balloon-close-button walkme-action-close']"))
					.click();
		} else {
			System.out.print("\nagents is enabled.");
		}
	}

	/**************************************************************************************
	 * Description : This function is to launch configured website. Date :
	 * 13-Feb-2017 Author : QSG
	 **************************************************************************************/
	public void clickOnAway() throws Exception {
		wdriver.findElement(By.xpath("//span[text()='Away']")).click();
		;
	}

}
