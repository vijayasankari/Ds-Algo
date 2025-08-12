Feature: Stack Module
  This is to test the links and tryeditor page in the Stack module of DS-Algo online learning portal

  Background: 
    Given User sign in to dsAlgo Portal
    And User navigates to Stack page using the Getting Started button

  @Stack-StackTopics-Navigation
  Scenario Outline: User navigates to <stackTopic> topic in Stack page
    When User clicks <stackTopic> button in Stack Page
    Then User is redirected to <stackTopic> topic in Stack Page

    Examples: 
      | stackTopic          |
      | Operations in Stack |
      | Implementation      |
      | Applications        |

  @StackTopics-TryHereButton
  Scenario Outline: User sees Try Here button under <stackTopic> topic in Stack page
    When User clicks <stackTopic> button in Stack Page
    Then User sees Try Here button below the content for <stackTopic> topic

    Examples: 
      | stackTopic          |
      | Operations in Stack |
      | Implementation      |
      | Applications        |

  @StackTopics-TryEditor
  Scenario Outline: User goes to the try Editor page of <stackTopic>
    When User clicks <stackTopic> button in Stack Page
    And clicks Try Here button under <stackTopic> topic content
    Then User is redirected to TryEditor page of <stackTopic> with a Run button to test

    Examples: 
      | stackTopic          |
      | Operations in Stack |
      | Implementation      |
      | Applications        |

  @StackTopics-TryEditor-CodeValidation
  Scenario Outline: Code validation in the tryEditor page of  Implementation
    When User clicks <stackTopic> button in Stack Page
    And clicks Try Here button under <stackTopic> topic content
    And enters <codeType> in the try editor page for <stackTopic> and clicks on Run button
    Then <status> for <stackTopic>-<codeType> type is displayed

    Examples: 
      | stackTopic          | codeType     | status        |
      | Operations in Stack | invalid code | Error message |
      | Operations in Stack | valid code   | Output        |
      | Implementation      | invalid code | Error message |
      | Implementation      | valid code   | Output        |
      | Applications        | invalid code | Error message |
      | Applications        | valid code   | Output        |

  @Stack-OtherTopicsNavigation
  Scenario Outline: User navigates to <otherTopics> pages from Stack page
    When User clicks Data Structures dropdown button and selects <otherTopics> item
    Then User is redirected to <otherTopics> page

    Examples: 
      | otherTopics |
      | Arrays      |
      | Linked List |
      | Queue       |
      | Stack       |
      | Tree        |
      | Graph       |

  @Stack-HomePageNavigation
  Scenario: User navigates to home page from stack page
    When User clicks Numpy Ninja button from stack page
    Then User is redirected to home page

  @Stack-Logout
  Scenario: User logs out from Stack Page
    When User clicks Signout button from Stack page
    Then User should be navigated to home page
    And User should see the message "Logged out successfully"
