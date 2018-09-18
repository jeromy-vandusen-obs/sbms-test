package com.sbms.test.stepdefs;

import cucumber.api.DataTable;
import cucumber.api.java8.En;

public class ArrangementSteps implements En {
    public ArrangementSteps() {
        Given("^the messages collection contains a message for the language \"([^\"]*)\" that says \"([^\"]*)\"$", (String language, String content) -> {
            // TODO
        });

        Given("^my browser's locale is set to \"([^\"]*)\"$", (String language) -> {
            // TODO
        });

        Given("^the messages collection contains exactly these messages:$", (DataTable messages) -> {
            // TODO
        });
    }
}
