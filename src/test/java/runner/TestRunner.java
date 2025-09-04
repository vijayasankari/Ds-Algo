package runner;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import Utilities.configReader;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

	@CucumberOptions(
			plugin = {"pretty","html:target/DsAlgoTryCatchers.html"},//reporting purpose
			monochrome = false,//console output color
			tags = "@StackTopics-TryEditor-ValidCodeValidation",//tags from feature file
			features = {"src/test/resources/features"},//location of feature files
			glue = {"stepDefinitions", "Hooks"} //location to step definition files
			)
	public class TestRunner extends AbstractTestNGCucumberTests {
		
		@BeforeTest
		@Parameters({"Browser"})
		public void defineBrowser(String browser) throws Throwable {
			configReader.setBrowserType(browser);
			System.out.println(browser);
		}
		
		@Override
	    @DataProvider(parallel = false)
	    public Object[][] scenarios() {
					
			return super.scenarios();
	    }
	    }
		
	

