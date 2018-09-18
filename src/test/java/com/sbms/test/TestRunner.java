package com.sbms.test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.sbms.test.stepdefs"},
        tags = {"~@Ignore"},
        format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        }
)
public class TestRunner {
    private TestNGCucumberRunner cucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        cucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeatureWrapper) {
        cucumberRunner.runCucumber(cucumberFeatureWrapper.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return cucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        cucumberRunner.finish();
    }
}
