
Feature: Stack
  This is to test Stack pages in the DS-Algo online learning portal
  User will be able to run and test Python code for Stack DataStructure
  
  Background:
  Given The user sign in to dsAlgo Portal
  And navigates to Stack page using the Getting Started button
  
  @StackTopics @OperationsInStack @Implementation @Applications
  Scenario Outline: The user navigates to <stackTopic> page
    Given The Stack page is displayed
    When The user clicks <stackTopic> button
    Then The user is redirected to <stackTopic> page
    
    Examples: 
      |stackTopic|
      |Operations in Stack|
      |Implementation|
      |Applications|
    
  @StackTopics-TryEditor
  Scenario Outline: The user goes to the try Editor page of <stackTopic>
  	Given The <stackTopic> page is displayed
  	When The user clicks Try Here button in <stackTopic> page
  	Then The user is redirected to TryEditor page of <stackTopic> with a Run button to test
  	
  	Examples: 
      |stackTopic|
      |Operations in Stack|
      |Implementation|
      |Applications|
  	
  @StackTopics-TryEditor-CodeValidation
  Scenario Outline: Code validation in the tryEditor page of <stackTopic>
  	Given The tryEditor page of <stackTopic> is shown
  	When The user enters <code> in the text editor section for <stackTopic> and clicks Run button
  	Then The <status> for <stackTopic> code is displayed
  	
   Examples:
   |stackTopic|code|status|
   |Operations in Stack|invalid code|error message|
   |Operations in Stack|valid code|output|
   |Implementation|invalid code|error message|
   |Implementation|valid code|output|
   |Applications|invalid code|error message|
   |Applications|valid code|output|
     
   @StackTopics-PracticeQuestions
    Scenario Outline: The user goes to Practice Questions page for <stackTopic>
     Given <stackTopic> page is displayed
     When The user clicks Practice Questions from <stackTopic> page
     Then The user is redirected to practice page for <stackTopic>
     
     Examples:
      |stackTopic|
      |Operations in Stack|
      |Implementation|
      |Applications|
       
   @StackTopics-stackotherTopics-Navigation
   Scenario Outline: The user navigates to <othertopic> page from <stackTopic> page
    Given <stackTopic> page is displayed
    When The user clicks <othertopic> button  from <stackTopic> page
    Then The user is redirected to <othertopic> page from <stackTopic> page
   
   Examples:
    |stackTopic|othertopic|
    |Operations in Stack|Implementation|
    |Operations in Stack|Applications|
    |Implementation|Operations in Stack|
    |Implementation|Applications|
    |Applications|Operations in Stack|
    |Applications|Implementation|
    
    #Navigation to Home page, other DS pages from Stack, StackTopics and 
    #Stack Practice Question pages can be given through Hooks ?
     
   
   
   
  
