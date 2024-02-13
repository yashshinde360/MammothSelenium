package com.stepdefinitions;

import java.io.IOException;
import java.util.List;

import com.testSteps.HistoryByStoreTestSteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class HistoryByStoreSteps {
	HistoryByStoreTestSteps historyByStoreTestSteps= new HistoryByStoreTestSteps();
	
	@Then("user fetches the amount from the table for months")
	public void user_fetches_the_amount_from_the_table_for_months(DataTable datatable) throws IOException {
		List<String> rows = datatable.asList();
	    for (String month : rows) {
		historyByStoreTestSteps.fetchGrandTotalForMonth(month);
	    }
	}
	
	@Then("user verifies the Grand total for all months")
			public void user_verifies_the_Grand_total_for_all_months() {
		historyByStoreTestSteps.assertAllMonths();
	}
}
