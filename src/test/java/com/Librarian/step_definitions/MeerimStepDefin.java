package com.Librarian.step_definitions;

import com.Librarian.pages.MeerimPAge;
import com.Librarian.utils.BrowserUtils;
import com.Librarian.utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MeerimStepDefin {
    MeerimPAge meerimPage=new MeerimPAge();

    @When("user click on Book Categories dropdown menu,select {string}")
    public void user_click_on_book_categories_dropdown_menu_select(String categories) {
        meerimPage.bookCategories(categories);
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



}
