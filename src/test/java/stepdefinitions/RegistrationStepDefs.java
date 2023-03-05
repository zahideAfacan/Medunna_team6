package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.RegistrationPage;
import utilities.ConfigReader;
import utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class RegistrationStepDefs {
    RegistrationPage us01UiRegistrationPage=new RegistrationPage();
    @Given("go to {string}")
    public void go_to(String url) {

        Driver.getDriver().get(url);
    }
    @Given("user click the registration icon")
    public void user_click_the_registration_icon() {
        us01UiRegistrationPage.registerIcon.click();
    }
    @Given("user click registration button")
    public void user_click_registration_button() {
        us01UiRegistrationPage.registerButton.click();
    }













}
