package runner;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)//Junit execution
	@CucumberOptions(
			plugin = {"pretty","html:target/DsAlgoTryCatchers.html"},//reporting purpose
			monochrome = false,//console output color
			tags = "@HomePageValidation",//tags from feature file
			features = {"src/test/resources/features"},//location of feature files
			glue = {"Step_Definitions", "Hooks"} //location to step definition files
			)
	public class TestRunner extends AbstractTestNGCucumberTests {
		
		@Override
	    @DataProvider(parallel = false)
	    public Object[][] scenarios() {
					
			return super.scenarios();
	    }
	    }
		
	

