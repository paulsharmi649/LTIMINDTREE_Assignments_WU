Feature: Login to OrangeHRM site and validations

  Background:
    Given User navigated to the OrangeHRM URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When User specify Username as "Admin" and Password as "admin123"
    And Click on login  button

  Scenario: Recruitment search and go to vacancies
    Given User Clicks on the Recruitment button
    When User Clicks on Vacancies
    And  Search with "Associate IT Manager" and records should be displayed
    Then  Logout







