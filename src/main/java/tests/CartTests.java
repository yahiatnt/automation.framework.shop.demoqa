package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import objects.AddedToCartPopup;
import objects.FeaturedProducts;
import objects.ProductItem;
import pages.HomePage;
import utils.BaseTests;

public class CartTests extends BaseTests {
	@Test
	public void AddProductToCartFromProductItemOnFeatureProducts() {
		HomePage homePage = new HomePage();
		Assert.assertEquals(homePage.getNumberOfFeaturedProducts(), 4);
		FeaturedProducts featuredProdcuts = homePage.getFeaturedProductsByHeader("DRESSES");
		Assert.assertEquals(featuredProdcuts.getNumberOfProducts(), 3);
		ProductItem productItem = featuredProdcuts.getProductByName("SNOW SEQUINS BODYCON DRESS");
		AddedToCartPopup popup = productItem.addToCart();
		Assert.assertEquals(popup.getMessage(), "PRODUCT WAS SUCCESSFULLY ADDED TO YOUR CART.");
		popup.viewCart();
	}
}
