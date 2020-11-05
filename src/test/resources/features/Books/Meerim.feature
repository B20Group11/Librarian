@LibraryMeerim
Feature: User should be able to maintain the books by using Books module


  Background: Login into the library application
    Given user is on the login page
    When user logs in
    And user navigates to "Books"





  @LibraryMeerim @ACMeerim
  Scenario:As a user I should be able to select a category of the book by using the dropdown menu
    When user click on Book Categories dropdown menu,select "Drama"
    Then user should be able to see "Drama" book on the book categories grid
