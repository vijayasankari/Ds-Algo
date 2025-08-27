package stepDefinitions;
import Hooks.Hooks;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PageObjects.LaunchPage;
import PageObjects.LoginPage;
import PageObjects.PageObjectManager;
import PageObjects.StackPageObject;
import PageObjects.homePO;
import Utilities.configReader;
import Utilities.excelReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StackStepDef {
	
	private PageObjectManager pageObjectManager;
	private homePO homePage;
	private LaunchPage launchPage;
	private LoginPage login;
	private StackPageObject stack;
	
	String invalidCode=excelReader.getTryEditorCode("InvalidCode");
	String validCode=excelReader.getTryEditorCode("validCode");


		
	@Before(order = 1) // This @Before runs before each scenario, after Hooks.setUp()
	public void setUpPageObjects() {
		pageObjectManager = new PageObjectManager(Hooks.driver);
		homePage = pageObjectManager.getHomePage();
		launchPage = pageObjectManager.getLaunchPage();
		login = pageObjectManager.getLoginPage();
		stack=pageObjectManager.getStackPage();
	}
		
	@Given("User sign in to dsAlgo Portal")
	public void user_sign_in_to_ds_algo_portal() {
	  //  stack.homegetstarted();
		launchPage.GetStartedClick();
		homePage.clickSignInLink();
		
		  String filepath = configReader.getProperty("filepath"); 
		  String SheetName="LoginCredentials"; 
		  try { Object[][] fetchedData = excelReader.getTestData(filepath, SheetName); 
		  int i=0;
		  String username = null;
		  String password = null;
		  
		 
		  for(int j=0;j<2;j++) {
		  String value=(String) fetchedData[i][j];
		   
		  if (value.equalsIgnoreCase("Username"))
			 username=(String) fetchedData[i+1][j]; 
		  else if(value.equalsIgnoreCase("Password"))
			  password=(String)fetchedData[i+1][j]; 
			  
		  }
		  
		  login.loginAuthentication(username, password);
		  
		  }
		  catch (Exception e) { 
			  e.printStackTrace(); 
		  }
		 
	}

	@Given("User navigates to Stack page using the Getting Started button")
	public void user_navigates_to_stack_page_using_the_getting_started_button() {
		stack.StackGetStartedBtn();
	}
	
	@When("User looks for StackTopics under Topics Covered section in Stack page")
	public void user_looks_for_StackTopics_under_Topics_Covered_section_in_Stack_page(DataTable stackTopicsTable) {
		
		
		stack.StackTopicsCoveredPart();
		
			List<String> stackTopicsData=stackTopicsTable.asList(String.class);
			for(int i=1;i<stackTopicsData.size();i++) {
				String stackTopic=stackTopicsData.get(i);
				stack.StackTopicList(stackTopic);
			}
				
	}
	
    @Then("User sees the following Stack topic listed are in link format")
    public void user_sees_the_following_Stack_topic_links_enabled_under_the_Topics_Covered_section(DataTable stackTopicsTable) {
    	List<String> stackTopicsData=stackTopicsTable.asList(String.class);
		for(int i=1;i<stackTopicsData.size();i++) {
			String stackTopic=stackTopicsData.get(i);
			boolean stackTopicAreLinks=stack.stackTopicLinks(stackTopic);
			Assert.assertEquals(stackTopicAreLinks, true, stackTopic+"is not in link format");
		}
    	
    }

	@When("User clicks {string} button in Stack Page")
	public void user_clicks_button_in_stack_page(String stackTopic ) {
		stack.StackTopic(stackTopic);
	}

	@Then("User is redirected to {string} topic in Stack Page")
	public void user_is_redirected_to_topic_in_stack_page(String stackTopic) {
		Assert.assertEquals(stack.getTitleCurrentPage(), stackTopic, "User is not redirected to"+stackTopic+" topic in Stack Page");
	}

	
	@Then("User sees Try Here button below the content for {string} topic")
	public void user_sees_try_here_button_below_the_content_for_topic(String stackTopic) {
		Assert.assertEquals(stack.tryHereDisplayed(),true,"Try Here button is not visible");
	}

	

	@When("clicks Try Here button under {string} topic content")
	public void clicks_Try_Here_button_under__topic_content(String stackTopic) {
		
			stack.tryEditor();
		
	}

	@Then("User is redirected to TryEditor page with a Run button to test")
	public void user_is_redirected_to_try_editor_page_of_operations_in_stack_with_a_run_button_to_test() {
		Assert.assertEquals(stack.getTitleCurrentPage(), "Assessment", "User is not redirected to TryEditor page of Operations in Stack");
		 Assert.assertEquals(stack.runBtnDisplayed(),true,"Run button is not displayed in TryEditor page of Operations in Stack topic");
	}
	
	@When("enters invalid code read from excel in the try editor page and clicks on Run button")
	public void enters_invalid_code_in_the_try_editor_page__and_clicks_on_run_button() throws InterruptedException, IOException {
		stack.tryEditorcode(invalidCode);
	}

	@Then("error message alert is thrown")
	public void error_message_alert_is_thrown() throws InterruptedException {
		
		Assert.assertEquals(stack.tryEditorInvalidcodeError(), true, "Alert exception ocurred");
				}

	@When("enters valid code read from excel in the try editor page and clicks on Run button")
	public void enters_valid_code_in_the_try_editor_page_and_clicks_on_run_button() throws InterruptedException, IOException {
		stack.tryEditorcode(validCode);
	}

	@Then("Output is displayed for {string} valid code")
	public void Output_is_displayed_for(String stackTopic) throws IOException, AWTException, Exception {
		 stack.tryEditorValidcodeoutput(stackTopic+"Validcode");
	}



	@When("User clicks Data Structures dropdown button and selects {string} item")
	public void user_clicks_data_structures_dropdown_button_and_selects__item(String otherTopic) throws InterruptedException {
		stack.getdropdownItems(otherTopic);
	}

	@Then("User is redirected to {string} page")
	public void user_is_redirected_to__page(String otherTopic) {
		String pageTitle=null;
		switch (otherTopic) {
		case "Arrays":
			pageTitle="Array";
			Assert.assertEquals(stack.getTitleCurrentPage(),pageTitle , "User is not redirected to "+pageTitle+ " page");
			break; 
		default:
			 pageTitle=otherTopic;
			 Assert.assertEquals(stack.getTitleCurrentPage(),pageTitle , "User is not redirected to "+pageTitle+ " page");
		}
		
	}

	
	@When("User clicks Numpy Ninja button from stack page")
	public void user_clicks_numpy_ninja_button_from_stack_page() {
		stack.homePage();
	}

	@Then("User is redirected to home page")
	public void user_is_redirected_to_home_page() {
		Assert.assertEquals(stack.getTitleCurrentPage(), "Numpy Ninja", "User is not redirected to home page");
	}

	@When("User clicks Signout button from Stack page")
	public void user_clicks_signout_button_from_stack_page() {
	    stack.logoutPage();
	}

	@Then("User should be navigated to home page")
	public void User_should_be_navigated_to_home_page() {
		Assert.assertEquals(stack.getTitleCurrentPage(), "NumpyNinja", "User is not redirected to home page");
	}
	
	@Then("User should see the message {string}")
	public void User_should_see_the_message(String expectedLogoutMessage) {
		String actualMsg=stack.logoutMsg();
		Assert.assertEquals(actualMsg, expectedLogoutMessage, "User logged out message is missing");
	}



}
