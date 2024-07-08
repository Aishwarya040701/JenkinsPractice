package com.base;

import org.openqa.selenium.WebDriver;

import com.pom.LoginPage;
import com.pom.OverviewPage;
import com.pom.ProductsPage;
import com.pom.YourCartPage;
import com.pom.YourInformationPage;

public class DriverManager {

	WebDriver driver;

	public DriverManager(WebDriver driver) {
		this.driver = driver;
	}

	// login page object
	public LoginPage getLoginPage() {
		return new LoginPage(this.driver);
	}

	// product page object
	public ProductsPage getProductPage() {
		return new ProductsPage(this.driver);
	}

	// YourCart page object
	public YourCartPage getYourCartPage() {
		return new YourCartPage(this.driver);
	}

	// your information page object
	public YourInformationPage getOurInformationPage() {
		return new YourInformationPage(this.driver);
	}

	// overview page object
	public OverviewPage getOverviewPage() {
		return new OverviewPage(this.driver);
	}

}
