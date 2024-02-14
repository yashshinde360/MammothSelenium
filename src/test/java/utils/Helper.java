package utils;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.InitDriver;

public class Helper {
	InitDriver initDriver = new InitDriver();

	public void waitForElementToBeVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(initDriver.getDriver(), Duration.ofSeconds(30));
		WebElement ele = wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementToBeDisappear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(initDriver.getDriver(), Duration.ofSeconds(30));
		Boolean ele = wait.until(ExpectedConditions.invisibilityOfAllElements(element));
	}

	public void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(initDriver.getDriver(), Duration.ofSeconds(30));
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
