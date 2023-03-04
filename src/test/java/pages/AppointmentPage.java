
package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

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

    @FindBy (xpath = "//*[contains(text(),'Your FirstName')]")
    public WebElement yourFirstName;
    @FindBy (xpath = "//*[contains(text(),'Your LastName')]")
    public WebElement yourLastName;
    @FindBy (xpath = "//*[contains(text(),'Your SSN')]")
    public WebElement yourSSN;
    @FindBy (xpath = "//*[contains(text(),'Your email')]")
    public WebElement yourEmail;
    @FindBy (xpath ="//*[contains(text(),'Phone number ')]" )
    public WebElement yourPhone;

    ////////////////////////Admin
    @FindBy (id = "account-menu")
    public WebElement accountMenu;
    @FindBy (id = "login-item")
    public WebElement signIn;

    @FindBy(id = "username")
    public WebElement userName;
    @FindBy (id = "password")
    public WebElement password;
    @FindBy (xpath = "//button[@type='submit']")
    public WebElement submit;

    @FindBy (id = "entity-menu")
    public WebElement itemTitles;
    @FindBy (xpath = "(//a[@class='dropdown-item'])[1]")
    public WebElement patient;
    @FindBy (xpath = "//table[@class='table']//thead//tr//th")
    public List<WebElement> tableHeader;
    @FindBy (xpath ="//*[@id='app-view-container']//table/tbody/tr" )
    public List<WebElement>  allRowElements ;
    @FindBy (xpath = "//li[@class='page-item']|//li[@class='page-item disabled']")
    public List<WebElement>  pageItems;


    @FindBy(xpath ="(//*[@id='app-view-container'])//*[.='Next']" )
    public WebElement next;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitAdmin;


}