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
		return driver.findElement(By.id("username"));
	}
	
	public WebElement getPasswordField() {
		return driver.findElement(By.id("password"));
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(By.xpath("//span[text()='Log In']"));
	}
	
	public WebElement getProfileIcon() {
		return driver.findElement(By.cssSelector("[data-name*='profile']"));
	}
}
