



Feature: Linked List Module on DSAlgo Portal


    
Background: 
    Given User is on the login page for DSAlgo Portal
    When User enters valid credentials for login page 
    Then User clicks on LinkedList from dropdown
    
    
@LL1    
Scenario: Verify that user is able to navigate to Introduction data structure page
    Given The user is in the Linked List page 
     When The user clicks Introduction link
    Then The user should be redirected to Introduction page
    
@LL2  
Scenario: Verify that user is able to navigate to Try here page for Introduction page
    Given The user is on the Introduction page
    When The user clicks Try Here button in Introduction page
    Then The user should be navigated to try Editor with a Run button to test for Introduction page

@LL3
Scenario Outline: Verify Validating the code for Introduction
  Given The user is in the tryEditor page for Introduction
  When The user write the <LLTypes> code in Editor and click the Run Button for Introduction
  Then The user should be able to see <LLResult> for Introduction 

  Examples:
    | LLTypes | LLResult                    |
    | invalid  | an error message in alert window  |
    | valid    | output in the console             |
	

@LL4
Scenario: Verify that user is able to navigate to Creating Linked List data structure page
    Given The user is in the LinkedList page 
     When The user clicks Creating Linked List link
    Then The user should be redirected to Creating Linked List page
    
@LL5
Scenario: Verify that user is able to navigate to Try here page for Creating Linked List page
    Given The user is on the Creating Linked List page
    When The user clicks Try Here button in Creating Linked List page
    Then The user should be navigated to try Editor with a Run button to test in Creating Linked List page   
    
@LL6
Scenario Outline: Verify Validating the code for Creating Linked List
  Given The user is in the tryEditor page in Creating Linked List page
  When The user write the <LLTypes> code in Editor and click the Run Button in Creating Linked List page
  Then The user should be able to see <LLResult> in Creating Linked List page

  Examples:
    | LLTypes | LLResult                    |
    | invalid  | an error message in alert window  |
    | valid    | output in the console             |
    
@LL7
 Scenario: Verify that user is able to navigate to Types of Linked List data structure page
    Given The user is in the LinkedList page 
     When The user clicks Types of Linked List link
    Then The user should be redirected to Types of Linked List page
    
@LL8
Scenario: Verify that user is able to navigate to Try here page for Types of Linked List page
    Given The user is on the Types of Linked List page
    When The user clicks Try Here button in Basic Operations in Lists page
    Then The user should be navigated to try Editor with a Run button to test for for Types of Linked List   
    
@LL9
Scenario Outline: Verify Validating the code for Types of Linked List
  Given The user is in the tryEditor page for Types of Linked List
  When The user write the <LLTypes> code in Editor and click the Run Button for Types of Linked List
  Then The user should be able to see <LLResult> for Types of Linked List

  Examples:
    | LLTypes | LLResult                    |
    | invalid  | an error message in alert window  |
    | valid    | output in the console             |
    
    
@LL10
Scenario: Verify that user is able to navigate to Implement Linked List in Python data structure page
    Given The user is in the LinkedList page
     When The user clicks Implement Linked List in Python link
    Then The user should be redirected to Applications of Array page
    
@LL11
Scenario: Verify that user is able to navigate to Try here page for Implement Linked List in Python page
    Given The user is on the Implement Linked List in Python page
    When The user clicks Try Here button in Applications of Array page
    Then The user should be navigated to try Editor with a Run button to test for Implement Linked List in Python   
    
@LL12
Scenario Outline: Verify Validating the code for Implement Linked List in Python
  Given The user is in the tryEditor page for  Implement Linked List in Python
  When The user write the <LLTypes> code in Editor and click the Run Button for Implement Linked List in Python
  Then The user should be able to see <LLResult> for Implement Linked List in Python

  Examples:
    | LLTypes | LLResult                    |
    | invalid  | an error message in alert window  |
    | valid    | output in the console             |
    
@LL13
Scenario: Verify that user is able to navigate to Traversal data structure page
    Given The user is in the LinkedList page
     When The user clicks Traversal link
    Then The user should be redirected to Traversal page
    
@LL14
Scenario: Verify that user is able to navigate to Try here page for Traversal page
    Given The user is on the Traversal page
    When The user clicks Try Here button in Traversal
    Then The user should be navigated to try Editor with a Run button to test for Traversal page   
    
@LL15
Scenario Outline: Verify Validating the code for Traversal
  Given The user is in the tryEditor page for Traversal page
  When The user write the <LLTypes> code in Editor and click the Run Button for Traversal page
  Then The user should be able to see <LLResult> or Traversal page

  Examples:
    | LLTypes | LLResult                    |
    | invalid  | an error message in alert window  |
    | valid    | output in the console             |
       
@LL16
Scenario: Verify that user is able to navigate to Insertion data structure page
    Given The user is in the LinkedList page
     When The user clicks Insertion link
    Then The user should be redirected to Insertion page
    
@LL17
Scenario: Verify that user is able to navigate to Try here page for Insertion page
    Given The user is on the Insertion page
    When The user clicks Try Here button in Applications of Array page
    Then The user should be navigated to try Editor with a Run button to test for Insertion page    
    
@LL18
Scenario Outline: Verify Validating the code for Insertion page
  Given The user is in the tryEditor page for Insertion page
  When The user write the <LLTypes> code in Editor and click the Run Button for Insertion page
  Then The user should be able to see <LLResult>

  Examples:
    | LLTypes | LLResult                    |
    | invalid  | an error message in alert window  |
    | valid    | output in the console             |
       
       
@LL19
Scenario: Verify that user is able to navigate to Deletion data structure page
    Given The user is in the LinkedList page
     When The user clicks Deletion link
    Then The user should be redirected to Deletion page
    
@LL20
Scenario: Verify that user is able to navigate to Try here page for Deletion page
    Given The user is on the Deletion page
    When The user clicks Try Here button in Applications of Array page
    Then The user should be navigated to try Editor with a Run button to test for DEletion page   
    
@LL21
Scenario Outline: Verify Validating the code for Deletion page
  Given The user is in the tryEditor pagein Deletion page
  When The user write the <LLTypes> code in Editor and click the Run Button for Deletion page
  Then The user should be able to see <LLResult> for DEletion page

  Examples:
    | LLTypes | LLResult                    |
    | invalid  | an error message in alert window  |
    | valid    | output in the console             |
       
       
@LL22
Scenario: Verify that user is able to navigate to Practice Questions Page for Introduction page
    Given The user is on the Introduction page
     When The user clicks Practice Questions button
    Then The user should be redirected to Practice Questions page
    
@LL23
Scenario: Verify that user able to logout from the LinkedList data structure

   Given The user is in the LinkedList data structure page
   When  The user clicks signout button
   Then The user should signout successfully from LinkedList page
