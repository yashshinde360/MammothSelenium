package com.stepdefinitions;

import com.testSteps.LoginTestSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	LoginTestSteps loginTestSteps = new LoginTestSteps();
	
	@Given("user is on Mammoth login screen")
	public void user_is_on_mammoth_login_screen() {
		loginTestSteps.navigateToMammoth();
	}

	@When("user enters username as {string}")
	public void user_enters_username_as(String userName) {
		loginTestSteps.enterUserName(userName);
	}

	@When("user enters password as {string}")
	public void user_enters_password_as(String password) {
		System.out.println(password);
		loginTestSteps.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginTestSteps.clickOnLoginButton();
	}

	@Then("user verifies Profile icon on the homescreen")
	public void user_verifies_Profile_icon_on_the_homescreen() {
		loginTestSteps.verifyProfileIcon();
	}
}
