Feature: To test Fetch from URL functionality of Mammoth 
		As an user
		I want to create dataset using Fetch URL option
		So that I can verify Fetch from URL functionality of Mammoth 
		And verify Top Cashiers of the data

Scenario: Login to Mammoth
	Given user is on Mammoth login screen 
	When user enters username as "yashshinde360@gmail.com"
	And user enters password as "Test4_Mammoth$"
	And user clicks on Login button
	Then user verifies Profile icon on the homescreen
	
Scenario: User create project with name "Fetch URL Mammoth"
	Given user is on Mammoth screen 	
	When user clicks on Plus icon to creating new project
	And user enters project name as "Fetch URL Mammoth"
	And user clicks on Create Project button on Modal
	Then user verifies "Fetch URL Mammoth" is showing under Projects section
	
Scenario: User creates dataset using Fetch URL option
	Given user is on Mammoth screen 	
	When user clicks on Fetch from URL link
	And user enters URL as "https://mammothsamples.s3.amazonaws.com/Store_Transactions.csv"
	And user clicks on "Submit" button
	Then user verifies "Store_Transactions.csv" is showing in project
	
Scenario: User opens the file and verifies tab heading
	Given user is on Mammoth screen
	When user clicks on "Store_Transactions.csv" from the project
	And user clicks on OPEN button
	Then user verifies heading of the page as "Store_Transactions.csv"
	
Scenario: User verifies top Cashiers in the dataset
	Given user is on Mammoth screen
	When user clicks on "Column Browser" button
	And user clicks on "Cashier" checkbox
	And user clicks on "Open in Explore Columns" option
	And user fetches top 3 "Cashier" who sold maximum quantities of items
	
Scenario: User deletes all existing projects and Verify Delete functionality
	Given user is on Mammoth screen
	When user closes the "Store_Transactions.csv" tab
	And user deletes all projects
	Then user verifies "Fetch URL Mammoth" is deleted from the projects section
	
	
	
	
	
	
	
	