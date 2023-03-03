@US_005
Feature: US_005
  @US_005_TC01
  Scenario: US_005_TC01

    Given go to medunna home page
    When click on sign in icon
    When enter patient username
    When enter patient password
    When click sign in button
    When verify the application login is successful
    Then close the application

    @US_005_TC02
  Scenario: US_005_TC02
    Given go to medunna home page
    When click on sign in icon
    When enter patient username
    When enter patient password
    When verify rememberme and click
    When click sign in button
    When click sign out button
    When verify that the remember me function is working
    Then close the application

    @US_005_TC03
  Scenario: US_005_TC03
    Given go to medunna home page
    When click on sign in icon
    When verify cancel button
    When verify register option
    Then close the application

