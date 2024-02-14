Feature: To test Transactions table and CSV created from UI
 		As user
		I want to navigate to Transactions page
		So that I can verify Transactions table and CSS created from UI
		
Scenario: Login to Loop
	Given user is on loop login screen 
	When user enters username as "qa-engineer-assignment@test.com"
	And user enters password as "QApassword123$"
	And user clicks on Login button
	Then user verifies Welcome back message on the homescreen

Scenario: Verify Transactions table and CSV created from UI
	Given user is on loop home screen 
	When user clicks on "3P Chargebacks" Hamberger manu and selects "Transactions"
	And user clicks on "Locations" filter
	And user clicks on clear button of the filter
	And user applies filter as "Artisan Alchemy,Blissful Buffet"
	And user clicks on Apply selected button
	And user clicks on "Marketplaces" filter
	And user clicks on clear button of the filter
	And user applies filter as "Grubhub"
	And user clicks on Apply selected button
 	Then user writes the csv file
 
Scenario: Verify Transactions page CSV Download functionality
	Given user is on Transactions screen 
	When user clicks on Download button
	Then user verifies "chargebacks_payouts_overview.csv" file is downloaded
	
	