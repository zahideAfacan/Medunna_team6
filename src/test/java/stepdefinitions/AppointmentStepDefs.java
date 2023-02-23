package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import pages.AppointmentPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AppointmentStepDefs {
AppointmentPage appointmentPage=new AppointmentPage();
    @Given("user patient is on {string}")
    public void user_patient_is_on(String string) {
     Driver.getDriver().get(string);

    }
    @Then("user patient clicks on the make appointment button")
    public void user_patient_clicks_on_the_make_appointment_button() {
     appointmentPage.appointment.click();
        ReusableMethods.waitFor(3);
    }
    @And("user patient scrolls down the page")
    public void user_patient_scrolls_down_the_page() {
       JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver() ;
       js.executeScript("arguments[0].scrollIntoView(true);", appointmentPage.firstName);
        ReusableMethods.waitFor(3);
    }
    @And("user patient enters the firstname {string}")
    public void user_patient_enters_the_firstname(String string) {
appointmentPage.firstName.sendKeys(string);
        ReusableMethods.waitFor(3);
    }
    @And("user patient enters the lastname {string}")
    public void user_patient_enters_the_lastname(String string) {
        appointmentPage.lastName.sendKeys(string);
        ReusableMethods.waitFor(3);
    }

    @And("user patient enters ssn {string}")
    public void user_patient_enters (String string) {
appointmentPage.ssn.sendKeys(string);
        ReusableMethods.waitFor(3);
    }
    @And("user patient enters email  {string}")
    public void user_patient_enters_email(String string) {

appointmentPage.email.sendKeys(string);
        ReusableMethods.waitFor(3);
    }
    @And("user patient enters phone {string}")
    public void user_patient_enters_phone(String string) {
appointmentPage.phone.sendKeys(string);
        ReusableMethods.waitFor(3);
    }
    @And("user patient enters date")
    public void user_patient_enters_date() {
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/YYYY");
        Date currentDate = new Date();
        Calendar cl = Calendar.getInstance();
        cl.setTime(currentDate);;
        cl.add(Calendar.DAY_OF_YEAR, 2);
        currentDate=cl.getTime();
        String str = dateFormat.format(currentDate);

appointmentPage.appoDate.sendKeys(str);
ReusableMethods.waitFor(3);
    }
    @And("user patient click make appointment button")
    public void user_patient_click_make_appointment_button() {
appointmentPage.sendAppoRequest.click();
        ReusableMethods.waitFor(5);

    }
    @And("user patient verifies {string} alert")
    public void user_patient_verifies_alert(String string) {

 String alertText=appointmentPage.popUpMessage.getText();
        System.out.println(alertText);
        Assert.assertTrue(alertText.contains(string));
    }
    @Then("user patient  close the application")
    public void user_patient_close_the_application() {

Driver.getDriver().close();
    }


}
