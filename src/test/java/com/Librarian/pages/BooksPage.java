package com.Librarian.pages;
import com.Librarian.utils.BrowserUtils;
import com.Librarian.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
public class BooksPage extends BasePage {

    //Alex
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

    //Ziiadin
    @FindBy(xpath = "//select[@class='form-control input-sm input-xsmall input-inline']")
    private WebElement showRecordsDropDown;
    @FindBy(xpath = "//tbody//tr")
    private List<WebElement> links;
    @FindBy(id = "tbl_books_info")
    private WebElement confirmationNumberMessage;

    //Meerim
    @FindBy(id = "book_categories")
    private WebElement bookCategoriesDropDown;
    @FindBy(xpath = "//table[@id='tbl_books']//tr/td[5]")
    private List<WebElement> displayCategories;

    public void editBookBtn() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(editBookBtn)).click();
        System.out.println("Clicking on 'Edit book' button");
    }

    public void editBookBtn(int number) {
        if (number >= 1) {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
            WebElement editBookBtnN = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='tbl_books']//tr[" + number + "]/td[1]")));
            wait.until(ExpectedConditions.elementToBeClickable(editBookBtnN)).click();
            System.out.println("Clicking on 'Edit book' button line " + number);
        } else {
            System.out.println("Number cannot be 0");
        }
    }

    public void enterBookName(String bookName) {
        BrowserUtils.enterText(bookNameInputBox, bookName);
    }

    public void enterIsbn(String isbn) {
        BrowserUtils.enterText(isbnInputBox, isbn);
    }

    public void enterYear(String year) {
        BrowserUtils.enterText(yearInputBox, year);
    }

    public void enterAuthor(String author) {
        BrowserUtils.enterText(authorInputBox, author);
    }

    public void selectBookCategory(String bookCategory) {
        BrowserUtils.selectValue(bookCategoryDropDown, bookCategory);
    }

    public void enterDescription(String description) {
        BrowserUtils.enterText(descriptionInputBox, description);
    }

    public void selectShowRecords(String showRecords) {
        BrowserUtils.selectValue(showRecordsDropDown, showRecords);
    }

    public void verificationQuantity(String string) {
        int inum = Integer.parseInt(string);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tbody/tr"), inum));
        String actual = "" + links.size();
        Assert.assertEquals(string, actual);
    }
   /*
    public void verificationQuantity(String string ){
        String actual = confirmationNumberMessage.getText();
        System.out.println(actual);
        String str = actual.substring(actual.indexOf("to ")+3,actual.indexOf(" of"));
        System.out.println(str);
        Assert.assertEquals(string, str);
    }

    */

    public void bookCategories(String categori) {

        BrowserUtils.wait(1);
        Select select = new Select(bookCategoriesDropDown);
        select.selectByVisibleText(categori);
    }
}