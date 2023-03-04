package stepdefinitions.ui_stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.MedunnaHomePage;
import pages.RegistrationPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class RegistrationStepDefs {

    MedunnaHomePage medunnaHomePage = new MedunnaHomePage();
    RegistrationPage registrationPage = new RegistrationPage();

    //Set up
    @Given("user navigates to Medunna url")
    public void user_navigates_to_medunna_url() {
        Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));
    }
    @Then("click on user icon")
    public void click_on_user_icon() {
        ReusableMethods.waitFor(1);
        medunnaHomePage.userIcon.click();
    }
    @Then("choose register option from dropdown")
    public void choose_register_option_from_dropdown() {
        ReusableMethods.waitFor(1);
        medunnaHomePage.registerOption.click();
    }

    //Berk: US01
    @Then("user provides valid ssn {string} number")
    public void user_provides_valid_ssn_number(String ssnNumber) {
        registrationPage.ssnBox.sendKeys(ssnNumber+ Keys.TAB);
    }
    @Then("user should not see the error message Your SSN is required or Your SSN is invalid")
    public void user_should_not_see_the_error_message_your_ssn_is_required_or_your_ssn_is_invalid() {
        String ssnBoxAttribute = registrationPage.ssnBox.getAttribute("class");
        Assert.assertFalse(ssnBoxAttribute.contains("invalid"));
//        Assert.assertTrue(ssnBoxAttribute.contains("valid"));
    }
    @Then("user provides invalid ssn {string} number")
    public void user_provides_invalid_ssn_number(String ssnInvalid) {
        registrationPage.ssnBox.sendKeys(ssnInvalid+ Keys.TAB);
//        RegistrationPages.ssnBox.sendKeys(ssnInvalid);
    }
    @Then("user should see the error message Your SSN is invalid")
    public void user_should_see_the_error_message_your_ssn_is_invalid() {
        Assert.assertTrue(registrationPage.ssnIsInvalidMessage.isDisplayed());
    }
    @Then("user leaves ssn box blank")
    public void user_leaves_ssn_box_blank() {
        registrationPage.ssnBox.sendKeys(""+ Keys.TAB);
    }
    @Then("user should see the error message Your SSN is required.")
    public void user_should_see_the_error_message_your_ssn_is_required() {
        Assert.assertTrue(registrationPage.ssnIsRequiredMessage.isDisplayed());
    }

    @Then("user provides valid firstname {string} that contains any chars")
    public void user_provides_valid_firstname_that_contains_any_chars(String firstName) {
        registrationPage.firstNameBox.sendKeys(firstName+ Keys.TAB);
    }

    @Then("user should not see the error message Your FirstName is required.")
    public void user_should_not_see_the_error_message_your_first_name_is_required() {
        String firstNameBoxAttribute = registrationPage.firstNameBox.getAttribute("class");
        Assert.assertTrue(firstNameBoxAttribute.contains("valid"));
    }

    @Then("user leaves firstname box blank")
    public void user_leaves_firstname_box_blank() {
        registrationPage.firstNameBox.sendKeys(""+ Keys.TAB);
    }
    @Then("user should see the error message Your FirstName is required.")
    public void user_should_see_the_error_message_your_first_name_is_required() {
        Assert.assertTrue(registrationPage.firstNameIsRequiredMessage.isDisplayed());
    }

    @Then("user provides valid lastname {string} that contains any chars")
    public void user_provides_valid_lastname_that_contains_any_chars(String lastName) {
        registrationPage.lastNameBox.sendKeys(lastName+ Keys.TAB);
    }
    @Then("user should not see the error message Your LastName is required.")
    public void user_should_not_see_the_error_message_your_last_name_is_required() {
        String lastNameBoxAttribute = registrationPage.lastNameBox.getAttribute("class");
        Assert.assertTrue(lastNameBoxAttribute.contains("valid"));
    }
    @Then("user leaves lastname box blank")
    public void user_leaves_lastname_box_blank() {
        registrationPage.lastNameBox.sendKeys(""+ Keys.TAB);
    }
    @Then("user should see the error message Your LastName is required.")
    public void user_should_see_the_error_message_your_last_name_is_required() {
        Assert.assertTrue(registrationPage.lastNameIsRequiredMessage.isDisplayed());
    }

    //Dilnoza: US02
    @Then("put cursor on username box and click enter")
    public void put_cursor_on_username_box_and_click_enter() {
        ReusableMethods.waitFor(2);
        registrationPage.username.sendKeys(Keys.ENTER);
    }

    @Then("validate that Your username is required note appeared")
    public void validate_that_your_username_is_required_note_appeared() {
        ReusableMethods.waitFor(1);
        String feedback = registrationPage.feedbackUsername.getText();
        System.out.println("feedback = " + feedback);
        Assert.assertEquals("Your username is required.", feedback);
    }

    @Then("write email without @ and click enter")
    public void write_email_without_and_click_enter() {
        registrationPage.email.sendKeys("testgmail.com");
        registrationPage.email.sendKeys(Keys.ENTER);
    }
    @Then("write email with point extension and click enter")
    public void write_email_with_point_extension_and_click_enter() {
        registrationPage.email.sendKeys("test@gmail.com.");
        registrationPage.email.sendKeys(Keys.ENTER);
    }

    @Then("put cursor on email box and click enter")
    public void put_cursor_on_email_box_and_click_enter() {
       registrationPage.email.sendKeys(Keys.ENTER);
    }

    @Then("validate that Your email is required note appeared")
    public void validate_that_your_email_is_required_note_appeared() {
        ReusableMethods.waitFor(1);
        String feedback1 = registrationPage.feedbackEmail.getText();
        System.out.println("feedback = " + feedback1);
        Assert.assertEquals("Your email is required.", feedback1);
    }

    @Then("validate that This field is invalid note appeared")
    public void validateThatThisFieldIsInvalidNoteAppeared() {
        ReusableMethods.waitFor(1);
        String feedback1 = registrationPage.feedbackEmail.getText();
        System.out.println("feedback = " + feedback1);
        Assert.assertEquals("This field is invalid", feedback1);
    }

    @Then("close the application")
   public void close_the_application() throws InterruptedException {
        Driver.closeDriver();
    }

}