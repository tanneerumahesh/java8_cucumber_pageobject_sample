package ebay.qa.test.stepdefs;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
plugin={"pretty","html:format"},
features = {"features/"},
glue = {"ebay.qa.test.stepdefs"},
tags = {}
)

public class TestRunner {
	
}
