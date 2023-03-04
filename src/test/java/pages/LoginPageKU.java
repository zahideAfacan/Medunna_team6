package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPageKU {

    public LoginPageKU() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement signInButton;

    @FindBy(linkText= "MY PAGES(PATIENT)")
    public WebElement userMenu;

    @FindBy(name = "rememberMe")
    public WebElement rememberMe;

    @FindBy(linkText = "Sign out")
    public WebElement signOut;

    @FindBy(linkText = "SIGN IN AGAIN")
    public WebElement signInAgain;

    @FindBy(xpath = "//span[text()='Register a new account']")
    public WebElement registerOption;

    @FindBy(id = "entity-menu")
    public WebElement myPages;

    @FindBy(linkText = "My Appointments")
    public WebElement myAppointments;

    @FindBy(linkText = "In Patient")
    public WebElement inpatient;


}