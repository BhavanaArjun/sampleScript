package qaframework.webElements;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;

public class ElementList {

	public AndroidDriver Android_Driver;

	public ElementList(AndroidDriver _driver) {
		this.Android_Driver = _driver;
	}

	public WebElements element(String elementName, String locatorStrategy)
			throws Exception {
		return new WebElements(this, this.getWebDriverBy(elementName,
				locatorStrategy));
	}

	/**
	 * Functions fetch element and returns WebdriverWait element
	 * 
	 * @param elementName
	 * @param locatorStrategy
	 * @return
	 * @throws Exception
	 */
	public WebdriverWait element_wait(String elementName, String locatorStrategy)
			throws Exception {
		return new WebdriverWait(this, this.getWebDriverBy(elementName,
				locatorStrategy));
	}

	public enum type {
		xpath, css, id, name, tagName, linktext, classname;
	}

	public By getWebDriverBy(String elementName, String locatorStrategy)
			throws Exception {
		By webdriverby = null;

		switch (type.valueOf(locatorStrategy)) {
		case xpath:
			webdriverby = By.xpath(elementName);
			break;
		case css:
			webdriverby = By.cssSelector(elementName);
			break;
		case id:
			webdriverby = By.id(elementName);
			break;
		case name:
			webdriverby = By.name(elementName);
			break;
		case tagName:
			webdriverby = By.tagName(elementName);
			break;
		case linktext:
			webdriverby = By.linkText(elementName);
			break;
		case classname:
			webdriverby = By.className(elementName);
			break;
		}
		return webdriverby;
	}

	/**
	 * Functions to wait for page loading
	 * 
	 * @param elementName
	 * @param locatorStrategy
	 * @return
	 * @throws Exception
	 */
	public boolean waitForLoading() throws InterruptedException {
		boolean bln = false;
		int intCnt = 0;
		Android_Driver
				.manage()
				.timeouts()
				.implicitlyWait(WaitTimeConstants.WAIT_TIME_False,
						TimeUnit.SECONDS);
		do {
			try {
				Android_Driver.findElement(
						By.className("android.widget.ProgressBar"))
						.isDisplayed();
				Android_Driver
						.manage()
						.timeouts()
						.implicitlyWait(WaitTimeConstants.WAIT_TIME_ForLoading,
								TimeUnit.SECONDS);
			} catch (Exception E) {
				break;
			} finally {
				Android_Driver
						.manage()
						.timeouts()
						.implicitlyWait(WaitTimeConstants.IMPLICIT_WAIT_TIME,
								TimeUnit.SECONDS);
			}

			intCnt++;
		} while (intCnt <= 30);

		return bln;
	}

}