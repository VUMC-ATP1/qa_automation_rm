Feature: Saucedemo checkout
  As a user,
  I want to be able to log in to Saucedemo website, choose a product and buy it,
  So I can test checkout functionality and validate checkout form input fields.

  Scenario: Successfully completed checkout process for a product
    Given I have to navigate to Saucedemo website
    When I login  with "standard_user" and "secret_sauce"
    Then I am successfully logged in to Saucedemo website
    And I add one product to a shopping Cart
    Then I go to shopping Cart page
    When I check that product "Sauce Labs Bolt T-Shirt" is in the Cart
    Then I go to Checkout page
    And I fill and submit the Checkout form with first name "John", last name "Doe", ZIP code "LV-1000"
    When I validate that order has 1 item, "1" quantity of product "Sauce Labs Bolt T-Shirt"
    Then I press the Finish button to complete my order
    And I check that order was successful
    Then I got to Home page

  Scenario Outline: Validate Checkout form input fields
    Given I have to navigate to Saucedemo website
    When I login  with "standard_user" and "secret_sauce"
    Then I am successfully logged in to Saucedemo website
    And I go to shopping Cart page
    And I go to Checkout page
    When I submit Checkout form with "<firstName>", "<lastName>" and "<zipCode>" entered
    Then I validate that empty field is mandatory and correct "<errorMessage>" is displayed
    Examples:
    | firstName | lastName | zipCode | errorMessage |
    | empty | Doe | LV-1000 | Error: First Name is required |
    | John | empty | LV-1000 | Error: Last Name is required |
    | John | Doe | empty | Error: Postal Code is required |