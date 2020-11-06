package com.Librarian.pages;

import com.Librarian.utils.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MeerimPage extends BasePage{
    @FindBy(id="book_categories")
    private WebElement bookCategoriesDropDown;

    @FindBy(xpath ="//table[@id='tbl_books']//tr/td[5]")
    private List<WebElement> displayCategories;

    public void bookCategories(String categori){

        BrowserUtils.wait(1);
        Select select=new Select(bookCategoriesDropDown);
        select.selectByVisibleText(categori);
    }















}
