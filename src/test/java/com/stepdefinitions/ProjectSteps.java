package com.stepdefinitions;

import com.testSteps.ProjectTestSteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProjectSteps {
	ProjectTestSteps projectTestSteps = new ProjectTestSteps();
	
	@Then("user verifies heading of the page as {string}")
	public void user_verifies_heading_of_the_page_as(String fileName) throws InterruptedException {
		projectTestSteps.verifyHeading(fileName);
	}
	
	@When("user clicks on select all checkbox")
	public void user_clicks_on_select_all_checkbox() {
		projectTestSteps.clickOnSelectAllCheckbox();
	}
	
	@When("user clicks on {string} checkbox")
	public void user_clicks_on_checkbox(String columnHeading) {
		projectTestSteps.clickCheckbox(columnHeading);
	}

	@When("user clicks on {string} option")
	public void user_clicks_on_option(String optionText) throws InterruptedException {
		projectTestSteps.clickOnOption(optionText);
	}

	@Then("user verifies the data titles from data cards")
	public void user_verifies_the_data_titles_from_data_cards() {
		projectTestSteps.verifyCardTitles();
	}
	
	@Then("user verifies data from the data cards")
	public void user_verifies_data_from_the_data_cards() {
		projectTestSteps.verifyDataOfCards();
	}
	
	@When("user closes the {string} tab")
	public void user_closes_the_tab(String string) {
		projectTestSteps.closeFileTab();
	}
	
	@When("user fetches top {int} {string} who sold maximum quantities of items")
	public void user_fetches_top_who_sold_maximum_quantities_of_items(int numbers, String columnHeading) throws InterruptedException {
		projectTestSteps.checkTopEntries(numbers, columnHeading);
	}
}
