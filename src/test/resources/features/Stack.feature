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

  @StackTopics-PresenceOfTryHereButton
  Scenario Outline: User should see Try Here button under StackTopics in Stack page
    When User clicks "<stackTopic>" button in Stack Page
    Then User should see Try Here button below the content for "<stackTopic>" topic

    Examples: 
      | stackTopic          |
      | Operations in Stack |
      | Implementation      |
      | Applications        |

  @StackTopics-TryEditor
  Scenario Outline: User goes to the try Editor page of StackTopics
    When User clicks Try Here button under "<stack Topic>"
    Then User is redirected to TryEditor page with a Run button to test

    Examples: 
      | stackTopic          |
      | Operations in Stack |
      | Implementation      |
      | Applications        |

  @StackTopics-TryEditor-InvalidCodeValidation @Login
  Scenario Outline: Code validation in the tryEditor page of stackTopic
    When User enters invalid code "<CodePattern>" read from excel in the text editor after reaching tryEditor page of "<stackTopic>"
    Then error message alert is thrown

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
    When User enters valid code "<CodePattern>" read from excel in the text editor after reaching tryEditor page of "<stackTopic>"
    Then Output is displayed for "<stackTopic>" valid code

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

  @Stack-HomePageNavigation @Login
  Scenario: User navigates to home page from stack page
    When User clicks Numpy Ninja button from stack page
    Then User is redirected to home page

  @Stack-Logout @Login
  Scenario: User logs out from Stack Page
    When User clicks Signout button from Stack page
    Then User should be navigated to home page with message seen as "Logged out successfully"
