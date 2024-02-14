# Loop

Selenium+BDD Framework for UI automation of LOOP 

*************************************************************************************************************************************************

Testcases:
Scenario 1 : Verify Verify Grand total functionality on History by Store page
	Feature file loaction: \Loop\src\test\resources\features\verify-grandtotal-on-history-by-store.feature
	Cucumber report: https://reports.cucumber.io/reports/53be3b45-79a2-415b-a9ee-16793e85359d

	Fetched the values from History by Store page table and printed on terminal
	Asserted 2 totals(One which is coming from calculation and one which is showing on UI) and printed the results from each month

Testcase will pass if assertions for each month gets passed
Testcase will fail if any of the assertion gets failed, and will get message in terminal showing the months for which assertion failed

*************************************************************************************************************************************************

Scenario 2 : Verify Transactions table and CSS created from Transaction page
	Feature file location: \Loop\src\test\resources\features\verify-transactions-table-and-csv.feature
	Cucumber report: https://reports.cucumber.io/reports/8e454d56-0d73-4f93-a766-7430b6846ff4

	Fetched the data from Transactions page and printed on terminal as well as in CSV(CSV will get generated under testResults folder)(Shared the CSV generated in last run at "\Loop\AutomatedTest_Videos_and_Files\CSV_From_UI.csv")
	Downloaded the CSV from UI and verified the CSV(Shared the CSV downloaded from UI at "Loop\AutomatedTest_Videos_and_Files\chargebacks_payouts_overview.csv")

Testcase will pass if CSV is generated properly and CSV is downloaded properly
Testcase will fail if CSV is not generated properly and CSV is not getting downloaded properly

Bonus task is coverted under this Scenario 

*************************************************************************************************************************************************
	




	