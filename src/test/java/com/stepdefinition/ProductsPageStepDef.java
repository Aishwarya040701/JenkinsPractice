package com.stepdefinition;

import org.testng.Assert;

import com.base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductsPageStepDef extends BaseTest {

	@Given("User is on sauce demo website")
	public void user_is_on_sauce_website() {
		this.driver = setUp();
		pageObjects();
		Assert.assertEquals(driver.getCurrentUrl(), read.getProperties("sauceUrl"));
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}

	@Given("user login with valid username as {string} and password as {string} to sauce website")
	public void user_login_to_sauce_website(String username, String password) {
		login.login(username, password);
		login.clickLoginButton();

	}

	@Given("User as navigated to products page")
	public void user_is_on_products_page() {
		Assert.assertEquals(product.getPageHeading(), "Products");
		System.out.println("User on Products page");
	}

	@When("user add products to cart {string}")
	public void add_products_to_cart_and_verify_cart_value(String methodName) {
		switch (methodName) {
		case "addToCartTwoProducts":
			product.addToCartTwoProducts();
			break;
		case "addToCartFourProducts":
			product.addToCartFourProducts();
			break;
		case "removeFromCart":
			product.removeFromCart();
			break;

		}

	}

	@Then("check cart value with expected result cartValue {string}")
	public void check_cart_value_with_expected_result(String carValue) {
		Assert.assertEquals(product.getCartValue(), carValue);
		System.out.println("Cart value is correct");
		tearDown();

	}

	@When("user click on filter options with value {string}")
	public void user_click_on_filter_options_with_value(String value) {
		product.sortProductsByValue(value);
	}

	@Then("the products should be sorted based on the value and the first product is {string} and {string}")
	public void the_products_should_be_sorted_based_on_the_value_and_the_first_product_is(String productName,
			String result) {

		Assert.assertEquals(product.getSortedProduct(), productName);
		System.out.println(result + " Verified");
		tearDown();
	}

//	@After
//	public void closeBrowser() {
//		tearDown();
//	}

}
