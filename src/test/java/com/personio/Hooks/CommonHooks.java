package com.personio.Hooks;

import com.cucumber.listener.Reporter;
import com.personio.automation.ui.context.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;
import java.util.logging.Logger;

public class CommonHooks {
    private static final Logger LOGGER = Logger.getLogger("automation");

    @Before
    public void beforeScenario(Scenario scenarioContext) {
        LOGGER.info("Started execution of " + scenarioContext.getName());
    }

    @After
    public void afterScenario(Scenario scenarioContext) throws IOException {
        LOGGER.info("Execution Finished for scenario: " + scenarioContext.getName() + " execution status :" + scenarioContext.getStatus());
        if (scenarioContext.isFailed()) {
            TestContext.browser.takeScreenShot("test-results/cucumber-reports/screenshots/" + scenarioContext.getName() + ".png");
            Reporter.addScreenCaptureFromPath("screenshots/" + scenarioContext.getName() + ".png");
        }
        TestContext.testTearDown();
    }
}
