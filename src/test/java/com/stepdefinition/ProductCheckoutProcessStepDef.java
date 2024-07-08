package com.stepdefinition;

import org.testng.Assert;
import com.base.BaseTest;
import com.utils.ReadExcelFile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductCheckoutProcessStepDef extends BaseTest {
	String firstname, lastname, postalCode;

	@Given("User is on sauce website")
	public void user_is_on_sauce_website() {
		this.driver = setUp();
		pageObjects();
		Assert.assertEquals(driver.getCurrentUrl(), read.getProperties("sauceUrl"));
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}

	@Given("user login with valid username as {string} password as {string} to sauce website")
	public void user_login_to_sauce_website(String username, String password) {
		login.login(username, password);
		login.clickLoginButton();

	}

	@Given("User is on products page")
	public void user_is_on_products_page() {
		Assert.assertEquals(product.getPageHeading(), "Products");
		System.out.println("User on Products page");
	}

	@When("user add products to cart")
	public void add_products_to_cart_and_verify_cart_value() {
		product.addToCartTwoProducts();

		Assert.assertEquals(product.getCartValue(), "2");
		System.out.println("Cart value is correct");

	}

	@When("move to cart page")
	public void move_to_cart_page() {
		product.clickCartButton();

		Assert.assertEquals(cart.getProduct1Name(), product.getProduct1Name());
		Assert.assertEquals(cart.getProduct2Name(), product.getProduct2Name());
		System.out.println("Products verified");

		Assert.assertEquals(cart.getPageHeading(), "Your Cart");
	}

	@When("click on checkout button")
	public void click_on_checkout_button() {
		cart.clickCheckoutButton();
	}

	@When("enter the details")
	public void enter_the_details_and_click_on_continue_button() {
		Assert.assertEquals(information.getPageHeading(), "Checkout: Your Information");
		ReadExcelFile.ExcelConnection("Sheet1");

		int rowCount = ReadExcelFile.workSheet.getPhysicalNumberOfRows();

		for (int i = 1; i < rowCount - 1; i++) {

			firstname = ReadExcelFile.ExcelReadDataFromCell(i, 2);
			lastname = ReadExcelFile.ExcelReadDataFromCell(i, 3);
			postalCode = ReadExcelFile.ExcelReadDataFromCell(i, 4);
			information.enterDetails("firstname", "lastname", "postalCode");
		}
	}

	@When("click on continue button")
	public void click_on_continue_button() {
		information.clickOnContinueButton();
	}

	@When("click on finish")
	public void click_on_finish() {
		Assert.assertEquals(overview.getPageHeading(), "Checkout: Overview");
		overview.ClickFinishButton();

	}

	@Then("product checkout should be completed and message to be displayed")
	public void product_checkout_should_be_completed_and_message_to_be_displayed() {
		Assert.assertEquals(overview.getThankyouMessage(), "Thank you for your order!");
		System.out.println("Product checkout completed");
	}

	@Then("logout from website")
	public void logout_from_website() {
		overview.logout();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
		System.out.println("Logout Successful");
		tearDown();

	}
//	@After
//	public void closeBrowser() {
//		tearDown();
//	}

}
