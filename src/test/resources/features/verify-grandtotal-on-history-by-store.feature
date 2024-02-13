Feature: To test Grand total functionality on Loop
 		As user
		I want to navigate to History by store page
		So that I can verify Grand total functionality

Scenario: Login to Loop
	Given user is on loop login screen 
	When user enters username as "qa-engineer-assignment@test.com"
	And user enters password as "QApassword123$"
	And user clicks on Login button
	Then user verifies Welcome back message on the homescreen
	
Scenario: Verify Grand total functionality
	Given user is on loop home screen 
	When user clicks on "3P Chargebacks" Hamberger manu and selects "History by Store"
	Then user fetches the amount from the table for months
	| Aug 2023 |
	| Sep 2023 |
	| Oct 2023 |
	| Nov 2023 |
	| Dec 2023 |
	| Jan 2024 |
	| Feb 2024 |
	And user verifies the Grand total for all months
	