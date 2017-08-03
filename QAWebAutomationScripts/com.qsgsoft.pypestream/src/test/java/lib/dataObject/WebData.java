package lib.dataObject;

import java.util.Random;

public class WebData {

	public static String randomString() {
		char[] chars = "123456789".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String output = sb.toString();
		return output;
	}

	public static final String url = "https://stage-wpm-v3r2.pypestream.com/",
			urlQA = "https://app.pypestream.com/",
			closeWebChatWidget = "//div[@class='pypestream_launcher pypestream_launcher--bottom pypestream_launcher--right pypestream_launcher--active']",
			configuredSiteUrl = /* "http://webchat-v3r2stage.pype.tech/placeholder.html" */"http://webchat-v3r2qa.pype.tech/placeholder.html",
			verifyloginUrlQA = "https://qa-wpm-v3r2.pype.tech/login",
			urlOfYopmail = "http://www.yopmail.com",
			urlQAToAddPype = "https://qa-wpm-v3r2.pype.tech/signup/step1?ref=web_sign_in_out",
			getPypeLink = "//a[contains(text(),'Get a Pype')]",
			setPwdHeader = "//h4[contains(text(),'Set your password')]",
			wEmail = "//input[@id='email']",
			wPwd = "//input[@id='password']",
			wConfirmPwd = "//input[@id='passwordconfirmation']",
			setPwdContinue = "//input[@id='passwordconfirmation']/parent::div/following-sibling::input[@value='Continue']",
			yourCompanyInfo = "//h4[contains(text(),'Your company information')]",
			nameOfPype = "//input[@id='companyname']",
			publicPypeUrl = "//input[@id='companyslug']",
			industry = "//select[@name='company[industry]']",
			companyInfoContinue = "//select[@class='form-control']/parent::div/following-sibling::input[@value='Continue']",
			almostDoneHeader = "//h4[contains(text(),'Almost done!')]",
			wfName = "//input[@id='firstname']",
			wlName = "//input[@id='lastname']",
			wPhone = "//input[@id='phone']",
			almostDoneContinue = "//input[@id='phone']/parent::div/following-sibling::input[@value='Continue']",
			pypeName = "Py" + System.currentTimeMillis(),
			verifyPypeName = "//div/h3[contains(text(), " + pypeName + ")]",
			verifyNameOfThePype = "//h3",
			wEmailId = System.currentTimeMillis() + "@yopmail.com",
			firstname = "FN" + System.currentTimeMillis(),
			lastname = "LN" + System.currentTimeMillis(),
			phoneNumb = randomString(),
			streamName = "Web" + System.currentTimeMillis(),
			wpassword = "test1234",
			wloginId = "//input[@name = 'email']",
			wPasswordId = "//input[@name = 'password']",
			signin = "//button[contains(text(),'Sign in')]",
			growTab = "//span[contains(text(),'Grow')]",
			inviteUserHeader = "//h3[contains(text(),'Invite users directly')]",
			emailInvite = "//input[@type = 'email']",
			sendEmail = "//button[contains(text(),'Send email')]",
			notificationMessage = "//div[@class='notification-message']",
			notificationClose = "//div[@class='notification-message']/following-sibling::span",
			clickOnMore = "//button[contains(text(),'More')]",
			clickChatsTab = "//span[text()='Chats']",
			startNewChat = "//button/span[contains(text(),'Start new chat')]",
			newChatHeader = "//h4[contains(text(),'New chat')]",
			selectUserTo = "//div/label[contains(text(),'To:')]/parent::div/div/div/span[@class='Select-arrow-zone']/span[@class='Select-arrow']",
			selectUser = "//div",
			enterUserName = "//div/span/div[text()='Select a user']/parent::span/div[@class='Select-input']/input",
			selectStreamArrow = "//div/label[contains(text(),'Stream:')]/parent::div/div/div/span[@class='Select-arrow-zone']/span[@class='Select-arrow']",
			selectStream = "//div[text()='Support']",
			enterStreamName = "//div/span/div[text()='Select a stream']/parent::span/div[@class='Select-input']/input",
			enterMessageAgent = "//textarea[@placeholder='Type your message here...']",
			enterMessage = "//textarea[@placeholder='Enter a message...']",
			sendMessageButtonAgent = "//button[contains(text(),'Send message')]",
			sendMessageButton = "//button[@class = 'btn btn-link btn-sm btn-send-chat p-0']",
			verifySentMessageInWPM = "//div[@class='chat-message sent']/div/div/span[contains(text(),'Hi!! How are you??')]",
			verifySentMessageInPM = "//div[@class = 'message-text']",
			// verifyConsumerMessageInWPM =
			// "//div[@class='chat-message received']/div/div/span/span[contains(text(),'Im good. You??')]",
			verifyConsumerMessageInWPM = "//span[text()='Hello']",
			clickOverViewTab = "//a[@href='/overview']",
			fileIsDisplayedInChatRoom = "//a/img",
			attachButtonInChat = "//div[@class='btn btn-attach p-0']",
			attachButtonInNewChat = "//img[@ src = '/img/paperclip-5d61a89fa0.svg']",
			enterMessageInConversation = "//textarea[@placeholder='Enter a message...']",
			sendButtonInConversation = "//button/span[text()='Send']",
			clickBroadcastTab = "//span[text()='Broadcasts']",
			clickSendNewBroadcast = "//button/span[contains(text(),'Send new broadcast…')]",
			verifyNewBroadcastScreen = "//h4[text()='New broadcast']",
			enterBroadcastMessage = "textarea.form-control.no-border",
			selectstreamForBroadCast = "//span[@class = 'Select-arrow']",
			clickReviewButton = "//button[text()='Review']",
			verifyReviewBroadcastScreen = "//h4[contains(text(),'Send to ')]",
			verifyBroadcastMessageSent = "//p",
			clickSendButtonInReviewBroadcast = "//button[@class='save-btn btn btn-primary pull-right']",
			verifyBroadcastMessageSentSuccessfullyMsg = "//div[contains(text(),'Your broadcast was sent successfully.')]",
			clickAdminTab = "//span[text()='Admin']",
			verifyAgentScreen = "//div[text()='Agents']",
			clickAddAgent = "//span[text()='Add agent']",
			verifyAddAgentPage = "//h4[contains(text(),'Add agent')]",
			enterAgentFN = "//label/div[contains(text(),'First name')]/parent::label/input",
			enterAgentLN = "//label/div[contains(text(),'Last name')]/parent::label/input",
			enterAgentEmail = "//label/div/span[contains(text(),'Email')]/parent::div/parent::label/input",
			clickSendInvitationButton = "//button/div[contains(text(),'Send invitation')]",
			signout = "//button[contains(text(),'Sign out')]",
			endchat = "//button[contains(text(),'End chat')]",
			endchatconfirmation = "//button[2][contains(text(),'End chat')]", // select[@name='company[industry]']"
			selectDispositionCodefield = "//div[contains(text(),'Select Resolution codes')]",

