package com.sbms.test.stepdefs;

import com.sbms.test.TestApplication;
import com.sbms.test.model.Message;
import com.sbms.test.pages.HomePage;
import cucumber.api.DataTable;
import cucumber.api.java8.En;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestApplication.class)
@SpringBootTest
public class AssertionSteps implements En {
    public AssertionSteps() {
        Then("^I will see a personalized message that says \"([^\"]*)\"$", (String personalizedMessage) -> {
            HomePage page = new HomePage();
            assertThat(page.getPersonalizedMessage()).isEqualTo(personalizedMessage);
        });

        Then("^I will see a table of messages containing exactly these messages in this order:$", (DataTable messages) -> {
            List<Message> expectedMessages = messages
                    .asLists(String.class)
                    .stream()
                    .map(cells -> new Message(cells.get(0), cells.get(1)))
                    .collect(Collectors.toList());
            HomePage page = new HomePage();
            assertThat(page.getMessages()).containsExactlyElementsOf(expectedMessages);
        });
    }
}
