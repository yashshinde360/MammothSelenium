package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver= driver;	
	}
	
	public WebElement getWelcomeMessage() {
		return driver.findElement(By.cssSelector(".MuiBox-root h2"));
	}
	
	public WebElement getLoadingSpinner() {
		return driver.findElement(By.cssSelector(".MuiCircularProgress-circle"));
	}
	
	public WebElement getSkipForNowButton() {
		return driver.findElement(By.xpath("//button[text()='Skip for now']"));
	}
	
	public WebElement getHambergerManu(String hambergerMenu) {
		return driver.findElement(By.xpath("//span[text()='"+hambergerMenu+"']"));
	}
	
	public WebElement getSubMenu(String subMenu) {
		return driver.findElement(By.xpath("//span[text()='"+subMenu+"']"));
	}
}
