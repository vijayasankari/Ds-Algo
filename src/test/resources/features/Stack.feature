Feature: Stack Module
  This is to test the links and tryeditor page in the Stack module of DS-Algo online learning portal

  Background: 
    Given User sign in to dsAlgo Portal
    And User navigates to Stack page using the Getting Started button

  @Stack-PresenceOfStackTopicLinks
  Scenario Outline: User sees links enabled for Stack topics in Stack page
    When User looks for StackTopics under Topics Covered section in Stack page
      | StackTopics         |
      | Operations in Stack |
      | Implementation      |
      | Applications        |
    Then User sees the following Stack topic listed are in link format
      | StackTopics         |
      | Operations in Stack |
      | Implementation      |
      | Applications        |

  @Stack-StackTopics-Navigation
  Scenario Outline: User navigates to each of the StackTopics in Stack page
    When User clicks "<stackTopic>" button in Stack Page
    Then User is redirected to "<stackTopic>" topic in Stack Page

    Examples: 
      | stackTopic          |
      | Operations in Stack |
      | Implementation      |
      | Applications        |

  @StackTopics-PresenceOfTryHereButton
  Scenario Outline: User sees Try Here button under StackTopics in Stack page
    When User clicks "<stackTopic>" button in Stack Page
    Then User sees Try Here button below the content for "<stackTopic>" topic

    Examples: 
      | stackTopic          |
      | Operations in Stack |
      | Implementation      |
      | Applications        |

  @StackTopics-TryEditor
  Scenario Outline: User goes to the try Editor page of StackTopics
    When User clicks "<stackTopic>" button in Stack Page
    And clicks Try Here button under "<stackTopic>" topic content
    Then User is redirected to TryEditor page with a Run button to test

    Examples: 
      | stackTopic          |
      | Operations in Stack |
      | Implementation      |
      | Applications        |

  @StackTopics-TryEditor-InvalidCodeValidation
  Scenario Outline: Code validation in the tryEditor page of  Implementation
    When User clicks "<stackTopic>" button in Stack Page
    And clicks Try Here button under "<stackTopic>" topic content
    And enters invalid code read from excel in the try editor page and clicks on Run button
    Then error message alert is thrown

    Examples: 
      | stackTopic          |
      | Operations in Stack |
      | Implementation      |
      | Applications        |

  @StackTopics-TryEditor-ValidCodeValidation
  Scenario Outline: Code validation in the tryEditor page of  Implementation
    When User clicks "<stackTopic>" button in Stack Page
    And clicks Try Here button under "<stackTopic>" topic content
    And enters valid code read from excel in the try editor page and clicks on Run button
    Then Output is displayed for "<stackTopic>" valid code

    Examples: 
      | stackTopic          |
      | Operations in Stack |
      | Implementation      |
      | Applications        |

 
  @Stack-OtherTopicsNavigation
  Scenario Outline: User navigates to other DataStructure topic pages from Stack page
    When User clicks Data Structures dropdown button and selects "<otherTopics>" item
    Then User is redirected to "<otherTopics>" page

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
