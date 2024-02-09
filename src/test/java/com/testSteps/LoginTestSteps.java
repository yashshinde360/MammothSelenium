package com.testSteps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.LoginPage;

import driverFactory.InitDriver;
import utils.Helper;

public class LoginTestSteps {
	InitDriver initDriver = new InitDriver();
	Helper helper = new Helper();
	public WebDriver driver = initDriver.getDriver();
	
	LoginPage loginPage = new LoginPage(initDriver.getDriver());
	
	public void navigateToLoop() {
		driver.get("https://app.tryloop.ai/login/password");
	}
	
	public void enterUsername(String username) {
		helper.waitForElementToBeVisible(loginPage.getuserNameField());
		loginPage.getuserNameField().sendKeys(username);
	}
	
	public void enterPassword(String password) {
		helper.waitForElementToBeVisible(loginPage.getPasswordField());
		loginPage.getPasswordField().sendKeys(password);
	}
	
	public void clickOnLoginButton() {
		helper.waitForElementToBeVisible(loginPage.getLoginButton());
		loginPage.getLoginButton().click();
	}
	
	public void verifyWelcomeMessage() throws InterruptedException {
		Thread.sleep(10000);
		helper.waitForElementToBeVisible(loginPage.getWelcomeMessage());
		System.out.println(loginPage.getWelcomeMessage().getText());
		assertTrue(loginPage.getWelcomeMessage().getText().contains("Welcome back, "));
	}
}
