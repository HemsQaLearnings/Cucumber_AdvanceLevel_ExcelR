Feature: Test the pim Module in OrangeHRM using DataTable

  @RegressionTesting
  Scenario: Add new Employee
    Given the user should be in homepage
    When the user click on pim module button
    And the user click on add employee button
    And enter all the required fields
      | FirtName   | hems      |
      | MiddleName | qa        |
      | lastName   | learnings |
      | Employeeid |     12345 |
    Then click on save button
