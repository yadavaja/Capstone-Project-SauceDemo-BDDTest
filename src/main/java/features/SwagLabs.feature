@RegressionTest
Feature: Sauce Demo - Swag Labs Site

  Scenario: Verify Ajax Loader popup
    Given Navigate to "https://www.saucedemo.com/"
    Then Verify Title of the Application
    Then Login to the Sauce demo portal using valid credential
    And Verify that able to login to the portal successfully
    Then Add Multiple Items to the Cart
    And Click on CheckOut and Provide Information
    Then Click on Finish
    And Verify the message should be "Thank you for your order!"
    Then Close the browser