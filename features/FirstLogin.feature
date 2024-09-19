Feature: login

   
  @FunctionalTesting
  Scenario Outline: Multipledata login
    Given the user is on OrangeHrm Login Page
    When the user enters <username> and <password>
    And the user clicks on login button
    Then the user should be redirected to homepage

    Examples: 
      | username | password |
      | ExcelR   |      145 |
      | Admin    | admin123 |
      | Demo     | demo23   |
#after writing the code you should check the intendation. without intendation it will not work make a note
#how to check : press "Control + F" button in your keyboard
#else select all the script and right click select pretty format
