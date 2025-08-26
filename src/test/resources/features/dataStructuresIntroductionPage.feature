@DataStructureIntroductionValidation
Feature: Data Structures Introduction Page validation
  Page navigation, hyperlink access and try editor validation performed

  Background: 
    Given User logged into DsAlgo portal
    And clicks "Data Structures-Introduction" Get Started button

  @DataStructures @TimeComplexityPage @Login
  Scenario: Verify that user is able to navigate to Time Complexity page
    When The user clicks Time Complexity hyperlink
    Then The user should be redirected to Time Complexity page of Data structures-Introduction

  @DataStructures @PracticeQuestions @Login
  Scenario: Verify that user is able to navigate to Practice Questions page
    When the user navigates to Time Complexity page
    And clicks the Practice Questions hyperlink
    Then The user should be redirected to Practice Questions page of Data structures-Introduction

  @DataStructures @TryEditor @Login
  Scenario: Verify that user is able to navigate to try Editor page
    When the user navigates to Time Complexity page
    And clicks on Try Here link
    Then The user should be redirected to a page having an try Editor with a Run button to test

  @DataStructures @TryEditorValidation @Login
  Scenario Outline: Verify that user able to validate python code
    When the user navigates to Time Complexity page
    And user clicks on Try here link
    And User enters "<python code>" in try editor from excel sheet
    Then The user should able to see the "<result>"

    Examples: 
      | python code |  | result         |
      | InvalidCode |  | Alert Message  |
      | ValidCode   |  | Console Output |

  @DataStructures @DropDownSelection @Login
  Scenario Outline: Verify that on clicking dropdown values user able to navigate to module pages
    When The user selects "<module>" from the Data Structures dropdown of Data Structures Introduction page
    Then The user should be able to navigate to respective "<module>" page

    Examples: 
      | module      |
      | Arrays      |
      | Linked List |
      | Stack       |
      | Queue       |
      | Tree        |
      | Graph       |

  @DataStructures @UsernameHyperlink @Login
  Scenario: Verify that page is reloaded on clicking username hyperlink on the top right
    When The user clicks on username hyperlink displayed at the top right corner
    Then The user should be able to see that the current page is reloaded
