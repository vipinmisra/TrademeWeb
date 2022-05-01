package nz.co.trademe.lib;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = {"nz.co.trademe.steps", "nz.co.trademe.lib"}, monochrome = true)
public class TestRunner {
}
