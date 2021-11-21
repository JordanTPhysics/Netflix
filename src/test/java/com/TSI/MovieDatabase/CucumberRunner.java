package com.TSI.MovieDatabase;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:target/cucumber"},
        features = "src/test/resources",
        glue = "com.TSI.MovieDatabase.StepDefs")
@CucumberContextConfiguration
public class CucumberRunner {
}
