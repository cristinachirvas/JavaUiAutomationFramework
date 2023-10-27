Feature: Register Flow Test Suite

  Scenario: Register Page can be accessed from Home Page
    Given "string" endpoint is accessed
    When registerLink from Header menu is clicked
    Then the current url contains "route=account/register" keyword

  Scenario: The Account Page URL is opened when the registration is successful
    Given "/index.php?route=account/register&language=en-gb" endpoint is accessed
    And registerLink from Header menu is clicked
    When the register form is populated with the random data
    And Continue button is clicked
    Then the current url contains "route=account/success" keyword

  Scenario: User remains on Register page when the continue button is not clicked
    Given "/index.php?route=account/register&language=en-gb" endpoint is accessed
    When the register form is populated with the random data
    Then the current url contains "route=account/register" keyword
