package com.Librarian.step_definitions;

import com.Librarian.pages.BasePage;
import com.Librarian.pages.BooksPage;
import com.Librarian.pages.LoginPage;
import com.Librarian.utils.BrowserUtils;
import com.Librarian.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class BooksStepDefinitions {
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

    @When("user click and choose {string}")
    public void user_click_and_choose(String string) {
        booksPage.selectShowRecords(string);
    }


    @Then("user verify quantity of books {string}")
    public void user_verify_quantity_of_books(String string) {
        booksPage.verificationQuantity(string);
    }

    @When("user click on Book Categories dropdown menu,select {string}")
    public void user_click_on_book_categories_dropdown_menu_select(String categories) {
        booksPage.bookCategories(categories);
        BrowserUtils.wait(1);
        System.out.println(categories+" is select in the drop down succefully");
    }


    @Then("user should be able to see {string} book on the book categories grid")
    public void user_should_be_able_to_see_book_on_the_book_categories_grid(String categories) {

        List<WebElement> displayedCategories = Driver.getDriver().findElements(By.xpath("//table[@id='tbl_books']//tr/td[5]"));

        for (WebElement each : displayedCategories){
            String displayElement = each.getText();
            if (!displayElement.contains(categories)){
                System.out.println(displayElement + "is different than " + categories);
            }
        }

        String actualCategory = displayedCategories.get(0).getText();

        Assert.assertEquals("The Displayed Category is not displayed, Verification Failed!!!",actualCategory,categories);
        System.out.println("Drama books are displayed!");
        Driver.closeDriver();
    }

    @When("user clicks on add book button")
    public void user_clicks_on_add_book_button() {
       booksPage.addBookBtn();
    }











}
