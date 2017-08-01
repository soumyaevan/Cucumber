Feature: LoginFeature
  This feature deals with login functionality of the application

  @Successful_Login
  Scenario: Login with correct username and password
    Given I navigate to the login page
    And I enter credentials
      | username | password   |
      | soumya   | nopass     |
    And I click on the login button
    Then I should see the userform page

    @Unsuccessful_Login
  Scenario: Login with correct username and password Fail
    Given I navigate to the login page
    And I enter credentials
      | username | password   |
      | soumya   | nopass     |
    And I click on the login button
    Then I should see the userform page wrongly