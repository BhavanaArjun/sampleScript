package qaframework.webElements;

import static org.testng.AssertJUnit.assertTrue;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

import qaframework.configuration.GetInfo;
import qaframework.custom.WaitForElement;

public class WebdriverWait {

	public By webDriverBy;
	WebDriver driver;
	WaitForElement wait;

	public WebdriverWait(ElementList elementList, By by) {
		this.driver = elementList.Android_Driver;
		this.webDriverBy = by;
		wait = new WaitForElement(this.driver);
	}

	/**
	 * Functions to wait until the element is displayed
	 * 
	 * @param elementName
	 * @param locatorStrategy
	 * @return
	 * @throws Exception
	 */
	public boolean waitForVisibilityOfElement() throws Exception {
		boolean bln = false;
		int intCnt = 0;
		do {
			try {
				driver.findElement(webDriverBy).isDisplayed();
				bln = true;
				break;
			} catch (InvalidElementStateException e) {
				intCnt++;
				wait.waitForTwoSecond();
			} catch (StaleElementReferenceException SE) {
				intCnt++;
				wait.waitForTwoSecond();
			} catch (NoSuchElementException SE) {
				intCnt++;
				wait.waitForTwoSecond();
			} catch (Exception e) {
				intCnt++;
				wait.waitForTwoSecond();
			}
			intCnt++;
		} while (intCnt <= 30);

		assertTrue("Failed in " + GetInfo.getCallingFunctionName(4)
				+ " on page " + GetInfo.getCallingClassName(4) + " element "
				+ webDriverBy + " is not displayed ", bln);
		return bln;
	}

	public boolean isElementPresent() throws InvocationTargetException {
		@SuppressWarnings("unused")
		int intCnt = 0;
		boolean blnFound = false;
		try {
			try {
				driver.findElement(webDriverBy).isDisplayed();
				blnFound = true;

			} catch (NoSuchElementException e) {
				intCnt++;
				wait.waitForOneSecond();
				blnFound = false;

			} catch (StaleElementReferenceException e) {
				intCnt++;
				wait.waitForOneSecond();
				blnFound = false;

			} catch (InvalidElementStateException e) {
				intCnt++;
				wait.waitForOneSecond();
				blnFound = false;
			}

		} catch (Exception E) {

		}
		return blnFound;
	}

}
