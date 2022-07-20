Feature: Verify if user can change the password entering incorrect email

  Scenario Outline: Restore password with invalid email test

    Given Click on Guest DropDown icon
    When enterExtendedSearchButton
    And Fill data in field <ages> check if the <expected> is shown

    Examples:
      |ages              |expected     |
      |1,2,18,20         |2,2,18,18    |
