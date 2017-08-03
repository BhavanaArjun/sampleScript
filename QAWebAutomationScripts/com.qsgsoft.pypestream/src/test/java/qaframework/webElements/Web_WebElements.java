package qaframework.webElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import qaframework.webElements.WaitTimeConstants;

public class Web_WebElements {

	public By webDrivryBy;
	WebDriver wb_driver;

	public Web_WebElements(Web_ElementList elementList, By by) {
		this.wb_driver = elementList.wb_driver;
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
		WebElement element = this.wb_driver.findElement(this.webDrivryBy);
		return element;
	}

	public List<WebElement> get() throws Exception {
		return this.wb_driver.findElements(webDrivryBy);
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
	public void webElementToEnterText(String Text) throws Exception {
		WebElement element = this.getOne();
		element.clear();
		element.sendKeys(Text);
	}

	/**
	 * Refreshes the page
	 */
	public void pageRefresh() {
		this.wb_driver.navigate().refresh();
	}

	public void waitForPageToLoad() throws Exception {
		@SuppressWarnings("unused")
		boolean blnPageLoaded;
		do {
			blnPageLoaded = ((JavascriptExecutor) wb_driver).executeScript(
					"return document.readyState").equals("complete");
		} while (blnPageLoaded = false);
	}

	/**
	 * Performs mouse over action
	 * 
	 * @param elementName
	 * @param locatorStrategy
	 * @throws Exception
	 */
	public void mouseOver() throws Exception {
		WebElement element = this.getOne();
		Actions action = new Actions(this.wb_driver);
		action.moveToElement(element).build().perform();
	}

	/**
	 * Function to convert element of type WebElement to Select
	 * 
	 * @param elementName
	 * @param locatorStrategy
	 * @return Select
	 * @throws Exception
	 */
	public void webElementToSelect(String text) throws Exception {
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
	public void Click() throws Exception {
		Actions actions = new Actions(this.wb_driver);
		actions.click(this.getOne()).build().perform();
	}

	/**
	 * Double click action on web element
	 * 
	 * @param elementName
	 * @param locatorStrategy
	 * @throws Exception
	 */
	public void doubleClick() throws Exception {
		Actions actions = new Actions(this.wb_driver);
		actions.doubleClick(this.getOne()).build().perform();
	}

	// Drag and Drop action
	public void dragAndDrop(WebElement target) throws Exception {
		WebElement source = this.getOne();
		Actions action = new Actions(this.wb_driver);
		action.dragAndDrop(source, target).build().perform();
	}

	/**
	 * Verifies whether element present or not
	 * 
	 * @param elementName
	 * @param locatorStrategy
	 * @returns true for at least one match or false if no matches found.
	 * @throws Exception
	 */
	public boolean isElementPresent() throws Exception {

		boolean present = true;
		if (this.get().size() == 0) {
			present = false;
		}
		return present;
	}

	/**
	 * Verifies whether element present or not
	 * 
	 * @param elementName
	 * @param locatorStrategy
	 * @returns true for at least one match or false if no matches found.
	 * @throws Exception
	 */
	public boolean isElementPresent(int count) throws Exception {
		wb_driver.manage().timeouts().implicitlyWait(count, TimeUnit.SECONDS);
		boolean present = true;
		if (this.get().size() == 0) {
			present = false;
		}
		wb_driver
				.manage()
				.timeouts()
				.implicitlyWait(WaitTimeConstants.WAIT_TIME_LONG,
						TimeUnit.SECONDS);
		return present;
	}

	public void scrollDownTillElement(String locatorName, String locatorStrategy)
			throws Exception {
		WebElement element = this.getOne();
		((JavascriptExecutor) this.wb_driver).executeScript(
				"arguments[0].scrollIntoView(true);", element);
	}

	public int getXpathCount() throws Exception {
		return this.get().size();
	}

	public int getCssCount() throws Exception {
		return this.get().size();
	}

	/**
	 * Function finds the element and get text
	 * 
	 * @param elementName
	 * @param locatorStrategy
	 * @return single WebElement
	 * @throws Exception
	 */
	public String webElementToGetText() throws Exception {
		WebElement element = this.getOne();
		return element.getText();
	}

	/**
	 * Function finds the element and get value
	 * 
	 * @param elementName
	 * @param locatorStrategy
	 * @return single WebElement
	 * @throws Exception
	 */
	public String webElementToGetValue() throws Exception {
		WebElement element = this.getOne();
		return element.getAttribute("value");
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

	/**
	 * Function finds the element and get value
	 * 
	 * @param elementName
	 * @param locatorStrategy
	 * @return single WebElement
	 * @throws Exception
	 */
	public String webElementToGetAttributeTitle() throws Exception {
		WebElement element = this.getOne();
		return element.getAttribute("title");
	}

}
