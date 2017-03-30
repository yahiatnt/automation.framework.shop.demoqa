package pages;

import java.util.List;

import org.testng.Assert;

import objects.FeaturedProducts;

public class HomePage extends Page {
	List<FeaturedProducts> featuredProducts;

	public HomePage() {
		FindFeaturedProducts();
	}

	public int getNumberOfFeaturedProducts() {
		return featuredProducts.size();
	}

	public FeaturedProducts getFeaturedProductsByHeader(String header) {
		FeaturedProducts result = null;

		for (FeaturedProducts f : featuredProducts) {
			if (f.getHeader().equals(header)) {
				result = f;
				break;
			}
		}

		if (result == null) {
			Assert.fail("Coun't find featured products wrapper with header = " + header);
		}

		return result;
	}

	private void FindFeaturedProducts() {
		featuredProducts = FeaturedProducts.getAllFeaturedProductsOnThisPage();
	}
}
