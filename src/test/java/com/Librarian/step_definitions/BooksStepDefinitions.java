package com.Librarian.step_definitions;

import com.Librarian.pages.BasePage;
import com.Librarian.pages.BooksPage;
import com.Librarian.pages.LoginPage;
import com.Librarian.utils.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.Map;

public class BooksStepDefinitions {
    LoginPage loginPage = new LoginPage();
    BooksPage booksPage = new BooksPage();

    @Given("user navigates to {string}")
    public void user_navigates_to(String module) {
        booksPage.navigateTo(module);
    }

    @Given("user clicks on edit book button")
    public void user_clicks_on_edit_book_button() {
        booksPage.editBookBtn(2);
    }

    @When("user edit book information")
    public void user_edit_book_information(Map<String, String> dataTable) {
        dataTable.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));

        String bookName = dataTable.get("Book Name");
        String isbn = dataTable.get("ISBN");
        String year = dataTable.get("Year");
        String author = dataTable.get("Author");
        String description = dataTable.get("Description");

        String bookCategory = dataTable.get("Book Category");

        System.out.println("Book Name: " + bookName);
        System.out.println("ISBN: " + isbn);
        System.out.println("Year: " + year);
        System.out.println("Author: " + author);
        System.out.println("Description: " + description);
        System.out.println("Book Category: " + bookCategory);

        booksPage.enterBookName(bookName);
        booksPage.enterIsbn(isbn);
        booksPage.enterYear(year);
        booksPage.enterAuthor(author);
        booksPage.enterDescription(description);
        booksPage.selectBookCategory(bookCategory);

    }

    @When("user clicks on save changes button")
    public void user_clicks_on_save_changes_button() {
        booksPage.clickSaveChanges();
    }










}
