package qaframework.webElements;

import io.appium.java_client.android.AndroidDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import qaframework.configuration.GetInfo;

public class WebElements {

	public By webDrivryBy;
	AndroidDriver driver;

	public WebElements(ElementList elementList, By by) {
		this.driver = elementList.Android_Driver;
		this.webDrivryBy = by;
	}

	/**
	 * Verifies whether element present or not
	 * 
	 * @param elementName
	 * @param locatorStrategy
	 * @returns true for at least one match or false if no matches found.
	 * @throws Exception
	 */
	public WebElement getOne() throws Exception {
		WebElement element = null;
		try {
			element = this.driver.findElement(this.webDrivryBy);
		} catch (Exception E) {
			System.out.println(GetInfo.getCallingFunctionName(4) + " on page "
					+ GetInfo.getCallingClassName(4) + " " + webDrivryBy
					+ " is not displayed");

		}
		return element;
	}

	public List<WebElement> get() throws Exception {
		return this.driver.findElements(webDrivryBy);
	}

	/**
	 * Function finds the element and clear the input value and returns the
	 * WebElement
	 * 
	 * @param elementName
	 * @param locatorStrategy
	 * @return WebElements
	 * @throws Exception
	 */
	public List<WebElement> clearInputsValue() throws Exception {
		List<WebElement> element = this.get();
		for (WebElement _element : element) {
			_element.clear();
			if (!_element.getAttribute("value").equals("")) {
				throw new Exception("Input value is not cleared");
			}
		}
		return element;
	}

	/**
	 * Function finds the element and clear the input value and returns the
	 * WebElement
	 * 
	 * @param elementName
	 * @param locatorStrategy
	 * @return single WebElement
	 * @throws Exception
	 */
	public WebElement clearInputValue() throws Exception {
		WebElement element = this.getOne();
		element.clear();
		if (!element.getAttribute("value").equals("")) {
			throw new Exception("Input value is not cleared");
		}
		return element;
	}

	/**
	 * Function finds the element and enter the input value
	 * 
	 * @param elementName
	 * @param locatorStrategy
	 * @return single WebElement
	 * @throws Exception
	 */
	public void enterText2(String text) throws Exception {
		WebElement element = this.getOne();
		/*
		 * element.sendKeys(Keys.BACK_SPACE ); element.clear(); element.click();
		 * element.sendKeys(text); clear(); element.sendKeys(text);
		 */
		clear();
		element.sendKeys(text);

	}

	public void enterText(String text) throws Exception {
		WebElement element = this.getOne();
		element.click();
		// clear();
		element.sendKeys(text);
	}

	public void enterText1(String text) throws Exception {
		WebElement element = this.getOne();
		// element.clear();
		element.click();
		clear();
		element.sendKeys(text);
		/*
		 * element.sendKeys(Keys.chord(Keys.CONTROL, "a"), "55");//Firstly
		 * select all the text in the field and then send the new sequence:
		 * element.sendKeys(text);
		 */

	}

	// clear inputs
	public void cleatTextFully(WebElement element) {

		int stringLength = element.getText().length();

		for (int i = 0; i < stringLength; i++) {
			driver.pressKeyCode(22); // "KEYCODE_DPAD_RIGHT"
		}

		for (int i = 0; i < stringLength; i++) {
			driver.pressKeyCode(67); // "KEYCODE_DEL"
		}
	}

	public void clear() throws Exception {
		WebElement element = this.getOne();
		String text = element.getText();
		int maxChars = text.length();
		for (int i = 0; i < maxChars; i++)
			driver.pressKeyCode(67);
	}

	/**
	 * Function to convert element of type WebElement to Select
	 * 
	 * @param elementName
	 * @param locatorStrategy
	 * @return Select
	 * @throws Exception
	 */
	public void select(String text) throws Exception {
		WebElement element = this.getOne();
		new Select(element).selectByVisibleText(text);
	}

	/**
	 * click action on web element
	 * 
	 * @param elementName
	 * @param locatorStrategy
	 * @throws Exception
	 */
	public void click() throws Exception {
		this.getOne().click();
	}

	/**
	 * Function finds the element and get text
	 * 
	 * @param elementName
	 * @param locatorStrategy
	 * @return single WebElement
	 * @throws Exception
	 */
	public Assertions getText() throws Exception {
		WebElement element = this.getOne();
		return new Assertions(element.getText());
	}

	/**
	 * Function to convert element of get first selected value from drop down
	 * 
	 * @param elementName
	 * @param locatorStrategy
	 * @return single WebElement
	 * @throws Exception
	 */
	public String getSelectedOptionFromDropDown() throws Exception {
		WebElement element = this.getOne();
		return new Select(element).getFirstSelectedOption().getText();
	}

	public void mouseOver() throws Exception {
		WebElement element = this.getOne();
		Actions action = new Actions(this.driver);
		action.moveToElement(element).build().perform();

	}

	/**
	 * Function hide the keypad
	 * 
	 * @param elementName
	 * @param locatorStrategy
	 * @return single WebElement
	 * @throws Exception
	 */
	public void enterTextByHidingKeyPad(String Text) throws Exception {
		WebElement element = this.getOne();
		element.click();
		driver.manage()
				.timeouts()
				.implicitlyWait(WaitTimeConstants.WAIT_TIME_ForLoading,
						TimeUnit.SECONDS);
		;
		driver.hideKeyboard();
		element.sendKeys(Text);
	}

	public void scrollDownTillElement(String locatorName, String locatorStrategy)
			throws Exception {
		WebElement element = this.getOne();
		((JavascriptExecutor) this.driver).executeScript(
				"arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * Double click action on web element
	 * 
	 * @param elementName
	 * @param locatorStrategy
	 * @throws Exception
	 */
	public void doubleClick() throws Exception {
		Actions actions = new Actions(this.driver);
		actions.doubleClick(this.getOne()).build().perform();
	}

}
