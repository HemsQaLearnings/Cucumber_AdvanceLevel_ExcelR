Feature: Login Data Driven with Excel

  @FunctionalTesting
  Scenario Outline: Login Data Driven Excel
    Given the user is on OrangeHrm Login Page
    Then the user should be redirected to the Home Page by passing email and password with excel row "<row_index>"

    Examples: 
      | row_index |
      |         1 |
      |         2 |
      |         3 |
      |         4 |
      |         5 |
