package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
//@CucumberOptions(features = {".//features"},glue="stepDefinitions") //.feature means it will execute all the files which are inside the folder
@CucumberOptions(
		// features= {".//Features/"},
		//features= {".//Features/FirstLogin.feature"},
	// features = { ".//Features/DataTable_Login.feature" },
		features = { ".//Features/LoginDDTExcel.feature" },

		//features= {"@target/rerun.txt"}, //it work like retryAnnalyser like how we
		// have
		// implemented in hybrid framework
		glue = { "stepDefinitions", "hooks" }, 
		plugin = { "pretty", "html:reports/myreport.html",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		// "rerun:target/rerun.txt",

		},

		dryRun = false, // checks mapping between scenario steps and step definition methods
		monochrome = true, // to avoid junk characters in output
		publish = true, // to publish report in cucumber server

//tags="@sanity" // this will execute scenarios tagged with @sanity
//tags = "@RegressionTesting"
tags = "@FunctionalTesting"
//tags="@sanity and @regression" //Scenarios tagged with both @sanity and
// @regression
// tags="@sanity and not @regression" //Scenarios tagged with @sanity but not
// tagged with @regression: it will execute only with @sanity
// tags="@sanity or @regression" //Scenarios tagged with either @sanity or
// @regression) //it will run only one feature file i.e login.featurefile
)
public class TestRun {

}
