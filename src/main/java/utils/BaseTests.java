package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTests {
	private static WebDriver driver;

	@BeforeClass
	public static void OpenApplication() {
		setChromeDriverProperty();
		driver = new ChromeDriver();
		driver.get(Links.HOME);
	}

	@AfterClass
	public static void QuitApplication() {
		driver.quit();
	}

	public static WebDriver getWebDriver() {
		return driver;
	}

	private static void setChromeDriverProperty() {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium drivers\\chromedriver.exe");
	}
}
