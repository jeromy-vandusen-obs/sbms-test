package com.sbms.test.stepdefs;

import com.sbms.test.TestApplication;
import cucumber.api.java8.En;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestApplication.class)
@SpringBootTest
public class ActionSteps implements En {
    public ActionSteps() {
        When("^I navigate to the home page$", () -> {
            // TODO
        });
    }
}
