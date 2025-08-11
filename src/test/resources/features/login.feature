@LoginPageValidation
Feature: Login page validation
  Page navigation and field level validation performed
  Successful login verified

  Background: 
    Given User navigates to Sign in page from home page

  @LoginPageHoverTextValidation
  Scenario Outline: Verify that user receives hovertext message for all empty fields during Login
    When user clicks login button after providing "<username>" and "<password>"
    Then Hover text message as "Please fill out this field." appears below respective "<field>" textbox

    Examples: 
      | username  |  | password    |  | field    |
      |           |  |             |  | Username |
      | SDETQA219 |  |             |  | Password |
      |           |  | sdfglkjh@24 |  | Username |

  @LoginPageFieldValidation
  Scenario Outline: Verify that user receives error message for invalid login credentials
    When user clicks login button after entering invalid credentials "<usrname>" and "<password>"
    Then user should able to see an error message "Invalid Username and Password".

    Examples: 
      | usrname   |  | password   |
      | SA        |  | SDET213890 |
      | SDETQA219 |  | SDET21389  |
      | SA        |  | SDE3890    |

  @LoginPageRegistrationHyperLink
  Scenario: Verify that user is able to navigate to Registration page by clicking on the Register hyperlink
    When user clicks Register hyperlink displayed at the end of the login page
    Then user should be redirected to Register Page

  @LoginPageRegisterHyperLink
  Scenario: Verify that user is able to navigate to Registration page by clicking on the Register hyperlink on the top right
    When user clicks Register hyperlink displayed at the top right corner of the login page
    Then user should be redirected to Register Page

  @LoginPageSignInHyperLink
  Scenario: Verify that page is reloaded on clicking Sign in hyperlink on the top right
    When user clicks Sign in hyperlink displayed at the top right corner of the login page
    Then user should be able to see that the page is reloaded

  @LoginPageNumpyNinjaLabel
  Scenario: Verify that Launch page with Get Started button is displayed on clicking NumpyNinja label
    When user clicks NumpyNinja label on the Login page
    Then user should be navigated to the Launch page

  @LoginPageDataStructuresDropDown
  Scenario: Verify that user is able to view dropdown options for Data Structures dropdown on Login page
    When user clicks the Data Structures dropdown from the login page
    Then user should able to see following six options
      | Option      |
      | Arrays      |
      | Linked List |
      | Stack       |
      | Queue       |
      | Tree        |
      | Graph       |

  @LoginPageDataStructuresDropDownValuesClick
  Scenario Outline: Verify that user is navigated to Home page and able to see warning message while selecting dropdown values from the login page
    When user selects "<dropdown values>" from login page
    Then user should be navigated to the Home page
    And able to see warning message as "You are not logged in"

    Examples: 
      | dropdown values |
      | Arrays          |
      | Linked List     |
      | Stack           |
      | Queue           |
      | Tree            |
      | Graph           |

  @LoginPageSucessfulLogin
  Scenario: Verify that user able to land on Home page after entering valid Username and Password fields
    When user clicks login button after entering username and password read from excel
    Then user should be navigated to dsAlgo Home Page
    And message should be displayed "You are logged in"
