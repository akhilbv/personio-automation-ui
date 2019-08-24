package com.personio.runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/features"},
        glue = {"com.personio"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:test-results/cucumber-reports/report.html",
                "pretty",
                "html:test-results/cucumber-reports/cucumber-pretty",
                "json:test-results/cucumber-reports/CucumberTestReport.json",
                "rerun:test-results/cucumber-reports/rerun.txt"}
)
public class TestRunner {
}
