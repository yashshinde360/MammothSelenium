package com.stepdefinitions;

import com.testSteps.HomeTestSteps;
import com.testSteps.LoginTestSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps {
	LoginTestSteps loginTestSteps = new LoginTestSteps();
	HomeTestSteps homeTestSteps = new HomeTestSteps();
	
	@Given("user is on Mammoth screen")
	public void user_is_on_mammoth_screen() {
		loginTestSteps.verifyProfileIcon();
	}

	@When("user clicks on Plus icon to creating new project")
	public void user_clicks_on_Plus_icon_to_creating_new_project() {
		homeTestSteps.clickOnPlusIconForCreatingProject();
	}

	@When("user enters project name as {string}")
	public void user_enters_project_name_as(String projectName) {
		homeTestSteps.enterProjectName(projectName);
	}

	@When("user clicks on Create Project button on Modal")
	public void user_clicks_on_create_project_button_on_modal() {
		homeTestSteps.clickOnCreateProjectOnModal();
	}

	@Then("user verifies {string} is showing under Projects section")
	public void user_verifies_is_showing_under_projects_section(String projectName) {
		homeTestSteps.verifyProjectCreated(projectName);
		
	}

	@When("user clicks on Fetch from URL link")
	public void user_clicks_on_fetch_from_url_link() {
		homeTestSteps.clickOnFetchFromURL();
	}

	@When("user enters URL as {string}")
	public void user_enters_url_as(String fileUrl) {
		homeTestSteps.enterIntoURLField(fileUrl);
	}

	@When("user clicks on {string} button")
	public void user_clicks_on_button(String buttonText) {
		homeTestSteps.clickOnButton(buttonText);
	}
	
	@When("user clicks on OPEN button")
	public void user_clicks_on_open_button() {
		homeTestSteps.clickOnOpenButton();
	}
	
	@Then("user verifies {string} is showing in project")
	public void user_verifies_is_showing_in_project(String fileName) {
		homeTestSteps.verifyFileInProject(fileName);
	}
	
	@When("user clicks on {string} from the project")
	public void user_clicks_on_from_the_project(String fileName) {
		homeTestSteps.cickOnFileInProject(fileName);
	}
	
	@When("user deletes all projects")
	public void user_deletes_all_projects() throws InterruptedException {
		homeTestSteps.deleteAllProjects();
	}

	@Then("user verifies {string} is deleted from the projects section")
	public void user_verifies_is_deleted_from_the_projects_section(String projectName) {
		homeTestSteps.verifyProjectDeleted(projectName);
	}
	
	@When("user clicks on My Desktop link")
	public void user_clicks_on_my_desktop_link() {
		homeTestSteps.clickOnMyDesktopLink();
	}

	@When("user upload file {string}")
	public void user_upload_file(String fileName) {
		homeTestSteps.uploadFile(fileName);
	}
}
