package stepdefinitions.ui_stepdef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.LoginPageKU;
import pages.MedunnaHomePage;
import pages.PatientTestPageKU;
import utilities.Driver;
import utilities.ReusableMethods;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertTrue;
import static utilities.ReusableMethods.waitFor;

public class US_11_12_13_Stepdefs {

    MedunnaHomePage medunnaHomePage = new MedunnaHomePage();
    LoginPageKU loginPageKU=new LoginPageKU();

    PatientTestPageKU patientTestPageKU = new PatientTestPageKU();

    Actions actions=new Actions(Driver.getDriver());

    @When("click on MY PAGE icon and My Appointments button")
    public void clickOnMYPAGEIconAndMyAppointmentsButton() throws IOException {

        loginPageKU.myPages.click();
        loginPageKU.myAppointments.click();


//        List<String> patientTable = Collections.singletonList(loginPageKU.table.getText());
 //       System.out.println("patientTable = " + patientTable);

// Locate the table element
        WebElement table = loginPageKU.table;

        // Locate all the rows in the table
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        // Loop through each row and extract the data from the cells
        for (WebElement row : rows) {
            // Locate all the cells in the row
            List<WebElement> cells = row.findElements(By.tagName("td"));

            // Loop through each cell and print the data
            for (WebElement cell : cells) {
                System.out.print(cell.getText() + "\t");

            }
        }

        ReusableMethods.getScreenshot("Appointments");

    }

    @When("click on Show Appointments button and Click on Edit button")
    public void clickOnShowAppointmentsButtonAndClickOnEditButton() {


    }

    @Then("steff change status of appointment")
    public void steffChangeStatusOfAppointment() {

    }

    @Then("staff click save button")
    public void staffClickSaveButton() {

        patientTestPageKU.saveButton.click();
    }

    @When("click on Request A Test button")
    public void clickOnRequestATestButton() {

        patientTestPageKU.requestATest.click();
        waitFor(2);


    }
    @Then("verify that have Glucose, Urea, Creatinine, Sodium as checkmark options")
    public void verifyThatHaveGlucoseUreaCreatinineSodiumAsCheckmarkOptions() {
        assertTrue(Driver.getDriver().getPageSource().contains("Urea"));
        assertTrue(Driver.getDriver().getPageSource().contains("Glucose"));
        assertTrue(Driver.getDriver().getPageSource().contains("Potassium"));

    }

    @When("click on urea checkbox and save button")
    public void clickOnUreaCheckboxAndSaveButton() {
        patientTestPageKU.ureaCheckbox.click();
        waitFor(2);
        actions.sendKeys(Keys.END).perform();
        waitFor(2);
        patientTestPageKU.saveButton.click();
        waitFor(2);
    }
}
