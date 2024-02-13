package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HistoryViewByStorePage {
	WebDriver driver;
	public HistoryViewByStorePage(WebDriver driver) {
		this.driver= driver;	
	}
	
	public WebElement getStoresTable() {
		return driver.findElement(By.cssSelector("table.MuiTable-root"));
	}
	
	public WebElement getTableLoadingElement() {
		return driver.findElement(By.cssSelector(".MuiSkeleton-pulse"));
	}
	
	public List<WebElement> getStoresTableRows() {
		return driver.findElements(By.cssSelector("table.MuiTable-root tbody tr"));
	}
	
	public WebElement getStoresTableCellValue(int row, int column) {
		return driver.findElement(By.cssSelector("table.MuiTable-root tbody tr:nth-child("+row+") td:nth-child("+column+")"));
	}
	
	public List<WebElement> getTableHeaders() {
		return driver.findElements(By.cssSelector("table.MuiTable-root thead th"));
	}
	
}
