package stepDefinitions;

import java.util.List;

import org.testng.Assert;

import Hooks.Hooks;
import PageObjects.LaunchPage;
import PageObjects.PageObjectManager;
import PageObjects.RegisterPage;
import PageObjects.homePO;
import Utilities.configReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterPageSteps {

	private PageObjectManager pageObjectManager;
	private homePO homePage;
	private LaunchPage launchPage;
	private RegisterPage register;

	public RegisterPageSteps() {
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
		Assert.assertEquals(register.hoverText(hoverTextField), expectedHoverText, "Hover Text mismatch");
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
		List<String> expectedDropdownOptions = dropdownValues.asList(String.class);
		List<String> actualDropdownOptions = homePage.fetchDataStructuresDropdownValues();
		for (int i = 0; i < expectedDropdownOptions.size(); i++) {
			String expectedValue = expectedDropdownOptions.get(i);
			String actualValue = actualDropdownOptions.get(i);
			Assert.assertEquals(actualValue, expectedValue, "Mismatch at index " + "i");
		}
	}

	@When("The user selects {string} values")
	public void the_user_selects_values(String moduleName) {
		register.clickDataStructuresDropdown();
		register.selectDropdownValue(moduleName);
	}

	@Then("The user should be navigated to Home page")
	public void the_user_should_be_navigated_to_home_page() {
		Assert.assertEquals(register.getTitleCurrentPage().trim(), "NumpyNinja", "User is not redirected to Home page");
	}

	@Then("able to see warning message {string}")
	public void see_an_warning_message(String expectedWarningMessage) {
		Assert.assertEquals(register.warningMessage(), expectedWarningMessage, "Warning message mismatch");
	}

	@When("The user clicks Register button after entering valid values from excel sheet")
	public void the_user_clicks_register_button_after_entering_valid_values_from_excel_sheet() {
		configReader.SheetName = "SuccessfulRegistration";
		register.fetchRegistrationDetailsAndRegister(configReader.filepath, configReader.SheetName);
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
