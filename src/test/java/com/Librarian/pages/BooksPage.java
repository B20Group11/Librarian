package com.Librarian.pages;

import com.Librarian.utils.BrowserUtils;
import com.Librarian.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BooksPage extends BasePage {
    @FindBy(xpath = "//table[@id='tbl_books']//tr[1]/td[1]")
    private WebElement editBookBtn;

    @FindBy(name = "name")
    private WebElement bookNameInputBox;
    @FindBy(name = "isbn")
    private WebElement isbnInputBox;
    @FindBy(name = "year")
    private WebElement yearInputBox;
    @FindBy(xpath = "//input[@placeholder='Author']")
    private WebElement authorInputBox;
    @FindBy(id = "book_group_id")
    private WebElement bookCategoryDropDown;
    @FindBy(id = "description")
    private WebElement descriptionInputBox;




    public void editBookBtn(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
        wait.until(ExpectedConditions.elementToBeClickable(editBookBtn)).click();
        System.out.println("Clicking on 'Edit book' button");
    }


    public void editBookBtn(int number){
       if (number>=1) {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
            WebElement editBookBtnN = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='tbl_books']//tr["+number+"]/td[1]")));
            wait.until(ExpectedConditions.elementToBeClickable(editBookBtnN)).click();
            System.out.println("Clicking on 'Edit book' button line "+number);
        }else {
            System.out.println("Number cannot be 0");
      }
    }

    public void enterBookName(String bookName){
      BrowserUtils.enterText(bookNameInputBox,bookName);
    }

    public void enterIsbn(String isbn){
        BrowserUtils.enterText(isbnInputBox,isbn);
    }

    public void enterYear(String year){
        BrowserUtils.enterText(yearInputBox,year);
    }

    public void enterAuthor(String author){
        BrowserUtils.enterText(authorInputBox,author);
    }

    public void selectBookCategory(String bookCategory){
        BrowserUtils.selectValue(bookCategoryDropDown,bookCategory);
    }

    public void enterDescription(String description){
        BrowserUtils.enterText(descriptionInputBox,description);
    }


}
