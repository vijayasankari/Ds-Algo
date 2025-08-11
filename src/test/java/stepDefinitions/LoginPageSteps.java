package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import Hooks.Hooks;
import PageObjects.LaunchPage;
import PageObjects.LoginPage;
import PageObjects.PageObjectManager;
import PageObjects.homePO;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private PageObjectManager pageObjectManager;
	private homePO homePage;
	private LaunchPage launchPage;
	private LoginPage login;

	@Before(order = 1) // This @Before runs before each scenario, after Hooks.setUp()
	public void setUpPageObjects() {
		pageObjectManager = new PageObjectManager(Hooks.driver);
		homePage = pageObjectManager.getHomePage();
		launchPage = pageObjectManager.getLaunchPage();
		login = pageObjectManager.getLoginPage();
	}

	@Given("User navigates to Sign in page from home page")
	public void user_navigates_to_sign_in_page_from_home_page() {
		launchPage.GetStartedClick();
		homePage.clickSignInLink();
	}

	@When("user clicks login button after providing {string} and {string}")
	public void user_clicks_login_button_after_providing_and(String username, String password) {
		login.loginAuthentication(username, password);
	}

	@Then("Hover text message as {string} appears below respective {string} textbox")
	public void hover_text_message_as_appears_below_respective_textbox(String expectedHoverText,
			String hoverTextField) {
		String actualHoverText;
		switch (hoverTextField) {
		case "Username":
			actualHoverText = login.usernameHoverText();
			Assert.assertEquals(actualHoverText, expectedHoverText, "Hover Text mismatch");
			break;
		case "Password":
			actualHoverText = login.passwordHoverText();
			Assert.assertEquals(actualHoverText, expectedHoverText, "Hover Text mismatch");
			break;
		}
	}

	@When("user clicks login button after entering invalid credentials {string} and {string}")
	public void user_clicks_login_button_after_entering_invalid_credentials_and(String username, String password) {
		login.loginAuthentication(username, password);
	}

	@Then("user should able to see an error message {string}.")
	public void user_should_able_to_see_an_error_message(String expectedErrorMessage) {
		String actualErrorMessage = login.errorMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Incorrect Error Message");
	}

	@When("user clicks Register hyperlink displayed at the end of the login page")
	public void user_clicks_register_hyperlink_displayed_at_the_end_of_the_login_page() {
		login.clickRegisterHyperLinkAtEndOfPage();
	}

	@Then("user should be redirected to Register Page")
	public void user_should_be_redirected_to_register_page() {
		Assert.assertEquals(login.getTitleCurrentPage().trim(), "Registration",
				"User is not redirected to Registration page");
	}

	@When("user clicks Register hyperlink displayed at the top right corner of the login page")
	public void user_clicks_register_hyperlink_displayed_at_the_top_right_corner_of_the_login_page() {
		login.clickRegisterHyperLink();
	}

	@When("user clicks Sign in hyperlink displayed at the top right corner of the login page")
	public void user_clicks_sign_in_hyperlink_displayed_at_the_top_right_corner_of_the_login_page() {
		login.clickSignInHyperLink();
	}

	@Then("user should be able to see that the page is reloaded")
	public void user_should_be_able_to_see_that_the_page_is_reloaded() {
		Assert.assertEquals(login.getTitleCurrentPage().trim(), "Login", "Login page is not reloaded");
	}

	@When("user clicks NumpyNinja label on the Login page")
	public void the_user_clicks_numpy_ninja_label_on_the_login_page() {
		login.clickNumpyNinjaLabel();
	}

	@Then("user should be navigated to the Launch page")
	public void the_user_should_be_navigated_to_the_launch_page() {
		Assert.assertEquals(login.getTitleCurrentPage().trim(), "Numpy Ninja", "User is not redirected to Launch page");
	}

	@When("user clicks the Data Structures dropdown from the login page")
	public void user_clicks_the_data_structures_dropdown_from_the_login_page() {
		login.clickDataStructuresDropdown();
	}

	@Then("user should able to see following six options")
	public void user_should_able_to_see_following_six_options(DataTable dropdownValues) {
		List<List<String>> expectedTable = dropdownValues.asLists(String.class);
		List<String> expectedDropdownOptions = new ArrayList<>();
		for (int i = 1; i < expectedTable.size(); i++) {
			expectedDropdownOptions.add(expectedTable.get(i).get(0)); // Get the value from the first column
		}
		List<String> actualDropdownOptions = login.fetchDataStructuresDropdownValues();
		for (int i = 0; i < expectedDropdownOptions.size(); i++) {
			String expectedValue = expectedDropdownOptions.get(i);
			String actualValue = actualDropdownOptions.get(i);
			Assert.assertEquals(expectedValue, actualValue, "Mismatch at index " + "i");
		}
	}

	@When("user selects Arrays from login page")
	public void user_selects_arrays_from_login_page() {
		login.clickArrayInDropdown();
	}

	@When("user selects Linked List from login page")
	public void user_selects_linked_list_from_login_page() {
		login.clickLinkedListInDropdown();
	}

	@When("user selects Stack from login page")
	public void user_selects_stack_from_login_page() {
		login.clickStackInDropdown();
	}

	@When("user selects Queue from login page")
	public void user_selects_queue_from_login_page() {
		login.clickQueueInDropdown();
	}

	@When("user selects Tree from login page")
	public void user_selects_tree_from_login_page() {
		login.clickTreeInDropdown();
	}

	@When("user selects Graph from login page")
	public void user_selects_graph_from_login_page() {
		login.clickGraphInDropdown();
	}

	@Then("user should be navigated to the Home page")
	public void user_should_be_navigated_to_the_home_page() {
		Assert.assertEquals(login.getTitleCurrentPage().trim(), "NumpyNinja", "User is not redirected to Home page");
	}

	@Then("able to see warning message as {string}")
	public void able_to_see_warning_message_as(String expectedWarningMessage) {
		String actualWarningMessage = homePage.messageToUser();
		Assert.assertEquals(actualWarningMessage, expectedWarningMessage, "Warning message incorrect");
	}

	@When("user clicks login button after entering username and password read from excel")
	public void user_clicks_login_button_after_entering_username_and_password_read_from_excel() {
		login.fetchLoginCredentialsAndLogin();
	}

	@Then("user should be navigated to dsAlgo Home Page")
	public void user_should_be_navigated_to_ds_algo_home_page() {
		Assert.assertEquals(login.getTitleCurrentPage().trim(), "NumpyNinja", "User is not redirected to Home page");
	}

	@Then("message should be displayed {string}")
	public void message_should_be_displayed(String expectedConfirmationMessage) {
		String actualConfirmationMessage = homePage.messageToUser();
		Assert.assertEquals(expectedConfirmationMessage, actualConfirmationMessage, "Confirmation message incorrect");
	}

}
