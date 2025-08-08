


Feature: Array Module on DSAlgo Portal

    
Background: 
    Given User is on the login page
    When User enters valid credentials
    Then User clicks on Array from dropdown
    

@Array1   
Scenario: Verify that user is able to navigate to "Arrays in Python" data structure page
    Given The user is in the Array page
     When The user clicks "Arrays in Python" link
    Then The user should be redirected to "Arrays in Python" page
    
@Array2  
Scenario: Verify that user is able to navigate to "Try here" page for "Arrays in Python" page
    Given The user is on the "Arrays in Python" page
    When The user clicks "Try Here" button in Arrays in Python page
    Then The user should be navigated to try Editor with a Run button to test

@Array3
Scenario Outline: Verify Validating the code for "Arrays in Python"
  Given The user is in the tryEditor page
  When The user write the <Types> code in Editor and click the Run Button
  Then The user should be able to see <Result>

  Examples:
    | Types | Result                    |
    | invalid  | an error message in alert window  |
    | valid    | output in the console             |
	
@Array4
Scenario: Verify that user is able to navigate to "Arrays using Lists" data structure page
    Given The user is in the Array page
     When The user clicks "Arrays using Lists" link
    Then The user should be redirected to "Arrays using Lists" page
 @Array5   
Scenario: Verify that user is able to navigate to "Try here" page for "Arrays using Lists" page
    Given The user is on the "Arrays in Python" page
    When The user clicks "Try Here" button in Arrays in Python page
    Then The user should be navigated to try Editor with a Run button to test    
@Array6    
Scenario Outline: Verify Validating the code for "Arrays using Lists"
  Given The user is in the tryEditor page
  When The user write the <Types> code in Editor and click the Run Button
  Then The user should be able to see <Result>

  Examples:
    | Types | Result                    |
    | invalid  | an error message in alert window  |
    | valid    | output in the console             |
    
@Array7
 Scenario: Verify that user is able to navigate to "Basic Operations in Lists" data structure page
    Given The user is in the Array page
     When The user clicks "Basic Operations in Lists" link
    Then The user should be redirected to "Basic Operations in Lists" page
    
@Array8
Scenario: Verify that user is able to navigate to "Try here" page for "Basic Operations in Lists" page
    Given The user is on the "Basic Operations in Lists" page
    When The user clicks "Try Here" button in Basic Operations in Lists page
    Then The user should be navigated to try Editor with a Run button to test    
    
@Array9
Scenario Outline: Verify Validating the code for "Basic Operations in Lists"
  Given The user is in the tryEditor page
  When The user write the <Types> code in Editor and click the Run Button
  Then The user should be able to see <Result>

  Examples:
    | Types | Result                    |
    | invalid  | an error message in alert window  |
    | valid    | output in the console             |
    
    
@Array10
Scenario: Verify that user is able to navigate to "Applications of Array" data structure page
    Given The user is in the Array page
     When The user clicks "Applications of Array" link
    Then The user should be redirected to "Applications of Array" page
    
@Array11
Scenario: Verify that user is able to navigate to "Try here" page for "Applications of Array" page
    Given The user is on the "Applications of Array" page
    When The user clicks "Try Here" button in Applications of Array page
    Then The user should be navigated to try Editor with a Run button to test    
    
@Array12
Scenario Outline: Verify Validating the code for "Applications of Array"
  Given The user is in the tryEditor page
  When The user write the <Types> code in Editor and click the Run Button
  Then The user should be able to see <Result>

  Examples:
    | Types | Result                    |
    | invalid  | an error message in alert window  |
    | valid    | output in the console             |
       
@Array13 

Scenario: Verify that user is able to navigate to "Practice Questions" Page for "Arrays in Python" page
    Given The user is on the "Arrays in Python" page
     When The user clicks "Practice Questions" button
    Then The user should be redirected to "Practice Questions" page
    
@Array14 

Scenario: Verify that user is able to navigate to "Search the array" page from Practice question page of "Arrays in Python" page
    Given The user is on the "Practice Questions" page
     When The user clicks the "Search the array" link
    Then The user should be redirected to "Question" page with a question,and try Editor with Run and Submit buttons
    
    
