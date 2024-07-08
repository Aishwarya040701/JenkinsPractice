package com.stepdefinition;

import org.testng.Assert;
import com.base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef extends BaseTest {

	@Given("User is on login page")
	public void user_is_on_login_page() {
		this.driver = setUp();
		pageObjects();
		Assert.assertEquals(driver.getCurrentUrl(), read.getProperties("sauceUrl"));
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}

	@Given("User enter valid username as {string}  and password as {string}")
	public void user_enter_valid_username_as_and_password_as(String username, String password) {
		login.login(username, password);
	}

	@When("click on login button")
	public void click_on_login_button() {
		login.clickLoginButton();

	}

	@Then("User should be able to login and navigate to products page")
	public void user_should_be_able_to_login_and_navigate_to_products_page() {
		Assert.assertEquals(product.getPageHeading(), "Products");
		System.out.println("Login Successfull!!!");

		tearDown();

	}

	@Given("User enter invalid username {string}  and password as {string}")
	public void user_enter_invalid_username_and_password_as(String username, String password) {
		login.login(username, password);
	}

	@Then("User should not be able to login and error message {string} is displayed")
	public void user_should_not_be_able_to_login_and_error_message_is_displayed(String errorMessage) {
		Assert.assertTrue(login.checkErrorMessageDisplayed(), "Error message is  displayed");
		Assert.assertEquals(login.getErrorMessage(), errorMessage);
		System.out.println("Error Message " + errorMessage);
		tearDown();

	}
//	@After
//	public void closeBrowser() {
//		tearDown();
//	}

}
