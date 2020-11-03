package com.Librarian.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/Librarian/step_definitions",
        dryRun = false,
        tags = "@edit_book", //"@search_book","@book_Categories"
        publish = true
)
public class CucumberRunner {
}
