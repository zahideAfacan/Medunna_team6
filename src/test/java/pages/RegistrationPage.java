package pages;


import utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    public RegistrationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//*[@id='account-menu']/a")
    public WebElement registerIcon;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
    public WebElement registerButton;

    @FindBy(id = "ssn")
    public WebElement ssnBox;

    @FindBy(xpath = "//*[@id=\"register-form\"]/div[1]/div")
    public WebElement ssnIsInvalidMessage;

    @FindBy(xpath = "//*[@id=\"register-form\"]/div[1]/div")
    public WebElement ssnIsRequiredMessage;

    @FindBy(id = "firstName")
    public WebElement firstNameBox;

    @FindBy(xpath = "//*[@id=\"register-form\"]/div[2]/div")
    public WebElement firstNameIsRequiredMessage;

    @FindBy(id = "lastName")
    public WebElement lastNameBox;

    @FindBy(xpath = "//*[@id=\"register-form\"]/div[3]/div")
    public WebElement lastNameIsRequiredMessage;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[4]")
    public WebElement feedbackUsername;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[5]")
    public WebElement feedbackEmail;

    @FindBy(id = "email")
    public WebElement email;

}
