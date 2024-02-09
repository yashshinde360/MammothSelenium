package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.InitDriver;

public class Helper {
	InitDriver initDriver = new InitDriver();
	
	public void waitForElementToBeVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(initDriver.getDriver(), 100);
		WebElement ele = wait.until(
		        ExpectedConditions.visibilityOf(element));
	}
}
