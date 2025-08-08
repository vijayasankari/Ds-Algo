package stepDefinitions;
import Hooks.Hooks;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import PageObjects.StackPageObject;
import Utilities.configReader;
import Utilities.excelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StackStepDef {
	
	WebDriver driver;
	StackPageObject stack;


		
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

	@Given("navigates to Stack page using the Getting Started button")
	public void navigates_to_stack_page_using_the_getting_started_button() {
		stack.StackGetStartedBtn();
	}

	@When("User clicks Operations in Stack button in Stack Page")
	public void user_clicks_operations_in_stack_button_in_stack_page() {
	    stack.OperationsInStack();
	}

	@Then("User is redirected to Operations in Stack topic in Stack Page")
	public void user_is_redirected_to_operations_in_stack_topic_in_stack_page() {
		String title=stack.getTitleCurrentPage();
	    System.out.println("The user is redirected to " +title);
	}

	@When("User clicks Implementation button in Stack Page")
	public void user_clicks_implementation_button_in_stack_page() {
	    stack.ImplementationStack();
	}

	@Then("User is redirected to Implementation topic in Stack Page")
	public void user_is_redirected_to_implementation_topic_in_stack_page() {
		String title=stack.getTitleCurrentPage();
	    System.out.println("The user is redirected to " +title);
	}

	@When("User clicks Applications button in Stack Page")
	public void user_clicks_applications_button_in_stack_page() {
	    stack.ApplicationsStack();
	}

	@Then("User is redirected to Applications topic in Stack Page")
	public void user_is_redirected_to_applications_topic_in_stack_page() {
		String title=stack.getTitleCurrentPage();
	    System.out.println("The user is redirected to " +title);
	}

	@Then("User sees Try Here button below the content for Operations in Stack topic")
	public void user_sees_try_here_button_below_the_content_for_operations_in_stack_topic() {
		if (stack.tryHereDisplayed()) {
			System.out.println("Try Here button is present for Operations in Stack topic");
		}

			
		
	}

	@Then("User sees Try Here button below the content for Implementation topic")
	public void user_sees_try_here_button_below_the_content_for_implementation_topic() {
	    
	}

	@Then("User sees Try Here button below the content for Applications topic")
	public void user_sees_try_here_button_below_the_content_for_applications_topic() {
	    
	}

	@When("User navigates to Operations in Stack and clicks Try Here button")
	public void user_navigates_to_operations_in_stack_and_clicks_try_here_button() {
	    
	}

	@Then("User is redirected to TryEditor page of Operations in Stack with a Run button to test")
	public void user_is_redirected_to_try_editor_page_of_operations_in_stack_with_a_run_button_to_test() {
	    
	}

	@When("User navigates to Implementation and clicks Try Here button")
	public void user_navigates_to_implementation_and_clicks_try_here_button() {
	    
	}

	@Then("User is redirected to TryEditor page of Implementation with a Run button to test")
	public void user_is_redirected_to_try_editor_page_of_implementation_with_a_run_button_to_test() {
	    
	}

	@When("User navigates to Applications and clicks Try Here button")
	public void user_navigates_to_applications_and_clicks_try_here_button() {
	    
	}

	@Then("User is redirected to TryEditor page of Applications with a Run button to test")
	public void user_is_redirected_to_try_editor_page_of_applications_with_a_run_button_to_test() {
	    
	}

	@When("User clicks <stacktopic> topic in Stack page")
	public void user_clicks_stacktopic_topic_in_stack_page() {
	    
	}

	@When("User clicks Try Here button and navigates to  TryEditor page of Operations in Stack")
	public void user_clicks_try_here_button_and_navigates_to_try_editor_page_of_operations_in_stack() {
	    
	}

	@When("User enters invalid code in the text editor section and clicks on Run button")
	public void user_enters_invalid_code_in_the_text_editor_section_and_clicks_on_run_button() {
	    
	}

	@Then("Error message for Operations in Stack is displayed")
	public void error_message_for_operations_in_stack_is_displayed() {
	    
	}

	@When("User enters valid code in the text editor section and clicks on Run button")
	public void user_enters_valid_code_in_the_text_editor_section_and_clicks_on_run_button() {
	    
	}

	@Then("Output for Operations in Stack is displayed")
	public void output_for_operations_in_stack_is_displayed() {
	    
	}

	@When("User clicks Try Here button and navigates to  TryEditor page of Implementation")
	public void user_clicks_try_here_button_and_navigates_to_try_editor_page_of_implementation() {
	    
	}

	@Then("Error message for Implementation is displayed")
	public void error_message_for_implementation_is_displayed() {
	    
	}

	@Then("Output for Implementation is displayed")
	public void output_for_implementation_is_displayed() {
	    
	}

	@When("User clicks Try Here button and navigates to  TryEditor page of Applications")
	public void user_clicks_try_here_button_and_navigates_to_try_editor_page_of_applications() {
	    
	}

	@Then("Error message for Applications is displayed")
	public void error_message_for_applications_is_displayed() {
	    
	}

	@Then("Output for Applications is displayed")
	public void output_for_applications_is_displayed() {
	    
	}

	@When("User clicks Data Structures dropdown button and selects Arrays item")
	public void user_clicks_data_structures_dropdown_button_and_selects_arrays_item() {
	    
	}

	@Then("User is redirected to Arrays page")
	public void user_is_redirected_to_arrays_page() {
	    
	}

	@When("User clicks Data Structures dropdown button and selects Linked List item")
	public void user_clicks_data_structures_dropdown_button_and_selects_linked_list_item() {
	    
	}

	@Then("User is redirected to Linked List page")
	public void user_is_redirected_to_linked_list_page() {
	    
	}

	@When("User clicks Data Structures dropdown button and selects Queue item")
	public void user_clicks_data_structures_dropdown_button_and_selects_queue_item() {
	    
	}

	@Then("User is redirected to Queue page")
	public void user_is_redirected_to_queue_page() {
	    
	}

	@When("User clicks Data Structures dropdown button and selects Tree item")
	public void user_clicks_data_structures_dropdown_button_and_selects_tree_item() {
	    
	}

	@Then("User is redirected to Tree page")
	public void user_is_redirected_to_tree_page() {
	    
	}

	@When("User clicks Data Structures dropdown button and selects Graph item")
	public void user_clicks_data_structures_dropdown_button_and_selects_graph_item() {
	    
	}

	@Then("User is redirected to Graph page")
	public void user_is_redirected_to_graph_page() {
	    
	}

	@When("User clicks Numpy Ninja button from stack page")
	public void user_clicks_numpy_ninja_button_from_stack_page() {
	    
	}

	@Then("User is redirected to home page")
	public void user_is_redirected_to_home_page() {
	    
	}

	@When("User clicks Signout button from Stack page")
	public void user_clicks_signout_button_from_stack_page() {
	    
	}

	@Then("User is signedout successfully from the Stack page of DS-Algo Application")
	public void user_is_signedout_successfully_from_the_stack_page_of_ds_algo_application() {
	    
	}




}
