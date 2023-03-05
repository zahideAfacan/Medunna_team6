package stepdefinitions.ui_stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.eo.Se;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.DoctorPageMD;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class US015_StepDefs {
DoctorPageMD doctorPageMD=new DoctorPageMD();

    @Then("click on MY PAGE icon and My Inpatients button")
    public void click_on_my_page_icon_and_my_inpatients_button() {
ReusableMethods.waitFor(3);
     doctorPageMD.myPages.click();
        ReusableMethods.waitFor(2);
doctorPageMD.myInpatients.click();
    }


    @Then("verify the titles")
    public void verify_the_titles() {
        Assert.assertEquals("ID", doctorPageMD.patientInfoTitles.get(0).getText());
        Assert.assertEquals("Start Date", doctorPageMD.patientInfoTitles.get(1).getText());
        Assert.assertEquals("End Date", doctorPageMD.patientInfoTitles.get(2).getText());
        Assert.assertEquals("Status", doctorPageMD.patientInfoTitles.get(3).getText());
        Assert.assertEquals("Description", doctorPageMD.patientInfoTitles.get(4).getText());
        Assert.assertEquals("Created Date", doctorPageMD.patientInfoTitles.get(5).getText());
        Assert.assertEquals("Room", doctorPageMD.patientInfoTitles.get(6).getText());
        Assert.assertEquals("Appointment", doctorPageMD.patientInfoTitles.get(7).getText());
        Assert.assertEquals("Patient", doctorPageMD.patientInfoTitles.get(8).getText());
    }

    @And("user doctor click sign out button")
    public void user_doctor_click_sign_out_button(){

   doctorPageMD.accountMenu.click();
   ReusableMethods.waitFor(1);
   ReusableMethods.waitForClickablility(doctorPageMD.signOut,5);
   doctorPageMD.signOut.click();
        ReusableMethods.waitFor(1);
    }

    @Given("user doctor clicks on  My Inpatients")
    public void user_doctor_clicks_on_my_inpatients() {
      doctorPageMD.myInpatients.click();
        ReusableMethods.waitFor(1);
    }
    @Then("user doctor clicks on patient edit button")
    public void user_doctor_clicks_on_patient_edit_button() {
       doctorPageMD.patientEdit.click();
        ReusableMethods.waitFor(1);
    }
    @Then("user doctor updates the patient's status")
    public void user_doctor_updates_the_patient_s_status() {
        Select select=new Select(doctorPageMD.inPatientStatus);
        select.selectByVisibleText("STAYING");
        ReusableMethods.waitFor(1);

    }
    @Then("user doctor  updates room status")
    public void user_doctor_updates_room_status() {

Select select1=new Select(doctorPageMD.inPatientRoom);
select1.selectByIndex(6);

    }

    @Then("user doctor click save button")
    public void user_doctor_click_save_button() throws IOException {
        ReusableMethods.waitFor(1);
        doctorPageMD.save.click();
        ReusableMethods.waitFor(3);
        File scrFile = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("C:\\Users\\mdurk\\IdeaProjects\\Medunna_team6\\target\\generated-test-sources\\screenshot.png"));
    }
}
