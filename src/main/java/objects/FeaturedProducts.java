package objects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FeaturedProducts extends BaseObject {
	private static By headerIdentifier = By.xpath(".//div[contains(@class,'product-header')]//span");
	private static By wrapperIdentifier = By.xpath(".//div[contains(@class,'product-wrap')]");

	List<ProductItem> products;

	public FeaturedProducts(WebElement element) {
		super(element);
		findProducts();
	}

	public int getNumberOfProducts() {
		return products.size();
	}

	public static List<FeaturedProducts> getAllFeaturedProductsOnThisPage() {
		List<WebElement> featuredProductsElements = driver.findElements(wrapperIdentifier);
		List<FeaturedProducts> featuredProducts = new ArrayList<FeaturedProducts>();
		for (WebElement e : featuredProductsElements) {
			FeaturedProducts f = new FeaturedProducts(e);
			featuredProducts.add(f);
		}

		return featuredProducts;
	}

	private void findProducts() {
		products = ProductItem.getAllProductsUnderParentObject(this);
	}

	public String getHeader() {
		return element.findElement(headerIdentifier).getText();
	}

	public ProductItem getProductByName(String name) {
		ProductItem result = null;

		for (ProductItem p : products) {
			if (p.getName().equals(name)) {
				result = p;
				break;
			}
		}

		if (result == null) {
			Assert.fail("Couldn't find product with name = " + name);
		}

		return result;
	}
}
