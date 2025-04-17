Feature: Test of basketballengland
  Scenario: Create an account
    Given I am at basketballengland
    When I create an account
    And The user select terms and conditions
    And I am aged over 18 or am a person with parental responsibility
    And I have read, understood and agree to adhere to the Basketball England Code of Ethics and Conduct
    And Confirm and submit btn
    Then The user see the Successful registration