package com.executors;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "utilCucumber",
        tags = "@common",
        snippets = SnippetType.CAMELCASE
)

public class RunnerTest {
}
