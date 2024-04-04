package com.testSteps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.pages.LoginPage;
import driverFactory.InitDriver;
import utils.Helper;

public class LoginTestSteps {
	InitDriver initDriver = new InitDriver();
	Helper helper = new Helper();
	public WebDriver driver = initDriver.getDriver();
	LoginPage loginPage = new LoginPage(driver);
	
	public void navigateToMammoth() {
		driver.get("http://bangalore.mammoth.io/");
	}
	
	public void enterUserName(String userName) {
		helper.waitForElementToBeVisible(loginPage.getuserNameField());
		loginPage.getuserNameField().sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		loginPage.getPasswordField().sendKeys(password);
	}
	
	public void clickOnLoginButton() {
		loginPage.getLoginButton().click();
	}
	
	public void verifyProfileIcon(){
		helper.waitForElementToLoad();
		Assert.assertTrue(loginPage.getProfileIcon().isDisplayed());
	}

}