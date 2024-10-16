package com.oop.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "pretty",
                "json:target/cucumber.json" ,
                "html:target/default-html-reports.html",
                "rerun:target/rerun.txt"
        },

        features = "src/test/resources/features",
        glue = "com/oop/step_definitions",
        dryRun = false,
        tags = "@wip",
        monochrome = true
)

public class CukesRunner {
}
