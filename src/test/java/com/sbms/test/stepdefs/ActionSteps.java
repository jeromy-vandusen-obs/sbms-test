package com.sbms.test.stepdefs;

import com.sbms.test.TestApplication;
import com.sbms.test.pages.HomePage;
import com.sbms.test.utils.DriverFactory;
import cucumber.api.java8.En;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestApplication.class)
@SpringBootTest
public class ActionSteps implements En {
    public ActionSteps(@Value("${uri.base}") String uriBase) {
        When("^I navigate to the home page$", () -> {
            HomePage.navigate(uriBase);
            DriverFactory.getInstance().getDriver().navigate().to("http://localhost:8080/");
        });
    }
}
