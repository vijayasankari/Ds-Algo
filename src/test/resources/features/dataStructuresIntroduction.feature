@DataStructureIntroductionValidation
Feature: Data Structures Introduction Page validation
Page navigation, hyperlink access and try editor validation performed 

 Background:  
 Given User clicks on Get Started for Data Structure - Intoduction after logging in
 
 @TimeComplexityPage
  Scenario: Verify that user is able to navigate to Time Complexity page
  	Given Data Structures Introduction page is displayed
    When The user clicks Time Complexity hyperlink
    Then The user should be redirected to Time Complexity page of Data structures-Introduction
    
 @DataStructuresPracticeQuestions
  Scenario: Verify that user is able to navigate to Practice Questions page
  	Given User navigates to Time complexity page
    When The user clicks the Practice Questions hyperlink
    Then The user should be redirected to Practice Questions page of Data structures-Introduction
  
 @DataStructuresTryEditor  
   Scenario: Verify that user is able to navigate to try Editor page
  	Given User navigates to Time complexity page
    When The user clicks Try Here button
    Then The user should be redirected to a page having an try Editor with a Run button to test
    
 @DataStructuresTryEditorValidation
   Scenario Outline: Verify that user able to validate python code
  	Given User clicks on Try here button in the Time complexity page
    When User enters <python code> in try editor
    Then The user should able to see the <result>
    
   Examples: 
      | python code || result  |
      | invalid 	  || alert message |
      | valid       || console output displayed |

 @DataStructuresTryEditorUserNavigation @TimeComplexityPage
   Scenario: Verify that user is able to navigate to Data structure Time Complexity page from tryEditor page
  	Given User clicks on Try here button in the Time complexity page
    When User tries to navigate to Data Structure Time Complexity page 
    Then The user should be navigated to Data structure Time Complexity page
    
 @DataStructuresTryEditorUserNavigation @DataStructuresHomePage  
   Scenario: Verify that user is able to navigate to Data structure introduction page from tryEditor page
  	Given User clicks on Try here button in the Time complexity page
    When User tries to navigate to Data Structure home page 
    Then The user should be navigated to Data structure home page 

 @DataStructuresDropDownArray 
   Scenario: Verify that user is able to select Arrays from the dropdown and navigated to Arrays Home page 
  	Given User navigates to Time complexity page
    When The user selects Arrays from the Data structure drop down
    Then The user should be navigated to Arrays Home page
    
 @DataStructuresDropDownLinkedList    
   Scenario: Verify that user is able to select Linked List from the dropdown and navigated to Linked List Home page 
  	Given User navigates to Time complexity page
    When The user selects Linked List from the Data structure drop down
    Then The user should be navigated to Linked List Home page
    
 @DataStructuresDropDownStack
   Scenario: Verify that user is able to select Stack from the dropdown and navigated to Stack Home page 
  	Given User navigates to Time complexity page
    When The user selects Stack from the Data structure drop down
    Then The user should be navigated to Stack Home page
    
 @DataStructuresDropDownQueue
   Scenario: Verify that user is able to select Queue from the dropdown and navigated to Queue Home page 
  	Given User navigates to Time complexity page
    When The user selects Queue from the Data structure drop down
    Then The user should be navigated to Queue Home page
 
 @DataStructuresDropDownTree 
   Scenario: Verify that user is able to select Tree from the dropdown and navigated to Tree Home page 
  	Given User navigates to Time complexity page
    When The user selects Tree from the Data structure drop down
    Then The user should be navigated to Tree Home page
 
 @DataStructuresDropDownGraph   
  Scenario: Verify that user is able to select Graph from the dropdown and navigated to Graph Home page 
  	Given User navigates to Time complexity page
    When The user selects Graph from the Data structure drop down
    Then The user should be navigated to Graph Home page
 
 @DataStructuresUsernameHyperlink   
  Scenario: Verify that page is reloaded on clicking username hyperlink on the top right
  	Given User navigates to Time complexity page
    When The user clicks on username hyperlink displayed at the top right corner
    Then The user should be able to see that the current page is reloaded
