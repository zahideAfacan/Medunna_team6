package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.Driver;

public class RegistrationStepDefs {
    @Given("go to {string}")
    public void go_to(String url) {
        Driver.getDriver().get(url);
    }
    @Then("close the application")
    public void close_the_application() throws InterruptedException {
        Driver.closeDriver();

    }
}
