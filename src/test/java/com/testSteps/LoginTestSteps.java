package com.testSteps;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.pages.LoginPage;
import com.pages.HistoryViewByStorePage;
import com.pages.HomePage;

import driverFactory.InitDriver;
import utils.Helper;

public class LoginTestSteps {
	InitDriver initDriver = new InitDriver();
	Helper helper = new Helper();
	public WebDriver driver = initDriver.getDriver();
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	HistoryViewByStorePage historyViewByStorePage = new HistoryViewByStorePage(driver);

	public void navigateToLoop() {
		driver.get("https://app.tryloop.ai/login/password");
	}

	public void enterUsername(String username) {
		helper.waitForElementToBeDisappear(homePage.getLoadingSpinner());
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

	public void verifyWelcomeMessage() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		helper.waitForElementToBeClickable(homePage.getSkipForNowButton());
		if (homePage.getSkipForNowButton().isDisplayed()) {

			helper.waitForElementToBeVisible(homePage.getSkipForNowButton());
			homePage.getSkipForNowButton().click();
		}
		helper.waitForElementToBeVisible(homePage.getWelcomeMessage());
		System.out.println(homePage.getWelcomeMessage().getText());
		assertTrue(homePage.getWelcomeMessage().getText().contains("Welcome back, "));
	}

	public void verifyLoopHomePage() {
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, "https://app.tryloop.ai/home");
	}

	public void navigateToSubMenu(String hambergerMenu, String subMenu) {
		helper.waitForElementToBeClickable(homePage.getHambergerManu(hambergerMenu));
		homePage.getHambergerManu(hambergerMenu).click();
		helper.waitForElementToBeClickable(homePage.getHambergerManu(subMenu));
		homePage.getHambergerManu(subMenu).click();
	}
}
