package stepdefinitions.ui_stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import pages.LoginPageKU;
import pages.MedunnaHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import static org.junit.Assert.assertTrue;
import static utilities.ReusableMethods.waitFor;

public class LoginStepDefinitionKU {

    MedunnaHomePage medunnaHomePage = new MedunnaHomePage();
    LoginPageKU loginPageKU=new LoginPageKU();

    Actions actions=new Actions(Driver.getDriver());

    @Given("go to medunna home page")
    public void go_to_medunna_home_page() {
        Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));

    }
    @When("click on sign in icon")
    public void click_on_sign_in_icon() {

       medunnaHomePage.userIcon.click();
        waitFor(1);
        medunnaHomePage.signIn.click();

    }
    @When("enter patient username")
    public void enter_patient_username() {
        loginPageKU.username.sendKeys("hasta");
        waitFor(1);

    }
    @When("enter patient password")
    public void enter_patient_password() {

        loginPageKU.password.sendKeys("Hastaiyi123");
        waitFor(1);

    }

    @When("enter doctor username")
    public void enter_doctor_username() {
        loginPageKU.username.sendKeys("doktorm");
        waitFor(1);
    }
    @When("enter doctor password")
    public void enter_doctor_password() {
        loginPageKU.password.sendKeys("DoktorM234");
        waitFor(1);

    }

    @When("enter staff username")
    public void enter_staff_username() {
        loginPageKU.username.sendKeys("stafkisi");
        waitFor(1);

    }
    @When("enter staff password")
    public void enter_staff_password() {
        loginPageKU.password.sendKeys("Stafkisi123");
        waitFor(1);

    }

    @Then("click sign in button")
    public void click_sign_in_button() {
        loginPageKU.signInButton.click();

    }

    @When("verify the application login is successful")
    public void verify_the_application_login_is_successful() {
        assertTrue(loginPageKU.userMenu.isDisplayed());

    }

    @When("verify rememberme and click")
    public void verify_rememberme_and_click() {
        assertTrue(loginPageKU.rememberMe.isDisplayed());
        loginPageKU.rememberMe.click();
        waitFor(1);
    }
    @When("click sign out button")
    public void click_sign_out_button() {
        medunnaHomePage.userIcon.click();
        waitFor(1);
        loginPageKU.signOut.click();
        waitFor(1);
    }

    @When("verify that the remember me function is working")
    public void verify_that_the_function_is_working() {
        loginPageKU.signInAgain.click();
        waitFor(1);
        //   loginPageKU.signInButton.click();
        waitFor(1);
        //   assertTrue(loginPageKU.userMenu.isDisplayed());

    }

    @When("verify cancel button")
    public void verify_cancel_button() {

        assertTrue(Driver.getDriver().getPageSource().contains("Cancel"));
    }
    @When("verify register option")
    public void verify_register_option() {
        assertTrue(Driver.getDriver().getPageSource().contains("Register a new account"));
        loginPageKU.registerOption.click();
        loginPageKU.registerOption.click();
        assertTrue(Driver.getDriver().getPageSource().contains("Registration"));
        waitFor(1);
    }




}