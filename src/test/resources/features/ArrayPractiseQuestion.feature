


Feature: Verify Array Pages in Array Module on DSAlgo Portal

    
Background: 
    Given User is on the login page
    When User clicks on Array from dropdown after logged in application
    

@Links_Arraypages
Scenario Outline: Verify the user is able to navigate to array topics page
    Given User is in the Array page
     When user clicks "<Array_Topics>"
    Then user should be redirected to  "<Array_Topics>" page
      Examples:
    | Array_Topics |
    |Arrays in Python|
    |Arrays Using List|
    |Basic Operations in Lists|
    |Applications of Array|
    |NumpyNinja|
            
    

@TryEditor_ArrayTopic
Scenario Outline: Verify the presence of Try Here button in array topics
    Given User is in the Array page
     When user clicks "<Array_Topics>"
    Then user should be see Try Here button below the content
     Examples:
    | Array_Topics |
    |Arrays in Python|
    |Arrays Using List|
    |Basic Operations in Lists|
    |Applications of Array|
    
    
 

 @Links_Arraydropdown
Scenario Outline: Verify the user is able to navigate to dropdown topics page
    Given User is in the Array page
     When user clicks "<Dropdown_Topics>"
    Then user should be redirected to  "<Dropdown_Topics>" page
      Examples:
    | Dropdown_Topics|
    |Linked List|
    |Stack|
    |Queue|
    |Tree|   
    |Graph|   
   
 @RunValidArray_Links
Scenario Outline: Verify the output of "<ArrayTopics>"
    Given User is in the Array page
    When user clicks  on "<ArrayTopics>" page
    And user clicks on Try editor
    And user runs the valid code after reaching Try Editor page with a Run button to test
    Then user should see "<ExpectedoutPut>"

    Examples:
        | ArrayTopics                | ExpectedOutput |
        | Arrays in Python           |                |
        | Arrays Using List          |                |
        | Basic Operations in Lists  |                |
        | Applications of Array      |                |

@RunInValidArray_Links
Scenario Outline: Verify the output of "<ArrayTopics>"
   Given User is in the Array page
    When user clicks  on "<ArrayTopics>" page
    And user clicks on Try editor
		And user runs the in valid code after reaching Try Editor page with a Run button to test
    Then user should see "<ExpectedoutPut>"

    Examples:
        | ArrayTopics                | ExpectedOutput |
        | Arrays in Python           |                |
        | Arrays Using List          |                |
        | Basic Operations in Lists  |                |
        | Applications of Array      |                |    
  
 @Logout
 
 Scenario:: Verify that user able to logout from the Array data structure

   Given User is in the Array page
   When  user clicks signout button
   Then user should signout successfully
    
    



	

 




    

 
    




    
