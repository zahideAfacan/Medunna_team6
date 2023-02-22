package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(


        features = "./src/test/resources/features/ui_test",
        glue="stepdefinitions",
        dryRun = false,
        tags = "@GoogleFeature"
)

public class Runner {

}
