package com.sbms.test.stepdefs;

import cucumber.api.DataTable;
import cucumber.api.java8.En;

public class AssertionSteps implements En {
    public AssertionSteps() {
        Then("^I will see a personalized message that says \"([^\"]*)\"$", (String content) -> {
            // TODO
        });

        Then("^I will see a table of messages containing exactly these messages in this order:$", (DataTable messages) -> {
            // TODO
        });
    }
}
