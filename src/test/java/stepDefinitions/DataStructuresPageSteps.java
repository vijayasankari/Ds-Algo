package stepDefinitions;

import org.testng.Assert;

import Hooks.Hooks;
import PageObjects.DataStructuresPage;
import PageObjects.LaunchPage;
import PageObjects.LoginPage;
import PageObjects.PageObjectManager;
import PageObjects.TryEditorPage;
import PageObjects.homePO;
import Utilities.configReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataStructuresPageSteps {

	private PageObjectManager pageObjectManager;
	private homePO homePage;
	private LaunchPage launchPage;
	private LoginPage login;
	private DataStructuresPage dataStructuresPage;
	private TryEditorPage tryEditor;

	public DataStructuresPageSteps() {
		pageObjectManager = new PageObjectManager(Hooks.driver);
		homePage = pageObjectManager.getHomePage();
		launchPage = pageObjectManager.getLaunchPage();
		login = pageObjectManager.getLoginPage();
		dataStructuresPage = pageObjectManager.getDataStructuresPage();
		tryEditor = pageObjectManager.getTryHereEditorPage();
	}

	@Given("User logged into DsAlgo portal")
	public void user_logged_into_ds_algo_portal() {
		launchPage.GetStartedClick();
		homePage.clickSignInLink();
		login.fetchLoginCredentialsAndLogin(configReader.filepath, configReader.SheetName);
	}

	@Given("clicks {string} Get Started button")
	public void clicks_get_started_button(String moduleName) {
		homePage.clickGetStarted(moduleName);
	}

	@When("The user clicks Time Complexity hyperlink")
	public void the_user_clicks_time_complexity_hyperlink() {
		dataStructuresPage.clickTimeComplexityLink();
	}

	@Then("The user should be redirected to Time Complexity page of Data structures-Introduction")
	public void the_user_should_be_redirected_to_time_complexity_page_of_data_structures_introduction() {
		Assert.assertEquals(dataStructuresPage.getTitleCurrentPage().trim(), "Time Complexity",
				"User is not redirected to Time Complexity page");
	}
	
	@When("clicks the Practice Questions hyperlink")
	public void clicks_the_practice_questions_hyperlink() {
		dataStructuresPage.clickPracticeQuestionsLink();
	}

	@Then("The user should be redirected to Practice Questions page of Data structures-Introduction")
	public void the_user_should_be_redirected_to_practice_questions_page_of_data_structures_introduction() {
		Assert.assertEquals(dataStructuresPage.getTitleCurrentPage().trim(), "Practice Questions",
				"User is not redirected to Practice Questions page");
	}
	
	@When("the user navigates to Time Complexity page")
	public void the_user_navigates_to_time_complexity_page() {
		dataStructuresPage.clickTimeComplexityLink();
	}
	
	@When("clicks on Try Here link")
	public void clicks_on_try_here_link() {
		dataStructuresPage.clickTryHereButton();
	}

	@Then("The user should be redirected to a page having an try Editor with a Run button to test")
	public void the_user_should_be_redirected_to_a_page_having_an_try_editor_with_a_run_button_to_test() {
		Assert.assertEquals(dataStructuresPage.getTitleCurrentPage().trim(), "Assessment",
				"User is not redirected to Try here Editor page");
	}
	
	@When("user clicks on Try here link")
	public void user_clicks_on_try_here_link() {
		dataStructuresPage.clickTryHereButton();
	}

	@When("User enters {string} in try editor from excel sheet")
	public void user_enters_in_try_editor_from_excel_sheet(String codeType) {
		configReader.SheetName = "TryEditor";
		tryEditor.fetchCodeAndRun(codeType, configReader.filepath, configReader.SheetName);
	}

	@Then("The user should able to see the {string}")
	public void the_user_should_able_to_see_the(String expectedResult) throws InterruptedException {
		String result = tryEditor.fetchResult(expectedResult);
		System.out.println(result);
	}

	@When("The user selects {string} from the Data Structures dropdown of Data Structures Introduction page")
	public void the_user_selects_from_the_data_structures_dropdown_of_data_structures_introduction_page(
			String dropdownSelection) {
		dataStructuresPage.clickDataStructuresDropdown();
		dataStructuresPage.selectDropdownValue(dropdownSelection);
	}

	@Then("The user should be able to navigate to respective {string} page")
	public void the_user_should_be_able_to_navigate_to_respective_page(String module) {
		Assert.assertEquals(dataStructuresPage.getTitleCurrentPage().trim(), module,
				"User is not redirected to " + module + " page");
	}

	@When("The user clicks on username hyperlink displayed at the top right corner")
	public void the_user_clicks_on_username_hyperlink_displayed_at_the_top_right_corner() {
		dataStructuresPage.clickUsernameLink();
	}

	@Then("The user should be able to see that the current page is reloaded")
	public void the_user_should_be_able_to_see_that_the_current_page_is_reloaded() {
		Assert.assertEquals(dataStructuresPage.getTitleCurrentPage().trim(), "Data Structures-Introduction",
				"Page is not reloaded correctly");
	}

}
