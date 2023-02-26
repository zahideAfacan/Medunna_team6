@appointment
Feature: appointment

  Background: user_on_the_appointment_page
    Given user patient is on medunna page
    When user patient clicks on the make appointment button


  Scenario Outline: TC01_make_appointment_and_verify

    Then user patient enters the firstname "<firstname>"
    And user patient enters the lastname "<lastname>"
    And user patient enters the ssn "<ssn>"
    And user patient enters the email "<email>"
    And user patient enters the phone "<phone>"
    And user selects a date
    And user patient click send appointment button
    Then user patient verifies  alert

    Examples:test_data
      | firstname | lastname | ssn         | email              | phone        |
      | Hasta     | Iyi      | 123-45-9876 | hastaiyi@gmail.com | 234-456-6789 |


  Scenario: TC02_all_fields_blank

   Then user patient enters the firstname blank " "
    And user patient verifies firstname "Your FirstName is required." warning
    And user patient enters the lastname blank " "
    And user patient verifies lastname "Your LastName is required." warning
    And user patient enters ssn blank " "
    And user patient verifies ssn "Your SSN is required." warning
    And user patient enters email blank " "
    And user patient verifies email "Your email is required." warning
    And user patient enters phone blank " "
    And user patient verifies phone "Phone number is required." warning


   # Then user patient  close the application

  @appointment1
  Scenario: TC03_wrong_ssn

    Then user patient enters the firstname
    Then user patient enters the lastname
    And user patient enters wrong  ssn and verifies
      | 000-45-6789 |
      | 666-45-6789 |
      | 900-45-6789 |
      | 11-145-6789 |

    Then user patient  close the application


