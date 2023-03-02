package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.E;
import io.cucumber.java.it.Ma;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.AppointmentPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.*;

public class AppointmentVerificationStepDefs {

    ////////////////VERIFICATION\\\\\\\\\\\\\\\\
    AppointmentPage appointmentPage = new AppointmentPage();

    @Given("user admin clicks account menu button")
    public void user_admin_clicks_account_menu_button() {
        appointmentPage.accountMenu.click();
    }
    @When("user admin clicks sign in button")
    public void user_admin_clicks_sign_in_button() {
        appointmentPage.signIn.click();
    }
    @Then("user admin enters credentials")
    public void user_admin_enters_credentials(DataTable adminCredentials) {
        List<Map<String, String>> adminUserPass = adminCredentials.asMaps(String.class, String.class);

        for (Map<String, String> each : adminUserPass) {
            appointmentPage.userName.sendKeys(each.get("username"));
            ReusableMethods.waitFor(2);
            appointmentPage.password.sendKeys(each.get("password"));
            ReusableMethods.waitFor(2);
        }
        appointmentPage.submitAdmin.click();
    }
    @Then("user admin clicks itemTitles")
    public void user_admin_clicks_item_titles() {
        ReusableMethods.waitFor(1);
        appointmentPage.itemTitles.click();

    }
    @Then("user admin clicks patient")
    public void user_admin_clicks_patient() {
        ReusableMethods.waitFor(2);
        appointmentPage.patient.click();

    }
    @Then("user admin checks appointment of patient and verify the credentials")
    public void user_admin_checks_appointment_of_patient (DataTable patientInfo) {
        String firstname = null, lastname = null, ssn = null, email = null, phone = null;
        ReusableMethods.waitFor(3);
        List<Map<String, String>> patientDetails = patientInfo.asMaps(String.class, String.class);
        System.out.println("Patient Details"+patientDetails);
        for (Map<String, String> each : patientDetails) {
            firstname = each.get("firstname");
            lastname = each.get("lastname");
            ssn = each.get("ssn");
            email = each.get("email");
            phone = each.get("phone");

        }
        //Table Headers
        List<String> allHeaderNames = new ArrayList<String>();
        for (int i = 0; i < appointmentPage.tableHeader.size() - 1; i++) {
            String headerName = appointmentPage.tableHeader.get(i).getText();
            allHeaderNames.add(headerName);

        }
//ALL TABLE DATA
        List<LinkedHashMap<String, String>> allTableData = new ArrayList<LinkedHashMap<String, String>>();
        int rowCount = appointmentPage.allRowElements.size();
        int pageItemSize = appointmentPage.pageItems.size();
        for (int i = 1; i <= pageItemSize; i++) {
            ReusableMethods.waitFor(3);
            List<WebElement> row = Driver.getDriver().findElements(By.xpath("//*[@id='app-view-container']//table/tbody/tr"));
            for (int j = 1; j <= row.size(); j++) {
                List<WebElement> allColumnsElements = Driver.getDriver().findElements(By.xpath("//*[@id='app-view-container']//table/tbody/tr[" + j + "]//td"));
                LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();

                for (int k = 0; k < allHeaderNames.size(); k++) {

                    String cellValue = allColumnsElements.get(k).getText();
                    eachRowData.put(allHeaderNames.get(k), cellValue);
                }

                allTableData.add(eachRowData);

            }
            Actions actions = new Actions(Driver.getDriver());
            actions.moveToElement(appointmentPage.next).click().perform();
            ReusableMethods.waitFor(1);


        }
        System.out.println("All data Table ---->  " + allTableData);
        System.out.println(allTableData.size());
LinkedHashMap<String,String> userInfo=new LinkedHashMap<>();
        for(int i=0 ;i<allTableData.size();i++){
            if(allTableData.get(i).get("SSN").equals(ssn)){
                userInfo.put("First Name",allTableData.get(i).get("First Name"));
                userInfo.put("Last Name",allTableData.get(i).get("Last Name"));
                userInfo.put("Email",allTableData.get(i).get("Email"));
                userInfo.put("Phone",allTableData.get(i).get("Phone"));
                userInfo.put("SSN",allTableData.get(i).get("SSN"));
            }

        }
        System.out.println(userInfo);
Assert.assertEquals(patientDetails.get(0).get("firstname"),userInfo.get("First Name"));
Assert.assertEquals(patientDetails.get(0).get("lastname"),userInfo.get("Last Name"));
Assert.assertEquals(patientDetails.get(0).get("ssn"),userInfo.get("SSN"));
Assert.assertEquals(patientDetails.get(0).get("email"),userInfo.get("Email"));
Assert.assertEquals(patientDetails.get(0).get("phone"),userInfo.get("Phone"));

}

        }





