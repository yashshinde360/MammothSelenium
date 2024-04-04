Feature: [External] To test Fetch from URL functionality of Mammoth 
		As an user
		I want to create dataset using Fetch URL option
		So that I can verify Fetch from URL functionality of Mammoth 
		And verify titles and data of datacards and datasets

Scenario: Login to Mammoth
	Given user is on Mammoth login screen 
	When user enters username as "yashshinde360@gmail.com"
	And user enters password as "Test4_Mammoth$"
	And user clicks on Login button
	Then user verifies Profile icon on the homescreen
	
Scenario: User create project with name "Fetch URL File"
	Given user is on Mammoth screen 	
	When user clicks on Plus icon to creating new project
	And user enters project name as "Fetch URL File"
	And user clicks on Create Project button on Modal
	Then user verifies "Fetch URL File" is showing under Projects section
	
Scenario: User creates dataset using Fetch URL option
	Given user is on Mammoth screen 	
	When user clicks on Fetch from URL link
	And user enters URL as "https://support.staffbase.com/hc/en-us/article_attachments/360009197031/username.csv"
	And user clicks on "Submit" button
	Then user verifies "username.csv" is showing in project
	
Scenario: User opens the file and verifies tab heading
	Given user is on Mammoth screen
	When user clicks on "username.csv" from the project
	And user clicks on OPEN button
	Then user verifies heading of the page as "username.csv"
	
Scenario: User verifies titles and data of datacards and datasets
	Given user is on Mammoth screen
	When user clicks on "Column Browser" button
	And user clicks on select all checkbox
	And user clicks on "Open in Explore Columns" option 
	Then user verifies the data titles from data cards
	And user verifies data from the data cards
	
Scenario: User deletes all existing projects and Verify Delete functionality
	Given user is on Mammoth screen
	When user closes the "username.csv" tab
	And user deletes all projects
	Then user verifies "Fetch URL File" is deleted from the projects section
	
	
	
	
	
	
	
	