package com.stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.testSteps.TransactionsTestSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TransactionSteps {
	TransactionsTestSteps transactionsTestSteps= new TransactionsTestSteps();
	
	@When("user clicks on {string} filter")
	public void user_clicks_on_filter(String filterType) {
		transactionsTestSteps.clickOnFilter(filterType);
	}

	@When("user clicks on clear button of the filter")
	public void user_clicks_on_clear_button_of_the_filter() {
		transactionsTestSteps.clearFilters();
	}

	@When("user applies filter as {string}")
	public void user_applies_filter_as(String filters) {
		transactionsTestSteps.applyFilters(filters);
	}

	@When("user clicks on Apply selected button")
	public void user_clicks_on_apply_selected_button() {
		transactionsTestSteps.clickOnApplyButton();
	}

	@Then("user writes the csv file")
	public void user_writes_the_csv_file() throws IOException {
		transactionsTestSteps.initiateCSVFile();
		transactionsTestSteps.writeCSVHeader();
		transactionsTestSteps.writeCSVFile();	
	}
	
	@Given("user is on Transactions screen")
	public void user_is_on_transactions_screen() {
		transactionsTestSteps.verifyTransactionsHomePage();
	}

	@When("user clicks on Download button")
	public void user_clicks_on_download_button() {
		transactionsTestSteps.clickOnDownloadButton();
	}

	@Then("user verifies {string} file is downloaded")
	public void user_verifies_file_is_downloaded(String fileName) throws InterruptedException {
		transactionsTestSteps.verifyDownloadedCSV(fileName);
	}
}
