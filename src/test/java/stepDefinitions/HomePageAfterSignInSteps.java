package stepDefinitions;

import org.testng.Assert;

import Hooks.Hooks;
import PageObjects.LaunchPage;
import PageObjects.LoginPage;
import PageObjects.PageObjectManager;
import PageObjects.homePO;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageAfterSignInSteps {

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

	@Given("User provides valid credentials and navigated to Home page")
	public void user_provides_valid_credentials_and_navigated_to_Home_page() {
		launchPage.GetStartedClick();
		homePage.clickSignInLink();
		login.fetchLoginCredentialsAndLogin();
	}

	@When("user clicks NumpyNinja label on the top left")
	public void user_clicks_numpy_ninja_label_on_the_top_left() {
		homePage.clickNumpyNinjaLabel();
	}

	@Then("user should able to see that the page is reloaded")
	public void user_should_able_to_see_that_the_page_is_reloaded() {
		Assert.assertEquals(homePage.getTitleCurrentPage().trim(), "NumpyNinja", "Page not reloaded correctly");
	}

	@When("The user selects {string} from the data structures dropdown")
	public void the_user_selects_from_the_data_structures_dropdown(String dropdownSelection) {
		switch (dropdownSelection) {
		case "Array":
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

	@When("The user selects Get started button of the {string}")
	public void the_user_selects_get_started_button_of_the(String moduleSelection) {
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

	@Then("The user should able to navigate to respective {string} page")
	public void the_user_should_able_to_navigate_to_respective_page(String moduleSelection) {
		switch (moduleSelection) {
		case "Data Structures-Introduction":
			Assert.assertEquals(homePage.getTitleCurrentPage().trim(), "Data Structures-Introduction",
					"User is not redirected to Data Structures page");
			break;
		case "Array":
			Assert.assertEquals(homePage.getTitleCurrentPage().trim(), "Array", "User is not redirected to Array page");
			break;
		case "Linked List":
			Assert.assertEquals(homePage.getTitleCurrentPage().trim(), "Linked List",
					"User is not redirected to Linked List page");
			break;
		case "Stack":
			Assert.assertEquals(homePage.getTitleCurrentPage().trim(), "Stack", "User is not redirected to Stack page");
			break;
		case "Queue":
			Assert.assertEquals(homePage.getTitleCurrentPage().trim(), "Queue", "User is not redirected to Queue page");
			break;
		case "Tree":
			Assert.assertEquals(homePage.getTitleCurrentPage().trim(), "Tree", "User is not redirected to Tree page");
			break;
		case "Graph":
			Assert.assertEquals(homePage.getTitleCurrentPage().trim(), "Graph", "User is not redirected to Array page");
			break;
		}
	}

	@When("user clicks Sign out")
	public void user_clicks_sign_out() {
		homePage.clickSignOut();
	}

	@Then("user should be reloaded to home page with message {string}")
	public void user_should_be_reloaded_to_home_page_with_message(String expectedMessage) {
		String actualMessage = homePage.messageToUser();
		Assert.assertEquals(actualMessage, expectedMessage, "User is not logged out");
	}
}
