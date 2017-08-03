package qaframework.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaframework.webElements.WaitTimeConstants;

public class Web_WebdriverWait {

	public By webDriverBy;
	WebDriver wb_driver;

	public Web_WebdriverWait(Web_ElementList elementList, By by) {
		this.wb_driver = elementList.wb_driver;
		this.webDriverBy = by;
	}

	public boolean waitForInvisibilityOfElement() {
		WebDriverWait wait = new WebDriverWait(this.wb_driver,
				WaitTimeConstants.WAIT_TIME_TOO_SMALL);
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(this.webDriverBy));
		return false;
	}

	@SuppressWarnings("deprecation")
	public boolean waitForText(String text) {
		WebDriverWait wait = new WebDriverWait(this.wb_driver,
				WaitTimeConstants.WAIT_TIME_LONG);
		wait.until(ExpectedConditions.textToBePresentInElement(
				this.webDriverBy, text));
		return false;
	}

}
