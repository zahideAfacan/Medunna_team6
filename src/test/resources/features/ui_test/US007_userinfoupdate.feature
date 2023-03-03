@userinfo
Feature: userinfoupdate

Background: user_on_the_appointment_page
Given user patient is on medunna page
@userinfocheck
Scenario: TC01_There should be user info being populated
Given user admin clicks account menu button
When user admin clicks sign in button
Then user admin enters credentials
| username    | password |
| AdminTeam06 | Team06+  |
Then user admin clicks administration and usermanagement
  And user admin clicks edit button
And user admin sends updated firstname "firstname" and "lastname"
  And user admin selects language
  And user admin selects roles
  Then user admin clicks save button
  And user admin verifies popup message "popUpMessage"


