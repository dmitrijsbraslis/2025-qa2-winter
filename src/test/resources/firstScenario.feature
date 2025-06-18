Feature: User data modification
  Scenario: First name modification
    Given user first name: "Dmitry"
    And user last name: "Tester"
    And user e-mail: "test@test.lv"

    When we are changing first name to "Dima"

    Then first name is: "Dima"
    And last name is not changed