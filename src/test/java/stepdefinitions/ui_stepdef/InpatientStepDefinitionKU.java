package stepdefinitions.ui_stepdef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.InpatientPageKU;
import pages.LoginPageKU;
import pages.PatientTestPageKU;
import utilities.Driver;
import static org.junit.Assert.assertTrue;
import static utilities.ReusableMethods.waitFor;

public class InpatientStepDefinitionKU {


    InpatientPageKU inpatientPageKU=new InpatientPageKU();
    PatientTestPageKU patientTestPageKU=new PatientTestPageKU();
    LoginPageKU loginPageKU=new LoginPageKU();
    String appointmentID;

    @When("click on Request Inpatient and get appointment id")
    public void click_on_request_inpatient_and_get_appointment_id() {
        inpatientPageKU.requestInpatient.click();
        appointmentID= inpatientPageKU.inpatientID.getAttribute("value");

    }
    @When("Click on MY PAGE icon and click on Inpatient button")
    public void click_on_my_page_icon_and_click_on_inpatient_button() {
        loginPageKU.myPages.click();
        waitFor(1);
        loginPageKU.inpatient.click();
        waitFor(3);
    }
    @Then("verify to appointment id")
    public void verify_to_appointment_id() {
        System.out.println("appointmentID = " + appointmentID);
        assertTrue(Driver.getDriver().getPageSource().contains(appointmentID));


    }

}