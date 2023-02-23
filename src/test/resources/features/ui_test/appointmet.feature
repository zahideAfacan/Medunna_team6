@appointment
Feature: appointment

Scenario Outline: TC01_make_appointment_and_verify
  Given user patient is on "https://www.medunna.com/"
  Then user patient clicks on the make appointment button
  And user patient scrolls down the page
  And user patient enters the firstname "<firstname>"
  And user patient enters the lastname "<lastname>"
  And user patient enters ssn "<SSN>"
  And user patient enters email  "<email>"
  And user patient enters phone "<phonenumber>"
  And user patient enters date
  And user patient click make appointment button
  And user patient verifies "Appointment registration saved!" alert
  Then user patient  close the application
  Examples:
    | firstname | lastname | SSN         | email                 | phonenumber  |
    | Ali       | Veli     | 345-66-7124 | aliveli4950@gmail.com | 567-456-3456 |