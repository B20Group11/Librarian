Feature:  As Librarian, I want to be able to edit book

  @show_records
  Scenario Outline: show records
    Given user is on the login page
    When user logs in
    And user navigates to "Books"
    When user click and choose "<role>"
    Then user verify quantity of books "<role>"
     Examples: data set
    |role|
  #  |5   |
  #  |10  |
  #  |15  |
    |50  |
  #  |100 |
  #  |200 |
  #  |500 |
