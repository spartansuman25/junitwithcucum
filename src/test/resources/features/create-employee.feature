Feature: Create Employee

  Scenario: WITH ALL REQUIRED FIELDS IS SUCCESSFUL

    Given user wants to create an employee with the following attributes
      | id  | name  | address | age |  |  |  |
      | 100 | suman | nepal   | 34  |  |  |  |


    When user saves the new employee 'WITH ALL REQUIRED FIELDS'
    Then the save 'IS SUCCESSFUL'