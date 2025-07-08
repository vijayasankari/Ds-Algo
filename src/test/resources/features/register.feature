@RegisterPageValidation
Feature: Registration page validation
Page navigation and Field level validation performed 

 Background:  
 Given User navigates to registration page from home page
 
  Scenario: Verify that user receives error message for all empty fields during registration
    When The user clicks Register button with all fields empty
    Then Hover text message as "Please fill out this field." should be displayed for Username textbox
    
  Scenario: Verify that user receives error message for empty Password field during registration
    When The user clicks Register button after entering Username alone
    Then Hover text message as "Please fill out this field." should be displayed for Password textbox
    
  Scenario: Verify that user receives error message for empty Password Confirmation field during registration
    When The user clicks Register button when value not provided for Password Confirmation
    Then Hover text message as "Please fill out this field." should be displayed for Password confirmation textbox
    
  Scenario Outline: Verify that user receives error message for invalid username field during registration  
    When The user clicks Register button after entering invalid <username> and valid <password>
    Then User should receive <error> message for respective field
    
    Examples: 
      | username || password    || error |
      | SDET&& 	 || sdfglkjh@24 || Invalid Username |
      |          || sdfglkjh@24 || Invalid Username |
      | SDET@219 || sjh@24      || Invalid password |
      | SDET@219 || 2356789453  || Invalid password |
      | SDET@219 ||             || Invalid password |
     
    
  Scenario: Verify that user receives error message for mismatched Password and Password Confirmation field during registration
    When User enters different password in both password fields
    Then The user should able to see an password warning message 
    
  Scenario: Verify that user is able to navigate to Login page by clicking on the Login hyperlink
    When The user clicks Login hyperlink displayed at the end of the page
    Then The user should be redirected to Login Page
    
  Scenario: Verify that user is able to navigate to Login page by clicking on the Sign in hyperlink on the top right
    When The user clicks Sign in hyperlink displayed at the top right corner
    Then The user should be redirected to Login Page
    
  Scenario: Verify that page is reloaded on clicking "Register" hyperlink on the top right
    When The user clicks Register hyperlink displayed at the top right corner
    Then The user should be reloaded to the same Page
    
  Scenario: Verify that DsAlgo portal with Get Started button is displayed on clicking NumpyNinja label
    When The user clicks NumpyNinja label on the Registration page without Sign in
    Then The user should be navigated to the Initial DsAlgo portal with Get Started button   
    
  Scenario: Verify that user is able to view dropdown options for Data Structures dropdown on Registration page 
    When The user clicks the data structure dropdown 
    Then The user should able to see options as (Arrays,Linked List,Stack,Queue,Tree,Graph)
    
  Scenario Outline: Verify that user is navigated to Home page and able to see warning message while selecting values from the Data Structure drop down 
    When The user selects <dropdown> values
    Then The user should be navigated to Home page and see an warning message "You are not logged in"
    
    Examples: 
      | dropdown  |
      | Arrays |
      | Linked List |
      | Stack |
      | Queue |
      | Tree |
      | Graph |

  Scenario: Verify that user is able to land on Homepage after registration with valid fields
    When The user clicks Register button after entering valid values
    Then The user should be redirected to Home Page of DS Algo with message "New Account Created. You are logged in as <ID>"  
      
      