package stepDefinitions;

import java.util.List;

import org.testng.Assert;

import Hooks.Hooks;
import PageObjects.PageObjectManager;
import Utilities.LoggerReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageBeforeSignInSteps {

	private PageObjectManager pageObjectManager;

	public HomePageBeforeSignInSteps() {
		pageObjectManager = new PageObjectManager(Hooks.driver);
	}

	@Given("User is on the DsAlgo Home page")
	public void user_is_on_the_ds_algo_home_page() {
		pageObjectManager.getLaunchPage().GetStartedClick();
		LoggerReader.info("User is in home page");
	}

	@When("The user clicks NumpyNinja label on the homepage")
	public void the_user_clicks_numpy_ninja_label_on_the_homepage() {
		pageObjectManager.getHomePage().clickNumpyNinjaLabel();
	}

	@Then("The user should able to see that the page is reloaded")
	public void the_user_should_able_to_see_that_the_page_is_reloaded() {
		Assert.assertEquals(pageObjectManager.getHomePage().getTitleCurrentPage().trim(), "NumpyNinja", "Page not reloaded correctly");
	}

	@When("The user clicks Register link on the Home page")
	public void the_user_clicks_register_link_on_the_home_page() {
		pageObjectManager.getHomePage().clickRegisterLink();
	}

	@Then("The user should be redirected to Registration page")
	public void the_user_should_be_redirected_to_registration_page() {
		Assert.assertEquals(pageObjectManager.getHomePage().getTitleCurrentPage().trim(), "Registration",
				"User is not navigated to Registration page");
	}

	@When("The user clicks Sign in link")
	public void the_user_clicks_sign_in_link() {
		pageObjectManager.getHomePage().clickSignInLink();
	}

	@Then("The user should be redirected to Sign in page")
	public void the_user_should_be_redirected_to_sign_in_page() {
		Assert.assertEquals(pageObjectManager.getHomePage().getTitleCurrentPage().trim(), "Login", "User is not navigated to SignIn page");
	}	
	
	@Then("user should be able to verify the number of modules in the home page")
	public void user_should_be_able_to_verify_the_number_of_modules_in_the_home_page() {
		System.out.println("Number of module cards : "+pageObjectManager.getHomePage().numberOfModulesCards());
	}
	
	@Then("user should be able to verify the number of modules in the data structures dropdown")
	public void user_should_be_able_to_verify_the_number_of_modules_in_the_data_structures_dropdown() {
		System.out.println("Number of modules in dropdown : "+pageObjectManager.getHomePage().countOfModulesInDropdown());
	}

	@When("The user clicks the data Structures dropdown in Home page")
	public void the_user_clicks_the_data_structures_dropdown() {
		pageObjectManager.getHomePage().clickDataStructuresDropdown();
	}

	@Then("user should see the following options:")
	public void the_user_should_see_the_following_options(DataTable dropdownValues) {
		List<String> expectedDropdownOptions = dropdownValues.asList(String.class);
		List<String> actualDropdownOptions = pageObjectManager.getHomePage().fetchDataStructuresDropdownValues();
		for (int i = 0; i < expectedDropdownOptions.size(); i++) {
			String expectedValue = expectedDropdownOptions.get(i);
			String actualValue = actualDropdownOptions.get(i);
			Assert.assertEquals(actualValue, expectedValue, "Mismatch at index " + "i");
		}
	}

	@When("The user selects {string} from the drop down")
	public void the_user_selects_from_the_drop_down(String dropdownSelection) {
		pageObjectManager.getHomePage().clickDataStructuresDropdown();
		pageObjectManager.getHomePage().selectDropdownValue(dropdownSelection);
	}

	@Then("The user should able to see warning message as {string}")
	public void the_user_should_able_to_see_warning_message_as(String expectedWarningMessage) {
		String actualWarningMessage = pageObjectManager.getHomePage().messageToUser();
		Assert.assertEquals(actualWarningMessage, expectedWarningMessage, "Warning message mismatch");
	}

	@When("The user clicks Get Started button of {string} on the homepage")
	public void the_user_clicks_get_started_button_of_on_the_homepage(String moduleSelection) {
		pageObjectManager.getHomePage().clickGetStarted(moduleSelection);
	}

}
