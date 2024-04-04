# MammothSelenium

Selenium+BDD Framework for UI automation of Mammoth

*************************************************************************************************************************************************
Testcases:
Test 1 - Find out the top 3 cashiers who sold maximum quantities of items
	Feature file loaction: /Mammoth/src/test/resources/features/mammoth-login-add-data-using-mammoth-url.feature
	Cucumber report: https://reports.cucumber.io/reports/65aae7f5-5ac8-481b-8b2a-85ab61d269b5

Test Script steps:
  1. Login to Mammoth
  2. User create project with name "Fetch URL Mammoth"
  3. User creates dataset using Fetch URL option
  4. User opens the file and verifies tab heading
  5. User verifies top Cashiers in the dataset
  6. User deletes all existing projects and Verify Delete functionality

Terminal Screenshot showing top 3 Cashiers:
![image](https://github.com/yashshinde360/MammothSelenium/assets/159560085/21dda437-6625-4c1f-a6e2-021fe7e46f8a)

*************************************************************************************************************************************************

Test 2 : Verify upload from My Desktop functionality of Mammoth 
	Feature file location: /Mammoth/src/test/resources/features/mammoth-login-add-data-using-local-file.feature
	Cucumber report: https://reports.cucumber.io/reports/318ba309-520a-49d0-9539-8db1dd472a8b

Test Script steps:
  1. Login to Mammoth
  2. User create project with name "My Desktop File"
  3. User creates dataset using My Desktop link
  4. User opens the file and verifies tab heading
  5. User verifies titles and data of datacards and datasets
  6. User deletes all existing projects and Verify Delete functionality

*************************************************************************************************************************************************
Steps to execute and see report, screenshots:
1. To execute the feature file: 
    1. Open feature file from location
    2. Right click > Run as > Cucumber feature
2. Cucumber report link will be available in terminal after completion of execution
3. Screenshots taken during/after execution are stored at '/Mammoth/testResults' forder. Screenshots are taken after each scenario(Screenshot name is ammended with PASS or FAIL as per the Scenario execution status).



	
