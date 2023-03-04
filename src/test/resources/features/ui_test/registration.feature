
@US01_UI @Medunna_team6 @Wip
Feature: US01_Registration_should_be_available_using SSN_firstname_and_lastname_feature

  Background: set_up
    Given  user navigates to Medunna url
    And user click the registration icon
    And user click registration button


  @US01_TC01
  Scenario Outline: US01_TC01_valid_ssn_feature

    Then  user provides valid ssn "<ssn>" number
    Then user should not see the error message Your SSN is required or Your SSN is invalid

    Examples: ssn
      | ssn         |
      | 123-45-6789 |
      | 234-56-7891 |
      | 020-33-9876 |
      | 150-68-7575 |
      | 654-67-0001 |

  @US01_TC02
  Scenario Outline: US01_TC02_invalid_ssn_feature
    Then  user provides invalid ssn "<ssn>" number
    Then user should see the error message Your SSN is invalid

    Examples: ssn
      | ssn         |
      | 123456789   |
      | 5678-9-1234 |
      | 000         |
      | 666-2-6548  |
      | 11-22-0001  |

  @US01_TC03
  Scenario: US01_TC03_blank_ssn_feature
    Then  user leaves ssn box blank
    Then user should see the error message Your SSN is required.

  @US01_TC04
  Scenario Outline: US01_TC04_valid_firstname_feature
    Then  user provides valid firstname "<firstname>" that contains any chars
    Then user should not see the error message Your FirstName is required.

    Examples: ssn
      | firstname   |
      | John        |
      | 756         |
      | ?/! #       |
      | ,           |
      | 123-45-6789 |

  @US01_TC05
  Scenario: US01_TC05_blank_firstname_feature
    Then  user leaves firstname box blank
    Then user should see the error message Your FirstName is required.

  @US01_TC06
  Scenario Outline: US01_TC06_valid_lastname_feature
    Then  user provides valid lastname "<lastname>" that contains any chars
    Then user should not see the error message Your LastName is required.

    Examples: ssn
      | lastname    |
      | Doe         |
      | 911         |
      | !!          |
      |      (:)    |
      | 987-65-4321 |


  @US01_TC07
  Scenario: US01_TC07_blank_lastname_feature
    Then  user leaves lastname box blank
    Then user should see the error message Your LastName is required.



  @US02_TC01
  Scenario: US02_TC01_username_test
    Then put cursor on username box and click enter
    Then validate that Your username is required note appeared
    Then close the application

  @US02_TC03
  Scenario: US02_TC03_email_test_1
    Then write email without @ and click enter
    Then validate that This field is invalid note appeared
    Then write email with point extension and click enter
    Then validate that This field is invalid note appeared
    Then close the application

  @US02_TC04
  Scenario: US02_TC04_email_test_2
    Then put cursor on email box and click enter
    Then validate that Your email is required note appeared
    Then close the application



