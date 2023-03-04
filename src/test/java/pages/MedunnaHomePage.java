package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MedunnaHomePage {

    public MedunnaHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id = "account-menu")
    public WebElement userIcon;

    @FindBy(xpath = "//a[@href='/account/register']")
    public WebElement registerOption;

    @FindBy(id = "login-item")
    public WebElement signIn;


}
