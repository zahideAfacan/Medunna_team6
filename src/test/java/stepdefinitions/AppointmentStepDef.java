package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AppointmentPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class AppointmentStepDef {
    AppointmentPage appointmentPage=new AppointmentPage();
    @Given("user patient is on medunna page")
    public void user_patient_is_on() {
Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));

    }
    @Then("user patient clicks on the make appointment button")
    public void user_patient_clicks_on_the_make_appointment_button() {
appointmentPage.appointment.click();
ReusableMethods.waitFor(1);
    }
    @Then("user patient enters the firstname {string}")
    public void user_patient_enters_the_firstname(String string) {
appointmentPage.firstName.sendKeys(string);
        ReusableMethods.waitFor(1);
    }
    @Then("user patient enters the lastname {string}")
    public void user_patient_enters_the_lastname(String string) {
        appointmentPage.lastName.sendKeys(string);
        ReusableMethods.waitFor(1);
    }
    @Then("user patient enters the ssn {string}")
    public void user_patient_enters_the_ssn(String string) {
appointmentPage.ssn.sendKeys(string);
        ReusableMethods.waitFor(1);

    }
    @Then("user patient enters the email {string}")
    public void user_patient_enters_the_email(String string) {
   appointmentPage.email.sendKeys(string);
        ReusableMethods.waitFor(1);

    }
    @Then("user patient enters the phone {string}")
    public void user_patient_enters_the_phone(String string) {
    appointmentPage.phone.sendKeys(string);
        ReusableMethods.waitFor(1);

    }

    @Then("user selects a date")
    public void user_selects_a_date() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 3);
       Date futureDateTime = calendar.getTime();
        String formattedDate = sdf.format(futureDateTime);
        System.out.println(formattedDate);
        appointmentPage.appoDate.sendKeys(formattedDate);
        ReusableMethods.waitFor(1);
    }
    @Then("user patient click send appointment button")
    public void user_patient_click_send_appointment_button() {

appointmentPage.sendAppoRequest.click();
ReusableMethods.waitFor(3);
    }
    @Then("user patient verifies  alert")
    public void user_patient_verifies_alert() {

String actualText=appointmentPage.popUpMessage.getText();
 Assert.assertTrue(actualText.contains("Appointment registration saved!"));
 ReusableMethods.waitFor(3);
    }


    @Then("user patient enters the firstname blank {string}")
    public void user_patient_enters_the_firstname_blank(String string) {
   appointmentPage.firstName.sendKeys(string+Keys.TAB);
        ReusableMethods.waitFor(1);
    }
    @Then("user patient verifies firstname {string} warning")
    public void user_patient_verifies_firstname_warning(String string) {
   Assert.assertEquals(string,appointmentPage.yourFirstName.getText());
        ReusableMethods.waitFor(1);
    }
    @Then("user patient enters the lastname blank {string}")
    public void user_patient_enters_the_lastname_blank(String string) {
   appointmentPage.lastName.sendKeys(string+Keys.TAB);
        ReusableMethods.waitFor(1);
    }
    @Then("user patient verifies lastname {string} warning")
    public void user_patient_verifies_lastname_warning(String string) {

Assert.assertEquals(string,appointmentPage.yourLastName.getText());
        ReusableMethods.waitFor(1);
    }
    @Then("user patient enters ssn blank {string}")
    public void user_patient_enters_ssn_blank(String string) {
appointmentPage.ssn.sendKeys(string+Keys.TAB);
        ReusableMethods.waitFor(1);

    }
    @Then("user patient verifies ssn {string} warning")
    public void user_patient_verifies_ssn_warning(String string) {
        Assert.assertEquals(string,appointmentPage.yourSSN.getText());
        ReusableMethods.waitFor(1);
    }
    @Then("user patient enters email blank {string}")
    public void user_patient_enters_email_blank(String string) {
      appointmentPage.email.sendKeys(string+Keys.TAB);

        ReusableMethods.waitFor(1);

    }
    @Then("user patient verifies email {string} warning")
    public void user_patient_verifies_email_warning(String string) {
Assert.assertEquals(string,appointmentPage.yourEmail.getText());
        ReusableMethods.waitFor(1);
    }
    @Then("user patient enters phone blank {string}")
    public void user_patient_enters_phone_blank(String string) {
appointmentPage.phone.sendKeys(string+Keys.TAB);

        ReusableMethods.waitFor(1);
    }
    @Then("user patient verifies phone {string} warning")
    public void user_patient_verifies_phone_warning(String string) {

    Assert.assertEquals(string,appointmentPage.yourPhone.getText());
        ReusableMethods.waitFor(1);
    }
////WRONG SSN\\\\

    @Then("user patient enters the firstname")
    public void user_patient_enters_the_firstname() {
appointmentPage.firstName.sendKeys("Abc");
        ReusableMethods.waitFor(1);
    }
    @Then("user patient enters the lastname")
    public void user_patient_enters_the_lastname() {
        appointmentPage.lastName.sendKeys("Cde");
        ReusableMethods.waitFor(1);
    }


    @Then("user patient enters wrong  ssn and verifies")
    public void user_patient_enters_wrong_ssn(DataTable ssn) {
    List<String>  ssnList=ssn.asList() ;
        System.out.println(ssnList);
for(String w:ssnList) {
    appointmentPage.ssn.sendKeys(w+Keys.TAB);
    ReusableMethods.waitFor(1);
    String warning="Your SSN is invalid";
    Assert.assertEquals(warning,appointmentPage.yourSSN.getText());
    ReusableMethods.waitFor(1);
appointmentPage.ssn.clear();

}
    }




    @Then("user patient  close the application")
    public void user_patient_close_the_application() {

Driver.getDriver().close();
    }



}
