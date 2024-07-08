package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage {

	WebDriver driver;

	public OverviewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "finish")
	WebElement finishButton;

	@FindBy(xpath = "//h2[@class='complete-header']")
	WebElement thankyouMessage;

	@FindBy(id = "react-burger-menu-btn")
	WebElement menuButton;

	@FindBy(id = "logout_sidebar_link")
	WebElement logoutButton;

	@FindBy(xpath = "//span[@class='title']")
	public WebElement overviewPageHeading;

	public void ClickFinishButton() {
		finishButton.click();

	}

	public void logout() {
		menuButton.click();
		logoutButton.click();

	}

	public String getThankyouMessage() {
		return thankyouMessage.getText();
	}

	public String getPageHeading() {
		return overviewPageHeading.getText();
	}

}
