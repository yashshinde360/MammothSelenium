package utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.InitDriver;

public class Helper {
	InitDriver initDriver = new InitDriver();
	WebDriver driver = initDriver.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));
	
	public void waitForElementToBeVisible(WebElement element) {
		WebElement ele = wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementToBeDisappear(WebElement element) {
		Boolean ele = wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void waitForElementToBeClickable(WebElement element) {
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElementToLoad() {
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
	}
	
	public void switchToTab(int index) {
		List<String> windowHandlesList = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowHandlesList.get(index));
	}
	
	public void closeTab(int index) {
		List<String> windowHandlesList = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowHandlesList.get(index)).close();;
	}
	
	public void uploadFile(WebElement element, String fileName) {
		String projectPath = System.getProperty("user.dir");
		String filePath = projectPath+"/src/test/resources/testAssets/"+fileName;
		element.sendKeys(filePath);
	}
}
