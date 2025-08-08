


Feature: Verify Linked List Pages in Array Module on DSAlgo Portal

    
Background: 
    Given User is on the login page
    When User clicks on Linked List from dropdown after logged in application
    

@Links_LinkedListpages
Scenario Outline: Verify the user is able to navigate to Linked List topics page
    Given User is in the Linked List page
     When user clicks "<LL_Topics>"
    Then user should be redirected to  "<LL_Topics>" page
      Examples:
    |LL_Topics |
    |Introduction|
    |Creating Linked LIst|
    |Types of Linked List|
    |Implement Linked List in Python|
    |Traversal|
    |Insertion|
    |Deletion|
    |NumpyNinja|
            
    

@TryEditor_LinkedListTopic
Scenario Outline: Verify the presence of Try Here button in LinkedList topics
    Given User is in the Linked List page
     When user clicks "<LL_Topics>"
    Then user should be see Try Here button below the content
     Examples:
  		|LL_Topics |
    |Introduction|
    |Creating Linked LIst|
    |Types of Linked List|
    |Implement Linked List in Python|
    |Traversal|
    |Insertion|
    |Deletion|
    
@LinkedlistPractiseQuestions  
Scenario: Verify that user is able to navigate to Practice Questions page
	Given User is in the Linked List page
    When user clicks on Introduction link
    And user clicks the Practice Questions link
    Then user should be redirected to Practice Questions page 

 @Links_LinkedListdropdown
Scenario Outline: Verify the user is able to navigate to dropdown topics page
    Given User is in the Linked List page
     When user clicks "<LLDropdown_Topics>"
    Then user should be redirected to  "<LLDropdown_Topics>" page
      Examples:
    | LLDropdown_Topics|
    |Array|
    |Stack|
    |Queue|
    |Tree|   
    |Graph|   
   
 @RunValidLinkedList_Links
Scenario Outline: Verify the output of "<LLTopics>"
    Given User is in the Linked List page
    When user clicks  on "<LLTopics>" page
    And user clicks on Try editor
    And user runs the valid code after reaching Try Editor page with a Run button to test
    Then user should see "<ExpectedoutPut>"

    Examples:
     |LLTopics |
    |Introduction|
    |Creating Linked LIst|
    |Types of Linked List|
    |Implement Linked List in Python|
    |Traversal|
    |Insertion|
    |Deletion|
    
@RunInValidLinkedList_Links
Scenario Outline: Verify the output of "LLTopics>"
   Given User is in the Linked List page
    When user clicks  on "<LLTopics>" page
    And user clicks on Try editor
		And user runs the in valid code after reaching Try Editor page with a Run button to test
    Then user should see "<ExpectedoutPut>"

    Examples:
        |LLTopics |
    |Introduction|
    |Creating Linked LIst|
    |Types of Linked List|
    |Implement Linked List in Python|
    |Traversal|
    |Insertion|
    |Deletion|   
  
 @Logout
 
 Scenario:: Verify that user able to logout from the Linked List data structure

   Given User is in the Linked List page
   When  user clicks signout button
   Then user should signout successfully
    
    



	

 




    

 
    




    
