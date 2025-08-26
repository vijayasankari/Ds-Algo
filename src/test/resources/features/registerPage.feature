@RegisterPageValidation
Feature: Registration page validation
  Page navigation and Field level validation performed

  Background: 
    Given User navigates to registration page from home page
    
  @RegisterPageHoverTextValidation
  Scenario Outline: Verify that user receives hovertext message for all empty fields during registration
    When The user clicks Register button after entering "<username>" and "<password>" and "<passwordConfirmation>"
    Then Hover text message as "Please fill out this field." should be displayed for respective "<Field>" textbox

    Examples: 
      | username |  | password   |  | passwordConfirmation |  | Field                |
      |          |  |            |  |                      |  | Username             |
      | SDET@219 |  |            |  |                      |  | Password             |
      | SDET@219 |  | sdfglkh@24 |  |                      |  | PasswordConfirmation |

  @RegisterPageFieldLevelValidation
  Scenario Outline: Field level validation for username and password in registration page
    When The user clicks Register button after entering "<username>" and "<password>" and "<passwordConfirmation>"
    Then User should receive "<error>" message for respective field

    Examples: 
      | username  |  | password    |  | passwordConfirmation |  | error                                                   |
      | SDET&&    |  | sdfglkjh@24 |  | sdfglkjh@24          |  | Invalid Username                                        |
      | SDET$21,% |  | sdfglkjh@24 |  | sdfglkjh@24          |  | Invalid Username                                        |
      | SDET@219  |  | sjh@24      |  | sjh@24               |  | Invalid password                                        |
      | SDET@219  |  |  2356789453 |  |           2356789453 |  | Invalid password                                        |
      | SDET@219  |  | Test1234    |  | Test1234             |  | Invalid password                                        |
      | SDET@219  |  | sdfglkjh@24 |  | sdfglkjh@2           |  | password_mismatch:The two password fields didn’t match. |

  @RegisterPageLoginHyperLink
  Scenario: Verify that user is able to navigate to Login page by clicking on the Login hyperlink
    When The user clicks Login hyperlink displayed at the end of the page
    Then The user should be redirected to Login Page

  @RegisterPageSignInHyperLink
  Scenario: Verify that user is able to navigate to Login page by clicking on the Sign in hyperlink on the top right
    When The user clicks Sign in hyperlink displayed at the top right corner
    Then The user should be redirected to Login Page

  @RegisterPageRegisterHyperLink
  Scenario: Verify that page is reloaded on clicking "Register" hyperlink on the top right
    When The user clicks Register hyperlink displayed at the top right corner
    Then The user should be reloaded to the same Page

  @RegisterPageNumpyNinjaLabel
  Scenario: Verify that Launch page with Get Started button is displayed on clicking NumpyNinja label
    When The user clicks NumpyNinja label on the Registration page
    Then The user should be navigated to the Launch page with Get Started button

  @RegisterPageDataStructuresDropdown
  Scenario: Verify that user is able to view dropdown options for Data Structures dropdown on Registration page
    When The user clicks the data structure dropdown in Register page
    Then user should see the following options
      | Arrays      |
      | Linked List |
      | Stack       |
      | Queue       |
      | Tree        |
      | Graph       |

  @RegisterPageDropdownValuesSelection
  Scenario Outline: Verify that user is navigated to Home page and able to see warning message while selecting values from the Data Structure drop down
    When The user selects "<dropdown>" values
    Then The user should be navigated to Home page
    And able to see warning message "You are not logged in"

    Examples: 
      | dropdown    |
      | Arrays      |
      | Linked List |
      | Stack       |
      | Queue       |
      | Tree        |
      | Graph       |

  @SuccessfulRegistration
  Scenario: Verify that user is able to land on Homepage after registration with valid fields
    When The user clicks Register button after entering valid values from excel sheet
    Then The user should be redirected to Home Page of DS Algo
    And message should be displayed as "New Account Created. You are logged in as "
