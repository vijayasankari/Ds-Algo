package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import Hooks.Hooks;
import PageObjects.LaunchPage;
import PageObjects.PageObjectManager;
import PageObjects.homePO;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageBeforeSignInSteps {

	private PageObjectManager pageObjectManager;
	private homePO homePage;
	private LaunchPage launchPage;

	@Before(order = 1) // This @Before runs before each scenario, after Hooks.setUp()
	public void setUpPageObjects() {
		pageObjectManager = new PageObjectManager(Hooks.driver);
		homePage = pageObjectManager.getHomePage();
		launchPage = pageObjectManager.getLaunchPage();
	}

	@Given("User is on the DsAlgo Home page")
	public void user_is_on_the_ds_algo_home_page() {
		launchPage.GetStartedClick();
	}

	@When("The user clicks NumpyNinja label on the homepage")
	public void the_user_clicks_numpy_ninja_label_on_the_homepage() {
		homePage.clickNumpyNinjaLabel();
	}

	@Then("The user should able to see that the page is reloaded")
	public void the_user_should_able_to_see_that_the_page_is_reloaded() {
		Assert.assertEquals(homePage.getTitleCurrentPage().trim(), "NumpyNinja", "Page not reloaded correctly");
	}

	@When("The user clicks Register link on the Home page")
	public void the_user_clicks_register_link_on_the_home_page() {
		homePage.clickRegisterLink();
	}

	@Then("The user should be redirected to Registration page")
	public void the_user_should_be_redirected_to_registration_page() {
		Assert.assertEquals(homePage.getTitleCurrentPage().trim(), "Registration",
				"User is not navigated to Registration page");
	}

	@When("The user clicks Sign in link")
	public void the_user_clicks_sign_in_link() {
		homePage.clickSignInLink();
	}

	@Then("The user should be redirected to Sign in page")
	public void the_user_should_be_redirected_to_sign_in_page() {
		Assert.assertEquals(homePage.getTitleCurrentPage().trim(), "Login", "User is not navigated to SignIn page");
	}

	@When("The user clicks the data Structures dropdown in Home page")
	public void the_user_clicks_the_data_structures_dropdown() {
		homePage.clickDataStructuresDropdown();
	}

	@Then("user should see the following options:")
	public void the_user_should_see_the_following_options(DataTable dropdownValues) {
		List<List<String>> expectedTable = dropdownValues.asLists(String.class);
		List<String> expectedDropdownOptions = new ArrayList<>();
		for (int i = 1; i < expectedTable.size(); i++) {
			expectedDropdownOptions.add(expectedTable.get(i).get(0)); // Get the value from the first column
		}
		List<String> actualDropdownOptions = homePage.fetchDataStructuresDropdownValues();
		for (int i = 0; i < expectedDropdownOptions.size(); i++) {
			String expectedValue = expectedDropdownOptions.get(i);
			String actualValue = actualDropdownOptions.get(i);
			Assert.assertEquals(expectedValue, actualValue, "Mismatch at index " + "i");
		}
	}

	@When("The user selects {string} from the drop down")
	public void the_user_selects_from_the_drop_down(String dropdownSelection) {
		switch (dropdownSelection) {
		case "Arrays":
			homePage.clickArrayInDropdown();
			break;
		case "Linked List":
			homePage.clickLinkedListInDropdown();
			break;
		case "Stack":
			homePage.clickStackInDropdown();
			break;
		case "Queue":
			homePage.clickQueueInDropdown();
			break;
		case "Tree":
			homePage.clickTreeInDropdown();
			break;
		case "Graph":
			homePage.clickGraphInDropdown();
			break;
		}
	}

	@Then("The user should able to see warning message as {string}")
	public void the_user_should_able_to_see_warning_message_as(String expectedWarningMessage) {
		String actualWarningMessage = homePage.messageToUser();
		Assert.assertEquals(expectedWarningMessage, actualWarningMessage, "Warning message mismatch");
	}

	@When("The user clicks Get Started button of {string} on the homepage")
	public void the_user_clicks_get_started_button_of_on_the_homepage(String moduleSelection) {
		switch (moduleSelection) {
		case "Data Structures-Introduction":
			homePage.clickDataStructuresGetStartedButton();
			break;
		case "Array":
			homePage.clickArrayGetStartedButton();
			break;
		case "Linked List":
			homePage.clickLinkedListGetStartedButton();
			break;
		case "Stack":
			homePage.clickStackGetStartedButton();
			break;
		case "Queue":
			homePage.clickQueueGetStartedButton();
			break;
		case "Tree":
			homePage.clickTreeGetStartedButton();
			break;
		case "Graph":
			homePage.clickGraphGetStartedButton();
			break;
		}
	}

}
