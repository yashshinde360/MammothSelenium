package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransactionsPage {
	WebDriver driver;
	public TransactionsPage(WebDriver driver) {
		this.driver= driver;	
	}
	
	public WebElement getFilter(String filterType) {
		return driver.findElement(By.xpath("//span[text()='"+filterType+"']"));
	}
	
	public WebElement getClearButton() {
		return driver.findElement(By.xpath("//button[text()='Clear']"));
	}
	
	public WebElement getFilterOption(String filterOption) {
		return driver.findElement(By.xpath("//p[text()='"+filterOption+"']"));
	}
	
	public WebElement getApplyButton() {
		return driver.findElement(By.xpath("//button[contains(text(),'Apply')]"));
	}
	
	public WebElement getTransactionTable() {
		return driver.findElement(By.xpath("//*[@id='view-table-id']/div/table"));
	}
	
	public List<WebElement> getTransactionsTableRows() {
		return driver.findElements(By.cssSelector("[id='view-table-id'] table tbody tr"));
	}
	
	public WebElement getTransactionsTableCellValue(int row, int column) {
		return driver.findElement(By.cssSelector("[id='view-table-id'] table tbody tr:nth-child("+row+") td:nth-child("+column+")"));
	}
	
	public List<WebElement> getColumnsofRow(int row) {
		return driver.findElements(By.cssSelector("[id='view-table-id'] table tbody tr:nth-child("+row+") td"));
	}
	
	public WebElement getNextResultsButton() {
		return driver.findElement(By.cssSelector("[data-testid=\"pagination-next\"]"));
	}
	
	public WebElement getDownloadButton() {
		return driver.findElement(By.xpath("//button[text()='Download']"));
	}
	
	public WebElement getDownloadingMessage() {
		return driver.findElement(By.xpath("//p[text()='Downloading']"));
	}
	
	public WebElement getDownloadCompletedMessage() {
		return driver.findElement(By.xpath("//div[text()='Download Completed']"));
	}
	
}
