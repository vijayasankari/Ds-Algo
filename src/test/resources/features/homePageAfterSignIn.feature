@HomePageValidationAfterSignIn
Feature: User accessibility verification of Home page after Sign in
  Module page navigation from dropdown and get started click verified
  Sign out verified

  Background: 
    Given User provides valid credentials and navigated to Home page

  @HomePageNumpyNinjaLabelAfterSignIn @Login
  Scenario: Verify that page is reloaded on clicking NumpyNinja label
    When user clicks NumpyNinja label on the top left
    Then user should able to see that the page is reloaded

  @HomePagModuleSelectionDropdownAfterSignIn @Login
  Scenario Outline: Verify that on clicking dropdown values user able to navigate to module pages
    When The user selects "<module>" from the data structures dropdown
    Then The user should able to navigate to respective "<module>" page

    Examples: 
      | module      |
      | Arrays      |
      | Linked List |
      | Stack       |
      | Queue       |
      | Tree        |
      | Graph       |

  @HomePagModuleSelectionAfterSignIn @Login
  Scenario Outline: Verify that on clicking Get Started button able to navigate to module pages
    When The user selects Get started button of the "<module>"
    Then The user should able to navigate to respective "<module>" page

    Examples: 
      | module                       |
      | Data Structures-Introduction |
      | Array                        |
      | Linked List                  |
      | Stack                        |
      | Queue                        |
      | Tree                         |
      | Graph                        |

  @HomePageSignOut @Login
  Scenario: Verify that user able to sign out successfully
    When user clicks Sign out
    Then user should be reloaded to home page with message "Logged out successfully"
