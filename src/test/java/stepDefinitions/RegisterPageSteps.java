package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import Hooks.Hooks;
import PageObjects.LaunchPage;
import PageObjects.PageObjectManager;
import PageObjects.RegisterPage;
import PageObjects.homePO;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterPageSteps {

	private PageObjectManager pageObjectManager;
	private homePO homePage;
	private LaunchPage launchPage;
	private RegisterPage register;

	@Before(order = 1)
	public void setUpPageObjects() {
		pageObjectManager = new PageObjectManager(Hooks.driver);
		homePage = pageObjectManager.getHomePage();
		launchPage = pageObjectManager.getLaunchPage();
		register = pageObjectManager.getRegisterPage();
	}

	@Given("User navigates to registration page from home page")
	public void user_navigates_to_registration_page_from_home_page() {
		launchPage.GetStartedClick();
		homePage.clickRegisterLink();
	}

	@When("The user clicks Register button after entering {string} and {string} and {string}")
	public void the_user_clicks_register_button_after_entering_and_and(String username, String password,
			String passwordConfirm) {
		register.userRegistration(username, password, passwordConfirm);
	}

	@Then("Hover text message as {string} should be displayed for respective {string} textbox")
	public void hover_text_message_as_should_be_displayed_for_respective_textbox(String expectedHoverText,
			String hoverTextField) {
		String actualHoverText;
		switch (hoverTextField) {
		case "Username":
			actualHoverText = register.usernameHoverText();
			Assert.assertEquals(actualHoverText, expectedHoverText, "Hover Text mismatch");
			break;
		case "Password":
			actualHoverText = register.passwordHoverText();
			Assert.assertEquals(actualHoverText, expectedHoverText, "Hover Text mismatch");
			break;
		case "PasswordConfirmation":
			actualHoverText = register.passwordConfirmationHoverText();
			Assert.assertEquals(actualHoverText, expectedHoverText, "Hover Text mismatch");
			break;
		}
	}

	@Then("User should receive {string} message for respective field")
	public void user_should_receive_message_for_respective_field(String expectedErrorMessage) {
		String ActualErrorMessage = register.warningMessage();
		Assert.assertEquals(ActualErrorMessage, expectedErrorMessage, "Alert message is incorrect");
	}

	@When("The user clicks Login hyperlink displayed at the end of the page")
	public void the_user_clicks_login_hyperlink_displayed_at_the_end_of_the_page() {
		register.clickLogInHyperLink();
	}

	@Then("The user should be redirected to Login Page")
	public void the_user_should_be_redirected_to_login_page() {
		Assert.assertEquals(register.getTitleCurrentPage().trim(), "Login", "User is not redirected to Login page");
	}

	@When("The user clicks Sign in hyperlink displayed at the top right corner")
	public void the_user_clicks_sign_in_hyperlink_displayed_at_the_top_right_corner() {
		register.clickSignInHyperLink();
	}

	@When("The user clicks Register hyperlink displayed at the top right corner")
	public void the_user_clicks_register_hyperlink_displayed_at_the_top_right_corner() {
		register.clickRegisterHyperLink();
	}

	@Then("The user should be reloaded to the same Page")
	public void the_user_should_be_reloaded_to_the_same_page() {
		Assert.assertEquals(register.getTitleCurrentPage().trim(), "Registration", "Page not reloaded correctly");
	}

	@When("The user clicks NumpyNinja label on the Registration page")
	public void the_user_clicks_numpy_ninja_label_on_the_registration_page_without_sign_in() {
		register.clickNumpyNinjaLabel();
	}

	@Then("The user should be navigated to the Launch page with Get Started button")
	public void the_user_should_be_navigated_to_the_initial_ds_algo_portal_with_get_started_button() {
		Assert.assertEquals(register.getTitleCurrentPage().trim(), "Numpy Ninja",
				"User is not redirected to Launch page");
	}

	@When("The user clicks the data structure dropdown in Register page")
	public void the_user_clicks_the_data_structure_dropdown() {
		register.clickDataStructuresDropdown();
	}

	@Then("user should see the following options")
	public void the_user_should_see_the_following_options(DataTable dropdownValues) {
		List<List<String>> expectedTable = dropdownValues.asLists(String.class);
		List<String> expectedDropdownOptions = new ArrayList<>();
		for (int i = 1; i < expectedTable.size(); i++) {
			expectedDropdownOptions.add(expectedTable.get(i).get(0)); // Get the value from the first column
		}
		List<String> actualDropdownOptions = register.fetchDataStructuresDropdownValues();
		for (int i = 0; i < expectedDropdownOptions.size(); i++) {
			String expectedValue = expectedDropdownOptions.get(i);
			String actualValue = actualDropdownOptions.get(i);
			Assert.assertEquals(actualValue, expectedValue, "Mismatch at index " + "i");
		}
	}

	@When("The user selects Arrays values")
	public void the_user_selects_arrays_values() {
		register.clickArrayInDropdown();
	}

	@Then("The user should be navigated to Home page")
	public void the_user_should_be_navigated_to_home_page() {
		Assert.assertEquals(register.getTitleCurrentPage().trim(), "NumpyNinja", "User is not redirected to Home page");
	}

	@Then("able to see warning message {string}")
	public void see_an_warning_message(String expectedWarningMessage) {
		Assert.assertEquals(register.warningMessage(), expectedWarningMessage, "Warning message mismatch");
	}

	@When("The user selects Linked List values")
	public void the_user_selects_linked_list_values() {
		register.clickLinkedListInDropdown();
	}

	@When("The user selects Stack values")
	public void the_user_selects_stack_values() {
		register.clickStackInDropdown();
	}

	@When("The user selects Queue values")
	public void the_user_selects_queue_values() {
		register.clickQueueInDropdown();
	}

	@When("The user selects Tree values")
	public void the_user_selects_tree_values() {
		register.clickTreeInDropdown();
	}

	@When("The user selects Graph values")
	public void the_user_selects_graph_values() {
		register.clickGraphInDropdown();
	}

	@When("The user clicks Register button after entering valid values from excel sheet")
	public void the_user_clicks_register_button_after_entering_valid_values_from_excel_sheet() {
		register.fetchRegistrationDetailsAndRegister();
	}

	@Then("The user should be redirected to Home Page of DS Algo")
	public void the_user_should_be_redirected_to_home_page_of_ds_algo() {
		Assert.assertEquals(register.getTitleCurrentPage().trim(), "NumpyNinja", "User is not redirected to Home page");

	}

	@Then("message should be displayed as {string}")
	public void message_should_be_displayed_as(String expectedMessage) {
		String actualConfirmationMessage = homePage.messageToUser();
		System.out.println(actualConfirmationMessage);
		String expectedConfirmationMessage = expectedMessage + RegisterPage.username;
		System.out.println(expectedConfirmationMessage);
		Assert.assertEquals(actualConfirmationMessage, expectedConfirmationMessage, "Confirmation message incorrect");
	}

}
