@US_014
Feature: US_014
  @US_011
    Scenario: User (doctor) can see their appointments list and time slots on My Appointments
    Given go to medunna home page
    When click on sign in icon
    When enter doctor username
    When enter doctor password
    When click sign in button
    When click on MY PAGE icon and My Appointments button
    Then close the application

  @US_012
  Scenario: User (doctor) should be able to populate info in 'Create or edit an appointment'
    Given go to medunna home page
    When click on sign in icon
    When enter doctor username
    When enter doctor password
    When click sign in button
    When click on MY PAGE icon and My Appointments button and edit button
    When click sign out button

    And go to medunna home page
    When click on sign in icon
    When enter staff username
    When enter staff password
    When click sign in button
    When Click on MY PAGE icon and click on Search Patients and Enter the Patient SSN
    When click on Show Appointments button and Click on Edit button
    Then steff change status of appointment
    Then staff click save button

  @US_013
    Scenario: US_13
    Given go to medunna home page
    When click on sign in icon
    When enter doctor username
    When enter doctor password
    When click sign in button
    When click on MY PAGE icon and My Appointments button and edit button
    When click on Request A Test button
    Then verify that have Glucose, Urea, Creatinine, Sodium as checkmark options
    When click on urea checkbox and save button
    When click sign out button


  @US_014_TC01
  Scenario: US_014_TC01
    Given go to medunna home page
    When click on sign in icon
    When enter doctor username
    When enter doctor password
    When click sign in button
    When click on MY PAGE icon and My Appointments button and edit button
    When click on Request A Test button and urea checkbox and save button
    When click sign out button

    And go to medunna home page
    When click on sign in icon
    When enter staff username
    When enter staff password
    When click sign in button
    When Click on MY PAGE icon and click on Search Patients and Enter the Patient SSN
    When click on Show Appointments button and Click on Show Tests button and click on View Results button
    When Click on Edit button and enter a Result and click on Save
    When click sign out button

    And go to medunna home page
    When click on sign in icon
    When enter doctor username
    When enter doctor password
    When click sign in button
    When click on MY PAGE icon and My Appointments button and edit button
    When click on Show Test Results button  and click on View Results button
    When Verify to doctor can see all test information
    Then close the application

  @US_014_TC02
  Scenario: US_014_TC02
    Given go to medunna home page
    When click on sign in icon
    When enter doctor username
    When enter doctor password
    When click sign in button
    When click on MY PAGE icon and My Appointments button and edit button
    When click on Request Inpatient and get appointment id
    When click sign out button

    And go to medunna home page
    When click on sign in icon
    When enter staff username
    When enter staff password
    When click sign in button
    When Click on MY PAGE icon and click on Inpatient button
    When verify to appointment id
    Then close the application




