Feature: Stack Module
  This is to test the links and tryeditor page in the Stack module of DS-Algo online learning portal

  Background: 
    Given User sign in to dsAlgo Portal with username and password fetched for Successful login from Excel file
    When User clicks Get Started button for stack page after reaching home page

  @PresenceOfStackTopic @Login
  Scenario: User should see the topics covered in Stack
    Then User should see the following StackTopics under Topics Covered section in Stack page
      | StackTopics         |
      | Operations in Stack |
      | Implementation      |
      | Applications        |

  @StackTopicLinks @Login
  Scenario: User should see that links are enabled for Stack topics
    Then User should see the following Stack topic listed are in link format
      | StackTopics         |
      | Operations in Stack |
      | Implementation      |
      | Applications        |

  @StackTopics-Navigation @Login
  Scenario Outline: User navigates to each of the StackTopics in Stack page
    When User clicks "<stackTopic>" button in Stack Page
    Then User is redirected to "<stackTopic>" topic in Stack Page

    Examples: 
      | stackTopic          |
      | Operations in Stack |
      | Implementation      |
      | Applications        |

  @StackTopics-PresenceOfTryHereButton @Login
  Scenario Outline: User should see Try Here button under StackTopics in Stack page
    When User clicks "<stackTopic>" button in Stack Page
    Then User should see Try Here button below the content for Stack module - "<stackTopic>" topic 

    Examples: 
      | stackTopic          |
      | Operations in Stack |
      | Implementation      |
      | Applications        |

  @StackTopics-TryEditor @Login
  Scenario Outline: User goes to the try Editor page of StackTopics
    When User clicks Try Here button under Stack module - "<stack Topic>" topic 
    Then User is redirected to TryEditor page with a Run button to test code based on Stack

    Examples: 
      | stackTopic          |
      | Operations in Stack |
      | Implementation      |
      | Applications        |

  @StackTopics-TryEditor-InvalidCodeValidation @Login
  Scenario Outline: Code validation in the tryEditor page of stackTopic
    When User enters invalid code "<CodePattern>" read from excel in the text editor after reaching tryEditor page of Stack module - "<stackTopic>" topic
    Then error message alert is thrown for Stack invalid code

    Examples: 
      | CodePattern  | stackTopic          |
      | invalidCode1 | Operations in Stack |
      | invalidCode1 | Implementation      |
      | invalidCode1 | Applications        |
      | invalidCode2 | Operations in Stack |
      | invalidCode2 | Implementation      |
      | invalidCode2 | Applications        |

  @StackTopics-TryEditor-ValidCodeValidation @Login
  Scenario Outline: Code validation in the tryEditor page of stackTopic
    When User enters valid code "<CodePattern>" read from excel in the text editor after reaching tryEditor page of Stack module - "<stackTopic>" topic
    Then Output is displayed for Stack module - "<stackTopic>" topic valid code

    Examples: 
      | CodePattern | stackTopic          |
      | validCode1  | Operations in Stack |
      | validCode1  | Implementation      |
      | validCode1  | Applications        |
      | validCode2  | Operations in Stack |
      | validCode2  | Implementation      |
      | validCode2  | Applications        |

  @Stack-OtherTopicsNavigation @Login
  Scenario Outline: User navigates to other DataStructure topic pages from Stack page
    When User clicks Data Structures dropdown button in stack page and selects "<otherTopics>" item
    Then User is redirected to "<otherTopics>" page from stack page

    Examples: 
      | otherTopics |
      | Arrays      |
      | Linked List |
      | Queue       |
      | Stack       |
      | Tree        |
      | Graph       |

  @Stack-HomePageNavigation @Login
  Scenario: User navigates to home page from stack page
    When User clicks Numpy Ninja button from stack page
    Then User is redirected to home page from stack page

  @Stack-Logout @Login
  Scenario: User logs out from Stack Page
    When User clicks Signout button from Stack page
    Then User should be navigated from stack page to home page with message seen as "Logged out successfully"
