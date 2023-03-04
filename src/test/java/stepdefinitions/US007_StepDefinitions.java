package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.AppointmentPageMD;
import pages.MD_AdminPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class US007_StepDefinitions {
    String userURL;
    MD_AdminPage md_adminPage = new MD_AdminPage();
    AppointmentPageMD appointmentPageMD =new AppointmentPageMD();

    @Then("user admin clicks administration and usermanagement")
    public void user_admin_clicks_administration_and_usermanagement() {

        md_adminPage.adminMenu.click();
        ReusableMethods.waitFor(1);
        md_adminPage.userManagement.click();
        ReusableMethods.waitFor(1);
    }

    @Then("user admin clicks edit button")
    public void user_admin_clicks_edit_button() throws InterruptedException {

        md_adminPage.createdDate.click();
        ReusableMethods.waitFor(1);
        WebElement edit = null;
        while (edit == null) {

            try {
                ReusableMethods.waitFor(2);
                edit = Driver.getDriver().findElement(By.xpath("//*[@id='user_mdrky1']//*[contains(text(),'Edit')]"));

            } catch (NoSuchElementException e) {
                ReusableMethods.waitFor(2);
                Actions actions = new Actions(Driver.getDriver());
                actions.moveToElement(md_adminPage.next).click().perform();
                ReusableMethods.waitFor(1);
            }
        }


        edit.click();

    }
    @Then("user admin sends updated firstname {string} and {string}")
    public void user_admin_sends_updated_firstname_and(String firstName, String lastName) {
     firstName="Tarum";
             lastName="Ayakrud";
        md_adminPage.firstName.sendKeys(Keys.CONTROL, "a"+Keys.BACK_SPACE);
        md_adminPage.firstName.sendKeys(firstName);
        ReusableMethods.waitFor(1);
        md_adminPage.lastName.sendKeys(Keys.CONTROL, "a"+Keys.DELETE);
        md_adminPage.lastName.sendKeys(lastName);
    }
    @Then("user admin selects language")
    public void user_admin_selects_language() {
        md_adminPage.language.sendKeys("");
        ReusableMethods.waitFor(1);
        Select language=new Select(md_adminPage.language);
        language.selectByValue("tr");
    }
    @Then("user admin selects roles")
    public void user_admin_selects_roles() {
        Select roles=new Select(md_adminPage.roles);
        roles.selectByValue("ROLE_USER");
        roles.selectByValue("ROLE_PATIENT");
        roles.selectByValue("ROLE_STAFF");
        ReusableMethods.waitFor(2);

    }
    @Then("user admin clicks save button")
    public void user_admin_clicks_save_button() {
        try {
            md_adminPage.submit.click();
        } catch (Exception e) {
            Actions actions = new Actions(Driver.getDriver());
            actions.moveToElement(md_adminPage.submit).click().perform();
            md_adminPage.submit.click();
            ReusableMethods.waitFor(5);
        }
    }
    @Then("user admin verifies popup message {string}")
    public void user_admin_verifies_popup_message(String string) {
ReusableMethods.waitForVisibility(md_adminPage.successMessage,5);

            String  actualText=md_adminPage.successMessage.getText();
            ReusableMethods.waitFor(2);
        System.out.println(actualText);
            System.out.println(actualText+"   actualText");
          Assert.assertTrue(actualText.contains("A user is updated with identifier"));
        }
    }










