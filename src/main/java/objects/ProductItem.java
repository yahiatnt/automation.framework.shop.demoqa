package objects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductItem extends BaseObject {
	private static By productItemHolderIdentifier = By.xpath(".//div[contains(@class,'product-item')]");
	private static By nameIdentifier = By.xpath(".//h3/a");
	private static By thumbnatilImagesIdentifier = By.xpath(".//div[contains(@class,'product-thumbnail')]//img");
	private static By pricesIdentifier = By.xpath(".//span[@class='price']");
	private static By addToCartIdentifier = By.xpath(".//a[contains(@class,'add_to_cart_button')]");
	private static By addToWishListIdentifier = By.xpath(".//a[contains(@class,'add_to_wishlist')]");
	private static By zoomIdentifier = By.xpath(".//span[contains(@class,'zoom-in')]");

	public ProductItem(WebElement element) {
		super(element);
	}

	public AddedToCartPopup addToCart() {
		showButtons();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element.findElement(addToCartIdentifier))).click();
		// element.findElement(addToCartIdentifier).click();
		return new AddedToCartPopup();
	}

	public void addToWishList() {
		showButtons();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element.findElement(addToWishListIdentifier))).click();
		// element.findElement(addToWishListIdentifier).click();
	}

	public static List<ProductItem> getAllProductsUnderParentObject(BaseObject parent) {
		List<WebElement> productsElements = parent.element.findElements(productItemHolderIdentifier);
		List<ProductItem> products = new ArrayList<ProductItem>();
		for (WebElement e : productsElements) {
			ProductItem p = new ProductItem(e);
			products.add(p);
		}

		return products;
	}

	void showButtons() {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	public String getName() {
		return element.findElement(nameIdentifier).getText();
	}
}