			selectTag = "//div[contains(text(),'23 - Ending Chat Tag')]",
			inputselectDispositionCodefield = ".//*[@id='react-select-5--value']/div[2]/input",
			enterselectDispositionCodefield = "//input[@role = 'combobox']",
			selectleaveYourComment = "//textarea[@placeholder= 'Leave your comment here...']",
			clickConfirmButton = "//button[@class = 'save-btn btn btn-primary']",
			selectDispositionCode = "//div[@class = 'Select-input']",
			// selectDispositionCode = "//span[text()='Ending Chat Tag']",
			clickUserTab = "//span[text()='Users']",
			SelectSearchField = "//input[@class = 'form-control search-input']",
			// SelectUserName = "//p[Contains(text(), '+1 963-258-7425')]",
			SelectUserName = "//div[@class='msg']",
			clickViewChatHistory = "//a[@class='view-chat-history-link']",
			// clickViewChatHistory = "//a[Contains(text(), 'View chat
			// history')]",
			// clickTags = "//button[1][@class = 'icon-button']"
			clickTags = "//div[1]/div[3]/span[2]/div[1]/div[1]/span[1]/button[1][@class = 'icon-button']",
			verifyTag = "//div[contains(text(),'23 - Ending Chat Tag')]",
			clickLogin = "//input[@id = 'login']",
			clickCheckMailButton = "//input[@class = 'sbut']",

			// Added Jan 18
			clickStreamTab = "//li[text()='Streams']",
			selectAddStream = "//span[@class='m-l-10']",
			addStream = "//td[@class='p-10']",
			enterNewStreamName = "//input[@class='form-control p-sm']",
			saveStream = "//button[@class='btn btn-link p-sm']",
			streamCloseButton = "//button[@class='close']",

