package com.testSteps;

import com.pages.LoginPage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.pages.HistoryViewByStorePage;
import com.pages.HomePage;

import driverFactory.InitDriver;
import utils.Helper;

public class HistoryByStoreTestSteps {
	InitDriver initDriver = new InitDriver();
	Helper helper = new Helper();
	public WebDriver driver = initDriver.getDriver();
	SoftAssert softAssert;
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	HistoryViewByStorePage historyViewByStorePage = new HistoryViewByStorePage(driver);
	List<String> failedMonths = new ArrayList<>();
	
	
	public void fetchGrandTotalForMonth(String month) throws IOException  {
		helper.waitForElementToBeVisible(historyViewByStorePage.getStoresTable());
		try {
			helper.waitForElementToBeDisappear(historyViewByStorePage.getTableLoadingElement());
		} catch (Exception e) {
			e.printStackTrace();
		}
		int rowCount= historyViewByStorePage.getStoresTableRows().size();
		double grandTotal = 0.00;
		int columnCount = historyViewByStorePage.getTableHeaders().size();
		int requiredColumn=0;
		double grandTotalOnUi = 0;
		for (int j=2;j<columnCount-1;j++) {
			if(historyViewByStorePage.getTableHeaders().get(j-1).getText().equals(month)) {
				requiredColumn=j;
			}
		}
		for(int i=1;i<rowCount-1;i++) {
			String cellText = historyViewByStorePage.getStoresTableCellValue(i, requiredColumn).getText();
			String storeName =historyViewByStorePage.getStoresTableCellValue(i, 1).getText();
			double yearAmount=Double.parseDouble(cellText.replace("$", "").toString()); 
			System.out.println("Amount of store "+storeName+" for month "+month+" is: "+yearAmount);
			grandTotal= grandTotal+yearAmount;
			grandTotalOnUi = Double.parseDouble(historyViewByStorePage.getStoresTableCellValue(rowCount, requiredColumn).getText().replaceAll("[$,]", "").toString());
		}
		System.out.println("Grand total is: "+grandTotal);
		System.out.println("Grand total on UI is: "+grandTotalOnUi);
		
			if(!(Math.abs(grandTotalOnUi-grandTotal)==0.00)) {
				System.out.println("\u001B[31m***********************Testcase is failed for "+month+"***********************\u001B[0m");
				failedMonths.add(month);
			}
			else {
				System.out.println("\u001B[32m***********************Testcase is Passed for "+month+"***********************\u001B[0m");
			}
			String fileWithPath= "./testResults/"+month+".png";
			TakesScreenshot scrShot =((TakesScreenshot)driver);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File(fileWithPath);
		    FileUtils.copyFile(SrcFile, DestFile);
			softAssert = new SoftAssert();
			softAssert.assertEquals(grandTotalOnUi, grandTotal, 0.001, "\u001B[31mAssertion Error on\u001B[0m "+ failedMonths);
	}
	
		public void assertAllMonths() {
			softAssert.assertAll();
		}
}