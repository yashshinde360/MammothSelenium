package com.testSteps;

import utils.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.pages.ProjectPage;

import driverFactory.InitDriver;

public class ProjectTestSteps {
	WebDriver driver = InitDriver.getDriver();
	Helper helper = new Helper();
	ProjectPage projectPage = new ProjectPage(driver);
	
	public void verifyHeading(String fileName) throws InterruptedException {
		helper.switchToTab(1);
		helper.waitForElementToLoad();
		Thread.sleep(5000);
		Assert.assertTrue(projectPage.getPageHeading().getText().contains(fileName));
	}
	
	public void clickOnSelectAllCheckbox() {
		helper.waitForElementToLoad();
		projectPage.getSelectAllCheckbox().click();
	}
	
	public void clickCheckbox(String columnHeading) {
		helper.waitForElementToLoad();
		projectPage.getCheckbox(columnHeading).click();
	}
	
	public void clickOnOption(String optionText) throws InterruptedException {
		helper.waitForElementToLoad();
		projectPage.getOption(optionText).click();
		Thread.sleep(5000);
	}
	
	public void verifyCardTitles() {
		helper.waitForElementToLoad();
		List<WebElement> dataCardTitles = projectPage.getDataCardTitles();
		List<WebElement> columnHeaders = projectPage.getTableColumnHeaders();
		String[] columnHeadersArray= new String[columnHeaders.size()];
		for(int i=0;i<columnHeaders.size();i++) {
			columnHeadersArray[i] = columnHeaders.get(i).getText();
		}
		System.out.println(Arrays.toString(columnHeadersArray));
		for(WebElement dataCardTitle: dataCardTitles) {
			System.out.println(dataCardTitle.getText());
			Assert.assertTrue(Arrays.toString(columnHeadersArray).contains(dataCardTitle.getText()));
		}
	}
	
	public void verifyDataOfCards() {
		helper.waitForElementToLoad();
		List<WebElement> columnHeaders = projectPage.getTableColumnHeaders();
		List<WebElement> dataCardTitles = projectPage.getDataCardTitles();
		List<WebElement> dataCards = projectPage.getDataCards();
		List<WebElement> tableRows = projectPage.getTableRows();
		for(int i=0; i<columnHeaders.size();i++) { //table
			for(int j=0;j<dataCardTitles.size();j++) {  //card
				if(columnHeaders.get(i).getText().equals(dataCardTitles.get(j).getText())) {
					for(int p=0;p<tableRows.size();p++) { //row
						String tableCellValue = projectPage.getCellValue(p+1,i+1).getText();
						if(tableCellValue.matches("[0-9]+")) {
							break;
						}
						Assert.assertTrue(dataCards.get(i).getText().contains(tableCellValue));
					}
					break;
				}
			}
		}
	}
	
	public void closeFileTab() {
		helper.closeTab(1);
		helper.switchToTab(0);
	}
	
	public void checkTopEntries(int numbers, String columnHeading) throws InterruptedException {
		helper.waitForElementToLoad();
		List<WebElement> dataCardTitles = projectPage.getDataCardTitles();
		List<WebElement> dataCards = projectPage.getDataCards();
		List<String> dataCardElements = new ArrayList<String>();
		for(int i=0;i<dataCardTitles.size();i++) { 
			if(dataCardTitles.get(i).getText().equals(columnHeading)) {
				List<WebElement> dataElement =dataCards.get(i).findElements(By.cssSelector("explore-card-display[card='card'] .value"));
				System.out.println("rowwwww"+dataElement.size());
				for(int j=0;j<dataElement.size();j++) {
				System.out.println(dataElement.get(j).getText());
				dataCardElements.add(dataElement.get(j).getText());
				}
			}
		}
		System.out.print("!!!!!!!!!!!!!!!!!!!!Top "+numbers+" Cashiers are: ");
		for(int p=0; p<numbers;p++) {
			System.out.print(dataCardElements.get(p)+", ");
		}
		System.out.print("!!!!!!!!!!!!!!!!!!!!");
		System.out.println();
		
		
	}
}