			selectAddAgent = "//span[@class='m-l-10']",
			clickAddAgentButton = "//button[@class='btn btn-link no-padding fw-500']",
			agentFirstName = "agent",
			agentSecondName = "AutoTest",
			clickAgentFirstName = "//input[@placeholder='e.g., Maria']",
			clickAgentSecondName = "//input[@placeholder='e.g., Chu']",
			clickAgentEmail = "//input[@placeholder='e.g., mariachu@example.com']",
			// clickSendInvitationBtn = "//button[@class='save-btn btn
			// btn-primary']",
			clickSendInvitationBtn = "//div[contains(text(),'Send invitation')]",
			errorMessage = "//span[contains(text(),'Agent invitation to')]",

			clickAdmintab = "//span[text()='Admin']",

			SendBroadcastMessageLink = "//button[@class='m-l-a btn btn-link p-0']",
			broadcastMessage = "//a[@class='list-item']",

			// Added Jan 24
			removeAgentButton = "//button[@class = 'save-btn btn remove-agent-btn btn-link text-danger']",
			confirmAgentRemoval = "//h4[@class='modal-title text-center']",
			confirmRemoveAgentButton = "//button[@class = 'save-btn btn btn-danger']",
			removeUserButton = "//button[@class='btn btn-link no-padding inline-block']",
			confirmDisconnect = "//div[contains(text(), 'Confirm disconnection')]",
			disconnectUser = "//button[contains(text(), 'Disconnect user')]",
			autoresponses = "//div[contains(text(), 'Autoresponses')]",
			offlineAutoresponseCheckboxEnabled = "//span[contains(text(), 'Use autoresponse when all agents are offline')]/parent::label/div/input[@value='true']",
			offlineAutoresponseMessage = "//textarea[@class='form-control']",

			// Added feb 16
			autoresponder = "//span[text()='Autoresponses']",
			clickOnAutoresponderCheckbox = "//span[contains(text(), 'Use autoresponse when all agents are offline')]/parent::label/div",
			saveAutoresponderChanges = "//button[@class='save-btn btn btn-primary']",
			noMessages = "//div[@class='empty-list-content']/h4[contains(text(), 'No messages')]",
			editEmailOrPassword = "//button[contains(text(), 'Edit email or password')]",
			passwordSecurityCheck = "//h4[contains(text(), 'Security Check')]",
			currentPassword = "//input[@name='password']",
			continueButton = "//button[contains(text(), 'Continue')]",
			editEmailOrPasswordPopup = "//h4[contains(text(), 'Edit email or password')]",
			changeYourPasswordTitle = "//h4[contains(text(), 'Change your password')]",
			newPassword = "//input[@name='new_password']",
			confirmNewPassword = "//input[@name='confirm_new_password']",
			saveChanges = "//button[contains(text(), 'Save Changes')]",
			busyAutoResponseCheckboxEnabled = "//span[contains(text(), 'Use autoresponse when all agents are busy')]/parent::label/div/input[@value='true']",
			busyAutoResponseMessage = "//p[contains(text(), 'BUSY AUTORESPONSE MESSAGE')]/following-sibling::textarea[@class='form-control']",

			// Added feb 20
			verifyConsumer1MessageInAgent = "//div[@class='chat-message received']/div/div/span[contains(text(),'%s')]",
			verifyConsumer2MessageInAgent = "//div[@class='chat-message received']/div/div/span[contains(text(),'Consumer2')]",
			replyForConsumer1 = "//div[@class='chat-message received']/div/div/span[contains(text(),'Reply for Consumer1')]",
			replyForConsumer2 = "//div[@class='chat-message received']/div/div/span[contains(text(),'Reply for Consumer2')]",
			changeYourEmailTitle = "//h4[contains(text(), 'Change your email')]",
			newEmail = "//input[@name='email']",
			agentemail = "//div[contains(text(),'%s')]",
			invalidEmailPassword = "//div[contains(text(), 'Invalid email or password')]",

			// Added feb 22
			agentNameEditIcon = "//img[@src= '../../img/icon-pencil-blue-24510de520.svg']",
			agentFirstNameText = "//div[contains(text(), 'First name')]",
			agentLastNameText = "//div[contains(text(), 'Last name')]",
			agentFirstNameEditText = "//div[contains(text(), 'First name')]/following-sibling::input",
			agentSecondNameEditText = "//div[contains(text(), 'Last name')]/following-sibling::input",
			agentNewFirstNameEditText = "//input[@value = 'Rahul']",
			agentNewSecondNameEditText = "//input[@value = 'dravid']",
			saveEditAgentNames = "//button[@class='save-btn btn btn btn-primary']",
			verifyToastMessage = "//span[contains(text(),'Save changes successfully')]",
			agentName = "//p[contains(text(), '%s')]",
			firstEditIcon = "//div/div[4]/div[1]/div[1]/div[1]//div[1]/img",
		

