package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddedToCartPopup extends BaseObject {
	By containerIdentifier = By.xpath(".//div[contains(@class,'white-popup')]");
	By messageIdentifier = By.tagName("p");
	By continueShoppingIdentifier = By.xpath(".//a[contains(@class,'close-popup')]");
	By viewCartIdentifier = By.xpath(".//a[contains(@class,'view-cart')]");

	public AddedToCartPopup() {
		super(null);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(containerIdentifier));
		element = driver.findElement(containerIdentifier);
	}

	public String getMessage() {
		return element.findElement(messageIdentifier).getText();
	}

	public void continueShopping() {
		element.findElement(continueShoppingIdentifier).click();
		switchBackToPage();
	}

	public void viewCart() {
		element.findElement(viewCartIdentifier).click();
		switchBackToPage();
	}

	private void switchBackToPage() {
		driver.switchTo().defaultContent();
	}
}
