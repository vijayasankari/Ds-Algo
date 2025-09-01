package stepDefinitions;
import Hooks.Hooks;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import org.testng.Assert;
import PageObjects.PageObjectManager;
import PageObjects.StackPageObject;
import Utilities.configReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StackStepDef {
	
	private PageObjectManager pageObjectManager;
	private StackPageObject stack;
	//private StackPageObject stack;
	
	//String invalidCode=excelReader.getTryEditorCode("InvalidCode");
	//String validCode=excelReader.getTryEditorCode("validCode");


		
	@Before(order = 1) // This @Before runs before each scenario, after Hooks.setUp()
	public void setUpPageObjects() {
		
		pageObjectManager = new PageObjectManager(Hooks.driver);
		//stack=new StackPageObject(Hooks.driver);
	}
		
	@Given("User sign in to dsAlgo Portal with username and password fetched for Successful login from Excel file")
	public void User_sign_in_to_dsAlgo_Portal_with_username_and_password_fetched_for_Successful_login_from_Excel_file() {
	 
		pageObjectManager.getLaunchPage().GetStartedClick();
		pageObjectManager.getHomePage().clickSignInLink();
		pageObjectManager.getLoginPage().fetchLoginCredentialsAndLogin(configReader.filepath, configReader.SheetName);
	
	}

	@When("User clicks Get Started button for stack page after reaching home page")
	public void User_clicks_Get_Started_button_for_stack_page_after_reaching_home_page() {
		pageObjectManager.getHomePage().clickGetStarted("Stack");
	}
	
	@Then("User should see the following StackTopics under Topics Covered section in Stack page")
	public void user_should_see_the_following_stack_topics_under_topics_covered_section_in_stack_page(DataTable stackTopicsTable) {
		
		Assert.assertEquals(pageObjectManager.getStackPage().StackTopicCoveredHeader(),true,"Topics Covered Header is not present in Stack Module");

		List<String> stackTopicsData=stackTopicsTable.asList(String.class);
			for(int i=1;i<stackTopicsData.size();i++) {
				
				String stackTopic=stackTopicsData.get(i);
				
				Assert.assertEquals(pageObjectManager.getStackPage().StackTopicList(stackTopic),true,stackTopic+" is not present in Stack Module");
			
			}
				
	}
	
    @Then("User should see the following Stack topic listed are in link format")
    public void user_should_see_the_following_Stack_topic_links_enabled_under_the_Topics_Covered_section(DataTable stackTopicsTable) {
    	
    	List<String> stackTopicsData=stackTopicsTable.asList(String.class);
		for(int i=1;i<stackTopicsData.size();i++) {
			
			String stackTopic=stackTopicsData.get(i);
			Assert.assertEquals(pageObjectManager.getStackPage().stackTopicLinksFormat(stackTopic), true, stackTopic+"is not in link format");
		
		}
    	
    }

	@When("User clicks {string} button in Stack Page")
	public void user_clicks_button_in_stack_page(String stackTopic ) {
		
		pageObjectManager.getStackPage().StackTopicLinksClickAction(stackTopic);
	
	}

	@Then("User is redirected to {string} topic in Stack Page")
	public void user_is_redirected_to_topic_in_stack_page(String stackTopic) {
	
		Assert.assertEquals(pageObjectManager.getStackPage().getTitleCurrentPage(), stackTopic, "User is not redirected to"+stackTopic+" topic in Stack Page");
	
	}

	
	@Then("User should see Try Here button below the content for {string} topic")
	public void user_should_see_try_here_button_below_the_content_for_topic(String stackTopic) {

		Assert.assertEquals(pageObjectManager.getStackPage().tryHereDisplayed(),true,"Try Here button is not visible");
	
	}

	
	@When("User clicks Try Here button under {string}")
	public void user_clicks_try_here_button_under(String stackTopic) {
		
		pageObjectManager.getStackPage().tryEditor();
		
	}

	@Then("User is redirected to TryEditor page with a Run button to test")
	public void user_is_redirected_to_try_editor_page_of_operations_in_stack_with_a_run_button_to_test() {
		
		Assert.assertEquals(pageObjectManager.getStackPage().getTitleCurrentPage(), "Assessment", "User is not redirected to TryEditor page of Operations in Stack");
		Assert.assertEquals(pageObjectManager.getStackPage().runBtnDisplayed(),true,"Run button is not displayed in TryEditor page of Operations in Stack topic");
	
	}
	
	@When("User enters invalid code {string} read from excel in the text editor after reaching tryEditor page of {string}")
	public void user_enters_invalid_Acode_read_from_excel_in_the_text_editor_after_reaching_try_editor_page_of(String invalidCodePattern,String stackTopic) throws Exception {
		pageObjectManager.getStackPage().tryEditorcode("StackTopics-TryEditor-InvalidCodeValidation",invalidCodePattern,stackTopic);
		
	}

	@Then("error message alert is thrown")
	public void error_message_alert_is_thrown() throws InterruptedException {
		
		Assert.assertEquals(pageObjectManager.getStackPage().tryEditorInvalidcodeError(), true, "Alert exception ocurred");
				}

	@When("User enters valid code {string} read from excel in the text editor after reaching tryEditor page of {string}")
	public void user_enters_valid_code_read_from_excel_in_the_text_editor_after_reaching_try_editor_page_of(String validCodePattern,String stackTopic) throws Exception {
		pageObjectManager.getStackPage().tryEditorcode("StackTopics-TryEditor-ValidCodeValidation",validCodePattern,stackTopic);
	}

	@Then("Output is displayed for {string} valid code")
	public void Output_is_displayed_for(String stackTopic) throws IOException, AWTException, Exception {
		pageObjectManager.getStackPage().tryEditorValidcodeoutput(stackTopic+"Validcode");
	}



	@When("User clicks Data Structures dropdown button and selects {string} item")
	public void user_clicks_data_structures_dropdown_button_and_selects__item(String otherTopic) throws InterruptedException {
		pageObjectManager.getHomePage().clickDataStructuresDropdown();
		pageObjectManager.getHomePage().selectDropdownValue(otherTopic);
	}

	@Then("User is redirected to {string} page")
	public void user_is_redirected_to__page(String otherTopic) {
		String pageTitle=null;
		switch (otherTopic) {
		case "Arrays":
			pageTitle="Array";
			Assert.assertEquals(pageObjectManager.getStackPage().getTitleCurrentPage(),pageTitle , "User is not redirected to "+pageTitle+ " page");
			break; 
		default:
			 pageTitle=otherTopic;
			 Assert.assertEquals(pageObjectManager.getStackPage().getTitleCurrentPage(),pageTitle , "User is not redirected to "+pageTitle+ " page");
		}
		
	}

	
	@When("User clicks Numpy Ninja button from stack page")
	public void user_clicks_numpy_ninja_button_from_stack_page() {
		pageObjectManager.getHomePage().clickNumpyNinjaLabel();
	}

	@Then("User is redirected to home page")
	public void user_is_redirected_to_home_page() {
		Assert.assertEquals(pageObjectManager.getStackPage().getTitleCurrentPage(), "Numpy Ninja", "User is not redirected to home page");
	}

	@When("User clicks Signout button from Stack page")
	public void user_clicks_signout_button_from_stack_page() {
		pageObjectManager.getHomePage().clickSignOut();
	}
	
	@Then("User should be navigated to home page with message seen as {string}")
	public void user_should_be_navigated_to_home_page_with_message_seen_as(String expectedLogoutMessage) {
		
		Assert.assertEquals(stack.getTitleCurrentPage(), "NumpyNinja", "User is not redirected to home page after clicking Logout");
		Assert.assertEquals(pageObjectManager.getHomePage().messageToUser(), expectedLogoutMessage, "User logged out message is missing");
	
	}



}
