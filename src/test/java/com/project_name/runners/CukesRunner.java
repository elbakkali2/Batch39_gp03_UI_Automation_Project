package com.project_name.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt",
        },
        features = "src/test/resources/features",
        glue = "com/project_name/step_definitions",
  
        dryRun = false,
  
        tags = "", // Optional
  
        publish = true //generating a report with a public link
  
        
)
public class CukesRunner {
}


