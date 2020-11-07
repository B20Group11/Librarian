@Book_page
Feature: User should be able to maintain the books by using Books module

  Background: Login into the library application
    Given user is on the login page
    When user logs in
    And user navigates to "Books"

  @AC2 @Alex
  Scenario: 1. edit some book
    And user clicks on edit book button
    When user edit book information
      | Book Name      | The hunger games : the ultimate quiz book |
      | ISBN           | 9781781662717 |
      | Year           | 2014 |
      | Autor          | Goldstein, Jack |
      | Book Category  | FICTION |
      | Description    | How much do you know about the three books that make up the Hunger Games series? Prove your knowledge with this fascinating quiz book containing 200 questions (and answers!) to test the knowledge of any Hunger Games fan. |
    And user clicks on save changes button

  @AC3 @Meerim
  Scenario:As a user I should be able to select a category of the book by using the dropdown menu

    When user click on Book Categories dropdown menu,select "Drama"
    Then user should be able to see "Drama" book on the book categories grid

  @AC4 @Radoje
  Scenario: 1. search book by "Author and Name"
    When user put information on search box
      | Book Name      | The hunger games : the ultimate quiz book |
      | Author         | Goldstein, Jack                           |


  @AC5 @Ziiadin
  Scenario Outline: show records
    When user click and choose "<role>"
    Then user verify quantity of books "<role>"
    Examples: data set
      |role|
      |5   |
      |10  |
      |15  |
      |50  |
      |100 |
      |200 |
      |500 |