			/**********************************************************************************
			 * Description : Account Details used in Script Date : 1-March-2016
			 * Author : Sowmya
			 **********************************************************************************/

			strPypeName = "QTest",

			strAdminEmail = "qsgtest@yopmail.com",
			strAdminPassword = "pass@123",

			strOtherAdminEmail = "book01@yopmail.com",

			strAgentEmail = "agent123@yopmail.com",
			strAgentPassword = "pass@123",
			strChangeAgentEmail = "agent1234@yopmail.com",

			strAgentFN = "John",
			strAgentLN = "Agent1",

			strAgentNewFN = "Rahul",
			strAgentNewLN = "dravid",

			// Consumer credentials
			strConsumerPhnNum = "7050360412",
			strConsumerPassword = "pass@123",
			strConsumerName = "Websmokeauto Consumer",
			strConsumerPhnNum2 = "7050360413",
			strConsumerName2 = "Websmokeauto Consumer2",

			// Second Pype
			FN = "xyz",
			LN = "y",
			PN = "7890654321",
			strPypeName2 = "QualityTest",
			strAdminEmail2 = "testautoadmin@yopmail.com",
			strAdminPassword2 = "pass@123",

			strAgentFN2 = "Agent",
			strAgentLN2 = "2",
			strAgentEmail2 = "testautoagent@yopmail.com",
			strAgentPassword2 = "pass@123",

			loginErrorMessage = "//div[@class='alert alert-danger'][text()='Invalid email or password']",

			agentInitiateChatDisabled = "//div[@class='ui-checkbox']", // "/input[@value='false']",
			agentInitiateChatEnabled = "//div[@class='ui-checkbox value']",// "/input[@value='true']";
			agentCurrentStatus = "//div[@class='agent-status-status agent-status-current-status']/span[2]",
			agentStatusArrowButton = "//div[@class='arrow-down']",
			agentStatusAway = "//span[contains(text(), 'Away')]/parent::div",
			agentStatusOnline = "//span[contains(text(), 'Online')]/parent::div",

			// added march 6
			agentStatusArrow = "//div[@class='arrow-down']",
			userTab = "//span[contains(text(),'Users')]",
			adminUsername = "shop0001@yopmail.com",
			adminPassword = "savita123",
			agentUsername = "shop444@yopmail.com",
			agentPassword = "dontask!",
			oldpypeName = "shop0001",
			oldPypeDescription = "Welcome to the shop0001 Pype",
			adminPypeDesc = "//div/p[@class='m-t-10']",
			editPypeLink = "//button[text()='Edit Pype']",
			pypeNameTitle = "//h5[text()='Pype Name']",
			pypeNameEditTextBox = "//input[@type='text']",
			newPypeName = "Unique",
			pypeDescriptionTitle = "//span[@data-reactid='.8.0.0.1.0.0.0.1.0.0']",
			pypeDescriptionTextBox = "//textarea[@class='form-control']",
			newPypeDescription = "Welcome to the Unique pype",
			clickContinue = "//button[text()='Continue']",
			saveChanges1 = "//button[text()='Save Changes']",
			pypeDesc = "//p[@class='m-t-10 pype-description']",
			consumerPypeName = "com.pypestream:id/title",

			// added march 7
			userCountInAgentAcount = "//div/h1[@class='no-margin']",
			userCountInStreamtab = "//span[@data-reactid='.0.2.0.1.1.0.1.0.2.1.$/=12.0.0.1.0.0.0.3.$0.0.0.$scrollable_cells.0.$cell_1.1.0.0.0.0']",
			clickRemoveUserLink = "//button[@class='btn btn-link no-padding inline-block']",
			clickAllTimeLink = "//span[text()='All Time']",
			clickDisconnectUser = "//button[@class='btn btn-danger' and text()='Disconnect user']",
			clickStream = "//li[text()='Streams']",

			// added march 9
			adminUName = "ship01@yopmail.com",
			adminPwd = "ship01",
			agent1 = "ship44@yopmail.com",
			agent1Pwd = "ship44",
			agent2 = "ship04@yopmail.com",
			agent2Pwd = "ship04",
			pype = "Ship",
			Stream1 = "Support",
			Stream2 = "Billing",
			clickChat = "//span[text()='Chats']",
			consumerName = "divya M",
			consumerName2 = "Kavya T",

