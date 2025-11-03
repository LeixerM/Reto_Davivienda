Feature: Register employee

  As a user of OrangeHRM
  I want to create an employee
  To be able to view the employee

  Background:
  Scenario: Successful register employee
    Given Since the user is on the OrangeHRM page
      |user        |password              |
      |Admin       |admin123              |
    When the user creates the employee
    Then the system should display the employee in the search results