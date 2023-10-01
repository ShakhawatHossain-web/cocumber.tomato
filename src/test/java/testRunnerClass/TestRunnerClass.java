package testRunnerClass;

import org.junit.runner.RunWith; 
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
	//this is feature file path
	features = ".//FeatureFile/LogingFeature.feature/", 
	glue = "stepDefination",
		
	//checking the compatibility
	dryRun = false,
	
	//output readable
	monochrome = true,
	tags="@sanity",

	plugin = {"pretty", "html:target/Cucumber-Report/reports_html.html"}
		)
public class TestRunnerClass {
}