
Feature: Register Flow Test Suite

  Background:
    Given "/index.php?route=account/register&language=en-gb" endpoint is accessed


  Scenario: Register Page can be accessed from Home Page
    Given HomePage is displayed
    When registerLink from Header menu is clicked
    Then the current url contains "route=account/register" keyword

  Scenario: The Account Page URL is opened when the registration is successful
    And registerLink from Header menu is clicked
    When the register form is populated with the random data
    And Continue button is clicked
    Then the current url contains "route=account/success" keyword

  Scenario: User remains on Register page when the continue button is not clicked
    When the register form is populated with the random data
    Then the current url contains "route=account/register" keyword

#  @run
#  Scenario: An error message is displayed when invalid first Name is used for register flow
#    Given "/index.php?route=account/register&language=en-gb" endpoint is accessed
#    When the register form is populated with the following data:
#      | firstName | 1234588888888888888////////////////////////////////////74444444444444444444444444444444444444444 |
#      | lastName  | Chirvas                                                                                          |
#      | email     | cristina.chirvas@gmail.com                                                                       |
#      | password  | Andrei123!                                                                                       |
#    And Continue button is clicked
#    Then the following list of error messages is displayed:
#      | First Name must be between 1 and 32 characters! |
#      | First Name must be between 1 and 32 characters! |

  Scenario Outline: An error message is displayed when invalid <impacted attribute> is used for register flow
    When the register form is populated with the following data:
      | firstName | <firstName>    |
      | lastName  | <lastName>     |
      | email     | <emailData>    |
      | password  | <passwordData> |
    And Continue button is clicked
    Then the following list of error messages is displayed:
      | <impacted attribute> must be between 1 and 32 characters! |
    Examples:
      | impacted attribute | firstName                         | lastName                          | emailData | passwordData |
      | First Name         | 1234588888888888888!@#$%^&*()_+12 | Random                            | Random    | Random       |
      | Last Name          | Cristina                          | 1234588888888888888!@#$%^&*()_+12 | Random    | Random       |
      | First Name         | 1234588888888888888!@#$%^&*()_+12 | Random                            | Random    | Random       |
      | Last Name          | Cristina                          | 1234588888888888888!@#$%^&*()_+12 | Random    | Random       |
      | First Name         | 1234588888888888888!@#$%^&*()_+12 | Random                            | Random    | Random       |
      | Last Name          | Cristina                          | 1234588888888888888!@#$%^&*()_+12 | Random    | Random       |
      | First Name         | 1234588888888888888!@#$%^&*()_+12 | Random                            | Random    | Random       |
      | Last Name          | Cristina                          | 1234588888888888888!@#$%^&*()_+12 | Random    | Random       |
      | First Name         | 1234588888888888888!@#$%^&*()_+12 | Random                            | Random    | Random       |
      | Last Name          | Cristina                          | 1234588888888888888!@#$%^&*()_+12 | Random    | Random       |






