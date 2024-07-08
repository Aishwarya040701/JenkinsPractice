package com.stepdefinition;

import org.testng.Assert;

import com.base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class YourInformationPageStepDef extends BaseTest {

	@Given("User is on sauce demo website login page")
	public void user_is_on_sauce_demo_website_login_page() {
		this.driver = setUp();
		pageObjects();
		Assert.assertEquals(driver.getCurrentUrl(), read.getProperties("sauceUrl"));
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}

	@Given("User will complete product checkout process till your information page")
	public void User_will_complete_product_checkout_process_till_your_information_page() {

		login.login("standard_user", "secret_sauce");
		login.clickLoginButton();
		Assert.assertEquals(product.getPageHeading(), "Products");
		product.addToCartTwoProducts();
		product.clickCartButton();
		cart.clickCheckoutButton();
	}

	@Given("User is on your information page")
	public void user_is_on_your_information_page() {
		Assert.assertEquals(information.getPageHeading(), "Checkout: Your Information");
	}

	@When("user enter valid firstName as {string} lastName as {string} and postalCode as {string}")
	public void user_enter_valid_first_name_as_last_name_as_and_postal_code_as(String firstName, String lastName,
			String postalCode) {
		information.enterDetails(firstName, lastName, postalCode);
		information.clickOnContinueButton();
	}

	@Then("User should be able navigate to overview page")
	public void user_should_be_able_navigate_to_overview_page() {
		Assert.assertEquals(overview.getPageHeading(), "Checkout: Overview");
		tearDown();
	}

	@When("user enter valid firstName {string} lastName {string} and postalCode {string}")
	public void user_enter_valid_first_name_last_name_and_postal_code(String firstName, String lastName,
			String postalCode) {
		information.enterDetails(firstName, lastName, postalCode);
		information.clickOnContinueButton();
	}

	@Then("User should get correct error meassage {string}")
	public void user_should_get_correct_error_meassage(String error) {

		Assert.assertEquals(information.getErrorMessage(), error);
		tearDown();
	}
//@After
//public void closeBrowser() {
//	tearDown();
//}

}
