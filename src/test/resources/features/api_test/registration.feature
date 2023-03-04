@Api


  Feature: Medunna_Registration_Api

   Background: registration

    Scenario: US02_TC02_username_api_test
      Given user sends post request for registration
      Then user gets registrant info and validates it
      Then user sends get request for validation with SSN


 #   @US02_TC02
 #     Then validate that username is unique


