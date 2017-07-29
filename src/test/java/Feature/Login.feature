Feature: LoginFeature
  This feature deals with login functionality of the application

  Scenario: Login with correct username and password
    Given I navigate to the login page
    And I enter the user's email:Admin
    And I enter credentials
      | username | password   |
      | soumya   | nopass     |
      | abcd     | nopassword |
    And I click on the login button
    And The number of digit in salary:21000
    And I want to see the step in cucumber java-8
    Then I should see the userform page

  Scenario Outline: Login with correct username and password using example
    Given I navigate to the login page
    And I enter <username> and <password>
    And I click on the login button
    Then I should see the userform page
    Examples:
      | username | password   |
      | soumya   | nopass     |
      | abcd     | nopassword |
      | pranoy   | das        |