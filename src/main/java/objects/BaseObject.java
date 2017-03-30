package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.BaseTests;

public class BaseObject {
	protected WebElement element;
	protected static WebDriver driver = BaseTests.getWebDriver();

	public BaseObject(WebElement element) {
		this.element = element;
	}
}
