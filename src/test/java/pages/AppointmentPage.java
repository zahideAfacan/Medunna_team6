package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AppointmentPage {
    public AppointmentPage () {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//span[@class='d-none d-md-inline']")
    public WebElement appointment;
    @FindBy(name = "firstName")
    public WebElement firstName;
    @FindBy(name = "lastName")
    public WebElement lastName;
    @FindBy(name = "ssn")
    public WebElement ssn;

@FindBy(name = "appoDate")
    public WebElement appoDate;
@FindBy(name = "email")
    public WebElement email;
@FindBy(name = "phone")
    public WebElement phone;

@FindBy(id = "register-submit")
    public WebElement sendAppoRequest;

@FindBy (xpath = "//div[@class='Toastify']")
    public WebElement popUpMessage;
    @FindBy (xpath = "//div[@class='invalid-feedback']")
    public WebElement invalidFirstName;

    @FindBy (xpath = "//h2[.='Make an Appointment']")
    public WebElement scrollIntoView;

    @FindBy (xpath = "//div[@class='invalid-feedback']")
    public WebElement invalidSSN;

}



