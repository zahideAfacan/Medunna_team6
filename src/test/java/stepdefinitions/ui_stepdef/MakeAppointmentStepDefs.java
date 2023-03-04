package stepdefinitions.ui_stepdef;


import com.github.javafaker.Faker;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.LoginPageKU;
import pages.PatientTestPageKU;
import utilities.Driver;
import static org.junit.Assert.assertTrue;
import static utilities.ReusableMethods.waitFor;

public class MakeAppointmentStepDefs {

        LoginPageKU loginPageKU=new LoginPageKU();

        PatientTestPageKU patientTestPageKU=new PatientTestPageKU();

        Actions actions=new Actions(Driver.getDriver());
        Faker faker=new Faker();

        String  testresult;
        String testdescription;

        @When("click on MY PAGE icon and My Appointments button and edit button")
        public void click_on_my_page_icon_and_my_appointments_button_and_edit_button() {
            loginPageKU.myPages.click();
            loginPageKU.myAppointments.click();
            patientTestPageKU.edit.click();
            waitFor(2);

        }

        @When("click on Request A Test button and urea checkbox and save button")
        public void click_on_request_a_test_button_and_urea_checkbox_and_save_button() {

            patientTestPageKU.requestATest.click();
            waitFor(2);
            patientTestPageKU.ureaCheckbox.click();
            waitFor(2);
            actions.sendKeys(Keys.END).perform();
            waitFor(2);
            patientTestPageKU.saveButton.click();
            waitFor(2);
        }

        @When("Click on MY PAGE icon and click on Search Patients and Enter the Patient SSN")
        public void click_on_my_page_icon_and_click_on_search_patients_and_enter_the_patient_ssn() {
            loginPageKU.myPages.click();
            waitFor(2);
            patientTestPageKU.searchPatients.click();
            waitFor(2);
            patientTestPageKU.patientSSN.sendKeys("123-45-9876");
            waitFor(2);
        }
        @When("click on Show Appointments button and Click on Show Tests button and click on View Results button")
        public void click_on_show_appointments_button_and_click_on_show_tests_button_and_click_on_view_results_button() {
            patientTestPageKU.showAppointments.click();
            waitFor(2);
            patientTestPageKU.showTests.click();
            waitFor(2);
            patientTestPageKU.viewResult.click();
            waitFor(2);



        }
        @When("Click on Edit button and enter a Result and click on Save")
        public void click_on_edit_button_and_enter_a_result_and_click_on_save() {
            patientTestPageKU.edit.click();
            waitFor(2);
            patientTestPageKU.resultInput.clear();

            testresult= String.valueOf(faker.number().numberBetween(10,20));
            testdescription= faker.name().firstName();

            patientTestPageKU.resultInput.sendKeys(testresult);
            waitFor(2);
            patientTestPageKU.descriptionInput.clear();
            patientTestPageKU.descriptionInput.sendKeys(testdescription);
            waitFor(2);
            actions.sendKeys(Keys.END).perform();
            waitFor(2);
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            waitFor(2);
            patientTestPageKU.saveButton.click();
        }

        @When("click on Show Test Results button  and click on View Results button")
        public void click_on_show_test_results_button_and_click_on_view_results_button() {
            patientTestPageKU.showTestResults.click();
            waitFor(2);
            patientTestPageKU.viewResult.click();
            waitFor(2);
        }
        @When("Verify to doctor can see all test information")
        public void verify_to_doctor_can_see_all_test_information() {

            assertTrue(Driver.getDriver().getPageSource().contains("Urea"));
            assertTrue(Driver.getDriver().getPageSource().contains(testresult));
            assertTrue(Driver.getDriver().getPageSource().contains("10 mg/dL"));
            assertTrue(Driver.getDriver().getPageSource().contains("20 mg/dL"));
            assertTrue(Driver.getDriver().getPageSource().contains(testdescription));

        }

    }










