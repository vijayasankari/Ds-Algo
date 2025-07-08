
Feature: Queue
  This is to test Queue pages in the DS-Algo online learning portal
  User will be able to run and test Python code for Queue DataStructure
  
  Background:
  Given The user sign in to dsAlgo Portal 
  And navigates to Queue page using the Getting Started button
  
  @QueueTopics @Implementation-of-Queue-in-Python @Implementation-using-collections.deque @Implementation-using-array @Queue-Operations
  Scenario Outline: The user navigates to <queueTopic> page
    Given The Queue page is displayed
    When The user clicks <queueTopic> button
    Then The user is redirected to <queueTopic> page
    
    Examples: 
      |queueTopic|
      |Implementation of Queue in Python|
			|Implementation using collections.deque|
			|Implementation using array|
			|Queue Operations|
    
  @QueueTopics-TryEditor  @QueueTopics-PracticeQuestions
  Scenario Outline: The user goes to the try Editor page of <queueTopic>
  	Given The <queueTopic> page is displayed
  	When The user clicks <button> in <queueTopic> page
  	Then The user is redirected to <page> of <queueTopic>
  	
  	Examples: 
			|queueTopic|button|page|
      |Implementation of Queue in Python|Try Here|TryEditor|
			|Implementation using collections.deque|Try Here|TryEditor|
			|Implementation using array|Try Here|TryEditor|
			|Queue Operations|Try Here|TryEditor|
			|Implementation of Queue in Python|Practice Questions|Practice|
			|Implementation using collections.deque|Practice Questions|Practice|
			|Implementation using array|Practice Questions|Practice|
			|Queue Operations|Practice Questions|Practice|
  	
  @QueueTopics-TryEditor-CodeValidation
  Scenario Outline: Code validation in the tryEditor page of <queueTopic>
  	Given The tryEditor page of <queueTopic> is shown
  	When The user enters <code> in the text editor section for <queueTopic> and clicks Run button
  	Then The <status> for <queueTopic> code is displayed
  	
   Examples:
   |queueTopic|code|status|
   |Implementation of Queue in Python|invalid code|error message|
   |Implementation of Queue in Python|valid code|output|
   |Implementation using collections.deque|invalid code|error message|
   |Implementation using collections.deque|valid code|output|
   |Implementation using array|invalid code|error message|
   |Implementation using array|valid code|output|
   |Queue Operations|invalid code|error message|
   |Queue Operations|valid code|output|
     
          
   @QueueTopics-stackotherTopics-Navigation
   Scenario Outline: The user navigates to <othertopic> page from <queueTopic> page
    Given <queueTopic> page is displayed
    When The user clicks <othertopic> button from <queueTopic> page
    Then The user is redirected to <othertopic> page from <queueTopic> page
   
   Examples:
    |queueTopic|othertopic|
    |Implementation of Queue in Python|Implementation using collections.deque|
    |Implementation of Queue in Python|Implementation using array|
    |Implementation of Queue in Python|Queue Operations|
		|Implementation using collections.deque|Implementation of Queue in Python|
		|Implementation using collections.deque|Implementation using array|
		|Implementation using collections.deque|Queue Operations|
		|Implementation using array|Implementation of Queue in Python|
		|Implementation using array|Implementation using collections.deque|
		|Implementation using array|Queue Operations|
		|Queue Operations|Implementation of Queue in Python|
		|Queue Operations|Implementation using collections.deque|
		|Queue Operations|Implementation using array|
    
    #Navigation to Home page, other DS pages from Queue, QueueTopics and 
    #Queue Practice Question pages can be given through Hooks ?