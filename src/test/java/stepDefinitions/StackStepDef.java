package stepDefinitions;
import Hooks.Hooks;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import PageObjects.StackPageObject;
import Utilities.configReader;
import Utilities.excelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StackStepDef {
	
	WebDriver driver;
	WebDriverWait wait;
	StackPageObject stack;
	
	String invalidCode=excelReader.getTryEditorCode("InvalidCode");
	String validCode=excelReader.getTryEditorCode("validCode");


		
		public StackStepDef() {
			
			
			this.driver=Hooks.driver; //Getting driver from hooks
		
			 stack=new StackPageObject(driver);
			
		}

		
	@Given("User sign in to dsAlgo Portal")
	public void user_sign_in_to_ds_algo_portal() {
	    stack.homegetstarted();
	    String filepath = configReader.getProperty("filepath");
	    String SheetName="LoginCredentials";
		try {
			Object[][] fetchedData = excelReader.getTestData(filepath, SheetName);
			int i=0;
				
				String username = "test";
				String password = "pass";
				for(int j=0;j<2;j++) {
					String value=(String) fetchedData[i][j];
					System.out.println("value is"+value);
					if (value.equalsIgnoreCase("Username")) {
						username=(String) fetchedData[i+1][j];
					}
					else if(value.equalsIgnoreCase("Password")){
					 password=(String) fetchedData[i+1][j];
					}
				}
			
				stack.login(username, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Given("User navigates to Stack page using the Getting Started button")
	public void navigates_to_stack_page_using_the_getting_started_button() {
		stack.StackGetStartedBtn();
	}

	@When("User clicks Operations in Stack button in Stack Page")
	public void user_clicks_operations_in_stack_button_in_stack_page() {
	    stack.OperationsInStack();
	}

	@Then("User is redirected to Operations in Stack topic in Stack Page")
	public void user_is_redirected_to_operations_in_stack_topic_in_stack_page() {
		Assert.assertEquals(stack.getTitleCurrentPage(), "Operations in Stack", "User is not redirected to Operations in Stack topic in Stack Page");
	}

	@When("User clicks Implementation button in Stack Page")
	public void user_clicks_implementation_button_in_stack_page() {
	    stack.ImplementationStack();
	}

	@Then("User is redirected to Implementation topic in Stack Page")
	public void user_is_redirected_to_implementation_topic_in_stack_page() {
		Assert.assertEquals(stack.getTitleCurrentPage(), "Implementation", "User is not redirected to Implementation topic in Stack Page");

	}

	@When("User clicks Applications button in Stack Page")
	public void user_clicks_applications_button_in_stack_page() {
	    stack.ApplicationsStack();
	}

	@Then("User is redirected to Applications topic in Stack Page")
	public void user_is_redirected_to_applications_topic_in_stack_page() {
		Assert.assertEquals(stack.getTitleCurrentPage(), "Applications", "User is not redirected to Applications topic in Stack Page");
	}

	@Then("User sees Try Here button below the content for Operations in Stack topic")
	public void user_sees_try_here_button_below_the_content_for_operations_in_stack_topic() {
		if (stack.tryHereDisplayed()) {
			System.out.println("Try Here button is present for Operations in Stack topic");
		}		
	}

	@Then("User sees Try Here button below the content for Implementation topic")
	public void user_sees_try_here_button_below_the_content_for_implementation_topic() {
		if (stack.tryHereDisplayed()) {
			System.out.println("Try Here button is present for Implementation topic");
		}
	}

	@Then("User sees Try Here button below the content for Applications topic")
	public void user_sees_try_here_button_below_the_content_for_applications_topic() {
		if (stack.tryHereDisplayed()) {
			System.out.println("Try Here button is present for Application topic");
		}
	}

	@When("clicks Try Here button under Operations in Stack topic content")
	public void clicks_Try_Here_button_under_operations_in_stack__topic_content() {
		if (stack.tryHereEnabled())
			stack.tryEditor();
		else
			System.out.println("Try Here Button is disabled for Operations in Stack topic");
	}

	@Then("User is redirected to TryEditor page of Operations in Stack with a Run button to test")
	public void user_is_redirected_to_try_editor_page_of_operations_in_stack_with_a_run_button_to_test() {
		Assert.assertEquals(stack.getTitleCurrentPage(), "TryEditor page:Assessment", "User is not redirected to TryEditor page of Operations in Stack");
		 Assert.assertEquals(stack.runBtnDisplayed(),true,"Run button is not displayed in TryEditor page of Operations in Stack topic");
	}

	@When("clicks Try Here button under Implementation topic content")
	public void clicks_Try_Here_button_under_Implementation_topic_content() {
		if (stack.tryHereEnabled())
			stack.tryEditor();
		else
			System.out.println("Try Here Button is disabled for ImplementationStack topic");
	}

	@Then("User is redirected to TryEditor page of Implementation with a Run button to test")
	public void user_is_redirected_to_try_editor_page_of_implementation_with_a_run_button_to_test() {
		Assert.assertEquals(stack.getTitleCurrentPage(), "TryEditor page:Assessment", "User is not redirected to TryEditor page of Implementation");
		 Assert.assertEquals(stack.runBtnDisplayed(),true,"Run button is not displayed in TryEditor page of Implementation topic");
	}

	@When("clicks Try Here button under Applications topic content")
	public void clicks_Try_Here_button_under_Applications_topic_content() {

		if (stack.tryHereEnabled())
			stack.tryEditor();
		else
			System.out.println("Try Here Button is disabled for Applications topic");
	}

	@Then("User is redirected to TryEditor page of Applications with a Run button to test")
	public void user_is_redirected_to_try_editor_page_of_applications_with_a_run_button_to_test() {
	 Assert.assertEquals(stack.getTitleCurrentPage(), "TryEditor page:Assessment", "User is not redirected to TryEditor page of Applications");
	 Assert.assertEquals(stack.runBtnDisplayed(),true,"Run button is not displayed in TryEditor page of Applications topic");
	}

	
	@When("enters invalid code in the try editor page for Operations in Stack and clicks on Run button")
	public void enters_invalid_code_in_the_try_editor_page_for_operations_in_stack_and_clicks_on_run_button() throws InterruptedException, IOException {
		stack.tryEditorcode(invalidCode);
	}

	@Then("Error message for Operations in Stack-invalid code type is displayed")
	public void error_message_for_operations_in_stack_invalid_code_type_is_displayed() throws InterruptedException {
		stack.tryEditorInvalidcodeError();
	}

	@When("enters valid code in the try editor page for Operations in Stack and clicks on Run button")
	public void enters_valid_code_in_the_try_editor_page_for_operations_in_stack_and_clicks_on_run_button() throws InterruptedException, IOException {
		stack.tryEditorcode(validCode);
	}

	@Then("Output for Operations in Stack-valid code type is displayed")
	public void output_for_operations_in_stack_valid_code_type_is_displayed() {
		 stack.tryEditorValidcodeoutput();
	}

	@When("enters invalid code in the try editor page for Implementation and clicks on Run button")
	public void enters_invalid_code_in_the_try_editor_page_for_implementation_and_clicks_on_run_button() throws InterruptedException, IOException {
		stack.tryEditorcode(invalidCode);
	}

	@Then("Error message for Implementation-invalid code type is displayed")
	public void error_message_for_implementation_invalid_code_type_is_displayed() throws InterruptedException {
		stack.tryEditorInvalidcodeError();
	}

	@When("enters valid code in the try editor page for Implementation and clicks on Run button")
	public void enters_valid_code_in_the_try_editor_page_for_implementation_and_clicks_on_run_button() throws InterruptedException, IOException {
		stack.tryEditorcode(validCode);
	}

	@Then("Output for Implementation-valid code type is displayed")
	public void output_for_implementation_valid_code_type_is_displayed() {
		 stack.tryEditorValidcodeoutput();
	}
	@When("enters invalid code in the try editor page for Applications and clicks on Run button")
	public void enters_invalid_code_in_the_try_editor_page_for_applications_and_clicks_on_run_button() throws InterruptedException, IOException {
		stack.tryEditorcode(invalidCode);
	}

	@Then("Error message for Applications-invalid code type is displayed")
	public void error_message_for_applications_invalid_code_type_is_displayed() throws InterruptedException {
		stack.tryEditorInvalidcodeError();
	}

	@When("enters valid code in the try editor page for Applications and clicks on Run button")
	public void enters_valid_code_in_the_try_editor_page_for_applications_and_clicks_on_run_button() throws InterruptedException, IOException {
		stack.tryEditorcode(validCode);
	}

	@Then("Output for Applications-valid code type is displayed")
	public void output_for_applications_valid_code_type_is_displayed() {
		stack.tryEditorValidcodeoutput();
	}
	@When("User clicks Data Structures dropdown button and selects Arrays item")
	public void user_clicks_data_structures_dropdown_button_and_selects_arrays_item() throws InterruptedException {
		stack.arrayFromdropdown();
	}

	@Then("User is redirected to Arrays page")
	public void user_is_redirected_to_arrays_page() {
		Assert.assertEquals(stack.getTitleCurrentPage(), "Array", "User is not redirected to Array page");
	}

	@When("User clicks Data Structures dropdown button and selects Linked List item")
	public void user_clicks_data_structures_dropdown_button_and_selects_linked_list_item() {
		stack.linkedListFromdropdown();
	}

	@Then("User is redirected to Linked List page")
	public void user_is_redirected_to_linked_list_page() {
		Assert.assertEquals(stack.getTitleCurrentPage(), "Linked List", "User is not redirected to Array page");
	}

	@When("User clicks Data Structures dropdown button and selects Stack item")
	public void user_clicks_data_structures_dropdown_button_and_selects_stack_item() {
		stack.stackFromdropdown();
	}

	@Then("User is redirected to Stack page")
	public void user_is_redirected_to_stack_page() {
		Assert.assertEquals(stack.getTitleCurrentPage(), "Stack", "User is not redirected to Array page");
	}

	@When("User clicks Data Structures dropdown button and selects Queue item")
	public void user_clicks_data_structures_dropdown_button_and_selects_queue_item() {
		stack.queueFromdropdown();
	}

	@Then("User is redirected to Queue page")
	public void user_is_redirected_to_queue_page() {
		Assert.assertEquals(stack.getTitleCurrentPage(), "Queue", "User is not redirected to Array page");
	}

	@When("User clicks Data Structures dropdown button and selects Tree item")
	public void user_clicks_data_structures_dropdown_button_and_selects_tree_item() {
		stack.treeFromdropdown();
	}

	@Then("User is redirected to Tree page")
	public void user_is_redirected_to_tree_page() {
		Assert.assertEquals(stack.getTitleCurrentPage(), "Tree", "User is not redirected to Array page");
	}
	
	@When("User clicks Data Structures dropdown button and selects Graph item")
	public void user_clicks_data_structures_dropdown_button_and_selects_graph_item() {
		stack.graphFromdropdown();
	}

	@Then("User is redirected to Graph page")
	public void user_is_redirected_to_graph_page() {
		Assert.assertEquals(stack.getTitleCurrentPage(), "Graph", "User is not redirected to Array page");
	}

	@When("User clicks Numpy Ninja button from stack page")
	public void user_clicks_numpy_ninja_button_from_stack_page() {
		stack.homePage();
	}

	@Then("User is redirected to home page")
	public void user_is_redirected_to_home_page() {
		System.out.println( "current page"+stack.getTitleCurrentPage());
	}

	@When("User clicks Signout button from Stack page")
	public void user_clicks_signout_button_from_stack_page() {
	    stack.logoutPage();
	}

	@Then("User is signedout successfully from the Stack page of DS-Algo Application")
	public void user_is_signedout_successfully_from_the_stack_page_of_ds_algo_application() {
		System.out.println( "current page"+stack.getTitleCurrentPage());
	}




}
