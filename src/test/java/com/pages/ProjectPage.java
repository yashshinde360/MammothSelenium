package com.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectPage {
	WebDriver driver;
	public ProjectPage(WebDriver driver) {
		this.driver= driver;
	}
	
	public WebElement getPageHeading() {
		return driver.findElement(By.cssSelector(".navbar-title"));
	}
	
	public WebElement getSelectAllCheckbox() {
		return driver.findElement(By.cssSelector(".column-browser-select-all .mm-checkbox"));
	}
	
	public WebElement getCheckbox(String columnHeading) {
		return driver.findElement(By.xpath("//*[@class='mm-menu--container'] //label[text()='"+columnHeading+"']"));
	}
	
	public WebElement getOption(String optionText) {
		return driver.findElement(By.xpath("//label[text()='"+optionText+"']"));
	}
	
	public List<WebElement> getDataCards() {
		return driver.findElements(By.cssSelector("explore-card-display[card='card']"));
	}
	
	public List<WebElement> getDataCardTitles() {
		return driver.findElements(By.cssSelector("explore-card-display[card=\"card\"] .card-title"));
	}
	
	public List<WebElement> getTableColumnHeaders() {
		return driver.findElements(By.cssSelector(".mm-data-grid-header-cell--header-text"));
	}
	
	public WebElement getTable() {
		return driver.findElement(By.cssSelector(".ag-center-cols-container"));
	}
	
	public List<WebElement> getTableRows() {
		return driver.findElements(By.cssSelector(".ag-center-cols-container [role='row']"));
	}
	
	public WebElement getCellValue(int rowIndex, int columnIndex) {
		return driver.findElement(By.cssSelector(".ag-center-cols-container [role='row']:nth-child("+rowIndex+") [role='gridcell']:nth-child("+columnIndex+")"));
	}
	
	public WebElement getLoadingSpinner() {
		return driver.findElement(By.cssSelector("[class='ng-scope'] [class='spinner']"));
	}
	
	public WebElement getBody() {
		return driver.findElement(By.tagName("body"));
	}
}
