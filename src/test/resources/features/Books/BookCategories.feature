
Feature: User should be able to maintain the books by using Books module

  @book_Categories
  Scenario:Book Categories
    Given user is on the login page
    When user logs in
    And user navigates to "Books"
    When user click on Book Categories dropdown menu,select "Drama"
    Then user should be able to see "Drama" book on the book categories grid
