package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "user-name")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(id = "login-button")
	WebElement loginButton;

	@FindBy(xpath = "//div[@class='error-message-container error']")
	public WebElement errorMessage;

	public void login(String usernameData, String passwordData) {
		username.sendKeys(usernameData);
		password.sendKeys(passwordData);
	}

	public void clickLoginButton() {
		loginButton.click();

	}

	public String getErrorMessage() {
		return errorMessage.getText();
	}

	public boolean checkErrorMessageDisplayed() {
		return errorMessage.isDisplayed();
	}

}
