package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class InpatientPageKU {


    public InpatientPageKU(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@class='btn btn-warning btn-sm']")
    public WebElement requestInpatient;


    @FindBy(id = "appointment-id")
    public WebElement inpatientID;

}