			// added march 14
			pypeName1 = "book",
			adminU = "book01@yopmail.com",
			adminP = "book01",
			agent1U = "book44@yopmail.com",
			agent1P = "book44",
			agent2U = "book04@yopmail.com",
			agent2P = "book04",
			attach1 = "//span[text()='Attach a file']",
			textArea1 = "//textarea[@class='form-control no-border']",

			adminMail = "jira@yopmail.com",
			adminPass = "pass123!",
			agent3U = "jira44@yopmail.com",
			agent3P = "jira44",
			pypeN = "Jira",
			textArea2 = "//textarea[@class='form-control no-border no-resize p-0']",
			attach2 = "//img[@ data-reactid='.0.2.0.1.1.0.0.1.2.0.4.1.2.0.0.0']",
			send = "//span[text()='Send']",

			// added march 21
			admin3U = "BOOK01@YOPMAIL.COM",
			admin4U = "Book01@YOpMail.com",
			InvalidAdmin = "Book@YOpMail.com",

			// added march 22
			admin5U = "pype175596@yopmail.com",
			admin5P = "pype175596",
			pName = "Pype175596",
			privateOption = "//div/p[text()='Private']",
			// continueButton = "//button[text()='Continue']";
			notification = "//div[@class='notification-message']",
			publicOption = "//div/p[text()='Public (default)']",
			publicRadioButton = "//input[@value='0']",
			cancelMark = "//button[@class='close']",

			// added 28 march
			QaboxUrl = "https://qabox-wpm-v3r2.pype.tech",
			clickAgentTab = "//div[text()='Agents']",
			currentWaitList = "//h6[contains(text(), 'CURRENT WAITLIST')]/following-sibling::h1",
			stopWalkThru = "//div[@title = 'Stop Walk-thru']",
			emailId = "//p[@class='fade no-margin p-t-10']",
			initiateChats = "//h5[contains(text(),'Initiate chats')]",

			// added 10th may
			webChatWidget = "//div[text()='Web chat widget']", streams = "//li[text()='Streams']",
			addANewStream = "//span[text()='Add a new Stream']", streamName1 = "autoStream"
					+ System.currentTimeMillis(), modStreamName = "modStream" + System.currentTimeMillis(),
			savestream = "//button[text()='Save']", widgetName = "Autowid" + System.currentTimeMillis(),
			widgetName1 = "Autowid1" + System.currentTimeMillis(),
			templateThirdPartySite = "//h1[text()='Template third party site']", webChatMsg = "Hi hello"
					+ System.currentTimeMillis(), agentMsgReply = "Ho! hi" + System.currentTimeMillis(),
			agentNotAvoilable = "We're sorry, there are currently no agents available",
			agentsBusy = "All chat support agents are currently busy. Please wait for the next available agent",
			widgetPosition = "Top right", pypemanager = "autouser@yopmail.com", pypemanagerpwd = "Pass@123",
			widgetPositionBottomLeft = "Bottom left", widgetPositionTopRight = "Top right",
			widgetPositionTopLeft = "Top left", streamAlert = "Alerts", streamSupport = "Support",
			webChatAgent = "webchat_agent@yopmail.com", pypemanagerSingleSession = "webchatsinglesession@yopmail.com",
			pypemanagerSingleStream = "singlestream@yopmail.com",
			webChatAgentSingleSession = "SingleSessionAgent@yopmail.com", botStream = "Botstream",
			specStream = "Spec",
			botLiveAgent = "Live Agent", clickStreamSection = "//li[text()='Streams']",
			LongStreamName = "modStream1492669379008", disableStream = "//button[text()= '%s']/"
					+ "parent::td/span/span/button[text()='Disable']",
			editIcon = "//div/div[4]/div[1]/div[1]/div[1]//div[1]/img",
			send8DigitNo = "12345678",sendOption1InFaqListpicker = "How will Discovery Health Medical Scheme cover your procedure or treatment?",
			emailData = "www.yopmail.com",selectedOptionMsg = "How will Discovery Health Medical Scheme cover your procedure or treatment?";

	public static final String[] botMsgs = { "Hello! How can I help you?", "Find a provider",
			"Digital membership card and certificate", "Claims", "FAQ" };
	public static final String[] allStreams = { "A1", "A10", "A11", "A12", "A13", "A14", "A15", "A16", "A17", "A18",
			"A19", "A2", "A20", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "AAA" };
	public static final String[] hyperspaceMsg = {"Go Back","Start Over","Live Agent","End Chat"};
}
