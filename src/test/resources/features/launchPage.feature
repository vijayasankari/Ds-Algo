@LaunchPageValidation
Feature: User accessibility verification of DsAlgo URL

  Background: 
    Given User accesses DsAlgo URL

  @LaunchPageVerification
  Scenario: Verify user able to navigate to Home page successfully
    When Get Started button is clicked
    Then user should be able to navigate to Home page
