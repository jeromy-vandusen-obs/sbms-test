package com.sbms.test.stepdefs;

import com.sbms.test.TestApplication;
import cucumber.api.DataTable;
import cucumber.api.java8.En;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestApplication.class)
@SpringBootTest
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
