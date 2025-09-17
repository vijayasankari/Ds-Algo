package stepDefinitions;

import org.testng.Assert;

import Hooks.Hooks;
import PageObjects.PageObjectManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageAfterSignInSteps {

	private PageObjectManager pageObjectManager;

	public HomePageAfterSignInSteps() {
		pageObjectManager = new PageObjectManager(Hooks.driver);
	}

	@When("user clicks NumpyNinja label on the top left")
	public void user_clicks_numpy_ninja_label_on_the_top_left() {
		pageObjectManager.getHomePage().clickNumpyNinjaLabel();
	}

	@Then("user should able to see that the page is reloaded")
	public void user_should_able_to_see_that_the_page_is_reloaded() {
		Assert.assertEquals(pageObjectManager.getHomePage().getTitleCurrentPage().trim(), "NumpyNinja", "Page not reloaded correctly");
	}

	@When("The user selects {string} from the data structures dropdown")
	public void the_user_selects_from_the_data_structures_dropdown(String dropdownSelection){
		pageObjectManager.getHomePage().clickDataStructuresDropdown();
		pageObjectManager.getHomePage().selectDropdownValue(dropdownSelection);
	}

	@When("The user selects Get started button of the {string}")
	public void the_user_selects_get_started_button_of_the(String moduleSelection) {
		pageObjectManager.getHomePage().clickGetStarted(moduleSelection);
	}

	@Then("The user should able to navigate to respective {string} page")
	public void the_user_should_able_to_navigate_to_respective_page(String moduleSelection) {
		Assert.assertEquals(pageObjectManager.getHomePage().getTitleCurrentPage().trim(), moduleSelection,
				"User is not redirected to "+moduleSelection+" page");
	}

	@When("user clicks Sign out")
	public void user_clicks_sign_out() {
		pageObjectManager.getHomePage().clickSignOut();
	}

	@Then("user should be reloaded to home page with message {string}")
	public void user_should_be_reloaded_to_home_page_with_message(String expectedMessage) {
		String actualMessage = pageObjectManager.getHomePage().messageToUser();
		Assert.assertEquals(actualMessage, expectedMessage, "User is not logged out");
	}
}
