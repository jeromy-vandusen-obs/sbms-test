package com.sbms.test.stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ServiceHooks {
    @Before
    public void initializeTest() {
        // TODO
    }

    @After
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                // TODO
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
