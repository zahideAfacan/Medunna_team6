package pages;

import io.cucumber.java.zh_cn.假定;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DoctorPageMD {
    public DoctorPageMD(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
@FindBy (xpath = "//*[@id='app-view-container']//th")
    public List<WebElement> patientInfoTitles;

@FindBy(xpath = "//*[contains(text(),'Edit')][1]")
    public WebElement patientEdit;
@FindBy (id = "in-patient-id")
    public WebElement inPatientId;
@FindBy (id="in-patient-startDate")
    public WebElement startDate;
@FindBy (id = "in-patient-endDate")
    public WebElement endDate;
@FindBy(id = "in-patient-appointment")
    public WebElement inPatientAppointment;

@FindBy (id = "in-patient-status")
    public WebElement inPatientStatus;
@FindBy (id="in-patient-room")
    public WebElement inPatientRoom;
@FindBy (id = "in-patient-patient")
    public WebElement inPatient;
@FindBy(id = "save-entity")
    public WebElement save;
@FindBy (xpath = "//*[@id='entity-menu']")
    public WebElement myPages;
@FindBy (xpath = "//span[contains(text(),'My Inpatients')]")
    public WebElement myInpatients;
@FindBy (id = "account-menu")
    public WebElement accountMenu;
@FindBy(linkText = "Sign out")
    public WebElement signOut;

}
