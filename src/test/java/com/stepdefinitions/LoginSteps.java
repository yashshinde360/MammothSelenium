package com.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.testSteps.LoginTestSteps;

import driverFactory.InitDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	LoginTestSteps loginTestSteps = new LoginTestSteps();
	
	
	@Given("user is on loop login screen")
	public void user_is_on_loop_login_screen() {
		loginTestSteps.navigateToLoop();
	}

	@When("user enters username as {string}")
	public void user_enters_username_as(String username) {
		loginTestSteps.enterUsername(username);
	}

	@When("user enters password as {string}")
	public void user_enters_password_as(String password) {
		loginTestSteps.enterPassword(password);
	    
	}
	
	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
	   loginTestSteps.clickOnLoginButton();
	}

	@Then("user verifies Welcome back message on the homescreen")
	public void user_verifies_the_homescreen() throws InterruptedException {
		loginTestSteps.verifyWelcomeMessage();
	}
	
	@Given("user is on loop home screen")
	public void user_is_on_loop_home_screen() {
		loginTestSteps.verifyLoopHomePage();
	}

	@When("user clicks on {string} Hamberger manu and selects {string}")
	public void user_clicks_on_hamberger_manu_and_selects(String hambergerMenu, String subMenu) {
		loginTestSteps.navigateToSubMenu(hambergerMenu,subMenu);
	}
}