@Array15
Scenario Outline: Verify Validating the code for "Search the array" question
  Given The user is in the practice question editor
  When The user write the <Types> code in Editor and click the Run Button
  Then The user should be able to see <Result>

  Examples:
    | Types | Result                    |
    | invalid  | an error message in alert window  |
    | valid    | output in the console             |
    
  @Array16 
 Scenario Outline: Verify Submitting the code for "Search the array" question
  Given The user is in the practice question editor
  When The user write the <Types> code in Editor and click the Submit Button
  Then The user should be able to see <Result>

  Examples:
    | Types | Result                    |
    | invalid  | Error occurred during submission  |
    | valid    | Submission successful           |
    
    
@Array17
Scenario: Verify that user is able to navigate to "Max Consecutive Ones" page from Practice question page of "Arrays in Python" page
    Given The user is on the "Practice Questions" page
     When The user clicks the "Max Consecutive Ones" link
    Then The user should be redirected to "Question" page with a question,and try Editor with Run and Submit buttons
    
    
@Array18
Scenario Outline: Verify Validating the code for "Max Consecutive Ones" question
  Given The user is in the practice question editor
  When The user write the <Types> code in Editor and click the Run Button
  Then The user should be able to see <Result>

  Examples:
    | Types | Result                    |
    | invalid  | an error message in alert window  |
    | valid    | output in the console             |
    
    
 @Array19
 Scenario Outline: Verify Submitting the code for "Max Consecutive Ones" question
  Given The user is in the practice question editor
  When The user write the <Types> code in Editor and click the Submit Button
  Then The user should be able to see <Result>

  Examples:
    | Types | Result                    |
    | invalid  | Error occurred during submission  |
    | valid    | Submission successful           |
 
 @Array20
 Scenario: Verify that user is able to navigate to "Find Numbers with Even Number of Digits" page from Practice question page of "Arrays in Python" page
    Given The user is on the "Practice Questions" page
     When The user clicks the "Find Numbers with Even Number of Digits" link
    Then The user should be redirected to "Question" page with a question,and try Editor with Run and Submit buttons
    
    
@Array21
Scenario Outline: Verify Validating the code for "Find Numbers with Even Number of Digits" question
  Given The user is in the practice question editor
  When The user write the <Types> code in Editor and click the Run Button
  Then The user should be able to see <Result>

  Examples:
    | Types | Result                    |
    | invalid  | an error message in alert window  |
    | valid    | output in the console             |
    
    
 @Array22
 Scenario Outline: Verify Submitting the code for "Find Numbers with Even Number of Digits" question
  Given The user is in the practice question editor
  When The user write the <Types> code in Editor and click the Submit Button
  Then The user should be able to see <Result>

  Examples:
    | Types | Result                    |
    | invalid  | Error occurred during submission  |
    | valid    | Submission successful           |
    
    
    
@Array23

Scenario: Verify that user is able to navigate to "Squares of a Sorted Array" page from Practice question page of "Arrays in Python" page
    Given The user is on the "Practice Questions" page
     When The user clicks the "Squares of a Sorted Array" link
    Then The user should be redirected to "Question" page with a question,and try Editor with Run and Submit buttons
    
    
@Array24

Scenario Outline: Verify Validating the code for "Squares of a Sorted Array" question
  Given The user is in the practice question editor
  When The user write the <Types> code in Editor and click the Run Button
  Then The user should be able to see <Result>

  Examples:
    | Types | Result                    |
    | invalid  | an error message in alert window  |
    | valid    | output in the console             |
    
    
 @Array25
 Scenario Outline: Verify Submitting the code for "Squares of a Sorted Array" question
  Given The user is in the practice question editor
  When The user write the <Types> code in Editor and click the Submit Button
  Then The user should be able to see <Result>

  Examples:
    | Types | Result                    |
    | invalid  | Error occurred during submission  |
    | valid    | Submission successful           | 
    
 @Array26
 
 Scenario:: Verify that user able to logout from the Array data structure

   Given The User is in the Array data structure page
   When  The User clicks signout button
   Then The user should signout successfully