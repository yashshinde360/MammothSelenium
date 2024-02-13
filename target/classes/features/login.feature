Feature: To test Loop

Scenario: Login to Loop
	Given user is on loop login screen 
	When user enters username as "qa-engineer-assignment@test.com"
	And user enters password as "QApassword123$"
	And user clicks on Login button
	Then user verifies Welcome back message on the homescreen
	
Scenario: Login to Loop
	Given user is on loop home screen 
	When user clicks on "3P Chargebacks" Hamberger manu and selects "History by Store"
	Then user verifies the Grand total for month "Aug 2023"
	And user verifies the Grand total for month "Sep 2023"
	And user verifies the Grand total for month "Oct 2023"
	And user verifies the Grand total for month "Nov 2023"
	And user verifies the Grand total for month "Dec 2023"
	And user verifies the Grand total for month "Jan 2024"
	And user verifies the Grand total for month "Feb 2024"
	