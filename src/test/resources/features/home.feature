@HomePageValidation
Feature: User accessibility verification of Home page without Sign in

 Background:  
 Given User is on the DsAlgo Home page
 
  Scenario: Verify that page is reloaded on clicking NumpyNinja label on the top left 
    When The user clicks NumpyNinja label on the homepage
    Then The user should able to see that the page is reloaded
    
  Scenario: Verify that user is able to access Register Page
    When The user clicks Register link on the Home page
    Then The user should be redirected to Registration page
 
  Scenario: Verify that user is able to access Login Page
    When The user clicks Sign in link
    Then The user should be redirected to Sign in page
    
  Scenario: Verify that user is able to view dropdown options for Data Structures dropdown on home page 
    When The user clicks the data Structures dropdown
    Then The user should able to see options (Arrays,Linked List,Stack,Queue,Tree,Graph)

  Scenario Outline: Verify that user able to see warning message while selecting values from the Data structure drop down 
    When The user selects <value> from the drop down
    Then The user should able to see an warning message as "You are not logged in"
    
    Examples: 
      | value  |
      | Arrays |
      | Linked List |
      | Stack |
      | Queue |
      | Tree |
      | Graph |

 Scenario Outline: Verify that user able to see warning message on clicking Get Started button of various modules on the home page  
    When The user clicks Get Started button of <module> on the homepage 
    Then The user should able to see warning message as "You are not logged in"
    
    Examples: 
      | module  |
      | Data Structures-Introduction  |
      | Array |
      | Linked List |
      | Stack |
      | Queue |
      | Tree |
      | Graph |
