package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import Hooks.Hooks;
import PageObjects.PageObjectManager;
import Utilities.LoggerReader;
import Utilities.excelReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataStructuresPageSteps {

	private PageObjectManager pageObjectManager;
	private String pythonCodeType;

	public DataStructuresPageSteps() {
		pageObjectManager = new PageObjectManager(Hooks.driver);
	}

	@Given("User logged into application")
	public void user_logged_into_application() {
		LoggerReader.info("User is in Home page");
	}

	@When("clicks {string} Get Started button")
	public void clicks_get_started_button(String moduleName) {
		pageObjectManager.getHomePage().clickGetStarted(moduleName);
	}

	@Then("The user should see below topics under Topics Covered section of Data Structures - Introduction page")
	public void the_user_should_see_below_topics_under_topics_covered_section_of_data_structures_introduction_page(
			DataTable topicsPresent) {
		List<String> expectedTopics = topicsPresent.asList(String.class);
		List<String> actualTopics = pageObjectManager.getDataStructuresPage().topicsPresent();
		for (int i = 0; i < expectedTopics.size(); i++) {
			String actualTopicName = actualTopics.get(i);
			String expectedTopicName = expectedTopics.get(i);
			Assert.assertEquals(actualTopicName, expectedTopicName, "Mismatch at index " + "i");
		}
	}

	@Then("Topics present in the page should be in link format")
	public void topics_present_in_the_page_should_be_in_link_format() {
		Assert.assertEquals(pageObjectManager.getDataStructuresPage().linkFormatOrNot(), true,
				"Topic is not in link format");
	}

	@When("The user clicks Time Complexity hyperlink")
	public void the_user_clicks_time_complexity_hyperlink() {
		pageObjectManager.getDataStructuresPage().clickTimeComplexityLink();
	}

	@Then("The user should be redirected to Time Complexity page of Data structures-Introduction")
	public void the_user_should_be_redirected_to_time_complexity_page_of_data_structures_introduction() {
		Assert.assertEquals(pageObjectManager.getDataStructuresPage().getTitleCurrentPage().trim(), "Time Complexity",
				"User is not redirected to Time Complexity page");
	}

	@When("clicks the Practice Questions hyperlink")
	public void clicks_the_practice_questions_hyperlink() {
		pageObjectManager.getDataStructuresPage().clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to Practice Questions page of Data structures-Introduction")
	public void the_user_should_be_redirected_to_practice_questions_page_of_data_structures_introduction() {
		Assert.assertEquals(pageObjectManager.getDataStructuresPage().getTitleCurrentPage().trim(),
				"Practice Questions", "User is not redirected to Practice Questions page");
	}

	@When("the user navigates to Time Complexity page")
	public void the_user_navigates_to_time_complexity_page() {
		pageObjectManager.getDataStructuresPage().clickTimeComplexityLink();
	}

	@When("clicks on Try Here link")
	public void clicks_on_try_here_link() {
		pageObjectManager.getDataStructuresPage().clickTryHereButton();
	}

	@Then("The user should be redirected to a page having an try Editor with a Run button to test")
	public void the_user_should_be_redirected_to_a_page_having_an_try_editor_with_a_run_button_to_test() {
		Assert.assertEquals(pageObjectManager.getDataStructuresPage().getTitleCurrentPage().trim(), "Assessment",
				"User is not redirected to Try here Editor page");
		Assert.assertEquals(pageObjectManager.getDataStructuresPage().runButtonDisplay(), true,
				"Run button is not displayed");
	}

	@When("user clicks on Try here link")
	public void user_clicks_on_try_here_link() {
		pageObjectManager.getDataStructuresPage().clickTryHereButton();
	}

	@When("User enters {string} in try editor from excel sheet with scenario {string}")
	public void user_enters_in_try_editor_from_excel_sheet(String codeType, String scenarioName) {
		pageObjectManager.getDataStructuresPage().fetchCodeAndRun(codeType, scenarioName);
		pythonCodeType = codeType;
	}

	@Then("The user should able to see the {string} as mentioned for the scenario {string} in the excel sheet")
	public void the_user_should_able_to_see_the_as_mentioned_for_the_scenario_in_the_excel_sheet(
			String expectedResultType, String scenarioName) {
		String actualResult = pageObjectManager.getDataStructuresPage().fetchResult(expectedResultType);
		String expectedResult = null;
		try {
			List<Map<String, String>> expectedOutput = excelReader.getTestData(scenarioName);
			for (Map<String, String> result : expectedOutput) {
				if (result.get("CodeType").equalsIgnoreCase(pythonCodeType)) {
					expectedResult = result.get("ExpectedOutput");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertEquals(actualResult, expectedResult, "Mismatch in actual and expected result");
	}

	@When("The user selects {string} from the Data Structures dropdown of Data Structures Introduction page")
	public void the_user_selects_from_the_data_structures_dropdown_of_data_structures_introduction_page(
			String dropdownSelection) {
		pageObjectManager.getDataStructuresPage().clickDataStructuresDropdown();
		pageObjectManager.getDataStructuresPage().selectDropdownValue(dropdownSelection);
	}

	@Then("The user should be able to navigate to respective {string} page")
	public void the_user_should_be_able_to_navigate_to_respective_page(String module) {
		Assert.assertEquals(pageObjectManager.getDataStructuresPage().getTitleCurrentPage().trim(), module,
				"User is not redirected to " + module + " page");
	}

	@When("The user clicks on username hyperlink displayed at the top right corner")
	public void the_user_clicks_on_username_hyperlink_displayed_at_the_top_right_corner() {
		pageObjectManager.getDataStructuresPage().clickUsernameLink();
	}

	@Then("The user should be able to see that the current page is reloaded")
	public void the_user_should_be_able_to_see_that_the_current_page_is_reloaded() {
		Assert.assertEquals(pageObjectManager.getDataStructuresPage().getTitleCurrentPage().trim(),
				"Data Structures-Introduction", "Page is not reloaded correctly");
	}

}
