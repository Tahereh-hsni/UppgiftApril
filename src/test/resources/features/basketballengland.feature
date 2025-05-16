Feature: Test of basketballengland
  Scenario: Create an account
    Given I am at basketballengland
    When I create an account
    And The user select terms and conditions
    And I am aged over 18 or am a person with parental responsibility
    And I have read, understood and agree to adhere to the Basketball England Code of Ethics and Conduct
    And Confirm and submit btn
    Then The user see the Successful registration

  Scenario: Create an account without last name
    Given I am at basketballengland
    When I try to create an account without last name
    And The user select terms and conditions
    And I am aged over 18 or am a person with parental responsibility
    And I have read, understood and agree to adhere to the Basketball England Code of Ethics and Conduct
    And Confirm and submit btn

   Scenario: Create an account without confirm password
     Given I am at basketballengland
     When I create an account without confrim pass
     And The user select terms and conditions
     And I am aged over 18 or am a person with parental responsibility
     And I have read, understood and agree to adhere to the Basketball England Code of Ethics and Conduct
     And Confirm and submit btn
     Then The user sees a message that password confirmation does not match

  Scenario: Create an account without accepting terms and conditions
    Given I am at basketballengland
    When I create an account without accepting terms and conditions
    And I am aged over 18 or am a person with parental responsibility
    And I have read, understood and agree to adhere to the Basketball England Code of Ethics and Conduct
    Then The user sees a message that terms and conditions must be accepted
