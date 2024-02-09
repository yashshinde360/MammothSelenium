Feature: To test Loop

Scenario: Login to Loop
	Given user is on loop login screen 
	When user enters username as "qa-engineer-assignment@test.com"
	And user enters password as "QApassword123$"
	And user clicks on Login button
	Then user verifies the homescreen
	