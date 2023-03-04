package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PatientTestPageKU {

    public PatientTestPageKU(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Edit")
    public WebElement edit;

    @FindBy(xpath = "//*[@class='btn btn-success btn-sm']")
    public WebElement requestATest;
    @FindBy(id = "1755")
    public WebElement ureaCheckbox;

    @FindBy(id = "save-entity")
    public WebElement saveButton;


    @FindBy(linkText = "Search Patient")
    public WebElement searchPatients;

    @FindBy(name = "ssn")
    public WebElement patientSSN;

    @FindBy(linkText = "Show Appointments")
    public WebElement showAppointments;

    @FindBy(linkText = "Show Tests")
    public WebElement showTests;

    @FindBy(xpath = "(//*[@class='d-none d-md-inline'])[1]")
    public WebElement viewResult;

    @FindBy(id = "c-test-result-result")
    public WebElement resultInput;

    @FindBy(id = "c-test-result-description")
    public WebElement descriptionInput;

    @FindBy(linkText = "Show Test Results")
    public WebElement showTestResults;


}
