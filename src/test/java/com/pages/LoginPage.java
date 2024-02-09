package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver= driver;	
	}
	
	public WebElement getuserNameField() {
		return driver.findElement(By.cssSelector("[data-testid='login-email'] input"));
	}
	
	public WebElement getPasswordField() {
		return driver.findElement(By.cssSelector("[data-testid='login-password'] input"));
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(By.cssSelector("[data-testid='login-button']"));
	}
	
	public WebElement getWelcomeMessage() {
		return driver.findElement(By.cssSelector(".MuiBox-root h2"));
	}
}
