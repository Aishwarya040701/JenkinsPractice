package com.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import com.pom.LoginPage;
import com.pom.OverviewPage;
import com.pom.ProductsPage;
import com.pom.YourCartPage;
import com.pom.YourInformationPage;
import com.utils.ReadPropertiesFile;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	public WebDriver driver;
	public ReadPropertiesFile read;
	public LoginPage login;
	public ProductsPage product;
	public YourCartPage cart;
	public YourInformationPage information;
	public OverviewPage overview;

	public WebDriver setUp() {
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--no-sandbox");

		options.addArguments("--disable-dev-shm-usage");

		options.addArguments("--headless");


		read = new ReadPropertiesFile();
		switch (System.getProperty("browser", "chrome")) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("Incorrect Browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(read.getProperties("sauceUrl"));
		
		return driver;
	}

	public void pageObjects() {
		DriverManager manager = new DriverManager(driver);
		login = manager.getLoginPage();
		product = manager.getProductPage();
		cart = manager.getYourCartPage();
		information = manager.getOurInformationPage();
		overview = manager.getOverviewPage();
	}

	public void tearDown() {
		driver.quit();
	}

}
