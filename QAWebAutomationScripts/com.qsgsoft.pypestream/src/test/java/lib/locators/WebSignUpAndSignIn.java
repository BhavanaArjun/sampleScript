package lib.locators;

public class WebSignUpAndSignIn {
	
	public class locators{
		
    public static final String urlQAToAddPype = "https://qa-wpm-v3r2.pype.tech/signup/step1?ref=web_sign_in_out",
				signin = "//button[contains(text(),'Sign in')]",
				signOut = "//button[text()='Sign out']",
				wloginId = "//input[@name = 'email']",
				QABoxUrl = "https://qabox-wpm-v3r2.pype.tech",
				QAUrl = "https://qa-wpm-v3r2.pype.tech/login",
				loginProhibition="//div[@class='alert alert-danger']",
				wPassword = "//input[@name = 'password']",
				clickOverViewTab = "//a[@href='/overview']",
				signout = "//button[contains(text(),'Sign out')]",
				notificationMessage = "//div[@class='notification-message']",
				notificationClose = "//div[@class='notification-message']/following-sibling::span";
	}
}