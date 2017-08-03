package lib.locators;

public class WebAdminTab {
	
	public class locators{
		
	    public static final String clickAdminTab = "//span[text()='Admin']",
				clickUserTab = "//span[text()='Users']",
				chatRouting = "//div[text()='Chat routing']",
				autoResponses = "//div[text()='Autoresponses']",
				invitation = "//div[contains(text(),'Send invitation')]",
				enterPassword = "//input[@placeholder ='Please enter a password']",
				reEnterPassword = "//input[@placeholder='Please re-enter your password']",
				continuePage = "//button[@type='submit']",
				crmDataDisabled = "//a//div[@class='fade'][text()='CRM data integration']",
				crmData = "//div[text()='CRM data integration']",
				endChatOption = "//a//div[text()='End chat options']",
				tagManagementDisabled = "//a//div[@class='fade'][text()='Tag management']",
				tagManagement = "//div[text()='Tag management']",
				prohibitionMessage = "//div[@class='notification-message']",
				clickWebChatWidget = "//div[text()='Web chat widget']",
                installCode = "//span[@class='_3zEP_TKO34GTi7TveY6RoO']",
                clickAgentTab = "//div[text()='Agents']",
				clickAddAgent = "//span[text()='Add agent']", 
				verifyAddAgentPage = "//h4[contains(text(),'Add agent')]",
				enterAgentFN = "//label/div[contains(text(),'First name')]/parent::label/input",
				enterAgentLN = "//label/div[contains(text(),'Last name')]/parent::label/input",
				enterAgentEmail = "//label/div/span[contains(text(),'Email')]/parent::div/parent::label/input",
				clickSendInvitationButton = "//button/div[contains(text(),'Send invitation')]",
				agentEmailId = "//div[contains(text(),'%s')]",
				agentEditButton = "//div[contains(text(),'%s')]/parent::div/parent::div/parent::div/parent::div/parent::div/div/div/div/div/div[@class='public_fixedDataTableCell_cellContent']/img",
				removeAgentButton = "//button[@class = 'save-btn btn remove-agent-btn btn-link text-danger']",
				confirmAgentRemoval = "//h4[contains(text(), 'Confirm agent removal')]",
				confirmRemoveAgentButton = "//button[@class = 'save-btn btn btn-danger']",
				agentChatLimit = "//div[contains(text(), 'Chat limit')]/parent::div/following-sibling::input",
				saveChangesButton = "//button[@class='save-btn btn btn btn-primary']";	    
	}
}