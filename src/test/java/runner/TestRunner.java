package runner;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

	@CucumberOptions(
			plugin = {"pretty","html:target/DsAlgoTryCatchers.html"},//reporting purpose
			monochrome = false,//console output color
			tags = "@RegisterPageValidation",//tags from feature file
			features = {"src/test/resources/features"},//location of feature files
			glue = {"stepDefinitions", "Hooks"} //location to step definition files
			)
	public class TestRunner extends AbstractTestNGCucumberTests {
		
		@Override
	    @DataProvider(parallel = false)
	    public Object[][] scenarios() {
					
			return super.scenarios();
	    }
	    }
		
	

