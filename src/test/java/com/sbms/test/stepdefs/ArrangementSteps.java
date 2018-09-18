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
