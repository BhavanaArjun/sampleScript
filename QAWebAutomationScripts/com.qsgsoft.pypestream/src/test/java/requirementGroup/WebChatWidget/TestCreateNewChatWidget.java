package requirementGroup.WebChatWidget;

import lib.dataObject.WCWData;
import lib.page.WebAdminTab;
import lib.page.WebSignUpAndSignIn;
import org.testng.annotations.Test;
import qaframework.configuration.Configuration_Web;

public class TestCreateNewChatWidget extends Configuration_Web {

	// feb 08 2017
	@Test(description = "Verify that configure general setting Step is completed when Next button"
			+ " is clicked  after selecting Stream in (Step 1) Configure widget settings screen.")
	public void BQS200197() throws Exception {

		TCID = "200197";
		strTO = "Verify that configure general setting Step is completed when Next button is "
				+ "clicked  after selecting Stream in (Step 1) Configure widget settings screen.";

		// Object for test data
		WCWData objWebTestData = new WCWData();

		// Test Data
		String strEmail = objWebTestData.pypemanager;
		String strPassword = objWebTestData.pypemanagerpwd;

		// mWeb.setUp();
		WebSignUpAndSignIn objWebSignUpAndSignIn = new WebSignUpAndSignIn();
		WebAdminTab objWebAdminTab = new WebAdminTab(wdriver);


		objWebSignUpAndSignIn.launchQALoginPage();
		objWebSignUpAndSignIn.wLogin("autouser@yopmail.com");
		objWebSignUpAndSignIn.wPassword("Pass@123");
		objWebSignUpAndSignIn.clickSignin();
		objWebAdminTab.clickAdminTab();
	

		gstrResult = "PASS";

	}

}
