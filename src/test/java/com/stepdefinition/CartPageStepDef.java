package com.stepdefinition;

import org.testng.Assert;

import com.base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartPageStepDef extends BaseTest {

	@Given("User is on sauce website login page")
	public void user_is_on_sauce_website() {
		this.driver = setUp();
		pageObjects();
		Assert.assertEquals(driver.getCurrentUrl(), read.getProperties("sauceUrl"));
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}

	@Given("user login with valid username as {string} and valid password as {string} to sauce website")
	public void user_login_to_sauce_website(String username, String password) {
		login.login(username, password);
		login.clickLoginButton();

	}

	@Given("User add products to cart")
	public void user_add_products_to_cart() {
		Assert.assertEquals(product.getPageHeading(), "Products");
		product.addToCartTwoProducts();
	}

	@When("user move to cart page")
	public void user_move_to_cart_page() {
		product.clickCartButton();
		Assert.assertEquals(cart.getPageHeading(), "Your Cart");

	}

	@Then("verify products that are added are displayed in cartpage")
	public void verify_products_that_are_added_are_displayed_in_cartpage() {
		Assert.assertTrue(cart.checkProduct1Displayed(), "Product1 is displayed");
		Assert.assertTrue(cart.checkProduct2Displayed(), "Product2 is displayed");
		System.out.println("Products are displayed in cart page");
		tearDown();
	}

	@Then("verify products that products added and products in cart are same")
	public void verify_products_that_products_added_and_products_in_cart_are_same() {
		Assert.assertEquals(cart.getProduct1Name(), product.getProduct1Name());
		Assert.assertEquals(cart.getProduct2Name(), product.getProduct2Name());
		System.out.println("Products verified");
		tearDown();

	}

//	@After
//	public void closeBrowser() {
//		tearDown();
//	}

}
