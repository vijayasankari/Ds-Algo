package Step_Definitions;

import org.openqa.selenium.WebDriver;
import Hooks.Hooks;
import PageObjects.StackPO;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StackSD {
WebDriver driver;
StackPO stack;

	
	public StackSD() {
		
		
		this.driver=Hooks.driver; //Getting driver from hooks
		 stack=new StackPO(driver);
		
	}
	
	@Given("The user sign in to dsAlgo Portal")
	public void the_user_sign_in_to_ds_algo_portal() {
		
		stack.homegetstarted();
		System.out.println("Home Page");
	   
	}

	@Given("navigates to Stack page using the Getting Started button")
	public void navigates_to_stack_page_using_the_getting_started_button() {
	    
	}

	@Given("The Stack page is displayed")
	public void the_stack_page_is_displayed() {
	    
	}

	@When("The user clicks Operations in Stack button")
	public void the_user_clicks_operations_in_stack_button() {
	    
	}

	@Then("The user is redirected to Operations in Stack page")
	public void the_user_is_redirected_to_operations_in_stack_page() {
	   
	}

	@When("The user clicks Implementation button")
	public void the_user_clicks_implementation_button() {
	    
	}

	@Then("The user is redirected to Implementation page")
	public void the_user_is_redirected_to_implementation_page() {
	    
	}

	@When("The user clicks Applications button")
	public void the_user_clicks_applications_button() {

	}

	@Then("The user is redirected to Applications page")
	public void the_user_is_redirected_to_applications_page() {

	}

	@Given("The Operations in Stack page is displayed")
	public void the_operations_in_stack_page_is_displayed() {

	}

	@When("The user clicks Try Here button in Operations in Stack page")
	public void the_user_clicks_try_here_button_in_operations_in_stack_page() {

	}

	@Then("The user is redirected to TryEditor page of Operations in Stack with a Run button to test")
	public void the_user_is_redirected_to_try_editor_page_of_operations_in_stack_with_a_run_button_to_test() {

	}

	@Given("The Implementation page is displayed")
	public void the_implementation_page_is_displayed() {
	
	}

	@When("The user clicks Try Here button in Implementation page")
	public void the_user_clicks_try_here_button_in_implementation_page() {
	
	}

	@Then("The user is redirected to TryEditor page of Implementation with a Run button to test")
	public void the_user_is_redirected_to_try_editor_page_of_implementation_with_a_run_button_to_test() {
	
	}

	@Given("The Applications page is displayed")
	public void the_applications_page_is_displayed() {
	
	}

	@When("The user clicks Try Here button in Applications page")
	public void the_user_clicks_try_here_button_in_applications_page() {
	
	}

	@Then("The user is redirected to TryEditor page of Applications with a Run button to test")
	public void the_user_is_redirected_to_try_editor_page_of_applications_with_a_run_button_to_test() {
	
	}

	@Given("The tryEditor page of Operations in Stack is shown")
	public void the_try_editor_page_of_operations_in_stack_is_shown() {
	
	}

	@When("The user enters invalid code in the text editor section for Operations in Stack and clicks Run button")
	public void the_user_enters_invalid_code_in_the_text_editor_section_for_operations_in_stack_and_clicks_run_button() {
	
	}

	@Then("The error message for Operations in Stack code is displayed")
	public void the_error_message_for_operations_in_stack_code_is_displayed() {
	  
	}

	@When("The user enters valid code in the text editor section for Operations in Stack and clicks Run button")
	public void the_user_enters_valid_code_in_the_text_editor_section_for_operations_in_stack_and_clicks_run_button() {
	
	}

	@Then("The output for Operations in Stack code is displayed")
	public void the_output_for_operations_in_stack_code_is_displayed() {
	    
	}

	@Given("The tryEditor page of Implementation is shown")
	public void the_try_editor_page_of_implementation_is_shown() {
	    
	}

	@When("The user enters invalid code in the text editor section for Implementation and clicks Run button")
	public void the_user_enters_invalid_code_in_the_text_editor_section_for_implementation_and_clicks_run_button() {
	    
	}

	@Then("The error message for Implementation code is displayed")
	public void the_error_message_for_implementation_code_is_displayed() {
	    
	}

	@When("The user enters valid code in the text editor section for Implementation and clicks Run button")
	public void the_user_enters_valid_code_in_the_text_editor_section_for_implementation_and_clicks_run_button() {
	    
	}

	@Then("The output for Implementation code is displayed")
	public void the_output_for_implementation_code_is_displayed() {
	    
	}

	@Given("The tryEditor page of Applications is shown")
	public void the_try_editor_page_of_applications_is_shown() {
	    
	}

	@When("The user enters invalid code in the text editor section for Applications and clicks Run button")
	public void the_user_enters_invalid_code_in_the_text_editor_section_for_applications_and_clicks_run_button() {
	    
	}

	@Then("The error message for Applications code is displayed")
	public void the_error_message_for_applications_code_is_displayed() {
	    
	}

	@When("The user enters valid code in the text editor section for Applications and clicks Run button")
	public void the_user_enters_valid_code_in_the_text_editor_section_for_applications_and_clicks_run_button() {
	    
	}

	@Then("The output for Applications code is displayed")
	public void the_output_for_applications_code_is_displayed() {
	    
	}

	@Given("Operations in Stack page is displayed")
	public void operations_in_stack_page_is_displayed() {
	    
	}

	@When("The user clicks Practice Questions from Operations in Stack page")
	public void the_user_clicks_practice_questions_from_operations_in_stack_page() {
	    
	}

	@Then("The user is redirected to practice page for Operations in Stack")
	public void the_user_is_redirected_to_practice_page_for_operations_in_stack() {
	    
	}

	@Given("Implementation page is displayed")
	public void implementation_page_is_displayed() {
	    
	}

	@When("The user clicks Practice Questions from Implementation page")
	public void the_user_clicks_practice_questions_from_implementation_page() {
	    
	}

	@Then("The user is redirected to practice page for Implementation")
	public void the_user_is_redirected_to_practice_page_for_implementation() {
	    
	}

	@Given("Applications page is displayed")
	public void applications_page_is_displayed() {
	    
	}

	@When("The user clicks Practice Questions from Applications page")
	public void the_user_clicks_practice_questions_from_applications_page() {
	    
	}

	@Then("The user is redirected to practice page for Applications")
	public void the_user_is_redirected_to_practice_page_for_applications() {
	    
	}

	@When("The user clicks Implementation button  from Operations in Stack page")
	public void the_user_clicks_implementation_button_from_operations_in_stack_page() {
	    
	}

	@Then("The user is redirected to Implementation page from Operations in Stack page")
	public void the_user_is_redirected_to_implementation_page_from_operations_in_stack_page() {
	    
	}

	@When("The user clicks Applications button  from Operations in Stack page")
	public void the_user_clicks_applications_button_from_operations_in_stack_page() {
	    
	}

	@Then("The user is redirected to Applications page from Operations in Stack page")
	public void the_user_is_redirected_to_applications_page_from_operations_in_stack_page() {
	    
	}

	@When("The user clicks Operations in Stack button  from Implementation page")
	public void the_user_clicks_operations_in_stack_button_from_implementation_page() {
	    
	}

	@Then("The user is redirected to Operations in Stack page from Implementation page")
	public void the_user_is_redirected_to_operations_in_stack_page_from_implementation_page() {
	    
	}

	@When("The user clicks Applications button  from Implementation page")
	public void the_user_clicks_applications_button_from_implementation_page() {
	    
	}

	@Then("The user is redirected to Applications page from Implementation page")
	public void the_user_is_redirected_to_applications_page_from_implementation_page() {
	    
	}

	@When("The user clicks Operations in Stack button  from Applications page")
	public void the_user_clicks_operations_in_stack_button_from_applications_page() {
	    
	}

	@Then("The user is redirected to Operations in Stack page from Applications page")
	public void the_user_is_redirected_to_operations_in_stack_page_from_applications_page() {
	    
	}

	@When("The user clicks Implementation button  from Applications page")
	public void the_user_clicks_implementation_button_from_applications_page() {
	    
	}

	@Then("The user is redirected to Implementation page from Applications page")
	public void the_user_is_redirected_to_implementation_page_from_applications_page() {
	    
	}

	

}
