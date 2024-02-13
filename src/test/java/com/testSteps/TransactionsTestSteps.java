package com.testSteps;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.opencsv.CSVWriter;
import com.pages.HistoryViewByStorePage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.TransactionsPage;

import driverFactory.InitDriver;
import utils.Helper;

public class TransactionsTestSteps {
	InitDriver initDriver = new InitDriver();
	Helper helper = new Helper();
	public WebDriver driver = initDriver.getDriver();
	CSVWriter writer;
	
	TransactionsPage transactionsPage = new TransactionsPage(driver);
	HistoryViewByStorePage historyViewByStorePage = new HistoryViewByStorePage(driver);
	
	public void clickOnFilter(String filterType) {
		helper.waitForElementToBeClickable(transactionsPage.getFilter(filterType));
		transactionsPage.getFilter(filterType).click();
	}
	
	public void clearFilters() {
		helper.waitForElementToBeClickable(transactionsPage.getClearButton());
		transactionsPage.getClearButton().click();
	}
	
	public void applyFilters(String filters) {
		String filterArray[]= filters.split(",");
		for (String filter : filterArray) {
		helper.waitForElementToBeClickable(transactionsPage.getFilterOption(filter));
		transactionsPage.getFilterOption(filter).click();
		}
	}
	
	public void clickOnApplyButton() {
		helper.waitForElementToBeClickable(transactionsPage.getApplyButton());
		transactionsPage.getApplyButton().click();
	}
	
	public void initiateCSVFile() throws IOException {
		String csv = "./testResults/CSV_From_UI.csv";
		writer = new CSVWriter(new FileWriter(csv));
	}
	
	public CSVWriter getWriter() {
		return writer;
	}
	
	public void writeCSVHeader() {
		String[] headerRow = {"order_id","b_name", "order_state","transaction_type","lost_sale","net_payout","payout_id","payout_date"};
		writer.writeNext(headerRow, false);
	}
	
	public void fetchDetailsFromTransationsTable() throws IOException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		helper.waitForElementToBeVisible(transactionsPage.getTransactionsTableRows().get(0));
		List<String> set1 = new LinkedList<>();
		set1.add(0,"");
		set1.add(1,"");
		set1.add(2,"");
		set1.add(3,"");
		set1.add(4,"");
		set1.add(5,"");
		set1.add(6,"");
		set1.add(7,"");
		for(int i=1;i<=transactionsPage.getTransactionsTableRows().size();i++) {
			System.out.println("rowwww"+i);
			System.out.println(transactionsPage.getColumnsofRow(i).size());
			for (int j=1; j<= transactionsPage.getColumnsofRow(i).size();j++) {
			System.out.println("column"+j);
			System.out.println("!!!!!!"+transactionsPage.getTransactionsTableCellValue(i, j).getText());
			if(transactionsPage.getColumnsofRow(i).size()==8) {
			for(int k=j;k<=j;k++) {
				System.out.println(set1.size());
				set1.set((k-1), transactionsPage.getTransactionsTableCellValue(i, j).getText());
				System.out.println(set1);
			}
			}
			else {
				for(int k=j;k<=j;k++) {
					System.out.println(set1.size());
					set1.set((k+2), transactionsPage.getTransactionsTableCellValue(i, j).getText());
					System.out.println(set1);
					
				}
			}
			
		} 
			String[] csvRow = {"","","","","","","",""};
			for(int l = 0; l<set1.size();l++) {
				System.out.println(set1.get(l));
				csvRow[l]= set1.get(l).replaceAll("[#,$]","").toString();
			}
			this.getWriter().writeNext(csvRow, false);
		}
		
	}
	
	public void checkForNextPageResults() throws IOException {
		while(transactionsPage.getNextResultsButton().isEnabled()) {
		Actions actions = new Actions(driver);
		actions.moveToElement(transactionsPage.getNextResultsButton());
		actions.perform();
		helper.waitForElementToBeClickable(transactionsPage.getNextResultsButton());
		transactionsPage.getNextResultsButton().click();
		this.fetchDetailsFromTransationsTable();
		}
	}
	
	public void writeCSVFile() throws IOException {
		this.fetchDetailsFromTransationsTable();
		this.checkForNextPageResults();
		this.getWriter().flush();
	}
	
	public void verifyTransactionsHomePage()  {
		String actualUrl = driver.getCurrentUrl();
		Assert.assertTrue(actualUrl.contains("https://app.tryloop.ai/chargebacks/transactions") );
	}
	
	public void clickOnDownloadButton() {
		helper.waitForElementToBeClickable(transactionsPage.getDownloadButton());
		Actions actions = new Actions(driver);
		actions.moveToElement(transactionsPage.getDownloadButton());
		actions.perform();
		transactionsPage.getDownloadButton().click();
	}
	
	public void verifyDownloadedCSV(String fileName) throws InterruptedException {
		helper.waitForElementToBeVisible(transactionsPage.getDownloadingMessage());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		helper.waitForElementToBeDisappear(transactionsPage.getDownloadCompletedMessage());
		String downloadPath = System.getProperty("user.dir")+"\\testResults";
		System.out.println(downloadPath);
	    File downloadedFile = new File(downloadPath+"\\"+fileName);
	    Assert.assertTrue("File not downloaded",downloadedFile.exists());

	}
}
