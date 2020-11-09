package com.Librarian.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "rerun:target/rerun.txt",
                "json:target/cucumber.json"        //needed for cucumber report
        },
        features = "src/test/resources/features",
        glue = "com/Librarian/step_definitions",
        dryRun = false,
        tags = "@smoke",
        publish = true
)
public class CucumberRunner {
}
