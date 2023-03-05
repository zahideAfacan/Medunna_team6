@US_015
Feature:
  Background:
    Given go to medunna home page
    When click on sign in icon
    Then enter doctor username
    And enter doctor password
    And click sign in button


  @US_015_TC_01
Scenario: US_015_TC_01
    And  click on MY PAGE icon and My Inpatients button
    Then verify the titles
    And user doctor click sign out button
    @US_015_TC_02
  Scenario: US_015_TC_02
  And  click on MY PAGE icon and My Inpatients button
   Then user doctor clicks on patient edit button
   And  user doctor updates the patient's status
   And user doctor  updates room status
      And user doctor click save button
