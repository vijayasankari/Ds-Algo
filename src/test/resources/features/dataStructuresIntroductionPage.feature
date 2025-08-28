@DataStructureIntroductionValidation
Feature: Data Structures Introduction Page validation
  Page navigation, hyperlink access and try editor validation performed

  Background: 
    Given User logged into DsAlgo portal

    And clicks Data Structures-Introduction Get Started button

  @TimeComplexityPage

  Scenario: Verify that user is able to navigate to Time Complexity page
    When The user clicks Time Complexity hyperlink
    Then The user should be redirected to Time Complexity page of Data structures-Introduction


  @DataStructuresPracticeQuestions
  Scenario: Verify that user is able to navigate to Practice Questions page
    When The user clicks the Practice Questions hyperlink from Time Complexity page
    Then The user should be redirected to Practice Questions page of Data structures-Introduction

  @DataStructuresTryEditor
  Scenario: Verify that user is able to navigate to try Editor page
    When The user clicks Try Here button from Time Complexity page
    Then The user should be redirected to a page having an try Editor with a Run button to test

  @DataStructuresTryEditorValidation
  Scenario: Verify that user able to validate python code
    Given User clicks on Try here button in the Time complexity page
    When User enters python code in try editor from excel sheet
    Then The user should able to see the result

  @DataStructuresPageDropDownSelection
  Scenario Outline: Verify that on clicking dropdown values user able to navigate to module pages
    When The user selects "<module>" from the Data Structures dropdown of Data Structures Introduction page
    Then The user should be able to navigate to respective "<module>" page

    Examples: 
      | module      |
      | Array       |
      | Linked List |
      | Stack       |
      | Queue       |
      | Tree        |
      | Graph       |


  @DataStructuresPageUsernameHyperlink
  Scenario: Verify that page is reloaded on clicking username hyperlink on the top right
    When The user clicks on username hyperlink displayed at the top right corner
    Then The user should be able to see that the current page is reloaded
