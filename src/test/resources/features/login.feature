@LoginPageValidation
Feature: Login page validation
Page navigation and field level validation performed

 Background:  
 Given User navigates to Sign in page from home page
 
 Scenario Outline: Verify that user receives error message for all empty fields during Login
    When The user clicks login button after providing <usrname> and <password>
    Then Hover text message as "Please fill out this field." appears below respective textbox
    
 Examples: 
      | usrname  || password |
      |  ||  |
      | SDETQA219 || |
      |  ||SDET213890|
     
 Scenario Outline: Verify that user receives error message for invalid data provided
    When The user clicks login button after entering invalid credentials <usrname> and <password>
    Then The user should able to see an error message "Invalid username and password".
    
 Examples: 
      | usrname  || password |
      | SA || SDET213890 |
      | SDETQA219 || SDET21389|
      | SA ||SDE3890|
      
 Scenario: Verify that user is able to navigate to Registration page by clicking on the Register hyperlink
    When The user clicks Register hyperlink displayed at the end of the login page
    Then The user should be redirected to Register Page
    
 Scenario: Verify that user is able to navigate to Registration page by clicking on the Register hyperlink on the top right
    When The user clicks Register hyperlink displayed at the top right corner of the login page
    Then The user should be redirected to Register Page  
      
 Scenario: Verify that page is reloaded on clicking Sign in hyperlink on the top right
    When The user clicks Sign in hyperlink displayed at the top right corner of the login page
    Then The user should be able to see that the page is reloaded
 
 Scenario: Verify that user is able to view dropdown options for Data Structures dropdown on Login page 
    When The user clicks the Data Structures dropdown from the login page
    Then The user should able to see six options (Arrays,Linked List,Stack,Queue,Tree,Graph)
    
 Scenario Outline: Verify that user is navigated to Home page and able to see warning message while selecting dropdown values from the login page
    When The user selects <dropdown values> from login page
    Then The user should able to see warning message as "You are not logged in" after navigated to Home page
    
 Examples: 
      | dropdown values |
      | Arrays |
      | Linked List |
      | Stack |
      | Queue |
      | Tree |
      | Graph |

@LogInSuccess      
 Scenario: Verify that user able to land on Home page after entering valid Username and Password fields
    When The user clicks login button after entering valid username and valid password
    Then The user should land in dsAlgo Home Page with message as "You are logged in"
    
@SignOutSuccess    
 Scenario: Verify that user able to sign out successfully
		Given The user is in the Home page after Sign in
    When The user clicks Sign out
    Then The user should be redirected to home page with message "Logged out successfully"