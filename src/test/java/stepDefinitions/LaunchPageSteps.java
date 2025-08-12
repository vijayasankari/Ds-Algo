package stepDefinitions;

import org.testng.Assert;

import Hooks.Hooks;
import PageObjects.LaunchPage;
import PageObjects.PageObjectManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LaunchPageSteps {

	private PageObjectManager pageObjectManager;
	private LaunchPage launchPage;

	@Given("User accesses DsAlgo URL")
	public void user_accesses_ds_algo_url() {
		pageObjectManager = new PageObjectManager(Hooks.driver);
		launchPage = pageObjectManager.getLaunchPage();
	}

	@When("Get Started button is clicked")
	public void Get_Started_button_is_clicked() {
		launchPage.GetStartedClick();
	}

	@Then("user should be able to navigate to Home page")
	public void user_should_able_to_navigate_to_Home_Page() {
		Assert.assertEquals(launchPage.getTitleCurrentPage().trim(), "NumpyNinja", "Home page is not loaded correctly");
	}

}
